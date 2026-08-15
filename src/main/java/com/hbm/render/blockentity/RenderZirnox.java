package com.hbm.render.blockentity;

import com.hbm.blockentity.machine.ReactorZirnoxBlockEntity;
import com.hbm.blocks.DummyableBlock;
import com.hbm.blocks.NtmBlocks;
import com.hbm.main.ResourceManager;
import com.hbm.render.item.ItemRenderBase;
import com.hbm.render.util.RenderContext;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class RenderZirnox extends BlockEntityRendererNT<ReactorZirnoxBlockEntity> implements IBEWLRProvider {

    @Override public BlockEntityRenderer<ReactorZirnoxBlockEntity> create(Context context) { return new RenderZirnox(); }

    @Override
    public void render(ReactorZirnoxBlockEntity be, MultiBufferSource buffer, float partialTicks) {

        RenderContext.translate(0.5F, 0F, 0.5F);

        if(be.tilted) {
            RenderContext.translate(0F, -0.5F, 0F);
            RenderContext.mulPose(Axis.ZP.rotationDegrees(10F));
            RenderContext.mulPose(Axis.YP.rotationDegrees(5F));
        }

        Direction facing = be.getBlockState().getValue(DummyableBlock.FACING);
        switch(facing) {
            case NORTH -> RenderContext.mulPose(Axis.YP.rotationDegrees(90F));
            case SOUTH -> RenderContext.mulPose(Axis.YP.rotationDegrees(270F));
            case WEST -> RenderContext.mulPose(Axis.YP.rotationDegrees(180F));
            case EAST -> RenderContext.mulPose(Axis.YP.rotationDegrees(0F));
        }

        RenderSystem.disableCull();
        bindTexture(ResourceManager.ZIRNOX_TEX); ResourceManager.zirnox.renderAll();
        RenderSystem.enableCull();
    }

    @Override
    public int getPacketLight(int packedLight, ReactorZirnoxBlockEntity be) {
        if(be.getLevel() != null && be.getBlockState().getBlock() instanceof DummyableBlock dummy) {
            return LevelRenderer.getLightColor(be.getLevel(), be.getBlockPos().above(dummy.getDimensions()[0]));
        }
        return packedLight;
    }

    @Override
    public Item getItemForRenderer() {
        return NtmBlocks.REACTOR_ZIRNOX.asItem();
    }

    @Override
    public BlockEntityWithoutLevelRenderer getRenderer() {
        return new ItemRenderBase() {
            @Override
            public void renderInventory(ItemStack stack, MultiBufferSource buffer) {
                RenderContext.translate(0F, -2F, 0F);
                RenderContext.scale(2.8F, 2.8F, 2.8F);
            }

            @Override
            public void renderCommon(ItemStack stack, MultiBufferSource buffer) {
                RenderContext.scale(0.75F, 0.75F, 0.75F);
                bindTexture(ResourceManager.ZIRNOX_TEX); ResourceManager.zirnox.renderAll();
            }
        };
    }
}
