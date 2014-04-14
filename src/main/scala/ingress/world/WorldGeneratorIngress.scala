package ingress.world

import cpw.mods.fml.common.IWorldGenerator
import java.util.Random
import net.minecraft.world.World
import net.minecraft.world.chunk.IChunkProvider
import net.minecraft.block.Block
import net.minecraft.world.gen.feature.{WorldGenFlowers, WorldGenMinable}
import net.minecraft.init.Blocks
import ingress.blocks.TestBlock

/**
 * Created by MartijnWoudstra on 14-4-2014.
 */
object WorldGeneratorIngress extends IWorldGenerator{
  override def generate(random: Random, chunkX: Int, chunkZ: Int, world: World, chunkGenerator: IChunkProvider, chunkProvider: IChunkProvider)
  {
    if(world.provider.dimensionId == 0)
      generateOverworld(random, world, chunkX*16, chunkZ*16)
    else if(world.provider.dimensionId == -1)
      generateNether(random, world, chunkX*16, chunkZ*16)
    else if(world.provider.dimensionId == 1)
      generateEnd(random, world, chunkX*16, chunkZ*16)
  }

  /**
   * Adds generation for the overworld. Add oreSpawn like the example below
   * addOreSpawn(block, random, world, xChunk, zChunk, int, int, int, int, int);
   * @param random the random object
   * @param world the world object
   * @param xChunk chunk x coordinate
   * @param zChunk chunk z coordinate
   */
  def generateOverworld(random: Random, world: World, xChunk: Int, zChunk: Int){
    addFlowerSpawnOverworld(TestBlock, random, world, xChunk, zChunk, 10, 50, 1, 0, 120)
  }

  /**
   * Adds generation for the nether. Add oreSpawn like the example below
   * addOreSpawn(block, random, world, xChunk, zChunk, int, int, int, int, int);
   * @param random the random object
   * @param world the world object
   * @param xChunk chunk x coordinate
   * @param zChunk chunk z coordinate
   */
  def generateNether(random: Random, world: World, xChunk: Int, zChunk: Int){
    //TODO add nether generator
  }

  /**
   * Adds generation for the end. Add oreSpawn like the example below
   * addOreSpawn(block, random, world, xChunk, zChunk, int, int, int, int, int);
   * @param random the random object
   * @param world the world object
   * @param xChunk chunk x coordinate
   * @param zChunk chunk z coordinate
   */
  def generateEnd(random: Random, world: World, xChunk: Int, zChunk: Int){
    //TODO add end generator
  }

  /**
   *
   * This method adds our block to the world.
   * It randomizes the coordinates, and does that as many times, as defined in spawnChance.
   * Then it gives all the params to WorldGenMinable, which handles the replacing of the ores for us.
   *
   *@param block The block you want to spawn
   *@param random The Random
   *@param world The world
   *@param blockXPos the blockXpos of a chunk
   *@param blockZPos the blockZpos of a chunk
   *@param minVainSize min vain
   *@param maxVainSize max vain
   *@param chancesToSpawn the chance to spawn. Usually around 2
   *@param minY lowest point to spawn
   *@param maxY highest point to spawn
   */
  def addOreSpawnOverworld(block: Block, random: Random, world: World, blockXPos: Int, blockZPos: Int, minVainSize: Int, maxVainSize: Int, chancesToSpawn: Int, minY: Int, maxY: Int ){
    for(i <- 0 until chancesToSpawn){
      val posX = blockXPos + random.nextInt(16)
      val posY = minY + random.nextInt(maxY - minY)
      val posZ = blockZPos + random.nextInt(16)
      new WorldGenMinable(block, minVainSize + random.nextInt(maxVainSize - minVainSize), Blocks.stone).generate(world, random, posX, posY, posZ);
    }
  }

  /**
   *
   * This method adds our block to the world.
   * It randomizes the coordinates, and does that as many times, as defined in spawnChance.
   * Then it gives all the params to WorldGenMinable, which handles the replacing of the ores for us.
   *
   *@param block The block you want to spawn
   *@param random The Random
   *@param world The world
   *@param blockXPos the blockXpos of a chunk
   *@param blockZPos the blockZpos of a chunk
   *@param minVainSize min vain
   *@param maxVainSize max vain
   *@param chancesToSpawn the chance to spawn. Usually around 2
   *@param minY lowest point to spawn
   *@param maxY highest point to spawn
   */
  def addFlowerSpawnOverworld(block: Block, random: Random, world: World, blockXPos: Int, blockZPos: Int, minVainSize: Int, maxVainSize: Int, chancesToSpawn: Int, minY: Int, maxY: Int ){
    for(i <- 0 until chancesToSpawn){
      val posX = blockXPos + random.nextInt(16)
      val posY = minY + random.nextInt(maxY - minY)
      val posZ = blockZPos + random.nextInt(16)
      new WorldGenFlowers(block).generate(world, random, posX, posY, posZ);
    }
  }
}
