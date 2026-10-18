package astro.sensible_inv_tweaks.world.gen;

import astro.sensible_inv_tweaks.entities.ModEntities;
import astro.sensible_inv_tweaks.entities.custom.CrabEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class SITEntitySpawns {
    public static void addSpawns()  {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN),
                SpawnGroup.WATER_AMBIENT, ModEntities.CRAB, 5, 1, 3);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN),
                SpawnGroup.WATER_AMBIENT, ModEntities.CRAB, 15, 1, 3);

        SpawnRestriction.register(ModEntities.CRAB, SpawnLocationTypes.UNRESTRICTED, Heightmap.Type.OCEAN_FLOOR_WG, CrabEntity::canSpawn);
    }
}
