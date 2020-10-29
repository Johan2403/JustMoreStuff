package johan24.justmorestuff.util;

import johan24.justmorestuff.JustMoreStuff;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class RegistryUtil {
	
	public static Item setItemName(final Item item, final String name) {
		item.setRegistryName(JustMoreStuff.MODID, name).setTranslationKey(name);
		return item;
	}

	public static Block setBlockName(final Block block, final String name) {
		block.setRegistryName(JustMoreStuff.MODID, name).setTranslationKey(name);
		return block;
	}
}
