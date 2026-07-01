package mctbl.tinkersreborn.library.entity;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class TinkersRebornChestLogic extends TinkersRebornInventoryLogic {

    public static final int MAX_INVENTORY = 256;
    // how big the 'perceived' inventory is
    public int actualSize;

    public TinkersRebornChestLogic() {
        this(MAX_INVENTORY);
    }

    public TinkersRebornChestLogic(int inventorySize) {
        super(inventorySize);
        this.actualSize = 1;
    }

    public TinkersRebornChestLogic(int inventorySize, int maxStackSize) {
        super(inventorySize, maxStackSize);
        this.actualSize = 1;
    }

    @Override
    public int getSizeInventory() {
        return MAX_INVENTORY;
    }

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    public boolean insertItemStackIntoInventory(ItemStack stack) {
        for (int i = 0; i < this.inventory.length; i++) {
            if (this.inventory[i] == null) {
                this.inventory[i] = stack.copy();
                stack.stackSize = 0;
                this.markDirty();
                return true;
            }
        }
        return false;
    }

    @Override
    public abstract boolean isItemValidForSlot(int slot, ItemStack itemstack);

    @Override
    public abstract String getDefaultName();

    @Override
    public abstract Container getGuiContainer(InventoryPlayer inventoryplayer, World world, int x, int y, int z);

}
