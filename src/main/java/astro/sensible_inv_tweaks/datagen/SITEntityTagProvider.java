package astro.sensible_inv_tweaks.datagen;

import astro.sensible_inv_tweaks.entities.ModEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class SITEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
    public SITEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(EntityTypeTags.AQUATIC)
                .add(ModEntities.CRAB);
        valueLookupBuilder(EntityTypeTags.CAN_BREATHE_UNDER_WATER)
                .add(ModEntities.CRAB);
        valueLookupBuilder(EntityTypeTags.NAUTILUS_HOSTILES)
                .add(ModEntities.CRAB);
        valueLookupBuilder(EntityTypeTags.ARTHROPOD)
                .add(ModEntities.CRAB);
    }
}