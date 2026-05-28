package mctbl.tinkersreborn.tools.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mctbl.tinkersreborn.library.TinkersRebornRegistry;
import mctbl.tinkersreborn.library.items.CraftingItem;
import mctbl.tinkersreborn.library.tools.IMaterialPart;
import mctbl.tinkersreborn.library.tools.IToolPart;

public class TinkersRebornToolPart extends CraftingItem implements IToolPart, IMaterialPart {

    public String partName;
    public String texture;
    public int cost;
    public IIcon defaultIcon;
    public String allowMaterialListName;

    public TinkersRebornToolPart(String texture, String name, String allowListName) {
        // texture -> pickaxe_head for texture
        // name -> PickaxeHead for localization
        super(null, null, "tools/parts/" + texture, TinkersRebornRegistry.partsTab);
        this.texture = texture;
        this.partName = name;
        this.allowMaterialListName = allowListName;
        this.setUnlocalizedName("tinkersreborn." + name); // tinkersreborn.PickaxeHead
    }

    public TinkersRebornToolPart(String texture, String name) {
        this(texture, name, "all");
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        // TODO Auto-generated method stub
        return super.getItemStackDisplayName(stack);
    }

    @Override
    public String getUnlocalizedName() {
        // TODO Auto-generated method stub
        return super.getUnlocalizedName();
    }

    @Override
    public void getSubItems(Item b, CreativeTabs tab, List<ItemStack> list) {
        // TODO Auto-generated method stub
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        // TODO Auto-generated method stub
        this.icons = new IIcon[0];
        // default texture
        this.defaultIcon = iconRegister.registerIcon("tinkersreborn:" + folder + "_" + texture);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        if (meta > icons.length) return defaultIcon;

        if (icons[meta] == null) return defaultIcon;

        return icons[meta];
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int renderpass) {
        // TODO Auto-generated method stub
        return super.getColorFromItemStack(stack, renderpass);
    }

    @Override
    public int getMaterialId() {
        // TODO Auto-generated method stub
        return -1;
    }

}
