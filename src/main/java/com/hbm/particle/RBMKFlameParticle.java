package com.hbm.particle;

import com.hbm.main.NuclearTechMod;
import com.hbm.particle.engine.ParticleEngineNT;
import com.hbm.particle.engine.ParticleNT;
import com.hbm.particle.vanilla.NbtParticleOptions;
import com.hbm.particle.vanilla.ParticleProviderBase;
import com.hbm.render.NtmRenderTypes;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.ParticleStatus;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public class RBMKFlameParticle extends ParticleNT {

    private static final ResourceLocation TEXTURE = NuclearTechMod.withDefaultNamespace("textures/particle_no_sheet/rbmk_fire.png");

    private static final RenderType FLAME = RenderType.create(
            "flame_render_type", DefaultVertexFormat.POSITION_TEX_COLOR, VertexFormat.Mode.QUADS, 1024,
            RenderType.CompositeState.builder()
                    .setShaderState(NtmRenderTypes.POSITION_TEX_COLOR)
                    .setTextureState(new RenderStateShard.TextureStateShard(TEXTURE, false, false))
                    .setTransparencyState(RenderType.LIGHTNING_TRANSPARENCY)
                    .setLightmapState(RenderType.LIGHTMAP)
                    .setOverlayState(RenderType.OVERLAY)
                    .setWriteMaskState(RenderStateShard.COLOR_WRITE)
                    .setOutputState(RenderStateShard.TRANSLUCENT_TARGET)
                    .createCompositeState(false)
    );

    public RBMKFlameParticle(ClientLevel level, double x, double y, double z, int lifetime) {
        super(level, x, y, z);

        this.lifetime = lifetime;
        this.quadSize = random.nextFloat() + 1F;
    }

    @Override
    public void render(VertexConsumer consumer, Camera camera, float partialTicks) {

        FogRenderer.setupNoFog();

        Vec3 camPos = camera.getPosition();
        float pX = (float) (Mth.lerp(partialTicks, this.xo, this.x) - camPos.x);
        float pY = (float) (Mth.lerp(partialTicks, this.yo, this.y) - camPos.y);
        float pZ = (float) (Mth.lerp(partialTicks, this.zo, this.z) - camPos.z);

        float yawRad = (float) Math.toRadians(camera.getYRot());
        float pitchRad = (float) Math.toRadians(camera.getXRot());
        pX += Mth.cos(yawRad);
        pY += Mth.cos(pitchRad);
        pZ += Mth.sin(yawRad);

        int texIndex = this.age * 5 % 14;
        float f0 = 1F / 14F;

        float uMin = texIndex % 5 * f0;
        float uMax = uMin + f0;
        float vMin = 0;
        float vMax = 1;

        this.alpha = 1F;
        if(this.age < 20) this.alpha = this.alpha / 20F;
        if(this.age > this.lifetime - 20) this.alpha = (this.lifetime - this.alpha) / 20F;
        this.alpha *= 0.5F;

        PoseStack poseStack = new PoseStack();
        poseStack.pushPose();
        poseStack.translate(pX, pY, pZ);
        poseStack.mulPose(Axis.YP.rotation((float) Math.toRadians(-camera.getYRot())));

        Matrix4f matrix = poseStack.last().pose();

        consumer.addVertex(matrix, -this.quadSize - 1, -this.quadSize * 2, 0).setUv(uMax, vMax).setColor(this.rCol, this.gCol, this.bCol, this.alpha);
        consumer.addVertex(matrix, -this.quadSize - 1, this.quadSize * 2, 0).setUv(uMax, vMin).setColor(this.rCol, this.gCol, this.bCol, this.alpha);
        consumer.addVertex(matrix, this.quadSize - 1, this.quadSize * 2, 0).setUv(uMin, vMin).setColor(this.rCol, this.gCol, this.bCol, this.alpha);
        consumer.addVertex(matrix, this.quadSize - 1, -this.quadSize * 2, 0).setUv(uMin, vMax).setColor(this.rCol, this.gCol, this.bCol, this.alpha);

        poseStack.popPose();
    }

    @Override public RenderType getRenderType() { return FLAME; }

    public static class Provider extends ParticleProviderBase<NbtParticleOptions> {

        @Override
        public void createParticle(NbtParticleOptions options, double x, double y, double z, double xd, double yd, double zd, ClientLevel level, RandomSource random, ParticleStatus particleStatus) {
            CompoundTag tag = options.tag;

            int lifetime = tag.getInt("lifetime");
            ParticleEngineNT.INSTANCE.add(new RBMKFlameParticle(level, x, y, z, lifetime));
        }
    }
}
