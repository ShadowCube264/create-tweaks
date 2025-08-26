package io.github.shadowcube264.createtweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import com.simibubi.create.compat.emi.CreateEmiPlugin;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import io.github.shadowcube264.createtweaks.CreateTweaksConfig;

@Mixin(value = CreateEmiPlugin.class, remap = false)
public abstract class EMIPluginMixin implements EmiPlugin {
    @Redirect(method = "register(Ldev/emi/emi/api/EmiRegistry;)V", at = @At(value = "INVOKE", target="Ldev/emi/emi/api/EmiRegistry;addRecipe(Ldev/emi/emi/api/recipe/EmiRecipe;)V"))
    private void cancelRecipeRegister(EmiRegistry registry, EmiRecipe recipe) {
        if (!(recipe.getCategory() == CreateEmiPlugin.FAN_BLASTING && !CreateTweaksConfig.enableBlasting.get()) && !(recipe.getCategory() == CreateEmiPlugin.FAN_SMOKING && !CreateTweaksConfig.enableSmoking.get())) {
            registry.addRecipe(recipe);
        }
    }
}
