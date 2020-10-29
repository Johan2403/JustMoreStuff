package johan24.justmorestuff.util;

import johan24.justmorestuff.init.ModBlocks;
import johan24.justmorestuff.init.ModItems;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryCompat {

	public static void registerOres() {
		OreDictionary.registerOre("oreObsidianite", ModBlocks.OBSIDIANITE_ORE);
		OreDictionary.registerOre("ingotObsidianite", ModItems.OBSIDIANITE_INGOT);
		OreDictionary.registerOre("ingotNetherite", ModItems.NETHERITE_INGOT);
	}
}
