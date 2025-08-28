package io.github.shadowcube264.createtweaks.plugins;

import com.simibubi.create.compat.rei.category.FanSmokingCategory;
import com.simibubi.create.compat.rei.category.FanBlastingCategory;

import dev.architectury.event.EventResult;
import io.github.shadowcube264.createtweaks.CreateTweaksConfig;
import me.shedaniel.rei.api.client.registry.category.visibility.CategoryVisibilityPredicate;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;

public class REISmeltPredicate implements CategoryVisibilityPredicate {
    
    @Override
    public EventResult handleCategory(DisplayCategory<?> category) {
        if (category instanceof FanBlastingCategory && !CreateTweaksConfig.enableBlasting.get()) {
            return EventResult.interruptFalse();
        }
        if (category instanceof FanSmokingCategory && !CreateTweaksConfig.enableSmoking.get()) {
            return EventResult.interruptFalse();
        }
        return EventResult.pass();
    }
}
