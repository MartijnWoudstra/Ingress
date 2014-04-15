package ingress.entity

import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World
import net.minecraftforge.common.IExtendedEntityProperties

class ExtendedPlayer(entityPlayer: EntityPlayer) extends IExtendedEntityProperties {
  final val EXT_PROP_NAME: String = "ExtendedPlayer"
  var player: EntityPlayer = entityPlayer
  var currentExoticMatter: Int = 0

  def register(player: EntityPlayer) {
    player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayer(player))
  }

  def get(player: EntityPlayer): ExtendedPlayer = {
    player.getExtendedProperties(EXT_PROP_NAME).asInstanceOf[ExtendedPlayer]
  }

  @Override
  def saveNBTData(compound: NBTTagCompound) {
    val properties: NBTTagCompound = new NBTTagCompound()
    properties.setInteger("CurrentExoticMatter", this.currentExoticMatter)
    compound.setTag(EXT_PROP_NAME, properties)
  }

  @Override
  def loadNBTData(compound: NBTTagCompound) {

    val properties: NBTTagCompound = compound.getTag(EXT_PROP_NAME).asInstanceOf[NBTTagCompound]
    this.currentExoticMatter = properties.getInteger("CurrentExoticMatter")
  }

  @Override
  def init(entity: Entity, world: World) {
  }

  def consumeExoticMatter(amount: Int): Boolean = {
    if (currentExoticMatter - amount > 0) {
      this.currentExoticMatter = this.currentExoticMatter - amount
      true
    }
    else
      false
  }

  def addExoticMatter(amount: Int) {
    currentExoticMatter += amount
  }

  def getExoticMatter: Int = {
    this.currentExoticMatter
  }
}