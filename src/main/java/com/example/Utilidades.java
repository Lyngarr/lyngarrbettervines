package com.example;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Utilidades {

    public static final String nomeMod = "logicthinkering";

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(nomeMod, id));
    }

    private static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = (Item)factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        return Registry.register(Registries.ITEM, key, item);
    }

    public static Item registrarItem(String id) {
        return register(keyOf(id), Item::new, new Item.Settings());
    }

}
