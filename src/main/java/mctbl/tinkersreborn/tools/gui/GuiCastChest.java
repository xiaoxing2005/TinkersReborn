package mctbl.tinkersreborn.tools.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mctbl.tinkersreborn.tools.entity.CastChestLogic;

@SideOnly(Side.CLIENT)
public class GuiCastChest extends GuiContainer {

    public CastChestLogic logic;

    public static int xSize = 194;
    public static int ySize = 168;

    public GuiCastChest(InventoryPlayer inventoryplayer, CastChestLogic holder, World world, int x, int y, int z) {
        super(holder.getGuiContainer(inventoryplayer, world, x, y, z));
        logic = holder;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        // TODO Auto-generated method stub

    }

}
