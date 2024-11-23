package com.example;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentModels;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;

public interface MateriaisArmadura {

    ArmorMaterial COBRE_REFORCADO = new ArmorMaterial(5, Util.make(new EnumMap<>(EquipmentType.class), (map) -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 5);
        map.put(EquipmentType.CHESTPLATE, 7);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 10);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, ItemTags.REPAIRS_LEATHER_ARMOR, EquipmentModels.LEATHER);

    ArmorMaterial ESMERALDA_REFORCADA = new ArmorMaterial(37, Util.make(new EnumMap<>(EquipmentType.class), (map) -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 11);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F, 0.1F, ItemTags.REPAIRS_GOLD_ARMOR, EquipmentModels.GOLD);

    ArmorMaterial AMETISTA_REFORCADA = new ArmorMaterial(37, Util.make(new EnumMap<>(EquipmentType.class), (map) -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 11);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.REPAIRS_NETHERITE_ARMOR, EquipmentModels.NETHERITE);

}
