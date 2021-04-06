package Ares.mods.impl;

import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import java.text.DecimalFormat;
import net.minecraft.client.Minecraft;

public class DistanceBetween extends ModDraggable {
   public void render(ScreenPosition var1) {
      if (this.isEnabled()) {
         this.font.drawString("[DistanceBetween Toggled]", var1.getAbsoluteX(), var1.getAbsoluteY(), -1);
      }

   }

   public int getWidth() {
      return this.font.getStringWidth("[DistanceBetween Toggled]");
   }

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public String returnDistanceNameplate(String var1, double var2, double var4, double var6) {
      if (this.isEnabled) {
         if (Minecraft.getMinecraft().getCurrentServerData() != null) {
            double var8 = Math.abs(this.mc.thePlayer.posX - var2);
            double var10 = Math.abs(this.mc.thePlayer.posY - var4);
            double var12 = Math.abs(this.mc.thePlayer.posZ - var6);
            return var1 + String.format(" %S", (new DecimalFormat("##.00")).format(var8 + var10 + var12));
         } else {
            return var1;
         }
      } else {
         return var1;
      }
   }

   public void renderDummy(ScreenPosition var1) {
      this.font.drawString("[DistanceBetween Toggled]", var1.getAbsoluteX(), var1.getAbsoluteY(), -1);
   }
}
