package mctbl.tinkersreborn.common.entity;

import net.minecraft.world.World;

import mctbl.tinkersreborn.library.entity.SlimeBase;

public class BlueSlime extends SlimeBase {

    public BlueSlime(World world) {
        super(world);
    }

    @Override
    protected String getSlimeParticle() {
        return "tinkers.blueslime";
    }

    @Override
    protected SlimeBase createInstance(World world) {
        return new BlueSlime(world);
    }

    @Override
    protected void alterSquishAmount() {
        this.squishAmount *= 0.8F;
    }

    @Override
    protected int getJumpDelay() {
        return this.rand.nextInt(10) + 10;
    }
}
