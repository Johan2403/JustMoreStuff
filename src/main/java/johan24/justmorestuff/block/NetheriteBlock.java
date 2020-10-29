package johan24.justmorestuff.block;

import johan24.justmorestuff.JustMoreStuff;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class NetheriteBlock extends Block {

	public NetheriteBlock(Material materialIn) {
		super(materialIn);
		this.setSoundType(SoundType.METAL);
		this.setHardness(50.0f);
		this.setResistance(1200.0f);
		this.setHarvestLevel("pickaxe", 3);
		this.setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}
}
