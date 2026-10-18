package astro.sensible_inv_tweaks.datagen;

import astro.sensible_inv_tweaks.blocks.ModBlocks;
import astro.sensible_inv_tweaks.items.ModItems;
import astro.sensible_inv_tweaks.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class SITBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public SITBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.DOORS)
                .add(ModBlocks.STEEL_DOOR);
        valueLookupBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.STEEL_TRAPDOOR);
    }
}