package Ares.Database;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class DatabaseUtil {
   private static JsonArray data;
   private static String stringurl = "https://raw.githubusercontent.com/moritz313/Test/main/capes.json";

   public static Integer getInt(String var0, String var1) throws IOException {
      for(int var2 = 0; var2 < data.size(); ++var2) {
         JsonObject var3 = data.get(var2).getAsJsonObject();
         if (var3.get("uuid").getAsString().equals(var0)) {
            return var3.get(var1).getAsInt();
         }
      }

      return null;
   }

   public static String getString(String var0, String var1) throws IOException {
      for(int var2 = 0; var2 < data.size(); ++var2) {
         JsonObject var3 = data.get(var2).getAsJsonObject();
         if (var3.get("uuid").getAsString().equals(var0)) {
            return var3.get(var1).getAsString();
         }
      }

      return null;
   }

   public static boolean getBoolean(String var0, String var1) throws IOException {
      for(int var2 = 0; var2 < data.size(); ++var2) {
         JsonObject var3 = data.get(var2).getAsJsonObject();
         if (var3.get("uuid").getAsString().equals(var0) && var3.get(var1).getAsBoolean()) {
            return true;
         }
      }

      return false;
   }

   public static void parseData() {
      URL var0 = null;

      try {
         var0 = new URL(stringurl);
         Scanner var1 = (new Scanner(var0.openStream(), "UTF-8")).useDelimiter("\\A");
         String var2 = var1.next();
         JsonParser var3 = new JsonParser();
         data = var3.parse(var2).getAsJsonArray();
         var1.close();
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }
}
