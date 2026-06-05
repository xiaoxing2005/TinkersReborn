package mctbl.tinkersreborn.library.crafting;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import mctbl.tinkersreborn.library.TinkersRebornRegistry;
import mctbl.tinkersreborn.library.materials.TinkersRebornMaterial;
import mctbl.tinkersreborn.library.tools.ToolCore;

public class ToolBuilderHelper {

    private ToolBuilderHelper() {}

    public static ToolBuilderHelper instance = new ToolBuilderHelper();

    public ItemStack buildTool(String toolName, ItemStack... parts) {
        ToolCore core = findMatchingToolCore(parts);
        if (core == null)
            // build fail because can't find match recipce
            return null;
        List<TinkersRebornMaterial> materials = new ArrayList<>();
        for (ItemStack stack : parts) {
            materials.add(TinkersRebornRegistry.getMaterialById(stack.getItemDamage()));
        }

        ItemStack newTool = new ItemStack(core);
        newTool.setTagCompound(core.buildItemNBT(materials));
        return newTool;
    }

    private ToolCore findMatchingToolCore(ItemStack[] parts) {
        for (ToolCore core : TinkersRebornRegistry.tools)
            // because define there has only 4 parts at max
            if (core.checkRecipeMatch(parts)) return core;
        return null;
    }
}
