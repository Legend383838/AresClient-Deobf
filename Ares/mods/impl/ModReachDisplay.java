package Ares.mods.impl;

import Ares.GuiIngameMods;
import Ares.GuiIngameSettings;
import Ares.event.EventTarget;
import Ares.event.gui.hud.ScreenPosition;
import Ares.event.impl.AttackPlayerEvent;
import Ares.event.impl.ClientTickEvent;
import Ares.mods.ModDraggable;
import java.text.DecimalFormat;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.util.Vec3;

public class ModReachDisplay extends ModDraggable {
   private boolean enabled = true;
   private int decimals;
   private long lastAttack;
   String ReachDisplay = "";

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   @EventTarget
   public void onHit(AttackPlayerEvent var1) {
      Vec3 var2 = this.mc.getRenderViewEntity().getPositionEyes(1.0F);
      double var3 = this.mc.objectMouseOver.hitVec.distanceTo(var2);
      if (GuiIngameSettings.ModStyle == 1) {
         this.ReachDisplay = this.getFormatter().format(var3) + " blocks";
      }

      if (GuiIngameSettings.ModStyle == 2) {
         this.ReachDisplay = "[" + GuiIngameSettings.ModColor + "Reach§f]:" + this.getFormatter().format(var3);
      }

      if (GuiIngameSettings.ModStyle == 3) {
         this.ReachDisplay = "[Reach]: " + this.getFormatter().format(var3);
      }

      this.lastAttack = System.nanoTime();
   }

   private DecimalFormat getFormatter() {
      StringBuilder var1 = new StringBuilder("0.");

      for(int var2 = 0; this.decimals > var2; ++var2) {
         var1.append('0');
      }

      return new DecimalFormat(var1.toString());
   }

   @EventTarget
   public void onTick(ClientTickEvent var1) {
      if (GuiIngameSettings.ModStyle == 1 && (double)(System.nanoTime() - this.lastAttack) >= 2.0E9D && this.enabled) {
         this.ReachDisplay = "Hasn't attacked";
      }

      if (GuiIngameSettings.ModStyle == 2 && (double)(System.nanoTime() - this.lastAttack) >= 2.0E9D && this.enabled) {
         this.ReachDisplay = "[" + GuiIngameSettings.ModColor + "Reach§f]: 0";
      }

      if (GuiIngameSettings.ModStyle == 3 && (double)(System.nanoTime() - this.lastAttack) >= 2.0E9D && this.enabled) {
         this.ReachDisplay = "[Reach]: 0";
      }

   }

   public void render(ScreenPosition var1) {
      if (GuiIngameMods.Reach.contains("on")) {
         if (GuiIngameSettings.ModStyle == 1 || GuiIngameSettings.ModStyle == 2) {
            this.font.drawStringWithShadow(this.ReachDisplay, (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), -1);
         }

         if (GuiIngameSettings.ModStyle == 3) {
            Render.drawChromaString(this.ReachDisplay, var1.getAbsoluteX(), var1.getAbsoluteY(), true);
         }
      }

   }

   public int getWidth() {
      return 64;
   }
}
