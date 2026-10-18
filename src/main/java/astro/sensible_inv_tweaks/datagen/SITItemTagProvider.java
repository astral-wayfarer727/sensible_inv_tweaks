package astro.sensible_inv_tweaks.datagen;

import astro.sensible_inv_tweaks.blocks.ModBlocks;
import astro.sensible_inv_tweaks.items.ModItems;
import astro.sensible_inv_tweaks.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class SITItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public SITItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.NAUTILUS_TAMING_ITEMS)
                .add(ModItems.RAW_CRAB_MARROW);

        valueLookupBuilder(ItemTags.NAUTILUS_FOOD)
                .add(ModItems.RAW_CRAB_MARROW);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.BUTCHER_KNIFE);

        valueLookupBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.SLEDGE_HAMMER);

        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.SLEDGE_HAMMER);

        valueLookupBuilder(ItemTags.VANISHING_ENCHANTABLE)
                .add(ModItems.SLEDGE_HAMMER);

        valueLookupBuilder(ModTags.Items.STEEL_TOOL_MATERIALS)
                .add(ModItems.STEEL_INGOT);

        valueLookupBuilder(ItemTags.DOORS)
                .add(Item.fromBlock(ModBlocks.STEEL_DOOR));
        valueLookupBuilder(ItemTags.TRAPDOORS)
                .add(Item.fromBlock(ModBlocks.STEEL_TRAPDOOR));
    }
}