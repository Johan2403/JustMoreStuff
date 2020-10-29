package johan24.justmorestuff;

import johan24.justmorestuff.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class JustMoreStuffTab extends CreativeTabs {
	
	public JustMoreStuffTab() {
		super(JustMoreStuff.MODID);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModItems.OBSIDIANITE_INGOT);
	}
}
