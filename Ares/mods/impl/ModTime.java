package Ares.mods.impl;

import Ares.GuiColor;
import Ares.GuiIngameMods;
import Ares.GuiIngameSettings;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.client.renderer.entity.Render;

public class ModTime extends ModDraggable {
   private ScreenPosition pos;

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public void render(ScreenPosition var1) {
      if (GuiIngameMods.Time.contains("on")) {
         String var2 = "hh:mm:ss a z";
         SimpleDateFormat var3 = new SimpleDateFormat(var2);
         String var4 = var3.format(new Date());
         if (GuiIngameSettings.ModStyle == 2) {
            this.font.drawStringWithShadow("§f[" + GuiIngameSettings.ModColor + "Time§f]: " + var4, (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
         }

         if (GuiIngameSettings.ModStyle == 1) {
            this.font.drawStringWithShadow(GuiColor.Color + "Time: " + var4, (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
         }

         if (GuiIngameSettings.ModStyle == 3) {
            Render.drawChromaString("[Time]: " + var4, var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, true);
         }
      }

   }

   public int getWidth() {
      return this.font.getStringWidth("Time: AA:AA:AA AA AAA");
   }

   public void renderDummy(ScreenPosition var1) {
      if (GuiIngameMods.Time.contains("on")) {
         String var2 = "hh:mm:ss a z";
         SimpleDateFormat var3 = new SimpleDateFormat(var2);
         String var4 = var3.format(new Date());
         this.font.drawStringWithShadow("Time: " + var4, (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
      }

   }
}
