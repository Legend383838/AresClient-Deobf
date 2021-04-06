package Ares;

import Ares.CustomCapes.CosmeticLoaderURL;
import Ares.CustomCapes.GuiIngameCustomCape;
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;

public class GuiAnimatedCapes extends GuiScreen {
   public static String CapeFolder = "dance";
   public static int MaxFrames = 1;
   public static String Capeonoff = "off";
   public static int Frames = 1;
   private int field_146445_a;
   int k = 1;
   private int field_146444_f;

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 1) {
         Capeonoff = "on";
         GuiIngameCustomCape.CustomCape = "off";
      }

      if (var1.id == 2) {
         Capeonoff = "off";
      }

      if (var1.id == 3) {
         CapeFolder = "dance";
         MaxFrames = 11;
      }

      if (var1.id == 4) {
         CapeFolder = "sad";
         MaxFrames = 32;
      }

      if (var1.id == 5) {
         CapeFolder = "bubble";
         MaxFrames = 50;
      }

      if (var1.id == 6) {
         CapeFolder = "cat";
         MaxFrames = 11;
      }

      if (var1.id == 7) {
         CapeFolder = "skull";
         MaxFrames = 31;
      }

      if (var1.id == 8) {
         CapeFolder = "street";
         MaxFrames = 29;
      }

      if (var1.id == 9) {
         CapeFolder = "vapor";
         MaxFrames = 32;
      }

      if (var1.id == 10) {
         CapeFolder = "kaktus";
         MaxFrames = 8;
      }

      if (var1.id == 11) {
         CapeFolder = "hand";
         MaxFrames = 27;
      }

      if (var1.id == 12) {
         CapeFolder = "worm";
         MaxFrames = 28;
      }

      if (var1.id == 13) {
         CapeFolder = "uwu";
         MaxFrames = 14;
      }

      if (var1.id == 14) {
         CapeFolder = "doggo";
         MaxFrames = 12;
      }

      if (var1.id == 15) {
         CapeFolder = "uno";
         MaxFrames = 28;
      }

      if (var1.id == 16) {
         CapeFolder = "speeddoggo";
         MaxFrames = 23;
      }

      if (var1.id == 17) {
         CapeFolder = "blob";
         MaxFrames = 10;
      }

      if (var1.id == 18) {
         CapeFolder = "loop";
         MaxFrames = 18;
      }

      if (var1.id == 19) {
         CapeFolder = "flash";
         MaxFrames = 24;
      }

      if (var1.id == 20) {
         CapeFolder = "nyan";
         MaxFrames = 6;
      }

      if (var1.id == 21) {
         CapeFolder = "kirby";
         MaxFrames = 20;
      }

   }

   public void initGui() {
      byte var1 = 30;
      String var2 = Minecraft.getMinecraft().getSession().getUsername();
      DrawMenuLogo.drawString(1.0D, var2, (float)(width / 9 - this.fontRendererObj.getStringWidth(var2) + 200), (float)(height / 20 - 5), Color.white.getRGB());
      this.buttonList.add(new GuiButton(1, 5, 230 + var1, 40, 20, I18n.format("on", new Object[0])));
      this.buttonList.add(new GuiButton(2, 55, 230 + var1, 40, 20, I18n.format("off", new Object[0])));
      this.buttonList.add(new GuiButton(3, 5, 5 + var1, 80, 20, I18n.format("Carameldansen", new Object[0])));
      this.buttonList.add(new GuiButton(4, 5, 30 + var1, 80, 20, I18n.format("Broken", new Object[0])));
      this.buttonList.add(new GuiButton(5, 5, 55 + var1, 80, 20, I18n.format("Bubble", new Object[0])));
      this.buttonList.add(new GuiButton(6, 5, 80 + var1, 80, 20, I18n.format("Cat", new Object[0])));
      this.buttonList.add(new GuiButton(7, 5, 105 + var1, 80, 20, I18n.format("Skull", new Object[0])));
      this.buttonList.add(new GuiButton(8, 5, 130 + var1, 80, 20, I18n.format("Street", new Object[0])));
      this.buttonList.add(new GuiButton(9, 5, 155 + var1, 80, 20, I18n.format("White", new Object[0])));
      this.buttonList.add(new GuiButton(10, 5, 180 + var1, 80, 20, I18n.format("Cactus", new Object[0])));
      this.buttonList.add(new GuiButton(11, 5, 205 + var1, 80, 20, I18n.format("Hand", new Object[0])));
      this.buttonList.add(new GuiButton(12, 90, 5 + var1, 80, 20, I18n.format("Worm", new Object[0])));
      this.buttonList.add(new GuiButton(13, 90, 30 + var1, 80, 20, I18n.format("Uwu Cat", new Object[0])));
      this.buttonList.add(new GuiButton(14, 90, 55 + var1, 80, 20, I18n.format("Doggo", new Object[0])));
      this.buttonList.add(new GuiButton(15, 90, 80 + var1, 80, 20, I18n.format("Uno", new Object[0])));
      this.buttonList.add(new GuiButton(16, 90, 105 + var1, 80, 20, I18n.format("Speed Doggo", new Object[0])));
      this.buttonList.add(new GuiButton(17, 90, 130 + var1, 80, 20, I18n.format("Party Blob", new Object[0])));
      this.buttonList.add(new GuiButton(18, 90, 155 + var1, 80, 20, I18n.format("8", new Object[0])));
      this.buttonList.add(new GuiButton(19, 90, 180 + var1, 80, 20, I18n.format("Lightning", new Object[0])));
      this.buttonList.add(new GuiButton(20, 90, 205 + var1, 80, 20, I18n.format("Nyan Cat", new Object[0])));
      this.buttonList.add(new GuiButton(21, 184, 5 + var1, 80, 20, I18n.format("Kirby", new Object[0])));
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

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         FileWriter var1;
         try {
            var1 = new FileWriter("AresFolder/CapeFolder.txt");
            var1.write(CapeFolder);
            var1.close();
            FileWriter var2 = new FileWriter("AresFolder/AnimatedCapeonoff.txt");
            var2.write(Capeonoff);
            var2.close();
            System.out.println("Successfully wrote to the file.");
         } catch (IOException var4) {
            System.out.println("An error occurred.");
            var4.printStackTrace();
         }

         try {
            CosmeticLoaderURL.SaveURl();
            var1 = new FileWriter("AresFolder/CustomCapeonoff.txt");
            var1.write(GuiIngameCustomCape.CustomCape);
            var1.close();
         } catch (IOException var3) {
         }

         super.onGuiClosed();
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      super.drawScreen(var1, var2, var3);
   }
}
