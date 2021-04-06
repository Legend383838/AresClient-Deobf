package Ares;

import Ares.cosmetics.CosmeticLoader;
import Ares.notis.Notification;
import Ares.notis.NotificationManager;
import Ares.notis.NotificationType;
import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;

public class GuiIngameCosmetics2 extends GuiScreen {
   private int field_146444_f;
   public static String Shield = "off";
   public static int BlazeTexture;
   public static String Blaze;
   public static int HaloTexture;
   public static int Skin;
   public static String Halo;
   int k = 1;
   public static String Blazepath;
   public static String Susanoo;
   public static int SkinTexture;
   public static String Halopath;
   public static int ShieldTexture = 1;
   private int field_146445_a;
   public static int SusanooTexture;
   public static String Susanoopath;
   public static String Shieldpath;

   static {
      Shieldpath = "Shields/shield" + ShieldTexture + ".png";
      Skin = 0;
      SkinTexture = 1;
      Susanoo = "off";
      SusanooTexture = 1;
      Susanoopath = "Susanoo/Susanoo" + SusanooTexture + ".png";
      Halo = "off";
      HaloTexture = 1;
      Halopath = "Halo/halo" + HaloTexture + ".png";
      Blaze = "off";
      BlazeTexture = 1;
      Blazepath = "Blaze/blaze" + BlazeTexture + ".png";
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         CosmeticLoader.save();
         super.onGuiClosed();
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      Gui.drawRect(5, 30, width / 3 - 100, height - 200, (new Color(0, 0, 0, 90)).getRGB());
      super.drawScreen(var1, var2, var3);
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

   public void initGui() {
      byte var1 = 30;
      Client.getInstance().getDiscordRP().update("Changing Cosmetics", "ign: " + Minecraft.getMinecraft().getSession().getUsername(), "cosmetics");
      String var2 = Minecraft.getMinecraft().getSession().getUsername();
      DrawMenuLogo.drawString(1.0D, var2, (float)(width / 9 - this.fontRendererObj.getStringWidth(var2) + 200), (float)(height / 20 - 5), Color.white.getRGB());
      this.buttonList.add(new GuiButton(30, 10, 5 + var1, 80, 20, I18n.format("Shield", new Object[0])));
      this.buttonList.add(new GuiButton(0, 100, 5 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(1, 125, 5 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      byte var3 = 30;
      this.buttonList.add(new GuiButton(2, 10, var3 + var1, 20, 20, I18n.format("<<", new Object[0])));
      this.buttonList.add(new GuiButton(3, 65, var3 + var1, 20, 20, I18n.format(">>", new Object[0])));
      this.buttonList.add(new GuiButton(30, 10, 55 + var1, 80, 20, I18n.format("Susanoo", new Object[0])));
      this.buttonList.add(new GuiButton(5, 100, 55 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(6, 125, 55 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      boolean var4 = true;
      this.buttonList.add(new GuiButton(7, 10, 50 + var3 + var1, 20, 20, I18n.format("<<", new Object[0])));
      this.buttonList.add(new GuiButton(8, 65, 50 + var3 + var1, 20, 20, I18n.format(">>", new Object[0])));
      this.buttonList.add(new GuiButton(30, 10, 105 + var1, 80, 20, I18n.format("Halo", new Object[0])));
      this.buttonList.add(new GuiButton(9, 100, 105 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(10, 125, 105 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      boolean var5 = true;
      this.buttonList.add(new GuiButton(11, 10, 100 + var3 + var1, 20, 20, I18n.format("<<", new Object[0])));
      this.buttonList.add(new GuiButton(12, 65, 100 + var3 + var1, 20, 20, I18n.format(">>", new Object[0])));
      this.buttonList.add(new GuiButton(16, 10, 155 + var3 + var1 + 30, 100, 20, I18n.format(">", new Object[0])));
      this.buttonList.add(new GuiButton(17, 10, 155 + var3 + var1 + 60, 100, 20, I18n.format("<", new Object[0])));
      this.buttonList.add(new GuiButton(30, 10, 160 + var1, 80, 20, I18n.format("Blaze", new Object[0])));
      this.buttonList.add(new GuiButton(18, 100, 160 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(19, 125, 160 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      boolean var6 = true;
      this.buttonList.add(new GuiButton(20, 10, 155 + var3 + var1, 20, 20, I18n.format("<<", new Object[0])));
      this.buttonList.add(new GuiButton(21, 65, 155 + var3 + var1, 20, 20, I18n.format(">>", new Object[0])));
      this.buttonList.add(new GuiButton(33, 10, 155 + var3 + var1 + 90, 100, 20, I18n.format("F5", new Object[0])));
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 0) {
         Shield = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Shield", "Turned on", 1));
      }

      if (var1.id == 1) {
         Shield = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Shield", "Turned off", 1));
      }

      if (var1.id == 2) {
         if (ShieldTexture <= 1) {
            ShieldTexture = 9;
         } else {
            --ShieldTexture;
         }

         Shieldpath = "Shields/shield" + ShieldTexture + ".png";
      }

      if (var1.id == 3) {
         if (ShieldTexture >= 9) {
            ShieldTexture = 1;
         } else {
            ++ShieldTexture;
         }

         Shieldpath = "Shields/shield" + ShieldTexture + ".png";
      }

      if (var1.id == 5) {
         Susanoo = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Susanoo", "Turned on", 1));
      }

      if (var1.id == 6) {
         Susanoo = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Susanoo", "Turned off", 1));
      }

      if (var1.id == 7) {
         if (SusanooTexture <= 1) {
            SusanooTexture = 9;
         } else {
            --SusanooTexture;
         }

         Susanoopath = "Susanoo/Susanoo" + SusanooTexture + ".png";
      }

      if (var1.id == 8) {
         if (SusanooTexture >= 9) {
            SusanooTexture = 1;
         } else {
            ++SusanooTexture;
         }

         Susanoopath = "Susanoo/Susanoo" + SusanooTexture + ".png";
      }

      if (var1.id == 9) {
         Halo = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Halo", "Turned on", 1));
      }

      if (var1.id == 10) {
         Halo = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Halo", "Turned off", 1));
      }

      if (var1.id == 11) {
         if (HaloTexture <= 1) {
            HaloTexture = 9;
         } else {
            --HaloTexture;
         }

         Halopath = "Halo/halo" + HaloTexture + ".png";
      }

      if (var1.id == 12) {
         if (HaloTexture >= 9) {
            HaloTexture = 1;
         } else {
            ++HaloTexture;
         }

         Halopath = "Halo/halo" + HaloTexture + ".png";
      }

      if (var1.id == 18) {
         Blaze = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Blaze", "Turned on", 1));
      }

      if (var1.id == 19) {
         Blaze = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Blaze", "Turned on", 1));
      }

      if (var1.id == 20) {
         if (BlazeTexture <= 1) {
            BlazeTexture = 9;
         } else {
            --BlazeTexture;
         }

         Blazepath = "Blaze/blaze" + BlazeTexture + ".png";
      }

      if (var1.id == 21) {
         if (BlazeTexture >= 9) {
            BlazeTexture = 1;
         } else {
            ++BlazeTexture;
         }

         Blazepath = "Blaze/blaze" + BlazeTexture + ".png";
      }

      if (var1.id == 16) {
         this.mc.displayGuiScreen(new GuiIngameCosmetics3());
      }

      if (var1.id == 17) {
         this.mc.displayGuiScreen(new GuiIngameCosmetics());
      }

      if (var1.id == 33) {
         this.mc.gameSettings.thirdPersonView = 1;
      }

   }
}
