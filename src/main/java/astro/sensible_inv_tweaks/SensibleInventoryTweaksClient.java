package astro.sensible_inv_tweaks;

import astro.sensible_inv_tweaks.blocks.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;

public class SensibleInventoryTweaksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.WARPED_WART_CROP, BlockRenderLayer.CUTOUT);
    }
}
