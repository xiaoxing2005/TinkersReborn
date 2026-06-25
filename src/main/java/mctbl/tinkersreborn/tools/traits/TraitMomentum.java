package mctbl.tinkersreborn.tools.traits;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;

import mctbl.tinkersreborn.library.entity.TinkersEntityProperties;
import mctbl.tinkersreborn.library.tools.traits.AbstractTrait;
import mctbl.tinkersreborn.library.utils.BlockPos;
import mctbl.tinkersreborn.util.ToolTagsHelper;

public class TraitMomentum extends AbstractTrait {

    public static final String MOMENTUM_KEY = "momentum";

    public TraitMomentum() {
        super(MOMENTUM_KEY, EnumChatFormatting.BLUE);
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        if (!event.entityPlayer.worldObj.isRemote) {
            TinkersEntityProperties props = TinkersEntityProperties.getProps(event.entityPlayer);

            float boost = props.getLevel(MOMENTUM_KEY);
            boost /= 80f; // 40% boost max

            // TinkersReborn.LOG.info(
            // "TraitMomentum faster faster faser! {} -> {}",
            // event.newSpeed,
            // event.newSpeed + event.originalSpeed * boost);

            event.newSpeed += event.originalSpeed * boost;
        }
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, Block block, BlockPos pos, EntityLivingBase player,
        boolean wasEffective) {
        if (!player.worldObj.isRemote) {
            int level = 1;
            TinkersEntityProperties props = TinkersEntityProperties.getProps(player);
            level += props.getLevel(MOMENTUM_KEY);

            level = Math.min(32, level);
            int duration = (int) ((10f / ToolTagsHelper.getActualMiningSpeed(tool)) * 1.5f * 20f);

            props.apply(MOMENTUM_KEY, duration, level);
        }

    }
}
