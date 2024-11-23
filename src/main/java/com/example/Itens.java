package com.example;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Itens {

    public static Item COBRE_REFORCADO = RegistrarItem.registrarItemComum("cobre_reforcado");
    public static Item ESMERALDA_REFORCADO = RegistrarItem.registrarItemComum("esmeralda_reforcado");
    public static Item AMETISTA_REFORCADO = RegistrarItem.registrarItemComum("ametista_reforcado");
    public static Item FIO_ENCAPADO_VERDE = RegistrarItem.registrarItemComum("fio_encapado_verde");
    public static Item FIO_ENCAPADO_VERMELHO = RegistrarItem.registrarItemComum("fio_encapado_vermelho");


    public static Item BOTA_COBRE_REFORCADA = RegistrarItem.registrarUtilizavel("botas_cobre_reforcada", (settings) -> {
        return new ArmorItem(MateriaisArmadura.COBRE_REFORCADO, EquipmentType.BOOTS, settings);
    });
    public static Item BOTA_ESMERALDA_REFORCADA = RegistrarItem.registrarUtilizavel("botas_esmeralda_reforcada", (settings) -> {
        return new ArmorItem(MateriaisArmadura.ESMERALDA_REFORCADA, EquipmentType.BOOTS, settings);
    });
    public static Item BOTA_AMETISTA_REFORCADA = RegistrarItem.registrarUtilizavel("botas_ametista_reforcada", (settings) -> {
        return new ArmorItem(MateriaisArmadura.AMETISTA_REFORCADA, EquipmentType.BOOTS, settings);
    });

    public static final RegistryKey<ItemGroup> LOGICTHINKERING_GRUPO = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(ExampleMod.nomeMod, "logicthinkering"));
    public static final ItemGroup LOGICTHINKERING_ITEM_GRUPO = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.CRAFTER))
            .displayName(Text.translatable("Logic Thinkering"))
            .build();

    public static void Inicializa() {
        Registry.register(Registries.ITEM_GROUP, LOGICTHINKERING_GRUPO, LOGICTHINKERING_ITEM_GRUPO);
        ItemGroupEvents.modifyEntriesEvent(LOGICTHINKERING_GRUPO).register(itemGroup -> {
            itemGroup.add(COBRE_REFORCADO);
            itemGroup.add(ESMERALDA_REFORCADO);
            itemGroup.add(AMETISTA_REFORCADO);
            itemGroup.add(FIO_ENCAPADO_VERDE);
            itemGroup.add(FIO_ENCAPADO_VERMELHO);
            itemGroup.add(BOTA_COBRE_REFORCADA);
            itemGroup.add(BOTA_ESMERALDA_REFORCADA);
            itemGroup.add(BOTA_AMETISTA_REFORCADA);
        });
    }
}
