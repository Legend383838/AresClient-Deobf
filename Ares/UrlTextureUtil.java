package Ares;

import java.awt.image.BufferedImage;
import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.FilenameUtils;

public class UrlTextureUtil {
   public static void downloadAndSetTexture(String var0, UrlTextureUtil.ResourceLocationCallback var1) {
      if (var0 != null && !var0.isEmpty()) {
         String var2 = FilenameUtils.getBaseName(var0);
         ResourceLocation var3 = new ResourceLocation("clientname_temp/" + var2);
         TextureManager var4 = Minecraft.getMinecraft().getTextureManager();
         ITextureObject var5 = var4.getTexture(var3);
         if (var5 != null && var5 instanceof ThreadDownloadImageData) {
            ThreadDownloadImageData var6 = (ThreadDownloadImageData)var5;
            if (var6.imageFound != null) {
               if (var6.imageFound) {
                  var1.onTextureLoaded(var3);
               }

               return;
            }
         }

         IImageBuffer var8 = new IImageBuffer(var1, var3) {
            private final UrlTextureUtil.ResourceLocationCallback val$callback;
            private final ResourceLocation val$resourcelocation;
            ImageBufferDownload ibd;

            public void skinAvailable() {
               this.val$callback.onTextureLoaded(this.val$resourcelocation);
            }

            {
               this.val$callback = var1;
               this.val$resourcelocation = var2;
               this.ibd = new ImageBufferDownload();
            }

            public BufferedImage parseUserSkin(BufferedImage var1) {
               return var1;
            }
         };
         ThreadDownloadImageData var7 = new ThreadDownloadImageData((File)null, var0, (ResourceLocation)null, var8);
         var7.pipeline = true;
         var4.loadTexture(var3, var7);
      }

   }

   public interface ResourceLocationCallback {
      void onTextureLoaded(ResourceLocation var1);
   }
}
