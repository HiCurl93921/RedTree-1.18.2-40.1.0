package com.hal.redTree.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTab extends CreativeModeTab {

    public CreativeTab(String modId) {
        super(modId);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.RED_TREE_SAPLING.get());
    }
}
