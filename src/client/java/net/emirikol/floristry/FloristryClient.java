package net.emirikol.floristry;

import net.emirikol.floristry.block.FloristryBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class FloristryClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(FloristryBlocks.HERMIT_PURPLE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(FloristryBlocks.MOONFLOWER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(FloristryBlocks.WITHER_BUSH, RenderLayer.getCutout());
	}
}
