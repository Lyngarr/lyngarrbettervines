package com.lyngarr.bettervines.blockentity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.random.Random;


public class VineBlockEntity extends BlockEntity {
    private int maxHeight = Random.create().nextBetween(5, 15); // Hauteur aléatoire
    private int maxWidth = Random.create().nextBetween(3, 6); // Largeur aléatoire

    public VineBlockEntity() {
        super(ModBlockEntities.VINE_BLOCK_ENTITY); // On l’enregistre (voir plus bas)
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.maxHeight = nbt.getInt("MaxHeight");
        this.maxWidth = nbt.getInt("MaxWidth");
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("MaxHeight", maxHeight);
        nbt.putInt("MaxWidth", maxWidth);
    }
}
