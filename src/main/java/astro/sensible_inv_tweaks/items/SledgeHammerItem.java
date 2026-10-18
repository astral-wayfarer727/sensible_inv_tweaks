package astro.sensible_inv_tweaks.items;

import astro.sensible_inv_tweaks.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class SledgeHammerItem extends Item {
    public SledgeHammerItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.pickaxe(material, attackDamage, attackSpeed));
    }

    // Sledge Hammer item coded following KaupenJoes 1.21.x Fabric Modding tutorial series, thank you for what you do!
    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, BlockState blockState, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);
        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            if (blockState.isIn(ModTags.Blocks.HAMMER_MINEABLE)){
                if (blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP) {
                    for (int x = -range; x <= range; x++) {
                        for (int y = -range; y <= range; y++) {
                            positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y));
                        }
                    }
                }

                if (blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                    for (int x = -range; x <= range; x++) {
                        for (int y = -range; y <= range; y++) {
                            positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ()));
                        }
                    }
                }

                if (blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                    for (int x = -range; x <= range; x++) {
                        for (int y = -range; y <= range; y++) {
                            positions.add(new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                        }
                    }
                }
            }
        }

        return positions;
    }
}
