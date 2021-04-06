package Ares;

import java.awt.Color;

public class RainbowColor {
   public static int getColor() {
      long var0 = System.currentTimeMillis();
      return Color.HSBtoRGB((float)(var0 % 2000L) / 2000.0F, 0.8F, 0.6F);
   }
}
