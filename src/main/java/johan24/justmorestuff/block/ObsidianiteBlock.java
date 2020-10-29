package johan24.justmorestuff.block;

import johan24.justmorestuff.JustMoreStuff;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ObsidianiteBlock extends Block {

	public ObsidianiteBlock(Material materialIn) {
		super(materialIn);
		this.setSoundType(SoundType.METAL);
		this.setHardness(6.0F);
		this.setResistance(6000.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}
}
