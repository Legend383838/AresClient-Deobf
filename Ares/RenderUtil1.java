package Ares;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public enum RenderUtil1 {
   instance;

   private static final RenderUtil1[] ENUM$VALUES = new RenderUtil1[]{instance};
   protected Minecraft mc = Minecraft.getMinecraft();

   public boolean isHovered(double var1, double var3, double var5, double var7, int var9, int var10) {
      return (double)var9 > var1 && (double)var10 > var3 && (double)var9 < var5 && (double)var10 < var7;
   }

   public void draw2DImage(ResourceLocation var1, int var2, int var3, int var4, int var5, Color var6) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f((float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha());
      this.mc.getTextureManager().bindTexture(var1);
      Gui.drawModalRectWithCustomSizedTexture(var2, var3, 0.0F, 0.0F, var4, var5, (float)var4, (float)var5);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
