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

public class GuiIngameCosmetics3 extends GuiScreen {
   public static int WitchHatTexture;
   public static int MaskTexture = 1;
   public static String Creeper;
   int k = 1;
   public static String Wither;
   public static String WitchHat;
   public static String MaskPath;
   public static String WitchHatPath;
   private int field_146445_a;
   public static String Mask = "off";
   private int field_146444_f;

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 0) {
         Mask = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Mask", "Turned on", 1));
      }

      if (var1.id == 1) {
         Mask = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Mask", "Turned off", 1));
      }

      if (var1.id == 2) {
         if (MaskTexture <= 1) {
            MaskTexture = 7;
         } else {
            --MaskTexture;
         }

         MaskPath = "Masks/mask" + MaskTexture + ".png";
      }

      if (var1.id == 3) {
         if (MaskTexture >= 7) {
            MaskTexture = 1;
         } else {
            ++MaskTexture;
         }

         MaskPath = "Masks/mask" + MaskTexture + ".png";
      }

      if (var1.id == 4) {
         Wither = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Wither", "Turned on", 1));
      }

      if (var1.id == 5) {
         Wither = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Wither", "Turned off", 1));
      }

      if (var1.id == 6) {
         Creeper = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Creeper", "Turned on", 1));
      }

      if (var1.id == 7) {
         Creeper = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Creeper", "Turned off", 1));
      }

      if (var1.id == 16) {
         this.mc.displayGuiScreen(new GuiIngameCosmetics());
      }

      if (var1.id == 17) {
         this.mc.displayGuiScreen(new GuiIngameCosmetics2());
      }

      if (var1.id == 18) {
         this.mc.gameSettings.thirdPersonView = 1;
      }

      if (var1.id == 8) {
         WitchHat = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic WitchHat", "Turned on", 1));
      }

      if (var1.id == 9) {
         WitchHat = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic WitchHat", "Turned off", 1));
      }

      if (var1.id == 10) {
         if (WitchHatTexture <= 1) {
            WitchHatTexture = 7;
         } else {
            --WitchHatTexture;
         }

         WitchHatPath = "witchhat/hat" + WitchHatTexture + ".png";
      }

      if (var1.id == 11) {
         if (WitchHatTexture >= 7) {
            WitchHatTexture = 1;
         } else {
            ++WitchHatTexture;
         }

         WitchHatPath = "witchhat/hat" + WitchHatTexture + ".png";
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      Gui.drawRect(5, 30, width / 3 - 100, height - 200, (new Color(0, 0, 0, 90)).getRGB());
      super.drawScreen(var1, var2, var3);
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
      this.buttonList.add(new GuiButton(30, 10, 5 + var1, 80, 20, I18n.format("Mask", new Object[0])));
      this.buttonList.add(new GuiButton(0, 100, 5 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(1, 125, 5 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      byte var3 = 30;
      this.buttonList.add(new GuiButton(2, 10, var3 + var1, 20, 20, I18n.format("<<", new Object[0])));
      this.buttonList.add(new GuiButton(3, 65, var3 + var1, 20, 20, I18n.format(">>", new Object[0])));
      this.buttonList.add(new GuiButton(30, 10, 55 + var1, 80, 20, I18n.format("Whither", new Object[0])));
      this.buttonList.add(new GuiButton(4, 100, 55 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(5, 125, 55 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(30, 10, 105 + var1, 80, 20, I18n.format("Creeper", new Object[0])));
      this.buttonList.add(new GuiButton(6, 100, 105 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(7, 125, 105 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(30, 10, 155 + var1, 80, 20, I18n.format("WitchHat", new Object[0])));
      this.buttonList.add(new GuiButton(8, 100, 155 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(9, 125, 155 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(10, 10, 155 + var3 + var1, 20, 20, I18n.format("<<", new Object[0])));
      this.buttonList.add(new GuiButton(11, 65, 155 + var3 + var1, 20, 20, I18n.format(">>", new Object[0])));
      this.buttonList.add(new GuiButton(16, 10, 155 + var3 + var1 + 30, 100, 20, I18n.format(">", new Object[0])));
      this.buttonList.add(new GuiButton(17, 10, 155 + var3 + var1 + 60, 100, 20, I18n.format("<", new Object[0])));
      this.buttonList.add(new GuiButton(18, 10, 155 + var3 + var1 + 90, 100, 20, I18n.format("F5", new Object[0])));
   }

   static {
      MaskPath = "Masks/mask" + MaskTexture + ".png";
      Wither = "off";
      Creeper = "off";
      WitchHat = "off";
      WitchHatTexture = 1;
      WitchHatPath = "witchhat/hat" + WitchHatTexture + ".png";
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         CosmeticLoader.save();
         super.onGuiClosed();
      }

   }
}
