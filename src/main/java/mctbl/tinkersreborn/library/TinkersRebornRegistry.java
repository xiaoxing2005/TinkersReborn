package mctbl.tinkersreborn.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import mctbl.tinkersreborn.library.crafting.LiquidCasting;
import mctbl.tinkersreborn.library.materials.TinkersRebornMaterial;
import mctbl.tinkersreborn.library.tools.ITrait;
import mctbl.tinkersreborn.library.tools.ToolCore;
import mctbl.tinkersreborn.library.tools.modifiers.AbstractModifier;
import mctbl.tinkersreborn.smeltery.blocks.TinkersRebornFluid;

public class TinkersRebornRegistry {

    public static TinkersRebornRegistry instance = new TinkersRebornRegistry();

    private TinkersRebornRegistry() {}

    public static TinkersRebornCreativeTab blockTab;
    public static TinkersRebornCreativeTab toolsTab;
    public static TinkersRebornCreativeTab weaponsTab;
    public static TinkersRebornCreativeTab partsTab;
    public static TinkersRebornCreativeTab miscTab;

    public static List<ToolCore> tools;

    public static List<TinkersRebornMaterial> allMaterialsList;
    public static Map<String, TinkersRebornMaterial> materialIdentifierMaps;
    public static Map<Integer, TinkersRebornMaterial> materialIdMaps;

    public static Map<String, AbstractModifier> modifierIdentifierMaps;

    public static Map<String, ITrait> traitIdentifierMaps;
    public static Map<Integer, ITrait> traitIdMaps;

    // contains all fluid that tinkers reborn registered
    public static List<TinkersRebornFluid> allTinkersFluid;

    public static LiquidCasting tableCasting;
    public static LiquidCasting basinCasting;

    public void preInit() {
        this.initCreativeTab();
        this.init();

        tableCasting = new LiquidCasting();
        basinCasting = new LiquidCasting();
    }

    private void initCreativeTab() {
        // TODO remember init after postInit to switch TinkersReborn's Item
        blockTab = new TinkersRebornCreativeTab("TinkersRebornBlocks").init(new ItemStack(Items.cookie));
        toolsTab = new TinkersRebornCreativeTab("TinkersRebornTools").init(new ItemStack(Items.flint_and_steel));
        weaponsTab = new TinkersRebornCreativeTab("TinkersRebornWeapons").init(new ItemStack(Items.diamond_boots));
        partsTab = new TinkersRebornCreativeTab("TinkersRebornParts").init(new ItemStack(Items.bow));
        miscTab = new TinkersRebornCreativeTab("TinkersRebornMisc").init(new ItemStack(Items.iron_pickaxe));
    }

    private void init() {
        tools = new ArrayList<>();
        allMaterialsList = new ArrayList<>();
        materialIdentifierMaps = new HashMap<>();
        materialIdMaps = new HashMap<>();
        modifierIdentifierMaps = new HashMap<>();
        traitIdentifierMaps = new HashMap<>();
        traitIdMaps = new HashMap<>();
        allTinkersFluid = new ArrayList<>();
    }

    public static void addMaterialToMap(TinkersRebornMaterial m) {
        materialIdentifierMaps.put(m.identifier, m);
        materialIdMaps.put(m.materialId, m);
        allMaterialsList.add(m);
    }

    public static void addMaterialToMap(List<TinkersRebornMaterial> l) {
        for (TinkersRebornMaterial m : l) addMaterialToMap(m);
    }

    public static void addMaterialToMap(TinkersRebornMaterial... l) {
        addMaterialToMap(Arrays.asList(l));
    }

    public static void addModifierToMap(AbstractModifier m) {
        modifierIdentifierMaps.put(m.getIdentifier(), m);
    }

    public static void addModifierToMap(List<AbstractModifier> m) {
        for (AbstractModifier mo : m) addModifierToMap(mo);
    }

    public static void addModifierToMap(AbstractModifier... m) {
        addModifierToMap(Arrays.asList(m));
    }

    public static TinkersRebornMaterial getMaterialByIdentifier(String identifier) {
        return materialIdentifierMaps.get(identifier);
    }

    public static TinkersRebornMaterial getMaterialById(int id) {
        return materialIdMaps.get(id);
    }

    public static TinkersRebornFluid getFluidByIndex(int idx) {
        if (idx < allTinkersFluid.size()) {
            return allTinkersFluid.get(idx);
        } else {
            return null;
        }
    }

    public static ITrait getTrait(String identifier) {
        return traitIdentifierMaps.get(identifier);
    }

    public static AbstractModifier getModifier(String identifier) {
        return modifierIdentifierMaps.get(identifier);
    }
}
