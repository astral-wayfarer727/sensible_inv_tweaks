package astro.sensible_inv_tweaks.entities.client.Crab;

import astro.sensible_inv_tweaks.entities.client.ModEntityModelLayers;
import astro.sensible_inv_tweaks.entities.custom.CrabEntity;
import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import astro.sensible_inv_tweaks.entities.variant.CrabVariant;
import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class CrabRenderer extends MobEntityRenderer<CrabEntity, CrabRenderState, CrabModel> {
    private static final Map<CrabVariant, Identifier> TEXTURES = Maps.newEnumMap(
            Map.of(
                    CrabVariant.RED,
                    Identifier.of(SensibleInventoryTweaks.MOD_ID, "textures/entity/crab/crab_red.png"),
                    CrabVariant.BLUE,
                    Identifier.of(SensibleInventoryTweaks.MOD_ID, "textures/entity/crab/crab_blue.png"),
                    CrabVariant.GREEN,
                    Identifier.of(SensibleInventoryTweaks.MOD_ID, "textures/entity/crab/crab_green.png"),
                    CrabVariant.YELLOW,
                    Identifier.of(SensibleInventoryTweaks.MOD_ID, "textures/entity/crab/crab_yellow.png"),
                    CrabVariant.PURPLE,
                    Identifier.of(SensibleInventoryTweaks.MOD_ID, "textures/entity/crab/crab_purple.png"),
                    CrabVariant.PINK,
                    Identifier.of(SensibleInventoryTweaks.MOD_ID, "textures/entity/crab/crab_pink.png"),
                    CrabVariant.VAMPIRE,
                    Identifier.of(SensibleInventoryTweaks.MOD_ID, "textures/entity/crab/crab_vampire.png")
            )
    );

    public CrabRenderer(EntityRendererFactory.Context context) {
        super(context, new CrabModel(context.getPart(ModEntityModelLayers.CRAB)), 0.35F);
    }

    @Override
    public CrabRenderState createRenderState() {
        return new CrabRenderState();
    }

    @Override
    public Identifier getTexture(CrabRenderState crabRenderState) {
        return TEXTURES.get(crabRenderState.variant);
    }

    public void updateRenderState(CrabEntity crabEntity, CrabRenderState crabRenderState, float f) {
        super.updateRenderState(crabEntity, crabRenderState, f);
        crabRenderState.variant = crabEntity.getCrabVariant();
        crabRenderState.walkAnimationState.copyFrom(crabEntity.walkAnimationState);
    }
}
