package Ares;

import Ares.Login.AltLoginThread;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

public final class GuiCustomSkin extends GuiScreen {
   public static String Url = "https://i.imgur.com/NV1e05G.png";
   public static int CustomCape = 0;
   private AltLoginThread thread;
   private final GuiScreen previousScreen;
   private GuiTextField username;

   public void initGui() {
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "Set Yeet Skin!"));
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username.setFocused(true);
      Keyboard.enableRepeatEvents(true);
   }

   public void givefriend(String var1) {
      Url = var1;
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

   public GuiCustomSkin(GuiScreen var1) {
      this.previousScreen = var1;
   }

   protected void actionPerformed(GuiButton var1) {
      switch(var1.id) {
      case 1:
         CustomCape = 0;
      case 0:
         CustomCape = 0;
         if (this.username.getText().contains("imgur")) {
            Url = this.username.getText();
            CustomCape = 1;
         }
      case 2:
      case 3:
      default:
      }
   }

   public void updateScreen() {
      this.username.updateCursorCounter();
   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.username.drawTextBox();
      this.drawCenteredString(this.mc.fontRendererObj, "SetCustomSkin", width / 2, 20, -1);
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Skin Url", width / 2 - 96, 66, -7829368);
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
}
