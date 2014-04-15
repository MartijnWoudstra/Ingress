package ingress.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import ingress.{Ingress, References, Strings}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import ingress.entity.ExtendedPlayer

/**
 * Created by MartijnWoudstra on 14-4-2014.
 */
object IngressPortalBlock extends Block(Material.rock) {
  setBlockName(Strings.TestBlockName)
  setCreativeTab(CreativeTabs.tabCombat)

  override def registerBlockIcons(iconRegister: IIconRegister) {
    blockIcon = iconRegister.registerIcon(References.Modid.toLowerCase + ":" + Ingress.getUnlocalizedName(this))
  }

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, entityPlayer: EntityPlayer, p_149727_6_ : Int, p_149727_7_ : Float, p_149727_8_ : Float, p_149727_9_ : Float): Boolean = {
    if(!world.isRemote) {
      val playerProperties: ExtendedPlayer = new ExtendedPlayer(entityPlayer)
      playerProperties.addExoticMatter(10)
      System.out.println("ExoticMatter = " + playerProperties.getExoticMatter)
    }
    true
  }
}
