package Ares.cosmetics.impl;

import Ares.GuiIngameCosmetics2;
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

public class CosmeticSusanoo extends CosmeticBase {
   private static final ResourceLocation TEXTURE = new ResourceLocation("Ares/Ohrenrosa.png");
   private final CosmeticSusanoo.ModelSusanoo modelSusanoo;

   public CosmeticSusanoo(RenderPlayer var1) {
      super(var1);
      this.modelSusanoo = new CosmeticSusanoo.ModelSusanoo(this, var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float[] var9;
      if (GuiIngameCosmetics2.Susanoo.contains("on") && var1.getName().toString().equals(Minecraft.getMinecraft().getSession().getUsername()) && CosmeticController.shouldRenderTopHat(var1)) {
         GlStateManager.pushMatrix();
         this.playerRenderer.bindTexture(new ResourceLocation(GuiIngameCosmetics2.Susanoopath));
         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.225D, 0.0D);
         }

         var9 = CosmeticController.getTopHatColor(var1);
         GL11.glColor3f(var9[0], var9[1], var9[2]);
         this.modelSusanoo.render(var1, var2, var3, var5, var6, var7, var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

      if (var1.getName().toString().equals("Reissacck") && CosmeticController.shouldRenderTopHat(var1)) {
         GlStateManager.pushMatrix();
         this.playerRenderer.bindTexture(new ResourceLocation("Susanoo/Susanoo1.png"));
         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.225D, 0.0D);
         }

         var9 = CosmeticController.getTopHatColor(var1);
         GL11.glColor3f(var9[0], var9[1], var9[2]);
         this.modelSusanoo.render(var1, var2, var3, var5, var6, var7, var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   private class ModelSusanoo extends CosmeticModelBase {
      private ModelRenderer claw2;
      private ModelRenderer ecke5;
      private ModelRenderer seite5;
      private ModelRenderer ecke3;
      private ModelRenderer claw3;
      private ModelRenderer seite1;
      private ModelRenderer seite2;
      private ModelRenderer seite6;
      private ModelRenderer ecke6;
      private ModelRenderer ecke2;
      private ModelRenderer claw1;
      private ModelRenderer seite4;
      private ModelRenderer seite;
      final CosmeticSusanoo this$0;
      private ModelRenderer ecke1;
      private ModelRenderer ecke4;
      private ModelRenderer seite3;

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.claw1.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.claw1.rotateAngleY = this.playerModel.bipedBody.rotateAngleY;
         this.claw1.rotationPointX = 0.0F;
         this.claw1.rotationPointY = 0.0F;
         this.claw1.render(var7);
         this.claw2.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.claw2.rotateAngleY = this.playerModel.bipedBody.rotateAngleY;
         this.claw2.rotationPointX = 0.0F;
         this.claw2.rotationPointY = 0.0F;
         this.claw2.render(var7);
         this.claw3.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.claw3.rotateAngleY = this.playerModel.bipedBody.rotateAngleY;
         this.claw3.rotationPointX = 0.0F;
         this.claw3.rotationPointY = 0.0F;
         this.claw3.render(var7);
         Float var8 = 45.0F;
         Float var9 = 0.0F;
         this.ecke1.rotateAngleX = this.playerModel.bipedBody.rotateAngleX + var9;
         this.ecke1.rotateAngleY = this.playerModel.bipedBody.rotateAngleY + var8;
         this.ecke1.rotationPointX = 3.0F;
         this.ecke1.rotationPointY = 0.0F;
         this.ecke1.render(var7);
         this.ecke2.rotateAngleX = this.playerModel.bipedBody.rotateAngleX + var9;
         this.ecke2.rotateAngleY = this.playerModel.bipedBody.rotateAngleY + var8;
         this.ecke2.rotationPointX = 3.0F;
         this.ecke2.rotationPointY = 0.0F;
         this.ecke2.render(var7);
         this.ecke3.rotateAngleX = this.playerModel.bipedBody.rotateAngleX + var9;
         this.ecke3.rotateAngleY = this.playerModel.bipedBody.rotateAngleY + var8;
         this.ecke3.rotationPointX = 3.0F;
         this.ecke3.rotationPointY = 0.0F;
         this.ecke3.render(var7);
         float var10 = -180.0F;
         this.ecke4.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.ecke4.rotateAngleY = this.playerModel.bipedBody.rotateAngleY + var10;
         this.ecke4.rotationPointX = 4.5F;
         this.ecke4.rotationPointY = 0.0F;
         this.ecke4.render(var7);
         this.ecke5.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.ecke5.rotateAngleY = this.playerModel.bipedBody.rotateAngleY + var10;
         this.ecke5.rotationPointX = 4.5F;
         this.ecke5.rotationPointY = 0.0F;
         this.ecke5.render(var7);
         this.ecke6.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.ecke6.rotateAngleY = this.playerModel.bipedBody.rotateAngleY + var10;
         this.ecke6.rotationPointX = 4.5F;
         this.ecke6.rotationPointY = 0.0F;
         this.ecke6.render(var7);
         this.seite1.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.seite1.rotateAngleY = this.playerModel.bipedBody.rotateAngleY;
         this.seite1.rotationPointX = 0.0F;
         this.seite1.rotationPointY = 0.0F;
         this.seite1.render(var7);
         this.seite2.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.seite2.rotateAngleY = this.playerModel.bipedBody.rotateAngleY;
         this.seite2.rotationPointX = 0.0F;
         this.seite2.rotationPointY = 0.0F;
         this.seite2.render(var7);
         this.seite3.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.seite3.rotateAngleY = this.playerModel.bipedBody.rotateAngleY;
         this.seite3.rotationPointX = 0.0F;
         this.seite3.rotationPointY = 0.0F;
         this.seite3.render(var7);
         this.seite4.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.seite4.rotateAngleY = this.playerModel.bipedBody.rotateAngleY;
         this.seite4.rotationPointX = 0.0F;
         this.seite4.rotationPointY = 0.0F;
         this.seite4.render(var7);
         this.seite5.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.seite5.rotateAngleY = this.playerModel.bipedBody.rotateAngleY;
         this.seite5.rotationPointX = 0.0F;
         this.seite5.rotationPointY = 0.0F;
         this.seite5.render(var7);
         this.seite6.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.seite6.rotateAngleY = this.playerModel.bipedBody.rotateAngleY;
         this.seite6.rotationPointX = 0.0F;
         this.seite6.rotationPointY = 0.0F;
         this.seite6.render(var7);
         this.seite.rotateAngleX = this.playerModel.bipedBody.rotateAngleX;
         this.seite.rotateAngleY = this.playerModel.bipedBody.rotateAngleY;
         this.seite.rotationPointX = 0.0F;
         this.seite.rotationPointY = 0.0F;
         this.seite.render(var7);
      }

      public ModelSusanoo(CosmeticSusanoo var1, RenderPlayer var2) {
         super(var2);
         this.this$0 = var1;
         this.claw1 = new ModelRenderer(this.playerModel, 0, 0);
         this.claw1.addBox(-5.0F, 6.0F, 5.0F, 10, 2, 2);
         this.claw2 = new ModelRenderer(this.playerModel, 0, 0);
         this.claw2.addBox(-5.0F, 12.0F, 5.0F, 10, 2, 2);
         this.claw3 = new ModelRenderer(this.playerModel, 0, 0);
         this.claw3.addBox(-5.0F, 0.0F, 5.0F, 10, 2, 2);
         float var3 = 5.0F;
         float var4 = -3.0F;
         this.ecke1 = new ModelRenderer(this.playerModel, 0, 0);
         this.ecke1.addBox(-10.0F + var3, 6.0F, 3.5F, 5, 2, 2);
         this.ecke2 = new ModelRenderer(this.playerModel, 0, 0);
         this.ecke2.addBox(-10.0F + var3, 12.0F, 3.5F, 5, 2, 2);
         this.ecke3 = new ModelRenderer(this.playerModel, 0, 0);
         this.ecke3.addBox(-10.0F + var3, 0.0F, 3.5F, 5, 2, 2);
         float var5 = 10.0F;
         float var6 = 3.0F;
         this.ecke4 = new ModelRenderer(this.playerModel, 0, 0);
         this.ecke4.addBox(-10.0F + var5, 6.0F, -12.0F, 5, 2, 2);
         this.ecke5 = new ModelRenderer(this.playerModel, 0, 0);
         this.ecke5.addBox(-10.0F + var5, 12.0F, -12.0F, 5, 2, 2);
         this.ecke6 = new ModelRenderer(this.playerModel, 0, 0);
         this.ecke6.addBox(-10.0F + var5, 0.0F, -12.0F, 5, 2, 2);
         byte var7 = 7;
         this.seite1 = new ModelRenderer(this.playerModel, 0, 0);
         this.seite1.addBox(-8.0F, 6.0F, -4.0F, 2, 2, var7);
         this.seite2 = new ModelRenderer(this.playerModel, 0, 0);
         this.seite2.addBox(-8.0F, 12.0F, -4.0F, 2, 2, var7);
         this.seite3 = new ModelRenderer(this.playerModel, 0, 0);
         this.seite3.addBox(-8.0F, 0.0F, -4.0F, 2, 2, var7);
         this.seite4 = new ModelRenderer(this.playerModel, 0, 0);
         this.seite4.addBox(5.5F, 6.0F, -4.0F, 2, 2, var7);
         this.seite5 = new ModelRenderer(this.playerModel, 0, 0);
         this.seite5.addBox(5.5F, 12.0F, -4.0F, 2, 2, var7);
         this.seite6 = new ModelRenderer(this.playerModel, 0, 0);
         this.seite6.addBox(5.5F, 0.0F, -4.0F, 2, 2, var7);
         this.seite = new ModelRenderer(this.playerModel, 0, 0);
         this.seite.addBox(-1.0F, -0.0F, 3.5F, 2, 15, 2);
      }
   }
}
