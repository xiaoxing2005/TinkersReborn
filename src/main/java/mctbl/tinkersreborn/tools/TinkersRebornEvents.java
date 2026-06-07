package mctbl.tinkersreborn.tools;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mctbl.tinkersreborn.library.tools.ToolCore;

public class TinkersRebornEvents {

    @SubscribeEvent
    public void tinkersToolTooltipEvent(ItemTooltipEvent e) {
        // use this to prevent vailnila durability display
        if (e.itemStack.getItem() instanceof ToolCore) e.toolTip.removeIf(s -> s.startsWith("Durability: "));
    }

}
