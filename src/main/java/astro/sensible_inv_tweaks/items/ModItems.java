package astro.sensible_inv_tweaks.items;

import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SensibleInventoryTweaks.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static Item RAW_FLANK = register("raw_flank", Item::new, new Item.Settings().food(ModFoodComponents.RAW_FLANK));
    public static Item COOKED_FLANK = register("cooked_flank", Item::new, new Item.Settings().food(ModFoodComponents.COOKED_FLANK));
    public static Item RAW_HAUNCH = register("raw_haunch", Item::new, new Item.Settings().food(ModFoodComponents.RAW_HAUNCH));
    public static Item COOKED_HAUNCH = register("cooked_haunch", Item::new, new Item.Settings().food(ModFoodComponents.COOKED_HAUNCH));
    public static Item RAW_FISH = register("raw_fish", Item::new, new Item.Settings().food(ModFoodComponents.RAW_FISH));
    public static Item COOKED_FISH = register("cooked_fish", Item::new, new Item.Settings().food(ModFoodComponents.COOKED_FISH));

    public static void registerItems() {
        SensibleInventoryTweaks.LOGGER.info("Registering items for " + SensibleInventoryTweaks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(RAW_FLANK);
            entries.add(COOKED_FLANK);
            entries.add(RAW_HAUNCH);
            entries.add(COOKED_HAUNCH);
            entries.add(RAW_FISH);
            entries.add(COOKED_FISH);
        });
    }
}
