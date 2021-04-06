package Ares.mods.impl;

import Ares.GuiColor;
import Ares.GuiIngameMods;
import Ares.GuiIngameSettings;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import net.minecraft.client.renderer.entity.Render;

public class ModDeaths extends ModDraggable {
   public static int Deaths = 0;

   public void renderDummy(ScreenPosition var1) {
      if (GuiIngameMods.Playername.contains("on")) {
         this.font.drawString("§f[" + GuiIngameSettings.ModColor + "Deaths§f]: " + Deaths, var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, -672001);
      }

   }

   public void render(ScreenPosition var1) {
      if (this.mc.thePlayer.isDead) {
         ++Deaths;
      }

      if (GuiIngameMods.Playername.contains("on")) {
         if (GuiIngameSettings.ModStyle == 1) {
            this.font.drawStringWithShadow(GuiColor.Color + "Deaths: " + Deaths, (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
         }

         if (GuiIngameSettings.ModStyle == 2) {
            this.font.drawStringWithShadow("§f[" + GuiIngameSettings.ModColor + "Deaths§f]: " + Deaths, (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
         }

         if (GuiIngameSettings.ModStyle == 3) {
            Render.drawChromaString("[Deaths]: " + Deaths, var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, true);
         }
      }

   }

   public int getWidth() {
      return this.font.getStringWidth("§f[" + GuiIngameSettings.ModColor + "Deaths§f]: " + Deaths);
   }

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }
}
