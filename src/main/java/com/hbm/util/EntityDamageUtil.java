package com.hbm.util;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;

import java.util.List;

public class EntityDamageUtil {

    // fuck it, every LivingEntity method is private/protected, les do something else
    /** Should mixin change vanilla behavior right now */
    public static boolean changeVanilla = false;
    /// FLAGS ///
    public static boolean ignoreIFrame = true;
    public static boolean allowSpecialCancel = false;
    public static double knockbackMultiplier = 0.0;

    private static void setup(boolean ignoreIFrame, boolean allowSpecialCancel, double knockbackMultiplier) {
        EntityDamageUtil.ignoreIFrame = ignoreIFrame;
        EntityDamageUtil.allowSpecialCancel = allowSpecialCancel;
        EntityDamageUtil.knockbackMultiplier = knockbackMultiplier;

        EntityDamageUtil.changeVanilla = true;
    }

    private static void reset() {
        EntityDamageUtil.ignoreIFrame = false;
        EntityDamageUtil.allowSpecialCancel = false;
        EntityDamageUtil.knockbackMultiplier = 0.0;

        EntityDamageUtil.changeVanilla = false;
    }

    /** Shitty hack, if the first attack fails, it retries with damage + previous damage, allowing damage to penetrate */
    @Deprecated
    public static boolean hurtIgnoreIFrame(Entity victim, DamageSource src, float damage) {

        if(!victim.hurt(src, damage)) {

            if(victim instanceof LivingEntity living) {

                if(living.invulnerableTime > 10.0F && !src.is(DamageTypeTags.BYPASSES_COOLDOWN)) {
                    damage += living.lastHurt;
                }
            }
            return victim.hurt(src, damage);
        } else {
            return true;
        }
    }

    /** New and improved entity damage calc - only use this one */
    public static boolean hurtNT(LivingEntity living, DamageSource source, float amount, boolean ignoreIFrame, boolean allowSpecialCancel, double knockbackMultiplier, float pierceDT, float pierce) {
        if(living instanceof ServerPlayer serverPlayer && source.getEntity() instanceof Player attacker) {
            if(!serverPlayer.canHarmPlayer(attacker)) return false; // handles wack-ass no PVP rule as well as scoreboard friendly fire
        }
        DamageResistanceHandler.setup(pierceDT, pierce);
        setup(ignoreIFrame, allowSpecialCancel, knockbackMultiplier); boolean ret = living.hurt(source, amount); reset();
        DamageResistanceHandler.reset();
        return ret;
    }

    public static void damageArmorNT(LivingEntity entity, float amount) { }

    public static void knockBack(LivingEntity living, double strength, double x, double z, double multiplier) {
        LivingKnockBackEvent event = CommonHooks.onLivingKnockBack(living, (float) strength, x, z);
        if(!event.isCanceled()) {
            double eventStrength = event.getStrength();
            double eventX = event.getRatioX();
            double eventZ = event.getRatioZ();
            eventStrength *= 1.0D - living.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
            if(eventStrength > 0.0D) {
                living.hasImpulse = true;

                Vec3 currentMotion = living.getDeltaMovement();
                while(eventX * eventX + eventZ * eventZ < 1.0E-5D) {
                    eventX = (Math.random() - Math.random()) * 0.01D;
                    eventZ = (Math.random() - Math.random()) * 0.01D;
                }

                double magnitude = eventStrength * multiplier;
                Vec3 knockbackVec = (new Vec3(eventX, 0.0D, eventZ)).normalize().scale(magnitude);
                double motionY = currentMotion.y;
                if(living.onGround()) {
                    motionY = currentMotion.y / 2.0D + magnitude;
                    if(motionY > 0.2D) motionY = 0.2D * multiplier;
                }
                if(motionY > 0.2D) motionY = 0.2D * multiplier;

                living.setDeltaMovement(currentMotion.x / 2.0D - knockbackVec.x, motionY, currentMotion.z / 2.0D - knockbackVec.z);
            }
        }
    }

    public static HitResult getMouseOver(Player attacker, double reach) { return getMouseOver(attacker, reach, 0D); }

    public static HitResult getMouseOver(Player attacker, double reach, double threshold) {

        Level level = attacker.level;
        HitResult objectMouseOver = rayTrace(attacker, reach, 1F);

        Entity pointedEntity = null;

        Vec3 pos = attacker.getEyePosition(1F);
        Vec3 look = attacker.getViewVector(1F);
        Vec3 end = pos.add(look.x * reach, look.y * reach, look.z * reach);
        Vec3 hitVec = null;
        float grace = 1.0F;

        List<Entity> list = level.getEntities(attacker, attacker.getBoundingBox().expandTowards(look.x * reach, look.y * reach, look.z * reach).inflate(grace, grace, grace), e -> e.isPickable() && e.isAlive());

        double closest = reach;

        for(Entity entity : list) {

            double borderSize = entity.getPickRadius() + threshold;
            AABB aabb = entity.getBoundingBox().inflate(borderSize, borderSize, borderSize);

            Vec3 hit = aabb.clip(pos, end).orElse(null);

            if(aabb.contains(pos)) {
                if(0.0D <= closest) {
                    pointedEntity = entity;
                    hitVec = hit == null ? pos : hit;
                    closest = 0.0D;
                }
            } else if(hit != null) {
                double dist = pos.distanceTo(hit);

                if(dist < closest || closest == 0.0D) {
                    if(entity == attacker.getVehicle() && !entity.canRiderInteract()) {
                        if(closest == 0.0D) {
                            pointedEntity = entity;
                            hitVec = hit;
                        }
                    } else {
                        pointedEntity = entity;
                        hitVec = hit;
                        closest = dist;
                    }
                }
            }
        }

        if(pointedEntity != null && (closest < reach || objectMouseOver.getType() == HitResult.Type.MISS)) {
            objectMouseOver = new EntityHitResult(pointedEntity, hitVec);
        }

        return objectMouseOver;
    }

    public static BlockHitResult rayTrace(Player player, double dist, float interp) {
        Vec3 pos = player.getEyePosition(1F);
        Vec3 look = player.getViewVector(interp);
        Vec3 end = pos.add(look.x * dist, look.y * dist, look.z * dist);

        return player.level.clip(new ClipContext(pos, end, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
    }
}
