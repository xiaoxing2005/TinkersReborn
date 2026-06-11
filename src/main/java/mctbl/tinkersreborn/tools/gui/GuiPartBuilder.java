package mctbl.tinkersreborn.tools.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mctbl.tinkersreborn.tools.entity.TinkersRebornPartBuilderLogic;
import mctbl.tinkersreborn.tools.inventory.TinkersRebornPartBuilderContainer;
import mctbl.tinkersreborn.util.ColorUtil;
import mctbl.tinkersreborn.util.TinkersStr;

@SideOnly(Side.CLIENT)
public class GuiPartBuilder extends GuiContainer {

    public TinkersRebornPartBuilderLogic logic;
    public TinkersRebornPartBuilderContainer toolSlots;
    String title;

    public GuiPartBuilder(InventoryPlayer inventoryplayer, TinkersRebornPartBuilderLogic stationlogic, World world,
        int x, int y, int z) {
        super(stationlogic.getGuiContainer(inventoryplayer, world, x, y, z));
        this.logic = stationlogic;

        // this.drawChestPart = inventorySlots instanceof PartCrafterChestContainer;

        this.title = ColorUtil.addUnderLine(TinkersStr.partCrafterTitle.toString());
    }

    @Override
    public void initGui() {
        // TODO Auto-generated method stub
        super.initGui();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        // TODO Auto-generated method stub
        // func_146110_a == drawModalRectWithCustomSizedTexture
        // func_152125_a == drawScaledCustomSizeModalRect
    }

}
