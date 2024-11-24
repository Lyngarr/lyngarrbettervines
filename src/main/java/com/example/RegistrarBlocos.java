package com.example;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class RegistrarBlocos {

    private static final String nomeMod = "logicthinkering";

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(nomeMod, id));
    }

    public static Block register(Block bloco, String nome, boolean deveRegistrarComoItem){
        Identifier id = Identifier.of(nomeMod, nome);

        if(deveRegistrarComoItem){
            BlockItem blockItem = new BlockItem(bloco, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }
        return Registry.register(Registries.BLOCK, id, bloco);
    }

   private static Block registrarBloco(Block bloco, String nome, boolean deveRegistrarComoItem){
        return register(bloco, nome, deveRegistrarComoItem);
    }
}
