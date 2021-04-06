package Ares;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

public class GuiKeystrokes extends GuiScreen {
   private int field_146444_f;
   public static int RMB = 1;
   int k = 1;
   public static int Rainbow = 0;
   public static String Style = "1";
   public static int LMB = 1;
   public static int Clicks = 1;
   private int field_146445_a;
   public static int Sneak = 1;

   protected void actionPerformed(GuiButton var1) throws IOException {
      int var10000 = var1.id;
      var10000 = var1.id;
      if (var1.id == 2) {
         Sneak = 1;
      }

      if (var1.id == 3) {
         Sneak = 0;
      }

      if (var1.id == 4) {
         Style = "1";
      }

      if (var1.id == 5) {
         Style = "0";
      }

      if (var1.id == 6) {
         Style = "1";
      }

      if (var1.id == 7) {
         Style = "2";
      }

      if (var1.id == 8) {
         Style = "3";
      }

      if (var1.id == 9) {
         Style = "4";
      }

      if (var1.id == 10) {
         Rainbow = 1;
      }

      if (var1.id == 11) {
         Rainbow = 0;
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawCenteredString(this.fontRendererObj, I18n.format("", new Object[0]), width / 2, height / 2 + 150, 16777215);
      super.drawScreen(var1, var2, var3);
   }

   public void initGui() {
      byte var1 = 30;
      String var2 = Minecraft.getMinecraft().getSession().getUsername();
      DrawMenuLogo.drawString(1.0D, var2, (float)(width / 9 - this.fontRendererObj.getStringWidth(var2) + 200), (float)(height / 20 - 5), Color.white.getRGB());
      this.buttonList.add(new GuiButton(40, 5, 30 + var1, 80, 20, I18n.format("Rainbow", new Object[0])));
      this.buttonList.add(new GuiButton(10, 95, 30 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(11, 120, 30 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5, 55 + var1, 80, 20, I18n.format("Mode", new Object[0])));
      this.buttonList.add(new GuiButton(6, 95, 55 + var1, 20, 20, I18n.format("1", new Object[0])));
      this.buttonList.add(new GuiButton(7, 120, 55 + var1, 20, 20, I18n.format("2", new Object[0])));
      this.buttonList.add(new GuiButton(8, 145, 55 + var1, 20, 20, I18n.format("3", new Object[0])));
      this.buttonList.add(new GuiButton(9, 170, 55 + var1, 20, 20, I18n.format("4", new Object[0])));
   }

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   public void onGuiClosed() {
      try {
         FileWriter var1 = new FileWriter("AresFolder/ModKeystrokestyle.txt");
         var1.write(Style);
         var1.close();
         System.out.println("Successfully wrote to the file.");
      } catch (IOException var2) {
         System.out.println("An error occurred.");
         var2.printStackTrace();
      }

   }
}
