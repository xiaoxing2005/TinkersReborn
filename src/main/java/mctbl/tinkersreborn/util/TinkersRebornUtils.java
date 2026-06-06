package mctbl.tinkersreborn.util;

import java.text.DecimalFormat;
import java.util.Locale;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;

import org.lwjgl.input.Keyboard;

public class TinkersRebornUtils {

    public static DecimalFormat df = new DecimalFormat("##.##");

    /**
     * Removes all whitespaces from the given string and makes it lowerspace.
     */
    public static String sanitizeLocalizationString(String string) {
        return string.toLowerCase(Locale.US)
            .replaceAll(" ", "");
    }

    public static String translate(String string) {
        return StatCollector.translateToLocal(string);
    }

    public static void ensureOreIsRegistered(String oreDict, ItemStack stack) {
        if (OreDictionary.getOreIDs(stack).length == 0) OreDictionary.registerOre(oreDict, stack);
    }

    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }

    /*
     * Code for ctl and shift down from TicTooltips by squeek502
     * https://github.com/squeek502/TiC-Tooltips/blob/1.7.10/java/squeek/tictooltips
     * /helpers/KeyHelper.java
     */
    public static boolean isCtrlKeyDown() {
        // prioritize CONTROL, but allow OPTION as well on Mac (note: GuiScreen's
        // isCtrlKeyDown only checks for the OPTION key on Mac)
        boolean isCtrlKeyDown = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
        if (!isCtrlKeyDown && Minecraft.isRunningOnMac) {
            isCtrlKeyDown = Keyboard.isKeyDown(Keyboard.KEY_LMETA) || Keyboard.isKeyDown(Keyboard.KEY_RMETA);
        }
        return isCtrlKeyDown;
    }
}
