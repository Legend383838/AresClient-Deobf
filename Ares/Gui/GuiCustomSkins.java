package Ares.Gui;

import Ares.CustomCapes.SkinLoader;
import Ares.Login.AltLoginThread;
import Ares.cosmetics.CosmeticLoader;
import Ares.notis.Notification;
import Ares.notis.NotificationManager;
import Ares.notis.NotificationType;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

public final class GuiCustomSkins extends GuiScreen {
   private AltLoginThread thread;
   private GuiTextField username;
   private final GuiScreen previousScreen;

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.username.drawTextBox();
      this.drawCenteredString(this.mc.fontRendererObj, "SetCustomSkin", width / 2, 20, -1);
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Skin Url", width / 2 - 96, 66, -7829368);
      }

      super.drawScreen(var1, var2, var3);
   }

   public void updateScreen() {
      this.username.updateCursorCounter();
   }

   protected void mouseClicked(int var1, int var2, int var3) {
      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      this.username.mouseClicked(var1, var2, var3);
   }

   public GuiCustomSkins(GuiScreen var1) {
      this.previousScreen = var1;
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

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 1) {
         SkinLoader.onoff = "on";
         NotificationManager.show(new Notification(NotificationType.INFO, "Custom Skin", "on", 1));
      }

      if (var1.id == 0 && this.username.getText().contains("imgur")) {
         SkinLoader.onoff = "on";
         SkinLoader.URL = this.username.getText();
         SkinLoader.SetUrl(this.username.getText());
         SkinLoader.SaveURl();
         SkinLoader.hasTriedToDownload = false;
      }

      if (var1.id == 2) {
         NotificationManager.show(new Notification(NotificationType.INFO, "Custom Cape", "off", 1));
         SkinLoader.onoff = "off";
      }

   }

   public void initGui() {
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "Set Custom Skin!"));
      this.buttonList.add(new GuiButton(1, width / 2 - 45, var1 + 72 + 40, 40, 20, "on"));
      this.buttonList.add(new GuiButton(2, width / 2 + 5, var1 + 72 + 40, 40, 20, "off"));
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username.setFocused(true);
      Keyboard.enableRepeatEvents(true);
   }

   public void onGuiClosed() {
      CosmeticLoader.save();
   }
}
