package Ares;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public class DrawMenuLogo {
   public static void drawString(double var0, String var2, float var3, float var4, int var5) {
      GlStateManager.pushMatrix();
      GlStateManager.scale(var0, var0, var0);
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(var2, var3, var4, var5);
      GlStateManager.popMatrix();
   }
}
