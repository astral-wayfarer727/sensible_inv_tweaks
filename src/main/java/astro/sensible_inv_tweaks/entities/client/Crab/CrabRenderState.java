package astro.sensible_inv_tweaks.entities.client.Crab;

import astro.sensible_inv_tweaks.entities.variant.CrabVariant;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class CrabRenderState extends LivingEntityRenderState {
    public final AnimationState walkAnimationState = new AnimationState();

    public CrabVariant variant = CrabVariant.RED;
}
