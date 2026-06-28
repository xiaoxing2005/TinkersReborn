package mctbl.tinkersreborn.tools.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import mctbl.tinkersreborn.library.inventory.ContainerSideInventory;
import mctbl.tinkersreborn.tools.entity.CastChestLogic;
import mctbl.tinkersreborn.tools.inventory.slots.SlotStencil;

public class ContainerCastChest extends ContainerTinkerStation<CastChestLogic> {

    protected ContainerSideInventory<CastChestLogic> inventory;

    public ContainerCastChest(InventoryPlayer inventoryplayer, CastChestLogic chest) {
        super(chest);
        // chest inventory. we have it as a module
        inventory = new DynamicChestInventory(tile, tile, 8, 18, 8); // columns don't matter since they get set by gui
        this.addSubContainer(inventory, true);

        // player inventory
        this.addPlayerInventory(inventoryplayer, 8, 84);
    }

    public static class DynamicChestInventory extends ContainerSideInventory<CastChestLogic> {

        public DynamicChestInventory(CastChestLogic tile, IInventory inventory, int x, int y, int columns) {
            super(tile, x, y, columns);

            // add the theoretically possible slots
            while (this.inventorySlots.size() < CastChestLogic.MAX_INVENTORY) {
                this.addSlotToContainer(createSlot(tile, this.inventorySlots.size(), 0, 0));
            }
        }

        @Override
        protected Slot createSlot(IInventory inventory, int index, int x, int y) {
            return new SlotPatternChest(tile, index, x, y);
        }
    }

    public static class SlotPatternChest extends SlotStencil {

        public final CastChestLogic patternChest;

        public SlotPatternChest(CastChestLogic inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition, false);

            this.patternChest = inventoryIn;
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return patternChest.isItemValidForSlot(getSlotIndex(), stack); // slot parameter is unused
        }
    }
}
