package mctbl.tinkersreborn.tools.materials;

import java.util.ArrayList;
import java.util.List;

import mctbl.tinkersreborn.library.materials.AbstractMaterialStats;
import mctbl.tinkersreborn.library.materials.MaterialStatusType;
import mctbl.tinkersreborn.util.TinkersRebornUtils;

public class StringMaterialStats extends AbstractMaterialStats {

    public final static String LOC_Multiplier = "stat.bowstring.modifier.name";

    public final static String LOC_MultiplierDesc = "stat.bowstring.modifier.desc";

    public final float modifier; // around 1.0

    /**
     * @param modifier
     */
    public StringMaterialStats(float modifier) {
        this.modifier = modifier;
    }

    @Override
    public MaterialStatusType getIdentifier() {
        return MaterialStatusType.STRING;
    }

    @Override
    public String getLocalizedName() {
        return TinkersRebornUtils.translate("stat.string.name");
    }

    @Override
    public List<String> getLocalizedInfo() {
        List<String> info = new ArrayList<>();

        if (modifier != 0) info.add(this.formatModifier());

        return info;
    }

    @Override
    public List<String> getLocalizedDesc() {
        List<String> info = new ArrayList<>();

        if (modifier != 0) info.add(TinkersRebornUtils.translate(LOC_MultiplierDesc));

        return info;
    }

    public String formatModifier() {
        return format(LOC_Multiplier, COLOR_Modifier, this.modifier);
    }

}
