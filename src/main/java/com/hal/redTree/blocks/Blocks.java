package com.hal.redTree.blocks;

import com.hal.redTree.RedTree;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

@Mod.EventBusSubscriber(modid = RedTree.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Blocks {
    private static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, RedTree.MOD_ID);

    /**
     * レッドツリーの苗木
     */
    public static final RegistryObject<Block> RED_TREE_SAPLING
            = BLOCKS.register("red_tree_sapling",
            () -> new SaplingBlock(new RedTreeGrower(),
                    BlockBehaviour
                            .Properties
                            .of(Material.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.GRASS)));

    /**
     * レッドツリーの原木
     */
    public static final RegistryObject<Block> RED_TREE_LOG
            = BLOCKS.register("red_tree_log",
            () -> log(MaterialColor.COLOR_RED, MaterialColor.COLOR_RED));

    /**
     * レッドツリーの葉
     */
    public static final RegistryObject<Block> RED_TREE_LEAVES
            = BLOCKS.register("red_tree_leaves",
            () -> leaves(SoundType.GRASS));

    /**
     * ブロックを登録します。
     * @param eventBus MODイベントバス
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    /**
     * 登録されているブロック群を取得します。
     * @return ブロック群
     */
    public static Collection<RegistryObject<Block>> getEntries() {
        return BLOCKS.getEntries();
    }

    @SubscribeEvent
    public static void registerBlockRenders(RegistryEvent.Register<Block> event) {
        for (RegistryObject<Block> registryObject : getEntries()) {
            Block block = registryObject.get();

            ItemBlockRenderTypes.setRenderLayer(block, BlockRenders.getRenderType(block));
        }
    }

    /**
     * ブロックカラーを登録します。
     */
    @SubscribeEvent
    public static void registerBlockColors(ColorHandlerEvent.Block event) {
        event.getBlockColors().register(BlockColors.getBlockColor(RED_TREE_LEAVES.get()), RED_TREE_LEAVES.get());
    }

    /**
     * 原木ブロックのインスタンスを生成します。
     * @param topMaterialColor 上面のマテリアルカラー
     * @param sideMaterialColor 側面のマテリアルカラー
     * @return 原木ブロックインスタンス
     */
    private static RotatedPillarBlock log(MaterialColor topMaterialColor, MaterialColor sideMaterialColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor;
        }).strength(2.0F).sound(SoundType.WOOD));
    }

    /**
     * 葉っぱブロックのインスタンスを生成します。
     * @param soundType サウンドタイプ
     * @return 葉っぱブロックインスタンス
     */
    private static LeavesBlock leaves(@NotNull SoundType soundType) {
        return new LeavesBlock(BlockBehaviour
                .Properties
                .of(Material.LEAVES)
                .strength(0.2F)
                .randomTicks()
                .sound(soundType)
                .noOcclusion()
                .isValidSpawn(Blocks::ocelotOrParrot)
                .isSuffocating(Blocks::never)
                .isViewBlocking(Blocks::never));
    }

    /**
     * ヤマネコもしくはオウムかどうかを判定します。
     * @param blockState ブロック状態
     * @param blockGetter ブロック取得
     * @param blockPos ブロック位置
     * @param entity エンティティタイプ
     * @return ヤマネコもしくはオウムであればtrueを返します。
     */
    private static Boolean ocelotOrParrot(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }
}
