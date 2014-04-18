package ingress.core.proxy

import cpw.mods.fml.common.registry.GameRegistry
import ingress.tileentities.TileEntityPortalBlock

/**
 * Created by MartijnWoudstra on 14-4-2014.
 */
class CommonProxy {
  def registerTileEntities() {
    GameRegistry.registerTileEntity(classOf[TileEntityPortalBlock], "tileEntityPortalBlock")
  }
}
