package com.hal.redTree.blocks;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public class BlockColors {
    private static final Map<Block, BlockColor> BLOCK_COLORS
            = Util.make(Maps.newHashMap(), (colorHashMap) -> {
        colorHashMap.put(Blocks.RED_TREE_LEAVES.get(), (blockState, blockDisplayReader, blockPos, colorNumber) -> { return 16711680; });
    });

    public static BlockColor getBlockColor(Block block) {
        return isRegisteredColor(block) ? BLOCK_COLORS.get(block) : getDefault();
    }

    /**
     * ブロックカラーに登録されているブロックかどうかを判定します。
     * @param block 判定するブロック
     * @return 登録されているブロックの場合trueを返します。
     */
    public static boolean isRegisteredColor(Block block) {
        return BLOCK_COLORS.containsKey(block);
    }

    private static BlockColor getDefault() {
        return (blockState, blockDisplayReader, blockPos, colorNum) -> {return -1;};
    }
}
