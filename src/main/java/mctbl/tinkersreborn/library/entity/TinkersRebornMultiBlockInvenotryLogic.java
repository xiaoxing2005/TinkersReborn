package mctbl.tinkersreborn.library.entity;

import java.util.ArrayList;
import java.util.List;

import mctbl.tinkersreborn.library.blocks.IActiveLogic;
import mctbl.tinkersreborn.library.utils.BlockPos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.FluidStack;

public abstract class TinkersRebornMultiBlockInvenotryLogic extends TinkersRebornInventoryLogic
	implements IMasterLogic, IActiveLogic {

    // NBT Tags
    public static final String TAG_TANKS = "tanks";
    public static final String TAG_FUEL_QUALITY = "fuelQuality";
    public static final String TAG_CURRENT_FUEL = "currentFuel";
    public static final String TAG_CURRENT_TANK = "currentTank";
    public static final String TAG_ACTIVE = "active";
    public static final String TAG_MINPOS = "minPos";
    public static final String TAG_MAXPOS = "maxPos";
    public static final String TAG_FUEL = "fuel";
    public static final String TAG_TEMPERATURE = "temperature";
    public static final String TAG_NEEDS_FUEL = "needsFuel";
    public static final String TAG_ITEM_TEMPERATURES = "itemTemperatures";
    public static final String TAG_ITEM_TEMP_REQUIRED = "itemTempRequired";
    public static final String TAG_IS_HEATING = "isHeating";

    /** smallest coordinate INSIDE the multiblock */
    protected BlockPos minPos;
    /** biggest coordinate INSIDE the multiblock */
    protected BlockPos maxPos;

    public boolean validStructure;
    public int fuelAmount;
    public int fuelCapacity;
    public FluidStack currentFuel;
    protected final List<BlockPos> lavaTanks;
    protected BlockPos activeLavaTank;

    protected int tickCounter = 0;
    protected int secondCounter = 0;

    protected boolean needsUpdate;

    protected int fuel; // Ticks left until the current fuel is depleted and fuel is taken from the
			// tanks. Depletes
			// every tick
    protected int temperature; // internal temperature of the heater == speed of the heater
    protected boolean needsFuel; // If the last tick executed an operation that required fuel.
    public boolean isHeating; // If the last tick is heating item insde.

    protected int[] itemTemperatures; // current temperature of each item in the corresponding slot
    protected int[] itemTempRequired; // Temperature where the items want to goooooo

    /**
     * @see #getDefaultName
     */
    protected String name;

    public TinkersRebornMultiBlockInvenotryLogic(String name) {
	super(0);
	this.itemTemperatures = new int[0];
	this.itemTempRequired = new int[0];
	this.lavaTanks = new ArrayList<>();
	this.name = "tinkersreborn.multi." + name;
    }

    @Override
    public void notifyChange(IServantLogic servant, int x, int y, int z) {
	this.checkWholeStructureValid();
    }

    @Override
    public boolean getActive() {
	return this.validStructure;
    }

    @Override
    public void setActive(boolean flag) {
	this.validStructure = flag;
	worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    @Override
    protected String getDefaultName() {
	return this.name;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (this.needsUpdate) {
	    this.checkWholeStructureValid();
	    this.needsUpdate = false;
	}
    }

    @Override
    public void writeToNBT(NBTTagCompound tags) {
	super.writeToNBT(tags);

	tags.setBoolean(TAG_ACTIVE, validStructure);
	tags.setTag(TAG_MINPOS, writePos(minPos));
	tags.setTag(TAG_MAXPOS, writePos(maxPos));

	tags.setInteger(TAG_FUEL, fuel);
	tags.setInteger(TAG_TEMPERATURE, temperature);
	tags.setBoolean(TAG_NEEDS_FUEL, needsFuel);
	tags.setIntArray(TAG_ITEM_TEMPERATURES, itemTemperatures);
	tags.setIntArray(TAG_ITEM_TEMP_REQUIRED, itemTempRequired);
	tags.setBoolean(TAG_IS_HEATING, isHeating);

	tags.setInteger(TAG_FUEL_QUALITY, fuelAmount);

	tags.setTag(TAG_CURRENT_TANK, writePos(activeLavaTank));
	NBTTagList tankList = new NBTTagList();
	for (BlockPos pos : lavaTanks) {
	    tankList.appendTag(writePos(pos));
	}
	tags.setTag(TAG_TANKS, tankList);

	NBTTagCompound fuelTag = new NBTTagCompound();
	if (currentFuel != null) {
	    currentFuel.writeToNBT(fuelTag);
	}
	tags.setTag(TAG_CURRENT_FUEL, fuelTag);

    }

    @Override
    public void readFromNBT(NBTTagCompound tags) {
	super.readFromNBT(tags);

	validStructure = tags.getBoolean(TAG_ACTIVE);
	minPos = readPos(tags.getCompoundTag(TAG_MINPOS));
	maxPos = readPos(tags.getCompoundTag(TAG_MAXPOS));
	fuel = tags.getInteger(TAG_FUEL);
	temperature = tags.getInteger(TAG_TEMPERATURE);
	needsFuel = tags.getBoolean(TAG_NEEDS_FUEL);
	itemTemperatures = tags.getIntArray(TAG_ITEM_TEMPERATURES);
	itemTempRequired = tags.getIntArray(TAG_ITEM_TEMP_REQUIRED);
	isHeating = tags.getBoolean(TAG_IS_HEATING);
	fuelAmount = tags.getInteger(TAG_FUEL_QUALITY);

	NBTTagList tankList = tags.getTagList(TAG_TANKS, 10);
	lavaTanks.clear();
	for (int i = 0; i < tankList.tagCount(); i++) {
	    lavaTanks.add(readPos(tankList.getCompoundTagAt(i)));
	}
	currentFuel = FluidStack.loadFluidStackFromNBT(tags.getCompoundTag(TAG_CURRENT_FUEL));

	needsUpdate = true;
    }

    public static NBTTagCompound writePos(BlockPos pos) {
	NBTTagCompound tag = new NBTTagCompound();
	if (pos != null) {
	    tag.setInteger("x", pos.getX());
	    tag.setInteger("y", pos.getY());
	    tag.setInteger("z", pos.getZ());
	}
	return tag;
    }

    public static BlockPos readPos(NBTTagCompound tag) {
	if (tag != null) {
	    return new BlockPos(tag.getInteger("x"), tag.getInteger("y"), tag.getInteger("z"));
	}
	return null;
    }
}
