package mctbl.tinkersreborn.library.inventory;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

import mctbl.tinkersreborn.TinkersReborn;

public class TinkersRebornContainer extends Container {

    public InventoryPlayer invPlayer;
    public Random random = TinkersReborn.random;

    public int playerInventoryStartX;
    public int playerInventoryStartY;

    public TinkersRebornContainer(InventoryPlayer inventoryplayer) {
        this(inventoryplayer, 118, 84);
    }

    public TinkersRebornContainer(InventoryPlayer invPlayer, int playerInventoryStartX, int playerInventoryStartY) {
        this.invPlayer = invPlayer;
        this.playerInventoryStartX = playerInventoryStartX;
        this.playerInventoryStartY = playerInventoryStartY;
    }

    public void bindPlayerInventory() {
        int playerInvX = this.playerInventoryStartX;
        int playerInvY = this.playerInventoryStartY;
        /* Player inventory */
        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 9; row++) {
                this.addSlotToContainer(new Slot(this.invPlayer, row + column * 9 + 9, playerInvX, playerInvY));
                playerInvX += 18;
            }
            playerInvX = this.playerInventoryStartX;
            playerInvY += 18;
        }
        playerInvY += 22;

        for (int column = 0; column < 9; column++) {
            this.addSlotToContainer(new Slot(this.invPlayer, column, playerInvX, playerInvY));
            playerInvX += 18;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return false;
    }

}
