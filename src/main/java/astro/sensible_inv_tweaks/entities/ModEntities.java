package astro.sensible_inv_tweaks.entities;
import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import astro.sensible_inv_tweaks.entities.custom.CrabEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;


public class ModEntities {

    public static final EntityType<CrabEntity> CRAB = Registry.register(Registries.ENTITY_TYPE, Identifier.of(SensibleInventoryTweaks.MOD_ID, "crab"),
            EntityType.Builder.create(CrabEntity::new, SpawnGroup.WATER_AMBIENT).dimensions(0.55F, 0.40F).eyeHeight(0.35F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE,
                    Identifier.of(SensibleInventoryTweaks.MOD_ID, "crab"))));

    public static void registerModEntities() {
        SensibleInventoryTweaks.LOGGER.info("Registering Mod Entities for " + SensibleInventoryTweaks.MOD_ID);
    }
}
