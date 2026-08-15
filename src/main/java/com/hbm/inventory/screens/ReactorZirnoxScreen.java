package com.hbm.inventory.screens;

import com.hbm.blockentity.machine.ReactorZirnoxBlockEntity;
import com.hbm.inventory.menus.ReactorZirnoxMenu;
import com.hbm.inventory.screens.element.ScreenElements;
import com.hbm.main.NuclearTechMod;
import com.hbm.network.toserver.CompoundTagControl;
import com.hbm.registry.NtmSoundEvents;
import com.hbm.util.i18n.I18nUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.ArrayList;
import java.util.List;

public class ReactorZirnoxScreen extends InfoScreen<ReactorZirnoxMenu> {

    private static final ResourceLocation TEXTURE = NuclearTechMod.withDefaultNamespace("textures/gui/reactors/gui_zirnox.png");

    private final ReactorZirnoxBlockEntity be;

    public ReactorZirnoxScreen(ReactorZirnoxMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);

        this.be = menu.be;

        this.imageWidth = 203;
        this.imageHeight = 256;
    }

    @Override
    protected void init() {
        super.init();

        this.titleLabelX = this.imageWidth / 2 - this.font.width(this.title) / 2;
        this.titleLabelY = 6;
        this.inventoryLabelX = 8;
        this.inventoryLabelY = this.imageHeight - 96 + 2;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        be.steam.renderTankTooltip(guiGraphics, mouseX, mouseY, this.leftPos + 160, this.topPos + 108, 18, 12);
        be.carbonDioxide.renderTankTooltip(guiGraphics, mouseX, mouseY, this.leftPos + 142, this.topPos + 108, 18, 12);
        be.water.renderTankTooltip(guiGraphics, mouseX, mouseY, this.leftPos + 178, this.topPos + 108, 18, 12);
        this.drawCustomInfoStat(guiGraphics, mouseX, mouseY, this.leftPos + 160, this.topPos + 33, 18, 17, Component.translatable("container.zirnox.temp0"), Component.translatable("container.zirnox.temp1", Math.round((be.heat) * 0.00001 * 780 + 20)));
        this.drawCustomInfoStat(guiGraphics, mouseX, mouseY, this.leftPos + 178, this.topPos + 33, 18, 17, Component.translatable("container.zirnox.bars0"), Component.translatable("container.zirnox.bars1", Math.round((be.pressure) * 0.00001 * 30)));

        List<Component> coolantText = new ArrayList<>(); for(String s : I18nUtil.resolveKeyArray("container.zirnox.coolant")) coolantText.add(Component.literal(s));
        this.drawCustomInfoStat(guiGraphics, mouseX, mouseY, this.leftPos - 16, this.topPos + 36, 16, 16, this.leftPos - 8, this.topPos + 36 + 16, coolantText);

        List<Component> pressureText = new ArrayList<>(); for(String s : I18nUtil.resolveKeyArray("container.zirnox.pressure")) pressureText.add(Component.literal(s));
        this.drawCustomInfoStat(guiGraphics, mouseX, mouseY, this.leftPos - 16, this.topPos + 36 + 16, 16, 16, this.leftPos - 8, this.topPos + 36 + 16 + 16, pressureText);

        if(be.water.getFill() <= 0) {
            List<Component> warningText = new ArrayList<>(); for(String s : I18nUtil.resolveKeyArray("container.zirnox.warning.water")) warningText.add(Component.literal(s));
            this.drawCustomInfoStat(guiGraphics, mouseX, mouseY, this.leftPos - 16, this.topPos + 36 + 32, 16, 16, this.leftPos - 8, this.topPos + 36 + 32 + 16, warningText);
        }

        if(be.carbonDioxide.getFill() < 4000) {
            List<Component> warningText = new ArrayList<>(); for(String s : I18nUtil.resolveKeyArray("container.zirnox.warning.carbon")) warningText.add(Component.literal(s));
            this.drawCustomInfoStat(guiGraphics, mouseX, mouseY, this.leftPos - 16, this.topPos + 36 + 32 + 16, 16, 16, this.leftPos - 8, this.topPos + 36 + 32 + 16 + 16, warningText);
        }

        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    public boolean mouseClicked(double mouseX, double mouseY, int button) {

        CompoundTag tag = new CompoundTag();

        if(this.isHovered(mouseX, mouseY, 144, 35, 14, 14)) { this.minecraft.getSoundManager().play(SimpleSoundInstance.forUI(NtmSoundEvents.RBMK_AZ5_COVER.get(), 0.5F)); tag.putBoolean("control", true); }
        if(this.isHovered(mouseX, mouseY, 151, 51, 36, 36)) { this.minecraft.getSoundManager().play(SimpleSoundInstance.forUI(NtmSoundEvents.RBMK_AZ5_COVER.get(), 0.5F)); tag.putBoolean("vent", true); }

        if(!tag.isEmpty()) PacketDistributor.sendToServer(new CompoundTagControl(tag, be.getBlockPos()));

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int partialTicks) {
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, imageWidth, imageHeight);

        ScreenElements.drawSmoothLinearGauge(this.leftPos + 162, this.topPos + 114, (float) be.steam.getFill() / be.steam.getMaxFill(), 2, 5, 0.75F, 14F, 0, 0xFF7F0000);
        ScreenElements.drawSmoothLinearGauge(this.leftPos + 144, this.topPos + 114, (float) be.carbonDioxide.getFill() / be.carbonDioxide.getMaxFill(), 2, 5, 0.75F, 14, 0, 0xFF7F0000);
        ScreenElements.drawSmoothLinearGauge(this.leftPos + 180, this.topPos + 114, (float) be.water.getFill() / be.water.getMaxFill(), 2, 5, 0.75F, 14F, 0, 0xFF7F0000);

        ScreenElements.drawSmoothGauge(this.leftPos + 169, this.topPos + 42, be.heat / 100000F, 5, 2, 1, 0xFF7F0000);
        ScreenElements.drawSmoothGauge(this.leftPos + 187, this.topPos + 42, be.pressure / 100000F, 5, 2, 1, 0xFF7F0000);

        if(be.isOn) {
            for(int x = 0; x < 4; x++)
                for(int y = 0; y < 4; y++)
                   guiGraphics.blit(TEXTURE, this.leftPos + 7 + 36 * x, this.topPos + 15 + 36 * y, 238, 238, 18, 18);
            for(int x = 0; x < 3; x++)
                for(int y = 0; y < 3; y++)
                    guiGraphics.blit(TEXTURE, this.leftPos + 25 + 36 * x, this.topPos + 33 + 36 * y, 238, 238, 18, 18);
            guiGraphics.blit(TEXTURE, this.leftPos + 142, this.topPos + 15, 220, 238, 18, 18);
        }

        this.drawInfoPanel(guiGraphics, this.leftPos - 16, this.topPos + 36, 2);
        this.drawInfoPanel(guiGraphics, this.leftPos - 16, this.topPos + 36 + 16, 3);

        if(be.water.getFill() <= 0) this.drawInfoPanel(guiGraphics, this.leftPos - 16, this.topPos + 36 + 32, 6);
        if(be.carbonDioxide.getFill() <= 4000) this.drawInfoPanel(guiGraphics, this.leftPos - 16, this.topPos + 36 + 32 + 16, 6);
    }
}
