package com.hbm.explosion.vanillalike.interfaces;

import com.hbm.explosion.vanillalike.ExplosionVNT;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.HashSet;
public interface IBlockAllocator {
    HashSet<BlockPos> allocate(ExplosionVNT explosion, Level level, double x, double y, double z, float size);
}
