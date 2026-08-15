package com.hbm.blockentity.machine;

import api.hbm.energymk2.IEnergyProviderMK2;
import api.hbm.fluidmk2.IFluidStandardTransceiverMK2;
import com.hbm.blockentity.IFluidCopiable;
import com.hbm.blockentity.ITickable;
import com.hbm.blockentity.LoadedBaseBlockEntity;
import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.inventory.fluid.tank.FluidTank;
import com.hbm.inventory.fluid.trait.FT_Coolable;
import com.hbm.inventory.fluid.trait.FT_Coolable.CoolingType;
import com.hbm.util.fauxpointtwelve.DirPos;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class TurbineBaseBlockEntity extends LoadedBaseBlockEntity implements IEnergyProviderMK2, IFluidStandardTransceiverMK2, ITickable, IFluidCopiable {

    protected ByteBuf buf;
    public long powerBuffer;

    public FluidTank[] tanks;
    protected double[] info = new double[3];
    public boolean operational = false;

    public TurbineBaseBlockEntity(BlockEntityType<? extends TurbineBaseBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public abstract double getEfficiency();
    public abstract DirPos[] getConPos();
    public abstract DirPos[] getPowerPos();
    public abstract double consumptionPercent();

    public void generatePower(long power, int steamConsumed) {
        this.powerBuffer += power;
    }

    @Override
    public void updateEntity() {
        if(this.level == null) return;

        if(!this.level.isClientSide) {
            this.powerBuffer = 0;
            this.info = new double[3];

            if(this.buf != null) this.buf.release();
            this.buf = Unpooled.buffer();

            this.tanks[0].serialize(buf);

            operational = false;
            FluidType in = tanks[0].getTankType();
            boolean valid = false;
            if(in.hasTrait(FT_Coolable.class)) {
                FT_Coolable trait = in.getTrait(FT_Coolable.class);
                double eff = trait.getEfficiency(CoolingType.TURBINE) * getEfficiency();
                if(eff > 0) {
                    tanks[1].setTankType(trait.coolsTo);
                    int inputOps = (int) (Math.min(Math.ceil(tanks[0].getFill() * consumptionPercent()), tanks[0].getFill()) / trait.amountReq);
                    int outputOps = (tanks[1].getMaxFill() - tanks[1].getFill()) / trait.amountProduced;
                    int ops = Math.min(inputOps, outputOps);
                    if(ops > 0) {
                        tanks[0].setFill(tanks[0].getFill() - ops * trait.amountReq);
                        tanks[1].setFill(tanks[1].getFill() + ops * trait.amountProduced);
                        this.generatePower((long) (ops * trait.heatEnergy * eff), ops * trait.amountReq);
                    }
                    info[0] = ops * trait.amountReq;
                    info[1] = ops * trait.amountProduced;
                    info[2] = ops * trait.heatEnergy * eff;
                    valid = true;
                    operational = ops > 0;
                }
            }

            onServerTick();

            this.tanks[1].serialize(buf);
            this.buf.writeLong(this.powerBuffer);

            if(!valid) tanks[1].setTankType(Fluids.NONE);

            for(DirPos pos : this.getPowerPos()) {
                this.tryProvide(this.level, pos.makeCompat(), pos.getDir());
            }

            for(DirPos pos : this.getConPos()) {
                this.tryProvide(tanks[1], this.level, pos);
                this.trySubscribe(tanks[0].getTankType(), this.level, pos);
            }
            networkPackNT(150);
        } else {
            this.onClientTick();
        }
    }

    public void onServerTick() { }
    public void onClientTick() { }

    public void onLeverPull() {

        FluidType type = tanks[0].getTankType();
        boolean resize = this.doesResizeCompressor();

        if(type == Fluids.STEAM) {
            tanks[0].setTankType(Fluids.HOTSTEAM); tanks[1].setTankType(Fluids.STEAM);
            if(resize) { tanks[0].changeTankSize(tanks[0].getMaxFill() / 10); tanks[1].changeTankSize(tanks[1].getMaxFill() / 10); }
        } else if(type == Fluids.HOTSTEAM) {
            tanks[0].setTankType(Fluids.SUPERHOTSTEAM); tanks[1].setTankType(Fluids.HOTSTEAM);
            if(resize) { tanks[0].changeTankSize(tanks[0].getMaxFill() / 10); tanks[1].changeTankSize(tanks[1].getMaxFill() / 10); }
        } else if(type == Fluids.SUPERHOTSTEAM) {
            tanks[0].setTankType(Fluids.ULTRAHOTSTEAM); tanks[1].setTankType(Fluids.SUPERHOTSTEAM);
            if(resize) { tanks[0].changeTankSize(tanks[0].getMaxFill() / 10); tanks[1].changeTankSize(tanks[1].getMaxFill() / 10); }
        } else if(type == Fluids.ULTRAHOTSTEAM) {
            tanks[0].setTankType(Fluids.STEAM); tanks[1].setTankType(Fluids.SPENTSTEAM);
            if(resize) { tanks[0].changeTankSize(tanks[0].getMaxFill() * 1000); tanks[1].changeTankSize(tanks[1].getMaxFill() * 1000); }
        } else {
            tanks[0].setTankType(Fluids.STEAM); tanks[1].setTankType(Fluids.SPENTSTEAM);
        }

        this.setChanged();
    }

    public boolean doesResizeCompressor() {
        return false;
    }

    @Override
    public void serialize(RegistryFriendlyByteBuf buf) {
        super.serialize(buf);
        buf.writeBytes(this.buf);
    }

    @Override
    public void deserialize(RegistryFriendlyByteBuf buf) {
        super.deserialize(buf);
        this.tanks[0].deserialize(buf);
        this.tanks[1].deserialize(buf);
        this.powerBuffer = buf.readLong();
    }

    @Override
    protected void loadAdditional(CompoundTag tag, Provider registries) {
        super.loadAdditional(tag, registries);
        tanks[0].readFromNBT(tag, "water");
        tanks[1].readFromNBT(tag, "steam");
        powerBuffer = tag.getLong("power");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, Provider registries) {
        super.saveAdditional(tag, registries);
        tanks[0].writeToNBT(tag, "water");
        tanks[1].writeToNBT(tag, "steam");
        tag.putLong("power", powerBuffer);
    }

    @Override public long getPower() { return powerBuffer; }
    @Override public long getMaxPower() { return powerBuffer; }
    @Override public void setPower(long power) { this.powerBuffer = power; }

    @Override public FluidTank[] getSendingTanks() { return new FluidTank[] {tanks[1]}; }
    @Override public FluidTank[] getReceivingTanks() { return new FluidTank[] {tanks[0]}; }
    @Override public FluidTank[] getAllTanks() { return tanks; }

    @Override public FluidTank getTankToPaste() { return null; }
}
