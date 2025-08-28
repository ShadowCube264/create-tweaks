package io.github.shadowcube264.createtweaks.plugins;

import java.util.function.Predicate;

import com.simibubi.create.compat.emi.CreateEmiPlugin;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import io.github.shadowcube264.createtweaks.CreateTweaksConfig;

public class EMIPlugin implements EmiPlugin {
    
    @Override
    public void register(EmiRegistry registry) {
        Predicate<EmiRecipe> checkDisabled = r
            -> (r.getCategory() == CreateEmiPlugin.FAN_BLASTING && !CreateTweaksConfig.enableBlasting.get())
            || (r.getCategory() == CreateEmiPlugin.FAN_SMOKING && !CreateTweaksConfig.enableSmoking.get());
        registry.removeRecipes(checkDisabled);
    }
}
