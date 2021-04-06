package Ares;

import Ares.event.gui.GuiModToggle;
import java.io.IOException;
import java.util.Random;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public class SetBlockOverlay extends GuiScreen {
   public static int name = 1;
   public static float bo = 1.0F;
   public static int cape = 1;
   public static float ao = 1.0F;
   public static float ro = 0.5F;
   public static float THICCNESS = 20.0F;
   public static int swing = 1;
   public static float go = 0.0F;

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 1) {
         this.mc.displayGuiScreen(new GuiModToggle());
      }

      if (var1.id == 0) {
         ro = 0.5F;
         go = 0.0F;
         bo = 1.0F;
      }

      if (var1.id == 3) {
         Random var2 = new Random();
         SessionChanger.getInstance().setUserOffline("User" + var2.nextInt(9) + var2.nextInt(9) + var2.nextInt(9) + var2.nextInt(9));
      }

      if (var1.id == 2) {
         ro = 1.0F;
         go = 0.0F;
         bo = 0.0F;
      }

      if (var1.id == 5) {
         ro = 0.0F;
         go = 1.0F;
         bo = 0.0F;
      }

      if (var1.id == 6) {
         ro = 0.0F;
         go = 0.0F;
         bo = 1.0F;
      }

      if (var1.id == 10) {
         cape = 1;
      }

      if (var1.id == 11) {
         cape = 2;
      }

      if (var1.id == 12) {
         cape = 3;
      }

      if (var1.id == 13) {
         cape = 4;
      }

      if (var1.id == 14) {
         cape = 5;
      }

      if (var1.id == 15) {
         cape = 6;
      }

      if (var1.id == 16) {
         name = 1;
      }

      if (var1.id == 17) {
         name = 0;
      }

      if (var1.id == 18) {
         swing = 0;
      }

      if (var1.id == 19) {
         swing = 1;
      }

   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
   }

   public void setBlockOverlay(float var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8) {
      ro = var1;
      go = var2;
      bo = var3;
      ao = var4;
      THICCNESS = var5;
      cape = var6;
      name = var7;
      swing = var8;
   }

   protected void mouseClicked(int var1, int var2, int var3) {
      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.drawCenteredString(this.mc.fontRendererObj, "Block Overlay Color", width / 2, 20, -1);
      this.drawCenteredString(this.mc.fontRendererObj, "Show Player Name", width / 2, 160, -1);
      super.drawScreen(var1, var2, var3);
   }

   public void updateScreen() {
   }

   public void initGui() {
      byte var1 = 100;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, 40, "Normal/Lila"));
      this.buttonList.add(new GuiButton(2, width / 2 - 100, 70, "Rot"));
      this.buttonList.add(new GuiButton(5, width / 2 - 100, 100, "Grün"));
      this.buttonList.add(new GuiButton(6, width / 2 - 100, 130, "Blau"));
      this.buttonList.add(new GuiButton(16, width / 2 - 100, 190, "Enable"));
      this.buttonList.add(new GuiButton(17, width / 2 - 100, 220, "Dissable"));
      this.buttonList.add(new GuiButton(1, width / 2 - 100, 190 + var1 + 150, "Back"));
      Keyboard.enableRepeatEvents(true);
   }
}
