package com.alien;

import com.alien.blocks.RegisterBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class AlienClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), RegisterBlocks.neomorphEggSack);
        Alien.LOGGER.info("Set cutout correctly!!!");
    }
}
