package johan24.justmorestuff.materials;

import johan24.justmorestuff.JustMoreStuff;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class NetheriteMaterials {

	public static final ToolMaterial NETHERITE_TOOL = EnumHelper.addToolMaterial(JustMoreStuff.MODID + ":" + "netherite_tool", 4, 2031, 9.0F, 4.0F, 15);
	
	public static final ArmorMaterial NETHERITE_ARMOR = EnumHelper.addArmorMaterial(JustMoreStuff.MODID + ":" + "netherite_armor", JustMoreStuff.MODID + ":netherite", 37,
			new int[] {3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3);
}
