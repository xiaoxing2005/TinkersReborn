package mctbl.tinkersreborn.tools.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import mctbl.tinkersreborn.library.inventory.TinkersRebornContainer;
import mctbl.tinkersreborn.tools.entity.TinkersRebornToolStationLogic;
import mctbl.tinkersreborn.tools.inventory.slots.SlotTool;

public class TinkersRebornToolStationContainer extends TinkersRebornContainer {

    public TinkersRebornToolStationLogic logic;
    public Slot[] slots;
    public SlotTool toolSlot;

    public TinkersRebornToolStationContainer(InventoryPlayer inventoryplayer,
        TinkersRebornToolStationLogic builderlogic) {
        super(inventoryplayer);
        this.invPlayer = inventoryplayer;
        this.logic = builderlogic;

        this.toolSlot = new SlotTool(inventoryplayer.player, builderlogic, 0, 225, 38);
        this.slots = new Slot[] { new Slot(builderlogic, 1, 167, 29), new Slot(builderlogic, 2, 149, 38),
            new Slot(builderlogic, 3, 167, 47) };

        this.addSlotToContainer(this.toolSlot);
        for (Slot s : this.slots) {
            this.addSlotToContainer(s);
        }

        this.bindPlayerInventory();
    }

    public TinkersRebornToolStationContainer(InventoryPlayer inventoryplayer) {
        // for tool forge
        super(inventoryplayer);
    }

    // posX and posY must be the same length
    public void resetSlots(int[] posX, int[] posY) {
        /* Station inventory */
        this.inventorySlots.clear();
        this.inventoryItemStacks.clear();

        this.addSlotToContainer(this.toolSlot);
        for (int iter = 0; iter < 3; iter++) {
            this.slots[iter].xDisplayPosition = posX[iter] + 111;
            this.slots[iter].yDisplayPosition = posY[iter] + 1;
            addSlotToContainer(slots[iter]);
        }

        this.bindPlayerInventory();
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return logic.isUseableByPlayer(entityplayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotID) {
        return null;
    }

    protected void craftTool(ItemStack stack) {

    }

    protected boolean mergeCraftedStack(ItemStack stack, int slotsStart, int slotsTotal, boolean playerInventory,
        EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack slotClick(int slotId, int clickedButton, int mode, EntityPlayer player) {
        return null;
    }
}
