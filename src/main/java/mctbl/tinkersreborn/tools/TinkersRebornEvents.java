package mctbl.tinkersreborn.tools;

import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class TinkersRebornEvents {

    @SubscribeEvent
    public void onPlayerResporn(PlayerRespawnEvent e) {}

    @SubscribeEvent
    public void onAttackEvent(LivingAttackEvent e) {}

    @SubscribeEvent
    public void onLivingDrop(LivingDropsEvent e) {}

    @SubscribeEvent
    public void onPlayerDeath(PlayerDropsEvent e) {}
}
