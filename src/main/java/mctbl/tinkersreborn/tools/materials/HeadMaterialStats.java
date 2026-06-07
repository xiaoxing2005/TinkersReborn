package mctbl.tinkersreborn.tools.materials;

import static mctbl.tinkersreborn.util.TinkersRebornUtils.translate;

import java.util.ArrayList;
import java.util.List;

import mctbl.tinkersreborn.library.materials.AbstractMaterialStats;
import mctbl.tinkersreborn.library.materials.MaterialStatusType;
import mctbl.tinkersreborn.library.utils.MiningLevelHelper;
import mctbl.tinkersreborn.library.utils.MiningLevelHelper.MiningLevel;
import mctbl.tinkersreborn.util.ColorUtil;

public class HeadMaterialStats extends AbstractMaterialStats {

    public final static String LOC_Durability = "tinkersreborn.stat.head.durability.name";
    public final static String LOC_MiningSpeed = "tinkersreborn.stat.head.miningspeed.name";
    public final static String LOC_Attack = "tinkersreborn.stat.head.attack.name";
    public final static String LOC_HarvestLevel = "tinkersreborn.stat.head.harvestlevel.name";

    public final static String LOC_DurabilityDesc = "tinkersreborn.stat.head.durability.desc";
    public final static String LOC_MiningSpeedDesc = "tinkersreborn.stat.head.miningspeed.desc";
    public final static String LOC_AttackDesc = "tinkersreborn.stat.head.attack.desc";
    public final static String LOC_HarvestLevelDesc = "tinkersreborn.stat.head.harvestlevel.desc";

    public final int durability; // usually between 1 and 1000
    public final int harvestLevel; // see HarvestLevels class
    public final float attack; // usually between 0 and 10 (in 1/2 hearts, so divide by 2 for damage in hearts)
    public final float miningspeed; // usually between 1 and 10

    public HeadMaterialStats(int durability, int harvestLevel, float attack, float miningspeed) {
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.attack = attack;
        this.miningspeed = miningspeed;
    }

    @Override
    public MaterialStatusType getIdentifier() {
        return MaterialStatusType.HEAD;
    }

    @Override
    public String getLocalizedName() {
        return translate("stat.head.name");
    }

    @Override
    public List<String> getLocalizedInfo() {
        List<String> info = new ArrayList<>();

        if (durability != 0) info.add(formatDurability(this.durability));
        info.add(formatHarvestLevel(this.harvestLevel));
        if (miningspeed != 0) info.add(formatMiningSpeed(this.miningspeed));
        if (attack != 0) info.add(formatAttack(this.attack));

        return info;
    }

    @Override
    public List<String> getLocalizedDesc() {
        List<String> info = new ArrayList<>();

        if (durability != 0) info.add(translate(LOC_DurabilityDesc));
        info.add(translate(LOC_HarvestLevelDesc));
        if (miningspeed != 0) info.add(translate(LOC_MiningSpeedDesc));
        if (attack != 0) info.add(translate(LOC_AttackDesc));

        return info;
    }

    public static String formatHarvestLevel(int harvestLevel) {
        MiningLevel miningLevel = MiningLevelHelper.getMiningLevel(harvestLevel);
        return format(LOC_HarvestLevel, miningLevel.getColorHex(), miningLevel.getLocalization());
    }

    public static String formatDurability(int durability) {
        return format(LOC_Durability, COLOR_Durability, durability);
    }

    public static String formatDurability(int durability, int maxDurability) {
        return String
            .format("%s: %s", translate(LOC_Durability), ColorUtil.formatPartialAmount(durability, maxDurability));
    }

    public static String formatMiningSpeed(float miningspeed) {
        return format(LOC_MiningSpeed, COLOR_Speed, miningspeed);
    }

    public static String formatAttack(float attack) {
        return format(LOC_Attack, COLOR_Attack, attack);
    }
}
