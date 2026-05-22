package mctbl.tinkersreborn.library.inventory.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ActiveSlot extends Slot {

    protected boolean active;
    public int activeSlotNumber;

    public ActiveSlot(IInventory iinventory, int slotIndex, int xDisplayPosition, int yDisplayPosition, boolean flag) {
        super(iinventory, slotIndex, xDisplayPosition, yDisplayPosition);
        this.active = flag;
    }

    public void setActive(boolean flag) {
        this.active = flag;
    }

    public boolean getActive() {
        return this.active;
    }
}
