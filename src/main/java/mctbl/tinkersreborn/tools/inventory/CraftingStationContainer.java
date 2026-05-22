package mctbl.tinkersreborn.tools.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import mctbl.tinkersreborn.library.inventory.InventoryCraftingStation;
import mctbl.tinkersreborn.library.inventory.InventoryCraftingStationResult;
import mctbl.tinkersreborn.library.inventory.TinkersRebornContainer;
import mctbl.tinkersreborn.tools.entity.CraftingStationLogic;

public class CraftingStationContainer extends TinkersRebornContainer {

    private final World worldObj;
    private final int posX;
    private final int posY;
    private final int posZ;

    /**
     * The crafting matrix inventory (3x3).
     */
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    public CraftingStationLogic station;
    public EntityPlayer player;

    public CraftingStationContainer(InventoryPlayer inventoryplayer, CraftingStationLogic l) {
        super(inventoryplayer);
        this.station = l;
        this.worldObj = l.getWorldObj();
        this.posX = l.xCoord;
        this.posY = l.yCoord;
        this.posZ = l.zCoord;
        this.player = inventoryplayer.player;
        craftMatrix = new InventoryCraftingStation(this, 3, 3, station);
        craftResult = new InventoryCraftingStationResult(station);

        // 0 - crafting slot
        this.addSlotToContainer(
            new SlotCraftingStation(inventoryplayer.player, this.craftMatrix, this.craftResult, 0, 0, 35));
        // 1 - 9 - Crafting Matrix
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                this.addSlotToContainer(new Slot(this.craftMatrix, col + row * 3, 0 + col * 18, 17 + row * 18));
            }
        }

        this.bindPlayerInventory();
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);

        if (!this.worldObj.isRemote) {
            for (int i = 0; i < 9; ++i) {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null) {
                    entityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return station.isUseableByPlayer(entityplayer);
    }

    public class SlotCraftingStation extends SlotCrafting {

        private final IInventory matrix;
        private final EntityPlayer player;

        public SlotCraftingStation(EntityPlayer par1EntityPlayer, IInventory par2IInventory, IInventory par3iInventory,
            int par4, int par5, int par6) {
            super(par1EntityPlayer, par2IInventory, par3iInventory, par4, par5, par6);
            this.matrix = par2IInventory;
            this.player = par1EntityPlayer;
        }

        @Override
        public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
            super.onPickupFromSlot(player, stack);
        }
    }
}
