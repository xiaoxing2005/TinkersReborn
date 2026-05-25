package mctbl.tinkersreborn.library;

import java.util.ArrayList;
import java.util.List;

import mctbl.tinkersreborn.library.tools.ToolCore;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TinkersRebornRegistry {

	public static TinkersRebornRegistry instance = new TinkersRebornRegistry();

	private TinkersRebornRegistry() {
	}

	public static TinkersRebornCreativeTab blockTab;
	public static TinkersRebornCreativeTab toolsTab;
	public static TinkersRebornCreativeTab weaponsTab;
	public static TinkersRebornCreativeTab partsTab;
	public static TinkersRebornCreativeTab miscTab;

	public static List<ToolCore> tools;

	public void preInit() {
		this.initCreativeTab();
		this.initLists();
	}

	public void initCreativeTab() {
		blockTab = new TinkersRebornCreativeTab("TinkersRebornBlocks").init(new ItemStack(Items.cookie));
		toolsTab = new TinkersRebornCreativeTab("TinkersRebornTools").init(new ItemStack(Items.flint_and_steel));
		weaponsTab = new TinkersRebornCreativeTab("TinkersRebornWeapons").init(new ItemStack(Items.diamond_boots));
		partsTab = new TinkersRebornCreativeTab("TinkersRebornParts").init(new ItemStack(Items.bow));
		miscTab = new TinkersRebornCreativeTab("TinkersRebornMisc").init(new ItemStack(Items.iron_pickaxe));
	}

	public void initLists() {
		tools = new ArrayList<>();
	}

}
