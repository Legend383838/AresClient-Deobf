package Ares.CustomCapes;

import Ares.GuiAnimatedCapes;
import Ares.Login.AltLoginThread;
import Ares.notis.Notification;
import Ares.notis.NotificationManager;
import Ares.notis.NotificationType;
import java.awt.Desktop;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

public final class GuiIngameCustomCape extends GuiScreen {
   public static String CustomCape = "off";
   public static String Url = " ";
   private AltLoginThread thread;
   private final GuiScreen previousScreen;
   private GuiTextField username;

   protected void mouseClicked(int var1, int var2, int var3) {
      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      this.username.mouseClicked(var1, var2, var3);
   }

   public void initGui() {
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "Set Custom Cape!"));
      this.buttonList.add(new GuiButton(3, width / 2 - 100, var1 + 62, "Download Template"));
      this.buttonList.add(new GuiButton(1, width / 2 - 45, var1 + 72 + 40, 40, 20, "on"));
      this.buttonList.add(new GuiButton(2, width / 2 + 5, var1 + 72 + 40, 40, 20, "off"));
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username.setFocused(true);
      Keyboard.enableRepeatEvents(true);
   }

   public void givefriend(String var1) {
      Url = var1;
   }

   protected void keyTyped(char var1, int var2) throws IOException {
      try {
         super.keyTyped(var1, var2);
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      if (var1 == '\t' && !this.username.isFocused()) {
         this.username.setFocused(true);
      }

      if (var1 == '\r') {
         this.actionPerformed((GuiButton)this.buttonList.get(0));
      }

      this.username.textboxKeyTyped(var1, var2);
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.username.drawTextBox();
      this.drawCenteredString(this.mc.fontRendererObj, "SetCustomCape", width / 2, 20, -1);
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Cape Url", width / 2 - 96, 66, -7829368);
      }

      super.drawScreen(var1, var2, var3);
   }

   public GuiIngameCustomCape(GuiScreen var1) {
      this.previousScreen = var1;
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 1) {
         CustomCape = "on";
         GuiAnimatedCapes.Capeonoff = "off";
         NotificationManager.show(new Notification(NotificationType.INFO, "Custom Cape", "on", 1));
      }

      if (var1.id == 0) {
         GuiAnimatedCapes.Capeonoff = "off";
         Url = this.username.getText();
         CosmeticLoaderURL.SetUrl(this.username.getText());
         CustomCape = "on";
         CosmeticLoaderURL.SaveURl();
         CosmeticLoaderURL.hasTriedToDownload = false;
      }

      if (var1.id == 2) {
         NotificationManager.show(new Notification(NotificationType.INFO, "Custom Cape", "off", 1));
         CustomCape = "off";
      }

      if (var1.id == 3) {
         Desktop var2 = Desktop.getDesktop();

         try {
            URI var3 = new URI("http://www.mediafire.com/view/vl3hxffrt3xgrzy/template.png/file");
            var2.browse(var3);
         } catch (URISyntaxException var5) {
         }
      }

   }

   public void updateScreen() {
      this.username.updateCursorCounter();
   }

   public void onGuiClosed() {
      try {
         CosmeticLoaderURL.SaveURl();
      } catch (IOException var5) {
      }

      Keyboard.enableRepeatEvents(false);

      FileWriter var1;
      try {
         CosmeticLoaderURL.SaveURl();
         var1 = new FileWriter("AresFolder/CustomCapeonoff.txt");
         var1.write(CustomCape);
         var1.close();
      } catch (IOException var4) {
      }

      try {
         var1 = new FileWriter("AresFolder/CapeFolder.txt");
         var1.write(GuiAnimatedCapes.CapeFolder);
         var1.close();
         FileWriter var2 = new FileWriter("AresFolder/AnimatedCapeonoff.txt");
         var2.write(GuiAnimatedCapes.Capeonoff);
         var2.close();
         System.out.println("Successfully wrote to the file.");
      } catch (IOException var3) {
         System.out.println("An error occurred.");
         var3.printStackTrace();
      }

   }
}
