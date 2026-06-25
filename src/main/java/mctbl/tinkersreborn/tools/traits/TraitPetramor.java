package mctbl.tinkersreborn.tools.traits;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import mctbl.tinkersreborn.library.tools.traits.AbstractTrait;
import mctbl.tinkersreborn.library.utils.BlockPos;
import mctbl.tinkersreborn.util.ToolTagsHelper;

public class TraitPetramor extends AbstractTrait {

    private static final float chance = 0.1f;

    public TraitPetramor() {
        super("petramor", EnumChatFormatting.RED);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, Block block, BlockPos pos, EntityLivingBase player,
        boolean wasEffective) {
        if (!world.isRemote && block.getMaterial() == Material.rock && random.nextFloat() < chance) {
            // TinkersReborn.LOG.info("TraitPetramor like stone!");
            ToolTagsHelper.healTool(tool, 5, player);
        }
    }
}
