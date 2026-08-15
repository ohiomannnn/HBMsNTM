package com.hbm.items.tools;

import com.hbm.blockentity.machine.ReactorZirnoxBlockEntity;
import com.hbm.blocks.machine.ReactorZirnoxBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

public class DyatlovItem extends Item {

    public DyatlovItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();

        if(!level.isClientSide) {
            Block block = level.getBlockState(pos).getBlock();

            if(block instanceof ReactorZirnoxBlock zirnox) {
                BlockPos corePos = zirnox.findCore(level, pos);

                if(corePos != null) {
                    BlockEntity be = level.getBlockEntity(corePos);
                    if(be instanceof ReactorZirnoxBlockEntity zirnoxBlockEntity) zirnoxBlockEntity.heat = 200000;
                }
            }
        }

        return InteractionResult.PASS;
    }
}
