package mctbl.tinkersreborn.tools.materials;

import java.util.ArrayList;
import java.util.List;

import mctbl.tinkersreborn.library.materials.AbstractMaterialStats;
import mctbl.tinkersreborn.library.materials.MaterialStatusType;
import mctbl.tinkersreborn.util.TinkersRebornUtils;

public class FletchingMaterialStats extends AbstractMaterialStats {

    public final static String LOC_Accuracy = "stat.fletching.accuracy.name";
    public final static String LOC_Multiplier = "stat.fletching.modifier.name";

    public final static String LOC_AccuracyDesc = "stat.fletching.accuracy.desc";
    public final static String LOC_MultiplierDesc = "stat.fletching.modifier.desc";

    public final float modifier;
    public final float accuracy;

    /**
     * @param modifier
     * @param accuracy
     */
    public FletchingMaterialStats(float modifier, float accuracy) {
        this.modifier = modifier;
        this.accuracy = accuracy;
    }

    @Override
    public MaterialStatusType getIdentifier() {
        return MaterialStatusType.FLETCHING;
    }

    @Override
    public String getLocalizedName() {
        return TinkersRebornUtils.translate("stat.fletching.name");
    }

    @Override
    public List<String> getLocalizedInfo() {
        List<String> info = new ArrayList<>();

        if (modifier != 0) info.add(this.formatModifier());
        if (accuracy != 0) info.add(this.formatAccuracy());

        return info;
    }

    @Override
    public List<String> getLocalizedDesc() {
        List<String> info = new ArrayList<>();

        if (modifier != 0) info.add(TinkersRebornUtils.translate(LOC_MultiplierDesc));
        if (accuracy != 0) info.add(TinkersRebornUtils.translate(LOC_AccuracyDesc));

        return info;
    }

    public String formatModifier() {
        return format(LOC_Multiplier, COLOR_Multiplier, this.modifier);
    }

    public String formatAccuracy() {
        return format(LOC_Accuracy, COLOR_Accuracy, this.accuracy);
    }

}
