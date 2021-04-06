package Ares;

import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class ChromaRect {
   public static void drawRect(int var0, int var1, int var2, int var3) {
      int var4;
      if (var0 < var2) {
         var4 = var0;
         var0 = var2;
         var2 = var4;
      }

      if (var1 < var3) {
         var4 = var1;
         var1 = var3;
         var3 = var4;
      }

      float var10 = (float)(color() >> 24 & 255) / 255.0F;
      float var5 = (float)(color() >> 16 & 255) / 255.0F;
      float var6 = (float)(color() >> 8 & 255) / 255.0F;
      float var7 = (float)(color() & 255) / 255.0F;
      Tessellator var8 = Tessellator.getInstance();
      WorldRenderer var9 = var8.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var5, var6, var7, var10);
      var9.begin(7, DefaultVertexFormats.POSITION);
      var9.pos((double)var0, (double)var3, 0.0D).endVertex();
      var9.pos((double)var2, (double)var3, 0.0D).endVertex();
      var9.pos((double)var2, (double)var1, 0.0D).endVertex();
      var9.pos((double)var0, (double)var1, 0.0D).endVertex();
      var8.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static int color() {
      long var0 = System.currentTimeMillis();
      int var2 = Color.HSBtoRGB((float)(var0 % 5000L) / 10000.0F, 0.8F, 0.7F);
      return var2;
   }
}
