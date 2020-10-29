package johan24.justmorestuff.block;

import johan24.justmorestuff.JustMoreStuff;
import johan24.justmorestuff.util.JustMoreStuffConfig.GuiIDs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SmithingTable extends Block {
	
	static GuiIDs guiIDs = new GuiIDs();
	
	public SmithingTable(Material materialIn) {
		super(materialIn);
		this.setSoundType(SoundType.WOOD);
		this.setHardness(2.5F);
		this.setResistance(2.5F);
		this.setHarvestLevel("axe", 1);
		this.setCreativeTab(JustMoreStuff.JUSTMORESTUFF_TAB);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(worldIn.isRemote)
			return true;
		playerIn.openGui(JustMoreStuff.instance, guiIDs.GUI_SMITHING_TABLE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
}
