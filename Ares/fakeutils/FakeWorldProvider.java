package Ares.fakeutils;

import net.minecraft.util.BlockPos;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class FakeWorldProvider extends WorldProvider {
   public boolean doesWaterVaporize() {
      return false;
   }

   public boolean isSurfaceWorld() {
      return true;
   }

   public boolean canRespawnHere() {
      return true;
   }

   public boolean isSkyColored() {
      return false;
   }

   public String getInternalNameSuffix() {
      return "";
   }

   public boolean canCoordinateBeSpawn(int var1, int var2) {
      return true;
   }

   public int getAverageGroundLevel() {
      return 63;
   }

   public IChunkProvider createChunkGenerator() {
      return new FakeChunkProvider();
   }

   public BlockPos getSpawnCoordinate() {
      return new BlockPos(0, 64, 0);
   }

   public boolean doesXZShowFog(int var1, int var2) {
      return false;
   }

   public String getDimensionName() {
      return "";
   }
}
