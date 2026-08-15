package com.hbm.items.weapon.sedna.factory;

import com.hbm.entity.projectile.BulletBaseMK4;
import com.hbm.items.weapon.sedna.hud.HUDComponentAmmoCounter;
import com.hbm.items.weapon.sedna.hud.HUDComponentDurabilityBar;
import com.hbm.main.ResourceManager;
import com.hbm.render.util.RenderContext;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;

import java.util.function.BiConsumer;

public class LegoClient {

    private static final RenderType BULLET = RenderType.create(
            "bullet_render_type", DefaultVertexFormat.POSITION_COLOR_LIGHTMAP, VertexFormat.Mode.QUADS, 1024,
            RenderType.CompositeState.builder()
                    .setShaderState(RenderType.RENDERTYPE_TEXT_BACKGROUND_SHADER)
                    .setLightmapState(RenderType.LIGHTMAP)
                    .setOverlayState(RenderType.OVERLAY)
                    .setCullState(RenderStateShard.NO_CULL)
                    .createCompositeState(true)
    );

    public static HUDComponentDurabilityBar HUD_COMPONENT_DURABILITY = new HUDComponentDurabilityBar();
    public static HUDComponentDurabilityBar HUD_COMPONENT_DURABILITY_MIRROR = new HUDComponentDurabilityBar(true);
    public static HUDComponentAmmoCounter HUD_COMPONENT_AMMO = new HUDComponentAmmoCounter(0);
    public static HUDComponentAmmoCounter HUD_COMPONENT_AMMO_MIRROR = new HUDComponentAmmoCounter(0).mirror();
    public static HUDComponentAmmoCounter HUD_COMPONENT_AMMO_NOCOUNTER = new HUDComponentAmmoCounter(0).noCounter();
    public static HUDComponentAmmoCounter HUD_COMPONENT_AMMO_SECOND = new HUDComponentAmmoCounter(1);

    public static BiConsumer<BulletBaseMK4, Float> RENDER_STANDARD_BULLET = (bullet, partialTick) -> {
        float length = Mth.lerp(partialTick, bullet.prevVelocity, bullet.velocity);
        if(length <= 0) return;
        renderBulletStandard(0xFFFFBF00, 0xFFFFFFFF, length, false);
    };

    public static BiConsumer<BulletBaseMK4, Float> RENDER_FLECHETTE_BULLET = (bullet, partialTick) -> {
        float length = Mth.lerp(partialTick, bullet.prevVelocity, bullet.velocity);
        if(length <= 0) return;
        renderBulletStandard(0xFF8C8C8C, 0xFFCACACA, length, false);
    };

    public static BiConsumer<BulletBaseMK4, Float> RENDER_AP_BULLET = (bullet, partialTick) -> {
        float length = Mth.lerp(partialTick, bullet.prevVelocity, bullet.velocity);
        if(length <= 0) return;
        renderBulletStandard(0xFFFF6A00, 0xFFFFE28D, length, false);
    };

    public static BiConsumer<BulletBaseMK4, Float> RENDER_FRAGMENTATION = (bullet, partialTick) -> {
        float length = Mth.lerp(partialTick, bullet.prevVelocity, bullet.velocity);
        if(length <= 0) return;
        renderBulletStandard(0xFFFF6A00, 0xFFFFE28D, length, true);
    };

    public static BiConsumer<BulletBaseMK4, Float> RENDER_EXPRESS_BULLET = (bullet, partialTick) -> {
        float length = Mth.lerp(partialTick, bullet.prevVelocity, bullet.velocity);
        if(length <= 0) return;
        renderBulletStandard(0xFF9E082E, 0xFFFF8A79, length, false);
    };

    public static BiConsumer<BulletBaseMK4, Float> RENDER_DU_BULLET = (bullet, partialTick) -> {
        float length = Mth.lerp(partialTick, bullet.prevVelocity, bullet.velocity);
        if(length <= 0) return;
        renderBulletStandard(0xFF5CCD41, 0xFFE9FF8D, length, false);
    };

    public static BiConsumer<BulletBaseMK4, Float> RENDER_HE_BULLET = (bullet, partialTick) -> {
        float length = Mth.lerp(partialTick, bullet.prevVelocity, bullet.velocity);
        if(length <= 0) return;
        renderBulletStandard(0xFFD8CA00, 0xFFFFF19D, length, true);
    };

    public static BiConsumer<BulletBaseMK4, Float> RENDER_SM_BULLET = (bullet, partialTick) -> {
        float length = Mth.lerp(partialTick, bullet.prevVelocity, bullet.velocity);
        if(length <= 0) return;
        renderBulletStandard(0xFF42A8DD, 0xFFFFFFFF, length, true);
    };

    public static BiConsumer<BulletBaseMK4, Float> RENDER_BLACK_BULLET = (bullet, partialTick) -> {
        float length = Mth.lerp(partialTick, bullet.prevVelocity, bullet.velocity);
        if(length <= 0) return;
        renderBulletStandard(0xFF000000, 0xFF7F006E, length, true);
    };

    public static BiConsumer<BulletBaseMK4, Float> RENDER_TRACER_BULLET = (bullet, partialTick) -> {
        float length = Mth.lerp(partialTick, bullet.prevVelocity, bullet.velocity);
        if(length <= 0) return;
        renderBulletStandard(0xFF9E082E, 0xFFFF8A79, length, true);
    };

    public static void renderBulletStandard(int dark, int light, float length, boolean fullbright) {
        renderBulletStandard(dark, light, length, 0.03125F, 0.03125F * 0.25F, fullbright);
    }
    public static void renderBulletStandard(int dark, int light, float length, float widthF, float widthB, boolean fullbright) {

        Matrix4f matrix = RenderContext.poseStack().last().pose();
        int packedLight = fullbright ? 240 : RenderContext.light();

        MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
        VertexConsumer consumer = buffer.getBuffer(BULLET);

        consumer.addVertex(matrix, length, widthB, -widthB).setColor(dark).setLight(packedLight);
        consumer.addVertex(matrix, length, widthB, widthB).setColor(dark).setLight(packedLight);

        consumer.addVertex(matrix, 0, widthF, widthF).setColor(light).setLight(packedLight);
        consumer.addVertex(matrix, 0, widthF, -widthF).setColor(light).setLight(packedLight);

        consumer.addVertex(matrix, length, -widthB, -widthB).setColor(dark).setLight(packedLight);
        consumer.addVertex(matrix, length, -widthB, widthB).setColor(dark).setLight(packedLight);

        consumer.addVertex(matrix, 0, -widthF, widthF).setColor(light).setLight(packedLight);
        consumer.addVertex(matrix, 0, -widthF, -widthF).setColor(light).setLight(packedLight);

        consumer.addVertex(matrix, length, -widthB, widthB).setColor(dark).setLight(packedLight);
        consumer.addVertex(matrix, length, widthB, widthB).setColor(dark).setLight(packedLight);

        consumer.addVertex(matrix, 0, widthF, widthF).setColor(light).setLight(packedLight);
        consumer.addVertex(matrix, 0, -widthF, widthF).setColor(light).setLight(packedLight);

        consumer.addVertex(matrix, length, -widthB, -widthB).setColor(dark).setLight(packedLight);
        consumer.addVertex(matrix, length, widthB, -widthB).setColor(dark).setLight(packedLight);

        consumer.addVertex(matrix, 0, widthF, -widthF).setColor(light).setLight(packedLight);
        consumer.addVertex(matrix, 0, -widthF, -widthF).setColor(light).setLight(packedLight);

        consumer.addVertex(matrix, length, widthB, widthB).setColor(dark).setLight(packedLight);
        consumer.addVertex(matrix, length, widthB, -widthB).setColor(dark).setLight(packedLight);
        consumer.addVertex(matrix, length, -widthB, -widthB).setColor(dark).setLight(packedLight);
        consumer.addVertex(matrix, length, -widthB, widthB).setColor(dark).setLight(packedLight);

        consumer.addVertex(matrix, 0, widthF, widthF).setColor(light).setLight(packedLight);
        consumer.addVertex(matrix, 0, widthF, -widthF).setColor(light).setLight(packedLight);
        consumer.addVertex(matrix, 0, -widthF, -widthF).setColor(light).setLight(packedLight);
        consumer.addVertex(matrix, 0, -widthF, widthF).setColor(light).setLight(packedLight);

        buffer.endLastBatch();
    }

    public static BiConsumer<BulletBaseMK4, Float> RENDER_BOMB = (bullet, partialTick) -> {

        RenderContext.pushPose();
        RenderContext.scale(0.0625F, 0.0625F, 0.0625F);
        RenderContext.mulPose(Axis.YP.rotationDegrees(-90F));
        RenderContext.translate(0F, -1F, 1F);
        RenderSystem.setShaderTexture(0, ResourceManager.CLUSTER_SUBMUNITION_TEX);
        ResourceManager.fatman.renderPart("MiniNuke");
        RenderContext.popPose();
    };

}
