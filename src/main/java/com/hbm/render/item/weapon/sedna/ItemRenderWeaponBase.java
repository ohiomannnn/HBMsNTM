package com.hbm.render.item.weapon.sedna;

import com.hbm.items.weapon.sedna.GunBaseNTItem;
import com.hbm.items.weapon.sedna.GunBaseNTItem.SmokeNode;
import com.hbm.main.NuclearTechMod;
import com.hbm.render.NtmRenderTypes;
import com.hbm.render.util.RenderContext;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix4f;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public abstract class ItemRenderWeaponBase extends BlockEntityWithoutLevelRenderer {

    public static final RenderType SMOKE = RenderType.create(
            "smoke_render_type", DefaultVertexFormat.POSITION_COLOR_LIGHTMAP, VertexFormat.Mode.QUADS, 1024,
            RenderType.CompositeState.builder()
                    .setShaderState(RenderType.RENDERTYPE_TEXT_BACKGROUND_SHADER)
                    .setTransparencyState(NtmRenderTypes.SEVEN_SEVEN_ONE_ZERO)
                    .setTextureState(RenderType.NO_TEXTURE)
                    .setLightmapState(RenderType.LIGHTMAP)
                    .setOverlayState(RenderType.OVERLAY)
                    .setCullState(RenderStateShard.NO_CULL)
                    .setWriteMaskState(RenderStateShard.COLOR_WRITE)
                    .createCompositeState(false)
    );

    public static final Function<ResourceLocation, RenderType> FLASH = Util.memoize(
            texture -> {
                RenderType.CompositeState state = RenderType.CompositeState.builder()
                        .setShaderState(NtmRenderTypes.POSITION_TEX_COLOR)
                        .setTextureState(new RenderStateShard.TextureStateShard(texture, false, false))
                        .setTransparencyState(RenderType.LIGHTNING_TRANSPARENCY)
                        .setCullState(RenderType.NO_CULL)
                        .setLightmapState(RenderType.LIGHTMAP)
                        .setOverlayState(RenderType.OVERLAY)
                        .setWriteMaskState(RenderStateShard.COLOR_WRITE)
                        .createCompositeState(false);
                return RenderType.create("flash_render_type", DefaultVertexFormat.POSITION_TEX_COLOR, VertexFormat.Mode.QUADS, 1024, state);
            }
    );
    public static final ResourceLocation FLASH_PLUME_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/lilmac_plume.png");
    public static final ResourceLocation LASER_FLASH_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/laser_flash.png");

    protected static float partialTick;
    protected static @Nullable LivingEntity living;
    public static final HashMap<LivingEntity, Long> flashMap = new HashMap<>();

    public ItemRenderWeaponBase() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {

        RenderContext.setup(poseStack, packedLight, packedOverlay);

        if(displayContext != ItemDisplayContext.GUI) RenderContext.translate(0.5F, 0F, 0.5F);
        RenderContext.mulPose(Axis.YP.rotationDegrees(180F));
        switch(displayContext) {
            case FIRST_PERSON_RIGHT_HAND -> {
                RenderContext.translate(-1F, 0.51F, -1F);
                if(!isRightHandMain()) RenderContext.mulPose(Axis.XP.rotationDegrees(15F));
                this.setupFirstPerson(stack);
                this.renderFirstPerson(stack, buffer);
            }
            case FIRST_PERSON_LEFT_HAND -> {
                RenderSystem.disableCull();
                RenderContext.translate(-1F, 0.51F, -1F);
                RenderContext.scale(-1F, 1F, 1F);
                if(isRightHandMain()) RenderContext.mulPose(Axis.XP.rotationDegrees(15F));
                this.setupFirstPerson(stack);
                this.renderFirstPerson(stack, buffer);
                RenderSystem.enableCull();
            }
            case THIRD_PERSON_RIGHT_HAND -> {
                this.setupThirdPerson(stack);
                this.renderStatic(stack, buffer, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND);
            }
            case THIRD_PERSON_LEFT_HAND -> {
                RenderSystem.disableCull();
                RenderContext.scale(-1F, 1F, 1F);
                this.setupThirdPerson(stack);
                this.renderStatic(stack, buffer, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND);
                RenderSystem.enableCull();
            }
            case GROUND -> {
                this.setupEntity(stack);
                this.renderStatic(stack, buffer,  ItemDisplayContext.GROUND);
            }
            case GUI -> {
                this.setupInv(stack);
                this.renderStatic(stack, buffer,  ItemDisplayContext.GUI);
            }
            default -> { }
        }

        ItemRenderWeaponBase.living = null; //!
        RenderContext.end();
    }

    public void setup(ItemStack stack, PoseStack poseStack, float partialTick) {
        ItemRenderWeaponBase.partialTick = partialTick;

        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if(player == null) return;

        float swayMagnitude = this.getSwayMagnitude(stack);
        float swayPeriod = this.getSwayPeriod(stack);
        float turnMagnitude = this.getTurnMagnitude(stack);

        //floppyness
        float xBob = Mth.lerp(partialTick, player.xBobO, player.xBob);
        float yBob = Mth.lerp(partialTick, player.yBobO, player.yBob);
        poseStack.mulPose(Axis.XP.rotationDegrees((player.xRot - xBob) * 0.1F * turnMagnitude));
        poseStack.mulPose(Axis.YP.rotationDegrees((player.yRot - yBob) * 0.1F * turnMagnitude));

        //viewbob
        if(mc.getCameraEntity() instanceof Player) {
            float distanceDelta = player.walkDist - player.walkDistO;
            float distanceInterp = -(player.walkDist + distanceDelta * partialTick);
            float bob = Mth.lerp(partialTick, player.oBob, player.bob);
            poseStack.translate(Mth.sin(distanceInterp * (float) Math.PI * swayPeriod) * bob * 0.5F * swayMagnitude, -Math.abs(Mth.cos(distanceInterp * (float) Math.PI * swayPeriod) * bob) * swayMagnitude, 0.0F);
            poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.sin(distanceInterp * (float) Math.PI * swayPeriod) * bob * 3.0F));
            poseStack.mulPose(Axis.XP.rotationDegrees(Math.abs(Mth.cos(distanceInterp * (float) Math.PI * swayPeriod - 0.2F) * bob) * 5.0F));
        }

        poseStack.translate(-1F, 0F, -1F);
    }

    public void setEntity(LivingEntity living) { ItemRenderWeaponBase.living = living; }

    public boolean isAkimbo(LivingEntity entity) { return false; }
    public boolean isLeftHanded() { return false; }
    public double getViewFOV(ItemStack stack, double fov, double partialTick) { return fov; }
    protected float getSwayMagnitude(ItemStack stack) { return GunBaseNTItem.getIsAiming(stack) ? 0.1F : 0.5F; }
    protected float getSwayPeriod(ItemStack stack) { return 0.75F; }
    protected float getTurnMagnitude(ItemStack stack) { return 2.75F; }

    public abstract void renderFirstPerson(ItemStack stack, MultiBufferSource buffer);
    public void renderStatic(ItemStack stack, MultiBufferSource buffer, ItemDisplayContext displayContext) { }

    public void setupFirstPerson(ItemStack stack) {
        RenderContext.translate(0F, 0F, 1F);
    }

    public void setupThirdPerson(ItemStack stack) {
        float scale = 0.07F;
        RenderContext.scale(scale, scale, scale);
        RenderContext.translate(0F, 6.47F, -1.5F);
    }

    public void setupInv(ItemStack stack) {
        float scale = 0.063F;
        RenderContext.scale(scale, scale, scale);
        RenderContext.translate(-7.77F, 7.77F, 0F);
        RenderContext.mulPose(Axis.ZP.rotationDegrees(45F));
        RenderContext.mulPose(Axis.YP.rotationDegrees(90F));
    }

    public void setupEntity(ItemStack stack) {
        RenderContext.translate(0F, 0.5F, 0F);
        float scale = 0.05F;
        RenderContext.scale(scale, scale, scale);
    }

    public static boolean isRightHandMain() { return Minecraft.getInstance().options.mainHand().get() == HumanoidArm.RIGHT; }

    public static void standardAimingTransform(ItemStack stack, float sX, float sY, float sZ, float aX, float aY, float aZ) {
        float aimingProgress = Mth.lerp(partialTick, GunBaseNTItem.prevAimingProgress, GunBaseNTItem.aimingProgress);
        float x = sX + (aX - sX) * aimingProgress;
        float y = sY + (aY - sY) * aimingProgress;
        float z = sZ + (aZ - sZ) * aimingProgress;
        RenderContext.translate(x, y, z);
    }

    public static void renderSmokeNodes(MultiBufferSource buffer, List<SmokeNode> nodes, float scale) {
        if(nodes.size() > 1) {

            VertexConsumer consumer = buffer.getBuffer(SMOKE);
            Matrix4f matrix = RenderContext.poseStack().last().pose();
            int packedLight = RenderContext.light();

            for(int i = 0; i < nodes.size() - 1; i++) {
                SmokeNode node = nodes.get(i);
                SmokeNode past = nodes.get(i + 1);

                float clamped = Math.clamp(node.alpha, 0F, 1F);
                float clampedPast = Math.clamp(past.alpha, 0F, 1F);

                consumer.addVertex(matrix, node.forward, node.lift, node.side).setColor(1F, 1F, 1F, clamped).setLight(packedLight);
                consumer.addVertex(matrix, node.forward, node.lift, node.side + node.width * scale).setColor(1F, 1F, 1F, 0F).setLight(packedLight);
                consumer.addVertex(matrix, past.forward, past.lift, past.side + past.width * scale).setColor(1F, 1F, 1F, 0F).setLight(packedLight);
                consumer.addVertex(matrix, past.forward, past.lift, past.side).setColor(1F, 1F, 1F, clampedPast).setLight(packedLight);

                consumer.addVertex(matrix, node.forward, node.lift, node.side).setColor(1F, 1F, 1F, clamped).setLight(packedLight);
                consumer.addVertex(matrix, node.forward, node.lift, node.side - node.width * scale).setColor(1F, 1F, 1F, 0F).setLight(packedLight);
                consumer.addVertex(matrix, past.forward, past.lift, past.side - past.width * scale).setColor(1F, 1F, 1F, 0F).setLight(packedLight);
                consumer.addVertex(matrix, past.forward, past.lift, past.side).setColor(1F, 1F, 1F, clampedPast).setLight(packedLight);
            }
        }
    }

    public static void renderGapFlash(MultiBufferSource buffer, long lastShot) {

        int flash = 75;

        if(System.currentTimeMillis() - lastShot < flash) {

            VertexConsumer consumer = buffer.getBuffer(FLASH.apply(FLASH_PLUME_TEX));
            Matrix4f matrix = RenderContext.poseStack().last().pose();

            float fire = (System.currentTimeMillis() - lastShot) / (float) flash;

            float height = 4 * fire;
            float length = 15 * fire;
            float lift = 3 * fire;
            float offset = 1 * fire;
            float lengthOffset = 0.125F;
            int color = 0xFFFFFFFF;

            consumer.addVertex(matrix, 0, -height, -offset).setUv(1, 1).setColor(color);
            consumer.addVertex(matrix, 0, height, -offset).setUv(0, 1).setColor(color);
            consumer.addVertex(matrix, 0, height + lift, length - offset).setUv(0 ,0).setColor(color);
            consumer.addVertex(matrix, 0, -height + lift, length - offset).setUv(1, 0).setColor(color);

            consumer.addVertex(matrix, 0, height, offset).setUv(0, 1).setColor(color);
            consumer.addVertex(matrix, 0, -height, offset).setUv(1, 1).setColor(color);
            consumer.addVertex(matrix, 0, -height + lift, -length + offset).setUv(1, 0).setColor(color);
            consumer.addVertex(matrix, 0, height + lift, -length + offset).setUv(0 ,0).setColor(color);

            consumer.addVertex(matrix, 0, -height, -offset).setUv(1, 1).setColor(color);
            consumer.addVertex(matrix, 0, height, -offset).setUv(0, 1).setColor(color);
            consumer.addVertex(matrix, lengthOffset, height, length - offset).setUv(0, 0).setColor(color);
            consumer.addVertex(matrix, lengthOffset, -height, length - offset).setUv(1, 0).setColor(color);

            consumer.addVertex(matrix, 0, height, offset).setUv(0, 1).setColor(color);
            consumer.addVertex(matrix, 0, -height, offset).setUv(1, 1).setColor(color);
            consumer.addVertex(matrix, lengthOffset, -height, -length + offset).setUv(1, 0).setColor(color);
            consumer.addVertex(matrix, lengthOffset, height, -length + offset).setUv(0, 0).setColor(color);
        }
    }

    public static void renderMuzzleFlash(MultiBufferSource buffer, long lastShot) {
        renderMuzzleFlash(buffer, lastShot, 75, 15);
    }

    public static void renderMuzzleFlash(MultiBufferSource buffer, long lastShot, int duration, float l) {

        int flash = duration;

        if(System.currentTimeMillis() - lastShot < flash) {

            VertexConsumer consumer = buffer.getBuffer(FLASH.apply(FLASH_PLUME_TEX));
            Matrix4f matrix = RenderContext.poseStack().last().pose();

            float fire = (System.currentTimeMillis() - lastShot) / (float) flash;

            float width = 6 * fire;
            float length = l * fire;
            float inset = 2;

            int color = 0xFFFFFFFF;

            consumer.addVertex(matrix, 0F, -width, - inset).setUv(1, 1).setColor(color);
            consumer.addVertex(matrix, 0F, width, - inset).setUv(0, 1).setColor(color);
            consumer.addVertex(matrix, 0.1F, width, length - inset).setUv(0 ,0).setColor(color);
            consumer.addVertex(matrix, 0.1F, -width, length - inset).setUv(1, 0).setColor(color);

            consumer.addVertex(matrix, 0F, width, inset).setUv(0, 1).setColor(color);
            consumer.addVertex(matrix, 0F, -width, inset).setUv(1, 1).setColor(color);
            consumer.addVertex(matrix, 0.1F, -width, -length + inset).setUv(1, 0).setColor(color);
            consumer.addVertex(matrix, 0.1F, width, -length + inset).setUv(0 ,0).setColor(color);

            consumer.addVertex(matrix, 0F, - inset, width).setUv(0, 1).setColor(color);
            consumer.addVertex(matrix, 0F, - inset, -width).setUv(1, 1).setColor(color);
            consumer.addVertex(matrix, 0.1F, length - inset, -width).setUv(1, 0).setColor(color);
            consumer.addVertex(matrix, 0.1F, length - inset, width).setUv(0 ,0).setColor(color);

            consumer.addVertex(matrix, 0F, inset, -width).setUv(1, 1).setColor(color);
            consumer.addVertex(matrix, 0F, inset, width).setUv(0, 1).setColor(color);
            consumer.addVertex(matrix, 0.1F, -length + inset, width).setUv(0 ,0).setColor(color);
            consumer.addVertex(matrix, 0.1F, -length + inset, -width).setUv(1, 0).setColor(color);
        }
    }
}
