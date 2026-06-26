package mctbl.tinkersreborn.tools.modifiers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import mctbl.tinkersreborn.library.tools.modifiers.ModifierNBT;
import mctbl.tinkersreborn.library.tools.modifiers.ModifierTrait;
import mctbl.tinkersreborn.util.ToolTagsHelper;

public class ModKnockback extends ModifierTrait {

    public ModKnockback() {
        super("knockback", 0x9f9f9f, 99, 10); // the sky is the limit, wheeeee
    }

    @Override
    public float knockBack(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage,
        float knockback, float newKnockback, boolean isCritical) {
        return newKnockback + calcKnockback(ToolTagsHelper.getModifierTag(tool, identifier));
    }

    protected float calcKnockback(NBTTagCompound modifierTag) {
        ModifierNBT.IntegerNBT data = ModifierNBT.readInteger(modifierTag);
        return (float) data.current * 0.1f;
    }
}
