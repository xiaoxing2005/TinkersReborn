package mctbl.tinkersreborn.tools.items;

import net.minecraft.block.material.Material;

import mctbl.tinkersreborn.library.tools.HarvestTool;
import mctbl.tinkersreborn.tools.TinkersRebornTools;

public class Pickaxe extends HarvestTool {

    public Pickaxe() {
        super("Pickaxe");
        this.categoryTags.add("pickaxe");

        this.componentParts.set(0, TinkersRebornTools.pickaxeHead);
        this.componentParts.set(1, TinkersRebornTools.rod);
        this.componentParts.set(2, TinkersRebornTools.binding);
        this.componentParts.set(3, null);

        this.initEffectiveMaterial();

        iconSuffixMap.put(0, "_pickaxe_head");
        iconSuffixMap.put(1, "_pickaxe_head_broken");
        iconSuffixMap.put(2, "_pickaxe_handle");
        iconSuffixMap.put(3, "_pickaxe_accessory");
    }

    void initEffectiveMaterial() {
        effectiveMaterials.add(Material.rock);
        effectiveMaterials.add(Material.iron);
        effectiveMaterials.add(Material.ice);
        effectiveMaterials.add(Material.glass);
        effectiveMaterials.add(Material.piston);
        effectiveMaterials.add(Material.anvil);
        effectiveMaterials.add(Material.circuits);
    }

    @Override
    protected String getHarvestType() {
        return "pickaxe";
    }
}
