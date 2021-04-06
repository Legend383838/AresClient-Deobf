package Ares.fakeutils;

import com.google.common.base.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.profiler.Profiler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;

public class FakeWorld extends World {
   public Chunk getChunkFromChunkCoords(int var1, int var2) {
      return null;
   }

   public void markBlocksDirtyVertical(int var1, int var2, int var3, int var4) {
   }

   public <T extends Entity> List<T> getEntities(Class<? extends T> var1, Predicate<? super T> var2) {
      return new ArrayList();
   }

   public boolean canBlockFreezeNoWater(BlockPos var1) {
      return false;
   }

   public boolean canSeeSky(BlockPos var1) {
      return var1.getY() > 62;
   }

   public MovingObjectPosition rayTraceBlocks(Vec3 var1, Vec3 var2) {
      return null;
   }

   public long getSeed() {
      return 1L;
   }

   public void notifyNeighborsRespectDebug(BlockPos var1, Block var2) {
   }

   public Entity findNearestEntityWithinAABB(Class var1, AxisAlignedBB var2, Entity var3) {
      return null;
   }

   public void spawnParticle(EnumParticleTypes var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14) {
   }

   public boolean isThundering() {
      return false;
   }

   public boolean checkBlockCollision(AxisAlignedBB var1) {
      return false;
   }

   public int getStrongPower(BlockPos var1, EnumFacing var2) {
      return 0;
   }

   public void updateAllPlayersSleepingFlag() {
   }

   public int getHeight() {
      return 256;
   }

   public boolean isSidePowered(BlockPos var1, EnumFacing var2) {
      return false;
   }

   public <T extends Entity> List<T> getEntitiesWithinAABB(Class<? extends T> var1, AxisAlignedBB var2, Predicate<? super T> var3) {
      return new ArrayList();
   }

   public boolean isBlockinHighHumidity(BlockPos var1) {
      return false;
   }

   public List<Entity> getEntitiesInAABBexcluding(Entity var1, AxisAlignedBB var2, Predicate<? super Entity> var3) {
      return new ArrayList();
   }

   public boolean checkNoEntityCollision(AxisAlignedBB var1, Entity var2) {
      return true;
   }

   public void removePlayerEntityDangerously(Entity var1) {
   }

   public int getStrongPower(BlockPos var1) {
      return 0;
   }

   public int getActualHeight() {
      return 256;
   }

   public boolean canBlockSeeSky(BlockPos var1) {
      return var1.getY() > 62;
   }

   public String getDebugLoadedEntities() {
      return "";
   }

   public void setItemData(String var1, WorldSavedData var2) {
   }

   public void tick() {
   }

   public void markBlockForUpdate(BlockPos var1) {
   }

   public boolean isAirBlock(BlockPos var1) {
      return var1.getY() > 63;
   }

   public boolean addTileEntity(TileEntity var1) {
      return true;
   }

   public int getLightFromNeighbors(BlockPos var1) {
      return 14;
   }

   public boolean addWeatherEffect(Entity var1) {
      return false;
   }

   public int getRedstonePower(BlockPos var1, EnumFacing var2) {
      return 0;
   }

   public boolean isAABBInMaterial(AxisAlignedBB var1, Material var2) {
      return false;
   }

   public int getLightFromNeighborsFor(EnumSkyBlock var1, BlockPos var2) {
      return 14;
   }

   public void markChunkDirty(BlockPos var1, TileEntity var2) {
   }

   public void notifyNeighborsOfStateChange(BlockPos var1, Block var2) {
   }

   public TileEntity getTileEntity(BlockPos var1) {
      return null;
   }

   public <T extends Entity> List<T> getEntitiesWithinAABB(Class<? extends T> var1, AxisAlignedBB var2) {
      return new ArrayList();
   }

   public void scheduleBlockUpdate(BlockPos var1, Block var2, int var3, int var4) {
   }

   public int countEntities(Class var1) {
      return 0;
   }

   public boolean isDaytime() {
      return true;
   }

   public boolean tickUpdates(boolean var1) {
      return false;
   }

   public int getLight(BlockPos var1) {
      return 14;
   }

   protected void updateBlocks() {
   }

   public void notifyLightSet(BlockPos var1) {
   }

   protected void onEntityRemoved(Entity var1) {
   }

   public boolean handleMaterialAcceleration(AxisAlignedBB var1, Material var2, Entity var3) {
      return false;
   }

   public void updateEntityWithOptionalForce(Entity var1, boolean var2) {
      if (var2) {
         ++var1.ticksExisted;
      }

   }

   public void markTileEntityForRemoval(TileEntity var1) {
   }

   public void addTileEntities(Collection<TileEntity> var1) {
   }

   public BlockPos getTopSolidOrLiquidBlock(BlockPos var1) {
      return new BlockPos(var1.getX(), 63, var1.getZ());
   }

   public BlockPos getHeight(BlockPos var1) {
      return new BlockPos(var1.getX(), 63, var1.getZ());
   }

   public boolean isMaterialInBB(AxisAlignedBB var1, Material var2) {
      return false;
   }

   public boolean setBlockState(BlockPos var1, IBlockState var2, int var3) {
      return true;
   }

   public void setEntityState(Entity var1, byte var2) {
   }

   public long getWorldTime() {
      return 1L;
   }

   public float getLightBrightness(BlockPos var1) {
      return 1.0F;
   }

   public int calculateSkylightSubtracted(float var1) {
      return 6;
   }

   public MovingObjectPosition rayTraceBlocks(Vec3 var1, Vec3 var2, boolean var3, boolean var4, boolean var5) {
      return null;
   }

   public void playAuxSFXAtEntity(EntityPlayer var1, int var2, BlockPos var3, int var4) {
   }

   public void playSoundEffect(double var1, double var3, double var5, String var7, float var8, float var9) {
   }

   public boolean canSnowAt(BlockPos var1, boolean var2) {
      return false;
   }

   public void notifyBlockOfStateChange(BlockPos var1, Block var2) {
   }

   public void removeTileEntity(BlockPos var1) {
   }

   public boolean spawnEntityInWorld(Entity var1) {
      return false;
   }

   public int getLightFor(EnumSkyBlock var1, BlockPos var2) {
      return 14;
   }

   protected void updateWeather() {
   }

   public void markBlockRangeForRenderUpdate(BlockPos var1, BlockPos var2) {
   }

   public int getChunksLowestHorizon(int var1, int var2) {
      return 63;
   }

   protected void onEntityAdded(Entity var1) {
   }

   public float getSunBrightness(float var1) {
      return 1.0F;
   }

   public boolean isBlockPowered(BlockPos var1) {
      return false;
   }

   public void playAuxSFX(int var1, BlockPos var2, int var3) {
   }

   public boolean canBlockFreezeWater(BlockPos var1) {
      return false;
   }

   public void notifyNeighborsOfStateExcept(BlockPos var1, Block var2, EnumFacing var3) {
   }

   public void setRainStrength(float var1) {
   }

   public void playRecord(BlockPos var1, String var2) {
   }

   public List<Entity> getEntitiesWithinAABBExcludingEntity(Entity var1, AxisAlignedBB var2) {
      return new ArrayList();
   }

   public String getProviderName() {
      return "";
   }

   public void spawnParticle(EnumParticleTypes var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
   }

   public FakeWorld(WorldInfo var1) {
      super(new FakeSaveHandler(), var1, new FakeWorldProvider(), new Profiler(), true);
      this.provider.registerWorld(this);
   }

   public boolean canBlockFreeze(BlockPos var1, boolean var2) {
      return false;
   }

   public IChunkProvider getChunkProvider() {
      return new FakeChunkProvider();
   }

   public int isBlockIndirectlyGettingPowered(BlockPos var1) {
      return 0;
   }

   public boolean checkNoEntityCollision(AxisAlignedBB var1) {
      return true;
   }

   public void loadEntities(Collection<Entity> var1) {
   }

   public void checkSessionLock() throws MinecraftException {
   }

   public boolean extinguishFire(EntityPlayer var1, BlockPos var2, EnumFacing var3) {
      return true;
   }

   public BlockPos getSpawnPoint() {
      return new BlockPos(0, 64, 0);
   }

   protected int getRenderDistanceChunks() {
      return 0;
   }

   public void playBroadcastSound(int var1, BlockPos var2, int var3) {
   }

   public void markBlockRangeForRenderUpdate(int var1, int var2, int var3, int var4, int var5, int var6) {
   }

   public void updateEntities() {
   }

   public boolean isBlockTickPending(BlockPos var1, Block var2) {
      return false;
   }

   public void removeEntity(Entity var1) {
   }

   public void makeFireworks(double var1, double var3, double var5, double var7, double var9, double var11, NBTTagCompound var13) {
   }

   public BiomeGenBase getBiomeGenForCoords(BlockPos var1) {
      return BiomeGenBase.plains;
   }

   public boolean isInsideBorder(WorldBorder var1, Entity var2) {
      return true;
   }

   public void addBlockEvent(BlockPos var1, Block var2, int var3, int var4) {
   }

   public void playSound(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10) {
   }

   protected IChunkProvider createChunkProvider() {
      return new FakeChunkProvider();
   }

   public void playSoundToNearExcept(EntityPlayer var1, String var2, float var3, float var4) {
   }

   public boolean isRaining() {
      return false;
   }

   public void unloadEntities(Collection<Entity> var1) {
   }

   public IBlockState getBlockState(BlockPos var1) {
      return var1.getY() > 63 ? Blocks.air.getDefaultState() : Blocks.grass.getDefaultState();
   }

   public void setThunderStrength(float var1) {
   }

   public MovingObjectPosition rayTraceBlocks(Vec3 var1, Vec3 var2, boolean var3) {
      return null;
   }

   public float getRainStrength(float var1) {
      return 0.0F;
   }

   public void setLightFor(EnumSkyBlock var1, BlockPos var2, int var3) {
   }

   public boolean destroyBlock(BlockPos var1, boolean var2) {
      return this.isAirBlock(var1);
   }

   public void setTileEntity(BlockPos var1, TileEntity var2) {
   }

   public boolean setBlockToAir(BlockPos var1) {
      return true;
   }

   public long getTotalWorldTime() {
      return 1L;
   }

   public List getPendingBlockUpdates(Chunk var1, boolean var2) {
      return null;
   }

   public boolean isAnyLiquid(AxisAlignedBB var1) {
      return false;
   }

   public boolean isBlockFullCube(BlockPos var1) {
      return var1.getY() <= 63;
   }

   public void setWorldTime(long var1) {
   }

   public boolean isBlockNormalCube(BlockPos var1, boolean var2) {
      return true;
   }

   public int getLight(BlockPos var1, boolean var2) {
      return 14;
   }

   public boolean setBlockState(BlockPos var1, IBlockState var2) {
      return true;
   }

   public float getThunderStrength(float var1) {
      return 0.0F;
   }

   public void joinEntityInSurroundings(Entity var1) {
   }

   protected boolean isChunkLoaded(int var1, int var2, boolean var3) {
      return false;
   }

   public void playSoundAtEntity(Entity var1, String var2, float var3, float var4) {
   }
}
