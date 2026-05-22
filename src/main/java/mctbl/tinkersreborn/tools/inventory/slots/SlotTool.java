package mctbl.tinkersreborn.tools.inventory.slots;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import mctbl.tinkersreborn.TinkersReborn;

public class SlotTool extends Slot {

    /** The player that is using the GUI where this slot resides. */
    public EntityPlayer player;

    Random random = TinkersReborn.random;

    public SlotTool(EntityPlayer entityplayer, IInventory builder, int par3, int par4, int par5) {
        super(builder, par3, par4, par5);
        this.player = entityplayer;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack stack) {
        return false;
        // return stack.getItem() instanceof ToolCore;
    }

    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack stack) {
        this.onCrafting(stack);
        // stack.setUnlocalizedName("\u00A7f" + toolName);
        super.onPickupFromSlot(par1EntityPlayer, stack);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    public void onCrafting(ItemStack stack, int par2) {
        // this.field_75228_b += par2;
        this.onCrafting(stack);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    public void onCrafting(ItemStack stack) {

    }
}
