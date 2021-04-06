package Ares.mods.impl;

import Ares.GuiColor;
import Ares.GuiIngameMods;
import Ares.GuiIngameSettings;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;

public class ModFps extends ModDraggable {
   public void render(ScreenPosition var1) {
      if (GuiIngameMods.Fps.contains("on")) {
         if (GuiIngameSettings.ModStyle == 1) {
            if (Minecraft.getDebugFPS() >= 60) {
               this.font.drawStringWithShadow(GuiColor.Color + "FPS: " + Minecraft.getDebugFPS() + "§f", (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), 16777215);
            }

            if (Minecraft.getDebugFPS() >= 25 && Minecraft.getDebugFPS() <= 59) {
               this.font.drawStringWithShadow("FPS: " + Minecraft.getDebugFPS() + "§f", (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), 16776960);
            }

            if (Minecraft.getDebugFPS() >= 0 && Minecraft.getDebugFPS() <= 24) {
               this.font.drawStringWithShadow("FPS: " + Minecraft.getDebugFPS() + "§f", (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), 16711680);
            }
         }

         if (GuiIngameSettings.ModStyle == 2) {
            this.font.drawStringWithShadow("§f[" + GuiIngameSettings.ModColor + "FPS§f]: " + Minecraft.getDebugFPS() + "§f", (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), 16777215);
         }

         if (GuiIngameSettings.ModStyle == 3) {
            Render.drawChromaString("[FPS]: " + Minecraft.getDebugFPS() + "§f", var1.getAbsoluteX(), var1.getAbsoluteY(), true);
         }
      }

   }

   public int getWidth() {
      return this.font.getStringWidth("FPS: " + Minecraft.getDebugFPS());
   }

   public void renderDummy(ScreenPosition var1) {
      if (GuiIngameMods.Fps.contains("on")) {
         this.font.drawStringWithShadow("§f[" + GuiIngameSettings.ModColor + "FPS§f]: " + Minecraft.getDebugFPS() + "§f", (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), 16777215);
      }

   }

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }
}
