package io.github.shadowcube264.createtweaks.plugins;

import io.github.shadowcube264.createtweaks.CreateTweaks;
import io.github.shadowcube264.createtweaks.CreateTweaksConfig;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.IRecipeManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CreateTweaks.ID, "jei_plugin");
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        IRecipeManager recipeManager = jeiRuntime.getRecipeManager();
        if (!CreateTweaksConfig.enableBlasting.get()) {
            recipeManager.hideRecipeCategory(recipeManager.getRecipeType(new ResourceLocation("create", "fan_blasting")).get());
        }
        if (!CreateTweaksConfig.enableSmoking.get()) {
            recipeManager.hideRecipeCategory(recipeManager.getRecipeType(new ResourceLocation("create", "fan_smoking")).get());
        }
    }
    
}
