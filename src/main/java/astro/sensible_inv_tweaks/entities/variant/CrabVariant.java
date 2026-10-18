package astro.sensible_inv_tweaks.entities.variant;

import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.random.Random;

public enum CrabVariant implements StringIdentifiable {
    RED(0, "red"),
    BLUE(1, "blue"),
    GREEN(2, "green"),
    YELLOW(3, "yellow"),
    PURPLE(4, "purple"),
    PINK(5, "pink"),
    VAMPIRE(6, "vampire");

    private final int id;
    private final String name;

    public static CrabVariant getCrabVariant(Random random) {
        int chance = random.nextInt(1000);
        if (chance < 1) {
            return VAMPIRE; // 0.1% chance
        } else if (chance < 25) {
            return PINK;       // 2.5% chance
        } else if (chance < 50) {
            return PURPLE;       // 5% chance
        } else if (chance < 100) {
            return YELLOW;       // 10% chance
        } else if (chance < 250) {
            return GREEN;       // 25% chance
        } else if (chance < 500) {
            return BLUE;       // 50% chance
        } else {
            return RED;    // Remaining 50% chance
        }
    }

    CrabVariant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public static CrabVariant byId(int id) {
        for (CrabVariant variant : values()) {
            if (variant.id == id) {
                return variant;
            }
        }
        return RED;
    }

    @Override
    public String asString() {
        return name;
    }
}
