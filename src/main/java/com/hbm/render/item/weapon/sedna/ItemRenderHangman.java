package com.hbm.render.item.weapon.sedna;

import com.hbm.items.weapon.sedna.GunBaseNTItem;
import com.hbm.main.ResourceManager;
import com.hbm.render.anim.HbmAnimations;
import com.hbm.render.util.RenderContext;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class ItemRenderHangman extends ItemRenderWeaponBase {

    @Override
    protected float getTurnMagnitude(ItemStack stack) { return GunBaseNTItem.getIsAiming(stack) ? 2.5F : -0.5F; }

    @Override
    public double getViewFOV(ItemStack stack, double fov, double partialTick) {
        double aimingProgress = Mth.lerp(partialTick, GunBaseNTItem.prevAimingProgress, GunBaseNTItem.aimingProgress);
        return fov * (1 - aimingProgress * 0.33F);
    }

    @Override
    public void setupFirstPerson(ItemStack stack) {
        RenderContext.translate(0F, 0F, 0.875F);

        float offset = 0.8F;
        standardAimingTransform(stack,
                -1.5F * offset, -0.875F * offset, 1.75F * offset,
                0, -1.5F / 8F, 1.25F);
    }

    @Override
    public void setupThirdPerson(ItemStack stack) {
        super.setupThirdPerson(stack);
        float scale = 0.5F;
        RenderContext.scale(scale, scale, scale);
        RenderContext.translate(0F, 4.25F, 11F);

    }

    @Override
    public void setupInv(ItemStack stack) {
        super.setupInv(stack);
        float scale = 0.375F;
        RenderContext.scale(scale, scale, scale);
        RenderContext.mulPose(Axis.XP.rotationDegrees(25F));
        RenderContext.mulPose(Axis.YP.rotationDegrees(45F));
        RenderContext.translate(-0.5F, 2.5F, 0F);
    }

    @Override
    public void setupEntity(ItemStack stack) {
        float scale = 0.0625F;
        RenderContext.scale(scale, scale, scale);
    }

    @Override
    public void renderFirstPerson(ItemStack stack, MultiBufferSource buffer) {

        GunBaseNTItem gun = (GunBaseNTItem) stack.getItem();
        RenderSystem.setShaderTexture(0, ResourceManager.HANGMAN_TEX);
        float offset = 0.8F;

        float[] equip = HbmAnimations.getRelevantTransformation("EQUIP");
        float[] recoil = HbmAnimations.getRelevantTransformation("RECOIL");
        float[] roll = HbmAnimations.getRelevantTransformation("ROLL");
        float[] turn = HbmAnimations.getRelevantTransformation("TURN");
        float[] smack = HbmAnimations.getRelevantTransformation("SMACK");
        float[] lid = HbmAnimations.getRelevantTransformation("LID");
        float[] mag = HbmAnimations.getRelevantTransformation("MAG");
        float[] bullets = HbmAnimations.getRelevantTransformation("BULLETS");

        RenderContext.translate(1.5F * offset, 0F, -1F);
        RenderContext.mulPose(Axis.YP.rotationDegrees(turn[1]));
        RenderContext.translate(-1.5F * offset, 0F, 1F);

        RenderContext.mulPose(Axis.ZP.rotationDegrees(roll[2]));
        RenderContext.translate(smack[0], smack[1], smack[2]);

        float scale = 0.125F;
        RenderContext.scale(scale, scale, scale);

        RenderContext.translate(0F, -4F, -10F);
        RenderContext.mulPose(Axis.XP.rotationDegrees(equip[0]));
        RenderContext.translate(0F, 4F, 10F);

        RenderContext.translate(0F, 0F, recoil[2]);

        ResourceManager.hangman.renderPart("Rifle");
        ResourceManager.hangman.renderPart("Internals");

        RenderContext.pushPose();
        //i give the fuck up
        RenderContext.translate(-2.1875F, -1.75F, 0F);
        RenderContext.mulPose(Axis.ZP.rotationDegrees(lid[2]));
        RenderContext.translate(2.1875F, 1.75F, 0F);
        ResourceManager.hangman.renderPart("Lid");
        RenderContext.popPose();

        RenderContext.pushPose();
        RenderContext.translate(mag[0], mag[1], mag[2]);
        ResourceManager.hangman.renderPart("Magazine");
        if(bullets[0] == 0) ResourceManager.hangman.renderPart("Bullets");
        RenderContext.popPose();

        float smokeScale = 1.5F;

        RenderContext.pushPose();
        RenderContext.translate(0F, 0F, 29F);
        RenderContext.mulPose(Axis.YP.rotationDegrees(90));
        RenderContext.scale(smokeScale, smokeScale, smokeScale);
        renderSmokeNodes(buffer, gun.getConfig(stack, 0).smokeNodes, 0.5F);
        RenderContext.popPose();
        
        RenderContext.pushPose();
        RenderContext.translate(0F, 0F, 29F);
        RenderContext.mulPose(Axis.YP.rotationDegrees(90F));
        RenderContext.mulPose(Axis.XP.rotationDegrees(90F * gun.shotRand));
        RenderContext.scale(2F, 2F, 2F);
        renderMuzzleFlash(buffer, gun.lastShot[0], 75, 7.5F);
        RenderContext.popPose();
    }

    @Override
    public void renderStatic(ItemStack stack, MultiBufferSource buffer, ItemDisplayContext displayContext) {

        RenderSystem.setShaderTexture(0, ResourceManager.HANGMAN_TEX);
        ResourceManager.hangman.renderAll();

        if(living != null && (displayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || displayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)) {
            long shot;
            float shotRand = 0;
            if(living == Minecraft.getInstance().player) {
                GunBaseNTItem gun = (GunBaseNTItem) stack.getItem();
                shot = gun.lastShot[0];
                shotRand = gun.shotRand;
            } else {
                shot = ItemRenderWeaponBase.flashMap.getOrDefault(living, (long) -1);
                if(shot < 0) return;
            }

            RenderContext.pushPose();
            RenderContext.translate(0F, 0F, 29F);
            RenderContext.mulPose(Axis.YP.rotationDegrees(90F));
            RenderContext.mulPose(Axis.XP.rotationDegrees(90F * shotRand));
            RenderContext.scale(2F, 2F, 2F);
            renderMuzzleFlash(buffer, shot, 75, 7.5F);
            RenderContext.popPose();
        }
    }
}
