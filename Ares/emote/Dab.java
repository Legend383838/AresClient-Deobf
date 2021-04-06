package Ares.emote;

import Ares.Client;
import Ares.GuiEmoteaccept;
import Ares.GuiEmotes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class Dab extends ModelPlayer {
   private ModelBase oldModel;
   private float thirdPersonPartialTicks;

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
      float var8 = (float)var7.getEntityId();
      boolean var9 = var8 == (float)Minecraft.getMinecraft().thePlayer.getEntityId();
      if (Client.getInstance().dab || var9 && InputEvent.prevDabbingHeld > 0) {
         float var10 = ((float)InputEvent.prevDabbingHeld + (float)(InputEvent.dabbingHeld - InputEvent.prevDabbingHeld) * this.thirdPersonPartialTicks) / 8.0F;
         if (!var9) {
            var10 = 1.0F;
         }

         if (GuiEmoteaccept.accept == 1) {
            float var11;
            float var12;
            if (GuiEmotes.Emote == 1) {
               this.bipedRightArm.rotateAngleX = (float)Math.toRadians((double)(-90.0F * var10));
               this.bipedRightArm.rotateAngleY = (float)Math.toRadians((double)(-35.0F * var10));
               this.bipedRightArmwear.rotateAngleX = (float)Math.toRadians((double)(-90.0F * var10));
               this.bipedRightArmwear.rotateAngleY = (float)Math.toRadians((double)(-35.0F * var10));
               this.bipedLeftArm.rotateAngleX = (float)Math.toRadians((double)(15.0F * var10));
               this.bipedLeftArm.rotateAngleY = (float)Math.toRadians((double)(15.0F * var10));
               this.bipedLeftArm.rotateAngleZ = (float)Math.toRadians((double)(-110.0F * var10));
               this.bipedLeftArmwear.rotateAngleX = (float)Math.toRadians((double)(15.0F * var10));
               this.bipedLeftArmwear.rotateAngleY = (float)Math.toRadians((double)(15.0F * var10));
               this.bipedLeftArmwear.rotateAngleZ = (float)Math.toRadians((double)(-110.0F * var10));
               var11 = var7.rotationPitch;
               this.bipedHead.rotateAngleX = (float)Math.toRadians((double)(-var11 * var10)) + (float)Math.toRadians((double)(45.0F * var10 + var11));
               var12 = ((EntityPlayer)var7).renderYawOffset - var7.rotationYaw;
               this.bipedHead.rotateAngleY = (float)Math.toRadians((double)(var12 * var10)) + (float)Math.toRadians((double)(35.0F * var10 - var12));
            }

            if (GuiEmotes.Emote == 2) {
               this.bipedRightArm.rotateAngleX = (float)Math.toRadians((double)(-15.0F * var10));
               this.bipedRightArm.rotateAngleY = (float)Math.toRadians((double)(-15.0F * var10));
               this.bipedRightArm.rotateAngleZ = (float)Math.toRadians((double)(110.0F * var10));
               this.bipedRightArmwear.rotateAngleX = (float)Math.toRadians((double)(-15.0F * var10));
               this.bipedRightArmwear.rotateAngleY = (float)Math.toRadians((double)(-15.0F * var10));
               this.bipedRightArmwear.rotateAngleZ = (float)Math.toRadians((double)(110.0F * var10));
               this.bipedLeftArm.rotateAngleX = (float)Math.toRadians((double)(15.0F * var10));
               this.bipedLeftArm.rotateAngleY = (float)Math.toRadians((double)(15.0F * var10));
               this.bipedLeftArm.rotateAngleZ = (float)Math.toRadians((double)(-110.0F * var10));
               this.bipedLeftArmwear.rotateAngleX = (float)Math.toRadians((double)(15.0F * var10));
               this.bipedLeftArmwear.rotateAngleY = (float)Math.toRadians((double)(15.0F * var10));
               this.bipedLeftArmwear.rotateAngleZ = (float)Math.toRadians((double)(-110.0F * var10));
            }

            if (GuiEmotes.Emote == 3) {
               this.bipedRightArm.rotateAngleX = (float)Math.toRadians((double)(-90.0F * var10));
               this.bipedRightArm.rotateAngleZ = (float)Math.toRadians((double)(110.0F * var10));
               this.bipedRightArmwear.rotateAngleX = (float)Math.toRadians((double)(-90.0F * var10));
               this.bipedRightArmwear.rotateAngleZ = (float)Math.toRadians((double)(110.0F * var10));
               this.bipedLeftArm.rotateAngleX = (float)Math.toRadians((double)(-90.0F * var10));
               this.bipedLeftArm.rotateAngleZ = (float)Math.toRadians((double)(-110.0F * var10));
               this.bipedLeftArmwear.rotateAngleX = (float)Math.toRadians((double)(-90.0F * var10));
               this.bipedLeftArmwear.rotateAngleZ = (float)Math.toRadians((double)(-110.0F * var10));
            }

            if (GuiEmotes.Emote == 4) {
               var11 = -60.0F;
               this.bipedRightLeg.rotateAngleX = (float)Math.toRadians((double)(var11 * var10));
               this.bipedRightLeg.rotateAngleZ = (float)Math.toRadians((double)(90.0F * var10));
               this.bipedRightLegwear.rotateAngleX = (float)Math.toRadians((double)(var11 * var10));
               this.bipedRightLegwear.rotateAngleZ = (float)Math.toRadians((double)(90.0F * var10));
               this.bipedLeftLeg.rotateAngleX = (float)Math.toRadians((double)(var11 * var10));
               this.bipedLeftLeg.rotateAngleZ = (float)Math.toRadians((double)(-90.0F * var10));
               this.bipedLeftLegwear.rotateAngleX = (float)Math.toRadians((double)(var11 * var10));
               this.bipedLeftLegwear.rotateAngleZ = (float)Math.toRadians((double)(-90.0F * var10));
               this.bipedBody.offsetY = (float)Math.toRadians((double)(40.0F * var10));
               this.bipedLeftArm.offsetY = (float)Math.toRadians((double)(40.0F * var10));
               this.bipedRightArm.offsetY = (float)Math.toRadians((double)(40.0F * var10));
               this.bipedLeftLeg.offsetY = (float)Math.toRadians((double)(40.0F * var10));
               this.bipedRightLeg.offsetY = (float)Math.toRadians((double)(40.0F * var10));
               this.bipedHead.offsetY = (float)Math.toRadians((double)(40.0F * var10));
               this.bipedBodyWear.offsetY = (float)Math.toRadians((double)(40.0F * var10));
               this.bipedLeftArmwear.offsetY = (float)Math.toRadians((double)(40.0F * var10));
               this.bipedRightArmwear.offsetY = (float)Math.toRadians((double)(40.0F * var10));
               this.bipedLeftLegwear.offsetY = (float)Math.toRadians((double)(40.0F * var10));
               this.bipedRightLegwear.offsetY = (float)Math.toRadians((double)(40.0F * var10));
               this.bipedHeadwear.offsetY = (float)Math.toRadians((double)(40.0F * var10));
            }

            if (GuiEmotes.Emote == 5) {
               var11 = -30.0F;
               var12 = 90.0F;
               float var13 = -80.0F;
               this.bipedRightLeg.rotateAngleX = (float)Math.toRadians((double)(var11 * var10));
               this.bipedRightLeg.rotateAngleY = (float)Math.toRadians((double)(90.0F * var10));
               this.bipedRightLegwear.rotateAngleX = (float)Math.toRadians((double)(var11 * var10));
               this.bipedRightLegwear.rotateAngleY = (float)Math.toRadians((double)(90.0F * var10));
               this.bipedLeftLeg.rotateAngleX = (float)Math.toRadians((double)(var11 * var10));
               this.bipedLeftLeg.rotateAngleY = (float)Math.toRadians((double)(-90.0F * var10));
               this.bipedLeftLegwear.rotateAngleX = (float)Math.toRadians((double)(var11 * var10));
               this.bipedLeftLegwear.rotateAngleY = (float)Math.toRadians((double)(-90.0F * var10));
               this.bipedBody.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedLeftArm.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedRightArm.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedLeftLeg.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedRightLeg.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedHead.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedBodyWear.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedLeftArmwear.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedRightArmwear.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedLeftLegwear.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedRightLegwear.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedHeadwear.offsetY = (float)Math.toRadians((double)(var13 * var10));
               this.bipedRightArm.rotateAngleX = (float)Math.toRadians((double)(-30.0F * var10));
               this.bipedRightArm.rotateAngleZ = (float)Math.toRadians((double)(50.0F * var10));
               this.bipedRightArmwear.rotateAngleX = (float)Math.toRadians((double)(-30.0F * var10));
               this.bipedRightArmwear.rotateAngleZ = (float)Math.toRadians((double)(50.0F * var10));
               this.bipedLeftArm.rotateAngleX = (float)Math.toRadians((double)(-30.0F * var10));
               this.bipedLeftArm.rotateAngleZ = (float)Math.toRadians((double)(-50.0F * var10));
               this.bipedLeftArmwear.rotateAngleX = (float)Math.toRadians((double)(-30.0F * var10));
               this.bipedLeftArmwear.rotateAngleZ = (float)Math.toRadians((double)(-50.0F * var10));
            }
         }

         RenderPlayer var14 = (RenderPlayer)Minecraft.getMinecraft().getRenderManager().getEntityRenderObject(var7);
         ModelPlayer var15 = var14.getMainModel();
         copyModelAngles(var15.bipedRightArm, this.bipedRightArm);
         copyModelAngles(var15.bipedLeftArm, this.bipedLeftArm);
         copyModelAngles(var15.bipedHead, this.bipedHead);
         copyModelAngles(var15.bipedHeadwear, this.bipedHeadwear);
         copyModelAngles(this.bipedHead, this.bipedHeadwear);
         if (var9 && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
            var10 = ((float)InputEvent.prevDabbingHeld + (float)(InputEvent.dabbingHeld - InputEvent.prevDabbingHeld) * InputEvent.firstPersonPartialTicks) / 8.0F;
            GlStateManager.rotate(-50.0F * var10, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(30.0F * var10, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(-30.0F * var10, 0.0F, 0.0F, 1.0F);
            GlStateManager.translate(-0.3D * (double)var10, -0.2D * (double)var10, -0.5D * (double)var10);
         }
      }

   }

   public void setLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4) {
      super.setLivingAnimations(var1, var2, var3, var4);
      this.thirdPersonPartialTicks = var4;
   }

   public Dab(ModelBase var1, float var2, boolean var3) {
      super(var2, var3);
      this.oldModel = var1;
   }
}
