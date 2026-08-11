package astro.sensible_inv_tweaks;

import astro.sensible_inv_tweaks.datagen.SITLootTablesProvider;
import astro.sensible_inv_tweaks.datagen.SensibleInventoryModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SensibleInventoryDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(SensibleInventoryModelProvider::new);
        pack.addProvider(SITLootTablesProvider::new);
    }
}
