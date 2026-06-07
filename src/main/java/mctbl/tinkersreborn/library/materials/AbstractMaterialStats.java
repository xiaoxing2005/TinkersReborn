package mctbl.tinkersreborn.library.materials;

import mctbl.tinkersreborn.util.TinkersRebornUtils;

public abstract class AbstractMaterialStats implements IMaterialStats {

    public final static String COLOR_Durability = "55FF55";
    public final static String COLOR_Speed = "78A0CD";
    public final static String COLOR_Attack = "D76464";
    public final static String COLOR_Multiplier = "B9B95A";
    public final static String COLOR_Modifier = COLOR_Multiplier;

    public final static String COLOR_Drawspeed = "808080";
    public final static String COLOR_Range = "8CAFAF";
    public final static String COLOR_Damage = "9B5041";

    public final static String COLOR_Accuracy = "CDAACD";

    public final static String formatBase = "%s: %s%s";

    public static String format(String s, String color, int data) {
        return format(s, color, String.valueOf(data));
    }

    public static String format(String s, String color, float data) {
        return format(s, color, TinkersRebornUtils.df.format(data));
    }

    public static String formatNumberPercent(String s, String color, float data) {
        return format(s, color, TinkersRebornUtils.dfPercent.format(data));
    }

    public static String format(String s, String color, String data) {
        return String.format(formatBase, TinkersRebornUtils.translate(s), color, data);
    }

}
