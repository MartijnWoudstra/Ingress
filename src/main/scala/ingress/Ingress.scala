package ingress

import cpw.mods.fml.common.{SidedProxy, Mod}
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import ingress.core.proxy.CommonProxy
import cpw.mods.fml.common.registry.GameRegistry
import ingress.blocks.TestBlock
import net.minecraft.block.Block

/**
 * Created by MartijnWoudstra on 14-4-2014.
 */

@Mod(modid = References.Modid, name = References.Modname, version = References.Version, modLanguage = "scala")
object Ingress {

  @SidedProxy(clientSide = References.ClientSide, serverSide = References.ServerSide)
  var proxy: CommonProxy = null

  @EventHandler
  def preInit(event: FMLPreInitializationEvent){
    addBlocks()
  }

  @EventHandler
  def init(event: FMLInitializationEvent){

  }

  @EventHandler
  def postInit(event: FMLPostInitializationEvent){

  }

  def addBlocks(){
    def getUnlocalizedName(block: Block) : String = {
      block.getUnlocalizedName.substring(block.getUnlocalizedName.indexOf(".") + 1)
    }

    GameRegistry.registerBlock(TestBlock, getUnlocalizedName(TestBlock))
  }
}

object References{
  final val Modid = "Ingress"
  final val Modname = "Ingress Mod"
  final val Version = "0.0.1"
  final val ClientSide = "ingress.core.proxy.ClientProxy"
  final val ServerSide = "ingress.core.proxy.ServerProxy"
}

object Strings{
  final val TestBlockName = "testBlock"
}