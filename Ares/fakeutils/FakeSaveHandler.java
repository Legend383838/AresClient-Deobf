package Ares.fakeutils;

import java.io.File;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.storage.IPlayerFileData;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;

public class FakeSaveHandler implements ISaveHandler {
   public void flush() {
   }

   public String getWorldDirectoryName() {
      return "";
   }

   public File getWorldDirectory() {
      return null;
   }

   public void saveWorldInfo(WorldInfo var1) {
   }

   public File getMapFileFromName(String var1) {
      return null;
   }

   public void saveWorldInfoWithPlayer(WorldInfo var1, NBTTagCompound var2) {
   }

   public void checkSessionLock() throws MinecraftException {
   }

   public IPlayerFileData getPlayerNBTManager() {
      return null;
   }

   public WorldInfo loadWorldInfo() {
      return null;
   }

   public IChunkLoader getChunkLoader(WorldProvider var1) {
      return null;
   }
}
