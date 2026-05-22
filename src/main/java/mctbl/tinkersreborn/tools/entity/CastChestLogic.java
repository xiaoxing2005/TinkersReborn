package mctbl.tinkersreborn.tools.entity;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import mctbl.tinkersreborn.library.entity.TinkersRebornChestLogic;
import mctbl.tinkersreborn.tools.inventory.CastChestContainer;

public class CastChestLogic extends TinkersRebornChestLogic {

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return false;
    }

    public boolean isItemValid(ItemStack itemstack) {
        return true;
    }

    @Override
    public String getDefaultName() {
        return "tinkersreborn.CastChest";
    }

    @Override
    public Container getGuiContainer(InventoryPlayer inventoryplayer, World world, int x, int y, int z) {
        return new CastChestContainer(inventoryplayer, this);
    }

}
