package com.example.smalleroffhand;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

public class SmallerOffhandMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register the render callback
        RenderTickCallback.EVENT.register(this::onRenderTick);
    }

    // This function will be called every frame
    private void onRenderTick(float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        ItemStack offhandItem = client.player.getOffHandStack();
        
        if (!offhandItem.isEmpty()) {
            // Reduce the scale of the item in the offhand
            renderSmallerOffhand(client, offhandItem, tickDelta);
        }
    }

    // Method to render the offhand item 5 times smaller
    private void renderSmallerOffhand(MinecraftClient client, ItemStack itemStack, float tickDelta) {
        // Get the position to render the offhand item
        int width = client.getWindow().getWidth();
        int height = client.getWindow().getHeight();
        
        float scale = 0.2f; // 5 times smaller
        
        // Start transformation
        MatrixStack matrixStack = new MatrixStack();
        matrixStack.translate(width / 2, height / 2, 0); // Center screen
        matrixStack.scale(scale, scale, scale);
        
        // Adjust position for offhand (left side of screen)
        matrixStack.translate(-width / 2 + 50, height / 2 - 50, 0); // adjust as necessary for your needs
        
        RenderSystem.pushMatrix();
        // Here we are using Minecraft’s existing rendering system to draw the offhand item
        client.getItemRenderer().renderItem(itemStack, client.player, client.options.getCamera(), 0, matrixStack, 0xF000F0, 0xF000F0);
        RenderSystem.popMatrix();
    }
}
