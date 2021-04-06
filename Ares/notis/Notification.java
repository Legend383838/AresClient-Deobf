package Ares.notis;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class Notification {
   private long start;
   private String title;
   private long fadeOut;
   private NotificationType type;
   private long fadedIn;
   private long end;
   private String messsage;

   public boolean isShown() {
      return this.getTime() <= this.end;
   }

   public void render() {
      double var1 = 0.0D;
      byte var3 = 120;
      byte var4 = 30;
      long var5 = this.getTime();
      if (var5 < this.fadedIn) {
         var1 = Math.tanh((double)var5 / (double)this.fadedIn * 3.0D) * (double)var3;
      } else if (var5 > this.fadeOut) {
         var1 = Math.tanh(3.0D - (double)(var5 - this.fadeOut) / (double)(this.end - this.fadeOut) * 3.0D) * (double)var3;
      } else {
         var1 = (double)var3;
      }

      Color var7 = new Color(0, 0, 0, 220);
      Color var8;
      if (this.type == NotificationType.INFO) {
         var8 = new Color(this.getRainbow(6000, -15));
      } else if (this.type == NotificationType.WARNING) {
         var8 = new Color(204, 193, 0);
      } else {
         var8 = new Color(204, 0, 18);
         int var9 = Math.max(0, Math.min(255, (int)(Math.sin((double)var5 / 100.0D) * 255.0D / 2.0D + 127.5D)));
         var7 = new Color(var9, 0, 0, 220);
      }

      FontRenderer var10 = Minecraft.getMinecraft().fontRendererObj;
      drawRect((double)GuiScreen.width - var1, (double)(GuiScreen.height - 5 - var4), (double)GuiScreen.width, (double)(GuiScreen.height - 5), var7.getRGB());
      drawRect((double)GuiScreen.width - var1, (double)(GuiScreen.height - 5 - var4), (double)GuiScreen.width - var1 + 4.0D, (double)(GuiScreen.height - 5), var8.getRGB());
      var10.drawString(this.title, (int)((double)GuiScreen.width - var1 + 8.0D), GuiScreen.height - 2 - var4, this.getRainbow(6000, -15));
      var10.drawString(this.messsage, (int)((double)GuiScreen.width - var1 + 8.0D), GuiScreen.height - 15, -1);
   }

   private int getRainbow(int var1, int var2) {
      float var3 = (float)((System.currentTimeMillis() + (long)var2) % (long)var1);
      var3 /= (float)var1;
      return Color.getHSBColor(var3, 1.0F, 1.0F).getRGB();
   }

   public Notification(NotificationType var1, String var2, String var3, int var4) {
      this.type = var1;
      this.title = var2;
      this.messsage = var3;
      this.fadedIn = (long)(200 * var4);
      this.fadeOut = this.fadedIn + (long)(500 * var4);
      this.end = this.fadeOut + this.fadedIn;
   }

   public static void drawRect(double var0, double var2, double var4, double var6, int var8) {
      double var9;
      if (var0 < var4) {
         var9 = var0;
         var0 = var4;
         var4 = var9;
      }

      if (var2 < var6) {
         var9 = var2;
         var2 = var6;
         var6 = var9;
      }

      float var15 = (float)(var8 >> 24 & 255) / 255.0F;
      float var10 = (float)(var8 >> 16 & 255) / 255.0F;
      float var11 = (float)(var8 >> 8 & 255) / 255.0F;
      float var12 = (float)(var8 & 255) / 255.0F;
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var10, var11, var12, var15);
      var14.begin(7, DefaultVertexFormats.POSITION);
      var14.pos(var0, var6, 0.0D).endVertex();
      var14.pos(var4, var6, 0.0D).endVertex();
      var14.pos(var4, var2, 0.0D).endVertex();
      var14.pos(var0, var2, 0.0D).endVertex();
      var13.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public void show() {
      this.start = System.currentTimeMillis();
   }

   private long getTime() {
      return System.currentTimeMillis() - this.start;
   }

   public static void drawRect(int var0, double var1, double var3, double var5, double var7, int var9) {
      double var10;
      if (var1 < var5) {
         var10 = var1;
         var1 = var5;
         var5 = var10;
      }

      if (var3 < var7) {
         var10 = var3;
         var3 = var7;
         var7 = var10;
      }

      float var16 = (float)(var9 >> 24 & 255) / 255.0F;
      float var11 = (float)(var9 >> 16 & 255) / 255.0F;
      float var12 = (float)(var9 >> 8 & 255) / 255.0F;
      float var13 = (float)(var9 & 255) / 255.0F;
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var11, var12, var13, var16);
      var15.begin(var0, DefaultVertexFormats.POSITION);
      var15.pos(var1, var7, 0.0D).endVertex();
      var15.pos(var5, var7, 0.0D).endVertex();
      var15.pos(var5, var3, 0.0D).endVertex();
      var15.pos(var1, var3, 0.0D).endVertex();
      var14.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }
}
