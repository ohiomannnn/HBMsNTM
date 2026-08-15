package com.hbm.blocks.machine;

import com.hbm.blockentity.ITickable;
import com.hbm.blockentity.ProxyComboBlockEntity;
import com.hbm.blockentity.machine.ChungusBlockEntity;
import com.hbm.blocks.DummyBlockType;
import com.hbm.blocks.DummyableBlock;
import com.hbm.blocks.ILookOverlay;
import com.hbm.blocks.ITooltipProvider;
import com.hbm.handler.MultiblockHandlerXR;
import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.inventory.fluid.tank.FluidTank;
import com.hbm.inventory.fluid.trait.FT_Coolable;
import com.hbm.registry.NtmSoundEvents;
import com.hbm.util.BobMathUtil;
import com.hbm.util.SoundUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderGuiEvent.Pre;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MachineChungusBlock extends DummyableBlock implements ITooltipProvider, ILookOverlay {

    public MachineChungusBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        DummyBlockType type = state.getValue(TYPE);
        return switch(type) {
            case CORE -> new ChungusBlockEntity(pos, state);
            case EXTRA -> new ProxyComboBlockEntity(pos, state).inventory().power().fluid();
            default -> null;
        };
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if(state.getValue(TYPE) != DummyBlockType.CORE) return null;
        return (lvl, pos, st, be) -> { if(be instanceof ITickable tickable) tickable.updateEntity(); };
    }

    public static final MapCodec<MachineChemicalPlantBlock> CODEC = simpleCodec(MachineChemicalPlantBlock::new);
    @Override public MapCodec<MachineChemicalPlantBlock> codec() { return CODEC; }

    @Override public int[] getDimensions() { return new int[] { 3, 0, 0, 3, 2, 2 }; }
    @Override public int getOffset() { return 3; }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        if(!player.isShiftKeyDown()) {
            BlockPos corePos = this.findCore(level, pos);
            if(corePos == null) return InteractionResult.FAIL;

            BlockEntity blockEntity = level.getBlockEntity(corePos);
            if(blockEntity instanceof ChungusBlockEntity be) {

                Direction dir = state.getValue(FACING);
                Direction turn = dir.getCounterClockWise(Axis.Y);

                BlockPos bePos = be.getBlockPos();

                int iX = bePos.getX() + dir.getStepX() + turn.getStepX() * 2;
                int iX2 = bePos.getX() + dir.getStepX() * 2 + turn.getStepX() * 2;
                int iZ = bePos.getZ() + dir.getStepZ() + turn.getStepZ() * 2;
                int iZ2 = bePos.getZ() + dir.getStepZ() * 2 + turn.getStepZ() * 2;

                if((pos.getX() == iX || pos.getX() == iX2) && (pos.getZ() == iZ || pos.getZ() == iZ2) && pos.getY() < bePos.getY() + 2) {

                    if(!level.isClientSide) {
                        if(!be.operational) {
                            SoundUtils.playAtVec3(level, Vec3.atCenterOf(pos), NtmSoundEvents.TURBINE_LEVER.get(), SoundSource.BLOCKS, 1.5F, 1F);
                            be.onLeverPull();
                        } else {
                            player.sendSystemMessage(Component.literal("Cannot change compressor setting while operational!").withStyle(ChatFormatting.RED));
                        }
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    protected void fillSpace(Level level, BlockPos pos, Direction dir, int offset) {
        super.fillSpace(level, pos, dir, offset);

        MultiblockHandlerXR.fillSpace(level, pos.relative(dir, offset), new int[] {4, -4, 0, 3, 1, 1}, this, dir);
        MultiblockHandlerXR.fillSpace(level, pos.relative(dir, offset), new int[] {3, 0, 6, -1, 1, 1}, this, dir);
        MultiblockHandlerXR.fillSpace(level, pos.relative(dir, offset), new int[] {2, 0, 10, -7, 1, 1}, this, dir);
        level.setBlock(pos.offset(dir.getStepX(), 2, dir.getStepZ()), this.createDummyState(dir), 3);

        this.makeExtra(level, pos.offset(dir.getStepX(), 2, dir.getStepZ())); //front connector
        this.makeExtra(level, pos.offset(dir.getStepX() * (offset - 10), 0, dir.getStepZ() * (offset - 10))); //back connector
        Direction side = dir.getClockWise(Axis.Y);
        this.makeExtra(level, pos.offset(dir.getStepX() * offset + side.getStepX() * 2, 0, dir.getStepZ() * offset + side.getStepZ() * 2)); //side connectors
        this.makeExtra(level, pos.offset(dir.getStepX() * offset - side.getStepX() * 2, 0, dir.getStepZ() * offset - side.getStepZ() * 2));
    }

    @Override
    protected boolean checkRequirement(Level level, BlockPos pos, Direction dir, int offset) {

        if(!MultiblockHandlerXR.checkSpace(level, pos.relative(dir, offset), this.getDimensions(), pos, dir)) return false;
        if(!MultiblockHandlerXR.checkSpace(level, pos.relative(dir, offset), new int[] {3, 0, 6, -1, 1, 1}, pos, dir)) return false;
        if(!MultiblockHandlerXR.checkSpace(level, pos.relative(dir, offset), new int[] {2, 0, 10, -7, 1, 1}, pos, dir)) return false;
        if(!level.getBlockState(pos.offset(dir.getStepX(), 2, dir.getStepZ())).canBeReplaced()) return false;

        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> components, TooltipFlag flag) {
        this.addStandardInfo(components);
    }

    @Override
    public void printHook(Pre event, Level level, BlockPos pos) {
        BlockPos corePos = this.findCore(level, pos);
        if(corePos == null) return;

        BlockEntity blockEntity = level.getBlockEntity(corePos);
        if(blockEntity instanceof ChungusBlockEntity be) {
            List<Component> text = new ArrayList<>();

            FluidTank tankInput = be.tanks[0];
            FluidTank tankOutput = be.tanks[1];

            FluidType inputType = tankInput.getTankType();
            FluidType outputType = Fluids.NONE;

            if(inputType.hasTrait(FT_Coolable.class)) outputType = inputType.getTrait(FT_Coolable.class).coolsTo;

            text.add(Component.literal("-> ").withStyle(ChatFormatting.DARK_GREEN).append(inputType.getName()).append(": " + String.format(Locale.US, "%,d", tankInput.getFill()) + "/" + String.format(Locale.US, "%,d", tankInput.getMaxFill()) + "mB").withStyle(ChatFormatting.RESET));
            text.add(Component.literal("<- ").withStyle(ChatFormatting.RED).append(outputType.getName()).append(": " + String.format(Locale.US, "%,d", tankOutput.getFill()) + "/" + String.format(Locale.US, "%,d", tankOutput.getMaxFill()) + "mB").withStyle(ChatFormatting.RESET));
            text.add(Component.literal("<- ").withStyle(ChatFormatting.RED).append(BobMathUtil.getShortNumber(be.powerBuffer) + "HE").withStyle(ChatFormatting.RESET));

            ILookOverlay.printGeneric(event, this.getName(), 0xffff00, 0x404000, text);
        }
    }
}
