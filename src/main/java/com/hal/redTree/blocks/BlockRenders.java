package com.hal.redTree.blocks;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public class BlockRenders {
    private static final Map<Block, RenderType> BLOCK_RENDER_TYPES = Util.make(Maps.newHashMap(), (renderHashMap) -> {
        renderHashMap.put(Blocks.RED_TREE_SAPLING.get(), RenderType.cutout());
    });

    public static RenderType getRenderType(Block block) {
        return isRegistered(block) ? BLOCK_RENDER_TYPES.get(block) : RenderType.solid();
    }

    public static boolean isRegistered(Block block){
        return BLOCK_RENDER_TYPES.containsKey(block);
    }

}
