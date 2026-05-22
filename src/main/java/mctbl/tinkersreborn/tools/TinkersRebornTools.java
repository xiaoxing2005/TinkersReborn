package mctbl.tinkersreborn.tools;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import mctbl.tinkersreborn.library.ITinkersRebornModule;
import mctbl.tinkersreborn.tools.blocks.CastChestBlock;
import mctbl.tinkersreborn.tools.blocks.CraftingStationBlock;
import mctbl.tinkersreborn.tools.blocks.PartBuilderBlock;
import mctbl.tinkersreborn.tools.blocks.PartChestBlock;
import mctbl.tinkersreborn.tools.blocks.ToolForgeBlock;
import mctbl.tinkersreborn.tools.blocks.ToolStationBlock;
import mctbl.tinkersreborn.tools.entity.CastChestLogic;
import mctbl.tinkersreborn.tools.entity.CraftingStationLogic;
import mctbl.tinkersreborn.tools.entity.PartChestLogic;
import mctbl.tinkersreborn.tools.entity.TinkersRebornPartBuilderLogic;
import mctbl.tinkersreborn.tools.entity.TinkersRebornToolForgeLogic;
import mctbl.tinkersreborn.tools.entity.TinkersRebornToolStationLogic;
import mctbl.tinkersreborn.tools.itemblocks.TinkersRebornCastChestItemBlock;
import mctbl.tinkersreborn.tools.itemblocks.TinkersRebornPartBuilderItemBlock;
import mctbl.tinkersreborn.tools.itemblocks.TinkersRebornPartChestItemBlock;
import mctbl.tinkersreborn.tools.itemblocks.TinkersRebornToolForgeItemBlock;
import mctbl.tinkersreborn.tools.itemblocks.TinkersRebornToolStationItemBlock;

public class TinkersRebornTools implements ITinkersRebornModule {

    @SidedProxy(
        clientSide = "mctbl.tinkersreborn.tools.TinkersRebornToolsProxyClient",
        serverSide = "mctbl.tinkersreborn.tools.TinkersRebornToolsProxyCommon")
    public static TinkersRebornToolsProxyCommon proxy;

    // Crafting blocks
    public static Block toolStation;
    public static Block toolForge;
    public static Block partBuilder;
    public static Block castChest;
    public static Block partChest;
    public static Block craftingStation;

    public static Block heldItemBlock;
    public static Block battlesignBlock;

    // Tool parts
    public static Item toolRod;
    public static Item pickaxeHead;
    public static Item shovelHead;
    public static Item axeHead;
    public static Item swordBlade;
    public static Item wideGuard;
    public static Item handGuard;
    public static Item crossBar;
    public static Item toolBinding;
    public static Item pan;
    public static Item wideBoard;
    public static Item knifeBlade;
    public static Item chiselHead;
    public static Item toughRod;
    public static Item toughBinding;
    public static Item largePlate;
    public static Item broadaxeHead;
    public static Item scytheHead;
    public static Item excavatorHead;
    public static Item largeBlade;
    public static Item hammerHead;
    public static Item fullGuard;
    public static Item bowSting;
    public static Item fletching;
    public static Item arrowHead;
    public static Item shaft;
    public static Item shurikenPart;
    public static Item crossBowLimb;
    public static Item crossBowBody;
    public static Item bowLimb;
    public static Item boltCore;

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        toolStation = new ToolStationBlock();
        GameRegistry
            .registerBlock(toolStation, TinkersRebornToolStationItemBlock.class, toolStation.getUnlocalizedName());
        GameRegistry.registerTileEntity(TinkersRebornToolStationLogic.class, toolStation.getUnlocalizedName());

        toolForge = new ToolForgeBlock();
        GameRegistry.registerBlock(toolForge, TinkersRebornToolForgeItemBlock.class, toolForge.getUnlocalizedName());
        GameRegistry.registerTileEntity(TinkersRebornToolForgeLogic.class, toolForge.getUnlocalizedName());

        partBuilder = new PartBuilderBlock();
        GameRegistry
            .registerBlock(partBuilder, TinkersRebornPartBuilderItemBlock.class, partBuilder.getUnlocalizedName());
        GameRegistry.registerTileEntity(TinkersRebornPartBuilderLogic.class, partBuilder.getUnlocalizedName());

        castChest = new CastChestBlock();
        GameRegistry.registerBlock(castChest, TinkersRebornCastChestItemBlock.class, castChest.getUnlocalizedName());
        GameRegistry.registerTileEntity(CastChestLogic.class, castChest.getUnlocalizedName());

        partChest = new PartChestBlock();
        GameRegistry.registerBlock(partChest, TinkersRebornPartChestItemBlock.class, partChest.getUnlocalizedName());
        GameRegistry.registerTileEntity(PartChestLogic.class, partChest.getUnlocalizedName());

        craftingStation = new CraftingStationBlock();
        GameRegistry.registerBlock(craftingStation, craftingStation.getUnlocalizedName());
        GameRegistry.registerTileEntity(CraftingStationLogic.class, craftingStation.getUnlocalizedName());
    }

    @Override
    public void init(FMLInitializationEvent e) {

        proxy.initialize();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        // TODO Auto-generated method stub

    }
}
