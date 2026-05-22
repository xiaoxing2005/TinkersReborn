package mctbl.tinkersreborn.tools.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import mctbl.tinkersreborn.tools.entity.CraftingStationLogic;

public class GuiCraftingStation extends GuiContainer {

    CraftingStationLogic logic;

    public GuiCraftingStation(InventoryPlayer inventory, CraftingStationLogic logic, World world, int x, int y, int z) {
        super(logic.getGuiContainer(inventory, world, x, y, z));
        this.logic = logic;

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        // TODO Auto-generated method stub

    }

}
