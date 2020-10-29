package johan24.justmorestuff;

import johan24.justmorestuff.block.AncientDebris;
import johan24.justmorestuff.block.NetheriteBlock;
import johan24.justmorestuff.block.ObsidianiteBlock;
import johan24.justmorestuff.block.ObsidianiteOre;
import johan24.justmorestuff.block.SmithingTable;
import johan24.justmorestuff.init.ModBlocks;
import johan24.justmorestuff.item.NetheriteIngot;
import johan24.justmorestuff.item.ObsidianiteIngot;
import johan24.justmorestuff.item.armor.ItemNetheriteArmor;
import johan24.justmorestuff.item.armor.ItemObsidianiteArmor;
import johan24.justmorestuff.item.food.ObsidianiteApple;
import johan24.justmorestuff.item.tools.ItemNetheriteAxe;
import johan24.justmorestuff.item.tools.ItemNetheriteHoe;
import johan24.justmorestuff.item.tools.ItemNetheritePickaxe;
import johan24.justmorestuff.item.tools.ItemNetheriteShovel;
import johan24.justmorestuff.item.tools.ItemNetheriteSword;
import johan24.justmorestuff.item.tools.ItemObsidianiteAxe;
import johan24.justmorestuff.item.tools.ItemObsidianiteHoe;
import johan24.justmorestuff.item.tools.ItemObsidianitePickaxe;
import johan24.justmorestuff.item.tools.ItemObsidianiteShovel;
import johan24.justmorestuff.item.tools.ItemObsidianiteSword;
import johan24.justmorestuff.materials.NetheriteMaterials;
import johan24.justmorestuff.materials.ObsidianiteMaterials;
import johan24.justmorestuff.util.RegistryUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistrationHandler {
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		final Item[] items = { 
				
				// Items
				RegistryUtil.setItemName(new ObsidianiteIngot(), "obsidianite_ingot").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new Item(), "obsidianite_scrap").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new NetheriteIngot(), "netherite_ingot").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new Item(), "netherite_scrap").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				
				
				//Tools
				RegistryUtil.setItemName(new ItemObsidianitePickaxe(ObsidianiteMaterials.OBSIDIANITE_TOOL), "obsidianite_pickaxe").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemObsidianiteSword(ObsidianiteMaterials.OBSIDIANITE_TOOL), "obsidianite_sword").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemObsidianiteAxe(ObsidianiteMaterials.OBSIDIANITE_TOOL, 7.5F, -3.2F), "obsidianite_axe").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemObsidianiteShovel(ObsidianiteMaterials.OBSIDIANITE_TOOL), "obsidianite_shovel").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemObsidianiteHoe(ObsidianiteMaterials.OBSIDIANITE_TOOL), "obsidianite_hoe").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				
				RegistryUtil.setItemName(new ItemNetheritePickaxe(NetheriteMaterials.NETHERITE_TOOL), "netherite_pickaxe").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemNetheriteSword(NetheriteMaterials.NETHERITE_TOOL), "netherite_sword").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemNetheriteAxe(NetheriteMaterials.NETHERITE_TOOL, 9.0F, -3.0F), "netherite_axe").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemNetheriteShovel(NetheriteMaterials.NETHERITE_TOOL), "netherite_shovel").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemNetheriteHoe(NetheriteMaterials.NETHERITE_TOOL), "netherite_hoe").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				
				
				// Armor
				RegistryUtil.setItemName(new ItemObsidianiteArmor(ObsidianiteMaterials.OBSIDIANITE_ARMOR, EntityEquipmentSlot.HEAD), "obsidianite_helmet").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemObsidianiteArmor(ObsidianiteMaterials.OBSIDIANITE_ARMOR, EntityEquipmentSlot.CHEST), "obsidianite_chestplate").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemObsidianiteArmor(ObsidianiteMaterials.OBSIDIANITE_ARMOR, EntityEquipmentSlot.LEGS), "obsidianite_leggings").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemObsidianiteArmor(ObsidianiteMaterials.OBSIDIANITE_ARMOR, EntityEquipmentSlot.FEET), "obsidianite_boots").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				
				RegistryUtil.setItemName(new ItemNetheriteArmor(NetheriteMaterials.NETHERITE_ARMOR, EntityEquipmentSlot.HEAD), "netherite_helmet").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemNetheriteArmor(NetheriteMaterials.NETHERITE_ARMOR, EntityEquipmentSlot.CHEST), "netherite_chestplate").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemNetheriteArmor(NetheriteMaterials.NETHERITE_ARMOR, EntityEquipmentSlot.LEGS), "netherite_leggings").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				RegistryUtil.setItemName(new ItemNetheriteArmor(NetheriteMaterials.NETHERITE_ARMOR, EntityEquipmentSlot.FEET), "netherite_boots").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB),
				
				
				// Food
				RegistryUtil.setItemName(new ObsidianiteApple(6, 14.4F, false), "obsidianite_apple").setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB)
				};
		
		final Item[] itemBlocks = {
				new ItemBlock(ModBlocks.OBSIDIANITE_BLOCK).setRegistryName(ModBlocks.OBSIDIANITE_BLOCK.getRegistryName()),
				new ItemBlock(ModBlocks.OBSIDIANITE_ORE).setRegistryName(ModBlocks.OBSIDIANITE_ORE.getRegistryName()),
				new ItemBlock(ModBlocks.NETHERITE_BLOCK).setRegistryName(ModBlocks.NETHERITE_BLOCK.getRegistryName()),
				new ItemBlock(ModBlocks.SMITHING_TABLE).setRegistryName(ModBlocks.SMITHING_TABLE.getRegistryName()),
				new ItemBlock(ModBlocks.ANCIENT_DEBRIS).setRegistryName(ModBlocks.ANCIENT_DEBRIS.getRegistryName())
		};

		event.getRegistry().registerAll(itemBlocks);
		event.getRegistry().registerAll(items);
	}
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		final Block[] blocks = {
				RegistryUtil.setBlockName(new ObsidianiteBlock(Material.IRON), "obsidianite_block"),
				RegistryUtil.setBlockName(new NetheriteBlock(Material.IRON), "netherite_block"),
				RegistryUtil.setBlockName(new ObsidianiteOre(Material.ROCK), "obsidianite_ore"),
				RegistryUtil.setBlockName(new SmithingTable(Material.WOOD), "smithing_table"),
				RegistryUtil.setBlockName(new AncientDebris(Material.ROCK), "ancient_debris")
		};
		
		event.getRegistry().registerAll(blocks);
	}
}
