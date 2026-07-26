package astro.sensible_inv_tweaks.potion;

import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    //Haste Potions
    public static final RegistryEntry<Potion> HASTE = registerPotion(
            "haste", new Potion("haste", new StatusEffectInstance(StatusEffects.HASTE, 900))
    );
    public static final RegistryEntry<Potion> LONG_HASTE = registerPotion(
            "long_haste", new Potion("haste", new StatusEffectInstance(StatusEffects.HASTE, 1800))
    );
    public static final RegistryEntry<Potion> STRONG_HASTE = registerPotion(
            "strong_haste", new Potion("haste", new StatusEffectInstance(StatusEffects.HASTE, 440, 1))
    );

    //Mining Fatigue Potions
    public static final RegistryEntry<Potion> MINING_FATIGUE = registerPotion(
            "mining_fatigue", new Potion("mining_fatigue", new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 450))
    );
    public static final RegistryEntry<Potion> LONG_MINING_FATIGUE = registerPotion(
            "long_mining_fatigue", new Potion("mining_fatigue", new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 900))
    );
    public static final RegistryEntry<Potion> STRONG_MINING_FATIGUE = registerPotion(
            "strong_mining_fatigue", new Potion("mining_fatigue", new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 220, 1))
    );

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(SensibleInventoryTweaks.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        SensibleInventoryTweaks.LOGGER.info("Registering potions for " + SensibleInventoryTweaks.MOD_ID);
    }
}
