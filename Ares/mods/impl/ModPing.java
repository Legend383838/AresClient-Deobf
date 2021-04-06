package Ares.mods.impl;

import Ares.GuiIngameSettings;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;

public class ModPing extends ModDraggable {
   public void render(ScreenPosition var1) {
      if (GuiIngameSettings.ModStyle == 1) {
         this.font.drawString("Ping:" + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime(), var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, -1);
      }

      if (GuiIngameSettings.ModStyle == 2) {
         this.font.drawString("§f[" + GuiIngameSettings.ModColor + "Ping§f]:" + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime(), var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, -1);
      }

      if (GuiIngameSettings.ModStyle == 3) {
         Render.drawChromaString("[Ping]:" + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime(), var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, true);
      }

   }

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public int getWidth() {
      return this.font.getStringWidth("Ping: " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime());
   }
}
