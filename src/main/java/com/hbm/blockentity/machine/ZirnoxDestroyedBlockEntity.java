package com.hbm.blockentity.machine;

import com.hbm.blockentity.ITickable;
import com.hbm.blockentity.NtmBlockEntityTypes;
import com.hbm.particle.NtmParticleTypes;
import com.hbm.particle.vanilla.NbtParticleOptions;
import com.hbm.util.SoundUtils;
import com.hbm.util.particle.ParticleUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class ZirnoxDestroyedBlockEntity extends BlockEntity implements ITickable {

    public boolean onFire = true;

    public ZirnoxDestroyedBlockEntity(BlockPos pos, BlockState state) {
        super(NtmBlockEntityTypes.ZIRNOX_DESTROYED.get(), pos, state);
    }

    @Override
    public void updateEntity() {
        if(this.level == null) return;

        if(!this.level.isClientSide) {

            if(this.level.random.nextInt(5000) == 0) onFire = false;

            if(this.onFire && this.level.getGameTime() % 50 == 0) {
                BlockPos pos = this.getBlockPos();
                CompoundTag tag = new CompoundTag();
                tag.putInt("lifetime", 90);
                ParticleUtil.addParticle(level, new NbtParticleOptions(NtmParticleTypes.RBMK_FLAME.get(), tag), pos.getX() + 0.25 + level.random.nextDouble() * 0.5, pos.getY() + 1.75, pos.getZ() + 0.25 + level.random.nextDouble() * 0.5);
                SoundUtils.playAtVec3(level, Vec3.atCenterOf(pos), SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F + level.random.nextFloat(), level.random.nextFloat() * 0.7F + 0.3F);
            }
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, Provider registries) {
        super.loadAdditional(tag, registries);

        this.onFire = tag.getBoolean("fire");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, Provider registries) {
        super.saveAdditional(tag, registries);

        tag.putBoolean("onFire", this.onFire);
    }
}
