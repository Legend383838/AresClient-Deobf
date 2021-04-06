package Ares.cosmetics;

import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticController {
   public static float[] getHaloColor(AbstractClientPlayer var0) {
      return new float[]{1.0F, 1.0F, 1.0F};
   }

   public static float[] getTopHatColor(AbstractClientPlayer var0) {
      return new float[]{1.0F, 1.0F, 1.0F};
   }

   public static boolean shouldRenderTopHat(AbstractClientPlayer var0) {
      return true;
   }

   public static boolean shouldRenderHalo(AbstractClientPlayer var0) {
      return true;
   }

   public static boolean shouldRenderTest(AbstractClientPlayer var0) {
      return true;
   }

   public static float[] getTestColor(AbstractClientPlayer var0) {
      return new float[]{1.0F, 1.0F, 1.0F};
   }
}
