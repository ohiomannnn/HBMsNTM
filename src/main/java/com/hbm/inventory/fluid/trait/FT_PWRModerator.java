package com.hbm.inventory.fluid.trait;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import net.minecraft.network.chat.Component;

import java.io.IOException;
import java.util.List;

public class FT_PWRModerator extends FluidTrait {

    private double multiplier;
    public FT_PWRModerator(){}
    public FT_PWRModerator(double mulitplier) {
        this.multiplier = mulitplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    @Override
    public void addInfo(List<Component> info) {
        //todo
    }

    @Override
    public void addInfoHidden(List<Component> info) {
        //todo
    }

    @Override
    public void serializeJSON(JsonWriter writer) throws IOException {
        writer.name("multiplier").value(multiplier);
    }

    @Override
    public void deserializeJSON(JsonObject obj) {
        this.multiplier = obj.get("multiplier").getAsDouble();
    }
}
