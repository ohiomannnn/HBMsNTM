package com.hbm.particle.vanilla;

import net.minecraft.client.Minecraft;
import net.minecraft.client.ParticleStatus;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;

import javax.annotation.Nullable;

public abstract class ParticleProviderBase<T extends ParticleOptions> implements ParticleProvider<T> {

    // for some fucking unknown reason minecraft crashes because "u cant use random from multiple threads" like what??? arent minecraft single thread game???
    protected static final RandomSource RANDOM = RandomSource.createThreadSafe();

    @Override
    public @Nullable Particle createParticle(T options, ClientLevel level, double x, double y, double z, double xd, double yd, double zd) {
        Minecraft mc = Minecraft.getInstance();
        this.createParticle(options, x, y, z, xd, yd, zd, level, RANDOM, mc.options.particles().get());
        return null;
    }

    public abstract void createParticle(T options, double x, double y, double z, double xd, double yd, double zd, ClientLevel level, RandomSource random, ParticleStatus particleStatus);
}
