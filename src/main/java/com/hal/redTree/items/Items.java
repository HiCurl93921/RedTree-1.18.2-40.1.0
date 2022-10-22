package com.hal.redTree.items;

import com.hal.redTree.RedTree;
import com.hal.redTree.blocks.Blocks;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    private static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, RedTree.MOD_ID);

    /**
     * レッドツリーの苗木アイテム
     */
    public static final RegistryObject<Item> RED_TREE_SAPLING
            = ITEMS.register("red_tree_sapling",
            () -> new RedTreeSaplingItem(Blocks.RED_TREE_SAPLING.get(),
                    new Item.Properties().tab(RedTree.TAB)));
    /**
     * レッドツリーの苗木アイテム
     */
    public static final RegistryObject<Item> RED_TREE_LOG
            = ITEMS.register("red_tree_log",
            () -> new RedTreeSaplingItem(Blocks.RED_TREE_LOG.get(),
                    new Item.Properties().tab(RedTree.TAB)));

    /**
     * レッドツリーの苗木アイテム
     */
    public static final RegistryObject<Item> RED_TREE_LEAVES
            = ITEMS.register("red_tree_leaves",
            () -> new RedTreeSaplingItem(Blocks.RED_TREE_LEAVES.get(),
                    new Item.Properties().tab(RedTree.TAB)));

    /**
     * レッドパウダーアイテム
     */
    public static final RegistryObject<Item> RED_POWDER
            = ITEMS.register("red_powder",
            () -> new RedPowderItem((new Item.Properties().tab(RedTree.TAB))));

    /**
     * アイテム登録
     * @param eventBus MODイベントバス
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}