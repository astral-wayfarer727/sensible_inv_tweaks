package astro.sensible_inv_tweaks.world;

import astro.sensible_inv_tweaks.SensibleInventoryTweaks;
import astro.sensible_inv_tweaks.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class SITConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> GUNPOWDER_BLOB_KEY = registerKey("gunpowder_blob");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RuleTest netherReplaceable = new BlockMatchRuleTest(Blocks.NETHERRACK);

        List<OreFeatureConfig.Target> gunpowderBlobs =
                List.of(OreFeatureConfig.createTarget(netherReplaceable, ModBlocks.GUNPOWDER_BLOCK.getDefaultState()));

        register(context, GUNPOWDER_BLOB_KEY, Feature.ORE, new OreFeatureConfig(gunpowderBlobs, 16, 1));
    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(SensibleInventoryTweaks.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key,new ConfiguredFeature<>(feature, configuration));
    }
}
