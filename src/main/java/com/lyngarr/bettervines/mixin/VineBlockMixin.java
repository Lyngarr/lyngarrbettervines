package com.lyngarr.bettervines.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(VineBlock.class)
public class VineBlockMixin {
    @Unique
    private static final IntProperty AGE = IntProperty.of("age", 0, 25);

    @Inject(method = "appendProperties", at = @At("TAIL"))
    private void addAgeProperty(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(AGE);
    }

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    private void modifyGrowth(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        int age = state.get(AGE);
        
        if (age >= 25) {
            ci.cancel(); // Stop growth if max age is reached
        } else {
            world.setBlockState(pos, state.with(AGE, age + 1), 2);
        }
    }
}
