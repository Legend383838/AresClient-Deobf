package Ares.cosmetics;

import Ares.GuiIngameCape;
import Ares.GuiIngameCosmetics;
import Ares.GuiIngameCosmetics2;
import Ares.GuiIngameCosmetics3;
import Ares.CustomCapes.SkinLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CosmeticLoader {
   public static void AllOff() {
      GuiIngameCosmetics.Bandanaonoff = "off";
      GuiIngameCosmetics.Wingsonoff = "off";
      GuiIngameCosmetics.Ears = "off";
      GuiIngameCosmetics.Hatonoff = "off";
      GuiIngameCosmetics2.Blaze = "off";
      GuiIngameCosmetics2.Halo = "off";
      GuiIngameCosmetics2.Shield = "off";
      GuiIngameCosmetics2.Susanoo = "off";
      GuiIngameCosmetics3.Creeper = "off";
      GuiIngameCosmetics3.Mask = "off";
      GuiIngameCosmetics3.Wither = "off";
   }

   public static void load() {
      File var0;
      Scanner var1;
      String var2;
      try {
         var0 = new File("AresFolder/Wingsonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics.Wingsonoff = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var27) {
         System.out.println("An error occurred.");
         var27.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Wingspath.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics.Wingspath = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var26) {
         System.out.println("An error occurred.");
         var26.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Hatpath.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics.Hatpath = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var25) {
         System.out.println("An error occurred.");
         var25.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Hatonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics.Hatonoff = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var24) {
         System.out.println("An error occurred.");
         var24.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Bandanaonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics.Bandanaonoff = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var23) {
         System.out.println("An error occurred.");
         var23.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Bandanapath.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics.Bandanapath = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var22) {
         System.out.println("An error occurred.");
         var22.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Hatonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics.Hatonoff = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var21) {
         System.out.println("An error occurred.");
         var21.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Earspath.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics.Earspath = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var20) {
         System.out.println("An error occurred.");
         var20.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Earsonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics.Ears = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var19) {
         System.out.println("An error occurred.");
         var19.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Shieldpath.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics2.Shieldpath = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var18) {
         System.out.println("An error occurred.");
         var18.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Shieldonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics2.Shield = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var17) {
         System.out.println("An error occurred.");
         var17.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Susanoopath.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics2.Susanoopath = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var16) {
         System.out.println("An error occurred.");
         var16.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Susanooonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics2.Susanoo = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var15) {
         System.out.println("An error occurred.");
         var15.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Halopath.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics2.Halopath = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var14) {
         System.out.println("An error occurred.");
         var14.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Haloonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics2.Halo = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var13) {
         System.out.println("An error occurred.");
         var13.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Blazepath.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics2.Blazepath = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var12) {
         System.out.println("An error occurred.");
         var12.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Blazeonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics2.Blaze = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var11) {
         System.out.println("An error occurred.");
         var11.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/onlinecapes.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCape.Online = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var10) {
         System.out.println("An error occurred.");
         var10.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Maskpath.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics3.MaskPath = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var9) {
         System.out.println("An error occurred.");
         var9.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Maskonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics3.Mask = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var8) {
         System.out.println("An error occurred.");
         var8.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Creeperonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics3.Creeper = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var7) {
         System.out.println("An error occurred.");
         var7.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Witheronoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics3.Wither = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var6) {
         System.out.println("An error occurred.");
         var6.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Witchhatonoff.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics3.WitchHat = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var5) {
         System.out.println("An error occurred.");
         var5.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Witchhatpath.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameCosmetics3.WitchHatPath = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var4) {
         System.out.println("An error occurred.");
         var4.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/CustomSkinURL.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); SkinLoader.URL = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var3) {
         System.out.println("An error occurred.");
         var3.printStackTrace();
      }

   }

   public static void save() {
      try {
         FileWriter var0 = new FileWriter("AresFolder/Wingsonoff.txt");
         var0.write(GuiIngameCosmetics.Wingsonoff);
         var0.close();
         FileWriter var1 = new FileWriter("AresFolder/Wingspath.txt");
         var1.write(GuiIngameCosmetics.Wingspath);
         var1.close();
         FileWriter var2 = new FileWriter("AresFolder/Hatpath.txt");
         var2.write(GuiIngameCosmetics.Hatpath);
         var2.close();
         FileWriter var3 = new FileWriter("AresFolder/Hatonoff.txt");
         var3.write(GuiIngameCosmetics.Hatonoff);
         var3.close();
         FileWriter var4 = new FileWriter("AresFolder/Bandanapath.txt");
         var4.write(GuiIngameCosmetics.Bandanapath);
         var4.close();
         FileWriter var5 = new FileWriter("AresFolder/Bandanaonoff.txt");
         var5.write(GuiIngameCosmetics.Bandanaonoff);
         var5.close();
         FileWriter var6 = new FileWriter("AresFolder/Earspath.txt");
         var6.write(GuiIngameCosmetics.Earspath);
         var6.close();
         FileWriter var7 = new FileWriter("AresFolder/Earsonoff.txt");
         var7.write(GuiIngameCosmetics.Ears);
         var7.close();
         FileWriter var8 = new FileWriter("AresFolder/Shieldpath.txt");
         var8.write(GuiIngameCosmetics2.Shieldpath);
         var8.close();
         FileWriter var9 = new FileWriter("AresFolder/Shieldonoff.txt");
         var9.write(GuiIngameCosmetics2.Shield);
         var9.close();
         FileWriter var10 = new FileWriter("AresFolder/Susanoopath.txt");
         var10.write(GuiIngameCosmetics2.Susanoopath);
         var10.close();
         FileWriter var11 = new FileWriter("AresFolder/Susanooonoff.txt");
         var11.write(GuiIngameCosmetics2.Susanoo);
         var11.close();
         FileWriter var12 = new FileWriter("AresFolder/Halopath.txt");
         var12.write(GuiIngameCosmetics2.Halopath);
         var12.close();
         FileWriter var13 = new FileWriter("AresFolder/Haloonoff.txt");
         var13.write(GuiIngameCosmetics2.Halo);
         var13.close();
         FileWriter var14 = new FileWriter("AresFolder/Blazepath.txt");
         var14.write(GuiIngameCosmetics2.Blazepath);
         var14.close();
         FileWriter var15 = new FileWriter("AresFolder/Blazeonoff.txt");
         var15.write(GuiIngameCosmetics2.Blaze);
         var15.close();
         FileWriter var16 = new FileWriter("AresFolder/onlinecapes.txt");
         var16.write(GuiIngameCape.Online);
         var16.close();
         FileWriter var17 = new FileWriter("AresFolder/Maskpath.txt");
         var17.write(GuiIngameCosmetics3.MaskPath);
         var17.close();
         FileWriter var18 = new FileWriter("AresFolder/Maskonoff.txt");
         var18.write(GuiIngameCosmetics3.Mask);
         var18.close();
         FileWriter var19 = new FileWriter("AresFolder/Creeperonoff.txt");
         var19.write(GuiIngameCosmetics3.Creeper);
         var19.close();
         FileWriter var20 = new FileWriter("AresFolder/Witheronoff.txt");
         var20.write(GuiIngameCosmetics3.Wither);
         var20.close();
         FileWriter var21 = new FileWriter("AresFolder/Witchhatonoff.txt");
         var21.write(GuiIngameCosmetics3.WitchHat);
         var21.close();
         FileWriter var22 = new FileWriter("AresFolder/Witchhatpath.txt");
         var22.write(GuiIngameCosmetics3.WitchHatPath);
         var22.close();
         FileWriter var23 = new FileWriter("AresFolder/CustomSkinonoff.txt");
         var23.write(SkinLoader.onoff);
         var23.close();
         FileWriter var24 = new FileWriter("AresFolder/CustomSkinURL.txt");
         var24.write(SkinLoader.URL);
         var24.close();
         System.out.println("Successfully wrote to the file.");
      } catch (IOException var25) {
         System.out.println("An error occurred.");
         var25.printStackTrace();
      }

   }
}
