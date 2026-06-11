package mctbl.tinkersreborn.tools.entity;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import mctbl.tinkersreborn.tools.gui.GuiToolForge;
import mctbl.tinkersreborn.tools.inventory.TinkersRebornToolForgeContainer;

public class TinkersRebornToolForgeLogic extends TinkersRebornToolStationLogic {

    public ItemStack previousTool;
    public String toolName;

    public TinkersRebornToolForgeLogic() {
        super(5);
        toolName = "";
    }

    @Override
    public String getDefaultName() {
        return "tinkersreborn.ToolForge";
    }

    @Override
    public Container getGuiContainer(InventoryPlayer inventoryplayer, World world, int x, int y, int z) {
        return new TinkersRebornToolForgeContainer(inventoryplayer, this);
    }

    @Override
    public GuiContainer getGui(InventoryPlayer inventoryplayer, World world, int x, int y, int z) {
        return new GuiToolForge(inventoryplayer, null, world, x, y, z);
    }

}
