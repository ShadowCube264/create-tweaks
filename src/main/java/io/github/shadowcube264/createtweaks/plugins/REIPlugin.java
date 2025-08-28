package io.github.shadowcube264.createtweaks.plugins;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;

public class REIPlugin implements REIClientPlugin {
    
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.registerVisibilityPredicate(new REISmeltPredicate());
    }
}
