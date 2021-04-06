package Ares.mods.impl.togglesprintsneak;

import Ares.GuiIngameSettings;
import Ares.mods.ModInstances;
import java.text.DecimalFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.potion.Potion;
import net.minecraft.util.MovementInput;

public class AresMovementInmput extends MovementInput {
   public static boolean sprint = false;
   private float originalFlySpeed = -1.0F;
   private GameSettings gameSettings;
   private int sneakWasPressed = 0;
   private static final DecimalFormat df = new DecimalFormat("#.0");
   private float boostedFlySpeed = 1.0F;
   private Minecraft mc;
   private EntityPlayerSP player;
   private int sprintWasPressed = 0;

   public String getDisplayText() {
      String var1 = "";
      boolean var2 = this.mc.thePlayer.capabilities.isFlying;
      boolean var3 = this.mc.thePlayer.isRiding();
      boolean var4 = this.gameSettings.keyBindSneak.isKeyDown();
      boolean var5 = this.gameSettings.keyBindSprint.isKeyDown();
      if (var2) {
         if (this.originalFlySpeed > 0.0F) {
            var1 = var1 + "[" + GuiIngameSettings.ModColor + "Flying§f (" + df.format((double)(this.boostedFlySpeed / this.originalFlySpeed)) + "x Boost)]  ";
         } else {
            var1 = var1 + "[" + GuiIngameSettings.ModColor + "Flying§f]  ";
         }
      }

      if (var3) {
         var1 = var1 + "[" + GuiIngameSettings.ModColor + "Riding§f]  ";
      } else if (sprint && !var2 && !var3) {
         if (var5) {
            var1 = var1 + "[" + GuiIngameSettings.ModColor + "Sprinting Held§f]  ";
         } else {
            var1 = var1 + "[" + GuiIngameSettings.ModColor + "Sprinting Toggled§f]  ";
         }
      }

      return var1.trim();
   }

   public void updatePlayerMoveState() {
      this.player = this.mc.thePlayer;
      this.moveStrafe = 0.0F;
      this.moveForward = 0.0F;
      if (this.gameSettings.keyBindForward.isKeyDown()) {
         ++this.moveForward;
      }

      if (this.gameSettings.keyBindBack.isKeyDown()) {
         --this.moveForward;
      }

      if (this.gameSettings.keyBindLeft.isKeyDown()) {
         ++this.moveStrafe;
      }

      if (this.gameSettings.keyBindRight.isKeyDown()) {
         --this.moveStrafe;
      }

      this.jump = this.gameSettings.keyBindJump.isKeyDown();
      this.sneak = this.gameSettings.keyBindSneak.isKeyDown();
      if (this.sneak) {
         this.moveStrafe *= 0.3F;
         this.moveForward *= 0.3F;
      }

      if (ModInstances.getModToggleSprintSneak().isEnabled()) {
         if (this.gameSettings.keyBindSprint.isKeyDown()) {
            if (this.sprintWasPressed == 0) {
               if (sprint) {
                  this.sprintWasPressed = -1;
               } else if (this.player.capabilities.isFlying) {
                  this.sprintWasPressed = ModInstances.getModToggleSprintSneak().keyHoldTicks + 1;
               } else {
                  this.sprintWasPressed = 1;
               }

               sprint = !sprint;
            } else if (this.sprintWasPressed > 0) {
               ++this.sprintWasPressed;
            }
         } else {
            if (ModInstances.getModToggleSprintSneak().keyHoldTicks > 0 && this.sprintWasPressed > ModInstances.getModToggleSprintSneak().keyHoldTicks) {
               sprint = false;
            }

            this.sprintWasPressed = 0;
         }
      } else {
         sprint = false;
      }

      if (sprint && this.moveForward == 1.0F && this.player.onGround && !this.player.isUsingItem() && !this.player.isPotionActive(Potion.blindness)) {
         this.player.setSprinting(true);
      }

      if (ModInstances.getModToggleSprintSneak().flyBoost && this.player.capabilities.isCreativeMode && this.player.capabilities.isFlying && this.mc.getRenderViewEntity() == this.player && sprint) {
         if (this.originalFlySpeed < 0.0F || this.player.capabilities.getFlySpeed() != this.boostedFlySpeed) {
            this.originalFlySpeed = this.player.capabilities.getFlySpeed();
         }

         this.boostedFlySpeed = this.originalFlySpeed * ModInstances.getModToggleSprintSneak().flyBoostFactor;
         this.player.capabilities.setFlySpeed(this.boostedFlySpeed);
         EntityPlayerSP var10000;
         if (this.sneak) {
            var10000 = this.player;
            var10000.motionY -= 0.15D * (double)(ModInstances.getModToggleSprintSneak().flyBoostFactor - 1.0F);
         }

         if (this.jump) {
            var10000 = this.player;
            var10000.motionY += 0.15D * (double)(ModInstances.getModToggleSprintSneak().flyBoostFactor - 1.0F);
         }
      } else {
         if (this.player.capabilities.getFlySpeed() == this.boostedFlySpeed) {
            this.player.capabilities.setFlySpeed(this.originalFlySpeed);
         }

         this.originalFlySpeed = -1.0F;
      }

   }

   public AresMovementInmput(GameSettings var1) {
      this.gameSettings = var1;
      this.mc = Minecraft.getMinecraft();
   }
}
