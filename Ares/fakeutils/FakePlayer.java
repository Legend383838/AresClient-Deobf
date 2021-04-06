package Ares.fakeutils;

import Ares.mods.impl.togglesprintsneak.AresMovementInmput;
import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.world.World;

public class FakePlayer extends EntityPlayerSP {
   public boolean hasPlayerInfo() {
      return true;
   }

   protected NetworkPlayerInfo getPlayerInfo() {
      return new FakeNetworkPlayerInfo(this.getGameProfile());
   }

   public FakePlayer(Minecraft var1, World var2) {
      this(var1, var2, checkNullGameProfile());
   }

   private static GameProfile checkNullGameProfile() {
      return Minecraft.getMinecraft().getSession() != null && Minecraft.getMinecraft().getSession().getProfile() != null ? Minecraft.getMinecraft().getSession().getProfile() : new GameProfile(UUID.randomUUID(), "FakePlayer");
   }

   public FakePlayer(Minecraft var1, World var2, GameProfile var3) {
      super(var1, var2, new NetHandlerPlayClient(var1, var1.currentScreen, new FakeNetworkManager(EnumPacketDirection.CLIENTBOUND), var3, var3) {
         private final GameProfile val$gp;

         public NetworkPlayerInfo getPlayerInfo(UUID var1) {
            return new FakeNetworkPlayerInfo(this.val$gp);
         }

         {
            this.val$gp = var5;
         }

         public NetworkPlayerInfo getPlayerInfo(String var1) {
            return new FakeNetworkPlayerInfo(this.val$gp);
         }
      }, (StatFileWriter)null);
      this.dimension = 0;
      this.movementInput = new AresMovementInmput((GameSettings)null);
      this.posX = 0.0D;
      this.posY = 0.0D;
      this.posZ = 0.0D;
   }

   public boolean isWearing(EnumPlayerModelParts var1) {
      return true;
   }

   public float getEyeHeight() {
      return 1.82F;
   }
}
