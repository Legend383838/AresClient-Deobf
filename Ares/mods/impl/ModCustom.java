package Ares.mods.impl;

import Ares.GuiCustomMod;
import Ares.GuiIngameMods;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;

public class ModCustom extends ModDraggable {
   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public int getWidth() {
      return this.font.getStringWidth(GuiCustomMod.Mod);
   }

   public void render(ScreenPosition var1) {
      if (GuiIngameMods.Custom.contains("on")) {
         this.font.drawStringWithShadow(GuiCustomMod.Mod, (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
      }

   }

   public void renderDummy(ScreenPosition var1) {
      if (GuiIngameMods.Custom.contains("on")) {
         this.font.drawString(GuiCustomMod.Mod, var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, -672001);
      }

   }
}
