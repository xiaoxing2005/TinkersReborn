package mctbl.tinkersreborn.library.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import mctbl.tinkersreborn.TinkersRebornConfig;
import mctbl.tinkersreborn.util.ColorUtil;

public final class MiningLevelHelper {

    private MiningLevelHelper() {}

    public static Map<String, MiningLevel> nameToLevel = new HashMap<>();
    public static List<MiningLevel> levelList = new ArrayList<>();

    static {
        int idx = 0;
        for (String s : TinkersRebornConfig.miningLevels) {
            String prefix = s.substring(0, 2);
            String local = s.substring(2);
            MiningLevel newLevel = new MiningLevel(idx, prefix, local);
            levelList.add(newLevel);
            nameToLevel.put(local, newLevel);

            idx++;
        }
    }

    public static class MiningLevel {

        public int levelIdx;
        public int color;
        public String colorPrefix;
        public String localString;

        private MiningLevel(int levelIdx, String colorPrefix, String localString) {
            this(
                levelIdx,
                ColorUtil.enumChatFormattingToColor(
                    EnumChatFormatting.getValueByName(String.valueOf(colorPrefix.charAt(1)))),
                colorPrefix,
                localString);
        }

        private MiningLevel(int levelIdx, int color, String colorPrefix, String localString) {
            this.levelIdx = levelIdx;
            this.color = color;
            this.colorPrefix = colorPrefix;
            this.localString = localString;
        }

        public String getLocalization() {
            return StatCollector.translateToLocal(this.localString);
        }

        public String getColorHex() {
            return Integer.toHexString(this.color)
                .toUpperCase();
        }
    }
}
