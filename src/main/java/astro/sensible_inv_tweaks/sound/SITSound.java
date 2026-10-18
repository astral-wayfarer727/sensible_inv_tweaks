package astro.sensible_inv_tweaks.sound;

import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SITSound {
    public static final SoundEvent CRAB_STEP = registerSoundEvent("crab_step");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(SensibleInventoryTweaks.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        SensibleInventoryTweaks.LOGGER.info("Registering Sounds for " + SensibleInventoryTweaks.MOD_ID);
    }
}
