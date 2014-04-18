package ingress.world

import java.util.Random
import net.minecraft.world.World
import net.minecraft.world.gen.feature.WorldGenerator
import net.minecraft.block.Block
import ingress.blocks.{IngressPortalBlockTop, IngressPortalBlock}
import net.minecraftforge.common.util.ForgeDirection
import net.minecraft.init.Blocks

/**
 * WorldGenPortals
 * Generates the portals in the world, just on the surface
 * @param block block to place
 */
class WorldGenPortals(block: Block) extends WorldGenerator {
  override def generate(world: World, random: Random, x: Int, y: Int, z: Int): Boolean = {
    for (l <- 0 until 64) {
      if ((world.isAirBlock(x, y, z)|| world.getBlock(x,y,z).isReplaceable(world, x,y,z)) &&
          world.isSideSolid(x, y - 1, z, ForgeDirection.UP) &&
          world.isAirBlock(x,y+1,z))
      {
        world.setBlock(x, y, z,IngressPortalBlock)
        world.setBlock(x, y+1, z, IngressPortalBlockTop)
        //TODO make checker for other portal <40 blocks
      }
    }
    true
  }
}
