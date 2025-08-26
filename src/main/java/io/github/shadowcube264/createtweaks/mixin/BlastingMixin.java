package io.github.shadowcube264.createtweaks.mixin;

import com.simibubi.create.content.kinetics.fan.processing.AllFanProcessingTypes;

import io.github.shadowcube264.createtweaks.CreateTweaksConfig;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AllFanProcessingTypes.BlastingType.class)
public abstract class BlastingMixin {

	@Inject(method = "canProcess", at = @At("HEAD"), cancellable = true)
	private void cancelProcessing(CallbackInfoReturnable<Boolean> ci) {
		if (!CreateTweaksConfig.enableBlasting.get()) {
			ci.setReturnValue(false);
		}
	}
}
