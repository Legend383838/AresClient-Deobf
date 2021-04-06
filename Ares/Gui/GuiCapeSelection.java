package Ares.Gui;

import Ares.GuiAnimatedCapes;
import Ares.GuiIngameCape;
import Ares.CustomCapes.CosmeticLoaderURL;
import Ares.CustomCapes.GuiIngameCustomCape;
import Ares.notis.Notification;
import Ares.notis.NotificationManager;
import Ares.notis.NotificationType;
import java.io.FileWriter;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;

public class GuiCapeSelection extends GuiScreen {
   public void initGui() {
      byte var1 = 100;
      this.buttonList.add(new GuiButton(1, width / 2 - 40, 25 + var1, 80, 20, I18n.format("Normal Capes", new Object[0])));
      this.buttonList.add(new GuiButton(2, width / 2 - 40, 50 + var1, 80, 20, I18n.format("Custom Cape", new Object[0])));
      this.buttonList.add(new GuiButton(3, width / 2 + 45, 50 + var1, 20, 20, I18n.format("on", new Object[0])));
      this.buttonList.add(new GuiButton(4, width / 2 + 70, 50 + var1, 20, 20, I18n.format("off", new Object[0])));
      this.buttonList.add(new GuiButton(5, width / 2 - 40, 75 + var1, 80, 20, I18n.format("Animated Capes", new Object[0])));
      this.buttonList.add(new GuiButton(6, width / 2 + 45, 75 + var1, 20, 20, I18n.format("on", new Object[0])));
      this.buttonList.add(new GuiButton(7, width / 2 + 70, 75 + var1, 20, 20, I18n.format("off", new Object[0])));
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         FileWriter var1;
         try {
            var1 = new FileWriter("AresFolder/CapeFolder.txt");
            var1.write(GuiAnimatedCapes.CapeFolder);
            var1.close();
            FileWriter var2 = new FileWriter("AresFolder/AnimatedCapeonoff.txt");
            var2.write(GuiAnimatedCapes.Capeonoff);
            var2.close();
            System.out.println("Successfully wrote to the file.");
         } catch (IOException var4) {
            System.out.println("An error occurred.");
            var4.printStackTrace();
         }

         try {
            CosmeticLoaderURL.SaveURl();
            var1 = new FileWriter("AresFolder/CustomCapeonoff.txt");
            var1.write(GuiIngameCustomCape.CustomCape);
            var1.close();
         } catch (IOException var3) {
         }

         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 1) {
         this.mc.displayGuiScreen(new GuiIngameCape());
      }

      if (var1.id == 2) {
         this.mc.displayGuiScreen(new GuiIngameCustomCape(this));
      }

      if (var1.id == 3) {
         GuiIngameCustomCape.CustomCape = "on";
         GuiAnimatedCapes.Capeonoff = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Custom Cape", "on", 1));
      }

      if (var1.id == 4) {
         GuiIngameCustomCape.CustomCape = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Custom Cape", "off", 1));
      }

      if (var1.id == 5) {
         this.mc.displayGuiScreen(new GuiAnimatedCapes());
      }

      if (var1.id == 6) {
         GuiAnimatedCapes.Capeonoff = "on";
         GuiIngameCustomCape.CustomCape = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Animated Cape", "on", 1));
      }

      if (var1.id == 7) {
         GuiAnimatedCapes.Capeonoff = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Animated Cape", "off", 1));
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      super.drawScreen(var1, var2, var3);
   }

   public void updateScreen() {
      super.updateScreen();
   }
}
