package mctbl.tinkersreborn.tools.traits;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.PlayerEvent;

import com.google.common.collect.ImmutableList;

import mctbl.tinkersreborn.library.tools.traits.AbstractTrait;
import mctbl.tinkersreborn.util.TinkersRebornUtils;
import mctbl.tinkersreborn.util.ToolTagsHelper;

public class TraitStonebound extends AbstractTrait {

    public TraitStonebound() {
        super("stonebound", EnumChatFormatting.DARK_GRAY);
    }

    private double calcBonus(ItemStack tool) {
        int durability = ToolTagsHelper.getCurrentDurability(tool);
        int maxDurability = ToolTagsHelper.getMaxDurability(tool);

        // old tcon stonebound formula
        return Math.log((maxDurability - durability) / 72d + 1d) * 2;
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        if (ToolTagsHelper.isToolEffective(tool, event.block, event.metadata)) {
            // TinkersReborn.LOG.info("TraitStonebound adding speed {}", calcBonus(tool));
            event.newSpeed += calcBonus(tool);
        }
    }

    @Override
    public List<String> getExtraInfo(ItemStack tool, NBTTagCompound modifierTag) {
        String loc = TinkersRebornUtils.translate(String.format(LOC_Extra, identifier));

        return ImmutableList.of(String.format(loc, TinkersRebornUtils.df.format(calcBonus(tool))));
    }
}
