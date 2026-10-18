package astro.sensible_inv_tweaks.items;

import astro.sensible_inv_tweaks.util.ModTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ModToolMaterials {
    public static final ToolMaterial SLEDGE_HAMMER_TOOL = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_SLEDGE_HAMMER,
            2048,3,2,15, ModTags.Items.STEEL_TOOL_MATERIALS);

    public static final ToolMaterial STEEL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL,
            1024,3,2,15, ModTags.Items.STEEL_TOOL_MATERIALS);
}
