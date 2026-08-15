package com.hbm.blockentity.machine;

import api.hbm.fluidmk2.IFluidStandardTransceiverMK2;
import com.hbm.blockentity.MachineBaseBlockEntity;
import com.hbm.blockentity.NtmBlockEntityTypes;
import com.hbm.blocks.DummyableBlock;
import com.hbm.blocks.NtmBlocks;
import com.hbm.handler.MultiblockHandlerXR;
import com.hbm.interfaces.IControlReceiver;
import com.hbm.inventory.MetaHelper;
import com.hbm.inventory.RecipesCommon.ComparableStack;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.inventory.fluid.tank.FluidTank;
import com.hbm.inventory.menus.ReactorZirnoxMenu;
import com.hbm.items.NtmItems;
import com.hbm.items.machine.ZirnoxRodItem;
import com.hbm.items.machine.ZirnoxRodItem.ZirnoxType;
import com.hbm.registry.NtmSoundEvents;
import com.hbm.util.EnumUtil;
import com.hbm.util.SoundUtils;
import com.hbm.util.fauxpointtwelve.DirPos;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class ReactorZirnoxBlockEntity extends MachineBaseBlockEntity implements IControlReceiver, IFluidStandardTransceiverMK2 {

    public int heat;
    public static final int maxHeat = 100000;
    public boolean redstonePowered = false;
    public int pressure;
    public static final int maxPressure = 100000;
    public boolean isOn = false;

    public final FluidTank steam;
    public final FluidTank carbonDioxide;
    public final FluidTank water;
    protected int output;

    private static final int[] SLOTS_IO = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 };

    public static final Map<ComparableStack, ItemStack> fuelMap = new HashMap<>();

    public ReactorZirnoxBlockEntity(BlockPos pos, BlockState state) {
        super(NtmBlockEntityTypes.REACTOR_ZIRNOX.get(), pos, state, 28);

        steam = new FluidTank(Fluids.SUPERHOTSTEAM, 8000);
        carbonDioxide = new FluidTank(Fluids.CARBONDIOXIDE, 16000);
        water = new FluidTank(Fluids.WATER, 32000);

        if(fuelMap.isEmpty()) {
            fuelMap.put(new ComparableStack(NtmItems.ROD_ZIRNOX.get(), 1, ZirnoxType.NATURAL_URANIUM_FUEL.ordinal()), new ItemStack(NtmItems.ROD_ZIRNOX_NATURAL_URANIUM_FUEL_DEPLETED.get()));
            fuelMap.put(new ComparableStack(NtmItems.ROD_ZIRNOX.get(), 1, ZirnoxType.URANIUM_FUEL.ordinal()), new ItemStack(NtmItems.ROD_ZIRNOX_URANIUM_FUEL_DEPLETED.get()));
            fuelMap.put(new ComparableStack(NtmItems.ROD_ZIRNOX.get(), 1, ZirnoxType.TH232.ordinal()), MetaHelper.newStack(NtmItems.ROD_ZIRNOX, 1, ZirnoxType.THORIUM_FUEL));
            fuelMap.put(new ComparableStack(NtmItems.ROD_ZIRNOX.get(), 1, ZirnoxType.THORIUM_FUEL.ordinal()), new ItemStack(NtmItems.ROD_ZIRNOX_THORIUM_FUEL_DEPLETED.get()));
            fuelMap.put(new ComparableStack(NtmItems.ROD_ZIRNOX.get(), 1, ZirnoxType.MOX_FUEL.ordinal()), new ItemStack(NtmItems.ROD_ZIRNOX_MOX_FUEL_DEPLETED.get()));
            fuelMap.put(new ComparableStack(NtmItems.ROD_ZIRNOX.get(), 1, ZirnoxType.PLUTONIUM_FUEL.ordinal()), new ItemStack(NtmItems.ROD_ZIRNOX_PLUTONIUM_FUEL_DEPLETED.get()));
            fuelMap.put(new ComparableStack(NtmItems.ROD_ZIRNOX.get(), 1, ZirnoxType.U233_FUEL.ordinal()), new ItemStack(NtmItems.ROD_ZIRNOX_U233_FUEL_DEPLETED.get()));
            fuelMap.put(new ComparableStack(NtmItems.ROD_ZIRNOX.get(), 1, ZirnoxType.U235_FUEL.ordinal()), new ItemStack(NtmItems.ROD_ZIRNOX_U235_FUEL_DEPLETED.get()));
            fuelMap.put(new ComparableStack(NtmItems.ROD_ZIRNOX.get(), 1, ZirnoxType.LES_FUEL.ordinal()), new ItemStack(NtmItems.ROD_ZIRNOX_LES_FUEL_DEPLETED.get()));
            fuelMap.put(new ComparableStack(NtmItems.ROD_ZIRNOX.get(), 1, ZirnoxType.LITHIUM.ordinal()), new ItemStack(NtmItems.ROD_ZIRNOX_TRITIUM.get()));
            fuelMap.put(new ComparableStack(NtmItems.ROD_ZIRNOX.get(), 1, ZirnoxType.ZFB_MOX.ordinal()), new ItemStack(NtmItems.ROD_ZIRNOX_ZFB_MOX_DEPLETED.get()));
        }
    }

    @Override protected Component getDefaultName() { return Component.translatable("container.zirnox"); }

    @Override
    public int[] getSlotsForFace(Direction direction) {
        return SLOTS_IO;
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
        return index < 24 && stack.getItem() instanceof ZirnoxRodItem;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return index < 24 && !(stack.getItem() instanceof ZirnoxRodItem);
    }

    private int[] getNeighbouringSlots(int id) {

        return switch(id) {
            case 0 -> new int[]{1, 7};
            case 1 -> new int[]{0, 2, 8};
            case 2 -> new int[]{1, 9};
            case 3 -> new int[]{4, 10};
            case 4 -> new int[]{3, 5, 11};
            case 5 -> new int[]{4, 6, 12};
            case 6 -> new int[]{5, 13};
            case 7 -> new int[]{0, 8, 14};
            case 8 -> new int[]{1, 7, 9, 15};
            case 9 -> new int[]{2, 8, 16};
            case 10 -> new int[]{3, 11, 17};
            case 11 -> new int[]{4, 10, 12, 18};
            case 12 -> new int[]{5, 11, 13, 19};
            case 13 -> new int[]{6, 12, 20};
            case 14 -> new int[]{7, 15, 21};
            case 15 -> new int[]{8, 14, 16, 22};
            case 16 -> new int[]{9, 15, 23};
            case 17 -> new int[]{10, 18};
            case 18 -> new int[]{11, 17, 19};
            case 19 -> new int[]{12, 18, 20};
            case 20 -> new int[]{13, 19};
            case 21 -> new int[]{14, 22};
            case 22 -> new int[]{15, 21, 23};
            case 23 -> new int[]{16, 22};
            default -> null;
        };

    }

    @Override
    public void updateEntity() {
        if(this.level == null) return;

        if(!this.level.isClientSide) {
            this.checkTilt(TiltType.CONFIG, true);

            if (redstonePowered) {
                isOn = true;
            }
            this.output = 0;

            if(!tilted && level.getGameTime() % 20 == 0) {
                this.updateConnections();
            }

            carbonDioxide.loadTank(level, 24, 26, slots);
            water.loadTank(level, 25, 27, slots);

            if(isOn) {
                for(int i = 0; i < 24; i++) {

                    if(!slots.get(i).isEmpty()) {
                        if(slots.get(i).getItem() instanceof ZirnoxRodItem) this.decay(i);
                        //else if(slots[i].getItem() == ModItems.meteorite_sword_bred)
                        //    slots[i] = new ItemStack(ModItems.meteorite_sword_irradiated);
                    }
                }
            }

            //2(fill) + (x * fill%)
            this.pressure = (this.carbonDioxide.getFill() * 2) + (int)((float)this.heat * ((float)this.carbonDioxide.getFill() / (float)this.carbonDioxide.getMaxFill()));

            if(this.heat > 0 && this.heat < maxHeat) {
                if(this.water.getFill() > 0 && this.carbonDioxide.getFill() > 0 && this.steam.getFill() < this.steam.getMaxFill()) {
                    this.generateSteam();
                    //(x * pressure) / 1,000,000
                    this.heat -= (int) ((float)this.heat * (float)this.pressure / 1000000F);
                } else {
                    this.heat -= 10;
                }

                //if(worldObj.getTotalWorldTime() % 100 == 0)
                //    SatelliteRayScan.reportEvent(worldObj, xCoord, yCoord, zCoord, RayEvent.INFO_NUCLEAR, 200);
            }

            if(!this.tilted) for(DirPos pos : this.getConPos()) {
                this.tryProvide(steam, level, pos);
            }

            this.checkIfMeltdown();

            this.networkPackNT(150);
        }
    }

    @Override public int getFloorCount() { return 3 * 3; }
    @Override public BlockPos getFloorPosFromIndex(int index) { return this.standardFloor5x5(index); }

    @Override
    protected void loadAdditional(CompoundTag tag, Provider registries) {
        super.loadAdditional(tag, registries);
        this.heat = tag.getInt("heat");
        this.pressure = tag.getInt("pressure");
        this.isOn = tag.getBoolean("isOn");
        this.steam.readFromNBT(tag, "steam");
        this.carbonDioxide.readFromNBT(tag, "carbondioxide");
        this.water.readFromNBT(tag, "water");
        this.redstonePowered = tag.getBoolean("redstonePowered");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("heat", heat);
        tag.putInt("pressure", pressure);
        tag.putBoolean("isOn", isOn);
        steam.writeToNBT(tag, "steam");
        carbonDioxide.writeToNBT(tag, "carbondioxide");
        water.writeToNBT(tag, "water");
        tag.putBoolean("redstonePowered", redstonePowered);
    }

    @Override
    public void serialize(RegistryFriendlyByteBuf buf) {
        super.serialize(buf);
        buf.writeInt(this.heat);
        buf.writeInt(this.pressure);
        buf.writeBoolean(this.isOn);
        buf.writeBoolean(this.redstonePowered);
        steam.serialize(buf);
        carbonDioxide.serialize(buf);
        water.serialize(buf);
    }

    @Override
    public void deserialize(RegistryFriendlyByteBuf buf) {
        super.deserialize(buf);
        this.heat = buf.readInt();
        this.pressure = buf.readInt();
        this.isOn = buf.readBoolean();
        this.redstonePowered = buf.readBoolean();
        steam.deserialize(buf);
        carbonDioxide.deserialize(buf);
        water.deserialize(buf);
    }

    public void setRedstonePowered(boolean powered) {
        if(!powered && this.redstonePowered) isOn = false;
        this.redstonePowered = powered;
    }

    private void generateSteam() {

        // function of SHS produced per tick
        // (heat - 10256)/100000 * steamFill (max efficiency at 14b) * 25 * 5 (should get rid of any rounding errors)
        if(this.heat > 10256) {
            float mult = 7.5F; // was 5 originally
            int cycle = (int)((((float)heat - 10256F) / (float)maxHeat) * Math.min(((float)carbonDioxide.getFill() / 14000F), 1F) * 25F * mult);
            this.output = cycle;

            water.setFill(water.getFill() - cycle);
            steam.setFill(steam.getFill() + cycle);

            if(water.getFill() < 0) water.setFill(0);
            if(steam.getFill() > steam.getMaxFill()) steam.setFill(steam.getMaxFill());
        }
    }

    private boolean hasFuelRod(int id) {
        if(slots.get(id).getItem() instanceof ZirnoxRodItem) {
            final ZirnoxType num = EnumUtil.grabEnumSafely(ZirnoxType.class, MetaHelper.getMeta(slots.get(id)));
            return !num.breeding;
        }

        return false;
    }

    private int getNeighbourCount(int id) {

        int[] neighbours = this.getNeighbouringSlots(id);

        if(neighbours == null)
            return 0;

        int count = 0;

        for(int neighbour : neighbours) {
            if(this.hasFuelRod(neighbour)) count++;
        }

        return count;

    }

    // itemstack in slots[id] has to contain ItemZirnoxRod
    private void decay(int id) {
        int decay = getNeighbourCount(id);
        final ZirnoxType num = EnumUtil.grabEnumSafely(ZirnoxType.class, MetaHelper.getMeta(slots.get(id)));

        if(!num.breeding)
            decay++;

        for(int i = 0; i < decay; i++) {
            this.heat += num.heat;
            ZirnoxRodItem.incrementLifeTime(slots.get(id));

            if(ZirnoxRodItem.getLifeTime(slots.get(id)) > num.maxLife) {
                slots.set(id, fuelMap.get(new ComparableStack(this.getItem(id))).copy());
                break;
            }
        }
    }

    private void checkIfMeltdown() {
        if(this.pressure > maxPressure || this.heat > maxHeat) this.meltdown();
    }

    private void meltdown() {
        if(this.level == null) return;

        this.clearContent();

        int[] dimensions = {1, 0, 2, 2, 2, 2,};
        Direction facing = this.getBlockState().getValue(DummyableBlock.FACING);
        this.level.setBlock(this.getBlockPos(), NtmBlocks.ZIRNOX_DESTROYED.get().defaultBlockState().setValue(DummyableBlock.FACING, facing), 3);
        MultiblockHandlerXR.fillSpace(this.level, this.getBlockPos(), dimensions, NtmBlocks.ZIRNOX_DESTROYED.get(), facing);
        Vec3 position = Vec3.atBottomCenterOf(this.getBlockPos());
        SoundUtils.playAtVec3(this.level, position, NtmSoundEvents.RBMK_EXPLOSION.get(), SoundSource.BLOCKS, 10F, 1F);
        this.level.explode(null, position.x, position.y + 3, position.z, 12F, ExplosionInteraction.BLOCK);
    }

    private void updateConnections() {
        for(DirPos pos : getConPos()) {
            this.trySubscribe(water.getTankType(), this.level, pos);
            this.trySubscribe(carbonDioxide.getTankType(), this.level, pos);
        }
    }

    private DirPos[] getConPos() {
        Direction dir = this.getBlockState().getValue(DummyableBlock.FACING);
        Direction rot = dir.getClockWise(Axis.Y);

        int dxRot = rot.getStepX() * 3;
        int dmxRot = rot.getStepX() * -3;
        int dzRot = rot.getStepZ() * 3;
        int dmzRot = rot.getStepZ() * -3;

        BlockPos pos = this.getBlockPos();
        return new DirPos[] {
                new DirPos(pos.offset(dxRot, 1, dzRot), rot),
                new DirPos(pos.offset(dxRot, 3, dzRot), rot),
                new DirPos(pos.offset(dmxRot, 1, dmzRot), rot.getOpposite()),
                new DirPos(pos.offset(dmxRot, 3, dmzRot), rot.getOpposite())
        };
    }

    @Override
    public boolean hasPermission(Player player) {
        return this.stillValid(player);
    }

    @Override
    public void receiveControl(CompoundTag tag) {
        if(tag.contains("control") && !redstonePowered) {
            this.isOn = !this.isOn;
            this.setChanged();
        }

        if(tag.contains("vent")) {
            int fill = this.carbonDioxide.getFill();
            this.carbonDioxide.setFill(fill - 1000);
            if(this.carbonDioxide.getFill() < 0) this.carbonDioxide.setFill(0);
            this.setChanged();
        }
    }

    @Override
    public FluidTank[] getSendingTanks() {
        return new FluidTank[] { steam };
    }

    @Override
    public FluidTank[] getReceivingTanks() {
        return new FluidTank[] { water, carbonDioxide };
    }

    @Override
    public FluidTank[] getAllTanks() {
        return new FluidTank[] { water, steam, carbonDioxide };
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new ReactorZirnoxMenu(id, inventory, this);
    }
}
