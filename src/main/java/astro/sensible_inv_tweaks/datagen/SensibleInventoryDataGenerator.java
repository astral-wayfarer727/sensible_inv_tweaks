package astro.sensible_inv_tweaks.datagen;

import astro.sensible_inv_tweaks.world.SITConfiguredFeatures;
import astro.sensible_inv_tweaks.world.SITPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class SensibleInventoryDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(SensibleInventoryModelProvider::new);
        pack.addProvider(SITLootTablesProvider::new);
        pack.addProvider(SITWorldGenerator::new);
        pack.addProvider(SITItemTagProvider::new);
        pack.addProvider(SITBlockTagProvider::new);
        pack.addProvider(SITEntityTagProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, SITConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, SITPlacedFeatures::bootstrap);
    }
}
