package astro.sensible_inv_tweaks.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.TorchflowerBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Blocks.class)
public class TorchflowerMixin {

    @ModifyExpressionValue(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = "stringValue=torchflower"
                    )
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;create()Lnet/minecraft/block/AbstractBlock$Settings;",
                    ordinal = 0
            )
    )
    private static AbstractBlock.Settings TorchflowerLightLevel(AbstractBlock.Settings properties) {
        return properties.luminance(blockState -> 14);
    }

    @ModifyExpressionValue(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Blocks;createFlowerPotSettings()Lnet/minecraft/block/AbstractBlock$Settings;",
                    ordinal = 1
            )
    )
    private static AbstractBlock.Settings PottedTorchflowerLightLevel(AbstractBlock.Settings properties) {
        return properties.luminance(blockState -> 12);
    }

    @ModifyExpressionValue(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = "stringValue=torchflower_crop"
                    )
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;create()Lnet/minecraft/block/AbstractBlock$Settings;",
                    ordinal = 0
            )
    )
    private static AbstractBlock.Settings TorchflowerCropLightLevel(AbstractBlock.Settings properties) {
        return properties.luminance(blockState -> switch (blockState.get(TorchflowerBlock.AGE)) {
            case 0 -> 7;
            case 1 -> 10;
            default -> 14;
        });
    }
}