package com.hbm.items.weapon.sedna.factory;

import com.hbm.items.weapon.sedna.GunBaseNTItem;
import com.hbm.items.weapon.sedna.GunBaseNTItem.LambdaContext;
import com.hbm.items.weapon.sedna.Receiver;
import com.hbm.items.weapon.sedna.mags.IMagazine;
import com.hbm.network.toclient.MuzzleFlashPacket;
import com.hbm.particle.SpentCasing;
import com.hbm.particle.helper.CasingCreator;
import com.hbm.registry.NtmSoundEvents;
import com.hbm.render.anim.AnimationEnums.GunAnimation;
import com.hbm.util.EntityDamageUtil;
import com.hbm.util.SoundUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.function.BiConsumer;

/** Orchestras are server-side components that run along client-side animations.
 * The orchestra only knows what animation is or was playing and how long it started, but not if it is still active.
 * Orchestras are useful for things like playing server-side sound, spawning casings or sending particle packets.*/
public class Orchestras {

    public static BiConsumer<ItemStack, LambdaContext> DEBUG_ORCHESTRA = (stack, ctx) -> {
        LivingEntity entity = ctx.entity;
        Level level = entity.level;
        if(!(level instanceof ServerLevel serverLevel)) return;
        GunAnimation type = GunBaseNTItem.getLastAnim(stack, ctx.configIndex);
        int timer = GunBaseNTItem.getAnimTimer(stack, ctx.configIndex);

        if(type == GunAnimation.RELOAD) {
            if(timer == 3) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_REVOLVER_COCK.get(), entity.getSoundSource());
            if(timer == 10) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_MAG_SMALL_REMOVE.get(), entity.getSoundSource());
            if(timer == 34) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_MAG_SMALL_INSERT.get(), entity.getSoundSource());
            if(timer == 40) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_REVOLVER_CLOSE.get(), entity.getSoundSource());

           if(timer == 16) {
               Receiver rec = ctx.config.getReceivers(stack)[0];
               IMagazine<?> mag = rec.getMagazine(stack);
               SpentCasing casing = mag.getCasing(stack, ctx.container);
               if(casing != null) for(int i = 0; i < mag.getCapacity(stack); i++) CasingCreator.composeEffect(entity.level, entity, 0.25, -0.125, -0.125, -0.05, 0, 0, 0.01, casing.getName());
           }
        }
        if(type == GunAnimation.CYCLE) {
            if(timer == 0) PacketDistributor.sendToPlayersNear(serverLevel, null, entity.getX(), entity.getY(), entity.getZ(), 100, new MuzzleFlashPacket(entity.getId()));
            if(timer == 11) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_REVOLVER_COCK.get(), entity.getSoundSource());
        }
        if(type == GunAnimation.CYCLE_DRY) {
            if(timer == 2) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_DRY_FIRE.get(), entity.getSoundSource());
            if(timer == 11) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_REVOLVER_COCK.get(), entity.getSoundSource());
        }
        if(type == GunAnimation.INSPECT) {
            if(timer == 3) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_REVOLVER_COCK.get(), entity.getSoundSource());
            if(timer == 16) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_REVOLVER_CLOSE.get(), entity.getSoundSource());
        }
    };

    public static BiConsumer<ItemStack, LambdaContext> ORCHESTRA_MARESLEG = (stack, ctx) -> {
        LivingEntity entity = ctx.entity;
        Level level = entity.level;
        if(!(level instanceof ServerLevel serverLevel)) return;
        GunAnimation type = GunBaseNTItem.getLastAnim(stack, ctx.configIndex);
        int timer = GunBaseNTItem.getAnimTimer(stack, ctx.configIndex);
        boolean aiming = GunBaseNTItem.getIsAiming(stack);

        if(type == GunAnimation.RELOAD) {
            if(timer == 8) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_REVOLVER_COCK.get(), entity.getSoundSource(), 1F, 0.8F);
            if(timer == 16) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_SHOTGUN_LOAD.get(), entity.getSoundSource(), 1F, 1F);
        }
        if(type == GunAnimation.RELOAD_CYCLE) {
            if(timer == 0) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_SHOTGUN_LOAD.get(), entity.getSoundSource(), 1F, 1F);
        }
        if(type == GunAnimation.RELOAD_END) {
            if(timer == 2) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_REVOLVER_COCK.get(), entity.getSoundSource(), 1F, 0.7F);
        }
        if(type == GunAnimation.JAMMED) {
            if(timer == 2) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_REVOLVER_COCK.get(), entity.getSoundSource(), 1F, 0.7F);
            if(timer == 17) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_LEVER_COCK.get(), entity.getSoundSource(), 1F, 0.8F);
            if(timer == 29) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_LEVER_COCK.get(), entity.getSoundSource(), 1F, 0.8F);
        }
        if(type == GunAnimation.CYCLE) {
            if(timer == 0) PacketDistributor.sendToPlayersNear(serverLevel, null, entity.getX(), entity.getY(), entity.getZ(), 100, new MuzzleFlashPacket(entity.getId()));
            if(timer == 14) {
                SpentCasing casing = ctx.config.getReceivers(stack)[0].getMagazine(stack).getCasing(stack, ctx.container);
                if(casing != null) CasingCreator.composeEffect(entity.level, entity, 0.3125, -0.125, aiming ? -0.125 : -0.375D, 0, 0.18, -0.12, 0.01, -10F + (float)entity.random.nextGaussian() * 5F, (float)entity.random.nextGaussian() * 2.5F, casing.getName(), true, 60, 0.5D, 20);
            }
            if(timer == 8) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_LEVER_COCK.get(), entity.getSoundSource(), 1F, 0.8F);
        }
        if(type == GunAnimation.CYCLE_DRY) {
            if(timer == 2) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_DRY_FIRE.get(), entity.getSoundSource(), 1F, 1F);
            if(timer == 8) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_LEVER_COCK.get(), entity.getSoundSource(), 1F, 0.8F);
        }
    };

    public static BiConsumer<ItemStack, LambdaContext> ORCHESTRA_SPAS = (stack, ctx) -> {
        LivingEntity entity = ctx.entity;
        Level level = entity.level;
        if(!(level instanceof ServerLevel serverLevel)) return;
        GunAnimation type = GunBaseNTItem.getLastAnim(stack, ctx.configIndex);
        int timer = GunBaseNTItem.getAnimTimer(stack, ctx.configIndex);
        boolean aiming = GunBaseNTItem.getIsAiming(stack);

        if(type == GunAnimation.CYCLE || type == GunAnimation.ALT_CYCLE) {
            if(timer == 0) PacketDistributor.sendToPlayersNear(serverLevel, null, entity.getX(), entity.getY(), entity.getZ(), 100, new MuzzleFlashPacket(entity.getId()));
            if(timer == 8) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_SHOTGUN_COCK.get(), entity.getSoundSource());
            if(timer == 10) {
                SpentCasing casing = ctx.config.getReceivers(stack)[0].getMagazine(stack).getCasing(stack, ctx.container); //turns out there's a reason why stovepipes look like that
                if(casing != null) CasingCreator.composeEffect(level, entity, 0.375, aiming ? 0 : -0.125, aiming ? 0 : -0.25D, 0, 0.18, -0.12, 0.01, -3F + (float)entity.random.nextGaussian() * 2.5F, -15F + entity.random.nextFloat() * -5F, casing.getName());
            }
        }
        if(type == GunAnimation.CYCLE_DRY) {
            if(timer == 0) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_DRY_FIRE.get(), entity.getSoundSource());
            if(timer == 8) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_SHOTGUN_COCK.get(), entity.getSoundSource());
        }
        if(type == GunAnimation.RELOAD) {
            IMagazine<?> mag = ctx.config.getReceivers(stack)[0].getMagazine(stack);
            if(mag.getAmount(stack, ctx.container) == 0) {
                if(timer == 0) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_REVOLVER_COCK.get(), entity.getSoundSource());
                if(timer == 7) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_REVOLVER_CLOSE.get(), entity.getSoundSource());
            }
            if(timer == 5) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_SHOTGUN_LOAD.get(), entity.getSoundSource());
        }
        if(type == GunAnimation.RELOAD_CYCLE) {
            if(timer == 5) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_SHOTGUN_LOAD.get(), entity.getSoundSource());
        }
        if(type == GunAnimation.INSPECT) {
            if(timer == 5) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_SHOTGUN_OPEN.get(), entity.getSoundSource());
            if(timer == 18) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_SHOTGUN_CLOSE.get(), entity.getSoundSource());
        }
        if(type == GunAnimation.JAMMED) {
            if(timer == 18) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_WHACK.get(), entity.getSoundSource());
            if(timer == 25) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_WHACK.get(), entity.getSoundSource());
            if(timer == 29) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_SHOTGUN_CLOSE.get(), entity.getSoundSource());
        }
    };

    public static BiConsumer<ItemStack, LambdaContext> ORCHESTRA_HANGMAN = (stack, ctx) -> {
        LivingEntity entity = ctx.entity;
        Level level = entity.level;
        if(!(level instanceof ServerLevel serverLevel)) return;
        GunAnimation type = GunBaseNTItem.getLastAnim(stack, ctx.configIndex);
        int timer = GunBaseNTItem.getAnimTimer(stack, ctx.configIndex);

        if(type == GunAnimation.CYCLE) {
            if(timer == 0) PacketDistributor.sendToPlayersNear(serverLevel, null, entity.getX(), entity.getY(), entity.getZ(), 100, new MuzzleFlashPacket(entity.getId()));
        }
        if(type == GunAnimation.CYCLE_DRY) {
            if(timer == 0) SoundUtils.playAtVec3(level, entity.position(), NtmSoundEvents.GUN_DRY_FIRE.get(), entity.getSoundSource());
        }

        if(type == GunAnimation.RELOAD) {

            //if(timer == 0) entity.worldObj.playSoundAtEntity(entity, NTMSounds.GUN_REVOLVER_COCK, 1F, 0.8F);
            //if(timer == 5) entity.worldObj.playSoundAtEntity(entity, NTMSounds.GUN_MAG_SMALL_REMOVE, 1F, 0.8F);
            //if(timer == 25) entity.worldObj.playSoundAtEntity(entity, NTMSounds.GUN_REVOLVER_CLOSE, 1F, 1F);
            //if(timer == 35) entity.worldObj.playSoundAtEntity(entity, NTMSounds.GUN_REVOLVER_COCK, 1F, 0.75F);

            if(timer == 10) {
                Receiver rec = ctx.config.getReceivers(stack)[0];
                IMagazine mag = rec.getMagazine(stack);
                SpentCasing casing = mag.getCasing(stack, ctx.container);
                if(casing != null) for(int i = 0; i < mag.getCapacity(stack); i++) CasingCreator.composeEffect(level, entity, 0.25, -0.25, -0.125, -0.05, 0, 0, 0.01, -6.5F + (float)entity.random.nextGaussian() * 3F, (float)entity.random.nextGaussian() * 5F, casing.getName());
            }
        }

        if(type == GunAnimation.INSPECT) {
            if(timer == 16 && ctx.getPlayer() != null) {
                HitResult hr = EntityDamageUtil.getMouseOver(ctx.getPlayer(), 3.0D);
                if(hr != null) {
                    if(hr.getType() == Type.ENTITY) {
                        EntityHitResult ehr = (EntityHitResult) hr;
                        Entity hitEntity = ehr.getEntity();
                        float damage = 10F;
                        hitEntity.hurt(entity.level.damageSources().playerAttack(ctx.getPlayer()), damage);
                        Vec3 motion = hitEntity.getDeltaMovement();
                        hitEntity.setDeltaMovement(motion.x * 2, motion.y, motion.z * 2);
                        //entity.worldObj.playSoundAtEntity(mop.entityHit, NTMSounds.GUN_SMACK, 1F, 0.9F + entity.getRNG().nextFloat() * 0.2F);
                    }
                    if(hr.getType() == Type.BLOCK) {
                        BlockHitResult bhr = (BlockHitResult) hr;
                        BlockPos pos = bhr.getBlockPos();
                        BlockState state = level.getBlockState(bhr.getBlockPos());
                        Block block = state.getBlock();
                        SoundUtils.playAtBlockPos(level, pos, block.getSoundType(state, level, pos, ctx.getPlayer()).getStepSound(), entity.getSoundSource(), 2F, 0.9F + entity.random.nextFloat() * 0.2F);
                    }
                }
            }
        }

        if(type == GunAnimation.JAMMED) {
            //if(timer == 10) entity.worldObj.playSoundAtEntity(entity, NTMSounds.GUN_REVOLVER_COCK, 1F, 0.8F);
            //if(timer == 15) entity.worldObj.playSoundAtEntity(entity, NTMSounds.GUN_MAG_SMALL_REMOVE, 1F, 0.8F);
            //if(timer == 20) entity.worldObj.playSoundAtEntity(entity, NTMSounds.GUN_REVOLVER_CLOSE, 1F, 1F);
            //if(timer == 25) entity.worldObj.playSoundAtEntity(entity, NTMSounds.GUN_REVOLVER_COCK, 1F, 0.75F);
        }
    };
}
