package Ares.mods.impl;

import Ares.GuiColor;
import Ares.GuiIngameMods;
import Ares.GuiIngameSettings;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;

public class ModPlayername extends ModDraggable {
   public void render(ScreenPosition var1) {
      if (GuiIngameMods.Playername.contains("on")) {
         if (GuiIngameSettings.ModStyle == 1) {
            this.font.drawStringWithShadow(GuiColor.Color + "IGN: " + Minecraft.getMinecraft().getSession().getUsername(), (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
         }

         if (GuiIngameSettings.ModStyle == 2) {
            this.font.drawStringWithShadow("§f[" + GuiIngameSettings.ModColor + "IGN§f]:" + Minecraft.getMinecraft().getSession().getUsername(), (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
         }

         if (GuiIngameSettings.ModStyle == 3) {
            Render.drawChromaString("[IGN]: " + Minecraft.getMinecraft().getSession().getUsername(), var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, true);
         }
      }

   }

   public void renderDummy(ScreenPosition var1) {
      if (GuiIngameMods.Playername.contains("on")) {
         this.font.drawString("IGN: PPMaster69 §f", var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, -672001);
      }

   }

   public int getWidth() {
      return this.font.getStringWidth("IGN: " + Minecraft.getMinecraft().getSession().getUsername());
   }

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }
}
