package com.example;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Itens {

    public static Item COBRE_REFORCADO = Utilidades.registrarItem("cobre_reforcado");
    public static Item ESMERALDA_REFORCADO = Utilidades.registrarItem("esmeralda_reforcado");
    public static Item AMETISTA_REFORCADO = Utilidades.registrarItem("ametista_reforcado");
    public static Item FIO_ENCAPADO_VERDE = Utilidades.registrarItem("fio_encapado_verde");
    public static Item FIO_ENCAPADO_VERMELHO = Utilidades.registrarItem("fio_encapado_vermelho");

    public static final RegistryKey<ItemGroup> LOGICTHINKERING_GRUPO = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Utilidades.nomeMod, "logicthinkering"));
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
        });
    }
}
