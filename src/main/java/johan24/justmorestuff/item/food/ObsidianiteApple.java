package johan24.justmorestuff.item.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ObsidianiteApple extends ItemFood {

	public ObsidianiteApple(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setAlwaysEdible();
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if(!worldIn.isRemote) {
			player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, (60*20), 0, false, true));
			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 3*(60*20), 0, false, true));
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
