package mctbl.tinkersreborn;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;
import mctbl.tinkersreborn.library.entity.TinkersRebornInventoryLogic;

public class CommonProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TinkersRebornInventoryLogic tinker) {
            return tinker.getGuiContainer(player.inventory, world, x, y, z);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TinkersRebornInventoryLogic tinker) {
            return tinker.getGui(player.inventory, world, x, y, z);
        }
        return null;
    }
}
