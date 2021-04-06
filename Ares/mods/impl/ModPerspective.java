package Ares.mods.impl;

import Ares.event.EventTarget;
import Ares.event.gui.hud.ScreenPosition;
import Ares.event.impl.KeyEvent;
import Ares.mods.ModDraggable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class ModPerspective extends ModDraggable {
   private int previousPerspective = 0;
   private boolean returnOnRelease = true;
   private boolean perspectiveToggled = false;
   private float cameraPitch = 0.0F;
   private float cameraYaw = 0.0F;

   public float getCameraYaw() {
      return this.perspectiveToggled ? this.cameraYaw : this.mc.thePlayer.rotationYaw;
   }

   public float getCameraPitch() {
      return this.perspectiveToggled ? this.cameraPitch : this.mc.thePlayer.rotationPitch;
   }

   public int getWidth() {
      return 0;
   }

   public int getHeight() {
      return 0;
   }

   public void render(ScreenPosition var1) {
   }

   public boolean overrideMouse() {
      if (this.mc.inGameHasFocus && Display.isActive()) {
         if (!this.perspectiveToggled) {
            return true;
         }

         this.mc.mouseHelper.mouseXYChange();
         float var1 = this.mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
         float var2 = var1 * var1 * var1 * 8.0F;
         float var3 = (float)this.mc.mouseHelper.deltaX * var2;
         float var4 = (float)this.mc.mouseHelper.deltaY * var2;
         this.cameraYaw += var3 * 0.15F;
         this.cameraPitch += var4 * 0.15F;
         if (this.cameraPitch > 90.0F) {
            this.cameraPitch = 90.0F;
         }

         if (this.cameraPitch < -90.0F) {
            this.cameraPitch = -90.0F;
         }
      }

      return false;
   }

   @EventTarget
   public void keyboardEvent(KeyEvent var1) {
      if (var1.getKey() == this.mc.gameSettings.CLIENT_PERSPECTIVE.getKeyCode()) {
         if (Keyboard.getEventKeyState()) {
            this.perspectiveToggled = !this.perspectiveToggled;
            this.cameraYaw = this.mc.thePlayer.rotationYaw;
            this.cameraPitch = this.mc.thePlayer.rotationPitch;
            if (this.perspectiveToggled) {
               this.previousPerspective = this.mc.gameSettings.thirdPersonView;
               this.mc.gameSettings.thirdPersonView = 1;
            } else {
               this.mc.gameSettings.thirdPersonView = this.previousPerspective;
            }
         } else if (this.returnOnRelease) {
            this.perspectiveToggled = false;
            this.mc.gameSettings.thirdPersonView = this.previousPerspective;
         }
      }

      if (Keyboard.getEventKey() == this.mc.gameSettings.keyBindTogglePerspective.getKeyCode()) {
         this.perspectiveToggled = false;
      }

   }
}
