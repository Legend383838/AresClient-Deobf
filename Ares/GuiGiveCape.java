package Ares;

import Ares.Login.AltLoginThread;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;

public final class GuiGiveCape extends GuiScreen {
   private AltLoginThread thread;
   public static String Friendpath;
   public static String friendonoff = "off";
   public static int number = 1;
   private GuiTextField username;
   private final GuiScreen previousScreen;
   public static String friend = "username";

   static {
      Friendpath = "cape/random/FadeCape/def" + number + ".png";
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 0) {
         Friendpath = "cape/random/" + GuiIngameCape.CapeFolder + "/def" + number + ".png";
         friend = this.username.getText();
      }

      if (var1.id == 4) {
         if (number >= 2) {
            --number;
         } else {
            number = 1;
         }

         Friendpath = "cape/random/" + GuiIngameCape.CapeFolder + "/def" + number + ".png";
      }

      if (var1.id == 5) {
         if (number <= 9) {
            ++number;
         } else {
            number = 10;
         }

         Friendpath = "cape/random/" + GuiIngameCape.CapeFolder + "/def" + number + ".png";
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

   public GuiGiveCape(GuiScreen var1) {
      this.previousScreen = var1;
   }

   protected void keyTyped(char var1, int var2) {
      try {
         super.keyTyped(var1, var2);
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      if (var1 == '\t' && !this.username.isFocused()) {
         this.username.setFocused(true);
      }

      this.username.textboxKeyTyped(var1, var2);
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.username.drawTextBox();
      this.drawCenteredString(this.mc.fontRendererObj, "Give Cape to friend!", width / 2, 20, -1);
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Username", width / 2 - 96, 66, -7829368);
      }

      super.drawScreen(var1, var2, var3);
   }

   public void updateScreen() {
      this.username.updateCursorCounter();
   }

   public void givefriend(String var1) {
      friend = var1;
   }

   public void initGui() {
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "Give Cape!"));
      this.buttonList.add(new GuiButton(2, width / 2 - 45, height / 2 + 50, 40, 20, I18n.format("On", new Object[0])));
      this.buttonList.add(new GuiButton(3, width / 2, height / 2 + 50, 40, 20, I18n.format("Off", new Object[0])));
      this.buttonList.add(new GuiButton(4, width / 2 - 45, height / 2 + 100, 40, 20, I18n.format("<<<", new Object[0])));
      this.buttonList.add(new GuiButton(5, width / 2, height / 2 + 100, 40, 20, I18n.format(">>>", new Object[0])));
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username.setFocused(true);
      Keyboard.enableRepeatEvents(true);
   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
   }
}
