package astro.sensible_inv_tweaks.util;

import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_SLEDGE_HAMMER = createTag("incorrect_for_sledge_hammer");
        public static final TagKey<Block> HAMMER_MINEABLE = createTag("hammer_mineable");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SensibleInventoryTweaks.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> STEEL_TOOL_MATERIALS = createTag("steel_tool_materials");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SensibleInventoryTweaks.MOD_ID, name));
        }
    }
}
