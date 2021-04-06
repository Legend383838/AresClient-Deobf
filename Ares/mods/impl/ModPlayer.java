package Ares.mods.impl;

import Ares.GuiIngameMods;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public class ModPlayer extends ModDraggable {
   public String modeCrouch = "up";
   public String modeAppear = "crouchSprint";
   public int stabilisation;
   public String visible;

   public int getWidth() {
      return 10;
   }

   public int getHeight() {
      return 30;
   }

   public void render(ScreenPosition var1) {
      GlStateManager.color(1.0F, 1.0F, 1.0F);
      if (GuiIngameMods.Player.contains("on")) {
         if (this.modeCrouch == "none") {
            this.stabilisation = 0;
            this.visible = "true";
         }

         if (this.modeCrouch == "down") {
            this.stabilisation = 0;
            this.visible = "true";
         }

         if (this.modeCrouch == "up") {
            this.stabilisation = -2;
            this.visible = "true";
         }

         if (this.modeAppear == "always") {
            this.visible = "true";
         }

         if (this.modeAppear == "crouch") {
            if (this.mc.thePlayer.isSneaking()) {
               this.visible = "true";
            } else {
               this.visible = "true";
            }
         }

         if (this.modeAppear == "sprint") {
            if (this.mc.thePlayer.isSprinting()) {
               this.visible = "true";
            } else {
               this.visible = "true";
            }
         }

         if (this.modeAppear == "crouchSprint") {
            if (!this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isSneaking()) {
               this.visible = "true";
            } else {
               this.visible = "true";
            }
         }

         if (this.visible == "true") {
            if (!this.mc.thePlayer.isSneaking()) {
               GuiInventory.drawEntityOnScreen(var1.getAbsoluteX() + 5, var1.getAbsoluteY() + 20, 25, 2.0F, 1.8F, Minecraft.getMinecraft().thePlayer);
            } else {
               GuiInventory.drawEntityOnScreen(var1.getAbsoluteX() + 5, var1.getAbsoluteY() + 20 + this.stabilisation, 25, 2.0F, 1.8F, Minecraft.getMinecraft().thePlayer);
            }
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      }

   }
}
