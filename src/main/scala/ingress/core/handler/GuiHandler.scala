package ingress.core.handler

import cpw.mods.fml.common.network.IGuiHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import ingress.tileentities.TileEntityPortalBlock

/**
 * Created by MartijnWoudstra on 17-4-2014.
 */
object GuiHandler extends IGuiHandler{
  override def getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int){
    if(ID == 0){
      val te: TileEntityPortalBlock = world.getTileEntity(x,y,z).asInstanceOf[TileEntityPortalBlock]
      new ContainerPortalBlock(player.inventory, te)
    }
  }

  override def getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int){
    if(ID == 0){
      val te: TileEntityPortalBlock = world.getTileEntity(x,y,z).asInstanceOf[TileEntityPortalBlock]
      new GuiPortalBlock(player.inventory, te)
    }
  }
}
