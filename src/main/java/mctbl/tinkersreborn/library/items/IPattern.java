package mctbl.tinkersreborn.library.items;

import net.minecraft.item.ItemStack;

import mctbl.tinkersreborn.library.materials.TinkersRebornMaterial;

public interface IPattern {

    int getPatternCost(ItemStack pattern);

    ItemStack getPatternOutput(ItemStack pattern, ItemStack input, TinkersRebornMaterial material);
}
