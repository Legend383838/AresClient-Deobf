package Ares;

import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

public class GuiEmoteaccept extends GuiScreen {
   int k = 1;
   private int field_146444_f;
   public static int accept = 0;
   private int field_146445_a;

   public void initGui() {
      boolean var1 = true;
      String var2 = Minecraft.getMinecraft().getSession().getUsername();
      DrawMenuLogo.drawString(1.0D, var2, (float)(width / 9 - this.fontRendererObj.getStringWidth(var2) + 200), (float)(height / 20 - 5), Color.white.getRGB());
      this.buttonList.add(new GuiButton(1, width / 2 + 20, height / 2 + 50, 60, 20, I18n.format("Yes", new Object[0])));
      this.buttonList.add(new GuiButton(2, width / 2 - 80, height / 2 + 50, 60, 20, I18n.format("Back", new Object[0])));
   }

   public void onGuiClosed() {
   }

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 1) {
         this.mc.displayGuiScreen(new GuiEmotes());
         accept = 1;
      }

      if (var1.id == 2) {
         this.mc.displayGuiScreen(new GuiIngameMenu());
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawCenteredString(this.fontRendererObj, I18n.format("Look out! Emotions are still being worked on!", new Object[0]), width / 2, height / 2, 16777215);
      this.drawCenteredString(this.fontRendererObj, I18n.format("You still have a lot of errors! Do you still want to test them?", new Object[0]), width / 2, height / 2 + 30, 16777215);
      super.drawScreen(var1, var2, var3);
   }
}
