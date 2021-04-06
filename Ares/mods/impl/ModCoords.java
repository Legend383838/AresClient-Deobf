package Ares.mods.impl;

import Ares.GuiColor;
import Ares.GuiIngameMods;
import Ares.GuiIngameSettings;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import net.minecraft.client.renderer.entity.Render;

public class ModCoords extends ModDraggable {
   public void render(ScreenPosition var1) {
      if (GuiIngameMods.Coords.contains("on")) {
         String var2;
         if (GuiIngameSettings.ModStyle == 1) {
            this.font.drawStringWithShadow(String.format(GuiColor.Color + "X: %.0f" + "§f", this.mc.renderViewEntity.posX), (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), -1);
            this.font.drawStringWithShadow(String.format(GuiColor.Color + "Y: %.0f" + "§f", this.mc.renderViewEntity.posY), (float)var1.getAbsoluteX(), (float)(var1.getAbsoluteY() + this.font.FONT_HEIGHT + 2), -1);
            this.font.drawStringWithShadow(String.format(GuiColor.Color + "Z: %.0f" + "§f", this.mc.renderViewEntity.posZ), (float)var1.getAbsoluteX(), (float)(var1.getAbsoluteY() + this.font.FONT_HEIGHT * 2 + 4), -1);
            var2 = "";
            switch(this.getDirectionFacing()) {
            case 0:
               var2 = GuiColor.Color + "S";
               break;
            case 1:
               var2 = GuiColor.Color + "SW";
               break;
            case 2:
               var2 = GuiColor.Color + "W";
               break;
            case 3:
               var2 = GuiColor.Color + "NW";
               break;
            case 4:
               var2 = GuiColor.Color + "N";
               break;
            case 5:
               var2 = GuiColor.Color + "NE";
               break;
            case 6:
               var2 = GuiColor.Color + "E";
               break;
            case 7:
               var2 = GuiColor.Color + "SE";
            }

            this.font.drawStringWithShadow(var2, (float)(var1.getAbsoluteX() + 54), (float)(var1.getAbsoluteY() + this.font.FONT_HEIGHT + 2), -1);
         }

         if (GuiIngameSettings.ModStyle == 2) {
            this.font.drawStringWithShadow(String.format(GuiColor.Color + "§f[" + GuiIngameSettings.ModColor + "X§f]: %.0f" + "§f", this.mc.renderViewEntity.posX), (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), -1);
            this.font.drawStringWithShadow(String.format(GuiColor.Color + "§f[" + GuiIngameSettings.ModColor + "Y§f]: %.0f" + "§f", this.mc.renderViewEntity.posY), (float)var1.getAbsoluteX(), (float)(var1.getAbsoluteY() + this.font.FONT_HEIGHT + 2), -1);
            this.font.drawStringWithShadow(String.format(GuiColor.Color + "§f[" + GuiIngameSettings.ModColor + "Z§f]: %.0f" + "§f", this.mc.renderViewEntity.posZ), (float)var1.getAbsoluteX(), (float)(var1.getAbsoluteY() + this.font.FONT_HEIGHT * 2 + 4), -1);
            var2 = "";
            switch(this.getDirectionFacing()) {
            case 0:
               var2 = GuiColor.Color + "S";
               break;
            case 1:
               var2 = GuiColor.Color + "SW";
               break;
            case 2:
               var2 = GuiColor.Color + "W";
               break;
            case 3:
               var2 = GuiColor.Color + "NW";
               break;
            case 4:
               var2 = GuiColor.Color + "N";
               break;
            case 5:
               var2 = GuiColor.Color + "NE";
               break;
            case 6:
               var2 = GuiColor.Color + "E";
               break;
            case 7:
               var2 = GuiColor.Color + "SE";
            }

            this.font.drawStringWithShadow(var2, (float)(var1.getAbsoluteX() + 54), (float)(var1.getAbsoluteY() + this.font.FONT_HEIGHT + 2), -1);
         }

         if (GuiIngameSettings.ModStyle == 3) {
            Render.drawChromaString(String.format("[X]: %.0f", this.mc.renderViewEntity.posX), var1.getAbsoluteX(), var1.getAbsoluteY(), true);
            Render.drawChromaString(String.format("[Y]: %.0f", this.mc.renderViewEntity.posY), var1.getAbsoluteX(), var1.getAbsoluteY() + this.font.FONT_HEIGHT + 2, true);
            Render.drawChromaString(String.format("[Z]: %.0f", this.mc.renderViewEntity.posZ), var1.getAbsoluteX(), var1.getAbsoluteY() + this.font.FONT_HEIGHT * 2 + 4, true);
            var2 = "";
            switch(this.getDirectionFacing()) {
            case 0:
               var2 = "S";
               break;
            case 1:
               var2 = "SW";
               break;
            case 2:
               var2 = "W";
               break;
            case 3:
               var2 = "NW";
               break;
            case 4:
               var2 = "N";
               break;
            case 5:
               var2 = "NE";
               break;
            case 6:
               var2 = "E";
               break;
            case 7:
               var2 = "SE";
            }

            Render.drawChromaString(var2, var1.getAbsoluteX() + 54, var1.getAbsoluteY() + this.font.FONT_HEIGHT + 2, true);
         }
      }

   }

   public void renderDummy(ScreenPosition var1) {
      if (GuiIngameMods.Coords.contains("on")) {
         this.font.drawStringWithShadow(String.format(GuiColor.Color + "§f[" + GuiIngameSettings.ModColor + "X§f]: %.0f" + "§f", this.mc.renderViewEntity.posX), (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), -1);
         this.font.drawStringWithShadow(String.format(GuiColor.Color + "§f[" + GuiIngameSettings.ModColor + "Y§f]: %.0f" + "§f", this.mc.renderViewEntity.posY), (float)var1.getAbsoluteX(), (float)(var1.getAbsoluteY() + this.font.FONT_HEIGHT + 2), -1);
         this.font.drawStringWithShadow(String.format(GuiColor.Color + "§f[" + GuiIngameSettings.ModColor + "Z§f]: %.0f" + "§f", this.mc.renderViewEntity.posZ), (float)var1.getAbsoluteX(), (float)(var1.getAbsoluteY() + this.font.FONT_HEIGHT * 2 + 4), -1);
         String var2 = "";
         switch(this.getDirectionFacing()) {
         case 0:
            var2 = GuiColor.Color + "S";
            break;
         case 1:
            var2 = GuiColor.Color + "SW";
            break;
         case 2:
            var2 = GuiColor.Color + "W";
            break;
         case 3:
            var2 = GuiColor.Color + "NW";
            break;
         case 4:
            var2 = GuiColor.Color + "N";
            break;
         case 5:
            var2 = GuiColor.Color + "NE";
            break;
         case 6:
            var2 = GuiColor.Color + "E";
            break;
         case 7:
            var2 = GuiColor.Color + "SE";
         }
      }

   }

   public int getHeight() {
      return this.font.FONT_HEIGHT * 4 - 2;
   }

   public int getWidth() {
      return this.font.getStringWidth(this.getCoordsPlaceholder());
   }

   private String getCoordsPlaceholder() {
      return "Y: 10000      NE";
   }

   private int getDirectionFacing() {
      int var1 = (int)this.mc.renderViewEntity.rotationYaw;
      var1 += 360;
      var1 += 22;
      var1 %= 360;
      return var1 / 45;
   }
}
