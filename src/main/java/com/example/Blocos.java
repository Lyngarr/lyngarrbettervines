package com.example;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Blocos {
    public static Block BLOCO_CONDENSED_DIRT = RegistrarBlocos.register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS)),
            "bloco_condensed_dirt",
            true
    );
    public static Block BLOCO_CONDENSED_OAK_LOG = RegistrarBlocos.register(
            new PillarBlock(
                    AbstractBlock.Settings.create()
                            .sounds(BlockSoundGroup.WOOD)
            ), "bloco_condensed_oak_log", true
    );

    public static final RegistryKey<ItemGroup> LOGICTHINKERING_GRUPO = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(ExampleMod.nomeMod, "logicthinkering"));
    public static final ItemGroup LOGICTHINKERING_ITEM_GRUPO = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.CRAFTER))
            .displayName(Text.translatable("Logic Thinkering"))
            .build();

    public static void Inicializa() {
        Registry.register(Registries.ITEM_GROUP, LOGICTHINKERING_GRUPO, LOGICTHINKERING_ITEM_GRUPO);
        ItemGroupEvents.modifyEntriesEvent(LOGICTHINKERING_GRUPO).register(itemGroup -> {
            itemGroup.add(BLOCO_CONDENSED_DIRT);
            itemGroup.add(BLOCO_CONDENSED_OAK_LOG);
        });
    }
}