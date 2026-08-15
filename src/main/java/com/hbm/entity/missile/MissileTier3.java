package com.hbm.entity.missile;

import api.hbm.entity.IRadarDetectableNT;
import com.hbm.explosion.ExplosionChaos;
import com.hbm.explosion.ExplosionLarge;
import com.hbm.explosion.vanillant.ExplosionVNT;
import com.hbm.items.NtmItems;
import com.hbm.particle.helper.ExplosionCreator;
import com.hbm.util.Vec3NT;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

import java.util.ArrayList;
import java.util.List;

public abstract class MissileTier3 extends MissileBase {

    public MissileTier3(EntityType<? extends MissileTier3> entityType, Level level) { super(entityType, level); }

    @Override
    public List<ItemStack> getDebris() {
        List<ItemStack> list = new ArrayList<>();
        list.add(new ItemStack(NtmItems.NOTHING.get(), 16));
        list.add(new ItemStack(NtmItems.NOTHING.get(), 10));
        list.add(new ItemStack(NtmItems.NOTHING.get(), 1));
        return list;
    }

    @Override
    public String getUnlocalizedName() {
        return "radar.target.tier3";
    }

    @Override
    public int getBlipLevel() {
        return IRadarDetectableNT.TIER3;
    }

    @Override
    protected void spawnContrail() {
        Vec3NT thrust = new Vec3NT(0, 0, 0.5);
        thrust.rotateAroundYRad((this.yRot + 90) * (float) Math.PI / 180F);
        thrust.rotateAroundXRad(this.xRot * (float) Math.PI / 180F);
        thrust.rotateAroundYRad(-(this.yRot + 90) * (float) Math.PI / 180F);

        this.spawnContraolWithOffset(thrust.xCoord, thrust.yCoord, thrust.zCoord);
        this.spawnContraolWithOffset(-thrust.zCoord, thrust.yCoord, thrust.xCoord);
        this.spawnContraolWithOffset(-thrust.xCoord, -thrust.zCoord, -thrust.zCoord);
        this.spawnContraolWithOffset(thrust.zCoord, -thrust.zCoord, -thrust.xCoord);
    }

    public static class MissileBurst extends MissileTier3 {
        public MissileBurst(EntityType<? extends MissileBurst> entityType, Level level) { super(entityType, level); }
        @Override public void onMissileImpact(BlockHitResult mop) {
            ExplosionCreator.composeEffectLarge(level, this.position.x, this.position.y, this.position.z);
            this.explodeStandard(50F, 48, false);
        }
        @Override public ItemStack getDebrisRareDrop() { return new ItemStack(NtmItems.NOTHING.get()); }
        @Override public ItemStack getMissileItemForInfo() { return new ItemStack(NtmItems.MISSILE_BURST.get()); }
    }

    public static class MissileInferno extends MissileTier3 {
        public MissileInferno(EntityType<? extends MissileInferno> entityType, Level level) { super(entityType, level); }
        @Override public void onMissileImpact(BlockHitResult mop) {
            ExplosionCreator.composeEffectLarge(level, this.position.x, this.position.y, this.position.z);
            this.explodeStandard(50F, 48, true);
            ExplosionChaos.burn(level, (int) (this.position.x + 0.5), (int) (this.position.y + 0.5), (int) (this.position.z + 0.5), 10);
            ExplosionChaos.flameDeath(level, (int) (this.position.x + 0.5), (int) (this.position.y + 0.5), (int) (this.position.z + 0.5), 25);
        }
        @Override public ItemStack getDebrisRareDrop() { return new ItemStack(NtmItems.NOTHING.get()); }
        @Override public ItemStack getMissileItemForInfo() { return new ItemStack(NtmItems.MISSILE_INFERNO.get()); }
    }

    public static class MissileRain extends MissileTier3 {
        public MissileRain(EntityType<? extends MissileRain> entityType, Level level) { super(entityType, level); this.isCluster = true; }
        @Override public void onMissileImpact(BlockHitResult mop) {
            ExplosionVNT.createExplosion(level, this, this.position.x, this.position.y, this.position.z, 25F, true);
            ExplosionChaos.cluster(this.level, this.getX(), this.getY(), this.getZ(), 100, this.yRot, this.xRot, (float) Math.PI * 0.25F, (float) Math.PI * 0.25F, 1F);
        }
        @Override public void cluster() { this.onMissileImpact(null); }
        @Override public ItemStack getDebrisRareDrop() { return new ItemStack(NtmItems.NOTHING.get()); }
        @Override public ItemStack getMissileItemForInfo() { return new ItemStack(NtmItems.MISSILE_RAIN.get()); }
    }

    public static class MissileDrill extends MissileTier3 {
        public MissileDrill(EntityType<? extends MissileDrill> entityType, Level level) { super(entityType, level); }
        @Override public void onMissileImpact(BlockHitResult mop) {
            for (int i = 0; i < 30; i++) ExplosionVNT.createExplosion(level, this, this.position.x, this.position.y - i, this.position.z, 10F, true);
            if (level instanceof ServerLevel serverLevel) {
                ExplosionLarge.spawnParticles(serverLevel, this.position.x, this.position.y, this.position.z, 5);
                ExplosionLarge.spawnShrapnels(serverLevel, this.position.x, this.position.y, this.position.z, 5);
                ExplosionLarge.jolt(serverLevel, this.position.x, this.position.y, this.position.z, 10, 50, 1);
            }
        }
        @Override public void cluster() { this.onMissileImpact(null); }
        @Override public ItemStack getDebrisRareDrop() { return new ItemStack(NtmItems.NOTHING.get()); }
        @Override public ItemStack getMissileItemForInfo() { return new ItemStack(NtmItems.MISSILE_DRILL.get()); }
    }
}
