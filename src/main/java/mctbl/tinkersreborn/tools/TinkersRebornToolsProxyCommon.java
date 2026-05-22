package mctbl.tinkersreborn.tools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;
import mctbl.tinkersreborn.ClientProxy;
import mctbl.tinkersreborn.library.entity.TinkersRebornInventoryLogic;

public class TinkersRebornToolsProxyCommon implements IGuiHandler {

    public static final int toolStationID = 0;
    public static final int partBuilderID = 1;
    public static final int partChestID = 2;
    public static final int castChestID = 3;
    public static final int toolForgeID = 4;
    public static final int craftingStationID = 5;

    public static final int frypanGuiID = 99;
    public static final int furnaceID = 99;
    public static final int battlesignTextID = 99;

    public TinkersRebornToolsProxyCommon() {}

    public void initialize() {
        registerGuiHandler();
    }

    protected void registerGuiHandler() {
        ClientProxy.registerServerGuiHandler(toolStationID, this);
        ClientProxy.registerServerGuiHandler(partBuilderID, this);
        ClientProxy.registerServerGuiHandler(partChestID, this);
        ClientProxy.registerServerGuiHandler(castChestID, this);
        ClientProxy.registerServerGuiHandler(toolForgeID, this);
        ClientProxy.registerServerGuiHandler(craftingStationID, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TinkersRebornInventoryLogic l) {
            return l.getGuiContainer(player.inventory, world, x, y, z);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

}
