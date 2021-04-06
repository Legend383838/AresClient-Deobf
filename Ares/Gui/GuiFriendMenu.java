package Ares.Gui;

import Ares.GuiIngameSettings;
import Ares.Login.AltLoginThread;
import Ares.event.gui.GuiCheckBox;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

public final class GuiFriendMenu extends GuiScreen {
   private GuiTextField username;
   public static ArrayList<String> Friends = new ArrayList();
   static int j = 0;
   public static int Gang = 0;
   private AltLoginThread thread;
   private final GuiScreen previousScreen;
   static int selected = 0;

   public static void save() throws IOException {
      FileOutputStream var0 = new FileOutputStream("AresFolder/Friends.txt");
      ObjectOutputStream var1 = new ObjectOutputStream(var0);
      var1.writeObject(Friends);
      var0.close();
   }

   public static void deletus() {
      Friends.clear();
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.username.drawTextBox();
      this.drawCenteredString(this.mc.fontRendererObj, "§f[" + GuiIngameSettings.ModColor + " Friends " + "§f]", 120, 52, -1);

      for(int var4 = 0; var4 < Friends.size(); ++var4) {
         byte var5 = 62;
         this.drawCenteredString(this.mc.fontRendererObj, (String)Friends.get(var4), 120, 12 * var4 + var5, -1);
      }

      this.drawCenteredString(this.mc.fontRendererObj, "Add Friend", width / 2, 20, -1);
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Friend Username", width / 2 - 96, 66, -7829368);
      }

      super.drawScreen(var1, var2, var3);
   }

   public void onGuiClosed() {
      selected = 0;
      Keyboard.enableRepeatEvents(false);

      try {
         save();
      } catch (IOException var2) {
      }

   }

   protected void mouseClicked(int var1, int var2, int var3) {
      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      this.username.mouseClicked(var1, var2, var3);
   }

   public void initGui() {
      selected = 0;
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(1, width / 2 - 100, var1 + 72 + 12, "Add Friend"));
      this.buttonList.add(new GuiButton(2, width / 2 - 100, var1 + 72 + 47, "Remove Friends"));
      this.buttonList.add(new GuiCheckBox(3, 5, 5, 20, 20));
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username.setFocused(true);
      Keyboard.enableRepeatEvents(true);
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 1) {
         Friends.add(this.username.getText());
      }

      if (var1.id == 2) {
         Friends.clear();
      }

      int var10000 = var1.id;
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

   public static void read() throws ClassNotFoundException, IOException {
      FileInputStream var0 = new FileInputStream("AresFolder/Friends.txt");
      ObjectInputStream var1 = new ObjectInputStream(var0);
      Friends = (ArrayList)var1.readObject();
      var0.close();
   }

   public void updateScreen() {
      this.username.updateCursorCounter();
   }

   public GuiFriendMenu(GuiScreen var1) {
      this.previousScreen = var1;
   }
}
