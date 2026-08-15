package com.hbm.items.weapon.sedna.factory;

import com.hbm.entity.projectile.BulletBaseMK4;
import com.hbm.extprop.HbmLivingAttachments;
import com.hbm.items.ItemEnums.CasingType;
import com.hbm.items.NtmItems;
import com.hbm.items.weapon.sedna.*;
import com.hbm.items.weapon.sedna.GunBaseNTItem.GunState;
import com.hbm.items.weapon.sedna.GunBaseNTItem.LambdaContext;
import com.hbm.items.weapon.sedna.GunBaseNTItem.WeaponQuality;
import com.hbm.items.weapon.sedna.factory.GunFactory.Ammo;
import com.hbm.items.weapon.sedna.mags.MagazineSingleReload;
import com.hbm.main.NuclearTechMod;
import com.hbm.main.ResourceManager;
import com.hbm.particle.SpentCasing;
import com.hbm.particle.SpentCasing.SpentCasingType;
import com.hbm.registry.NtmSoundEvents;
import com.hbm.render.anim.AnimationEnums.GunAnimation;
import com.hbm.render.anim.BusAnimation;
import com.hbm.render.anim.BusAnimationKeyframe;
import com.hbm.render.anim.BusAnimationKeyframe.IType;
import com.hbm.render.anim.BusAnimationSequence;
import com.hbm.util.SoundUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class XFactory12ga {

    public static BulletConfig g12_bp;
    public static BulletConfig g12_bp_magnum;
    public static BulletConfig g12_bp_slug;
    public static BulletConfig g12;
    public static BulletConfig g12_slug;
    public static BulletConfig g12_flechette;
    public static BulletConfig g12_magnum;
    public static BulletConfig g12_explosive;
    public static BulletConfig g12_phosphorus;

    public static BiConsumer<BulletBaseMK4, HitResult> LAMBDA_STANDARD_EXPLODE = (bullet, hr) -> {
        Lego.standardExplode(bullet, hr, 2F); bullet.discard();
    };

    public static void init(DeferredRegister.Items registry) {

        float buckshotSpread = 0.035F;
        float magnumSpread = 0.015F;
        g12_bp = new BulletConfig().setItem(Ammo.G12_BP).setCasing(CasingType.SHOTSHELL, 12).setBlackPowder(true).setProjectiles(8).setDamage(0.75F/8F).setSpread(buckshotSpread).setRicochetAngle(15).setCasing(new SpentCasing(SpentCasingType.SHOTGUN).setColor(SpentCasing.COLOR_CASE_BRASS, SpentCasing.COLOR_CASE_BRASS).setScale(0.75F).register("12GA_BP"));
        g12_bp_magnum = new BulletConfig().setItem(Ammo.G12_BP_MAGNUM).setCasing(CasingType.SHOTSHELL, 12).setBlackPowder(true).setProjectiles(4).setDamage(0.75F/4F).setSpread(buckshotSpread).setRicochetAngle(25).setCasing(new SpentCasing(SpentCasingType.SHOTGUN).setColor(SpentCasing.COLOR_CASE_BRASS, SpentCasing.COLOR_CASE_BRASS).setScale(0.75F).register("12GA_BP_MAGNUM"));
        g12_bp_slug = new BulletConfig().setItem(Ammo.G12_BP_SLUG).setCasing(CasingType.SHOTSHELL, 12).setBlackPowder(true).setDamage(0.75F).setSpread(0.01F).setRicochetAngle(5).setCasing(new SpentCasing(SpentCasingType.SHOTGUN).setColor(SpentCasing.COLOR_CASE_BRASS, SpentCasing.COLOR_CASE_BRASS).setScale(0.75F).register("12GA_BP_SLUG"));
        g12 = new BulletConfig().setItem(Ammo.G12).setCasing(CasingType.BUCKSHOT, 6).setProjectiles(8).setDamage(1F/8F).setSpread(buckshotSpread).setRicochetAngle(15).setThresholdNegation(2F).setCasing(new SpentCasing(SpentCasingType.SHOTGUN).setColor(0xB52B2B, SpentCasing.COLOR_CASE_BRASS).setScale(0.75F).register("12GA"));
        g12_slug = new BulletConfig().setItem(Ammo.G12_SLUG).setCasing(CasingType.BUCKSHOT, 6).setHeadshot(1.5F).setSpread(0.0F).setRicochetAngle(25).setThresholdNegation(4F).setArmorPiercing(0.15F).setCasing(new SpentCasing(SpentCasingType.SHOTGUN).setColor(0x393939, SpentCasing.COLOR_CASE_BRASS).setScale(0.75F).register("12GA_SLUG"));
        g12_flechette = new BulletConfig().setItem(Ammo.G12_FLECHETTE).setCasing(CasingType.BUCKSHOT, 6).setProjectiles(8).setDamage(1F/8F).setThresholdNegation(5F).setArmorPiercing(0.2F).setSpread(0.025F).setRicochetAngle(5).setCasing(new SpentCasing(SpentCasingType.SHOTGUN).setColor(0x3C80F0, SpentCasing.COLOR_CASE_BRASS).setScale(0.75F).register("12GA_FLECHETTE"));
        g12_magnum = new BulletConfig().setItem(Ammo.G12_MAGNUM).setCasing(CasingType.BUCKSHOT_ADVANCED, 6).setProjectiles(4).setDamage(2F/4F).setSpread(magnumSpread).setRicochetAngle(15).setThresholdNegation(4F).setCasing(new SpentCasing(SpentCasingType.SHOTGUN).setColor(0x278400, SpentCasing.COLOR_CASE_12GA).setScale(0.75F).register("12GA_MAGNUM"));
        g12_explosive = new BulletConfig().setItem(Ammo.G12_EXPLOSIVE).setCasing(CasingType.BUCKSHOT_ADVANCED, 6).setDamage(2.5F).setOnImpact(LAMBDA_STANDARD_EXPLODE).setSpread(0F).setRicochetAngle(15).setCasing(new SpentCasing(SpentCasingType.SHOTGUN).setColor(0xDA4127, SpentCasing.COLOR_CASE_12GA).setScale(0.75F).register("12GA_EXPLOSIVE"));
        g12_phosphorus = new BulletConfig().setItem(Ammo.G12_PHOSPHORUS).setCasing(CasingType.BUCKSHOT_ADVANCED, 6).setProjectiles(8).setDamage(1F/8F).setSpread(magnumSpread).setRicochetAngle(15).setCasing(new SpentCasing(SpentCasingType.SHOTGUN).setColor(0x910001, SpentCasing.COLOR_CASE_12GA).setScale(0.75F).register("12GA_PHOSPHORUS"))
                .setOnImpact((bullet, hr) -> { if(hr.getType() == HitResult.Type.MISS) { EntityHitResult ehr = (EntityHitResult) hr; if(ehr.getEntity() instanceof LivingEntity livingEntity) { HbmLivingAttachments data = HbmLivingAttachments.getData(livingEntity); if(data.phosphorus < 300) data.phosphorus = 300; } } });

        BulletConfig[] all = new BulletConfig[] {g12_bp, g12_bp_magnum, g12_bp_slug, g12, g12_slug, g12_flechette, g12_magnum, g12_explosive, g12_phosphorus};

        NtmItems.GUN_MARESLEG = registry.register("gun_maresleg", () -> new GunBaseNTItem(WeaponQuality.A_SIDE, new GunConfig()
                .dura(600).draw(10).inspect(39).reloadSequential(true).crosshair(Crosshair.L_CIRCLE).smoke(Lego.LAMBDA_STANDARD_SMOKE)
                .rec(new Receiver(0)
                        .dmg(16F).delay(20).reload(22, 10, 13, 0).jam(24).sound(NtmSoundEvents.GUN_SHOTGUN_FIRE, 1F, 1F)
                        .mag(new MagazineSingleReload(0, 6).addConfigs(all))
                        .offset(0.75, -0.0625, -0.1875)
                        .setupStandardFire().recoil(LAMBDA_RECOIL_MARESLEG))
                .setupStandardConfiguration()
                .anim(LAMBDA_MARESLEG_ANIMS).orchestra(Orchestras.ORCHESTRA_MARESLEG)
        ).setDefaultAmmo(Ammo.G12, 12));//.setNameMutator(LAMBDA_NAME_MARESLEG);
        NtmItems.GUN_SPAS12 = registry.register("gun_spas12", () -> new GunBaseNTItem(WeaponQuality.A_SIDE, new GunConfig()
                .dura(600).draw(20).inspect(39).reloadSequential(true).reloadChangeType(true).crosshair(Crosshair.L_CIRCLE).smoke(Lego.LAMBDA_STANDARD_SMOKE)
                .rec(new Receiver(0)
                        .dmg(32F).spreadHipfire(0F).delay(20).reload(5, 10, 10, 10, 0).jam(36).sound(NtmSoundEvents.GUN_SPAS_FIRE, 1.0F, 1.0F)
                        .mag(new MagazineSingleReload(0, 8).addConfigs(all))
                        .offset(0.75, -0.0625, -0.1875)
                        .setupStandardFire().recoil(LAMBDA_RECOIL_MARESLEG))
                .setupStandardConfiguration().ps(LAMBDA_SPAS_SECONDARY).pt(null)
                .anim(LAMBDA_SPAS_ANIMS).orchestra(Orchestras.ORCHESTRA_SPAS)
        ).setDefaultAmmo(Ammo.G12, 16));
    }

    public static BiConsumer<ItemStack, LambdaContext> LAMBDA_RECOIL_MARESLEG = (stack, ctx) -> {
        GunBaseNTItem.setupRecoil(10, (float) (ctx.getPlayer().getRandom().nextGaussian() * 1.5));
    };

    public static BiConsumer<ItemStack, LambdaContext> LAMBDA_SPAS_SECONDARY = (stack, ctx) -> {
        LivingEntity entity = ctx.entity;
        Player player = ctx.getPlayer();
        Receiver rec = ctx.config.getReceivers(stack)[0];
        int index = ctx.configIndex;
        GunState state = GunBaseNTItem.getState(stack, index);
        if(state == GunState.IDLE) {
            if(rec.getCanFire(stack).apply(stack, ctx)) {
                rec.getOnFire(stack).accept(stack, ctx);
                int remaining = rec.getRoundsPerCycle(stack);
                int timeFired = 1;
                for(int i = 0; i < remaining; i++) {
                    if(rec.getCanFire(stack).apply(stack, ctx)) {
                        rec.getOnFire(stack).accept(stack, ctx);
                        timeFired++;
                    }
                }
                if(rec.getFireSound(stack) != null) SoundUtils.playAtVec3(entity.level, entity.position(), rec.getFireSound(stack).value(), entity.getSoundSource(), rec.getFireVolume(stack), rec.getFirePitch(stack) * (timeFired > 1 ? 0.9F : 1F));
                GunBaseNTItem.setState(stack, index, GunState.COOLDOWN);
                GunBaseNTItem.setTimer(stack, index, 20);
            } else {
                if(rec.getDoesDryFire(stack)) {
                    GunBaseNTItem.playAnimation(player, stack, GunAnimation.CYCLE_DRY, index);
                    GunBaseNTItem.setState(stack, index, GunState.DRAWING);
                    GunBaseNTItem.setTimer(stack, index, rec.getDelayAfterDryFire(stack));
                }
            }
        }
        if(state == GunState.RELOADING) {
            GunBaseNTItem.setReloadCancel(stack, true);
        }
    };

    public static BiFunction<ItemStack, GunAnimation, BusAnimation> LAMBDA_SPAS_ANIMS = (stack, type) -> {
        return switch (type) {
            case EQUIP -> new BusAnimation()
                    .addBus("EQUIP", new BusAnimationSequence().addPos(-60, 0, 0, 0).addPos(0, 0, -3, 500, BusAnimationKeyframe.IType.SIN_DOWN));
            case CYCLE -> ResourceManager.spas_12_anim.get("Fire");
            case CYCLE_DRY -> ResourceManager.spas_12_anim.get("FireDry");
            case ALT_CYCLE -> ResourceManager.spas_12_anim.get("FireAlt");
            case RELOAD -> {
                boolean empty = ((GunBaseNTItem) stack.getItem()).getConfig(stack, 0).getReceivers(stack)[0].getMagazine(stack).getAmount(stack, NuclearTechMod.proxy.me().inventory) <= 0;
                yield ResourceManager.spas_12_anim.get(empty ? "ReloadEmptyStart" : "ReloadStart");
            }
            case RELOAD_CYCLE -> ResourceManager.spas_12_anim.get("Reload");
            case RELOAD_END -> ResourceManager.spas_12_anim.get("ReloadEnd");
            case JAMMED -> ResourceManager.spas_12_anim.get("Jammed");
            case INSPECT -> ResourceManager.spas_12_anim.get("Inspect");
            default -> null;
        };

    };

    public static BiFunction<ItemStack, GunAnimation, BusAnimation> LAMBDA_MARESLEG_ANIMS = (stack, type) -> {
        return switch (type) {
            case EQUIP -> new BusAnimation()
                    .addBus("EQUIP", new BusAnimationSequence().addPos(-60, 0, 0, 0).addPos(0, 0, -3, 500, IType.SIN_DOWN));
            case CYCLE -> new BusAnimation()
                    .addBus("RECOIL", new BusAnimationSequence().addPos(0, 0, 0, 50).addPos(0, 0, -1, 50).addPos(0, 0, 0, 250))
                    .addBus("SIGHT", new BusAnimationSequence().addPos(35, 0, 0, 100, IType.SIN_DOWN).addPos(0, 0, 0, 100, IType.SIN_FULL))
                    .addBus("LEVER", new BusAnimationSequence().addPos(0, 0, 0, 600).addPos(-85, 0, 0, 200).addPos(0, 0, 0, 200))
                    .addBus("TURN", new BusAnimationSequence().addPos(0, 0, 0, 600).addPos(0, 0, 45, 200, IType.SIN_DOWN).addPos(0, 0, 0, 200, IType.SIN_UP))
                    .addBus("HAMMER", new BusAnimationSequence().addPos(30, 0, 0, 50).addPos(30, 0, 0, 550).addPos(0, 0, 0, 200));
            case CYCLE_DRY -> new BusAnimation()
                    .addBus("LEVER", new BusAnimationSequence().addPos(0, 0, 0, 600).addPos(-90, 0, 0, 200).addPos(0, 0, 0, 200))
                    .addBus("TURN", new BusAnimationSequence().addPos(0, 0, 0, 600).addPos(0, 0, 45, 200, IType.SIN_DOWN).addPos(0, 0, 0, 200, IType.SIN_UP))
                    .addBus("HAMMER", new BusAnimationSequence().addPos(30, 0, 0, 50).addPos(30, 0, 0, 550).addPos(0, 0, 0, 200));
            case RELOAD -> {
                boolean empty = ((GunBaseNTItem) stack.getItem()).getConfig(stack, 0).getReceivers(stack)[0].getMagazine(stack).getAmount(stack, NuclearTechMod.proxy.me().inventory) <= 0;
                yield new BusAnimation()
                        .addBus("LIFT", new BusAnimationSequence().addPos(30, 0, 0, 400, IType.SIN_FULL))
                        .addBus("LEVER", new BusAnimationSequence().addPos(0, 0, 0, 400).addPos(-85, 0, 0, 200))
                        .addBus("SHELL", new BusAnimationSequence().addPos(0, 0, 0, 600).addPos(0, 0.25F, -3, 0).addPos(0, empty ? 0.25F : 0.125F, -1.5F, 150, IType.SIN_UP).addPos(0, empty ? 0.25F : -0.25F, 0, 150, IType.SIN_DOWN))
                        .addBus("FLAG", new BusAnimationSequence().addPos(0, 0, 0, empty ? 900 : 0).addPos(1, 1, 1, 0));
            }
            case RELOAD_CYCLE -> new BusAnimation()
                    .addBus("LIFT", new BusAnimationSequence().addPos(30, 0, 0, 0))
                    .addBus("LEVER", new BusAnimationSequence().addPos(-85, 0, 0, 0))
                    .addBus("SHELL", new BusAnimationSequence().addPos(0, 0.25F, -3, 0).addPos(0, 0.125F, -1.5F, 150, IType.SIN_UP).addPos(0, -0.125F, 0, 150, IType.SIN_DOWN))
                    .addBus("FLAG", new BusAnimationSequence().addPos(1, 1, 1, 0));
            case RELOAD_END -> new BusAnimation()
                    .addBus("LIFT", new BusAnimationSequence().addPos(30, 0, 0, 0).addPos(30, 0, 0, 250).addPos(0, 0, 0, 400, IType.SIN_FULL))
                    .addBus("LEVER", new BusAnimationSequence().addPos(-85, 0, 0, 0).addPos(0, 0, 0, 200))
                    .addBus("FLAG", new BusAnimationSequence().addPos(1, 1, 1, 0));
            case JAMMED -> new BusAnimation()
                    .addBus("LIFT", new BusAnimationSequence().addPos(30, 0, 0, 0).addPos(30, 0, 0, 250).addPos(0, 0, 0, 400, IType.SIN_FULL))
                    .addBus("LEVER", new BusAnimationSequence().addPos(-85, 0, 0, 0).addPos(-15, 0, 0, 200).addPos(-15, 0, 0, 650).addPos(-85, 0, 0, 200).addPos(-15, 0, 0, 200).addPos(-15, 0, 0, 200).addPos(-85, 0, 0, 200).addPos(0, 0, 0, 200))
                    .addBus("TURN", new BusAnimationSequence().addPos(0, 0, 0, 850).addPos(0, 0, 45, 200, IType.SIN_DOWN).addPos(0, 0, 45, 800).addPos(0, 0, 0, 200, IType.SIN_UP))
                    .addBus("FLAG", new BusAnimationSequence().addPos(1, 1, 1, 0));
            case INSPECT -> new BusAnimation()
                    .addBus("LIFT", new BusAnimationSequence().addPos(-35, 0, 0, 300, IType.SIN_FULL).addPos(-35, 0, 0, 1150).addPos(0, 0, 0, 500, IType.SIN_FULL))
                    .addBus("TURN", new BusAnimationSequence().addPos(0, 0, 0, 450).addPos(0, 0, -90, 500, IType.SIN_FULL).addPos(0, 0, -90, 500).addPos(0, 0, 0, 500, IType.SIN_FULL));
            default -> null;
        };

    };
}
