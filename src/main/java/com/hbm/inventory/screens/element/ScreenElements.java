package com.hbm.inventory.screens.element;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import org.joml.Vector3f;

public class ScreenElements {

    public static void drawSmoothGauge(int x, int y, float progress, float tipLength, float backLength, float backSide, int color) {
        drawSmoothGauge(x, y, progress, tipLength, backLength, backSide, color, 0xFF000000);
    }

    private static final Vector3f tip = new Vector3f();
    private static final Vector3f left = new Vector3f();
    private static final Vector3f right = new Vector3f();

    public static void drawSmoothGauge(int x, int y, float progress, float tipLength, float backLength, float backSide, int color, int colorOuter) {

        progress = Mth.clamp(progress, 0, 1);

        // -progress * 270 - 45 became this because we are using Vector3f
        float angle = (float) Math.toRadians(progress * 270 + 45);

        tip.set(0, tipLength, 0);
        left.set(backSide, -backLength, 0);
        right.set(-backSide, -backLength, 0);

        tip.rotateZ(angle);
        left.rotateZ(angle);
        right.rotateZ(angle);

        float mult = 1.5F;

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        BufferBuilder buffer = Tesselator.getInstance().begin(VertexFormat.Mode.TRIANGLES, DefaultVertexFormat.POSITION_COLOR);
        buffer.addVertex(x + tip.x * mult, y + tip.y * mult, 1F).setColor(colorOuter);
        buffer.addVertex(x + left.x * mult, y + left.y * mult, 1F).setColor(colorOuter);
        buffer.addVertex(x + right.x * mult, y + right.y * mult, 1F).setColor(colorOuter);
        buffer.addVertex(x + tip.x, y + tip.y, 1F).setColor(color);
        buffer.addVertex(x + left.x, y + left.y, 1F).setColor(color);
        buffer.addVertex(x + right.x, y + right.y, 1F).setColor(color);
        BufferUploader.drawWithShader(buffer.buildOrThrow());
    }

    public static void drawSmoothLinearGauge(int x, int y, float progress, float tipLength, float backLength, float backSide, float scale, float rotation, int color) {
        drawSmoothLinearGauge(x, y, progress, tipLength, backLength, backSide, scale, rotation, color, 0xFF000000);
    }

    private static final Vector3f bLeft = new Vector3f();
    private static final Vector3f bRight = new Vector3f();

    public static void drawSmoothLinearGauge(int x, int y, float progress, float tipLength, float backLength, float backSide, float scale, float rotation, int color, int colorOuter) {

        scale = Math.max(scale, 1);
        progress = Math.clamp(progress, 0, 1) * scale;

        tip.set(0, -tipLength, 0);
        right.set(-backSide, 0, 0);
        bRight.set(-backSide, backLength, 0);
        bLeft.set(backSide, backLength, 0);
        left.set(backSide, 0, 0);

        float angle = (float) Math.toRadians(rotation);

        tip.rotateZ(angle);
        right.rotateZ(angle);
        bRight.rotateZ(angle);
        bLeft.rotateZ(angle);
        left.rotateZ(angle);

        float deltaX = progress * Mth.cos(angle);
        float deltaY = progress * Mth.sin(angle);

        float mult = 1.5F;

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        BufferBuilder buffer = Tesselator.getInstance().begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
        buffer.addVertex(x + deltaX + tip.x * mult, y + deltaY + tip.y * mult, 1F).setColor(colorOuter);
        buffer.addVertex(x + deltaX + right.x * mult, y + deltaY + right.y * mult, 1F).setColor(colorOuter);
        buffer.addVertex(x + deltaX + bRight.x * mult, y + deltaY + bRight.y, 1F).setColor(colorOuter);
        buffer.addVertex(x + deltaX + bLeft.x * mult,  y + deltaY + bLeft.y, 1F).setColor(colorOuter);
        buffer.addVertex(x + deltaX + left.x * mult, y + deltaY + left.y * mult, 1F).setColor(colorOuter);
        BufferUploader.drawWithShader(buffer.buildOrThrow());

        buffer = Tesselator.getInstance().begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
        buffer.addVertex(x + deltaX + tip.x, y + deltaY + tip.y, 1F).setColor(color);
        buffer.addVertex(x + deltaX + right.x, y + deltaY + right.y, 1F).setColor(color);
        buffer.addVertex(x + deltaX + bRight.x, y + deltaY + bRight.y, 1F).setColor(color);
        buffer.addVertex(x + deltaX + bLeft.x, y + deltaY + bLeft.y, 1F).setColor(color);
        buffer.addVertex(x + deltaX + left.x, y + deltaY + left.y, 1F).setColor(color);
        BufferUploader.drawWithShader(buffer.buildOrThrow());
    }
}
