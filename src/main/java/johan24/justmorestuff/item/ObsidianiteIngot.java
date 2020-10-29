package johan24.justmorestuff.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ObsidianiteIngot extends Item {

	@Override
	public boolean isBeaconPayment(ItemStack stack) {
		return true;
	}
}
