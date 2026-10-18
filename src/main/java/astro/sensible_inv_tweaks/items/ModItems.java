package astro.sensible_inv_tweaks.items;

import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import astro.sensible_inv_tweaks.blocks.ModBlocks;
import astro.sensible_inv_tweaks.entities.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.function.Function;

public class ModItems {

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SensibleInventoryTweaks.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    //Steel Related
    public static Item RAW_CARBON_IRON = register("raw_carbon_iron", Item::new, new Item.Settings());
    public static Item STEEL_INGOT = register("steel_ingot", Item::new, new Item.Settings());
    public static final Item SLEDGE_HAMMER = register("sledge_hammer", settings -> new SledgeHammerItem(ModToolMaterials.SLEDGE_HAMMER_TOOL, 7, -3.2f, settings), new Item.Settings());
    public static Item BUTCHER_KNIFE = register("butcher_knife", Item::new, new Item.Settings().sword(ModToolMaterials.STEEL, 3.0F, -2.4F));

    //Replacement Food Items

    public static Item RAW_FLANK = register("raw_flank", Item::new, new Item.Settings().food(ModFoodComponents.RAW_FLANK));
    public static Item COOKED_FLANK = register("cooked_flank", Item::new, new Item.Settings().food(ModFoodComponents.COOKED_FLANK));
    public static Item RAW_HAUNCH = register("raw_haunch", Item::new, new Item.Settings().food(ModFoodComponents.RAW_HAUNCH));
    public static Item COOKED_HAUNCH = register("cooked_haunch", Item::new, new Item.Settings().food(ModFoodComponents.COOKED_HAUNCH));
    public static Item RAW_FISH = register("raw_fish", Item::new, new Item.Settings().food(ModFoodComponents.RAW_FISH));
    public static Item COOKED_FISH = register("cooked_fish", Item::new, new Item.Settings().food(ModFoodComponents.COOKED_FISH));

    //Crab
    public static Item RAW_CRAB_MARROW = register("raw_crab_marrow", Item::new, new Item.Settings().food(ModFoodComponents.RAW_FISH));
    public static Item COOKED_CRAB_MARROW = register("cooked_crab_marrow", Item::new, new Item.Settings().food(ModFoodComponents.COOKED_FISH));

    public static Item CRAB_CLAW = register("crab_claw", Item::new, new Item.Settings().maxCount(1).component(DataComponentTypes.ATTRIBUTE_MODIFIERS, reachAttribute()));

    private static AttributeModifiersComponent reachAttribute() {
        return AttributeModifiersComponent.builder()
            .add(
                EntityAttributes.BLOCK_INTERACTION_RANGE,
                    new EntityAttributeModifier(
                    Identifier.ofVanilla("attribute.name.block_interaction_range"),
                    2.0,
                    EntityAttributeModifier.Operation.ADD_VALUE
                ),
                AttributeModifierSlot.HAND
            )
            .add(
                EntityAttributes.ENTITY_INTERACTION_RANGE,
                    new EntityAttributeModifier(
                    Identifier.ofVanilla("attribute.name.entity_interaction_range"),
                    2.0,
                    EntityAttributeModifier.Operation.ADD_VALUE
                ),
                AttributeModifierSlot.HAND
            )
        .build();
    }

    public static Item CRAB_SPAWN_EGG = register("crab_spawn_egg", SpawnEggItem::new, new Item.Settings().spawnEgg(ModEntities.CRAB));

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
            entries.addAfter(ModItems.COOKED_FISH, ModItems.RAW_CRAB_MARROW);
            entries.addAfter(ModItems.RAW_CRAB_MARROW, ModItems.COOKED_CRAB_MARROW);
            entries.addAfter(Items.POTATO, ModItems.GOLDEN_POTATO);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.REDSTONE_TORCH, ModItems.GLOWSTICK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addBefore(Items.BRUSH, ModItems.BUTCHER_KNIFE);
            entries.addBefore(Items.NAME_TAG, ModItems.CRAB_CLAW);
            entries.addBefore(Items.BUCKET, ModItems.SLEDGE_HAMMER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.GOLDEN_CARROT, ModItems.GOLDEN_POTATO);
            entries.addAfter(Items.RAW_IRON, ModItems.RAW_CARBON_IRON);
            entries.addAfter(Items.IRON_INGOT, ModItems.STEEL_INGOT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.addAfter(Items.TROPICAL_FISH_SPAWN_EGG, ModItems.CRAB_SPAWN_EGG);
        });
    }
}
