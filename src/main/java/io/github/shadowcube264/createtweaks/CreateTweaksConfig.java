package io.github.shadowcube264.createtweaks;

import net.minecraftforge.common.ForgeConfigSpec;

public class CreateTweaksConfig {
    public static final ForgeConfigSpec CONFIG_SPEC;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setup(configBuilder);
        CONFIG_SPEC = configBuilder.build();
    }

    public static ForgeConfigSpec.BooleanValue enableBlasting;
    public static ForgeConfigSpec.BooleanValue enableSmoking;

    private static void setup(ForgeConfigSpec.Builder builder) {
        builder.push("fans");
        enableBlasting = builder
            .comment("Set to false to disable bulk blasting with fans (most smelting recipes).")
            .define("enableBlasting", true);
        enableSmoking = builder
            .comment("Set to false to disable bulk smoking with fans (food cooking recipes).")
            .define("enableSmoking", true);
        builder.pop();
    }
}
