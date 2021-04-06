package Ares;

import Ares.Login.AltLoginThread;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;

public final class GuiNameChanger extends GuiScreen {
   public static String Color = "§4";
   private final GuiScreen previousScreen;
   private GuiTextField username;
   private AltLoginThread thread;
   public static String Name = "Ares";

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

   public void initGui() {
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "Set Name"));
      byte var2 = 20;
      this.buttonList.add(new GuiButton(11, width / 2 - 90, height / 2 + var2, 40, 20, I18n.format("§9Color", new Object[0])));
      this.buttonList.add(new GuiButton(12, width / 2 - 45, height / 2 + var2, 40, 20, I18n.format("§aColor", new Object[0])));
      this.buttonList.add(new GuiButton(14, width / 2, height / 2 + var2, 40, 20, I18n.format("§4Color", new Object[0])));
      this.buttonList.add(new GuiButton(15, width / 2 + 45, height / 2 + var2, 40, 20, I18n.format("§cColor", new Object[0])));
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username.setFocused(true);
      Keyboard.enableRepeatEvents(true);
   }

   protected void actionPerformed(GuiButton var1) {
      switch(var1.id) {
      case 0:
      case 1:
         Name = this.username.getText();
      case 3:
      case 11:
         Color = "§9";
      case 2:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      default:
         break;
      case 12:
         Color = "§a";
         break;
      case 13:
         Color = "§b";
         break;
      case 14:
         Color = "§4";
         break;
      case 15:
         Color = "§c";
      }

   }

   public GuiNameChanger(GuiScreen var1) {
      this.previousScreen = var1;
   }

   public void updateScreen() {
      this.username.updateCursorCounter();
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.username.drawTextBox();
      this.drawCenteredString(this.mc.fontRendererObj, "Set Name", width / 2, 20, -1);
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Name", width / 2 - 96, 66, -7829368);
      }

      super.drawScreen(var1, var2, var3);
   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void mouseClicked(int var1, int var2, int var3) {
      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      this.username.mouseClicked(var1, var2, var3);
   }
}
