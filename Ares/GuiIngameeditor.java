package Ares;

import Ares.radio.Radio;
import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class GuiIngameeditor extends GuiScreen {
   int s = 10;
   public static String Chat = "on";
   int k = 1;
   public static int Admin = 0;
   public static String Scoreboard = "on";
   public static Radio radio = new Radio();
   public static String Style = "1";
   private int field_146444_f;
   public static String ScoreboardBG = "on";
   public static String NewHotbar = "off";
   public static String ChatBG = "on";
   private int field_146445_a;

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 2) {
         Chat = "on";
      }

      if (var1.id == 3) {
         Chat = "off";
      }

      if (var1.id == 4) {
         Scoreboard = "on";
      }

      if (var1.id == 5) {
         Scoreboard = "off";
      }

      if (var1.id == 6) {
         Style = "1";
      }

      if (var1.id == 7) {
         Style = "2";
      }

      if (var1.id == 8) {
         Style = "3";
      }

      if (var1.id == 9) {
         ChatBG = "on";
      }

      if (var1.id == 10) {
         ChatBG = "off";
      }

      if (var1.id == 11) {
         ScoreboardBG = "on";
      }

      if (var1.id == 12) {
         ScoreboardBG = "off";
      }

      int var10000 = var1.id;
   }

   public void initGui() {
      byte var1 = 90;
      String var2 = Minecraft.getMinecraft().getSession().getUsername();
      DrawMenuLogo.drawString(1.0D, var2, (float)(width / 9 - this.fontRendererObj.getStringWidth(var2) + 200), (float)(height / 20 - 5), Color.white.getRGB());
      byte var3 = 5;
      this.buttonList.add(new GuiButton(30, var3, 5 + var1, 80, 20, I18n.format("Chat", new Object[0])));
      this.buttonList.add(new GuiButton(2, var3 + 90, 5 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(3, var3 + 90 + 25, 5 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(40, var3, 30 + var1, 80, 20, I18n.format("Scoreboard", new Object[0])));
      this.buttonList.add(new GuiButton(4, var3 + 90, 30 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(5, 120, 30 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, var3, 55 + var1, 80, 20, I18n.format("Logo", new Object[0])));
      this.buttonList.add(new GuiButton(6, var3 + 90, 55 + var1, 20, 20, I18n.format("1", new Object[0])));
      this.buttonList.add(new GuiButton(7, var3 + 90 + 25, 55 + var1, 20, 20, I18n.format("2", new Object[0])));
      this.buttonList.add(new GuiButton(8, var3 + 90 + 50, 55 + var1, 20, 20, I18n.format("2", new Object[0])));
      this.buttonList.add(new GuiButton(40, var3, 80 + var1, 80, 20, I18n.format("Chat BG", new Object[0])));
      this.buttonList.add(new GuiButton(9, var3 + 90, 80 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(10, 120, 80 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(40, var3, 105 + var1, 80, 20, I18n.format("Scoreboard BG", new Object[0])));
      this.buttonList.add(new GuiButton(11, var3 + 90, 105 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(12, 120, 105 + var1, 20, 20, I18n.format("§coff", new Object[0])));
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

   public void setBlockOverlay(int var1, String var2, int var3) {
   }

   public void drawScreen(int var1, int var2, float var3) {
      if (Style.contains("2")) {
         GuiHelper.drawPicture(0, 0, 80, 40, "aresschrift.png");
      }

      if (Style.contains("1")) {
         GuiHelper.drawPicture(5, 5, 28, 25, "icon.png");
      }

      super.drawScreen(var1, var2, var3);
      if (Style.contains("3")) {
         RotateLogo.drawRotatingScaledLogo(30.0F, 30.0F, 50);
      }

   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

   }
}
