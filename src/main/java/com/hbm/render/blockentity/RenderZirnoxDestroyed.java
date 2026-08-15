package com.hbm.render.blockentity;

import com.hbm.blockentity.machine.ZirnoxDestroyedBlockEntity;
import com.hbm.blocks.DummyableBlock;
import com.hbm.main.ResourceManager;
import com.hbm.render.util.RenderContext;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;

public class RenderZirnoxDestroyed extends BlockEntityRendererNT<ZirnoxDestroyedBlockEntity> {

    @Override public BlockEntityRenderer<ZirnoxDestroyedBlockEntity> create(Context context) { return new RenderZirnoxDestroyed(); }

    @Override
    public void render(ZirnoxDestroyedBlockEntity be, MultiBufferSource buffer, float partialTicks) {

        RenderContext.translate(0.5F, 0F, 0.5F);

        Direction facing = be.getBlockState().getValue(DummyableBlock.FACING);
        switch(facing) {
            case NORTH -> RenderContext.mulPose(Axis.YP.rotationDegrees(90F));
            case SOUTH -> RenderContext.mulPose(Axis.YP.rotationDegrees(270F));
            case WEST -> RenderContext.mulPose(Axis.YP.rotationDegrees(180F));
            case EAST -> RenderContext.mulPose(Axis.YP.rotationDegrees(0F));
        }

        RenderSystem.disableCull();
        bindTexture(ResourceManager.ZIRNOX_DESTROYED_TEX); ResourceManager.zirnox_destroyed.renderAll();
        RenderSystem.enableCull();
    }

    @Override
    public int getPacketLight(int packedLight, ZirnoxDestroyedBlockEntity be) {
        if(be.getLevel() != null && be.getBlockState().getBlock() instanceof DummyableBlock dummy) {
            return LevelRenderer.getLightColor(be.getLevel(), be.getBlockPos().above(dummy.getDimensions()[0]));
        }
        return packedLight;
    }

}
