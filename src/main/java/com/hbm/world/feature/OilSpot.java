package com.hbm.world.feature;

import com.hbm.blocks.NtmBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;

public class OilSpot {

    public static void generateOilSpot(LevelAccessor level, int x, int z, int width, int count, boolean addWillows) {
        RandomSource random = level.getRandom();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for(int i = 0; i < count; i++) {
            int rX = x + (int) (random.nextGaussian() * width);
            int rZ = z + (int) (random.nextGaussian() * width);
            int rY = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, rX, rZ);

            for(int y = rY; y > rY - 4 && y > level.getMinBuildHeight(); y--) {
                BlockPos belowPos = new BlockPos(rX, y - 1, rZ);
                BlockState belowState = level.getBlockState(belowPos);

                pos.set(rX, y, rZ);
                BlockState groundState = level.getBlockState(pos);

                if(groundState.is(BlockTags.LEAVES)) {
                    level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                    break;
                }

                if(!belowState.isFaceSturdy(level, belowPos, Direction.UP)) continue;

                if(groundState.is(Blocks.GRASS_BLOCK) || groundState.is(Blocks.DIRT)) {
                    level.setBlock(pos, random.nextInt(10) == 0 ? NtmBlocks.DIRT_OILY.get().defaultBlockState() : NtmBlocks.DIRT_DEAD.get().defaultBlockState(), 3);
                    if(addWillows && random.nextInt(50) == 0) {
                        BlockPos above = pos.above();
                        if(level.getBlockState(above).canBeReplaced()) {
                            level.setBlock(above, Blocks.DEAD_BUSH.defaultBlockState(), 3);
                        }
                    }
                    break;
                }
                if(groundState.is(Blocks.SAND) || groundState.is(Blocks.RED_SAND) || groundState.is(NtmBlocks.ORE_OIL_SAND.get())) {
                    level.setBlock(pos, groundState.is(Blocks.RED_SAND) ? NtmBlocks.SAND_RED_OILY.get().defaultBlockState() : NtmBlocks.SAND_OILY.get().defaultBlockState(), 3);
                    break;
                }
                if(groundState.is(Blocks.STONE)) {
                    level.setBlock(pos, NtmBlocks.STONE_CRACKED.get().defaultBlockState(), 3);
                    break;
                }
            }
        }
    }
}
