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

public class CosmeticEars extends CosmeticBase {
   private final CosmeticEars.ModelEars modelEars;
   private static final ResourceLocation TEXTURE = new ResourceLocation("Ares/ohrenrot.png");

   public CosmeticEars(RenderPlayer var1) {
      super(var1);
      this.modelEars = new CosmeticEars.ModelEars(this, var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if ((var1.getUniqueID().toString().equals("4f-d92454293030") || var1.getUniqueID().toString().equals("f9a4fe88-404b2b5bc37dd7") || var1.getName().toString().equals("") || var1.getName().toString().equals("AresClient") || var1.getName().toString().equals("BannedFromHeavenn")) && CosmeticController.shouldRenderTopHat(var1)) {
         GlStateManager.pushMatrix();
         this.playerRenderer.bindTexture(TEXTURE);
         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.225D, 0.0D);
         }

         float[] var9 = CosmeticController.getTopHatColor(var1);
         GL11.glColor3f(var9[0], var9[1], var9[2]);
         this.modelEars.render(var1, var2, var3, var5, var6, var7, var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   private class ModelEars extends CosmeticModelBase {
      final CosmeticEars this$0;
      private ModelRenderer ear1;
      private ModelRenderer ear2;

      public ModelEars(CosmeticEars var1, RenderPlayer var2) {
         super(var2);
         this.this$0 = var1;
         this.ear1 = new ModelRenderer(this.playerModel, 0, 0);
         this.ear1.addBox(-2.5F, -12.0F, -3.5F, 2, 8, 2);
         this.ear2 = new ModelRenderer(this.playerModel, 0, 0);
         this.ear2.addBox(0.5F, -12.0F, -3.5F, 2, 8, 2);
      }

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.ear1.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.ear1.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.ear1.rotationPointX = 0.0F;
         this.ear1.rotationPointY = 0.0F;
         this.ear1.render(var7);
         this.ear2.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.ear2.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.ear2.rotationPointX = 0.0F;
         this.ear2.rotationPointY = 0.0F;
         this.ear2.render(var7);
      }
   }
}
