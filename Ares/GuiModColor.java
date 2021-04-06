package Ares;

import Ares.fakeutils.FakePlayer;
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
import net.minecraft.world.World;

public class GuiModColor extends GuiScreen {
   public static int CapeNumber = 5;
   public static int Arrow = 1;
   private int field_146445_a;
   private int field_146444_f;
   int k = 1;
   private World world;
   private FakePlayer player;
   float rotate = 0.0F;
   public static String SkinFolder = "HDSkins";
   int s = 2;

   public void drawScreen(int var1, int var2, float var3) {
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

      super.drawScreen(var1, var2, var3);
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

   public void initGui() {
      byte var1 = 30;
      String var2 = Minecraft.getMinecraft().getSession().getUsername();
      DrawMenuLogo.drawString(1.0D, var2, (float)(width / 9 - this.fontRendererObj.getStringWidth(var2) + 200), (float)(height / 20 - 5), Color.white.getRGB());
      this.buttonList.add(new GuiButton(3, 5, 5 + var1, 80, 20, I18n.format("§fWhite", new Object[0])));
      this.buttonList.add(new GuiButton(4, 5, 30 + var1, 80, 20, I18n.format("§eYellow", new Object[0])));
      this.buttonList.add(new GuiButton(5, 5, 55 + var1, 80, 20, I18n.format("§dMagenta", new Object[0])));
      this.buttonList.add(new GuiButton(6, 5, 80 + var1, 80, 20, I18n.format("§cRed", new Object[0])));
      this.buttonList.add(new GuiButton(7, 5, 105 + var1, 80, 20, I18n.format("§bTurquoise", new Object[0])));
      this.buttonList.add(new GuiButton(8, 5, 130 + var1, 80, 20, I18n.format("§aGreen", new Object[0])));
      this.buttonList.add(new GuiButton(9, 5, 155 + var1, 80, 20, I18n.format("§9Blue", new Object[0])));
      this.buttonList.add(new GuiButton(10, 5, 180 + var1, 80, 20, I18n.format("§0Black", new Object[0])));
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
   }

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      int var10000 = var1.id;
      if (var1.id == 1) {
         if (CapeNumber >= 2) {
            --CapeNumber;
         } else {
            CapeNumber = 1;
         }
      }

      if (var1.id == 2) {
         if (CapeNumber <= 9) {
            ++CapeNumber;
         } else {
            CapeNumber = 10;
         }
      }

      if (var1.id == 3) {
         GuiIngameSettings.ModColor = "§f";
         Arrow = 1;
      }

      if (var1.id == 4) {
         GuiIngameSettings.ModColor = "§e";
         Arrow = 2;
      }

      if (var1.id == 5) {
         GuiIngameSettings.ModColor = "§d";
         Arrow = 3;
      }

      if (var1.id == 6) {
         GuiIngameSettings.ModColor = "§c";
         Arrow = 4;
      }

      if (var1.id == 7) {
         GuiIngameSettings.ModColor = "§b";
         Arrow = 5;
      }

      if (var1.id == 8) {
         GuiIngameSettings.ModColor = "§a";
         Arrow = 6;
      }

      if (var1.id == 9) {
         GuiIngameSettings.ModColor = "§9";
         Arrow = 7;
      }

      if (var1.id == 10) {
         GuiIngameSettings.ModColor = "§0";
         Arrow = 8;
      }

      if (var1.id == 16) {
         this.mc.displayGuiScreen(new GuiIngameCosmetics());
      }

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
