package ingress.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import ingress.{Ingress, References, Strings}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import ingress.entity.ExtendedPlayer
import net.minecraft.tileentity.TileEntity
import ingress.tileentities.TileEntityPortalBlock

/**
 * Created by MartijnWoudstra on 14-4-2014.
 */
object IngressPortalBlock extends Block(Material.rock) {
  setBlockName(Strings.TestBlockName)
  setCreativeTab(CreativeTabs.tabCombat)

  override def registerBlockIcons(iconRegister: IIconRegister) {
    blockIcon = iconRegister.registerIcon(References.Modid.toLowerCase + ":" + Ingress.getUnlocalizedName(this))
  }

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, entityPlayer: EntityPlayer, par1: Int, par2: Float, par3: Float, par4: Float): Boolean = {
    if (!world.isRemote) {
      val playerProperties: ExtendedPlayer = entityPlayer.getExtendedProperties("ExtendedPlayer").asInstanceOf[ExtendedPlayer]
      playerProperties.addExoticMatter(10)
      System.out.println("ExoticMatter = " + playerProperties.getExoticMatter)
    }
    entityPlayer.openGui(Ingress, 0, world, x, y, z)
    true
  }

  override def createTileEntity(world: World, metadata: Int): TileEntity = {
    new TileEntityPortalBlock
  }
}
