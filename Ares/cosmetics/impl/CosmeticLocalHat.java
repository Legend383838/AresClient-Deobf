package Ares.cosmetics.impl;

import Ares.GuiIngameCosmetics;
import Ares.cosmetics.CosmeticBase;
import Ares.cosmetics.CosmeticController;
import Ares.cosmetics.CosmeticModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticLocalHat extends CosmeticBase {
   private static final ResourceLocation REIS = new ResourceLocation("Ares/hut.png");
   private final CosmeticLocalHat.ModelTopHat modelTopHat;
   private static final ResourceLocation TEXTURE = new ResourceLocation("Ares/hat.png");

   public CosmeticLocalHat(RenderPlayer var1) {
      super(var1);
      this.modelTopHat = new CosmeticLocalHat.ModelTopHat(this, var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1.getName().toString().equals(Minecraft.getMinecraft().getSession().getUsername()) && GuiIngameCosmetics.Hatonoff.contains("on") && CosmeticController.shouldRenderTopHat(var1)) {
         GlStateManager.pushMatrix();
         if (var1.getName().toString().equals(Minecraft.getMinecraft().getSession().getUsername())) {
            this.playerRenderer.bindTexture(new ResourceLocation(GuiIngameCosmetics.Hatpath));
         }

         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.225D, 0.0D);
         }

         float[] var9 = CosmeticController.getTopHatColor(var1);
         GL11.glColor3f(var9[0], var9[1], var9[2]);
         this.modelTopHat.render(var1, var2, var3, var5, var6, var7, var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   private class ModelTopHat extends CosmeticModelBase {
      final CosmeticLocalHat this$0;
      private ModelRenderer pointy;
      private ModelRenderer rim;

      public ModelTopHat(CosmeticLocalHat var1, RenderPlayer var2) {
         super(var2);
         this.this$0 = var1;
         this.rim = new ModelRenderer(this.playerModel, 0, 0);
         this.rim.addBox(-5.5F, -9.0F, -5.5F, 11, 2, 11);
         this.pointy = new ModelRenderer(this.playerModel, 0, 13);
         this.pointy.addBox(-3.5F, -17.0F, -3.5F, 7, 8, 7);
      }

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.rim.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.rim.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.rim.rotationPointX = 0.0F;
         this.rim.rotationPointY = 0.0F;
         this.rim.render(var7);
         this.pointy.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.pointy.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.pointy.rotationPointX = 0.0F;
         this.pointy.rotationPointY = 0.0F;
         this.pointy.render(var7);
      }
   }
}
