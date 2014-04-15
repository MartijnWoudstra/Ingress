package ingress.world

import java.util.Random
import net.minecraft.world.World
import net.minecraft.world.gen.feature.WorldGenerator
import net.minecraft.block.Block

/**
 * WorldGenPortals
 * Generates the portals in the world, just on the surface
 * @param block block to place
 */
class WorldGenPortals(block: Block) extends WorldGenerator {
  override def generate(world: World, random: Random, x: Int, y: Int, z: Int): Boolean = {
    for (l <- 0 until 64) {
      if (world.isAirBlock(x, y, z) && world.getBlock(x, y, z).canBlockStay(world, x, y, z) && world.canBlockSeeTheSky(x, y - 1, z) && !world.isAirBlock(x, y - 1, z)) {

        val r = scala.util.Random
        val i = r.nextInt(3) // [0;value[ from integers

        i match{
          case 0 =>
            world.setBlock(x, y-1, z, block)

          case 1 =>
            world.setBlock(x, y-1, z, block)
            world.setBlock(x, y, z, block)

          case 2 =>
            world.setBlock(x, y-1, z, block)
            world.setBlock(x, y, z, block)
            world.setBlock(x, y+1, z, block)
        }
      }
    }
    true
  }
}
