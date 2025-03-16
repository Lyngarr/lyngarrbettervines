package com.lyngarr.bettervines.mixin;

import com.lyngarr.bettervines.blockentity.VineBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VineBlock.class)
public class VineBlockMixin {
    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    private void onRandomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        BlockEntity entity = world.getBlockEntity(pos);
        if (!(entity instanceof VineBlockEntity vineEntity)) {
            return; // Si ce n'est pas notre BlockEntity, on ne fait rien
        }

        int maxHeight = vineEntity.getMaxHeight();
        int maxWidth = vineEntity.getMaxWidth();

        int vineHeight = 1;  
        int vineWidth = 1;

        // Vérification hauteur (haut et bas)
        BlockPos checkPos = pos.down();
        while (vineHeight < maxHeight && world.getBlockState(checkPos).getBlock() instanceof VineBlock) {
            vineHeight++;
            checkPos = checkPos.down();
        }
        checkPos = pos.up();
        while (vineHeight < maxHeight && world.getBlockState(checkPos).getBlock() instanceof VineBlock) {
            vineHeight++;
            checkPos = checkPos.up();
        }

        // Vérification largeur (gauche et droite)
        for (int dx = -maxWidth; dx <= maxWidth; dx++) {
            BlockPos lateralPos = pos.add(dx, 0, 0);
            if (world.getBlockState(lateralPos).getBlock() instanceof VineBlock) {
                vineWidth++;
            }
        }

        // Stop la croissance si la hauteur ou la largeur dépasse les limites
        if (vineHeight >= maxHeight || vineWidth >= maxWidth) {
            ci.cancel();
        }
    }
}
