package astro.sensible_inv_tweaks.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class SITFeatureGeneration {
    public static void generatePlacedFeatures() {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.VEGETAL_DECORATION,
                SITPlacedFeatures.GUNPOWDER_BLOB_PLACED_KEY);
    }
}
