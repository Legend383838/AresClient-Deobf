package Ares.mods.impl;

import Ares.GuiColor;
import Ares.GuiIngameMods;
import Ares.GuiIngameSettings;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.entity.Render;
import org.lwjgl.input.Mouse;

public class ModClicks extends ModDraggable {
   private List<Long> clicks2 = new ArrayList();
   private long lastPressed2;
   private boolean wasPressed2;
   private List<Long> clicks = new ArrayList();
   private boolean wasPressed;
   private long lastPressed;

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   private int getCPS() {
      long var1 = System.currentTimeMillis();
      this.clicks.removeIf(ModClicks::lambda$0);
      long var3 = System.currentTimeMillis();
      this.clicks2.removeIf(ModClicks::lambda$1);
      return this.clicks.size() + this.clicks2.size();
   }

   public int getWidth() {
      return this.font.getStringWidth("Cps: " + this.getCPS());
   }

   private static boolean lambda$1(long var0, Long var2) {
      return var2 + 1000L < var0;
   }

   public void render(ScreenPosition var1) {
      if (GuiIngameMods.CPS.contains("on")) {
         boolean var2 = Mouse.isButtonDown(0);
         boolean var3 = Mouse.isButtonDown(1);
         if (var2 != this.wasPressed) {
            this.lastPressed = System.currentTimeMillis() + 10L;
            this.wasPressed = var2;
            if (var2) {
               this.clicks.add(this.lastPressed);
            }
         }

         if (var3 != this.wasPressed2) {
            this.lastPressed2 = System.currentTimeMillis() + 10L;
            this.wasPressed2 = var3;
            if (var3) {
               this.clicks2.add(this.lastPressed2);
            }
         }

         if (GuiIngameSettings.ModStyle == 1) {
            this.font.drawStringWithShadow(GuiColor.Color + "Cps: " + this.getCPS(), (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
         }

         if (GuiIngameSettings.ModStyle == 2) {
            this.font.drawStringWithShadow("§f[" + GuiIngameSettings.ModColor + "Cps§f]:" + this.getCPS(), (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
         }

         if (GuiIngameSettings.ModStyle == 3) {
            Render.drawChromaString("[Cps]: " + this.getCPS(), var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, true);
         }
      }

   }

   private static boolean lambda$0(long var0, Long var2) {
      return var2 + 1000L < var0;
   }

   public void renderDummy(ScreenPosition var1) {
      if (GuiIngameMods.CPS.contains("on")) {
         this.font.drawStringWithShadow("§f[" + GuiIngameSettings.ModColor + "Cps§f]:" + this.getCPS(), (float)(var1.getAbsoluteX() + 1), (float)(var1.getAbsoluteY() + 1), -1);
      }

   }
}
