package mctbl.tinkersreborn.library.blocks;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.util.ForgeDirection;

public interface ITinkersRebornIFacingLogic {

    public byte getRenderDirection();

    public ForgeDirection getForgeDirection();

    public void setFrogeDirection(ForgeDirection direction);

    public void setRenderDirection(int side);

    public void setRenderDirection(float yaw, float pitch, EntityLivingBase player);
}
