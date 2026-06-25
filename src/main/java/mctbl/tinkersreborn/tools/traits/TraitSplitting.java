package mctbl.tinkersreborn.tools.traits;

import net.minecraftforge.common.MinecraftForge;

import mctbl.tinkersreborn.library.tools.traits.AbstractTrait;

// TODO
public class TraitSplitting extends AbstractTrait {

    private static final float DOUBLESHOT_CHANCE = 0.5f;

    public TraitSplitting() {
        super("splitting", 0xffffff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // @SubscribeEvent
    // public void onBowShooting(TinkerToolEvent.OnBowShoot event) {
    // if(TinkerUtil.hasTrait(TagUtil.getTagSafe(event.ammo), this.getModifierIdentifier()) && random.nextFloat() <
    // DOUBLESHOT_CHANCE) {
    // event.setProjectileCount(2);
    // event.setConsumeAmmoPerProjectile(false);
    // event.setConsumeDurabilityPerProjectile(false);
    // event.setBonusInaccuracy(3f);
    // }
    // }
}
