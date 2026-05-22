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
        BlockStateModelGenerator.BlockTexturePool lapisBlockExtrasPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LAPIS_BLOCK);
        lapisBlockExtrasPool.stairs(ModBlocks.LAPIS_STAIRS);
        lapisBlockExtrasPool.slab(ModBlocks.LAPIS_SLAB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_LAPIS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LAPIS_BRICKS);

        BlockStateModelGenerator.BlockTexturePool smoothLapisPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_LAPIS);
        smoothLapisPool.stairs(ModBlocks.SMOOTH_LAPIS_STAIRS);
        smoothLapisPool.slab(ModBlocks.SMOOTH_LAPIS_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_FLANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_FLANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_HAUNCH, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_HAUNCH, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FISH, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_FISH, Models.GENERATED);
    }
}
