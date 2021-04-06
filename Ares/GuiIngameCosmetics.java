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
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

public class GuiIngameCosmetics extends GuiScreen {
   public static String Bandanapath;
   private int field_146445_a;
   public static int HatTexture;
   public static String Ears;
   private int field_146444_f;
   public static int WingsTexture;
   public static String Hatpath;
   public static String Wingsonoff;
   public static String Earspath;
   public static int BandanaTexture = 1;
   public static int EarsTexture;
   int k = 1;
   public static String Wingspath;
   public static String Hatonoff;
   public static String Bandanaonoff = "off";

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
      this.buttonList.add(new GuiButton(30, 10, 5 + var1, 80, 20, I18n.format("Wings", new Object[0])));
      this.buttonList.add(new GuiButton(0, 100, 5 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(1, 125, 5 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      byte var3 = 30;
      this.buttonList.add(new GuiButton(2, 10, var3 + var1, 20, 20, I18n.format("<<", new Object[0])));
      this.buttonList.add(new GuiButton(3, 65, var3 + var1, 20, 20, I18n.format(">>", new Object[0])));
      this.buttonList.add(new GuiButton(30, 10, 55 + var1, 80, 20, I18n.format("Bandana", new Object[0])));
      this.buttonList.add(new GuiButton(4, 100, 55 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(5, 125, 55 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      boolean var4 = true;
      this.buttonList.add(new GuiButton(6, 10, 50 + var3 + var1, 20, 20, I18n.format("<<", new Object[0])));
      this.buttonList.add(new GuiButton(7, 65, 50 + var3 + var1, 20, 20, I18n.format(">>", new Object[0])));
      this.buttonList.add(new GuiButton(30, 10, 105 + var1, 80, 20, I18n.format("Hat", new Object[0])));
      this.buttonList.add(new GuiButton(8, 100, 105 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(9, 125, 105 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      boolean var5 = true;
      this.buttonList.add(new GuiButton(10, 10, 100 + var3 + var1, 20, 20, I18n.format("<<", new Object[0])));
      this.buttonList.add(new GuiButton(11, 65, 100 + var3 + var1, 20, 20, I18n.format(">>", new Object[0])));
      this.buttonList.add(new GuiButton(30, 10, 160 + var1, 80, 20, I18n.format("Ears", new Object[0])));
      this.buttonList.add(new GuiButton(12, 100, 160 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(13, 125, 160 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      boolean var6 = true;
      this.buttonList.add(new GuiButton(14, 10, 155 + var3 + var1, 20, 20, I18n.format("<<", new Object[0])));
      this.buttonList.add(new GuiButton(15, 65, 155 + var3 + var1, 20, 20, I18n.format(">>", new Object[0])));
      this.buttonList.add(new GuiButton(16, 10, 155 + var3 + var1 + 30, 100, 20, I18n.format(">", new Object[0])));
      this.buttonList.add(new GuiButton(17, 10, 155 + var3 + var1 + 60, 100, 20, I18n.format("<", new Object[0])));
      this.buttonList.add(new GuiButton(18, 10, 155 + var3 + var1 + 90, 100, 20, I18n.format("F5", new Object[0])));
   }

   private void drawRoundedRect(int var1, int var2, int var3, int var4, int var5, Color var6) {
      Gui.drawRect(var1, var2 + var5, var1 + var5, var2 + var4 - var5, var6.getRGB());
      Gui.drawRect(var1 + var5, var2, var1 + var3 - var5, var2 + var4, var6.getRGB());
      Gui.drawRect(var1 + var3 - var5, var2 + var5, var1 + var3, var2 + var4 - var5, var6.getRGB());
      this.drawArc(var1 + var5, var2 + var5, var5, 0, 90, var6);
      this.drawArc(var1 + var3 - var5, var2 + var5, var5, 270, 360, var6);
      this.drawArc(var1 + var3 - var5, var2 + var4 - var5, var5, 180, 270, var6);
      this.drawArc(var1 + var5, var2 + var4 - var5, var5, 90, 180, var6);
   }

   public void drawScreen(int var1, int var2, float var3) {
      Gui.drawRect(5, 30, width / 3 - 100, height - 200, (new Color(0, 0, 0, 90)).getRGB());
      super.drawScreen(var1, var2, var3);
   }

   static {
      Bandanapath = "bandanas/bandana" + BandanaTexture + ".png";
      Hatonoff = "off";
      HatTexture = 1;
      Hatpath = "Hats/hat" + HatTexture + ".png";
      Ears = "off";
      EarsTexture = 1;
      Earspath = "Ears/ears" + EarsTexture + ".png";
      Wingsonoff = "off";
      WingsTexture = 1;
      Wingspath = "Wings/wings" + WingsTexture + ".png";
   }

   private void drawArc(int var1, int var2, int var3, int var4, int var5, Color var6) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f((float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha() / 255.0F);
      WorldRenderer var7 = Tessellator.getInstance().getWorldRenderer();
      var7.begin(6, DefaultVertexFormats.POSITION);
      var7.pos((double)var1, (double)var2, 0.0D).endVertex();

      for(int var8 = (int)((double)var4 / 360.0D * 100.0D); var8 <= (int)((double)var5 / 360.0D * 100.0D); ++var8) {
         double var9 = 6.283185307179586D * (double)var8 / 100.0D + Math.toRadians(180.0D);
         var7.pos((double)var1 + Math.sin(var9) * (double)var3, (double)var2 + Math.cos(var9) * (double)var3, 0.0D).endVertex();
      }

      Tessellator.getInstance().draw();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         CosmeticLoader.save();
         super.onGuiClosed();
      }

   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 0) {
         Wingsonoff = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Wings", "Turned on", 1));
      }

      if (var1.id == 1) {
         Wingsonoff = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Wings", "Turned off", 1));
      }

      if (var1.id == 2) {
         if (WingsTexture <= 1) {
            WingsTexture = 17;
         } else {
            --WingsTexture;
         }

         Wingspath = "Wings/wings" + WingsTexture + ".png";
      }

      if (var1.id == 3) {
         if (WingsTexture >= 17) {
            WingsTexture = 1;
         } else {
            ++WingsTexture;
         }

         Wingspath = "Wings/wings" + WingsTexture + ".png";
      }

      if (var1.id == 4) {
         Bandanaonoff = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Bandana", "Turned on", 1));
      }

      if (var1.id == 5) {
         Bandanaonoff = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Bandana", "Turned off", 1));
      }

      if (var1.id == 6) {
         if (BandanaTexture <= 1) {
            BandanaTexture = 13;
         } else {
            --BandanaTexture;
         }

         Bandanapath = "bandanas/bandana" + BandanaTexture + ".png";
      }

      if (var1.id == 7) {
         if (BandanaTexture >= 13) {
            BandanaTexture = 1;
         } else {
            ++BandanaTexture;
         }

         Bandanapath = "bandanas/bandana" + BandanaTexture + ".png";
      }

      if (var1.id == 8) {
         Hatonoff = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Hat", "Turned on", 1));
      }

      if (var1.id == 9) {
         Hatonoff = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Hat", "Turned off", 1));
      }

      if (var1.id == 10) {
         if (HatTexture <= 1) {
            HatTexture = 7;
         } else {
            --HatTexture;
         }

         Hatpath = "Hats/hat" + HatTexture + ".png";
      }

      if (var1.id == 11) {
         if (HatTexture >= 7) {
            HatTexture = 1;
         } else {
            ++HatTexture;
         }

         Hatpath = "Hats/hat" + HatTexture + ".png";
      }

      if (var1.id == 12) {
         Ears = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Ears", "Turned on", 1));
      }

      if (var1.id == 13) {
         Ears = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Cosmetic Ears", "Turned off", 1));
      }

      if (var1.id == 14) {
         if (EarsTexture <= 1) {
            EarsTexture = 4;
         } else {
            --EarsTexture;
         }

         Earspath = "Ears/ears" + EarsTexture + ".png";
      }

      if (var1.id == 15) {
         if (EarsTexture >= 4) {
            EarsTexture = 1;
         } else {
            ++EarsTexture;
         }

         Earspath = "Ears/ears" + EarsTexture + ".png";
      }

      if (var1.id == 16) {
         this.mc.displayGuiScreen(new GuiIngameCosmetics2());
      }

      if (var1.id == 17) {
         this.mc.displayGuiScreen(new GuiIngameCosmetics3());
      }

      if (var1.id == 18) {
         this.mc.gameSettings.thirdPersonView = 1;
      }

   }
}
