package astro.sensible_inv_tweaks.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BreezePillarBlock extends PillarBlock {
    public BreezePillarBlock(Settings settings) {
        super(settings);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(40) == 0) {
            world.playSoundClient(
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    SoundEvents.ENTITY_BREEZE_WHIRL,
                    SoundCategory.AMBIENT,
                    random.nextFloat() * 0.25F + 0.75F,
                    random.nextFloat() + 0.5F,
                    false
            );
        }
    }
}
