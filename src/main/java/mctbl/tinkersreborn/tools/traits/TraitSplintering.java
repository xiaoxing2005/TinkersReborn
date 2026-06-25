package mctbl.tinkersreborn.tools.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import mctbl.tinkersreborn.library.entity.TinkersEntityProperties;
import mctbl.tinkersreborn.library.tools.traits.AbstractTrait;

public class TraitSplintering extends AbstractTrait {

    public TraitSplintering() {
        super("splintering", EnumChatFormatting.WHITE);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
        boolean isCritical) {
        TinkersEntityProperties props = TinkersEntityProperties.getProps(target);
        if (props != null) {
            // TinkersReborn.LOG.info("TraitSplintering before damage {}", newDamage);
            newDamage += 0.3f * (props.getLevel(identifier) + 1);
            // TinkersReborn.LOG.info("TraitSplintering after damage {}", newDamage);
        }

        return super.damage(tool, player, target, damage, newDamage, isCritical);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt,
        boolean wasCritical, boolean wasHit) {

        if (!player.worldObj.isRemote) {
            int level = 0;
            TinkersEntityProperties props = TinkersEntityProperties.getProps(target);
            if (props != null) {
                level = Math.min(5, props.getLevel(identifier) + 1);
            }

            // TinkersReborn.LOG.info("TraitSplintering apply level {}", level);

            // apply splinter effect
            props.apply(identifier, 40, level);
        }

        super.afterHit(tool, player, target, damageDealt, wasCritical, wasHit);
    }
}
