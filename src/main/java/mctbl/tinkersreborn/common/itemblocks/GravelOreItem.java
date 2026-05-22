package mctbl.tinkersreborn.common.itemblocks;

import net.minecraft.block.Block;

import mctbl.tinkersreborn.TinkersRebornConfig;
import mctbl.tinkersreborn.library.itemblocks.TinkersRebornItemBlock;

public class GravelOreItem extends TinkersRebornItemBlock {

    public GravelOreItem(Block b) {
        super(b, "block.ore.tinkersreborn.gravel", TinkersRebornConfig.gravelOreTypes);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

}
