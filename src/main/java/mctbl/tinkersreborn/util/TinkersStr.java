package mctbl.tinkersreborn.util;

import net.minecraft.util.StatCollector;

import mctbl.tinkersreborn.TinkersReborn;

public enum TinkersStr {

    ;

    static String modPrefix = TinkersReborn.MODID;
    String localization;

    TinkersStr(String localization) {
        this.localization = localization;
    }

    public static String translate(String string) {
        return StatCollector.translateToLocal(string);
    }

    public String getUnlocalizationStr() {
        return modPrefix + this.localization;
    }

    public String getLocalizationStr() {
        return translate(this.getUnlocalizationStr());
    }

    @Override
    public String toString() {
        return this.getLocalizationStr();
    }
}
