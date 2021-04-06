package Ares.mods.impl;

import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;

public class ModHelloWorld extends ModDraggable {
   private ScreenPosition pos;

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public ScreenPosition load() {
      return this.pos;
   }

   public void render(ScreenPosition var1) {
      this.font.drawString(" ", var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, -1);
   }

   public void renderDummy(ScreenPosition var1) {
      this.font.drawString(" ", var1.getAbsoluteX() + 50, var1.getAbsoluteY() + 50, -16711936);
   }

   public int getWidth() {
      return this.font.getStringWidth(" ");
   }

   public void save(ScreenPosition var1) {
      this.pos = var1;
   }
}
