package mctbl.tinkersreborn.tools.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import mctbl.tinkersreborn.library.tools.traits.AbstractTrait;

// You're so cheap, repairing gives you a bonus
public class TraitCheap extends AbstractTrait {

    public TraitCheap() {
        super("cheap", EnumChatFormatting.DARK_GRAY);
    }

    @Override
    public int onToolHeal(ItemStack tool, int amount, int newAmount, EntityLivingBase entity) {
        // 5% bonus durability repaired!
        return newAmount + amount * 5 / 100;
    }
}
