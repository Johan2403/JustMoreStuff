package johan24.justmorestuff.block;

import johan24.justmorestuff.JustMoreStuff;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ObsidianiteOre extends Block {

	public ObsidianiteOre(Material materialIn) {
		super(materialIn);
		this.setSoundType(SoundType.STONE);
		this.setHardness(3.0F);
		this.setResistance(6000.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB);
	}
}
