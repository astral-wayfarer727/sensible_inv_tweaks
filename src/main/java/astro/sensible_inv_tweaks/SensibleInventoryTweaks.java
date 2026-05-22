package astro.sensible_inv_tweaks;

import astro.sensible_inv_tweaks.blocks.ModBlocks;
import astro.sensible_inv_tweaks.items.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SensibleInventoryTweaks implements ModInitializer {
	public static final String MOD_ID = "sensible_inv_tweaks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModBlocks.registerBlocks();
	}
}