package Ares.CustomCapes;

import Ares.UrlTextureUtil;
import java.io.IOException;
import net.minecraft.util.ResourceLocation;

public class SkinLoader {
   public static boolean hasTriedToDownload = false;
   public static String URL = "https://i.imgur.com/MzHS090.png";
   public static String onoff = "off";
   public static ResourceLocation img = null;
   public static ResourceLocation CustomSkin;

   public static void SetUrl(String var0) {
      URL = var0;
   }

   static {
      CustomSkin = img;
   }

   public static ResourceLocation GetRessourceLocation() {
      if (!hasTriedToDownload) {
         hasTriedToDownload = true;
         UrlTextureUtil.downloadAndSetTexture(URL, new UrlTextureUtil.ResourceLocationCallback() {
            public void onTextureLoaded(ResourceLocation var1) {
               SkinLoader.img = var1;
               SkinLoader.CustomSkin = SkinLoader.img;
            }
         });
      }

      return img;
   }

   public static void SaveURl() throws IOException {
   }

   public static void voidLoadURL() {
   }
}
