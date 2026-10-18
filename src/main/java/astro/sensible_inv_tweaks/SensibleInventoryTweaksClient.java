package astro.sensible_inv_tweaks;

import astro.sensible_inv_tweaks.blocks.ModBlocks;
import astro.sensible_inv_tweaks.entities.ModEntities;
import astro.sensible_inv_tweaks.entities.client.Crab.CrabModel;
import astro.sensible_inv_tweaks.entities.client.Crab.CrabRenderer;
import astro.sensible_inv_tweaks.entities.client.ModEntityModelLayers;
import astro.sensible_inv_tweaks.items.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.item.FishingRodItem;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.stateprovider.PredicatedStateProvider;

public class SensibleInventoryTweaksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.FRAMED_GLASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.FRAMED_GLASS_PANE, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.STEEL_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.STEEL_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.STEEL_BARS, BlockRenderLayer.CUTOUT);

        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.CRAB, CrabModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CRAB, CrabRenderer::new);
    }
}
