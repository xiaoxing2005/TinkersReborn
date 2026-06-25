package mctbl.tinkersreborn.tools.traits;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerEvent;

import com.google.common.collect.ImmutableList;

import mctbl.tinkersreborn.library.tools.traits.AbstractTrait;
import mctbl.tinkersreborn.util.TinkersRebornUtils;

public class TraitLightweight extends AbstractTrait {

    private final float bonus = 0.1f;

    public TraitLightweight() {
        super("lightweight", 0x00ff00);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        super.applyEffect(rootCompound, modifierTag);
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        // 10% bonus speed
        // TinkersReborn.LOG.info("TraitLightweight mining faster!");
        event.newSpeed = event.newSpeed * (1 + bonus);
    }

    @Override
    public List<String> getExtraInfo(ItemStack tool, NBTTagCompound modifierTag) {
        String loc = TinkersRebornUtils.translate(String.format(LOC_Extra, identifier));

        return ImmutableList.of(String.format(loc, TinkersRebornUtils.dfPercent.format(bonus)));
    }
}
