package astro.sensible_inv_tweaks.datagen;

import astro.sensible_inv_tweaks.blocks.ModBlocks;
import astro.sensible_inv_tweaks.items.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

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

        //Compression Blocks
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GUNPOWDER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUGAR_BLOCK);

        //Red Nether Brick Extras
        BlockStateModelGenerator.BlockTexturePool redNetherBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.RED_NETHER_BRICKS);
        redNetherBrickPool.fence(ModBlocks.RED_NETHER_BRICK_FENCE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_CHISELED_NETHER_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_CRACKED_NETHER_BRICKS);

        //Nether Foliage
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRIMSON_CAP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WARPED_CAP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRIMSON_BUDDING_SHROOMLIGHT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WARPED_BUDDING_SHROOMLIGHT);

        //Smooth Lapis
        BlockStateModelGenerator.BlockTexturePool smoothLapisPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_LAPIS);
        smoothLapisPool.stairs(ModBlocks.SMOOTH_LAPIS_STAIRS);
        smoothLapisPool.slab(ModBlocks.SMOOTH_LAPIS_SLAB);

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
    }
}
