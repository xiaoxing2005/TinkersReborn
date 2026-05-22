package mctbl.tinkersreborn.common.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mctbl.tinkersreborn.common.TinkersRebornGeneral;
import mctbl.tinkersreborn.library.itemblocks.TinkersRebornItemBlock;

public class SlimeTallGrassItem extends TinkersRebornItemBlock {

    public static final String[] blockTypes = { "tallgrass", "tallgrass.fern" };

    public SlimeTallGrassItem(Block b) {
        super(b, "block.tinkersreborn.slime", blockTypes);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        int arr = MathHelper.clamp_int(meta, 0, blockTypes.length);
        return TinkersRebornGeneral.slimeTallGrass.getIcon(0, arr);
    }

}
