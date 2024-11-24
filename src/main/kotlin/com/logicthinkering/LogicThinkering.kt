package com.logicthinkering

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object LogicThinkering : ModInitializer {
    const val MOD_ID = "logic-thinkering"
    val logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        logger.info("Initializing Logic Thinkering mod!")
        registerItems()
        ModComponents.initialize()
    }
}
