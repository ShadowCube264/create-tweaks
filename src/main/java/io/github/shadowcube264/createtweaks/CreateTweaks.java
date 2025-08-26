package io.github.shadowcube264.createtweaks;

import com.simibubi.create.Create;

import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.config.ModConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateTweaks implements ModInitializer {
	public static final String ID = "create-tweaks";
	public static final String NAME = "Create Tweaks";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
		LOGGER.info(EnvExecutor.unsafeRunForDist(
				() -> () -> "{} is accessing Porting Lib from the client!",
				() -> () -> "{} is accessing Porting Lib from the server!"
		), NAME);
		ForgeConfigRegistry.INSTANCE.register(ID, ModConfig.Type.COMMON, CreateTweaksConfig.CONFIG_SPEC);
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
