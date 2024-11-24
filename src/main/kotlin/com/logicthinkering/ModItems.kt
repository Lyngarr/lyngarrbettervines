package com.logicthinkering

import com.logicthinkering.LogicThinkering.MOD_ID
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

val REINFORCED_COPPER_SHIELD = ReinforcedCopperShield()
val REINFORCED_COPPER_SWORD = ReinforcedCopperSword()

fun registerItems() {
    registerItem(REINFORCED_COPPER_SHIELD, "reinforced_copper_shield")
    registerItem(REINFORCED_COPPER_SWORD, "reinforced_copper_sword")

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register { entries ->
        entries.add(REINFORCED_COPPER_SWORD)
        entries.add(REINFORCED_COPPER_SHIELD)
    }
}

private fun registerItem(item: Item, id: String): Item {
    return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, id), item)
}
