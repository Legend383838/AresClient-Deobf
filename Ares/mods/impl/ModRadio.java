package Ares.mods.impl;

import Ares.GuiMusikPlayer;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;

public class ModRadio extends ModDraggable {
   public void render(ScreenPosition var1) {
      this.font.drawStringWithShadow(GuiMusikPlayer.NowPlaying, (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
   }

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public int getWidth() {
      return this.font.getStringWidth(GuiMusikPlayer.NowPlaying);
   }

   public void renderDummy(ScreenPosition var1) {
      this.font.drawString(GuiMusikPlayer.NowPlaying, var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, -672001);
   }
}
