package mctbl.tinkersreborn.tools.modifiers;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.google.common.collect.ImmutableList;

import mctbl.tinkersreborn.library.tools.modifiers.ModifierNBT;
import mctbl.tinkersreborn.library.tools.modifiers.ModifierTrait;
import mctbl.tinkersreborn.util.TinkersRebornUtils;
import mctbl.tinkersreborn.util.ToolTagsHelper;

public class ModNecrotic extends ModifierTrait {

    public ModNecrotic() {
        super("necrotic", 0x5E0000, 5, 0);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt,
        boolean wasCritical, boolean wasHit) {
        if (wasHit) {
            float amount = damageDealt * lifesteal(ToolTagsHelper.getModifierTag(tool, getIdentifier()));
            if (amount > 0) {
                // LOG.info("ModNecrotic heal you {}", amount);
                player.heal(amount);
            }
        }
    }

    private float lifesteal(NBTTagCompound modifierNBT) {
        ModifierNBT data = new ModifierNBT(modifierNBT);
        return 0.05F * data.level;
    }

    @Override
    public List<String> getExtraInfo(ItemStack tool, NBTTagCompound modifierTag) {
        String loc = TinkersRebornUtils.translate(String.format(LOC_Extra, getIdentifier()));
        float amount = lifesteal(modifierTag);

        return ImmutableList.of(String.format(loc, TinkersRebornUtils.dfPercent.format(amount)));
    }
}
