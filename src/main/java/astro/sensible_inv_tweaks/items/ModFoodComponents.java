package astro.sensible_inv_tweaks.items;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent RAW_FLANK = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();
    public static final FoodComponent COOKED_FLANK = new FoodComponent.Builder().nutrition(8).saturationModifier(0.8F).build();
    public static final FoodComponent RAW_HAUNCH = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build();
    public static final FoodComponent COOKED_HAUNCH = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build();
    public static final FoodComponent RAW_FISH = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodComponent COOKED_FISH = new FoodComponent.Builder().nutrition(6).saturationModifier(0.8F).build();
}
