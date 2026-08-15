package com.hbm.inventory.menus;

import com.hbm.blockentity.machine.ReactorZirnoxBlockEntity;
import com.hbm.inventory.NtmMenuTypes;
import com.hbm.inventory.SlotTakeOnly;
import com.hbm.util.CompatExternal;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class ReactorZirnoxMenu extends MenuBase<ReactorZirnoxBlockEntity> {

    public ReactorZirnoxMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, (ReactorZirnoxBlockEntity) CompatExternal.getCoreFromPos(inventory.player.level, extraData.readBlockPos()));
    }

    public ReactorZirnoxMenu(int id, Inventory inventory, ReactorZirnoxBlockEntity be) {
        super(NtmMenuTypes.REACTOR_ZIRNOX.get(), id, be);

        // Rods
        this.addSlot(new Slot(be, 0, 26, 16));
        this.addSlot(new Slot(be, 1, 62, 16));
        this.addSlot(new Slot(be, 2, 98, 16));
        this.addSlot(new Slot(be, 3, 8, 34));
        this.addSlot(new Slot(be, 4, 44, 34));
        this.addSlot(new Slot(be, 5, 80, 34));
        this.addSlot(new Slot(be, 6, 116, 34));
        this.addSlot(new Slot(be, 7, 26, 52));
        this.addSlot(new Slot(be, 8, 62, 52));
        this.addSlot(new Slot(be, 9, 98, 52));
        this.addSlot(new Slot(be, 10, 8, 70));
        this.addSlot(new Slot(be, 11, 44, 70));
        this.addSlot(new Slot(be, 12, 80, 70));
        this.addSlot(new Slot(be, 13, 116, 70));
        this.addSlot(new Slot(be, 14, 26, 88));
        this.addSlot(new Slot(be, 15, 62, 88));
        this.addSlot(new Slot(be, 16, 98, 88));
        this.addSlot(new Slot(be, 17, 8, 106));
        this.addSlot(new Slot(be, 18, 44, 106));
        this.addSlot(new Slot(be, 19, 80, 106));
        this.addSlot(new Slot(be, 20, 116, 106));
        this.addSlot(new Slot(be, 21, 26, 124));
        this.addSlot(new Slot(be, 22, 62, 124));
        this.addSlot(new Slot(be, 23, 98, 124));

        // Fluid IO
        this.addSlot(new Slot(be, 24, 143, 124));
        this.addSlot(new SlotTakeOnly(be, 26, 143, 142));
        this.addSlot(new Slot(be, 25, 179, 124));
        this.addSlot(new SlotTakeOnly(be, 27, 179, 142));

        this.playerInv(inventory, 8, 174);
    }
}
