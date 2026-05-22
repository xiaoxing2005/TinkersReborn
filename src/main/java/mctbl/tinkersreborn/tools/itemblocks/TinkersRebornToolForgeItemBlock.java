package mctbl.tinkersreborn.tools.itemblocks;

import net.minecraft.block.Block;

import mctbl.tinkersreborn.library.itemblocks.TinkersRebornItemBlock;
import mctbl.tinkersreborn.tools.blocks.ToolForgeBlock;

public class TinkersRebornToolForgeItemBlock extends TinkersRebornItemBlock {

    public TinkersRebornToolForgeItemBlock(Block b) {
        super(b, "tinkersreborn.ToolForge", ToolForgeBlock.materials);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }
}
