package com.hbm.blocks.machine;

import com.hbm.blockentity.ITickable;
import com.hbm.blockentity.ProxyComboBlockEntity;
import com.hbm.blockentity.machine.ReactorZirnoxBlockEntity;
import com.hbm.blockentity.machine.ZirnoxDestroyedBlockEntity;
import com.hbm.blocks.DummyBlockType;
import com.hbm.blocks.DummyableBlock;
import com.hbm.blocks.NtmBlocks;
import com.hbm.particle.NtmParticleTypes;
import com.hbm.particle.vanilla.NbtParticleOptions;
import com.hbm.util.SoundUtils;
import com.hbm.util.particle.ParticleUtil;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class ZirnoxDestroyedBlock extends DummyableBlock {

    public ZirnoxDestroyedBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        DummyBlockType type = state.getValue(TYPE);
        return switch(type) {
            case CORE -> new ZirnoxDestroyedBlockEntity(pos, state);
            case EXTRA -> new ProxyComboBlockEntity(pos, state).inventory().power().fluid();
            default -> null;
        };
    }

    @Override public int[] getDimensions() { return new int[] {1, 0, 2, 2, 2, 2,}; }
    @Override public int getOffset() { return 2; }

    public static final MapCodec<ZirnoxDestroyedBlock> CODEC = simpleCodec(ZirnoxDestroyedBlock::new);
    @Override protected MapCodec<ZirnoxDestroyedBlock> codec() { return CODEC; }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if(state.getValue(TYPE) != DummyBlockType.CORE) return null;
        return (lvl, pos, st, be) -> { if(be instanceof ITickable tickable) tickable.updateEntity(); };
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {

        BlockPos posAbove = pos.above();
        BlockState stateAbove = level.getBlockState(posAbove);

        if(stateAbove.isAir()) {
            if(random.nextInt(10) == 0) level.setBlock(posAbove, NtmBlocks.GAS_MELTDOWN.get().defaultBlockState(), 3);
        }

        if(random.nextInt(10) == 0 && stateAbove.isAir()) {
            level.setBlock(posAbove, NtmBlocks.GAS_MELTDOWN.get().defaultBlockState(), 3);
        }

        level.scheduleTick(pos, this, 100 + level.random.nextInt(20));
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);

        if(!level.isClientSide) {
            if(level.random.nextInt(4) == 0) {
                CompoundTag tag = new CompoundTag();
                tag.putInt("lifetime", 90);
                ParticleUtil.addParticle(level, new NbtParticleOptions(NtmParticleTypes.RBMK_FLAME.get(), tag), pos.getX() + 0.25 + level.random.nextDouble() * 0.5, pos.getY() + 1.75, pos.getZ() + 0.25 + level.random.nextDouble() * 0.5);
                SoundUtils.playAtVec3(level, Vec3.atCenterOf(pos), SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F + level.random.nextFloat(), level.random.nextFloat() * 0.7F + 0.3F);
            }
        }

        level.scheduleTick(pos, this, 100 + level.random.nextInt(20));
    }
}
