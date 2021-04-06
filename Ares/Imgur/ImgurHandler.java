package Ares.Imgur;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class ImgurHandler extends ImageHost {
   public static final String CLIENT_ID = "70df5d8909b8da8";
   private JsonObject lastUploadData;

   public boolean canUploadAnon() {
      return true;
   }

   public boolean upload(BufferedImage var1, ImageHost.UPLOAD_METHOD var2, String... var3) {
      OutputStreamWriter var4 = null;
      BufferedReader var5 = null;
      HttpURLConnection var6 = null;
      ByteArrayOutputStream var7 = null;

      try {
         URL var8 = new URL("https://api.imgur.com/3/upload.json");
         var7 = new ByteArrayOutputStream();
         ImageIO.write(var1, "png", var7);
         var7.flush();
         byte[] var9 = var7.toByteArray();
         String var10 = Base64.encodeBase64String(var9);
         String var11 = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(var10, "UTF-8");
         var6 = (HttpURLConnection)var8.openConnection();
         var6.setDoOutput(true);
         var6.setRequestMethod("POST");
         var6.setRequestProperty("Authorization", "Client-ID 70df5d8909b8da8");
         var6.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         var4 = new OutputStreamWriter(var6.getOutputStream());
         var4.write(var11);
         var4.flush();
         var5 = new BufferedReader(new InputStreamReader(var6.getInputStream()));
         this.lastUploadData = (new JsonParser()).parse(var5).getAsJsonObject();
         return true;
      } catch (IOException var15) {
         var15.printStackTrace();
      } finally {
         IOUtils.close(var6);
         IOUtils.closeQuietly(var4);
         IOUtils.closeQuietly(var5);
         IOUtils.closeQuietly(var7);
      }

      return true;
   }

   private String getDeleteHash() throws JsonParseException {
      if (this.lastUploadData != null) {
         JsonObject var1 = this.lastUploadData.get("data").getAsJsonObject();
         return var1.get("deletehash").getAsString();
      } else {
         return null;
      }
   }

   public boolean deleteLast() {
      HttpURLConnection var1 = null;

      try {
         URL var2 = new URL("https://api.imgur.com/3/image/" + this.getDeleteHash());
         var1 = (HttpURLConnection)var2.openConnection();
         var1.setDoOutput(true);
         var1.setRequestMethod("DELETE");
         var1.setRequestProperty("Authorization", "Client-ID 70df5d8909b8da8");
         if (var1.getResponseCode() == 200) {
            this.lastUploadData = null;
            return true;
         }
      } catch (IOException var6) {
         var6.printStackTrace();
         return false;
      } finally {
         IOUtils.close(var1);
      }

      return false;
   }

   public ImgurHandler() {
      super("imgur");
      System.out.println("added");
      this.lastUploadData = null;
   }

   public boolean canUploadAccount() {
      return false;
   }

   public String getLink() {
      if (this.lastUploadData != null) {
         JsonObject var1 = this.lastUploadData.get("data").getAsJsonObject();
         return "https://imgur.com/" + var1.get("id").getAsString();
      } else {
         return null;
      }
   }
}
