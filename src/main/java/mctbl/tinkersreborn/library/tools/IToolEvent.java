package mctbl.tinkersreborn.library.tools;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public abstract interface IToolEvent {

    // these are event base process
    public default void onPlayerResporn(PlayerRespawnEvent e) {};

    public default void onAttackEvent(LivingAttackEvent e) {};

    public default void onLivingDrop(LivingDropsEvent e) {};

    public default void onPlayerDeath(PlayerDropsEvent e) {};

    // these are item base event
    public abstract boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player);

    public abstract boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z,
        EntityLivingBase player);

    public abstract float getDigSpeed(ItemStack stack, Block block, int meta);

    public abstract boolean canHarvestBlock(Block par1Block, ItemStack itemStack);

    public abstract void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int slotId, boolean isInHand);

    public abstract boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity);

    public abstract boolean hitEntity(ItemStack stack, EntityLivingBase mob, EntityLivingBase player);

    public abstract ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player);

}
