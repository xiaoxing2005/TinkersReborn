package mctbl.tinkersreborn.library.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import mctbl.tinkersreborn.library.utils.BlockPos;

/**
 * Blocks implementing this interface are part of the tinker station GUI system
 */
public interface ITinkersToolStationBlock {

    /**
     * Used for sorting the tabs in the UI. Tabs are sorted from low to high.
     * Duplicate entries will be treated as the same and their blocks will be ignored.
     *
     * Values used:
     * 10 - Stencil Table
     * 15 - Pattern Chest
     * 20 - Part Builder
     * 25 - Tool Station/Forge
     * 50 - Crafting Station
     */
    int getGuiNumber(Block block);

    /**
     * Open the gui of this block for the given player. Same as BlockInventory.openGui, coincidentally! ;)
     */
    boolean openGui(EntityPlayer player, World world, BlockPos pos);

}
