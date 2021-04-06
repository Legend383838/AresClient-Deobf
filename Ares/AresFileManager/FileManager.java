package Ares.AresFileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
   public static String LoadFile(String var0) {
      String var1 = "";

      try {
         File var2 = new File("AresFolder/" + var0 + ".txt");

         Scanner var3;
         String var4;
         for(var3 = new Scanner(var2); var3.hasNextLine(); var1 = var4) {
            var4 = var3.nextLine();
         }

         var3.close();
      } catch (FileNotFoundException var5) {
         System.out.println("An error occurred.");
         var5.printStackTrace();
      }

      return var1;
   }

   public static void SaveFile(String var0, String var1) throws IOException {
      FileWriter var2 = new FileWriter("AresFolder/" + var0 + ".txt");

      try {
         var2.write(var1);
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      var2.close();
   }
}
