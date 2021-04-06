package Ares.CustomCapes;

import Ares.UrlTextureUtil;
import Ares.AresFileManager.FileManager;
import java.io.IOException;
import net.minecraft.util.ResourceLocation;

public class CosmeticLoaderURL {
   public static String URL;
   public static ResourceLocation img = null;
   public static boolean hasTriedToDownload = false;
   public static ResourceLocation CustomCape;

   public static void voidLoadURL() {
      URL = FileManager.LoadFile("LastURL");
   }

   public static void SaveURl() throws IOException {
      FileManager.SaveFile("LastURL", URL);
   }

   static {
      CustomCape = img;
   }

   public static void SetUrl(String var0) {
      URL = var0;
   }

   public static ResourceLocation GetRessourceLocation() {
      if (!hasTriedToDownload) {
         hasTriedToDownload = true;
         UrlTextureUtil.downloadAndSetTexture(URL, new UrlTextureUtil.ResourceLocationCallback() {
            public void onTextureLoaded(ResourceLocation var1) {
               CosmeticLoaderURL.img = var1;
               CosmeticLoaderURL.CustomCape = CosmeticLoaderURL.img;
            }
         });
      }

      return img;
   }
}
