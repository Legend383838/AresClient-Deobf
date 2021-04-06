package Ares;

import Ares.CustomCapes.GuiIngameCustomCape;
import Ares.cosmetics.CosmeticLoader;
import Ares.notis.Notification;
import Ares.notis.NotificationManager;
import Ares.notis.NotificationType;
import com.google.common.collect.Lists;
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;

public class GuiIngameCape extends GuiScreen {
   public static String Online = "on";
   protected ArrayList<ImageButton> ImageButtons = new ArrayList();
   ArrayList arraylist = Lists.newArrayList();
   private int field_146445_a;
   int k = 1;
   public static int Arrow = 2;
   public static String CapeFolder = "FadeCape";
   public static int CapeNumber = 5;
   private int field_146444_f;

   public void setBlockOverlay(int var1, String var2, int var3) {
      var2 = CapeFolder;
      var1 = CapeNumber;
      var3 = Arrow;
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         try {
            FileWriter var1 = new FileWriter("AresFolder/ModColor.txt");
            var1.write(GuiIngameSettings.ModColor);
            var1.close();
            FileWriter var2 = new FileWriter("AresFolder/Capepath.txt");
            var2.write(LayerCape.Capepath);
            var2.close();
            System.out.println("Successfully wrote to the file.");
         } catch (IOException var3) {
            System.out.println("An error occurred.");
            var3.printStackTrace();
         }

         super.onGuiClosed();
         CosmeticLoader.save();
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawCenteredString(this.fontRendererObj, I18n.format("Select your Cape", new Object[0]), width / 2, height / 2 + 150, 16777215);
      this.drawCenteredString(this.fontRendererObj, I18n.format("Selected Cape: " + CapeFolder + " " + CapeNumber + "/10", new Object[0]), width / 2, height / 2 + 170, 16777215);
      byte var4 = 30;
      byte var5 = 5;
      if (Arrow == 1) {
         this.drawCenteredString(this.fontRendererObj, I18n.format("<<<", new Object[0]), 100, 5 + var4 + var5, 16777215);
      }

      if (Arrow == 2) {
         this.drawCenteredString(this.fontRendererObj, I18n.format("<<<", new Object[0]), 100, 30 + var4 + var5, 16777215);
      }

      if (Arrow == 3) {
         this.drawCenteredString(this.fontRendererObj, I18n.format("<<<", new Object[0]), 100, 55 + var4 + var5, 16777215);
      }

      if (Arrow == 4) {
         this.drawCenteredString(this.fontRendererObj, I18n.format("<<<", new Object[0]), 100, 80 + var4 + var5, 16777215);
      }

      if (Arrow == 5) {
         this.drawCenteredString(this.fontRendererObj, I18n.format("<<<", new Object[0]), 100, 105 + var4 + var5, 16777215);
      }

      if (Arrow == 6) {
         this.drawCenteredString(this.fontRendererObj, I18n.format("<<<", new Object[0]), 100, 130 + var4 + var5, 16777215);
      }

      if (Arrow == 7) {
         this.drawCenteredString(this.fontRendererObj, I18n.format("<<<", new Object[0]), 100, 155 + var4 + var5, 16777215);
      }

      if (Arrow == 8) {
         this.drawCenteredString(this.fontRendererObj, I18n.format("<<<", new Object[0]), 100, 180 + var4 + var5, 16777215);
      }

      if (Arrow == 9) {
         this.drawCenteredString(this.fontRendererObj, I18n.format("<<<", new Object[0]), 100, 205 + var4 + var5, 16777215);
      }

      super.drawScreen(var1, var2, var3);
      Iterator var7 = this.ImageButtons.iterator();

      while(var7.hasNext()) {
         ImageButton var6 = (ImageButton)var7.next();
         var6.draw(var1, var2, Color.WHITE);
      }

   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 15) {
         NotificationManager.show(new Notification(NotificationType.INFO, "Cape", "Online Capes on", 1));
         Online = "on";
      }

      if (var1.id == 14) {
         NotificationManager.show(new Notification(NotificationType.INFO, "Cape", "Online Capes off", 1));
         Online = "off";
      }

      if (var1.id == 0) {
         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
      }

      if (var1.id == 1) {
         if (CapeNumber >= 2) {
            --CapeNumber;
         } else {
            CapeNumber = 1;
         }

         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
      }

      if (var1.id == 2) {
         if (CapeNumber <= 9) {
            ++CapeNumber;
         } else {
            CapeNumber = 10;
         }

         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
      }

      if (var1.id == 3) {
         CapeFolder = "AnimeCape";
         Arrow = 1;
         CapeNumber = 1;
         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cape", "Collection: " + CapeFolder, 1));
      }

      if (var1.id == 4) {
         CapeFolder = "FadeCape";
         Arrow = 2;
         CapeNumber = 5;
         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cape", "Collection: " + CapeFolder, 1));
      }

      if (var1.id == 5) {
         CapeFolder = "EboyCape";
         Arrow = 3;
         CapeNumber = 1;
         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cape", "Collection: " + CapeFolder, 1));
      }

      if (var1.id == 6) {
         CapeFolder = "EgirlCape";
         Arrow = 4;
         CapeNumber = 1;
         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cape", "Collection: " + CapeFolder, 1));
      }

      if (var1.id == 7) {
         CapeFolder = "MojangCape";
         Arrow = 5;
         CapeNumber = 1;
         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cape", "Collection: " + CapeFolder, 1));
      }

      if (var1.id == 8) {
         CapeFolder = "XMasCape";
         Arrow = 6;
         CapeNumber = 1;
         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cape", "Collection: " + CapeFolder, 1));
      }

      if (var1.id == 10) {
         CapeFolder = "UserMadeCape";
         Arrow = 7;
         CapeNumber = 1;
         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cape", "Collection: " + CapeFolder, 1));
      }

      if (var1.id == 13) {
         CapeFolder = "MinimalCapes";
         Arrow = 8;
         CapeNumber = 1;
         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cape", "Collection: " + CapeFolder, 1));
      }

      if (var1.id == 17) {
         CapeFolder = "MojangCape2";
         Arrow = 9;
         CapeNumber = 1;
         LayerCape.Capepath = "cape/random/" + CapeFolder + "/def" + CapeNumber + ".png";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cape", "Collection: " + CapeFolder, 1));
      }

      if (var1.id == 9) {
         this.mc.displayGuiScreen(new GuiIngameCustomCape((GuiScreen)null));
      }

      if (var1.id == 11) {
         this.mc.displayGuiScreen(new GuiGiveCape((GuiScreen)null));
      }

      if (var1.id == 12) {
         this.mc.displayGuiScreen(new GuiAnimatedCapes());
      }

   }

   public void initGui() {
      byte var1 = 30;
      String var2 = Minecraft.getMinecraft().getSession().getUsername();
      DrawMenuLogo.drawString(1.0D, var2, (float)(width / 9 - this.fontRendererObj.getStringWidth(var2) + 200), (float)(height / 20 - 5), Color.white.getRGB());
      this.buttonList.add(new GuiButton(1, width / 2 - 45, height / 2 + 100, 40, 20, I18n.format("<<<", new Object[0])));
      this.buttonList.add(new GuiButton(2, width / 2, height / 2 + 100, 40, 20, I18n.format(">>>", new Object[0])));
      boolean var3 = true;
      byte var4 = 75;
      int var5 = var4 / 2;
      this.buttonList.add(new GuiButton(3, 5, 5 + var1, 80, 20, I18n.format("Anime Capes§f", new Object[0])));
      this.buttonList.add(new GuiButton(4, 5, 30 + var1, 80, 20, I18n.format("Fade Capes", new Object[0])));
      this.buttonList.add(new GuiButton(5, 5, 55 + var1, 80, 20, I18n.format("E-Boy Capes§f", new Object[0])));
      this.buttonList.add(new GuiButton(6, 5, 80 + var1, 80, 20, I18n.format("E-Girl Capes§f", new Object[0])));
      this.buttonList.add(new GuiButton(7, 5, 105 + var1, 80, 20, I18n.format("Mojang Capes§f", new Object[0])));
      this.buttonList.add(new GuiButton(8, 5, 130 + var1, 80, 20, I18n.format("Christmas Capes§f", new Object[0])));
      this.buttonList.add(new GuiButton(10, 5, 155 + var1, 80, 20, I18n.format("User Made Capes", new Object[0])));
      this.buttonList.add(new GuiButton(13, 5, 180 + var1, 80, 20, I18n.format("V2 Capes", new Object[0])));
      this.buttonList.add(new GuiButton(17, 5, 205 + var1, 80, 20, I18n.format("Mojang Recolor", new Object[0])));
      this.buttonList.add(new GuiButton(9, 115, 5 + var1, 80, 20, I18n.format("Custom Cape", new Object[0])));
      this.buttonList.add(new GuiButton(11, 115, 30 + var1, 80, 20, I18n.format("Set Cape Friend", new Object[0])));
      this.buttonList.add(new GuiButton(12, 115, 55 + var1, 80, 20, I18n.format("Animated Capes", new Object[0])));
      Client.getInstance().getDiscordRP().update("Changing Cape", "ign: " + Minecraft.getMinecraft().getSession().getUsername(), "capes");
      this.buttonList.add(new GuiButton(50, width - 200, 5 + var1, 80, 20, I18n.format("Online Capes", new Object[0])));
      this.buttonList.add(new GuiButton(15, width - 200 + 90, 5 + var1, 20, 20, I18n.format("on", new Object[0])));
      this.buttonList.add(new GuiButton(14, width - 200 + 90 + 25, 5 + var1, 20, 20, I18n.format("off", new Object[0])));
   }

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   public static void drawEntityOnScreen(int var0, int var1, int var2, float var3, float var4, EntityLivingBase var5) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)var0, (float)var1, 50.0F);
      GlStateManager.scale((float)(-var2), (float)var2, (float)var2);
      GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
      float var6 = var5.renderYawOffset;
      float var7 = var5.rotationYaw;
      float var8 = var5.rotationPitch;
      float var9 = var5.prevRotationYawHead;
      float var10 = var5.rotationYawHead;
      GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(-((float)Math.atan((double)(var4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      var5.renderYawOffset = (float)Math.atan((double)(var3 / 40.0F)) * 20.0F;
      var5.rotationYaw = (float)Math.atan((double)(var3 / 40.0F)) * 40.0F;
      var5.rotationPitch = -((float)Math.atan((double)(var4 / 40.0F))) * 20.0F;
      var5.rotationYawHead = var5.rotationYaw;
      var5.prevRotationYawHead = var5.rotationYaw;
      GlStateManager.translate(0.0F, 0.0F, 0.0F);
      RenderManager var11 = Minecraft.getMinecraft().getRenderManager();
      var11.setPlayerViewY(180.0F);
      var11.setRenderShadow(false);
      var11.renderEntityWithPosYaw(var5, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      var11.setRenderShadow(true);
      var5.renderYawOffset = var6;
      var5.rotationYaw = var7;
      var5.rotationPitch = var8;
      var5.prevRotationYawHead = var9;
      var5.rotationYawHead = var10;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }
}
