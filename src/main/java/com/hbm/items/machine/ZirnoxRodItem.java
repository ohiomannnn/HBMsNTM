package com.hbm.items.machine;

import com.hbm.inventory.MetaHelper;
import com.hbm.items.EnumMultiItem;
import com.hbm.util.EnumUtil;
import com.hbm.util.TagsUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

public class ZirnoxRodItem extends EnumMultiItem {

    public ZirnoxRodItem(Properties properties) {
        super(properties, ZirnoxType.class, true, true);
    }

    public static void incrementLifeTime(ItemStack stack) {

        CompoundTag tag = TagsUtil.getCustomData(stack);
        int time = tag.getInt("life");
        tag.putInt("life", time + 1);
        TagsUtil.putCustomData(stack, tag);
    }

    public static void setLifeTime(ItemStack stack, int time) {

        CompoundTag tag = TagsUtil.getCustomData(stack);
        tag.putInt("life", time);
        TagsUtil.putCustomData(stack, tag);
    }

    public static int getLifeTime(ItemStack stack) {
        return TagsUtil.getCustomData(stack).getInt("life");
    }

    @Override public boolean isBarVisible(ItemStack stack) { return this.getBarWidth(stack) > 0; }

    @Override
    public int getBarWidth(ItemStack stack) {
        ZirnoxType num = EnumUtil.grabEnumSafely(theEnum, MetaHelper.getMeta(stack));
        return getLifeTime(stack) / num.maxLife;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        ZirnoxType num = EnumUtil.grabEnumSafely(theEnum, MetaHelper.getMeta(stack));
        int ratio = getLifeTime(stack) / num.maxLife;
        return Mth.hsvToRgb(ratio / 3F, 1.0F, 1.0F);
    }

    public enum ZirnoxType {
        NATURAL_URANIUM_FUEL(250_000, 30),
        URANIUM_FUEL(200_000, 50),
        TH232(20_000, 0, true),
        THORIUM_FUEL(200_000, 40),
        MOX_FUEL(165_000, 75),
        PLUTONIUM_FUEL(175_000, 65),
        U233_FUEL(150_000, 100),
        U235_FUEL(165_000, 85),
        LES_FUEL(150_000, 150),
        LITHIUM(20_000, 0, true),
        ZFB_MOX(50_000, 35);

        public final int maxLife;
        public final int heat;
        public final boolean breeding;

        ZirnoxType(int life, int heat, boolean breeding) {
            this.maxLife = life;
            this.heat = heat;
            this.breeding = breeding;
        }

        ZirnoxType(int life, int heat) {
            this.maxLife = life;
            this.heat = heat;
            this.breeding = false;
        }
    }
}
