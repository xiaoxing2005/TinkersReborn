package mctbl.tinkersreborn.tools.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

import mctbl.tinkersreborn.tools.entity.TinkersRebornToolForgeLogic;
import mctbl.tinkersreborn.tools.inventory.slots.SlotTool;

public class TinkersRebornToolForgeContainer extends TinkersRebornToolStationContainer {

    public TinkersRebornToolForgeContainer(InventoryPlayer inventoryplayer, TinkersRebornToolForgeLogic builderlogic) {
        super(inventoryplayer);
        this.invPlayer = inventoryplayer;
        this.logic = builderlogic;

        this.toolSlot = new SlotTool(inventoryplayer.player, builderlogic, 0, 225, 38);
        this.slots = new Slot[] { new Slot(builderlogic, 1, 167, 29), new Slot(builderlogic, 2, 149, 38),
            new Slot(builderlogic, 3, 167, 47), new Slot(builderlogic, 4, 167, 47 + 18) };

        this.addSlotToContainer(this.toolSlot);
        for (Slot s : this.slots) {
            this.addSlotToContainer(s);
        }

        this.bindPlayerInventory();
    }
}
