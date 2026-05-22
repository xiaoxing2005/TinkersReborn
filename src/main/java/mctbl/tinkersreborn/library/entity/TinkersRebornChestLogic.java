package mctbl.tinkersreborn.library.entity;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class TinkersRebornChestLogic extends TinkersRebornInventoryLogic {

    public TinkersRebornChestLogic() {
        super(36);
    }

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public String getInventoryName() {
        return getDefaultName();
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
