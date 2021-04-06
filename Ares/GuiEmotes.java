package Ares;

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
import net.minecraft.entity.EntityLivingBase;

public class GuiEmotes extends GuiScreen {
   private int field_146444_f;
   public static int Arrow = 1;
   int k = 1;
   public static int Emote = 1;
   private int field_146445_a;

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
      String var2 = Minecraft.getMinecraft().getSession().getUsername();
      DrawMenuLogo.drawString(1.0D, var2, (float)(width / 9 - this.fontRendererObj.getStringWidth(var2) + 200), (float)(height / 20 - 5), Color.white.getRGB());
      this.buttonList.add(new GuiButton(1, 5, 5 + var1, 80, 20, I18n.format("Dab", new Object[0])));
      this.buttonList.add(new GuiButton(2, 5, 30 + var1, 80, 20, I18n.format("T-Pose?", new Object[0])));
      this.buttonList.add(new GuiButton(3, 5, 55 + var1, 80, 20, I18n.format("Zombie", new Object[0])));
      this.buttonList.add(new GuiButton(4, 5, 80 + var1, 80, 20, I18n.format("Sit", new Object[0])));
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      int var10000 = var1.id;
      if (var1.id == 1) {
         Emote = 1;
         Arrow = 1;
      }

      if (var1.id == 2) {
         Emote = 2;
         Arrow = 2;
      }

      if (var1.id == 3) {
         Emote = 3;
         Arrow = 3;
      }

      if (var1.id == 4) {
         Emote = 4;
         Arrow = 4;
      }

      if (var1.id == 5) {
         Emote = 5;
         Arrow = 5;
      }

   }

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawCenteredString(this.fontRendererObj, I18n.format("Select your Emote", new Object[0]), width / 2, height / 2 + 150, 16777215);
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

      super.drawScreen(var1, var2, var3);
   }
}
