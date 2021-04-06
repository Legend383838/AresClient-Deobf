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

public class CosmeticCrown extends CosmeticBase {
   private static final ResourceLocation TEXTUREBlack = new ResourceLocation("Ares/crownblack.png");
   private static final ResourceLocation TEXTUREWhite = new ResourceLocation("Ares/crownwhite.png");
   private final CosmeticCrown.ModelCrown modelCrown;
   private static final ResourceLocation TEXTURE = new ResourceLocation("Ares/crown.png");

   public CosmeticCrown(RenderPlayer var1) {
      super(var1);
      this.modelCrown = new CosmeticCrown.ModelCrown(this, var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if ((var1.getName().toString().equals("AresClient") || var1.getName().toString().equals("Crown1") || var1.getName().toString().equals("Jannickill") || var1.getName().toString().equals("Crown2") || var1.getName().toString().equals("QuantenHD") || var1.getName().toString().equals("Crown3")) && CosmeticController.shouldRenderTopHat(var1)) {
         GlStateManager.pushMatrix();
         if (var1.getName().toString().equals("AresClient") || var1.getName().toString().equals("Crown1")) {
            this.playerRenderer.bindTexture(TEXTURE);
         }

         if (var1.getName().toString().equals("Jannickill") || var1.getName().toString().equals("Crown2")) {
            this.playerRenderer.bindTexture(TEXTUREBlack);
         }

         if (var1.getName().toString().equals("QuantenHD") || var1.getName().toString().equals("Crown3")) {
            this.playerRenderer.bindTexture(TEXTUREWhite);
         }

         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.225D, 0.0D);
         }

         float[] var9 = CosmeticController.getTopHatColor(var1);
         GL11.glColor3f(var9[0], var9[1], var9[2]);
         this.modelCrown.render(var1, var2, var3, var5, var6, var7, var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   private class ModelCrown extends CosmeticModelBase {
      private ModelRenderer band4;
      final CosmeticCrown this$0;
      private ModelRenderer band3;
      private ModelRenderer band1;
      private ModelRenderer band2;

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.band1.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.band1.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.band1.rotationPointX = 0.0F;
         this.band1.rotationPointY = 0.0F;
         this.band1.render(var7);
         this.band2.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.band2.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.band2.rotationPointX = 0.0F;
         this.band2.rotationPointY = 0.0F;
         this.band2.render(var7);
         this.band3.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.band3.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.band3.rotationPointX = 0.0F;
         this.band3.rotationPointY = 0.0F;
         this.band3.render(var7);
         this.band4.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.band4.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.band4.rotationPointX = 0.0F;
         this.band4.rotationPointY = 0.0F;
         this.band4.render(var7);
      }

      public ModelCrown(CosmeticCrown var1, RenderPlayer var2) {
         super(var2);
         this.this$0 = var1;
         this.band1 = new ModelRenderer(this.playerModel, 0, 0);
         this.band1.addBox(-4.5F, -9.0F, -4.7F, 9, 5, 1);
         this.band2 = new ModelRenderer(this.playerModel, 0, 0);
         this.band2.addBox(3.5F, -9.0F, -3.5F, 1, 5, 8);
         this.band3 = new ModelRenderer(this.playerModel, 0, 0);
         this.band3.addBox(-4.5F, -9.0F, -3.5F, 1, 5, 8);
         this.band4 = new ModelRenderer(this.playerModel, 0, 0);
         this.band4.addBox(-4.5F, -9.0F, 4.0F, 9, 5, 1);
      }
   }
}
