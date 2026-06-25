package mctbl.tinkersreborn.tools;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mctbl.tinkersreborn.library.entity.TinkersEntityProperties;
import mctbl.tinkersreborn.library.tools.TinkerToolEvent;
import mctbl.tinkersreborn.library.tools.ToolCore;
import mctbl.tinkersreborn.util.ToolTagsHelper;

public class TinkersRebornToolsEventsHandler {

    @SubscribeEvent
    public void tinkersToolTooltipEvent(ItemTooltipEvent e) {
        // use this to prevent vailnila durability display
        if (e.itemStack.getItemDamage() != 0 && e.itemStack.getItem() instanceof ToolCore) {
            for (int idx = e.toolTip.size() - 1; idx >= 0; idx--) {
                if (e.toolTip.get(idx)
                    .startsWith("Durability: ")) {
                    e.toolTip.remove(e.toolTip.get(idx));
                    break;
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.entityLiving.worldObj.isRemote) return;

        TinkersEntityProperties props = TinkersEntityProperties.getProps(event.entityLiving);
        if (props != null) {
            props.tick();
        }
    }

    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityLivingBase) {
            event.entity.registerExtendedProperties(TinkersEntityProperties.IDENTIFIER, new TinkersEntityProperties());
        }
    }

    @SubscribeEvent
    public void mineSpeed(PlayerEvent.BreakSpeed event) {
        ItemStack tool = event.entityPlayer.inventory.getCurrentItem();

        if (isTool(tool) && !ToolTagsHelper.isBroken(tool)) {
            ToolTagsHelper.getTraitsOrdered(tool)
                .forEach(trait -> trait.miningSpeed(tool, event));
        }
    }

    @SubscribeEvent
    public void blockBreak(BlockEvent.BreakEvent event) {
        ItemStack tool = event.getPlayer().inventory.getCurrentItem();

        if (isTool(tool) && !ToolTagsHelper.isBroken(tool)) {
            ToolTagsHelper.getTraitsOrdered(tool)
                .forEach(trait -> trait.beforeBlockBreak(tool, event));
        }
    }

    @SubscribeEvent
    public void blockDropEvent(BlockEvent.HarvestDropsEvent event) {
        if (event.harvester == null) {
            return;
        }
        ItemStack tool = event.harvester.getHeldItem();

        if (isTool(tool) && !ToolTagsHelper.isBroken(tool)) {
            ToolTagsHelper.getTraitsOrdered(tool)
                .forEach(trait -> trait.blockHarvestDrops(tool, event));
        }
    }

    /**
     * Handles the onBlock or the onPlayerHurt trait callback. Note that only one of the two is called!
     */
    // @SubscribeEvent
    // public void playerBlockOrHurtEvent(LivingHurtEvent event) {
    // boolean isPlayerGettingDamaged = event.getEntityLiving() instanceof EntityPlayer;
    // boolean isClient = event.getEntityLiving().getEntityWorld().isRemote;
    // boolean isReflectedDamage = event.getSource() instanceof EntityDamageSource && ((EntityDamageSource)
    // event.getSource()).getIsThornsDamage();
    //
    // if(!isPlayerGettingDamaged || isClient || isReflectedDamage) {
    // return;
    // }
    // final EntityPlayer player = (EntityPlayer) event.getEntityLiving();
    // Entity attacker = event.getSource().getTrueSource();
    //
    // List<ItemStack> heldTools = new ArrayList<>();
    // for(ItemStack tool : event.getEntity().getHeldEquipment()) {
    // if(isTool(tool) && !ToolHelper.isBroken(tool)) {
    // heldTools.add(tool);
    // }
    // }
    //
    // // first handle block
    // if(player.isActiveItemStackBlocking()) {
    // // we allow block traits to affect both main and offhand
    // for(ItemStack tool : heldTools) {
    // if(!event.isCanceled()) {
    // TinkerUtil.getTraitsOrdered(tool).forEach(trait -> trait.onBlock(tool, player, event));
    // }
    // }
    // }
    // // else handle living hurt
    // else if(attacker instanceof EntityLivingBase && !attacker.isDead) {
    // // we allow block traits to affect both main and offhand
    // for(ItemStack tool : heldTools) {
    // if(!event.isCanceled()) {
    // TinkerUtil.getTraitsOrdered(tool).forEach(trait -> trait.onPlayerHurt(tool, player, (EntityLivingBase) attacker,
    // event));
    // }
    // }
    // }
    // }

    @SubscribeEvent
    public void onRepair(TinkerToolEvent.OnRepair event) {
        ItemStack tool = event.itemStack;

        ToolTagsHelper.getTraitsOrdered(tool)
            .forEach(trait -> trait.onRepair(tool, event.amount));
    }

    private boolean isTool(ItemStack stack) {
        return stack != null && stack.getItem() instanceof ToolCore;
    }
}
