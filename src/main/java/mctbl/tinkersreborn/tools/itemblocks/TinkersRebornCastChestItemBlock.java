package mctbl.tinkersreborn.tools.itemblocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class TinkersRebornCastChestItemBlock extends ItemBlock {

    public TinkersRebornCastChestItemBlock(Block b) {
        super(b);
        this.setMaxDamage(0);
        this.setUnlocalizedName("tinkersreborn.CastChest");
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tinkersreborn.CastChest";
    }

    @Override
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List<String> p_77624_3_,
        boolean p_77624_4_) {
        super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
    }
}
