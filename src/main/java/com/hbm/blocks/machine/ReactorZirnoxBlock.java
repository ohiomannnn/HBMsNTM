package com.hbm.blocks.machine;

import com.hbm.blockentity.ITickable;
import com.hbm.blockentity.ProxyComboBlockEntity;
import com.hbm.blockentity.machine.ReactorZirnoxBlockEntity;
import com.hbm.blocks.DummyBlockType;
import com.hbm.blocks.DummyableBlock;
import com.hbm.handler.MultiblockHandlerXR;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class ReactorZirnoxBlock extends DummyableBlock {

    public ReactorZirnoxBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        DummyBlockType type = state.getValue(TYPE);
        return switch(type) {
            case CORE -> new ReactorZirnoxBlockEntity(pos, state);
            case EXTRA -> new ProxyComboBlockEntity(pos, state).inventory().power().fluid();
            default -> null;
        };
    }

    @Override public int[] getDimensions() { return new int[] {1, 0, 2, 2, 2, 2,}; }
    @Override public int getOffset() { return 2; }

    public static final MapCodec<ReactorZirnoxBlock> CODEC = simpleCodec(ReactorZirnoxBlock::new);
    @Override protected MapCodec<ReactorZirnoxBlock> codec() { return CODEC; }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if(state.getValue(TYPE) != DummyBlockType.CORE) return null;
        return (lvl, pos, st, be) -> { if(be instanceof ITickable tickable) tickable.updateEntity(); };
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        return this.standardOpenBehavior(level, pos, player);
    }

    @Override
    protected boolean checkRequirement(Level level, BlockPos pos, Direction dir, int offset) {
        return super.checkRequirement(level, pos, dir, offset) &&
                MultiblockHandlerXR.checkSpace(level, pos.relative(dir, offset), new int[] {4, -2, 1, 1, 1, 1}, pos, dir) &&
                MultiblockHandlerXR.checkSpace(level, pos.relative(dir, offset), new int[] {4, -2, 0, 0, 2, -2}, pos, dir) &&
                MultiblockHandlerXR.checkSpace(level, pos.relative(dir, offset), new int[] {4, -2, 0, 0, -2, 2}, pos, dir);
    }

    @Override
    protected void fillSpace(Level level, BlockPos pos, Direction dir, int offset) {
        super.fillSpace(level, pos, dir, offset);

        MultiblockHandlerXR.fillSpace(level, pos.relative(dir, offset), new int[] {4, -2, 1, 1, 1, 1}, this, dir);
        MultiblockHandlerXR.fillSpace(level, pos.relative(dir, offset), new int[] {4, -2, 0, 0, 2, -2}, this, dir);
        MultiblockHandlerXR.fillSpace(level, pos.relative(dir, offset), new int[] {4, -2, 0, 0, -2, 2}, this, dir);

        Direction rot = dir.getClockWise(Axis.Y);
        int dxDir = dir.getStepX() * offset;
        int dzDir = dir.getStepZ() * offset;
        int dxRot = rot.getStepX() * 2;
        int dzRot = rot.getStepZ() * 2;
        this.makeExtra(level, pos.offset(dxDir + dxRot, 1, dzDir + dzRot));
        this.makeExtra(level, pos.offset(dxDir + dxRot, 3, dzDir + dzRot));
        this.makeExtra(level, pos.offset(dxDir - dxRot, 1, dzDir - dzRot));
        this.makeExtra(level, pos.offset(dxDir - dxRot, 3, dzDir - dzRot));
        //i still don't know why the ports were such an issue all those months ago
        this.makeExtra(level, pos.offset(dxDir, 4, dzDir));
    }
}
