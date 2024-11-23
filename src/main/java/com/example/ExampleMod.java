package com.example;

import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "modid";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final String nomeMod = "logicthinkering";

	@Override
	public void onInitialize() {

		Itens.Inicializa();
		LOGGER.info("OK");
	}
}