package Ares.fakeutils;

import Ares.GuiIngameCosmetics2;
import Ares.Gui.GuiFriendMenu;
import com.google.common.base.Objects;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldSettings.GameType;

public class FakeNetworkPlayerInfo extends NetworkPlayerInfo {
   public int getResponseTime() {
      return 0;
   }

   public IChatComponent getDisplayName() {
      return new ChatComponentText(this.getGameProfile().getName());
   }

   public String getSkinType() {
      return "default";
   }

   public ResourceLocation getLocationSkin() {
      if (this.locationSkin == null) {
         this.loadPlayerTextures();
      }

      if (GuiFriendMenu.Gang == 1) {
         for(int var1 = 0; var1 < GuiFriendMenu.Friends.size(); ++var1) {
            if (this.gameProfile.getName().equals(GuiFriendMenu.Friends.get(var1))) {
               return new ResourceLocation("FriendSkins/" + var1 + ".png");
            }
         }
      }

      return GuiIngameCosmetics2.Skin == 1 && this.gameProfile.getName().equals(Minecraft.getMinecraft().getSession().getUsername()) ? new ResourceLocation("HDSkins/HDSkin" + GuiIngameCosmetics2.SkinTexture + ".png") : (ResourceLocation)Objects.firstNonNull(this.locationSkin, DefaultPlayerSkin.getDefaultSkin(this.gameProfile.getId()));
   }

   public ScorePlayerTeam getPlayerTeam() {
      return null;
   }

   public GameType getGameType() {
      return GameType.CREATIVE;
   }

   public FakeNetworkPlayerInfo(GameProfile var1) {
      super(var1);
   }
}
