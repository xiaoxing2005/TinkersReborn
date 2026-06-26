package mctbl.tinkersreborn.tools.modifiers;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntityDamageSource;

import com.google.common.collect.ImmutableList;

import mctbl.tinkersreborn.TinkersReborn;
import mctbl.tinkersreborn.common.particle.TinkersRebornParticle;
import mctbl.tinkersreborn.library.tools.modifiers.ModifierNBT;
import mctbl.tinkersreborn.library.tools.modifiers.ModifierTrait;
import mctbl.tinkersreborn.util.TinkersRebornUtils;
import mctbl.tinkersreborn.util.ToolTagsHelper;

public class ModFiery extends ModifierTrait {

    public ModFiery() {
        super("fiery", 0xEA9E32, 5, 25);
    }

    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage,
        boolean isCritical) {
        dealFireDamage(tool, player, target);
    }

    protected void dealFireDamage(ItemStack tool, EntityLivingBase attacker, EntityLivingBase target) {
        NBTTagCompound tag = ToolTagsHelper.getModifierTag(tool, identifier);
        ModifierNBT.IntegerNBT data = ModifierNBT.readInteger(tag);

        int duration = getFireDuration(data);
        target.setFire(duration);

        // one heart fire damage per 15
        float fireDamage = getFireDamage(data);
        if (attackEntitySecondary(
            new EntityDamageSource("onFire", attacker).setFireDamage(),
            fireDamage,
            target,
            false,
            true)) {
            int count = Math.round(fireDamage);
            TinkersReborn.proxy.spawnEffectParticle(TinkersRebornParticle.Type.HEART_FIRE, target, count);
        }
    }

    private float getFireDamage(ModifierNBT.IntegerNBT data) {
        return (float) data.current / 15f;
    }

    private int getFireDuration(ModifierNBT.IntegerNBT data) {
        return 1 + data.current / 8;
    }

    @Override
    public List<String> getExtraInfo(ItemStack tool, NBTTagCompound modifierTag) {
        String loc = String.format(LOC_Extra, getIdentifier());
        ModifierNBT.IntegerNBT data = ModifierNBT.readInteger(modifierTag);
        int duration = getFireDuration(data);
        float dmg = getFireDamage(data);

        return ImmutableList.of(
            String.format(TinkersRebornUtils.translate(loc), TinkersRebornUtils.df.format(dmg)),
            String.format(TinkersRebornUtils.translate(loc + 2), TinkersRebornUtils.df.format(duration)));
    }
}
