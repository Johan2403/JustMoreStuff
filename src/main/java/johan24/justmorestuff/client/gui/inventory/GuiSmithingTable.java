package johan24.justmorestuff.client.gui.inventory;

import johan24.justmorestuff.JustMoreStuff;
import johan24.justmorestuff.inventory.ContainerSmithingTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiSmithingTable extends GuiContainer {

	public static final int WIDTH = 176;
	public static final int HEIGHT = 166;

	private static final ResourceLocation background = new ResourceLocation(JustMoreStuff.MODID,
			"textures/gui/smithing.png");
	@SuppressWarnings("unused")
	private final IInventory playerInventory;

	public GuiSmithingTable(InventoryPlayer inventory, World world, BlockPos blockPos) {
		super(new ContainerSmithingTable(inventory, world, blockPos));
		playerInventory = inventory;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString("Upgrade Gear", 60, 20, 4210752);
		this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(background);
		int i = this.guiLeft;
		int j = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}
}
