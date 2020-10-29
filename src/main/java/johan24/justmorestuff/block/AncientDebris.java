package johan24.justmorestuff.block;

import johan24.justmorestuff.JustMoreStuff;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AncientDebris extends Block {

	public AncientDebris(Material materialIn) {
		super(materialIn);
		this.setSoundType(SoundType.STONE);
		this.setHardness(30.0F);
		this.setResistance(1200.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB);
		
	}

}
