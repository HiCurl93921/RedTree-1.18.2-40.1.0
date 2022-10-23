package com.hal.redTree.event;

import com.hal.redTree.event.entity.player.RedPowderEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nonnull;

public class RedTreeEventFactory {
    public static int onApplyRedPowder(@Nonnull Player player, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull ItemStack stack)
    {
        RedPowderEvent event = new RedPowderEvent(player, level, pos, state, stack);
        if (MinecraftForge.EVENT_BUS.post(event)) return -1;
        if (event.getResult() == Event.Result.ALLOW)
        {
            if (!level.isClientSide)
                stack.shrink(1);
            return 1;
        }
        return 0;
    }
}
