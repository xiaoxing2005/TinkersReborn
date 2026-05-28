package mctbl.tinkersreborn.util;

import java.text.DecimalFormat;
import java.util.Locale;

import net.minecraft.util.StatCollector;

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
}
