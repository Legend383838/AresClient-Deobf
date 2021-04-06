package Ares;

import Ares.Login.AltLoginThread;
import java.io.FileWriter;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

public final class GuiAutoText extends GuiScreen {
   public static int an = 0;
   private final GuiScreen previousScreen;
   private AltLoginThread thread;
   public static String Text = "Hello";
   private GuiTextField username;

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

   public GuiAutoText(GuiScreen var1) {
      this.previousScreen = var1;
   }

   public void initGui() {
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "Set Auto Text!"));
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username.setFocused(true);
      Keyboard.enableRepeatEvents(true);
   }

   protected void actionPerformed(GuiButton var1) {
      switch(var1.id) {
      case 0:
      case 1:
         an = 1;
         Text = this.username.getText();
      case 2:
      case 3:
      default:
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

   public void updateScreen() {
      this.username.updateCursorCounter();
   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);

      try {
         FileWriter var1 = new FileWriter("AresFolder/Autotext.txt");
         var1.write(Text);
         var1.close();
         System.out.println("Successfully wrote to the file.");
      } catch (IOException var2) {
         System.out.println("An error occurred.");
         var2.printStackTrace();
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.username.drawTextBox();
      this.drawCenteredString(this.mc.fontRendererObj, "SetAutoText", width / 2, 20, -1);
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Text", width / 2 - 96, 66, -7829368);
      }

      super.drawScreen(var1, var2, var3);
   }
}
