package ingress.inventory

import net.minecraft.inventory.{Slot, Container}
import net.minecraft.entity.player.{InventoryPlayer, EntityPlayer}
import ingress.tileentities.TileEntityPortalBlock

/**
 * Created by MartijnWoudstra on 18-4-2014.
 */
class ContainerPortalBlock(inventoryPlayer: InventoryPlayer, tileEntity: TileEntityPortalBlock) extends Container {

  val inventory: InventoryPlayer = inventoryPlayer
  val te: TileEntityPortalBlock = tileEntity
  bindPlayerInventory(inventoryPlayer)

  def bindPlayerInventory(inventoryPlayer: InventoryPlayer) {

    var id: Int = 0
    for (i <- 0 until 9) {
      addSlotToContainer(new Slot(inventoryPlayer, id, i * 18 + 8, 189))
      id += 1
    }
    for (i <- 0 until 9) {
      for (j <- 0 until 3) {
        addSlotToContainer(new Slot(inventory, id, i * 18 + 8, j * 18 + 131))
        id += 1
      }
    }
    //TODO DRAW GUI SLOTS
  }


  override def canInteractWith(var1: EntityPlayer): Boolean = {
    true
  }
}
