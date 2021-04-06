package Ares;

import Ares.event.EventManager;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;

public class GuiSlider extends GuiScreen {
   public int test2 = 300;
   int i = 50;
   public int test1 = 200;
   private GuiButton refreshButton;
   public boolean buttonEnabled = true;

   public GuiSlider() {
      EventManager.register(this);
   }

   public void drawScreen(int var1, int var2, float var3) {
      if (this.i != 175) {
         ++this.i;
      } else {
         this.buttonEnabled = true;
      }

      drawRect(0, 0, this.i, 500, -259882366);
      super.drawScreen(var1, var2, var3);
   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   protected void keyTyped(char var1, int var2) throws IOException {
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 0) {
         this.mc.displayGuiScreen((GuiScreen)null);
      }

   }

   public void initGui() {
      this.buttonList.clear();
      if (this.buttonEnabled) {
         this.buttonList.add(new GuiButton(0, width / 2 - 100, height - 25, 98, 20, EnumChatFormatting.RED + "Close"));
         this.buttonList.add(new GuiSliderButton(2, 100, 100, 100, 10, "Disable"));
      }

   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      super.mouseClicked(var1, var2, var3);
   }
}
