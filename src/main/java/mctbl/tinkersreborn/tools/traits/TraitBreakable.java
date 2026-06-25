package mctbl.tinkersreborn.tools.traits;

import net.minecraftforge.common.MinecraftForge;

import mctbl.tinkersreborn.library.tools.traits.AbstractTrait;

// TODO
public class TraitBreakable extends AbstractTrait {

    private final float BREAKCHANCE = 0.5f;

    public TraitBreakable() {
        super("breakable", 0xffffff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // @SubscribeEvent
    // public void onHitBlock(ProjectileEvent.OnHitBlock event) {
    // if(event.projectile != null && !event.projectile.getEntityWorld().isRemote) {
    //
    // ItemStack itemStack = event.projectile.tinkerProjectile.getItemStack();
    // if(TinkerUtil.hasTrait(TagUtil.getTagSafe(itemStack), this.getModifierIdentifier()) && random.nextFloat() <
    // BREAKCHANCE) {
    // event.projectile.setDead();
    // }
    // }
    // }
}
