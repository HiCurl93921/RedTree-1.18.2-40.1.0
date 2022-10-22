package com.hal.redTree;

import com.hal.redTree.blocks.Blocks;
import com.hal.redTree.items.CreativeTab;
import com.hal.redTree.items.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RedTree.MOD_ID)
public class RedTree {
    public static final String MOD_ID = "redtreemod";
    public static final CreativeTab TAB = new CreativeTab(MOD_ID);

    /**
     * コンストラクタ
     */
    public RedTree() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // ブロック登録
        Blocks.register(modEventBus);

        // アイテム登録
        Items.register(modEventBus);
    }
}
