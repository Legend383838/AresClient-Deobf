package Ares;

import com.google.common.collect.Lists;
import java.io.IOException;
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

public class GuiColor extends GuiScreen {
   private String historyBuffer = "";
   private String defaultInputFieldText = "";
   private static final Logger logger = LogManager.getLogger();
   private int autocompleteIndex;
   protected GuiTextField inputField;
   private List<String> foundPlayerNames = Lists.newArrayList();
   private boolean playerNamesFound;
   public static String Color = "§f";
   private String friend = "remix313";
   private boolean waitingOnAutocomplete;
   private int sentHistoryCursor = -1;

   public void getColor(String var1) {
      Color = var1;
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 0) {
         Color = "§c";
      }

      if (var1.id == 1) {
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.setIngameFocus();
      }

      if (var1.id == 20) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("gg");
      }

      if (var1.id == 3) {
         Color = "§a";
      }

      if (var1.id == 4) {
         Color = "§9";
      }

      if (var1.id == 5) {
         Color = "§e";
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
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "§cRed"));
      this.buttonList.add(new GuiButton(3, width / 2 - 100, var1 + 72 + 12 + 24 + 24, "§aGreen"));
      this.buttonList.add(new GuiButton(4, width / 2 - 100, var1 + 72 + 12 + 24, "§9Blue"));
      this.buttonList.add(new GuiButton(5, width / 2 - 100, var1 + 72 + 12 + 24 + 24 + 24, "§eYellow"));
      this.buttonList.add(new GuiButton(1, width / 2 - 100, var1 + 72 + 12 + 24 + 24 + 24 + 24, "Back"));
      Keyboard.enableRepeatEvents(true);
      boolean var2 = true;
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.drawCenteredString(this.mc.fontRendererObj, "Theme Settings", width / 2, 20, -1);
      this.drawCenteredString(this.mc.fontRendererObj, "Current Color:" + Color + " Hello", width / 2, 40, -1);
      super.drawScreen(var1, var2, var3);
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

      this.inputField.mouseClicked(var1, var2, var3);
      super.mouseClicked(var1, var2, var3);
   }

   public GuiColor() {
   }

   protected void keyTyped(char var1, int var2) {
      try {
         super.keyTyped(var1, var2);
      } catch (IOException var4) {
         var4.printStackTrace();
      }

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

   public void updateScreen() {
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

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
      this.mc.ingameGUI.getChatGUI().resetScroll();
   }

   public GuiColor(String var1) {
      this.defaultInputFieldText = var1;
   }

   public boolean doesGuiPauseGame() {
      return false;
   }
}
