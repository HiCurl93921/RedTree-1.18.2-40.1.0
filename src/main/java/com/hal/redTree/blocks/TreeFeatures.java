package com.hal.redTree.blocks;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class TreeFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> RED_TREE
            = FeatureUtils.register("red_tree", Feature.TREE, createRedTree().build());

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block logBlock, Block leavesBlock, int baseHeight, int heightRandA, int heightRandB, int intProviderValue) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(logBlock),
                new StraightTrunkPlacer(baseHeight, heightRandA, heightRandB),
                BlockStateProvider.simple(leavesBlock),
                new BlobFoliagePlacer(ConstantInt.of(intProviderValue), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createRedTree() {
        return createStraightBlobTree(Blocks.RED_TREE_LOG.get(),
                Blocks.RED_TREE_LEAVES.get(),
                4, 2, 0, 2)
                .ignoreVines();
    }
}
