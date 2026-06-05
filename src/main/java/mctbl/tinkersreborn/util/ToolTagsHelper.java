package mctbl.tinkersreborn.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class ToolTagsHelper {

    public static int TAG_TYPE_STRING = Constants.NBT.TAG_STRING;
    public static int TAG_TYPE_COMPOUND = Constants.NBT.TAG_COMPOUND;
    private static String TOOLBASETAG = ToolTags.TOOLBASETAG;

    private ToolTagsHelper() {}

    /* Generic Tag Operations */
    public static NBTTagCompound getTagSafe(ItemStack stack) {
        // yes, the null checks aren't needed anymore, but they don't hurt either.
        // After all the whole purpose of this function is safety/processing possibly
        // invalid input ;)
        if (stack == null || stack.getItem() == null || stack.stackSize == 0 || !stack.hasTagCompound())
            return new NBTTagCompound();

        return stack.getTagCompound();
    }

    public static NBTTagCompound getTagSafe(NBTTagCompound tag, String key) {
        if (tag == null || !tag.hasKey(key)) {
            return new NBTTagCompound();
        }
        return tag.getCompoundTag(key);
    }

    public static NBTTagList getTagListSafe(NBTTagCompound tag, String key, int type) {
        if (tag == null || !tag.hasKey(key)) {
            return new NBTTagList();
        }
        return tag.getTagList(key, type);
    }

    public static NBTTagList getStringTagListSafe(NBTTagCompound tag, String key) {
        return getTagListSafe(tag, key, TAG_TYPE_STRING);
    }

    public static NBTTagCompound getToolBaseNBTSafe(ItemStack stack) {
        return getTagSafe(getTagSafe(stack), TOOLBASETAG);
    }

}
