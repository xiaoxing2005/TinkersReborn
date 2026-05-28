package mctbl.tinkersreborn.library.tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import mctbl.tinkersreborn.TinkersReborn;
import mctbl.tinkersreborn.library.TinkersRebornRegistry;
import mctbl.tinkersreborn.util.ToolTags;

/**
 * All the base of a Tinkers style Tool class
 * Author MCTBL Time 2026-05-24 11:46:03
 */
public abstract class ToolCore extends Item implements IModifyable, IToolEvent {

    public Random random = TinkersReborn.random;
    /**
     * Head, Handle, Accessory, Extra in this order <br/>
     * null if it doesn't have that part
     */
    protected final List<IToolPart> componentParts = Arrays.asList(null, null, null, null);

    public final Map<Integer, IIcon> headIcons = new HashMap<>(); // 0
    public final Map<Integer, IIcon> brokenIcons = new HashMap<>(); // 1
    public final Map<Integer, IIcon> handleIcons = new HashMap<>(); // 2
    public final Map<Integer, IIcon> accessoryIcons = new HashMap<>(); // 3
    public final Map<Integer, IIcon> extraIcons = new HashMap<>(); // 4
    public final Map<Integer, IIcon> effectIcons = new HashMap<>(); // 5

    public final Set<String> categoryTags = new HashSet<>();

    public final Map<Integer, String> iconSuffixMap = new HashMap<>();

    public String toolTypeName; // pickaxe

    public ToolCore(String toolTypeName) {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(100);
        this.setUnlocalizedName("TinkerTools." + toolTypeName);
        this.setCreativeTab(TinkersRebornRegistry.toolsTab);
        this.setNoRepair();
        this.toolTypeName = toolTypeName.toLowerCase();
    }

    @Override
    public String getBaseTagName() {
        return ToolTags.TOOLBASETAG;
    }

    @Override
    public Set<String> getCategoryTags() {
        return this.categoryTags;
    }

    public List<IToolPart> getComponentParts() {
        // Head, Handle, Accessory, Extra in this order
        // null if it doesn't have that part
        return this.componentParts;
    }

    public IToolPart getHeadParts() {
        return this.componentParts.get(0);
    }

    public IToolPart getHandleParts() {
        return this.componentParts.get(1);
    }

    public IToolPart getAccessoryParts() {
        return this.componentParts.get(2);
    }

    public IToolPart getExtraParts() {
        return this.componentParts.get(3);
    }

    public String getIconSuffix(int partType) {
        String value = iconSuffixMap.get(partType);
        return value != null ? value : "";
    }

    public String getEffectSuffix() {
        return "_" + this.toolTypeName + "_effect";
    }

    public String getDefaultFolder() {
        return this.toolTypeName;
    }

    public String getUnlocalizedToolName() {
        return "tool." + this.toolTypeName;
    }

    public String getLocalizedToolName() {
        return StatCollector.translateToLocal(this.getUnlocalizedToolName());
    }

    public boolean isItemTool(ItemStack par1ItemStack) {
        return false;
    }

    @Override
    public boolean isRepairable() {
        return false;
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        // TODO Auto-generated method stub
        return super.showDurabilityBar(stack);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 100;
    }

    @Override
    public int getDamage(ItemStack stack) {
        // TODO Auto-generated method stub
        return super.getDamage(stack);
    }

    @Override
    public int getDisplayDamage(ItemStack stack) {
        return this.getDamage(stack);
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        // TODO Auto-generated method stub
        super.setDamage(stack, damage);
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        // TODO
        return null;
        // return new FancyEntityItem(world, location, itemstack);
    }

}
