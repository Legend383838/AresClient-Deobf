package Ares;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RotateLogo {
   public static void drawTexture(ResourceLocation var0, float var1, float var2, float var3, float var4) {
      GL11.glPushMatrix();
      float var5 = var3 / 2.0F;
      GL11.glEnable(3042);
      GL11.glEnable(3553);
      GL11.glEnable(2848);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      bindTexture(var0);
      GL11.glBegin(7);
      GL11.glTexCoord2d((double)(0.0F / var5), (double)(0.0F / var5));
      GL11.glVertex2d((double)var1, (double)var2);
      GL11.glTexCoord2d((double)(0.0F / var5), (double)((0.0F + var5) / var5));
      GL11.glVertex2d((double)var1, (double)(var2 + var4));
      GL11.glTexCoord2d((double)((0.0F + var5) / var5), (double)((0.0F + var5) / var5));
      GL11.glVertex2d((double)(var1 + var3), (double)(var2 + var4));
      GL11.glTexCoord2d((double)((0.0F + var5) / var5), (double)(0.0F / var5));
      GL11.glVertex2d((double)(var1 + var3), (double)var2);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void drawRotatingScaledLogo(float var0, float var1, int var2) {
      GL11.glPushMatrix();
      GL11.glTranslatef(var0, var1, 0.0F);
      double var3 = 0.3D;
      double var5 = Math.cos((double)System.currentTimeMillis() / 180.0D * 0.3D % 360.0D) * 90.0D + 90.0D;
      GL11.glRotatef((float)var5, 0.0F, 0.0F, 1.0F);
      drawTexture(new ResourceLocation("Ares/logo_255_outer.png"), (float)(-var2) / 2.0F, (float)(-var2) / 2.0F, (float)var2, (float)var2);
      GL11.glPopMatrix();
      drawTexture(new ResourceLocation("Ares/logo_108_inner.png"), var0 - (float)var2 / 2.0F, var1 - (float)var2 / 2.0F, (float)var2, (float)var2);
   }

   public static void bindTexture(ResourceLocation var0) {
      Object var1 = Minecraft.getMinecraft().getTextureManager().getTexture(var0);
      if (var1 == null) {
         var1 = new SimpleTexture(var0);
         Minecraft.getMinecraft().getTextureManager().loadTexture(var0, (ITextureObject)var1);
      }

      GL11.glBindTexture(3553, ((ITextureObject)var1).getGlTextureId());
   }
}
