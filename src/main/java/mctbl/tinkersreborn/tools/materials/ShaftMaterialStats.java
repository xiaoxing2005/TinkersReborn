package mctbl.tinkersreborn.tools.materials;

import java.util.ArrayList;
import java.util.List;

import mctbl.tinkersreborn.library.materials.AbstractMaterialStats;
import mctbl.tinkersreborn.library.materials.MaterialStatusType;
import mctbl.tinkersreborn.util.TinkersRebornUtils;

public class ShaftMaterialStats extends AbstractMaterialStats {

    public final static String LOC_Multiplier = "stat.shaft.modifier.name";
    public final static String LOC_Ammo = "stat.shaft.ammo.name";

    public final static String LOC_MultiplierDesc = "stat.shaft.modifier.desc";
    public final static String LOC_AmmoDesc = "stat.shaft.ammo.desc";

    public final static String COLOR_Ammo = COLOR_Durability;

    public final float modifier;
    public final int bonusAmmo;

    /**
     * @param modifier
     * @param bonusAmmo
     */
    public ShaftMaterialStats(float modifier, int bonusAmmo) {
        this.modifier = modifier;
        this.bonusAmmo = bonusAmmo;
    }

    @Override
    public MaterialStatusType getIdentifier() {
        return MaterialStatusType.SHAFT;
    }

    @Override
    public String getLocalizedName() {
        return TinkersRebornUtils.translate("stat.shaft.name");
    }

    @Override
    public List<String> getLocalizedInfo() {
        List<String> info = new ArrayList<>();

        if (modifier != 0) info.add(this.formatModifier());
        if (bonusAmmo != 0) info.add(this.formatAmmo());

        return info;
    }

    @Override
    public List<String> getLocalizedDesc() {
        List<String> info = new ArrayList<>();

        if (modifier != 0) info.add(TinkersRebornUtils.translate(LOC_MultiplierDesc));
        if (bonusAmmo != 0) info.add(TinkersRebornUtils.translate(LOC_AmmoDesc));

        return info;
    }

    public String formatModifier() {
        return format(LOC_Multiplier, COLOR_Multiplier, this.modifier);
    }

    public String formatAmmo() {
        return format(LOC_Ammo, COLOR_Durability, this.bonusAmmo);
    }

}
