package Ares;

import Ares.Gui.GuiCapeSelection;
import Ares.Gui.GuiFriendMain;
import Ares.Gui.GuiFriendMenu;
import Ares.Gui.GuiFriendSkins;
import Ares.Login.GuiAltLogin;
import Ares.cosmetics.CosmeticLoader;
import Ares.notis.Notification;
import Ares.notis.NotificationManager;
import Ares.notis.NotificationType;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.util.ResourceLocation;

public class ImageButton {
   protected int height;
   protected String description;
   protected int width;
   protected Minecraft mc;
   protected ResourceLocation image;
   protected int target;
   protected int x;
   protected int ani = 0;
   protected int y;

   protected void hoverAnimation(int var1, int var2) {
      if (this.isHovered(var1, var2)) {
         if (this.ani < 5) {
            ++this.ani;
         }
      } else if (this.ani > 0) {
         --this.ani;
      }

   }

   protected void Cosmeticsoff() {
      GuiIngameCosmetics.Bandanaonoff = "off";
      GuiIngameCosmetics.Wingsonoff = "off";
      GuiIngameCosmetics.Ears = "off";
      GuiIngameCosmetics.Hatonoff = "off";
      GuiIngameCosmetics2.Blaze = "off";
      GuiIngameCosmetics2.Halo = "off";
      GuiIngameCosmetics2.Shield = "off";
      GuiIngameCosmetics2.Susanoo = "off";
      GuiIngameCosmetics3.Creeper = "off";
      GuiIngameCosmetics3.Mask = "off";
      GuiIngameCosmetics3.Wither = "off";
   }

   public void onClick(int var1, int var2) {
      if (this.isHovered(var1, var2)) {
         if (this.target == 1) {
            this.mc.displayGuiScreen(new GuiSelectWorld((GuiScreen)null));
         }

         if (this.target == 2) {
            this.mc.displayGuiScreen(new GuiMultiplayer((GuiScreen)null));
         }

         if (this.target == 3) {
            this.mc.displayGuiScreen(new GuiOptions((GuiScreen)null, this.mc.gameSettings));
         }

         if (this.target == 4) {
            this.mc.displayGuiScreen(new GuiAltLogin((GuiScreen)null));
         }

         if (this.target == 5) {
            this.mc.displayGuiScreen(new GuiIngameMods());
         }

         if (this.target == 6) {
            this.mc.shutdown();
         }

         if (this.target == 8) {
            NotificationManager.show(new Notification(NotificationType.INFO, "Cooming soon", "Waypoints", 3));
         }

         if (this.target == 9) {
            this.mc.displayGuiScreen(new GuiIngameMods());
         }

         if (this.target == 10) {
            this.mc.displayGuiScreen(new GuiIngameSettings());
         }

         if (this.target == 11) {
            this.mc.displayGuiScreen(new GuiMusikPlayer());
         }

         if (this.target == 12) {
            this.mc.displayGuiScreen(new GuiCapeSelection());
         }

         if (this.target == 13) {
            this.mc.displayGuiScreen(new GuiIngameCosmetics());
         }

         if (this.target == 14) {
            this.mc.displayGuiScreen(new GuiIngameSkins());
         }

         if (this.target == 7) {
            if (GuiMainMenu.wallpaper >= 9) {
               GuiMainMenu.wallpaper = 1;
            } else {
               ++GuiMainMenu.wallpaper;
            }
         }

         if (this.target == 15) {
            this.mc.displayGuiScreen(new GuiWardarobe());
         }

         if (this.target == 16) {
            this.Cosmeticsoff();
            GuiAnimatedCapes.Capeonoff = "on";
            GuiAnimatedCapes.CapeFolder = "uno";
            GuiAnimatedCapes.MaxFrames = 28;
            GuiIngameSkins.Skinonoff = "1";
            GuiIngameSkins.Skinpath = "Skins/HDSkins/skin (2).png";
            GuiIngameCosmetics2.Blaze = "on";
            GuiIngameCosmetics2.Blazepath = "Blaze/blaze6.png";
            GuiIngameCosmetics2.Halo = "on";
            GuiIngameCosmetics2.Halopath = "Halo/halo1.png";
            CosmeticLoader.save();
         }

         if (this.target == 17) {
            this.Cosmeticsoff();
            GuiAnimatedCapes.Capeonoff = "on";
            GuiAnimatedCapes.CapeFolder = "kaktus";
            GuiAnimatedCapes.MaxFrames = 8;
            GuiIngameSkins.Skinonoff = "1";
            GuiIngameSkins.Skinpath = "Skins/HDSkins/skin (17).png";
            GuiIngameCosmetics.Wingsonoff = "on";
            GuiIngameCosmetics.Wingspath = "Wings/wings4.png";
            GuiIngameCosmetics.Bandanaonoff = "on";
            GuiIngameCosmetics.Bandanapath = "bandanas/bandana1.png";
            GuiIngameCosmetics.Ears = "on";
            GuiIngameCosmetics.Earspath = "Ears/ears1.png";
            CosmeticLoader.save();
         }

         if (this.target == 18) {
            this.Cosmeticsoff();
            GuiAnimatedCapes.Capeonoff = "on";
            GuiAnimatedCapes.CapeFolder = "skull";
            GuiAnimatedCapes.MaxFrames = 31;
            GuiIngameSkins.Skinonoff = "1";
            GuiIngameSkins.Skinpath = "Skins/EboySkins/skin (23).png";
            GuiIngameCosmetics.Wingsonoff = "on";
            GuiIngameCosmetics.Wingspath = "Wings/wings1.png";
            GuiIngameCosmetics2.Blaze = "on";
            GuiIngameCosmetics2.Blazepath = "Blaze/blaze4.png";
            GuiIngameCosmetics2.Halo = "on";
            GuiIngameCosmetics2.Halopath = "Halo/halo3.png";
            GuiIngameCosmetics2.Susanoo = "on";
            GuiIngameCosmetics2.Susanoopath = "Susanoo/Susanoo1.png";
            CosmeticLoader.save();
         }

         if (this.target == 19) {
            this.mc.displayGuiScreen(new GuiModColor());
         }

         if (this.target == 20) {
            this.mc.displayGuiScreen(new GuiClanTag((GuiScreen)null));
         }

         if (this.target == 21) {
            GuiTimechanger.Time = 0;
         }

         if (this.target == 22) {
            GuiTimechanger.Time = 13000;
         }

         if (this.target == 23) {
            GuiTimechanger.Time = 18000;
         }

         if (this.target == 24) {
            if (GuiIngameSettings.Nightmode == 0) {
               GuiIngameSettings.Nightmode = 1;
            } else {
               GuiIngameSettings.Nightmode = 0;
            }
         }

         if (this.target == 25) {
            this.mc.displayGuiScreen(new GuiTimechanger());
         }

         if (this.target == 26) {
            this.mc.displayGuiScreen(new GuiFriendMain());
         }

         if (this.target == 30) {
            this.mc.displayGuiScreen(new GuiFriendMenu((GuiScreen)null));
         }

         if (this.target == 31) {
            this.mc.displayGuiScreen(new GuiFriendSkins());
         }

         if (this.target == 33) {
            if (GuiFriendSkins.onoff.contains("off")) {
               GuiFriendSkins.onoff = "on";
            } else {
               GuiFriendSkins.onoff = "off";
            }
         }

         if (this.target == 34) {
            GuiFriendSkins.FriendFolder = "dream";
         }

         if (this.target == 35) {
            GuiFriendSkins.FriendFolder = "toad";
         }

         if (this.target == 36) {
            GuiFriendSkins.FriendFolder = "amongus";
         }

         if (this.target == 37) {
            this.mc.displayGuiScreen(new GuiMultiplayer(new GuiAresMenu()));
         }
      }

   }

   public void draw(int var1, int var2, Color var3) {
      this.hoverAnimation(var1, var2);
      if (this.ani > 0) {
         RenderUtil1.instance.draw2DImage(this.image, this.x - this.ani, this.y - this.ani, this.width + this.ani * 2, this.height + this.ani * 2, var3);
         double var4 = (double)this.mc.fontRendererObj.getStringWidth(this.description);
         if (this.target >= 7) {
            this.mc.fontRendererObj.drawString(this.description, this.x + this.width / 2 - this.mc.fontRendererObj.getStringWidth(this.description) / 2, this.y + this.height + 11, Color.WHITE.getRGB());
         }
      } else {
         RenderUtil1.instance.draw2DImage(this.image, this.x, this.y, this.width, this.height, var3);
      }

   }

   protected boolean isHovered(int var1, int var2) {
      return RenderUtil1.instance.isHovered((double)this.x, (double)this.y, (double)(this.x + this.width), (double)(this.y + this.height), var1, var2);
   }

   public ImageButton(ResourceLocation var1, int var2, int var3, int var4, int var5, String var6, int var7) {
      this.image = var1;
      this.x = var2;
      this.y = var3;
      this.width = var4;
      this.height = var5;
      this.description = var6;
      this.target = var7;
      this.mc = Minecraft.getMinecraft();
   }
}
