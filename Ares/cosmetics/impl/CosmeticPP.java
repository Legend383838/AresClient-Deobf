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

public class CosmeticPP extends CosmeticBase {
   private static final ResourceLocation TEXTURE = new ResourceLocation("Ares/Ohrenrosa.png");
   private final CosmeticPP.ModelPP modelPP;

   public CosmeticPP(RenderPlayer var1) {
      super(var1);
      this.modelPP = new CosmeticPP.ModelPP(this, var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if ((var1.getName().toString().equals("AresClientt") || var1.getName().toString().equals("PP")) && CosmeticController.shouldRenderTopHat(var1)) {
         GlStateManager.pushMatrix();
         this.playerRenderer.bindTexture(TEXTURE);
         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.225D, 0.0D);
         }

         float[] var9 = CosmeticController.getTopHatColor(var1);
         GL11.glColor3f(var9[0], var9[1], var9[2]);
         this.modelPP.render(var1, var2, var3, var5, var6, var7, var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   private class ModelPP extends CosmeticModelBase {
      final CosmeticPP this$0;
      private ModelRenderer rim;

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.rim.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.rim.rotateAngleY = this.playerModel.bipedBody.rotateAngleY;
         this.rim.rotationPointX = 0.0F;
         this.rim.rotationPointY = 0.0F;
         this.rim.render(var7);
      }

      public ModelPP(CosmeticPP var1, RenderPlayer var2) {
         super(var2);
         this.this$0 = var1;
         this.rim = new ModelRenderer(this.playerModel, 0, 0);
         this.rim.addBox(-1.0F, 11.0F, -10.0F, 2, 2, 11);
      }
   }
}
