package mctbl.tinkersreborn.tools.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class TinkersRebornCastChestItemBlock extends ItemBlock {

    public TinkersRebornCastChestItemBlock(Block b) {
        super(b);
        this.setMaxDamage(0);
        this.setUnlocalizedName("tinkersreborn.CastChest");
    }

}
