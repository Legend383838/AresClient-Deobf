package Ares.emote;

import Ares.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class tpose extends ModelPlayer {
   private float thirdPersonPartialTicks2;
   private ModelBase oldModel;

   public void setLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4) {
      super.setLivingAnimations(var1, var2, var3, var4);
      this.thirdPersonPartialTicks2 = var4;
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
      float var8 = (float)var7.getEntityId();
      boolean var9 = var8 == (float)Minecraft.getMinecraft().thePlayer.getEntityId();
      if (Client.getInstance().tpose || var9 && InputEvent.prevtposingHeld > 0) {
         float var10 = ((float)InputEvent.prevtposingHeld + (float)(InputEvent.tposingHeld - InputEvent.prevtposingHeld) * this.thirdPersonPartialTicks2) / 8.0F;
         if (!var9) {
            var10 = 1.0F;
         }

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
         float var11 = var7.rotationPitch;
         this.bipedHead.rotateAngleX = (float)Math.toRadians((double)(-var11 * var10)) + (float)Math.toRadians((double)(45.0F * var10 + var11));
         float var12 = ((EntityPlayer)var7).renderYawOffset - var7.rotationYaw;
         this.bipedHead.rotateAngleY = (float)Math.toRadians((double)(var12 * var10)) + (float)Math.toRadians((double)(35.0F * var10 - var12));
         RenderPlayer var13 = (RenderPlayer)Minecraft.getMinecraft().getRenderManager().getEntityRenderObject(var7);
         ModelPlayer var14 = var13.getMainModel();
         copyModelAngles(var14.bipedRightArm, this.bipedRightArm);
         copyModelAngles(var14.bipedLeftArm, this.bipedLeftArm);
         copyModelAngles(var14.bipedHead, this.bipedHead);
         copyModelAngles(var14.bipedHeadwear, this.bipedHeadwear);
         copyModelAngles(this.bipedHead, this.bipedHeadwear);
         if (var9 && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
            var10 = ((float)InputEvent.prevtposingHeld + (float)(InputEvent.tposingHeld - InputEvent.prevtposingHeld) * InputEvent.firstPersonPartialTicks2) / 8.0F;
            GlStateManager.rotate(-50.0F * var10, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(30.0F * var10, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(-30.0F * var10, 0.0F, 0.0F, 1.0F);
            GlStateManager.translate(-0.3D * (double)var10, -0.2D * (double)var10, -0.5D * (double)var10);
         }
      }

   }

   public tpose(ModelBase var1, float var2, boolean var3) {
      super(var2, var3);
      this.oldModel = var1;
   }
}
