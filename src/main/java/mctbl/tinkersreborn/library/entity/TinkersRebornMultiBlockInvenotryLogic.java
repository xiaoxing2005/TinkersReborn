package mctbl.tinkersreborn.library.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mctbl.tinkersreborn.TinkersReborn;
import mctbl.tinkersreborn.library.blocks.IActiveLogic;
import mctbl.tinkersreborn.library.utils.BlockPos;

public abstract class TinkersRebornMultiBlockInvenotryLogic extends TinkersRebornInventoryLogic
    implements IMasterLogic, IActiveLogic {

    public boolean validStructure;
    public Random rand = TinkersReborn.random;
    public int fuelAmount;
    public int fuelCapacity;
    protected final List<BlockPos> lavaTanks;
    protected BlockPos activeLavaTank;

    protected int tickCounter = 0;
    protected int secondCounter = 0;

    protected boolean needsUpdate;

    protected int fuel; // Ticks left until the current fuel is depleted and fuel is taken from the tanks. Depletes
                        // every tick
    protected int temperature; // internal temperature of the heater == speed of the heater
    protected boolean needsFuel; // If the last tick executed an operation that required fuel.
    public boolean isHeating; // If the last tick is heating item insde.

    protected int[] itemTemperatures; // current temperature of each item in the corresponding slot
    protected int[] itemTempRequired; // Temperature where the items want to goooooo

    /**
     * @see #getDefaultName()
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
    public abstract void updateEntity();

    @Override
    protected String getDefaultName() {
        return this.name;
    }

}
