package Ares;

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
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class GuiHitBox extends GuiScreen {
   int k = 1;
   public static String onoff = "off";
   public static int blue = 255;
   public static String SimpleMode = "off";
   public static int red = 255;
   public static int green = 255;
   private int field_146444_f;
   private int field_146445_a;

   public void drawScreen(int var1, int var2, float var3) {
      drawEntityOnScreen(width / 2, height / 2 + 150, 75, 0.0F, 0.0F, this.mc.thePlayer);
      super.drawScreen(var1, var2, var3);
   }

   public void initGui() {
      byte var1 = 30;
      String var2 = Minecraft.getMinecraft().getSession().getUsername();
      DrawMenuLogo.drawString(1.0D, var2, (float)(width / 9 - this.fontRendererObj.getStringWidth(var2) + 200), (float)(height / 20 - 5), Color.white.getRGB());
      this.buttonList.add(new GuiButton(0, 5, 5 + var1, 80, 20, I18n.format("Simple Mode", new Object[0])));
      this.buttonList.add(new GuiButton(3, 95, 5 + var1, 20, 20, I18n.format("on", new Object[0])));
      this.buttonList.add(new GuiButton(4, 125, 5 + var1, 20, 20, I18n.format("off", new Object[0])));
      this.buttonList.add(new GuiButton(0, 5, 30 + var1, 80, 20, I18n.format("Red", new Object[0])));
      this.buttonList.add(new GuiButton(5, 95, 30 + var1, 20, 20, I18n.format("-", new Object[0])));
      this.buttonList.add(new GuiButton(6, 125, 30 + var1, 20, 20, I18n.format("+", new Object[0])));
      this.buttonList.add(new GuiButton(0, 5, 55 + var1, 80, 20, I18n.format("Blue", new Object[0])));
      this.buttonList.add(new GuiButton(7, 95, 55 + var1, 20, 20, I18n.format("-", new Object[0])));
      this.buttonList.add(new GuiButton(8, 125, 55 + var1, 20, 20, I18n.format("+", new Object[0])));
      this.buttonList.add(new GuiButton(0, 5, 80 + var1, 80, 20, I18n.format("Green", new Object[0])));
      this.buttonList.add(new GuiButton(9, 95, 80 + var1, 20, 20, I18n.format("-", new Object[0])));
      this.buttonList.add(new GuiButton(10, 125, 80 + var1, 20, 20, I18n.format("+", new Object[0])));
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      int var10000 = var1.id;
      var10000 = var1.id;
      if (var1.id == 3) {
         SimpleMode = "on";
      }

      if (var1.id == 4) {
         SimpleMode = "off";
      }

      if (var1.id == 5) {
         red -= 10;
      }

      if (var1.id == 6) {
         red += 10;
      }

      if (var1.id == 7) {
         blue -= 10;
      }

      if (var1.id == 8) {
         blue += 10;
      }

      if (var1.id == 9) {
         green -= 10;
      }

      if (var1.id == 10) {
         green += 10;
      }

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

         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

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