package ingress.event

import net.minecraftforge.event.entity.EntityEvent.EntityConstructing
import net.minecraft.entity.player.EntityPlayer
import ingress.entity.ExtendedPlayer
import cpw.mods.fml.common.eventhandler.SubscribeEvent

/**
 * Created by MartijnWoudstra on 15-4-2014.
 */
class IngressEventHandler {
  @SubscribeEvent
  def onEntityConstructing(event: EntityConstructing) {
    if (event.entity.isInstanceOf[EntityPlayer]) {
      val extededPlayer: ExtendedPlayer = new ExtendedPlayer(event.entity.asInstanceOf[EntityPlayer])
      if (event.entity.isInstanceOf[EntityPlayer] && extededPlayer.get(event.entity.asInstanceOf[EntityPlayer]) == null) {
        extededPlayer.register(event.entity.asInstanceOf[EntityPlayer])
      }
      if (event.entity.isInstanceOf[EntityPlayer] && event.entity.getExtendedProperties(extededPlayer.EXT_PROP_NAME) == null) {
        event.entity.registerExtendedProperties(extededPlayer.EXT_PROP_NAME, new ExtendedPlayer(event.entity.asInstanceOf[EntityPlayer]))
      }
    }
  }
}