package astro.sensible_inv_tweaks;

import astro.sensible_inv_tweaks.blocks.ModBlocks;
import astro.sensible_inv_tweaks.items.ModItems;
import astro.sensible_inv_tweaks.potion.ModPotions;
import astro.sensible_inv_tweaks.world.SITFeatureGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SensibleInventoryTweaks implements ModInitializer {
	public static final String MOD_ID = "sensible_inv_tweaks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModBlocks.registerBlocks();
		ModPotions.registerPotions();
		SITFeatureGeneration.generatePlacedFeatures();

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.GOLDEN_POTATO, ModPotions.HASTE);
			builder.registerPotionRecipe(ModPotions.HASTE, Items.REDSTONE, ModPotions.LONG_HASTE);
			builder.registerPotionRecipe(ModPotions.HASTE, Items.GLOWSTONE_DUST, ModPotions.STRONG_HASTE);

			builder.registerPotionRecipe(ModPotions.HASTE, Items.FERMENTED_SPIDER_EYE, ModPotions.MINING_FATIGUE);
			builder.registerPotionRecipe(ModPotions.LONG_HASTE, Items.FERMENTED_SPIDER_EYE, ModPotions.LONG_MINING_FATIGUE);
			builder.registerPotionRecipe(ModPotions.STRONG_HASTE, Items.FERMENTED_SPIDER_EYE, ModPotions.STRONG_MINING_FATIGUE);
		});
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.APPLE_SACK, 1.0F);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CARROT_SACK, 1.0F);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.MELON_SEED_SACK, 1.0F);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.POTATO_SACK, 1.0F);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.WHEAT_SEED_SACK, 1.0F);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.PUMPKIN_SEED_SACK, 1.0F);

		CompostingChanceRegistry.INSTANCE.add(ModBlocks.BUNDLED_THATCH, 0.4F);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.THATCH, 0.1F);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.THATCH_SLAB, 0.1F);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.THATCH_STAIRS, 0.1F);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.THATCH_WALL, 0.1F);
	}
}