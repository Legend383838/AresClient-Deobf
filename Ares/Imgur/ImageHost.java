package Ares.Imgur;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public abstract class ImageHost {
   public static final HashMap<String, ImageHost> imageHosts = new HashMap();
   public static ImageHost currentSelectedHost;
   public final String hostName;

   public ImageHost(String var1) {
      if (imageHosts.containsKey(var1)) {
         throw new IllegalArgumentException("Image host " + var1 + " is already taken!");
      } else {
         this.hostName = var1;
         imageHosts.put(var1, this);
      }
   }

   public abstract boolean deleteLast();

   public boolean canUploadAccount() {
      return false;
   }

   public boolean canUploadAnon() {
      return false;
   }

   public abstract boolean upload(BufferedImage var1, ImageHost.UPLOAD_METHOD var2, String... var3);

   public abstract String getLink();

   public static enum UPLOAD_METHOD {
      CUSTOM,
      ACCOUNT;

      private static final ImageHost.UPLOAD_METHOD[] ENUM$VALUES = new ImageHost.UPLOAD_METHOD[]{ANON, ACCOUNT, CUSTOM};
      ANON;
   }
}
