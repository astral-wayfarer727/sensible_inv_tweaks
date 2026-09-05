package astro.sensible_inv_tweaks.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.ColoredFallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GunpowderBlock extends ColoredFallingBlock {

    public GunpowderBlock(ColorCode color, Settings settings) {
        super(color, settings);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.FLINT_AND_STEEL)) {
            if (!player.getAbilities().creativeMode) {
                stack.damage(1, player, hand.getEquipmentSlot());
            }
            world.removeBlock(pos, false);
            world.createExplosion(
                    null,
                    pos.getX() + 0.5D,
                    pos.getY() + 0.5D,
                    pos.getZ() + 0.5D,
                    5.0F,
                    false,
                    ServerWorld.ExplosionSourceType.BLOCK
            );
        } else {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (world instanceof ServerWorld serverWorld) {
            BlockPos blockPos = hit.getBlockPos();
            if (projectile.isOnFire() && projectile.canModifyAt(serverWorld, blockPos)) {
                world.removeBlock(blockPos, false);
                world.createExplosion(
                        null,
                        blockPos.getX() + 0.5D,
                        blockPos.getY() + 0.5D,
                        blockPos.getZ() + 0.5D,
                        5.0F,
                        false,
                        ServerWorld.ExplosionSourceType.BLOCK
                );
            }
        }
    }
}
