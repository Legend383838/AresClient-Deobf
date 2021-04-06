package Ares.Imgur;

import java.awt.image.BufferedImage;
import java.nio.IntBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ScreenshotHandler {
   private static IntBuffer pixelBuffer;
   private static int[] pixelData;

   public static void processScreenshot() {
      Minecraft var0 = Minecraft.getMinecraft();
      Thread var1 = new Thread(new ScreenshotRunnable("imgur", takeScreenshot(var0.displayWidth, var0.displayHeight, var0.getFramebuffer())));
      var1.start();
   }

   public static BufferedImage takeScreenshot(int var0, int var1, Framebuffer var2) {
      if (OpenGlHelper.isFramebufferEnabled()) {
         var0 = var2.framebufferWidth;
         var1 = var2.framebufferHeight;
      }

      int var3 = var0 * var1;
      if (pixelBuffer == null || pixelBuffer.capacity() < var3) {
         pixelBuffer = BufferUtils.createIntBuffer(var3);
         pixelData = new int[var3];
      }

      GL11.glPixelStorei(3333, 1);
      GL11.glPixelStorei(3317, 1);
      pixelBuffer.clear();
      if (OpenGlHelper.isFramebufferEnabled()) {
         GL11.glBindTexture(3553, var2.framebufferTexture);
         GL11.glGetTexImage(3553, 0, 32993, 33639, pixelBuffer);
      } else {
         GL11.glReadPixels(0, 0, var0, var1, 32993, 33639, pixelBuffer);
      }

      pixelBuffer.get(pixelData);
      TextureUtil.processPixelValues(pixelData, var0, var1);
      BufferedImage var4 = new BufferedImage(var0, var1, 1);
      var4.setRGB(0, 0, var0, var1, pixelData, 0, var0);
      return var4;
   }
}
