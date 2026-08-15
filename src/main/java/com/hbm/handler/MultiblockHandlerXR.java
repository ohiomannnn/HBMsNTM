package com.hbm.handler;

import com.hbm.blocks.DummyBlockType;
import com.hbm.blocks.DummyableBlock;
import com.hbm.main.NuclearTechMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class MultiblockHandlerXR {

    //when looking north
    //											U  D  N  S  W  E
    public static int[] uni = 		new int[] { 3, 0, 4, 4, 4, 4 };

    public static boolean checkSpace(Level level, BlockPos corePos, int[] dim, BlockPos placedPos, Direction dir) {
        if(dim == null || dim.length != 6) return false;

        int count = 0;

        int[] rot = rotate(dim, dir);

        int x = corePos.getX();
        int y = corePos.getY();
        int z = corePos.getZ();

        for(int a = x - rot[4]; a <= x + rot[5]; a++) {
            for(int b = y - rot[1]; b <= y + rot[0]; b++) {
                for(int c = z - rot[2]; c <= z + rot[3]; c++) {
                    BlockPos checkPos = new BlockPos(a, b, c);

                    if(checkPos.equals(placedPos)) continue; //if the position matches the just placed block, the space counts as unoccupied

                    if(!level.getBlockState(checkPos).canBeReplaced()) return false;

                    count++;

                    if(count > 2000) {
                        NuclearTechMod.LOGGER.warn("checkspace: ded {} {} {} {} {} {}", a, b, c, x, y, z);
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void fillSpace(Level level, BlockPos corePos, int[] dim, Block block, Direction dir) {
        if(dim == null || dim.length != 6) return;

        int count = 0;

        int[] rot = rotate(dim, dir);

        int x = corePos.getX();
        int y = corePos.getY();
        int z = corePos.getZ();

        DummyableBlock.safeRem = true;

        for(int a = x - rot[4]; a <= x + rot[5]; a++) {
            for(int b = y - rot[1]; b <= y + rot[0]; b++) {
                for(int c = z - rot[2]; c <= z + rot[3]; c++) {

                    Direction facingDir;

                    if(b < y) {
                        facingDir = Direction.DOWN;
                    } else if(b > y) {
                        facingDir = Direction.UP;
                    } else if(a < x) {
                        facingDir = Direction.WEST;
                    } else if(a > x) {
                        facingDir = Direction.EAST;
                    } else if(c < z) {
                        facingDir = Direction.NORTH;
                    } else if(c > z) {
                        facingDir = Direction.SOUTH;
                    } else {
                        continue;
                    }

                    BlockPos dummyPos = new BlockPos(a, b, c);
                    BlockState dummyState = block.defaultBlockState().setValue(DummyableBlock.FACING, facingDir).setValue(DummyableBlock.TYPE, DummyBlockType.DUMMY);

                    level.setBlock(dummyPos, dummyState, 3);

                    count++;

                    if(count > 2000) {
                        NuclearTechMod.LOGGER.warn("fillspace: ded {} {} {} {} {} {}", a, b, c, x, y, z);

                        DummyableBlock.safeRem = false;
                        return;
                    }
                }
            }
        }

        DummyableBlock.safeRem = false;
    }

    @Nullable
    public static int[] rotate(@Nullable int[] dim, Direction dir) {

        if(dim == null) return null;

        if(dir == Direction.SOUTH) return dim;
        if(dir == Direction.NORTH) {
            //                 U       D       N       S       W       E
            return new int[] { dim[0], dim[1], dim[3], dim[2], dim[5], dim[4] };
        }
        if(dir == Direction.EAST) {
            //                 U       D       N       S       W       E
            return new int[] { dim[0], dim[1], dim[5], dim[4], dim[2], dim[3] };
        }
        if(dir == Direction.WEST) {
            //                 U       D       N       S       W       E
            return new int[] { dim[0], dim[1], dim[4], dim[5], dim[3], dim[2] };
        }

        return dim;
    }
}