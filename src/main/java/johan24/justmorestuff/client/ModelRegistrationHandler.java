package johan24.justmorestuff.client;

import johan24.justmorestuff.JustMoreStuff;
import johan24.justmorestuff.init.ModBlocks;
import johan24.justmorestuff.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT, modid = JustMoreStuff.MODID)
public class ModelRegistrationHandler {

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		// Items
		registerModel(ModItems.OBSIDIANITE_INGOT, 0);
		registerModel(ModItems.OBSIDIANITE_SCRAP, 0);
		registerModel(ModItems.NETHERITE_INGOT, 0);
		registerModel(ModItems.NETHERITE_SCRAP, 0);
		
		
		//Blocks
		registerModel(Item.getItemFromBlock(ModBlocks.OBSIDIANITE_BLOCK), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.OBSIDIANITE_ORE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.NETHERITE_BLOCK), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.SMITHING_TABLE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.ANCIENT_DEBRIS), 0);
		
		
		// Tools
		registerModel(ModItems.OBSIDIANITE_PICKAXE, 0);
		registerModel(ModItems.OBSIDIANITE_SWORD, 0);
		registerModel(ModItems.OBSIDIANITE_AXE, 0);
		registerModel(ModItems.OBSIDIANITE_SHOVEL, 0);
		registerModel(ModItems.OBSIDIANITE_HOE, 0);
		
		registerModel(ModItems.NETHERITE_PICKAXE, 0);
		registerModel(ModItems.NETHERITE_SWORD, 0);
		registerModel(ModItems.NETHERITE_AXE, 0);
		registerModel(ModItems.NETHERITE_SHOVEL, 0);
		registerModel(ModItems.NETHERITE_HOE, 0);
		
		
		// Armor
		registerModel(ModItems.OBSIDIANITE_HELMET, 0);
		registerModel(ModItems.OBSIDIANITE_CHESTPLATE, 0);
		registerModel(ModItems.OBSIDIANITE_LEGGINGS, 0);
		registerModel(ModItems.OBSIDIANITE_BOOTS, 0);
		
		registerModel(ModItems.NETHERITE_HELMET, 0);
		registerModel(ModItems.NETHERITE_CHESTPLATE, 0);
		registerModel(ModItems.NETHERITE_LEGGINGS, 0);
		registerModel(ModItems.NETHERITE_BOOTS, 0);
		
		
		// Food
		registerModel(ModItems.OBSIDIANITE_APPLE, 0);
	}
	
	private static void registerModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, 
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
