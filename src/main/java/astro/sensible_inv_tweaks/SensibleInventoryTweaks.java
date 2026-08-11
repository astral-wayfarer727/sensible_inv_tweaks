package astro.sensible_inv_tweaks;

import astro.sensible_inv_tweaks.blocks.ModBlocks;
import astro.sensible_inv_tweaks.items.ModItems;
import astro.sensible_inv_tweaks.potion.ModPotions;
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

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.FIRE_RESISTANCE, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_FIRE_RESISTANCE, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.HARMING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.STRONG_HARMING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.HEALING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.STRONG_HEALING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.INFESTED, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.INVISIBILITY, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_INVISIBILITY, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LEAPING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_LEAPING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.STRONG_LEAPING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LUCK, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.NIGHT_VISION, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_NIGHT_VISION, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.OOZING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.POISON, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_POISON, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.STRONG_POISON, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.REGENERATION, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_REGENERATION, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.STRONG_REGENERATION, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.SLOW_FALLING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_SLOW_FALLING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.SLOWNESS, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_SLOWNESS, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.STRONG_SLOWNESS, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.STRENGTH, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_STRENGTH, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.STRONG_STRENGTH, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.SWIFTNESS, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_SWIFTNESS, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.STRONG_SWIFTNESS, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.TURTLE_MASTER, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_TURTLE_MASTER, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.STRONG_TURTLE_MASTER, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.WATER_BREATHING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_WATER_BREATHING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.WEAKNESS, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.LONG_WEAKNESS, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.WEAVING, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.WIND_CHARGED, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.MUNDANE, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.THICK, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(ModPotions.HASTE, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(ModPotions.LONG_HASTE, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(ModPotions.STRONG_HASTE, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(ModPotions.MINING_FATIGUE, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(ModPotions.LONG_MINING_FATIGUE, ModItems.WARPED_WART, Potions.WATER);
			builder.registerPotionRecipe(ModPotions.STRONG_MINING_FATIGUE, ModItems.WARPED_WART, Potions.WATER);

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