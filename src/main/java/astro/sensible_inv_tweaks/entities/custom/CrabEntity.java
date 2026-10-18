package astro.sensible_inv_tweaks.entities.custom;

import astro.sensible_inv_tweaks.entities.variant.CrabVariant;
import astro.sensible_inv_tweaks.sound.SITSound;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.AbstractNautilusEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import org.jspecify.annotations.Nullable;

public class CrabEntity extends WaterCreatureEntity {
    private static final TrackedData<Integer> VARIANT = DataTracker.registerData(CrabEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public final AnimationState walkAnimationState = new AnimationState();
    private int walkAnimationTimeout = 0;

    public CrabEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
    }

    @Override
    protected void tickWaterBreathingAir(ServerWorld world, int air) {
        if (this.isAlive() && !this.isTouchingWater()) {
            this.setAir(air - 1);
            if (this.shouldDrown()) {
                this.setAir(0);
                this.damage(world, this.getDamageSources().drown(), 1.0F);
            }
        } else {
            this.setAir(300);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getEntityWorld().isClient()) {
            this.setupAnimations();
        }
    }

    @Override
    public boolean canBeLeashed() {
        return true;
    }

    @Override
    public Vec3d getLeashOffset() {
        return new Vec3d(0.0, this.getStandingEyeHeight(), 0.0);
    }

    private void setupAnimations() {
        if (this.isMovingHorizontally() && walkAnimationTimeout <= 0) {
            walkAnimationTimeout = (int) 2.6; // length of your animation in ticks (e.g., 2 seconds = 40 ticks)
            this.walkAnimationState.start(this.age);
        } else {
            --this.walkAnimationTimeout;
        }

        if (!this.isMovingHorizontally()) {
            this.walkAnimationState.stop();
        }
    }



    //Goals and Attributes
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new CrabEntity.GoBackToWaterGoal(this, 1.25));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2.25));
        this.goalSelector.add(2, new FleeEntityGoal<>(this, AbstractNautilusEntity.class, 14.0F, 1.5, 2.0));
        this.goalSelector.add(2, new FleeEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.2, 1.4));
        this.goalSelector.add(3, new WanderAroundGoal(this, 1.0, 60));
    }

    public static DefaultAttributeContainer.Builder createCrabAttributes() {
        return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25F)
                .add(EntityAttributes.WATER_MOVEMENT_EFFICIENCY, 1.0F)
                .add(EntityAttributes.STEP_HEIGHT, 1.1F)
                .add(EntityAttributes.MAX_HEALTH, 5.0F);
    }



    //Sounds
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_TURTLE_EGG_CRACK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_TURTLE_EGG_BREAK;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SITSound.CRAB_STEP, 0.15F, 1.0F  + (this.random.nextFloat() - this.random.nextFloat()) * 0.015F);
    }

    @Override
    protected float calculateNextStepSoundDistance() {
        return this.distanceTraveled + 0.8F;
    }

    @Override
    public float getSoundPitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 2.0F;
    }



    // Pathfinding
    @Override
    protected EntityNavigation createNavigation(World world) {
        return new Navigation(this, world);
    }

    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        if (world.getBlockState(pos).getFluidState().isIn(FluidTags.WATER)) {
            return 10.0F;
        } else {
            return this.isSubmergedInWater() ? Float.NEGATIVE_INFINITY : 0.0F;
        }
    }

    static class Navigation extends MobNavigation {
        Navigation(CrabEntity entity, World world) {
            super(entity, world);
        }

        public boolean isValidPosition(BlockPos pos) {
            return this.world.getBlockState(pos).isOf(Blocks.WATER) || super.isValidPosition(pos);
        }
    }

    static class GoBackToWaterGoal extends MoveToTargetPosGoal {
        private final CrabEntity crab;

        GoBackToWaterGoal(CrabEntity crab, double speed) {
            super(crab, speed, 12, 3);
            this.crab = crab;
        }

        @Override
        public BlockPos getTargetPos() {
            return this.targetPos;
        }

        @Override
        public boolean shouldContinue() {
            return !this.crab.isSubmergedInWater() && this.isTargetPos(this.crab.getEntityWorld(), this.targetPos);
        }

        @Override
        public boolean canStart() {
            return !this.crab.isSubmergedInWater() && super.canStart();
        }

        @Override
        public boolean shouldResetPath() {
            return this.tryingTime % 20 == 0;
        }

        @Override
        protected boolean isTargetPos(WorldView world, BlockPos pos) {
            return world.getBlockState(pos).isOf(Blocks.WATER) && world.getBlockState(pos.up()).canPathfindThrough(NavigationType.LAND);
        }
    }



    // Variants
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(VARIANT, 0);
    }

    @Override
    protected void writeCustomData(WriteView view) {
        super.writeCustomData(view);
        view.putInt("Variant", this.getCrabVariant().getId());
    }

    @Override
    protected void readCustomData(ReadView view) {
        super.readCustomData(view);
        this.dataTracker.set(VARIANT, view.getInt("Variant", 0));
    }

    public CrabVariant getCrabVariant() {
        return CrabVariant.byId(this.dataTracker.get(VARIANT));
    }

    public void getCrabVariant(CrabVariant variant) {
        this.dataTracker.set(VARIANT, variant.getId());
    }



    // Spawning
    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        CrabVariant crabVariant = CrabVariant.getCrabVariant(this.random);
        this.getCrabVariant(crabVariant);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    @Override
    public int getLimitPerChunk() {
        return 8;
    }

    public static boolean canSpawn(EntityType<? extends WaterCreatureEntity> type, WorldAccess world, SpawnReason reason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isSolidBlock(world, pos.down()) && world.getBlockState(pos).isOf(Blocks.WATER);
    }
}
