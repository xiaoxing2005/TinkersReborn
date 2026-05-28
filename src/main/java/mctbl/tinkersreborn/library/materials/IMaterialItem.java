package mctbl.tinkersreborn.library.materials;

import net.minecraft.item.ItemStack;

/**
 * Items implementing this interface contain a material
 */
public interface IMaterialItem {

    /**
     * Returns the material identifier of the material of the part this itemstack holds.
     *
     * @return Identifier of a material or "Unknown", null or empty if invalid.
     */
    String getMaterialID(ItemStack stack);

    /**
     * Returns the material of the part this itemstack holds.
     *
     * @return TinkersRebornMaterial or TinkersRebornMaterial.UNKNOWN if invalid
     */
    TinkersRebornMaterial getMaterial(ItemStack stack);

    /**
     * Returns the item with the given material
     */
    ItemStack getItemstackWithMaterial(TinkersRebornMaterial tinkersRebornMaterial);
}
