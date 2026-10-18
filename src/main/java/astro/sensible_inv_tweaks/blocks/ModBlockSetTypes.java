package astro.sensible_inv_tweaks.blocks;

import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlockSetTypes {
    public static final BlockSetType STEEL = BlockSetTypeBuilder
            .copyOf(BlockSetType.IRON)
            .openableByHand(true)
            .soundGroup(BlockSoundGroup.IRON)
            .register(Identifier.of(SensibleInventoryTweaks.MOD_ID, "steel"));
}
