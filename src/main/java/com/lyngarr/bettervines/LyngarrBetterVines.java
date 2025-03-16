package com.lyngarr.bettervines;

import com.lyngarr.bettervines.blockentity.VineBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.BlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LyngarrBetterVines implements ModInitializer {
    public static final String MOD_ID = "lyngarrbettervines";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static BlockEntityType<VineBlockEntity> VINE_BLOCK_ENTITY;

    @Override
    public void onInitialize() {
        VINE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(MOD_ID, "vine_block_entity"),
            BlockEntityTypeBuilder.create(VineBlockEntity::new).build(null)
        );

        LOGGER.info("Lyngarr's Better Vines loaded.");
    }
}
