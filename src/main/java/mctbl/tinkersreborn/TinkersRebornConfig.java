package mctbl.tinkersreborn;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class TinkersRebornConfig {

    public static String[] metalTypes;
    public static String[] oreTypes;
    public static String[] gravelOreTypes;

    public static boolean disableAllRecipes;

    public static void setupConfig(File location) {
        metalTypes = new String[] { "Cobalt", "Ardite", "Manyullyn", "Copper", "Bronze", "Tin", "Aluminum", "AluBrass",
            "Alumite", "Steel", "Ender" };

        oreTypes = new String[] { "nether_slag", "nether_cobalt", "nether_ardite", "ore_copper", "ore_tin",
            "ore_aluminum", "ore_slag" };

        gravelOreTypes = new String[] { "iron", "gold", "copper", "tin", "aluminum", "cobalt" };

        Configuration config = new Configuration(new File(location + "/TinkersReborn"));

        disableAllRecipes = config
            .get(
                "general",
                "Disable All Recipes",
                false,
                "Disable all TinkersReborn recipes (smeltery, drying rack, crafting, etc)")
            .getBoolean();

    }
}
