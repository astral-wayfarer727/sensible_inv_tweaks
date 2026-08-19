package astro.sensible_inv_tweaks.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class GlisteringMelonBlock extends HorizontalFacingBlock {
    public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
    protected GlisteringMelonBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double radius = 1.5;

        for (int i = 0; i < 1; i++) {
            double offsetX = (random.nextDouble() - 0.5) * radius;
            double offsetY = (random.nextDouble() - 0.5) * radius;
            double offsetZ = (random.nextDouble() - 0.5) * radius;

            double x = pos.getX() + 0.5 + offsetX;
            double y = pos.getY() + 0.5 + offsetY;
            double z = pos.getZ() + 0.5 + offsetZ;

            world.addParticleClient(ParticleTypes.WAX_ON, x, y, z, 0.1, 0.1, 0.1);
        }
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}
