package com.hbm.render.blockentity;

import com.hbm.blockentity.machine.ChungusBlockEntity;
import com.hbm.blocks.DummyableBlock;
import com.hbm.blocks.NtmBlocks;
import com.hbm.main.ResourceManager;
import com.hbm.render.item.ItemRenderBase;
import com.hbm.render.util.RenderContext;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class RenderChungus extends BlockEntityRendererNT<ChungusBlockEntity> implements IBEWLRProvider {

    @Override public BlockEntityRenderer<ChungusBlockEntity> create(Context context) { return new RenderChungus(); }

    @Override
    public void render(ChungusBlockEntity be, MultiBufferSource buffer, float partialTicks) {

        RenderContext.translate(0.5F, 0F, 0.5F);

        RenderContext.mulPose(Axis.YP.rotationDegrees(90F));

        Direction facing = be.getBlockState().getValue(DummyableBlock.FACING);
        switch(facing) {
            case NORTH -> RenderContext.mulPose(Axis.YP.rotationDegrees(90F));
            case WEST -> RenderContext.mulPose(Axis.YP.rotationDegrees(180F));
            case SOUTH -> RenderContext.mulPose(Axis.YP.rotationDegrees(270F));
            case EAST -> RenderContext.mulPose(Axis.YP.rotationDegrees(0F));
        }

        RenderContext.translate(0F, 0F, -3F);
        bindTexture(ResourceManager.CHUNGUS_TEX);

        ResourceManager.chungus.renderPart("Body");

        RenderContext.pushPose();
        RenderContext.translate(0F, 0F, 4.5F);
        RenderContext.mulPose(Axis.XP.rotationDegrees(15 - (be.tanks[0].getTankType().getID() - 2) * 10));
        RenderContext.translate(0F, 0F, -4.5F);
        ResourceManager.chungus.renderPart("Lever");
        RenderContext.popPose();

        RenderContext.translate(0F, 2.5F, 0F);
        RenderContext.mulPose(Axis.ZN.rotationDegrees(Mth.lerp(partialTicks, be.lastRotor, be.rotor)));
        RenderContext.translate(0F, -2.5F, 0F);

        ResourceManager.chungus.renderPart("Blades");

    }

    @Override
    public int getPacketLight(int packedLight, ChungusBlockEntity be) {
        if(be.getLevel() != null && be.getBlockState().getBlock() instanceof DummyableBlock dummy) {
            return LevelRenderer.getLightColor(be.getLevel(), be.getBlockPos().above(dummy.getDimensions()[0]));
        }
        return packedLight;
    }

    @Override
    public Item getItemForRenderer() {
        return NtmBlocks.MACHINE_CHUNGUS.asItem();
    }

    @Override
    public BlockEntityWithoutLevelRenderer getRenderer() {
        return new ItemRenderBase() {
            @Override
            public void renderInventory(ItemStack stack, MultiBufferSource buffer) {
                RenderContext.translate(0.5F, 0F, 0F);
                RenderContext.scale(2.5F, 2.5F, 2.5F);
            }

            @Override
            public void renderCommon(ItemStack stack, MultiBufferSource buffer) {
                RenderContext.scale(0.5F, 0.5F, 0.5F);
                RenderContext.mulPose(Axis.YP.rotationDegrees(90F));
                bindTexture(ResourceManager.CHUNGUS_TEX);
                ResourceManager.chungus.renderPart("Body");
                ResourceManager.chungus.renderPart("Lever");
                ResourceManager.chungus.renderPart("Blades");
            }
        };
    }
}
