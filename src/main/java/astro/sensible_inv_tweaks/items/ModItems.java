package astro.sensible_inv_tweaks.items;

import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import astro.sensible_inv_tweaks.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ModItems {

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SensibleInventoryTweaks.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    //Warped Wart
    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }

    public static Item WARPED_WART = register("warped_wart", createBlockItemWithUniqueName(ModBlocks.WARPED_WART_CROP), new Item.Settings());

    //Replacement Food Items
    public static Item RAW_FLANK = register("raw_flank", Item::new, new Item.Settings().food(ModFoodComponents.RAW_FLANK));
    public static Item COOKED_FLANK = register("cooked_flank", Item::new, new Item.Settings().food(ModFoodComponents.COOKED_FLANK));
    public static Item RAW_HAUNCH = register("raw_haunch", Item::new, new Item.Settings().food(ModFoodComponents.RAW_HAUNCH));
    public static Item COOKED_HAUNCH = register("cooked_haunch", Item::new, new Item.Settings().food(ModFoodComponents.COOKED_HAUNCH));
    public static Item RAW_FISH = register("raw_fish", Item::new, new Item.Settings().food(ModFoodComponents.RAW_FISH));
    public static Item COOKED_FISH = register("cooked_fish", Item::new, new Item.Settings().food(ModFoodComponents.COOKED_FISH));

    //Potion Ingredient
    public static Item GOLDEN_POTATO = register("golden_potato", Item::new, new Item.Settings().food(ModFoodComponents.GOLDEN_POTATO));

    //Glowstick
    public static Item GLOWSTICK = register("glowstick_item", (properties) -> new VerticallyAttachableBlockItem(ModBlocks.GLOWSTICK, ModBlocks.WALL_GLOWSTICK, Direction.DOWN, properties), new Item.Settings());

    public static void registerItems() {
        SensibleInventoryTweaks.LOGGER.info("Registering items for " + SensibleInventoryTweaks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.COOKED_RABBIT, ModItems.RAW_FLANK);
            entries.addAfter(ModItems.RAW_FLANK, ModItems.COOKED_FLANK);
            entries.addAfter(ModItems.COOKED_FLANK, ModItems.RAW_HAUNCH);
            entries.addAfter(ModItems.RAW_HAUNCH, ModItems.COOKED_HAUNCH);
            entries.addAfter(Items.COOKED_SALMON, ModItems.RAW_FISH);
            entries.addAfter(ModItems.RAW_FISH, ModItems.COOKED_FISH);
            entries.addAfter(Items.POTATO, ModItems.GOLDEN_POTATO);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Items.NETHER_WART, ModItems.WARPED_WART);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.REDSTONE_TORCH, ModItems.GLOWSTICK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.GOLDEN_CARROT, ModItems.GOLDEN_POTATO);
            entries.addAfter(Items.NETHER_WART, ModItems.WARPED_WART);
        });
    }
}
