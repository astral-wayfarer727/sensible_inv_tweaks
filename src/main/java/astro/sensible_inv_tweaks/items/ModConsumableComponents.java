package astro.sensible_inv_tweaks.items;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.component.type.ConsumableComponents.food;

public class ModConsumableComponents {
    public static final ConsumableComponent GOLDEN_POTATO = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(new StatusEffectInstance(StatusEffects.HASTE, 900, 0))
                    )
            )
            .build();
    public static final ConsumableComponent ENCHANTED_GOLDEN_POTATO = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(new StatusEffectInstance(StatusEffects.HASTE, 440, 1))
                    )
            )
            .build();

}
