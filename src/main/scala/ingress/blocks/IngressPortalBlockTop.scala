package ingress.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import ingress.{Ingress, Strings}
import net.minecraft.world.{Explosion, World}
import net.minecraft.entity.player.EntityPlayer
import ingress.entity.ExtendedPlayer

/**
 * Created by MartijnWoudstra on 18-4-2014.
 */
object IngressPortalBlockTop extends Block(Material.rock) {
  setBlockName(Strings.IngressPortalBlockTopName)

  override def onNeighborBlockChange(world: World, x: Int, y: Int, z: Int, block: Block) {
    if(world.getBlock(x, y - 1, z) != IngressPortalBlock)
      world.setBlockToAir(x, y, z)
  }

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, entityPlayer: EntityPlayer, par1: Int, par2: Float, par3: Float, par4: Float): Boolean = {
    if (!world.isRemote) {
      val playerProperties: ExtendedPlayer = entityPlayer.getExtendedProperties("ExtendedPlayer").asInstanceOf[ExtendedPlayer]
      playerProperties.addExoticMatter(10)
    }
    entityPlayer.openGui(Ingress, 0, world, x, y, z)
    true
  }
}
