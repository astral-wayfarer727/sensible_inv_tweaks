package astro.sensible_inv_tweaks.datagen;

import astro.sensible_inv_tweaks.blocks.ModBlocks;
import astro.sensible_inv_tweaks.items.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;

public class SensibleInventoryModelProvider extends FabricModelProvider {
    public SensibleInventoryModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Lapis Blockset
        BlockStateModelGenerator.BlockTexturePool lapisBlockExtrasPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LAPIS_BLOCK);
        lapisBlockExtrasPool.stairs(ModBlocks.LAPIS_STAIRS);
        lapisBlockExtrasPool.slab(ModBlocks.LAPIS_SLAB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_LAPIS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LAPIS_BRICKS);

        //Smooth Lapis
        BlockStateModelGenerator.BlockTexturePool smoothLapisPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_LAPIS);
        smoothLapisPool.stairs(ModBlocks.SMOOTH_LAPIS_STAIRS);
        smoothLapisPool.slab(ModBlocks.SMOOTH_LAPIS_SLAB);

        //Polished Cobblestone
        BlockStateModelGenerator.BlockTexturePool polishedCobblePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_COBBLESTONE);
        polishedCobblePool.stairs(ModBlocks.POLISHED_COBBLESTONE_STAIRS);
        polishedCobblePool.slab(ModBlocks.POLISHED_COBBLESTONE_SLAB);
        polishedCobblePool.wall(ModBlocks.POLISHED_COBBLESTONE_WALL);

        //Compression Blocks
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GUNPOWDER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUGAR_BLOCK);

        BlockStateModelGenerator.BlockTexturePool thatchPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.THATCH);
        thatchPool.stairs(ModBlocks.THATCH_STAIRS);
        thatchPool.slab(ModBlocks.THATCH_SLAB);
        thatchPool.wall(ModBlocks.THATCH_WALL);

        //Red Nether Brick Extras
        BlockStateModelGenerator.BlockTexturePool redNetherBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.RED_NETHER_BRICKS);
        redNetherBrickPool.fence(ModBlocks.RED_NETHER_BRICK_FENCE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_CHISELED_NETHER_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_CRACKED_NETHER_BRICKS);

        //Blue Nether Bricks
        BlockStateModelGenerator.BlockTexturePool blueNetherBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLUE_NETHER_BRICKS);
        blueNetherBrickPool.stairs(ModBlocks.BLUE_NETHER_BRICK_STAIRS);
        blueNetherBrickPool.slab(ModBlocks.BLUE_NETHER_BRICK_SLAB);
        blueNetherBrickPool.wall(ModBlocks.BLUE_NETHER_BRICK_WALL);
        blueNetherBrickPool.fence(ModBlocks.BLUE_NETHER_BRICK_FENCE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_CHISELED_NETHER_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_CRACKED_NETHER_BRICKS);

        //Nether Foliage
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRIMSON_CAP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WARPED_CAP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRIMSON_BUDDING_SHROOMLIGHT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WARPED_BUDDING_SHROOMLIGHT);

        //Metal Decoration Blocks
        BlockStateModelGenerator.BlockTexturePool ironBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.IRON_BRICKS);
        ironBrickPool.stairs(ModBlocks.IRON_BRICK_STAIRS);
        ironBrickPool.slab(ModBlocks.IRON_BRICK_SLAB);
        ironBrickPool.wall(ModBlocks.IRON_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_IRON_BRICKS);

        BlockStateModelGenerator.BlockTexturePool goldBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GOLD_BRICKS);
        goldBrickPool.stairs(ModBlocks.GOLD_BRICK_STAIRS);
        goldBrickPool.slab(ModBlocks.GOLD_BRICK_SLAB);
        goldBrickPool.wall(ModBlocks.GOLD_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_GOLD_BRICKS);

        BlockStateModelGenerator.BlockTexturePool emeraldBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EMERALD_BRICKS);
        emeraldBrickPool.stairs(ModBlocks.EMERALD_BRICK_STAIRS);
        emeraldBrickPool.slab(ModBlocks.EMERALD_BRICK_SLAB);
        emeraldBrickPool.wall(ModBlocks.EMERALD_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_EMERALD_BRICKS);

        BlockStateModelGenerator.BlockTexturePool diamondBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DIAMOND_BRICKS);
        diamondBrickPool.stairs(ModBlocks.DIAMOND_BRICK_STAIRS);
        diamondBrickPool.slab(ModBlocks.DIAMOND_BRICK_SLAB);
        diamondBrickPool.wall(ModBlocks.DIAMOND_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_DIAMOND_BRICKS);

        BlockStateModelGenerator.BlockTexturePool netheriteBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.NETHERITE_BRICKS);
        netheriteBrickPool.stairs(ModBlocks.NETHERITE_BRICK_STAIRS);
        netheriteBrickPool.slab(ModBlocks.NETHERITE_BRICK_SLAB);
        netheriteBrickPool.wall(ModBlocks.NETHERITE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_NETHERITE_BRICKS);

        //Snow and Ice related blocks
        BlockStateModelGenerator.BlockTexturePool packedSnowPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PACKED_SNOW);
        packedSnowPool.stairs(ModBlocks.PACKED_SNOW_STAIRS);
        packedSnowPool.slab(ModBlocks.PACKED_SNOW_SLAB);
        packedSnowPool.wall(ModBlocks.PACKED_SNOW_WALL);

        BlockStateModelGenerator.BlockTexturePool packedIcePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CUT_PACKED_ICE);
        packedIcePool.stairs(ModBlocks.CUT_PACKED_ICE_STAIRS);
        packedIcePool.slab(ModBlocks.CUT_PACKED_ICE_SLAB);
        packedIcePool.wall(ModBlocks.CUT_PACKED_ICE_WALL);

        BlockStateModelGenerator.BlockTexturePool blueIcePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CUT_BLUE_ICE);
        blueIcePool.stairs(ModBlocks.CUT_BLUE_ICE_STAIRS);
        blueIcePool.slab(ModBlocks.CUT_BLUE_ICE_SLAB);
        blueIcePool.wall(ModBlocks.CUT_BLUE_ICE_WALL);

        //Misc
        blockStateModelGenerator.registerGlassAndPane(ModBlocks.FRAMED_GLASS, ModBlocks.FRAMED_GLASS_PANE);
        blockStateModelGenerator.registerTorch(ModBlocks.GLOWSTICK, ModBlocks.WALL_GLOWSTICK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_FLANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_FLANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_HAUNCH, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_HAUNCH, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FISH, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_FISH, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARPED_WART, Models.GENERATED);
    }
}
