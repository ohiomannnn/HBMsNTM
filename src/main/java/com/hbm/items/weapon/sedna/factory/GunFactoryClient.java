package com.hbm.items.weapon.sedna.factory;

import com.hbm.items.NtmItems;
import com.hbm.items.weapon.sedna.GunBaseNTItem;
import com.hbm.main.ResourceManager;
import com.hbm.render.item.weapon.sedna.*;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

import static com.hbm.items.weapon.sedna.factory.GunFactory.*;
import static com.hbm.items.weapon.sedna.factory.XFactory12ga.*;
import static com.hbm.items.weapon.sedna.factory.XFactory44.*;
import static com.hbm.items.weapon.sedna.factory.XFactoryCatapult.*;

public class GunFactoryClient {

    public static void init(RegisterClientExtensionsEvent event) {
        //GUNS
        registerGunItemRenderer(event, new ItemRenderDebug(), NtmItems.GUN_DEBUG.get());
        registerGunItemRenderer(event, new ItemRenderMaresleg(ResourceManager.MARESLEG_TEX), NtmItems.GUN_MARESLEG.get());
        registerGunItemRenderer(event, new ItemRenderSPAS12(), NtmItems.GUN_SPAS12.get());
        registerGunItemRenderer(event, new ItemRenderHangman(), NtmItems.GUN_HANGMAN.get());

        //PROJECTILES
        ammo_debug.setRenderer(LegoClient.RENDER_STANDARD_BULLET);
        ammo_debug_shot.setRenderer(LegoClient.RENDER_STANDARD_BULLET);

        m44_bp.setRenderer(LegoClient.RENDER_STANDARD_BULLET);
        m44_sp.setRenderer(LegoClient.RENDER_STANDARD_BULLET);
        m44_fmj.setRenderer(LegoClient.RENDER_STANDARD_BULLET);
        m44_jhp.setRenderer(LegoClient.RENDER_STANDARD_BULLET);
        m44_ap.setRenderer(LegoClient.RENDER_AP_BULLET);
        m44_express.setRenderer(LegoClient.RENDER_EXPRESS_BULLET);

        g12_bp.setRenderer(LegoClient.RENDER_STANDARD_BULLET);
        g12_bp_magnum.setRenderer(LegoClient.RENDER_STANDARD_BULLET);
        g12_bp_slug.setRenderer(LegoClient.RENDER_STANDARD_BULLET);
        g12.setRenderer(LegoClient.RENDER_STANDARD_BULLET);
        g12_slug.setRenderer(LegoClient.RENDER_STANDARD_BULLET);
        g12_flechette.setRenderer(LegoClient.RENDER_FLECHETTE_BULLET);
        g12_magnum.setRenderer(LegoClient.RENDER_STANDARD_BULLET);
        g12_explosive.setRenderer(LegoClient.RENDER_EXPRESS_BULLET);
        g12_phosphorus.setRenderer(LegoClient.RENDER_AP_BULLET);

        cluster_submunition.setRenderer(LegoClient.RENDER_BOMB);

        //HUDS
        ((GunBaseNTItem) NtmItems.GUN_DEBUG.get())						.getConfig(null, 0).hud(LegoClient.HUD_COMPONENT_DURABILITY, LegoClient.HUD_COMPONENT_AMMO, LegoClient.HUD_COMPONENT_AMMO_SECOND);
        ((GunBaseNTItem) NtmItems.GUN_MARESLEG.get())					.getConfig(null, 0).hud(LegoClient.HUD_COMPONENT_DURABILITY, LegoClient.HUD_COMPONENT_AMMO);
        ((GunBaseNTItem) NtmItems.GUN_SPAS12.get())						.getConfig(null, 0).hud(LegoClient.HUD_COMPONENT_DURABILITY, LegoClient.HUD_COMPONENT_AMMO);
        ((GunBaseNTItem) NtmItems.GUN_HANGMAN.get())					.getConfig(null, 0).hud(LegoClient.HUD_COMPONENT_DURABILITY, LegoClient.HUD_COMPONENT_AMMO);
    }

    public static void registerGunItemRenderer(RegisterClientExtensionsEvent event, ItemRenderWeaponBase weaponRenderer, Item item) {
        event.registerItem(new IClientItemExtensions() {

            private ItemRenderWeaponBase renderer;

            @Override
            public boolean applyForgeHandTransform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm, ItemStack itemInHand, float partialTick, float equipProcess, float swingProcess) {
                if(renderer == null) this.renderer = weaponRenderer;
                renderer.setup(itemInHand, poseStack, partialTick);
                return true;
            }

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if(renderer == null) this.renderer = weaponRenderer;
                return renderer;
            }

            @Override
            public HumanoidModel.ArmPose getArmPose(LivingEntity living, InteractionHand hand, ItemStack itemStack) {
                if(renderer == null) this.renderer = weaponRenderer;
                renderer.setEntity(living);

                return IClientItemExtensions.super.getArmPose(living, hand, itemStack);
            }
        }, item);
    }

}
