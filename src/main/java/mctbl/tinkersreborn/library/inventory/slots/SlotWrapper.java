package mctbl.tinkersreborn.library.inventory.slots;

import javax.annotation.Nonnull;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Used to wrap the slots inside Modules/Subcontainers
 */
public class SlotWrapper extends Slot {

    public final Slot parent;

    public SlotWrapper(Slot slot) {
        super(slot.inventory, slot.getSlotIndex(), slot.xDisplayPosition, slot.yDisplayPosition);
        this.parent = slot;
    }

    @Override
    public void onSlotChange(ItemStack p_75220_1_, ItemStack p_75220_2_) {
        parent.onSlotChange(p_75220_1_, p_75220_2_);
    }

    @Override
    public void onSlotChanged() {
        parent.onSlotChanged();
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return parent.isItemValid(stack);
    }

    @Override
    public boolean canTakeStack(EntityPlayer playerIn) {
        return parent.canTakeStack(playerIn);
    }

    @Override
    public void putStack(@Nonnull ItemStack stack) {
        parent.putStack(stack);
    }

    @Override
    public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack) {
        parent.onPickupFromSlot(playerIn, stack);
    }

    @Override
    @Nonnull
    public ItemStack getStack() {
        return parent.getStack();
    }

    @Override
    public boolean getHasStack() {
        return parent.getHasStack();
    }

    @Override
    public int getSlotStackLimit() {
        return parent.getSlotStackLimit();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getBackgroundIconIndex() {
        return parent.getBackgroundIconIndex();
    }

    @Override
    public ItemStack decrStackSize(int amount) {
        return parent.decrStackSize(amount);
    }

    @Override
    public boolean isSlotInInventory(IInventory inv, int slotIn) {
        return parent.isSlotInInventory(inv, slotIn);
    }

    @Override
    public ResourceLocation getBackgroundIconTexture() {
        return parent.getBackgroundIconTexture();
    }

    @Override
    public void setBackgroundIcon(IIcon icon) {
        parent.setBackgroundIcon(icon);
    }

    @Override
    public void setBackgroundIconTexture(ResourceLocation texture) {
        parent.setBackgroundIconTexture(texture);
    }

}
