package mctbl.tinkersreborn.tools.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import mctbl.tinkersreborn.library.inventory.ContainerSideInventory;
import mctbl.tinkersreborn.tools.entity.PartChestLogic;

public class ContainerPartChest extends ContainerTinkerStation<PartChestLogic> {

    protected ContainerSideInventory<PartChestLogic> inventory;

    public ContainerPartChest(InventoryPlayer inventoryplayer, PartChestLogic chest) {
        super(chest);
        // chest inventory. we have it as a module
        inventory = new DynamicChestInventory(tile, tile, 8, 18, 8); // columns don't matter since they get set by gui
        this.addSubContainer(inventory, true);

        // player inventory
        this.addPlayerInventory(inventoryplayer, 8, 84);
    }

    public static class DynamicChestInventory extends ContainerSideInventory<PartChestLogic> {

        public DynamicChestInventory(PartChestLogic tile, IInventory inventory, int x, int y, int columns) {
            super(tile, x, y, columns);

            // add the theoretically possible slots
            while (this.inventorySlots.size() < PartChestLogic.MAX_INVENTORY) {
                this.addSlotToContainer(createSlot(tile, this.inventorySlots.size(), 0, 0));
            }
        }

        @Override
        protected Slot createSlot(IInventory inventory, int index, int x, int y) {
            return new SlotPartChest(tile, index, x, y);
        }
    }

    public static class SlotPartChest extends Slot {

        public final PartChestLogic castChest;

        public SlotPartChest(PartChestLogic inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);

            this.castChest = inventoryIn;
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return castChest.isItemValidForSlot(getSlotIndex(), stack); // slot parameter is unused
        }
    }
}
