package Ares;

import Ares.Login.AltLoginThread;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

public final class GuiCustomMod extends GuiScreen {
   private final GuiScreen previousScreen;
   public static String Mod = "Sub 2 Ares";
   private GuiTextField username;
   private AltLoginThread thread;

   public void updateScreen() {
      this.username.updateCursorCounter();
   }

   public void initGui() {
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "Set Mod Text"));
      boolean var2 = true;
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username.setFocused(true);
      Keyboard.enableRepeatEvents(true);
   }

   public GuiCustomMod(GuiScreen var1) {
      this.previousScreen = var1;
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.username.drawTextBox();
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Mod Text", width / 2 - 96, 66, -7829368);
      }

      super.drawScreen(var1, var2, var3);
   }

   protected void mouseClicked(int var1, int var2, int var3) {
      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      this.username.mouseClicked(var1, var2, var3);
   }

   protected void actionPerformed(GuiButton var1) {
      switch(var1.id) {
      case 0:
      case 1:
         Mod = this.username.getText();
      default:
      }
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

      if (var1 == '\r') {
         this.actionPerformed((GuiButton)this.buttonList.get(0));
      }

      this.username.textboxKeyTyped(var1, var2);
   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
   }
}
