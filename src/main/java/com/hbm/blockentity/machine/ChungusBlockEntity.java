package com.hbm.blockentity.machine;

import com.hbm.blockentity.NtmBlockEntityTypes;
import com.hbm.blocks.DummyableBlock;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.inventory.fluid.tank.FluidTank;
import com.hbm.registry.NtmSoundEvents;
import com.hbm.sound.AudioWrapper;
import com.hbm.util.fauxpointtwelve.DirPos;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;

public class ChungusBlockEntity extends TurbineBaseBlockEntity {

    private int turnTimer;
    public float rotor;
    public float lastRotor;
    public float fanAcceleration = 0F;

    private AudioWrapper audio;
    private float audioDesync;

    //Configurable values todo
    public static int inputTankSize = 1_000_000_000;
    public static int outputTankSize = 1_000_000_000;
    public static double efficiency = 0.85D;

    public ChungusBlockEntity(BlockPos pos, BlockState state) {
        super(NtmBlockEntityTypes.MACHINE_CHUNGUS.get(), pos, state);

        tanks = new FluidTank[2];
        tanks[0] = new FluidTank(Fluids.STEAM, inputTankSize);
        tanks[1] = new FluidTank(Fluids.SPENTSTEAM, outputTankSize);

        RandomSource rand = RandomSource.create();
        audioDesync = rand.nextFloat() * 0.05F;
    }

    @Override public double consumptionPercent() { return 1D; }
    @Override public double getEfficiency() { return efficiency; }

    @Override
    public DirPos[] getConPos() {
        Direction dir = this.getBlockState().getValue(DummyableBlock.FACING);
        Direction rot = dir.getClockWise(Axis.Y);
        BlockPos pos = this.getBlockPos();
        return new DirPos[] {
                new DirPos(pos.offset(dir.getStepX() * 5, 2, dir.getStepZ() * 5), dir),
                new DirPos(pos.offset(rot.getStepX() * 3, 0, rot.getStepZ() * 3), rot),
                new DirPos(pos.offset(-rot.getStepX() * 3, 0, -rot.getStepZ() * 3), rot.getOpposite())
        };
    }

    @Override
    public DirPos[] getPowerPos() {
        Direction dir = this.getBlockState().getValue(DummyableBlock.FACING);
        BlockPos pos = this.getBlockPos();
        return new DirPos[] { new DirPos(pos.offset(-dir.getStepX() * 11, 0, -dir.getStepZ() * 11), dir.getOpposite()) };
    }

    @Override
    public void onServerTick() {
        turnTimer--;
        if(operational) turnTimer = 25;
    }

    @Override
    public void onClientTick() {
        if(this.level == null) return;

        this.lastRotor = this.rotor;
        this.rotor += this.fanAcceleration;

        if(this.rotor >= 360) {
            this.rotor -= 360;
            this.lastRotor -= 360;
        }

        if(turnTimer > 0) {
            // Fan accelerates with a random offset to ensure the audio doesn't perfectly align, makes for a more pleasant hum
            this.fanAcceleration = Math.max(0F, Math.min(25F, this.fanAcceleration += 0.075F + audioDesync));

            RandomSource rand = this.level.random;
            Direction dir = this.getBlockState().getValue(DummyableBlock.FACING);
            Direction side = dir.getClockWise(Axis.Y);
            BlockPos pos = this.getBlockPos();

            for(int i = 0; i < 10; i++) {
                level.addParticle(ParticleTypes.CLOUD,
                        pos.getX() + 0.5 + dir.getStepX() * (rand.nextDouble() + 1.25) + rand.nextGaussian() * side.getStepX() * 0.65,
                        pos.getY() + 2.5 + rand.nextGaussian() * 0.65,
                        pos.getZ() + 0.5 + dir.getStepZ() * (rand.nextDouble() + 1.25) + rand.nextGaussian() * side.getStepZ() * 0.65,
                        -dir.getStepX() * 0.2, 0, -dir.getStepZ() * 0.2);
            }

            if(audio == null) {
                audio = AudioWrapper.getLoopedSound(NtmSoundEvents.TURBINE_LEVI_LOOP.get(), SoundSource.BLOCKS, this, 1.0F, 20F, 1.0F, 20);
                audio.startSound();
            }

            float turbineSpeed = this.fanAcceleration / 25F;
            audio.updateVolume(getVolume(0.5f * turbineSpeed));
            audio.updatePitch(0.25F + 0.75F * turbineSpeed);
            audio.keepAlive();

        } else {
            this.fanAcceleration = Math.max(0F, Math.min(25F, this.fanAcceleration -= 0.1F));

            if(audio != null) {
                if(this.fanAcceleration > 0) {
                    float turbineSpeed = this.fanAcceleration / 25F;
                    audio.updateVolume(getVolume(0.5f * turbineSpeed));
                    audio.updatePitch(0.25F + 0.75F * turbineSpeed);
                } else {
                    audio.stopSound();
                    audio = null;
                }
            }
        }
    }

    @Override
    public void serialize(RegistryFriendlyByteBuf buf) {
        super.serialize(buf);
        buf.writeInt(this.turnTimer);
    }

    @Override
    public void deserialize(RegistryFriendlyByteBuf buf) {
        super.deserialize(buf);
        this.turnTimer = buf.readInt();
    }

    @Override
    public boolean canConnect(Direction dir) {
        return dir != Direction.UP && dir != Direction.DOWN && dir != null;
    }

    @Override
    public void onChunkUnloaded() {
        super.onChunkUnloaded();

        if(audio != null) {
            audio.stopSound();
            audio = null;
        }
    }

    @Override
    public void setRemoved() {
        super.setRemoved();

        if(audio != null) {
            audio.stopSound();
            audio = null;
        }
    }
}
