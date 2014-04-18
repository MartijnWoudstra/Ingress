package ingress.tileentities

import net.minecraft.tileentity.TileEntity
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.entity.player.EntityPlayer

/**
 * Created by MartijnWoudstra on 17-4-2014.
 */
class TileEntityPortalBlock extends TileEntity with IInventory {

  private val InventorySize: Int = 6
  //TODO make inventory
  private val itemStacks = new Array[ItemStack](7)
  private val InventoryStackLimit = 64

  override def isItemValidForSlot(slotIndex: Int, itemStack: ItemStack): Boolean = {
    //TODO
    true
  }

  override def closeInventory() {

  }

  override def openInventory() {

  }

  override def isUseableByPlayer(entityPlayer: EntityPlayer): Boolean = {
    !entityPlayer.isSneaking
  }

  override def getInventoryStackLimit: Int = {
    InventoryStackLimit
  }

  override def hasCustomInventoryName: Boolean = {
    false
  }

  override def getInventoryName: String = {
    ""
  }

  override def setInventorySlotContents(slotIndex: Int, itemStack: ItemStack) {
    itemStacks(slotIndex) = itemStack
    if (itemStack != null && itemStack.stackSize > getInventoryStackLimit)
      itemStack.stackSize = getInventoryStackLimit
  }

  override def getStackInSlotOnClosing(slotIndex: Int): ItemStack = {
    val is: ItemStack = getStackInSlot(slotIndex)
    if (is != null)
      setInventorySlotContents(slotIndex, null)
    is
  }

  override def decrStackSize(slotIndex: Int, decrementAmount: Int): ItemStack = {
    var is: ItemStack = getStackInSlot(slotIndex)
    if (is != null) {
      if (is.stackSize <= decrementAmount)
        setInventorySlotContents(slotIndex, null)
      else {
        is = is.splitStack(decrementAmount)
        if (is.stackSize == 0)
          setInventorySlotContents(slotIndex, null)
      }
    }
    is
  }

  override def getStackInSlot(slotIndex: Int): ItemStack = {
    itemStacks(slotIndex)
  }

  override def getSizeInventory: Int = {
    InventorySize
  }
}
