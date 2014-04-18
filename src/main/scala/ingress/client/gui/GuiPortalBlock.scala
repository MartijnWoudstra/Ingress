package ingress.client.gui

import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.entity.player.InventoryPlayer
import ingress.inventory.ContainerPortalBlock
import ingress.tileentities.TileEntityPortalBlock
import net.minecraft.util.ResourceLocation
import ingress.References
import cpw.mods.fml.client.FMLClientHandler

/**
 * Created by MartijnWoudstra on 18-4-2014.
 */
class GuiPortalBlock(inventory: InventoryPlayer, tileEntity: TileEntityPortalBlock) extends GuiContainer(new ContainerPortalBlock(inventory, tileEntity)) {

  private final val texture: ResourceLocation = new ResourceLocation(References.Modid, "/textures/gui/GuiPortal.png")
  xSize = 12 //TODO Adjust to gui texture size
  ySize = 12

  //TODO Adjust to gui texture size

  override def drawGuiContainerBackgroundLayer(float: Float, mouseX: Int, mouseZ: Int) {
    FMLClientHandler.instance().getClient.getTextureManager.bindTexture(texture)
    val x: Int = (this.width + xSize) / 2
    val y: Int = (this.height + ySize) / 2
    drawTexturedModalRect(x, y, 0, 0, xSize, ySize)
  }
}
