package mctbl.tinkersreborn.tools.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mctbl.tinkersreborn.library.entity.EnderferenceProperties;
import mctbl.tinkersreborn.library.tools.traits.AbstractTrait;

public class TraitEnderference extends AbstractTrait {

    public TraitEnderference() {
        super("enderference", EnumChatFormatting.DARK_AQUA);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage,
        boolean isCritical) {
        if (target instanceof EntityEnderman) {
            EnderferenceProperties props = getProps(target);
            if (props != null) {
                props.apply(100);
            }
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt,
        boolean wasCritical, boolean wasHit) {
        if (!wasHit) {
            EnderferenceProperties props = getProps(target);
            if (props != null) {
                props.apply(0);
            }
        }
    }

    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityLivingBase) {
            event.entity.registerExtendedProperties(EnderferenceProperties.IDENTIFIER, new EnderferenceProperties());
        }
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.entityLiving.worldObj.isRemote) return; // 只在服务端处理

        EnderferenceProperties props = getProps(event.entityLiving);
        if (props != null) {
            props.tick();
        }
    }

    @SubscribeEvent
    public void onEnderTeleport(EnderTeleportEvent event) {
        EnderferenceProperties props = getProps(event.entityLiving);
        if (props != null && props.isActive()) {
            event.setCanceled(true);
        }
    }

    public static EnderferenceProperties getProps(EntityLivingBase entity) {
        return (EnderferenceProperties) entity.getExtendedProperties(EnderferenceProperties.IDENTIFIER);
    }
}
