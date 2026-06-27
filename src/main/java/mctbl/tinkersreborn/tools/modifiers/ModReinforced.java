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

public class ModReinforced extends ModifierTrait {

    private static final float chancePerLevel = 0.20f;
    public static final String TAG_UNBREAKABLE = "Unbreakable";

    public ModReinforced() {
        super("reinforced", 0x502E83, 5, 0);
    }

    private float getReinforcedChance(NBTTagCompound modifierTag) {
        ModifierNBT data = ModifierNBT.readTag(modifierTag);

        return (float) data.level * chancePerLevel;
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        super.applyEffect(rootCompound, modifierTag);

        if (getReinforcedChance(modifierTag) >= 1f) {
            rootCompound.setBoolean(TAG_UNBREAKABLE, true);
        }
    }

    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        if (entity.worldObj.isRemote) {
            return 0;
        }

        // get reinforced level
        NBTTagCompound tag = ToolTagsHelper.getModifierTag(tool, getIdentifier());

        float chance = getReinforcedChance(tag);
        if (chance >= random.nextFloat()) {
            newDamage -= damage;
        }
        return Math.max(0, newDamage);
    }

    @Override
    public String getLocalizedDesc() {
        return String.format(super.getLocalizedDesc(), TinkersRebornUtils.dfPercent.format(chancePerLevel));
    }

    @Override
    public String getTooltip(NBTTagCompound modifierTag, boolean detailed) {
        ModifierNBT data = ModifierNBT.readTag(modifierTag);
        if (data.level == maxLevel) {
            return TinkersRebornUtils.translate(String.format("modifier.%s.unbreakable", getIdentifier()));
        }
        return super.getTooltip(modifierTag, detailed);
    }

    @Override
    public List<String> getExtraInfo(ItemStack tool, NBTTagCompound modifierTag) {
        String loc = TinkersRebornUtils.translate(String.format(LOC_Extra, getIdentifier()));

        float chance = getReinforcedChance(modifierTag);
        String chanceStr = chance >= 1f
            ? TinkersRebornUtils.translate(String.format("modifier.%s.unbreakable", getIdentifier()))
            : TinkersRebornUtils.dfPercent.format(chance);

        return ImmutableList.of(String.format(loc, chanceStr));
    }
}
