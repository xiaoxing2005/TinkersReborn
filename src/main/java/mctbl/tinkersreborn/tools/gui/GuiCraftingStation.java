package mctbl.tinkersreborn.tools.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mctbl.tinkersreborn.library.gui.GuiModule;
import mctbl.tinkersreborn.library.gui.GuiSideInventory;
import mctbl.tinkersreborn.library.inventory.ContainerSideInventory;
import mctbl.tinkersreborn.library.utils.BlockPos;
import mctbl.tinkersreborn.tools.entity.CraftingStationLogic;
import mctbl.tinkersreborn.tools.inventory.ContainerCraftingStation;
import mctbl.tinkersreborn.tools.inventory.ContainerTinkerStation;

@SideOnly(Side.CLIENT)
public class GuiCraftingStation extends GuiTinkerStation {

    private static final ResourceLocation BACKGROUND = new ResourceLocation(
        "textures/gui/container/crafting_table.png");
    protected final CraftingStationLogic tile;

    public GuiCraftingStation(InventoryPlayer playerInv, World world, BlockPos pos, CraftingStationLogic tile) {
        super(world, pos, (ContainerTinkerStation<?>) tile.getGuiContainer(playerInv, world, pos.x, pos.y, pos.z));

        this.tile = tile;

        if (inventorySlots instanceof ContainerCraftingStation) {
            ContainerCraftingStation container = (ContainerCraftingStation) inventorySlots;
            ContainerSideInventory chestContainer = container.getSubContainer(ContainerSideInventory.class);
            if (chestContainer != null) {
                // if(chestContainer.getTile() instanceof TileEntityChest) {
                // // Fix: chests don't update their single/double chest status clientside once accessed
                // ((TileEntityChest) chestContainer.getTile()).doubleChestHandler = null;
                // }
                this.addModule(
                    new GuiSideInventory(this, chestContainer, chestContainer.getSlotCount(), chestContainer.columns));
            }
        }
    }

    public boolean isSlotInChestInventory(Slot slot) {
        GuiModule module = getModuleForSlot(slot.slotNumber);
        return module instanceof GuiSideInventory;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        drawBackground(BACKGROUND);

        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    }

}
