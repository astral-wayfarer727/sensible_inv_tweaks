package astro.sensible_inv_tweaks.datagen;

import astro.sensible_inv_tweaks.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SITLootTablesProvider extends FabricBlockLootTableProvider {
    public SITLootTablesProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BUNDLED_THATCH);
        addDrop(ModBlocks.THATCH);
        addDrop(ModBlocks.THATCH_STAIRS);
        addDrop(ModBlocks.THATCH_WALL);
        addDrop(ModBlocks.THATCH_SLAB, slabDrops(ModBlocks.THATCH_SLAB));

        addDrop(ModBlocks.IRON_BRICKS);
        addDrop(ModBlocks.CHISELED_IRON_BRICKS);
        addDrop(ModBlocks.IRON_BRICK_STAIRS);
        addDrop(ModBlocks.IRON_BRICK_WALL);
        addDrop(ModBlocks.IRON_BRICK_SLAB, slabDrops(ModBlocks.IRON_BRICK_SLAB));

        addDrop(ModBlocks.GOLD_BRICKS);
        addDrop(ModBlocks.CHISELED_GOLD_BRICKS);
        addDrop(ModBlocks.GOLD_BRICK_STAIRS);
        addDrop(ModBlocks.GOLD_BRICK_WALL);
        addDrop(ModBlocks.GOLD_BRICK_SLAB, slabDrops(ModBlocks.GOLD_BRICK_SLAB));

        addDrop(ModBlocks.EMERALD_BRICKS);
        addDrop(ModBlocks.CHISELED_EMERALD_BRICKS);
        addDrop(ModBlocks.EMERALD_BRICK_STAIRS);
        addDrop(ModBlocks.EMERALD_BRICK_WALL);
        addDrop(ModBlocks.EMERALD_BRICK_SLAB, slabDrops(ModBlocks.EMERALD_BRICK_SLAB));

        addDrop(ModBlocks.DIAMOND_BRICKS);
        addDrop(ModBlocks.CHISELED_DIAMOND_BRICKS);
        addDrop(ModBlocks.DIAMOND_BRICK_STAIRS);
        addDrop(ModBlocks.DIAMOND_BRICK_WALL);
        addDrop(ModBlocks.DIAMOND_BRICK_SLAB, slabDrops(ModBlocks.DIAMOND_BRICK_SLAB));

        addDrop(ModBlocks.NETHERITE_BRICKS);
        addDrop(ModBlocks.CHISELED_NETHERITE_BRICKS);
        addDrop(ModBlocks.NETHERITE_BRICK_STAIRS);
        addDrop(ModBlocks.NETHERITE_BRICK_WALL);
        addDrop(ModBlocks.NETHERITE_BRICK_SLAB, slabDrops(ModBlocks.NETHERITE_BRICK_SLAB));

        addDrop(ModBlocks.BLUE_NETHER_BRICKS);
        addDrop(ModBlocks.BLUE_NETHER_BRICK_STAIRS);
        addDrop(ModBlocks.BLUE_NETHER_BRICK_WALL);
        addDrop(ModBlocks.BLUE_NETHER_BRICK_FENCE);
        addDrop(ModBlocks.BLUE_CHISELED_NETHER_BRICKS);
        addDrop(ModBlocks.BLUE_CRACKED_NETHER_BRICKS);
        addDrop(ModBlocks.BLUE_NETHER_BRICK_SLAB, slabDrops(ModBlocks.BLUE_NETHER_BRICK_SLAB));

        addDrop(ModBlocks.POLISHED_COBBLESTONE);
        addDrop(ModBlocks.POLISHED_COBBLESTONE_STAIRS);
        addDrop(ModBlocks.POLISHED_COBBLESTONE_WALL);
        addDrop(ModBlocks.POLISHED_COBBLESTONE_SLAB, slabDrops(ModBlocks.POLISHED_COBBLESTONE_SLAB));

        addDrop(ModBlocks.WHEAT_SEED_SACK);
        addDrop(ModBlocks.APPLE_SACK);
        addDrop(ModBlocks.CARROT_SACK);
        addDrop(ModBlocks.MELON_SEED_SACK);
        addDrop(ModBlocks.POTATO_SACK);
        addDrop(ModBlocks.PUMPKIN_SEED_SACK);
    }
}
