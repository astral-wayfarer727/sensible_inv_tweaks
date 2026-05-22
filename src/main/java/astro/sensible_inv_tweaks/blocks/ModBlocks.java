package astro.sensible_inv_tweaks.blocks;

import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.base.Function;

import static net.minecraft.block.Blocks.IRON_BLOCK;
import static net.minecraft.block.Blocks.LAPIS_BLOCK;

public class ModBlocks {

    private static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(SensibleInventoryTweaks.MOD_ID, name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    //Lapis Blockset
    public static Block LAPIS_STAIRS = register("lapis_stairs",
            settings -> new StairsBlock(LAPIS_BLOCK.getDefaultState(), settings),
            Block.Settings.copy(LAPIS_BLOCK));
    public static SlabBlock LAPIS_SLAB = (SlabBlock) register("lapis_slab",
            SlabBlock::new, Block.Settings.copy(LAPIS_BLOCK));
    public static Block CHISELED_LAPIS = register("chiseled_lapis",
            Block::new, AbstractBlock.Settings.copy(LAPIS_BLOCK));
    public static Block LAPIS_BRICKS = register("lapis_bricks",
            Block::new, AbstractBlock.Settings.copy(LAPIS_BLOCK));
    public static Block LAPIS_PILLAR = register("lapis_pillar",
            PillarBlock::new, AbstractBlock.Settings.copy(LAPIS_BLOCK));

    //Smooth Lapis
    public static Block SMOOTH_LAPIS = register("smooth_lapis",
            Block::new, AbstractBlock.Settings.copy(LAPIS_BLOCK));
    public static Block SMOOTH_LAPIS_STAIRS = register("smooth_lapis_stairs",
            settings -> new StairsBlock(SMOOTH_LAPIS.getDefaultState(), settings),
            Block.Settings.copy(SMOOTH_LAPIS));
    public static SlabBlock SMOOTH_LAPIS_SLAB = (SlabBlock) register("smooth_lapis_slab",
            SlabBlock::new, Block.Settings.copy(SMOOTH_LAPIS));

    //Compression Blocks
    public static Block BLAZE_PILLAR = register("blaze_pillar",
            PillarBlock::new, AbstractBlock.Settings.copy(IRON_BLOCK).luminance(state -> 14));
    public static Block BREEZE_PILLAR = register("breeze_pillar",
            PillarBlock::new, AbstractBlock.Settings.copy(IRON_BLOCK));

    public static void registerBlocks() {
        SensibleInventoryTweaks.LOGGER.info("Registering Blocks for " + SensibleInventoryTweaks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(LAPIS_SLAB);
            entries.add(LAPIS_STAIRS);
            entries.add(CHISELED_LAPIS);
            entries.add(LAPIS_BRICKS);
            entries.add(SMOOTH_LAPIS);
            entries.add(SMOOTH_LAPIS_STAIRS);
            entries.add(SMOOTH_LAPIS_SLAB);
            entries.add(LAPIS_PILLAR);
            entries.add(BLAZE_PILLAR);
            entries.add(BREEZE_PILLAR);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(BLAZE_PILLAR);
        });
    }
}
