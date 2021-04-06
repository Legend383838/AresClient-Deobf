package Ares.event.gui;

import Ares.SetBlockOverlay;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import util.ParticleUtil;

public class GuiModToggle extends GuiScreen {
   private ParticleUtil particles;
   private ScrollListModToggle scrollPanel;
   private ResourceLocation backgroundTexture;
   private DynamicTexture viewportTexture;

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.scrollPanel.drawScreen(var1, var2, var3);
      this.drawCenteredString(this.fontRendererObj, "Mod Options", width / 2, 8, 16777215);
      this.particles.drawParticles();
      super.drawScreen(var1, var2, var3);
   }

   protected void mouseReleased(int var1, int var2, int var3) {
      this.scrollPanel.mouseReleased(var1, var2, var3);
      super.mouseReleased(var1, var2, var3);
   }

   public void handleMouseInput() throws IOException {
      super.handleMouseInput();
      this.scrollPanel.handleMouseInput();
   }

   protected void actionPerformed(GuiButton var1) {
      switch(var1.id) {
      case 0:
      case 5:
         this.mc.displayGuiScreen(new SetBlockOverlay());
         break;
      case 1:
         this.mc.displayGuiScreen(new GuiMainMenu());
      case 2:
      case 3:
      case 4:
      }

   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      this.scrollPanel.mouseClicked(var1, var2, var3);
      super.mouseClicked(var1, var2, var3);
   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   public void initGui() {
      this.scrollPanel = new ScrollListModToggle(this.mc, this);
      this.buttonList.clear();
      this.particles = new ParticleUtil(width, height);
      this.buttonList.add(new GuiButton(1, width / 2 - 100, height / 4 + 180 + 30, I18n.format("Back", new Object[0])));
   }
}
