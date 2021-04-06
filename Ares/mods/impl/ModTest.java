package Ares.mods.impl;

import Ares.GuiIngameMods;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;

public class ModTest extends ModDraggable {
   public static int Deaths = 0;

   public int getWidth() {
      return this.font.getStringWidth("IGN: 10");
   }

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public void renderDummy(ScreenPosition var1) {
      if (GuiIngameMods.Playername.contains("on")) {
         this.font.drawString("Test §f", var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, -672001);
      }

   }

   public void render(ScreenPosition var1) {
   }
}
