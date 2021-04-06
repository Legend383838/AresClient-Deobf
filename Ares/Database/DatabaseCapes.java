package Ares.Database;

import Ares.UrlTextureUtil;
import net.minecraft.util.ResourceLocation;

public class DatabaseCapes {
   public static boolean hasTriedToDownload = false;
   public static ResourceLocation CustomCape;
   public static ResourceLocation img = null;

   static {
      CustomCape = img;
   }

   public static ResourceLocation GetRessourceLocation(String var0) {
      if (!hasTriedToDownload) {
         hasTriedToDownload = true;
         UrlTextureUtil.downloadAndSetTexture(var0, new UrlTextureUtil.ResourceLocationCallback() {
            public void onTextureLoaded(ResourceLocation var1) {
               DatabaseCapes.img = var1;
               DatabaseCapes.CustomCape = DatabaseCapes.img;
            }
         });
      }

      return img;
   }
}
