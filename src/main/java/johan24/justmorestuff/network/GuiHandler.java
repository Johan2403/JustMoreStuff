package johan24.justmorestuff.network;

import johan24.justmorestuff.client.gui.inventory.GuiSmithingTable;
import johan24.justmorestuff.init.ModBlocks;
import johan24.justmorestuff.inventory.ContainerSmithingTable;
import johan24.justmorestuff.util.JustMoreStuffConfig.GuiIDs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	static GuiIDs guiIDs = new GuiIDs();
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		IBlockState iblockstate = world.getBlockState(new BlockPos(x, y, z));
		if (ID == guiIDs.GUI_SMITHING_TABLE && (iblockstate.getBlock() == ModBlocks.SMITHING_TABLE))
			return new ContainerSmithingTable(player.inventory, world, new BlockPos(x, y, z));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		IBlockState iblockstate = world.getBlockState(new BlockPos(x, y, z));
		if (ID == guiIDs.GUI_SMITHING_TABLE && (iblockstate.getBlock() == ModBlocks.SMITHING_TABLE))
			return new GuiSmithingTable(player.inventory, world, new BlockPos(x, y, z));
		return null;
	}
}
