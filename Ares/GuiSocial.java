package Ares;

import com.google.common.collect.Lists;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GuiSocial extends GuiScreen {
   private List<String> foundPlayerNames = Lists.newArrayList();
   private String friend = "remix313";
   private boolean waitingOnAutocomplete;
   protected GuiTextField inputField;
   private GuiTextField username;
   private String defaultInputFieldText = "";
   private static final Logger logger = LogManager.getLogger();
   private String historyBuffer = "";
   private int autocompleteIndex;
   private int sentHistoryCursor = -1;
   private boolean playerNamesFound;

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
      this.mc.ingameGUI.getChatGUI().resetScroll();
   }

   public void getSentHistory(int var1) {
      int var2 = this.sentHistoryCursor + var1;
      int var3 = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
      var2 = MathHelper.clamp_int(var2, 0, var3);
      if (var2 != this.sentHistoryCursor) {
         if (var2 == var3) {
            this.sentHistoryCursor = var3;
            this.inputField.setText(this.historyBuffer);
         } else {
            if (this.sentHistoryCursor == var3) {
               this.historyBuffer = this.inputField.getText();
            }

            this.inputField.setText((String)this.mc.ingameGUI.getChatGUI().getSentMessages().get(var2));
            this.sentHistoryCursor = var2;
         }
      }

   }

   public void initGui() {
      Keyboard.enableRepeatEvents(true);
      this.sentHistoryCursor = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
      this.inputField = new GuiTextField(0, this.fontRendererObj, 4, height - 12, width - 4, 12);
      this.inputField.setMaxStringLength(100);
      this.inputField.setEnableBackgroundDrawing(false);
      this.inputField.setFocused(true);
      this.inputField.setText(this.defaultInputFieldText);
      this.inputField.setCanLoseFocus(false);
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "Add To Party"));
      this.buttonList.add(new GuiButton(3, width / 2 - 100, var1 + 72 + 12 + 24 + 24, "Add as Friend"));
      this.buttonList.add(new GuiButton(4, width / 2 - 100, var1 + 72 + 12 + 24, "Steal Skin"));
      this.buttonList.add(new GuiButton(5, width / 2 - 100, var1 + 72 + 12 + 24 + 24 + 24, "Search on YT"));
      this.buttonList.add(new GuiButton(1, width / 2 - 100, var1 + 72 + 12 + 24 + 24 + 24 + 24, "Back"));
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username.setFocused(true);
      Keyboard.enableRepeatEvents(true);
      boolean var2 = true;
   }

   public GuiSocial(String var1) {
      this.defaultInputFieldText = var1;
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.username.drawTextBox();
      this.drawCenteredString(this.mc.fontRendererObj, "Social Menu", width / 2, 20, -1);
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Username", width / 2 - 96, 66, -7829368);
      }

      super.drawScreen(var1, var2, var3);
   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   public void handleMouseInput() throws IOException {
      super.handleMouseInput();
      int var1 = Mouse.getEventDWheel();
      if (var1 != 0) {
         if (var1 > 1) {
            var1 = 1;
         }

         if (var1 < -1) {
            var1 = -1;
         }

         if (!isShiftKeyDown()) {
            var1 *= 7;
         }

         this.mc.ingameGUI.getChatGUI().scroll(var1);
      }

   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      if (var3 == 0) {
         IChatComponent var4 = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
         if (this.handleComponentClick(var4)) {
            return;
         }
      }

      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      this.username.mouseClicked(var1, var2, var3);
      this.inputField.mouseClicked(var1, var2, var3);
      super.mouseClicked(var1, var2, var3);
   }

   protected void keyTyped(char var1, int var2) {
      try {
         super.keyTyped(var1, var2);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      if (var1 == '\t' && !this.username.isFocused()) {
         this.username.setFocused(true);
      }

      if (var1 == '\r') {
         try {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
         } catch (IOException var4) {
            var4.printStackTrace();
         }
      }

      this.username.textboxKeyTyped(var1, var2);
   }

   public void updateScreen() {
      this.inputField.updateCursorCounter();
      this.username.updateCursorCounter();
   }

   public GuiSocial() {
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 0) {
         this.friend = this.username.getText();
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/party invite " + this.friend);
      }

      if (var1.id == 1) {
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.setIngameFocus();
      }

      if (var1.id == 20) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("gg");
      }

      if (var1.id == 3) {
         this.friend = this.username.getText();
         this.username.updateCursorCounter();
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/friend add " + this.friend);
      }

      Desktop var2;
      URI var3;
      if (var1.id == 4) {
         this.friend = this.username.getText();

         try {
            var2 = Desktop.getDesktop();
            var3 = new URI("https://minecraft.tools/download-skin/" + this.friend);
            var2.browse(var3);
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }

      if (var1.id == 5) {
         this.friend = this.username.getText();

         try {
            var2 = Desktop.getDesktop();
            var3 = new URI("https://www.youtube.com/results?search_query=" + this.friend);
            var2.browse(var3);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

   }
}
