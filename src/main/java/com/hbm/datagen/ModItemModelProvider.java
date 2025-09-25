package com.hbm.datagen;

import com.hbm.HBMsNTM;
import com.hbm.blocks.ModBlocks;
import com.hbm.items.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HBMsNTM.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.NOTHING.get());
        basicItem(ModItems.GEIGER_COUNTER.get());
        basicItem(ModItems.DOSIMETER.get());
        basicItem(ModItems.DETONATOR_DE.get());
        basicItem(ModItems.DETONATOR_DEADMAN.get());
        handheldItem(ModItems.REACHER.get());
        handheldItem(ModItems.DETONATOR.get());
        handheldItem(ModItems.MULTI_DETONATOR.get());
        basicItem(ModItems.DUCK_SPAWN_EGG.get());

        basicItem(ModItems.KEY.get());
        basicItem(ModItems.KEY_RED.get());
        basicItem(ModItems.KEY_KIT.get());
        basicItem(ModItems.KEY_FAKE.get());
        basicItem(ModItems.PIN.get());

        withExistingParent(ModBlocks.GAS_COAL.getId().getPath(), "item/generated")
                .texture("layer0", modLoc("block/gas_coal"));

        ItemModelBuilder builder = getBuilder("polaroid")
                .parent(getExistingFile(mcLoc("item/generated")));
        for (int i = 1; i <= 18; i++) {
            builder.override()
                    .predicate(ResourceLocation.fromNamespaceAndPath(HBMsNTM.MODID, "polaroid_id"), i)
                    .model(getBuilder("polaroid_" + i)
                            .parent(getExistingFile(mcLoc("item/generated")))
                            .texture("layer0", modLoc("item/polaroids/polaroid_" + i)))
                    .end();
        }
    }
}