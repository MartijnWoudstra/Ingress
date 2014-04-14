package ingress.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import ingress.Strings
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.client.renderer.texture.IIconRegister

/**
 * Created by MartijnWoudstra on 14-4-2014.
 */
object TestBlock extends Block(Material.rock){
  setBlockName(Strings.TestBlockName)
  setCreativeTab(CreativeTabs.tabCombat)

  override def registerBlockIcons(iconRegister: IIconRegister){

  }
}
