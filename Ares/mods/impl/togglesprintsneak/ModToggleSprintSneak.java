package Ares.mods.impl.togglesprintsneak;

import Ares.GuiIngameSettings;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;

public class ModToggleSprintSneak extends ModDraggable {
   public boolean shiftToggled = false;
   public boolean flyBoost = false;
   public float flyBoostFactor = 1.0F;
   public int keyHoldTicks = 7;

   public void renderDummy(ScreenPosition var1) {
      String var2 = "[" + GuiIngameSettings.ModColor + "Sprinting Toggled§f]  ";
      this.font.drawStringWithShadow(var2, (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), -1);
   }

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public void render(ScreenPosition var1) {
      String var2 = this.mc.thePlayer.movementInput.getDisplayText();
      this.font.drawStringWithShadow(var2, (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), -1);
   }

   public int getWidth() {
      return this.font.getStringWidth("[Sprinting (Toggled)]");
   }
}
