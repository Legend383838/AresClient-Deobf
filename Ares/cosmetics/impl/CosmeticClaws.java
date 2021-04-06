package Ares.cosmetics.impl;

import Ares.cosmetics.CosmeticBase;
import Ares.cosmetics.CosmeticController;
import Ares.cosmetics.CosmeticModelBase;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticClaws extends CosmeticBase {
   private static final ResourceLocation TEXTURE = new ResourceLocation("Ares/Ohrenrosa.png");
   private final CosmeticClaws.ModelClaws modelClaws;

   public CosmeticClaws(RenderPlayer var1) {
      super(var1);
      this.modelClaws = new CosmeticClaws.ModelClaws(this, var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if ((var1.getUniqueID().toString().equals("") || var1.getUniqueID().toString().equals("") || var1.getName().toString().equals("test") || var1.getName().toString().equals("NotReady")) && CosmeticController.shouldRenderTopHat(var1)) {
         GlStateManager.pushMatrix();
         this.playerRenderer.bindTexture(TEXTURE);
         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.225D, 0.0D);
         }

         float[] var9 = CosmeticController.getTopHatColor(var1);
         GL11.glColor3f(var9[0], var9[1], var9[2]);
         this.modelClaws.render(var1, var2, var3, var5, var6, var7, var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   private class ModelClaws extends CosmeticModelBase {
      private ModelRenderer claw2;
      private ModelRenderer claw3;
      final CosmeticClaws this$0;
      private ModelRenderer claw1;

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.claw1.rotateAngleX = this.playerModel.bipedRightArm.rotateAngleX;
         this.claw1.rotateAngleY = this.playerModel.bipedRightArm.rotateAngleY;
         this.claw1.rotationPointX = 0.0F;
         this.claw1.rotationPointY = 0.0F;
         this.claw1.render(var7);
         this.claw2.rotateAngleX = this.playerModel.bipedRightArm.rotateAngleX;
         this.claw2.rotateAngleY = this.playerModel.bipedRightArm.rotateAngleY;
         this.claw2.rotationPointX = 0.0F;
         this.claw2.rotationPointY = 0.0F;
         this.claw2.render(var7);
         this.claw3.rotateAngleX = this.playerModel.bipedRightArm.rotateAngleX;
         this.claw3.rotateAngleY = this.playerModel.bipedRightArm.rotateAngleY;
         this.claw3.rotationPointX = 0.0F;
         this.claw3.rotationPointY = 0.0F;
         this.claw3.render(var7);
      }

      public ModelClaws(CosmeticClaws var1, RenderPlayer var2) {
         super(var2);
         this.this$0 = var1;
         this.claw1 = new ModelRenderer(this.playerModel, 0, 0);
         this.claw1.addBox(-7.5F, 6.0F, 0.0F, 1, 8, 1);
         this.claw2 = new ModelRenderer(this.playerModel, 0, 0);
         this.claw2.addBox(-6.0F, 6.0F, 0.0F, 1, 8, 1);
         this.claw3 = new ModelRenderer(this.playerModel, 0, 0);
         this.claw3.addBox(-4.5F, 6.0F, 0.0F, 1, 8, 1);
      }
   }
}
