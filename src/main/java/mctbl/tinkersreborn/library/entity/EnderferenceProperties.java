package mctbl.tinkersreborn.library.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EnderferenceProperties implements IExtendedEntityProperties {

    public static final String IDENTIFIER = "enderference";

    private int enderferenceTicks;

    public EnderferenceProperties() {
        this.enderferenceTicks = 0;
    }

    public void apply(int ticks) {
        this.enderferenceTicks = Math.max(this.enderferenceTicks, ticks);
    }

    public void tick() {
        if (this.enderferenceTicks > 0) {
            this.enderferenceTicks--;
        }
    }

    public boolean isActive() {
        return this.enderferenceTicks > 0;
    }

    public int getRemainingTicks() {
        return this.enderferenceTicks;
    }

    @Override
    public void saveNBTData(NBTTagCompound compound) {}

    @Override
    public void loadNBTData(NBTTagCompound compound) {}

    @Override
    public void init(Entity entity, World world) {}
}
