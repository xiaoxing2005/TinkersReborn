package mctbl.tinkersreborn.tools.traits;

import net.minecraft.nbt.NBTTagCompound;

import mctbl.tinkersreborn.library.tools.traits.AbstractTrait;
import mctbl.tinkersreborn.util.ToolTagsHelper;

/** A general trait that adds damage to tools */
public class TraitBonusDamage extends AbstractTrait {

    protected final float damage;

    public TraitBonusDamage(String identifier, float damage) {
        super(identifier, 0xffffff);

        this.damage = damage;
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        // apply bonus damage if it hasn't been applied yet
        if (!ToolTagsHelper.hasModifier(rootCompound, identifier)) {
            // +damage
            ToolTagsHelper.setAttackStat(rootCompound, ToolTagsHelper.getAttackStat(rootCompound) + damage);
        }
        super.applyEffect(rootCompound, modifierTag);
    }
}
