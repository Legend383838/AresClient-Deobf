package Ares.mods;

import Ares.GuiAutoText;
import Ares.GuiIngameMods;
import Ares.GuiKeystrokes;
import Ares.mods.impl.ModArmorStatus;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ModLoader {
   public static void Load() {
      File var0;
      Scanner var1;
      String var2;
      try {
         var0 = new File("AresFolder/ModArmorText.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); ModArmorStatus.Text = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var18) {
         System.out.println("An error occurred.");
         var18.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModArmor.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.Armor = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var17) {
         System.out.println("An error occurred.");
         var17.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModCustom.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.Custom = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var16) {
         System.out.println("An error occurred.");
         var16.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModCoords.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.Coords = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var15) {
         System.out.println("An error occurred.");
         var15.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModDamageIndicator.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.DamageIndicator = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var14) {
         System.out.println("An error occurred.");
         var14.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModFps.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.Fps = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var13) {
         System.out.println("An error occurred.");
         var13.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModItem.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.Item = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var12) {
         System.out.println("An error occurred.");
         var12.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModKeystrokes.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.Keystrokes = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var11) {
         System.out.println("An error occurred.");
         var11.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModPlayer.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.Player = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var10) {
         System.out.println("An error occurred.");
         var10.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModPlayername.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.Playername = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var9) {
         System.out.println("An error occurred.");
         var9.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModPotion.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.Potion = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var8) {
         System.out.println("An error occurred.");
         var8.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModReach.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.Reach = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var7) {
         System.out.println("An error occurred.");
         var7.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModTime.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.Time = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var6) {
         System.out.println("An error occurred.");
         var6.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModCPS.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiIngameMods.CPS = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var5) {
         System.out.println("An error occurred.");
         var5.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/Autotext.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiAutoText.Text = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var4) {
         System.out.println("An error occurred.");
         var4.printStackTrace();
      }

      try {
         var0 = new File("AresFolder/ModKeystrokestyle.txt");

         for(var1 = new Scanner(var0); var1.hasNextLine(); GuiKeystrokes.Style = var2) {
            var2 = var1.nextLine();
         }

         var1.close();
      } catch (FileNotFoundException var3) {
         System.out.println("An error occurred.");
         var3.printStackTrace();
      }

   }

   public static void Save() {
      try {
         FileWriter var0 = new FileWriter("AresFolder/ModCoords.txt");
         var0.write(GuiIngameMods.Coords);
         var0.close();
         FileWriter var1 = new FileWriter("AresFolder/ModDamageIndicator.txt");
         var1.write(GuiIngameMods.DamageIndicator);
         var1.close();
         FileWriter var2 = new FileWriter("AresFolder/ModFps.txt");
         var2.write(GuiIngameMods.Fps);
         var2.close();
         FileWriter var3 = new FileWriter("AresFolder/ModItem.txt");
         var3.write(GuiIngameMods.Item);
         var3.close();
         FileWriter var4 = new FileWriter("AresFolder/ModKeystrokes.txt");
         var4.write(GuiIngameMods.Keystrokes);
         var4.close();
         FileWriter var5 = new FileWriter("AresFolder/ModPlayer.txt");
         var5.write(GuiIngameMods.Player);
         var5.close();
         FileWriter var6 = new FileWriter("AresFolder/ModPlayername.txt");
         var6.write(GuiIngameMods.Playername);
         var6.close();
         FileWriter var7 = new FileWriter("AresFolder/ModPotion.txt");
         var7.write(GuiIngameMods.Potion);
         var7.close();
         FileWriter var8 = new FileWriter("AresFolder/ModReach.txt");
         var8.write(GuiIngameMods.Reach);
         var8.close();
         FileWriter var9 = new FileWriter("AresFolder/ModTime.txt");
         var9.write(GuiIngameMods.Time);
         var9.close();
         FileWriter var10 = new FileWriter("AresFolder/ModCPS.txt");
         var10.write(GuiIngameMods.CPS);
         var10.close();
         FileWriter var11 = new FileWriter("AresFolder/ModCustom.txt");
         var11.write(GuiIngameMods.Custom);
         var11.close();
         FileWriter var12 = new FileWriter("AresFolder/ModArmor.txt");
         var12.write(GuiIngameMods.Armor);
         var12.close();
         FileWriter var13 = new FileWriter("AresFolder/ModArmorText.txt");
         var13.write(ModArmorStatus.Text);
         var13.close();
         System.out.println("Successfully wrote to the file.");
      } catch (IOException var14) {
         System.out.println("An error occurred.");
         var14.printStackTrace();
      }

   }
}
