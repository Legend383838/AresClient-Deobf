package Ares;

import java.awt.Color;

public class Rainbow {
   public static Color rainbowEffect(long var0, float var2) {
      float var3 = (float)(System.nanoTime() + var0) / 1.0E10F % 1.0F;
      long var4 = Long.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(var3, 1.0F, 1.0F))), 16);
      Color var6 = new Color((int)var4);
      return new Color((float)var6.getRed() / 255.0F * var2, (float)var6.getGreen() / 255.0F * var2, (float)var6.getBlue() / 255.0F * var2, (float)var6.getAlpha() / 255.0F);
   }
}
