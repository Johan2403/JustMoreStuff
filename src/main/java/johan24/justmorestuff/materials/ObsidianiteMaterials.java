package johan24.justmorestuff.materials;

import johan24.justmorestuff.JustMoreStuff;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ObsidianiteMaterials {
	
	public static final ToolMaterial OBSIDIANITE_TOOL = EnumHelper.addToolMaterial(JustMoreStuff.MODID + ":" + "obsidianite_tool", 3, 1897, 7.5F, 2.5F, 22);
	
	public static final ArmorMaterial OBSIDIANITE_ARMOR = EnumHelper.addArmorMaterial(JustMoreStuff.MODID + ":" + "obsidianite_armor", JustMoreStuff.MODID + ":obsidianite", 35, 
			new int[] {2, 5, 7, 3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
}
