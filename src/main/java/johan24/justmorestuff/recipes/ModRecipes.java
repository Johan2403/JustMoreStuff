package johan24.justmorestuff.recipes;

import johan24.justmorestuff.init.ModBlocks;
import johan24.justmorestuff.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void initSmelting() {
		GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(ModItems.OBSIDIANITE_SCRAP), 1.5F);
		GameRegistry.addSmelting(ModBlocks.OBSIDIANITE_ORE, new ItemStack(ModItems.OBSIDIANITE_INGOT), 2.0F);
		GameRegistry.addSmelting(ModBlocks.ANCIENT_DEBRIS, new ItemStack(ModItems.NETHERITE_SCRAP), 2.0F);
	}
}
