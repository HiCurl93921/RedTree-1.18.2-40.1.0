package com.hal.redTree.event.entity.player;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nonnull;

@Cancelable
@Event.HasResult
public class RedPowderEvent extends PlayerEvent {
    private final Level world;
    private final BlockPos pos;
    private final BlockState blockState;
    private final ItemStack stack;

    /**
     * コンストラクタ
     * @param player 対象のプレイヤー情報
     * @param world ワールド情報
     * @param pos ターゲットブロックの座標
     * @param blockState ターゲットブロックの状態
     * @param stack アイテムスタック
     */
    public RedPowderEvent(@Nonnull Player player, @Nonnull Level world, @Nonnull BlockPos pos, @Nonnull BlockState blockState, @Nonnull ItemStack stack) {
        super(player);
        this.world = world;
        this.pos = pos;
        this.blockState = blockState;
        this.stack = stack;
    }

    public Level getWorld()
    {
        return world;
    }

    public BlockPos getPos()
    {
        return pos;
    }

    public BlockState getBlockState()
    {
        return blockState;
    }

    @Nonnull
    public ItemStack getStack()
    {
        return stack;
    }
}
