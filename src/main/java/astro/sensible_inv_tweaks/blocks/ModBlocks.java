package astro.sensible_inv_tweaks.blocks;

import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.base.Function;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {

    private static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(SensibleInventoryTweaks.MOD_ID, name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    //Red Nether Brick Extras
    public static FenceBlock RED_NETHER_BRICK_FENCE = (FenceBlock) register("red_nether_brick_fence",
            FenceBlock::new, Block.Settings.copy(RED_NETHER_BRICKS));
    public static Block RED_CRACKED_NETHER_BRICKS = register("red_cracked_nether_bricks",
            Block::new, AbstractBlock.Settings.copy(RED_NETHER_BRICKS));
    public static Block RED_CHISELED_NETHER_BRICKS = register("red_chiseled_nether_bricks",
            Block::new, AbstractBlock.Settings.copy(RED_NETHER_BRICKS));

    //Nether Foliage
    public static Block CRIMSON_CAP = register("crimson_cap",
            settings -> new UntintedParticleLeavesBlock(0.01f, ParticleTypes.CRIMSON_SPORE, settings),
            AbstractBlock.Settings.create().ticksRandomly().mapColor(MapColor.RED).strength(0.5F).sounds(BlockSoundGroup.WART_BLOCK));
    public static Block WARPED_CAP = register("warped_cap",
            settings -> new UntintedParticleLeavesBlock(0.01f, ParticleTypes.WARPED_SPORE, settings),
            AbstractBlock.Settings.create().ticksRandomly().mapColor(MapColor.BRIGHT_TEAL).strength(0.5F).sounds(BlockSoundGroup.WART_BLOCK));
    public static Block CRIMSON_BUDDING_SHROOMLIGHT = register("crimson_budding_shroomlight",
            settings -> new UntintedParticleLeavesBlock(0.0f, ParticleTypes.CRIMSON_SPORE, settings),
            AbstractBlock.Settings.create().ticksRandomly().mapColor(MapColor.RED).strength(1.0F).luminance(state -> 12).sounds(BlockSoundGroup.SHROOMLIGHT));
    public static Block WARPED_BUDDING_SHROOMLIGHT = register("warped_budding_shroomlight",
            settings -> new UntintedParticleLeavesBlock(0.0f, ParticleTypes.WARPED_SPORE, settings),
            AbstractBlock.Settings.create().ticksRandomly().mapColor(MapColor.BRIGHT_TEAL).strength(1.0F).luminance(state -> 12).sounds(BlockSoundGroup.SHROOMLIGHT));

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
    public static Block FEATHER_BLOCK = register("feather_block",
            HayBlock::new, AbstractBlock.Settings.copy(HAY_BLOCK).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.WOOL));
    public static Block GUNPOWDER_BLOCK = register("gunpowder_block",
            settings -> new ColoredFallingBlock(new ColorCode(-8356741), settings),
            AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sounds(BlockSoundGroup.SAND));
    public static Block SUGAR_BLOCK = register("sugar_block",
            settings -> new ColoredFallingBlock(new ColorCode(-8356741), settings),
            AbstractBlock.Settings.create().mapColor(MapColor.WHITE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sounds(BlockSoundGroup.SAND));

    //Snow and Ice related blocks
    public static Block PACKED_SNOW = register("packed_snow",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.WHITE).requiresTool().strength(0.5F).sounds(BlockSoundGroup.SNOW));
    public static Block PACKED_SNOW_STAIRS = register("packed_snow_stairs",
            settings -> new StairsBlock(PACKED_SNOW.getDefaultState(), settings),
            Block.Settings.copy(PACKED_SNOW));
    public static SlabBlock PACKED_SNOW_SLAB = (SlabBlock) register("packed_snow_slab",
            SlabBlock::new, Block.Settings.copy(PACKED_SNOW));
    public static WallBlock PACKED_SNOW_WALL = (WallBlock) register("packed_snow_wall",
            WallBlock::new, Block.Settings.copy(PACKED_SNOW));

    public static Block CUT_PACKED_ICE = register("cut_packed_ice",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).requiresTool().slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS));
    public static Block CUT_PACKED_ICE_STAIRS = register("cut_packed_ice_stairs",
            settings -> new StairsBlock(CUT_PACKED_ICE.getDefaultState(), settings),
            Block.Settings.copy(CUT_PACKED_ICE));
    public static SlabBlock CUT_PACKED_ICE_SLAB = (SlabBlock) register("cut_packed_ice_slab",
            SlabBlock::new, Block.Settings.copy(CUT_PACKED_ICE));
    public static WallBlock CUT_PACKED_ICE_WALL = (WallBlock) register("cut_packed_ice_wall",
            WallBlock::new, Block.Settings.copy(CUT_PACKED_ICE));


    public static Block CUT_BLUE_ICE = register("cut_blue_ice",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).requiresTool().strength(2.8F).slipperiness(0.989F).sounds(BlockSoundGroup.GLASS));
    public static Block CUT_BLUE_ICE_STAIRS = register("cut_blue_ice_stairs",
            settings -> new StairsBlock(CUT_BLUE_ICE.getDefaultState(), settings),
            Block.Settings.copy(CUT_BLUE_ICE));
    public static SlabBlock CUT_BLUE_ICE_SLAB = (SlabBlock) register("cut_blue_ice_slab",
            SlabBlock::new, Block.Settings.copy(CUT_BLUE_ICE));
    public static WallBlock CUT_BLUE_ICE_WALL = (WallBlock) register("cut_blue_ice_wall",
            WallBlock::new, Block.Settings.copy(CUT_BLUE_ICE));

    //Redstone Lamp Variants
    public static final Block OCHRE_REDSTONE_LAMP = register("ochre_redstone_lamp",
            RedstoneLampBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_YELLOW).luminance(createLightLevelFromLitBlockState(15))
                    .strength(0.3F).sounds(BlockSoundGroup.GLASS).allowsSpawning(Blocks::always));
    public static final Block PEARLESCENT_REDSTONE_LAMP = register("pearlescent_redstone_lamp",
            RedstoneLampBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PURPLE).luminance(createLightLevelFromLitBlockState(15))
                    .strength(0.3F).sounds(BlockSoundGroup.GLASS).allowsSpawning(Blocks::always));
    public static final Block SEA_REDSTONE_LAMP = register("sea_redstone_lamp",
            RedstoneLampBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_CYAN).luminance(createLightLevelFromLitBlockState(15))
                    .strength(0.3F).sounds(BlockSoundGroup.GLASS).allowsSpawning(Blocks::always));
    public static final Block VERDANT_REDSTONE_LAMP = register("verdant_redstone_lamp",
            RedstoneLampBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_LIME).luminance(createLightLevelFromLitBlockState(15))
                    .strength(0.3F).sounds(BlockSoundGroup.GLASS).allowsSpawning(Blocks::always));

    public static void registerBlocks() {
        SensibleInventoryTweaks.LOGGER.info("Registering Blocks for " + SensibleInventoryTweaks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_STAIRS);
            entries.addAfter(ModBlocks.LAPIS_STAIRS, ModBlocks.LAPIS_SLAB);
            entries.addAfter(ModBlocks.LAPIS_SLAB, ModBlocks.CHISELED_LAPIS);
            entries.addAfter(ModBlocks.CHISELED_LAPIS, ModBlocks.LAPIS_BRICKS);
            entries.addAfter(ModBlocks.LAPIS_BRICKS, ModBlocks.LAPIS_PILLAR);
            entries.addAfter(ModBlocks.LAPIS_PILLAR, ModBlocks.SMOOTH_LAPIS);
            entries.addAfter(ModBlocks.SMOOTH_LAPIS, ModBlocks.SMOOTH_LAPIS_STAIRS);
            entries.addAfter(ModBlocks.SMOOTH_LAPIS_STAIRS, ModBlocks.SMOOTH_LAPIS_SLAB);

            entries.addAfter(Blocks.RED_NETHER_BRICK_WALL, ModBlocks.RED_NETHER_BRICK_FENCE);
            entries.addAfter(ModBlocks.RED_NETHER_BRICK_FENCE, ModBlocks.RED_CHISELED_NETHER_BRICKS);
            entries.addAfter(Blocks.RED_NETHER_BRICKS, ModBlocks.RED_CRACKED_NETHER_BRICKS);

            entries.addAfter(Blocks.CUT_RED_SANDSTONE_SLAB, ModBlocks.PACKED_SNOW);
            entries.addAfter(ModBlocks.PACKED_SNOW, ModBlocks.PACKED_SNOW_STAIRS);
            entries.addAfter(ModBlocks.PACKED_SNOW_STAIRS, ModBlocks.PACKED_SNOW_SLAB);
            entries.addAfter(ModBlocks.PACKED_SNOW_SLAB, ModBlocks.PACKED_SNOW_WALL);

            entries.addAfter(Blocks.CUT_RED_SANDSTONE_SLAB, ModBlocks.CUT_PACKED_ICE);
            entries.addAfter(ModBlocks.CUT_PACKED_ICE, ModBlocks.CUT_PACKED_ICE_STAIRS);
            entries.addAfter(ModBlocks.CUT_PACKED_ICE_STAIRS, ModBlocks.CUT_PACKED_ICE_SLAB);
            entries.addAfter(ModBlocks.CUT_PACKED_ICE_SLAB, ModBlocks.CUT_PACKED_ICE_WALL);

            entries.addAfter(Blocks.CUT_RED_SANDSTONE_SLAB, ModBlocks.CUT_BLUE_ICE);
            entries.addAfter(ModBlocks.CUT_BLUE_ICE, ModBlocks.CUT_BLUE_ICE_STAIRS);
            entries.addAfter(ModBlocks.CUT_BLUE_ICE_STAIRS, ModBlocks.CUT_BLUE_ICE_SLAB);
            entries.addAfter(ModBlocks.CUT_BLUE_ICE_SLAB, ModBlocks.CUT_BLUE_ICE_WALL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Blocks.PEARLESCENT_FROGLIGHT, ModBlocks.BLAZE_PILLAR);
            entries.addAfter(ModBlocks.BLAZE_PILLAR, ModBlocks.BREEZE_PILLAR);
            entries.addAfter(Blocks.SUSPICIOUS_GRAVEL, ModBlocks.GUNPOWDER_BLOCK);
            entries.addAfter(ModBlocks.GUNPOWDER_BLOCK, ModBlocks.SUGAR_BLOCK);
            entries.addAfter(Blocks.REDSTONE_LAMP, ModBlocks.OCHRE_REDSTONE_LAMP);
            entries.addAfter(ModBlocks.OCHRE_REDSTONE_LAMP, ModBlocks.PEARLESCENT_REDSTONE_LAMP);
            entries.addAfter(ModBlocks.PEARLESCENT_REDSTONE_LAMP, ModBlocks.SEA_REDSTONE_LAMP);
            entries.addAfter(ModBlocks.SEA_REDSTONE_LAMP, ModBlocks.VERDANT_REDSTONE_LAMP);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Blocks.WARPED_WART_BLOCK, ModBlocks.CRIMSON_CAP);
            entries.addAfter(ModBlocks.CRIMSON_CAP, ModBlocks.WARPED_CAP);
            entries.addAfter(Blocks.SHROOMLIGHT, ModBlocks.CRIMSON_BUDDING_SHROOMLIGHT);
            entries.addAfter(ModBlocks.CRIMSON_BUDDING_SHROOMLIGHT, ModBlocks.WARPED_BUDDING_SHROOMLIGHT);
            entries.addAfter(Blocks.HAY_BLOCK, ModBlocks.FEATHER_BLOCK);
        });
    }
}
