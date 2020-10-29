package johan24.justmorestuff.inventory;

import java.util.Map;

import johan24.justmorestuff.init.ModBlocks;
import johan24.justmorestuff.init.ModItems;
import johan24.justmorestuff.util.SoundsHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerSmithingTable extends Container {

	private final IInventory inputSlots;
	private final IInventory outputSlot;
	private final World world;
	private final BlockPos pos;

	public ContainerSmithingTable(IInventory playerInventory, World worldIn, BlockPos blockPos) {
		this.inputSlots = new InventoryBasic("Upgrade", true, 2) {

			public void markDirty() {

				super.markDirty();
				ContainerSmithingTable.this.onCraftMatrixChanged(this);
			}
		};
		this.outputSlot = new InventoryCraftResult();
		this.world = worldIn;
		this.pos = blockPos;

		this.addSlotToContainer(new Slot(this.inputSlots, 0, 27, 47));
		this.addSlotToContainer(new Slot(this.inputSlots, 1, 76, 47));
		this.addSlotToContainer(new Slot(this.outputSlot, 2, 134, 47) {
			public boolean isItemValid(ItemStack stack) {

				return false;
			}

			@Override
			public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {

				ContainerSmithingTable.this.inputSlots.setInventorySlotContents(0, ItemStack.EMPTY);
				ContainerSmithingTable.this.inputSlots.decrStackSize(1, 1);

				worldIn.playSound(thePlayer, thePlayer.getPosition().getX(), thePlayer.getPosition().getY(),
						thePlayer.getPosition().getZ(), SoundsHandler.SMITHING_TABLE_USE, SoundCategory.BLOCKS,
						1.0f, 1.0f);

				return super.onTake(thePlayer, stack);
			}
		});

		addPlayerSlots(playerInventory);
	}

	private void addPlayerSlots(IInventory playerInventory) {

		for (int k = 0; k < 3; ++k) {
			for (int i1 = 0; i1 < 9; ++i1) {
				this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
			}
		}

		for (int l = 0; l < 9; ++l) {
			this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 142));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index == 2) {
				if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
					return ItemStack.EMPTY;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (index != 0 && index != 1) {
				if (index >= 3 && index < 39 && !this.mergeItemStack(itemstack1, 0, 2, false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}

		return itemstack;
	}

	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);

		if (!this.world.isRemote) {
			this.clearContainer(playerIn, this.world, this.inputSlots);
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		if (this.world.getBlockState(this.pos).getBlock() != ModBlocks.SMITHING_TABLE) {
			return false;
		} else {
			return playerIn.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
					(double) this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}

	@Override
	public void onCraftMatrixChanged(IInventory inventoryIn) {
		super.onCraftMatrixChanged(inventoryIn);

		if (inventoryIn == this.inputSlots) {
			this.updateSmithingOutput();
		}
	}

	// The Core Smithing Table Logic
	public void updateSmithingOutput() {
		ItemStack itemstack = this.inputSlots.getStackInSlot(0);

		int durability;

		if (itemstack.isEmpty()) {
			this.outputSlot.setInventorySlotContents(0, ItemStack.EMPTY);
		} else {
			ItemStack itemstack1 = itemstack.copy();
			ItemStack itemstack2 = this.inputSlots.getStackInSlot(1);

			durability = itemstack1.getItemDamage();

			// Declare output Items here
			ItemStack netherite_sword = new ItemStack(ModItems.NETHERITE_SWORD);
			ItemStack netherite_pickaxe = new ItemStack(ModItems.NETHERITE_PICKAXE);
			ItemStack netherite_axe = new ItemStack(ModItems.NETHERITE_AXE);
			ItemStack netherite_shovel = new ItemStack(ModItems.NETHERITE_SHOVEL);
			ItemStack netherite_hoe = new ItemStack(ModItems.NETHERITE_HOE);
			ItemStack netherite_helmet = new ItemStack(ModItems.NETHERITE_HELMET);
			ItemStack netherite_chestplate = new ItemStack(ModItems.NETHERITE_CHESTPLATE);
			ItemStack netherite_leggings = new ItemStack(ModItems.NETHERITE_LEGGINGS);
			ItemStack netherite_boots = new ItemStack(ModItems.NETHERITE_BOOTS);

			Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemstack1);
			if (!itemstack2.isEmpty()) {
				if (itemstack2.getItem() == ModItems.NETHERITE_INGOT) {
					if (itemstack1.getItem() == Items.DIAMOND_SWORD) {
						netherite_sword.setItemDamage(durability);
						EnchantmentHelper.setEnchantments(map, netherite_sword);
						this.outputSlot.setInventorySlotContents(0, netherite_sword);
					}
					else if (itemstack1.getItem() == Items.DIAMOND_PICKAXE) {
						netherite_pickaxe.setItemDamage(durability);
						EnchantmentHelper.setEnchantments(map, netherite_pickaxe);
						this.outputSlot.setInventorySlotContents(0, netherite_pickaxe);
					}
					else if(itemstack1.getItem() == Items.DIAMOND_AXE) {
						netherite_axe.setItemDamage(durability);
						EnchantmentHelper.setEnchantments(map, netherite_axe);
						this.outputSlot.setInventorySlotContents(0, netherite_axe);
					}
					else if(itemstack1.getItem() == Items.DIAMOND_SHOVEL) {
						netherite_shovel.setItemDamage(durability);
						EnchantmentHelper.setEnchantments(map, netherite_shovel);
						this.outputSlot.setInventorySlotContents(0, netherite_shovel);
					}
					else if(itemstack1.getItem() == Items.DIAMOND_HOE) {
						netherite_hoe.setItemDamage(durability);
						EnchantmentHelper.setEnchantments(map, netherite_hoe);
						this.outputSlot.setInventorySlotContents(0, netherite_hoe);
					}
					else if(itemstack1.getItem() == Items.DIAMOND_HELMET) {
						netherite_helmet.setItemDamage(durability);
						EnchantmentHelper.setEnchantments(map, netherite_helmet);
						this.outputSlot.setInventorySlotContents(0, netherite_helmet);
					}
					else if(itemstack1.getItem() == Items.DIAMOND_CHESTPLATE) {
						netherite_chestplate.setItemDamage(durability);
						EnchantmentHelper.setEnchantments(map, netherite_chestplate);
						this.outputSlot.setInventorySlotContents(0, netherite_chestplate);
					}
					else if(itemstack1.getItem() == Items.DIAMOND_LEGGINGS) {
						netherite_leggings.setItemDamage(durability);
						EnchantmentHelper.setEnchantments(map, netherite_leggings);
						this.outputSlot.setInventorySlotContents(0, netherite_leggings);
					}
					else if(itemstack1.getItem() == Items.DIAMOND_BOOTS) {
						netherite_boots.setItemDamage(durability);
						EnchantmentHelper.setEnchantments(map, netherite_boots);
						this.outputSlot.setInventorySlotContents(0, netherite_boots);
					}
				}
			}
		}
	}
}
