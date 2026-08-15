package com.hbm.blockentity.machine.heater;

import api.hbm.fluidmk2.IFluidStandardTransceiverMK2;
import com.hbm.blockentity.IFluidCopiable;
import com.hbm.blockentity.NtmBlockEntityTypes;
import com.hbm.interfaces.IControlReceiver;
import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.inventory.fluid.tank.FluidTank;
import com.hbm.inventory.fluid.trait.FT_Coolable;
import com.hbm.inventory.fluid.trait.FT_Coolable.CoolingType;
import com.hbm.items.machine.IItemFluidIdentifier;
import com.hbm.util.fauxpointtwelve.DirPos;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class HeaterHeatexBlockEntity extends AbstractHeaterMachineBlockEntity implements IFluidStandardTransceiverMK2, IControlReceiver, IFluidCopiable {

    public int amountToCool = 24_000;
    public int tickDelay = 1;
    public boolean converted = true;

    public final FluidTank[] tanks = new FluidTank[] {
            new FluidTank(Fluids.NONE, 24_000),
            new FluidTank(Fluids.NONE, 24_000)
    };

    public HeaterHeatexBlockEntity(BlockPos pos, BlockState state) {
        super(NtmBlockEntityTypes.HEATER_HEATEX.get(), pos, state, 1);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.heaterHeatex");
    }

    @Override
    protected int getMaxHeat() {
        return 12_800_000;
    }

    @Override
    protected int getRenderHeight() {
        return 1;
    }

    public DirPos[] getConPos() {
        Direction facing = this.getBlockState().getValue(com.hbm.blocks.DummyableBlock.FACING);
        Direction rot = facing.getClockWise();

        return new DirPos[] {
                new DirPos(this.getBlockPos().getX() + facing.getStepX() * 2 + rot.getStepX(), this.getBlockPos().getY(), this.getBlockPos().getZ() + facing.getStepZ() * 2 + rot.getStepZ(), facing),
                new DirPos(this.getBlockPos().getX() + facing.getStepX() * 2 - rot.getStepX(), this.getBlockPos().getY(), this.getBlockPos().getZ() + facing.getStepZ() * 2 - rot.getStepZ(), facing),
                new DirPos(this.getBlockPos().getX() - facing.getStepX() * 2 + rot.getStepX(), this.getBlockPos().getY(), this.getBlockPos().getZ() - facing.getStepZ() * 2 + rot.getStepZ(), facing.getOpposite()),
                new DirPos(this.getBlockPos().getX() - facing.getStepX() * 2 - rot.getStepX(), this.getBlockPos().getY(), this.getBlockPos().getZ() - facing.getStepZ() * 2 - rot.getStepZ(), facing.getOpposite())
        };
    }

    @Override
    public void updateEntity() {
        if(this.level == null || this.level.isClientSide) return;

        if(!this.converted) {
            this.converted = true;
        }

        if(this.tanks[0].setType(0, this.slots)) {
            this.setChanged();
        }
        this.setupTanks();
        this.updateConnections();

        this.heatEnergy = (int) (this.heatEnergy * 0.999D);
        this.tryConvert();

        this.networkPackNT(25);

        for(DirPos pos : this.getConPos()) {
            if(this.tanks[1].getFill() > 0) {
                this.tryProvide(this.tanks[1], this.level, pos);
            }
        }
    }

    protected void setupTanks() {
        if(tanks[0].getTankType().hasTrait(FT_Coolable.class)) {
            FT_Coolable trait = tanks[0].getTankType().getTrait(FT_Coolable.class);
            if(trait.getEfficiency(CoolingType.HEATEXCHANGER) > 0) {
                tanks[1].setTankType(trait.coolsTo);
                return;
            }
        }

        this.tanks[0].setTankType(Fluids.NONE);
        this.tanks[1].setTankType(Fluids.NONE);
    }

    protected void updateConnections() {
        for(DirPos pos : this.getConPos()) {
            this.trySubscribe(this.tanks[0].getTankType(), this.level, pos);
        }
    }

    protected void tryConvert() {
        if(this.level == null) return;

        if(!tanks[0].getTankType().hasTrait(FT_Coolable.class)) return;
        if(tickDelay < 1) tickDelay = 1;
        if(this.level.getGameTime() % tickDelay != 0) return;

        FT_Coolable trait = tanks[0].getTankType().getTrait(FT_Coolable.class);

        int inputOps = tanks[0].getFill() / trait.amountReq;
        int outputOps = (tanks[1].getMaxFill() - tanks[1].getFill()) / trait.amountProduced;
        int opCap = this.amountToCool;

        int ops = Math.min(inputOps, Math.min(outputOps, opCap));
        tanks[0].setFill(tanks[0].getFill() - trait.amountReq * ops);
        tanks[1].setFill(tanks[1].getFill() + trait.amountProduced * ops);
        this.heatEnergy += trait.heatEnergy * ops * trait.getEfficiency(CoolingType.HEATEXCHANGER);
        this.setChanged();
    }

    @Override
    public boolean canConnect(FluidType type, Direction dir) {
        Direction facing = this.getBlockState().getValue(com.hbm.blocks.DummyableBlock.FACING);
        return dir == facing || dir == facing.getOpposite();
    }

    @Override
    public FluidTank[] getSendingTanks() {
        return new FluidTank[] { this.tanks[1] };
    }

    @Override
    public FluidTank[] getReceivingTanks() {
        return new FluidTank[] { this.tanks[0] };
    }

    @Override
    public FluidTank[] getAllTanks() {
        return this.tanks;
    }

    @Override
    public boolean hasPermission(Player player) {
        return player.distanceToSqr(this.getBlockPos().getX() + 0.5, this.getBlockPos().getY() + 0.5, this.getBlockPos().getZ() + 0.5) <= 256.0D;
    }

    @Override
    public void receiveControl(CompoundTag tag) {
        if(tag.contains("toCool")) this.amountToCool = Math.max(1, Math.min(tag.getInt("toCool"), this.tanks[0].getMaxFill()));
        if(tag.contains("delay")) this.tickDelay = Math.max(tag.getInt("delay"), 1);
        this.setChanged();
    }

    @Override
    public CompoundTag getSettings(net.minecraft.world.level.Level level, BlockPos pos) {
        CompoundTag tag = new CompoundTag();
        tag.putInt("toCool", this.amountToCool);
        tag.putInt("delay", this.tickDelay);
        return tag;
    }

    @Override
    public void pasteSettings(CompoundTag tag, int index, net.minecraft.world.level.Level level, Player player, BlockPos pos) {
        if(tag.contains("toCool")) this.amountToCool = Math.max(1, Math.min(tag.getInt("toCool"), this.tanks[0].getMaxFill()));
        if(tag.contains("delay")) this.tickDelay = Math.max(tag.getInt("delay"), 1);
    }

    @Override
    public boolean canPlaceItem(int slot, net.minecraft.world.item.ItemStack stack) {
        return slot == 0 && stack.getItem() instanceof IItemFluidIdentifier;
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new com.hbm.inventory.menus.HeaterHeatexMenu(id, inventory, this);
    }

    @Override
    public void serialize(RegistryFriendlyByteBuf buf) {
        super.serialize(buf);
        this.tanks[0].serialize(buf);
        this.tanks[1].serialize(buf);
        buf.writeInt(this.amountToCool);
        buf.writeInt(this.tickDelay);
        buf.writeBoolean(this.converted);
    }

    @Override
    public void deserialize(RegistryFriendlyByteBuf buf) {
        super.deserialize(buf);
        this.tanks[0].deserialize(buf);
        this.tanks[1].deserialize(buf);
        this.amountToCool = buf.readInt();
        this.tickDelay = buf.readInt();
        this.converted = buf.readBoolean();
    }

    @Override
    protected void loadAdditional(CompoundTag tag, net.minecraft.core.HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.tanks[0].readFromNBT(tag, "input");
        this.tanks[1].readFromNBT(tag, "output");
        if(tag.contains("toCool")) this.amountToCool = Math.max(1, Math.min(tag.getInt("toCool"), this.tanks[0].getMaxFill()));
        if(tag.contains("delay")) this.tickDelay = Math.max(tag.getInt("delay"), 1);
        this.converted = tag.getBoolean("converted");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, net.minecraft.core.HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        this.tanks[0].writeToNBT(tag, "input");
        this.tanks[1].writeToNBT(tag, "output");
        tag.putInt("toCool", this.amountToCool);
        tag.putInt("delay", this.tickDelay);
        tag.putBoolean("converted", this.converted);
    }
}
