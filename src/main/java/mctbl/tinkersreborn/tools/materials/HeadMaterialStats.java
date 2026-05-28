package mctbl.tinkersreborn.tools.materials;

import java.util.ArrayList;
import java.util.List;

import mctbl.tinkersreborn.library.materials.AbstractMaterialStats;
import mctbl.tinkersreborn.library.materials.MaterialStatusType;
import mctbl.tinkersreborn.library.utils.MiningLevelHelper;
import mctbl.tinkersreborn.library.utils.MiningLevelHelper.MiningLevel;
import mctbl.tinkersreborn.util.TinkersRebornUtils;

public class HeadMaterialStats extends AbstractMaterialStats {

    public final static String LOC_Durability = "stat.head.durability.name";
    public final static String LOC_MiningSpeed = "stat.head.miningspeed.name";
    public final static String LOC_Attack = "stat.head.attack.name";
    public final static String LOC_HarvestLevel = "stat.head.harvestlevel.name";

    public final static String LOC_DurabilityDesc = "stat.head.durability.desc";
    public final static String LOC_MiningSpeedDesc = "stat.head.miningspeed.desc";
    public final static String LOC_AttackDesc = "stat.head.attack.desc";
    public final static String LOC_HarvestLevelDesc = "stat.head.harvestlevel.desc";

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
        return TinkersRebornUtils.translate("stat.head.name");
    }

    @Override
    public List<String> getLocalizedInfo() {
        List<String> info = new ArrayList<>();

        if (durability != 0) info.add(this.formatDurability());
        info.add(this.formatHarvestLevel());
        if (miningspeed != 0) info.add(this.formatMiningSpeed());
        if (attack != 0) info.add(this.formatAttack());

        return info;
    }

    @Override
    public List<String> getLocalizedDesc() {
        List<String> info = new ArrayList<>();

        if (durability != 0) info.add(TinkersRebornUtils.translate(LOC_DurabilityDesc));
        info.add(TinkersRebornUtils.translate(LOC_HarvestLevelDesc));
        if (miningspeed != 0) info.add(TinkersRebornUtils.translate(LOC_MiningSpeedDesc));
        if (attack != 0) info.add(TinkersRebornUtils.translate(LOC_AttackDesc));

        return info;
    }

    public String formatHarvestLevel() {
        MiningLevel miningLevel = MiningLevelHelper.levelList.get(this.harvestLevel);
        return format(LOC_HarvestLevel, miningLevel.getColorHex(), miningLevel.getLocalization());
    }

    public String formatDurability() {
        return format(LOC_Durability, COLOR_Durability, this.durability);
    }

    public String formatMiningSpeed() {
        return format(LOC_MiningSpeed, COLOR_Speed, this.miningspeed);
    }

    public String formatAttack() {
        return format(LOC_Attack, COLOR_Attack, this.attack);
    }
}
