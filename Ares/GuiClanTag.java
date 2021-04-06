package Ares;

import Ares.Login.AltLoginThread;
import Ares.notis.Notification;
import Ares.notis.NotificationManager;
import Ares.notis.NotificationType;
import java.io.FileWriter;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;

public final class GuiClanTag extends GuiScreen {
   private GuiTextField tag;
   public static String SecondLine = "Sub 2 Ares <3";
   public static String Tag = "Ares";
   private GuiTextField clan;
   public static String Style = "new";
   public static String Username = Minecraft.getMinecraft().getSession().getUsername();
   private AltLoginThread thread;
   public static int an = 0;
   private final GuiScreen previousScreen;
   private GuiTextField username;

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 0) {
         an = 1;
         Tag = this.clan.getText();
         SecondLine = this.tag.getText();
         Username = this.username.getText();
         GuiNameChanger.Name = this.username.getText();
         GuiNameChanger.Color = "";
      }

      if (var1.id == 4) {
         GuiIngameSettings.NameProtect = 1;
         NotificationManager.show(new Notification(NotificationType.INFO, "Name Protect", "on", 1));
      }

      if (var1.id == 5) {
         GuiIngameSettings.NameProtect = 0;
         NotificationManager.show(new Notification(NotificationType.INFO, "Name Protect", "off", 1));
      }

      if (var1.id == 6) {
         SetBlockOverlay.name = 1;
         NotificationManager.show(new Notification(NotificationType.INFO, "Show Nametag", "on", 1));
      }

      if (var1.id == 7) {
         SetBlockOverlay.name = 0;
         NotificationManager.show(new Notification(NotificationType.INFO, "Show Nametag", "off", 1));
      }

      if (var1.id == 8) {
         Style = "new";
         NotificationManager.show(new Notification(NotificationType.INFO, "Style", "new", 1));
      }

      if (var1.id == 9) {
         Style = "old";
         NotificationManager.show(new Notification(NotificationType.INFO, "Style", "old", 1));
      }

      if (var1.id == 10) {
         this.username.setText(Minecraft.getMinecraft().thePlayer.getName());
      }

   }

   public GuiClanTag(GuiScreen var1) {
      this.previousScreen = var1;
   }

   protected void mouseClicked(int var1, int var2, int var3) {
      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      this.username.mouseClicked(var1, var2, var3);
      this.tag.mouseClicked(var1, var2, var3);
      this.clan.mouseClicked(var1, var2, var3);
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.tag.drawTextBox();
      this.username.drawTextBox();
      this.clan.drawTextBox();
      this.drawCenteredString(this.mc.fontRendererObj, "Set Nametag", width / 2, 20, -1);
      if (this.tag.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "2. Line", width / 2 - 96, 66, -7829368);
      }

      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Username", width / 2 - 96, 96, -7829368);
      }

      if (this.clan.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Clan", width / 2 - 96 - 60, 96, -7829368);
      }

      super.drawScreen(var1, var2, var3);
   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);

      try {
         FileWriter var1 = new FileWriter("AresFolder/Clantag.txt");
         var1.write(Tag);
         var1.close();
         FileWriter var2 = new FileWriter("AresFolder/TagStyle.txt");
         var2.write(Style);
         var2.close();
         FileWriter var3 = new FileWriter("AresFolder/TagName.txt");
         var3.write(Username);
         var3.close();
         FileWriter var4 = new FileWriter("AresFolder/TagSecondLine.txt");
         var4.write(SecondLine);
         var4.close();
         System.out.println("Successfully wrote to the file.");
      } catch (IOException var5) {
         System.out.println("An error occurred.");
         var5.printStackTrace();
      }

   }

   public void initGui() {
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "Save"));
      this.buttonList.add(new GuiButton(10, width / 2 + 110, height / 2 - 180, 80, 20, I18n.format("< normal name", new Object[0])));
      this.buttonList.add(new GuiButton(18, width / 2 - 100, height / 2 - 150, 80, 20, I18n.format("Namechanger", new Object[0])));
      this.buttonList.add(new GuiButton(4, width / 2 - 15, height / 2 - 150, 20, 20, I18n.format("On", new Object[0])));
      this.buttonList.add(new GuiButton(5, width / 2 + 10, height / 2 - 150, 20, 20, I18n.format("Off", new Object[0])));
      this.buttonList.add(new GuiButton(18, width / 2 - 100, height / 2 - 125, 80, 20, I18n.format("Show Nametag", new Object[0])));
      this.buttonList.add(new GuiButton(6, width / 2 - 15, height / 2 - 125, 20, 20, I18n.format("On", new Object[0])));
      this.buttonList.add(new GuiButton(7, width / 2 + 10, height / 2 - 125, 20, 20, I18n.format("Off", new Object[0])));
      this.buttonList.add(new GuiButton(18, width / 2 - 100, height / 2 - 100, 80, 20, I18n.format("Nametag Style", new Object[0])));
      this.buttonList.add(new GuiButton(8, width / 2 - 15, height / 2 - 100, 20, 20, I18n.format("new", new Object[0])));
      this.buttonList.add(new GuiButton(9, width / 2 + 10, height / 2 - 100, 20, 20, I18n.format("old", new Object[0])));
      this.tag = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 90, 200, 20);
      this.clan = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 160, 90, 50, 20);
      this.tag.setFocused(true);
      this.username.setFocused(true);
      this.clan.setFocused(true);
      Keyboard.enableRepeatEvents(true);
   }

   public void updateScreen() {
      this.username.updateCursorCounter();
      this.tag.updateCursorCounter();
      this.clan.updateCursorCounter();
   }

   protected void keyTyped(char var1, int var2) throws IOException {
      try {
         super.keyTyped(var1, var2);
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      if (var1 == '\t') {
         if (!this.username.isFocused() && !this.tag.isFocused() && !this.clan.isFocused()) {
            this.username.setFocused(true);
         } else {
            this.username.setFocused(this.tag.isFocused());
            this.tag.setFocused(!this.username.isFocused());
            this.tag.setFocused(!this.clan.isFocused());
         }
      }

      if (var1 == '\r') {
         this.actionPerformed((GuiButton)this.buttonList.get(0));
      }

      this.username.textboxKeyTyped(var1, var2);
      this.tag.textboxKeyTyped(var1, var2);
      this.clan.textboxKeyTyped(var1, var2);
   }
}
