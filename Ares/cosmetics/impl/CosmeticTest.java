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
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticTest extends CosmeticBase {
   CosmeticTest.BlazeModel blazeModel;

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (GuiIngameCosmetics2.Blaze.contains("on") && var1.getName().equals(Minecraft.getMinecraft().getSession().getUsername())) {
         GlStateManager.pushMatrix();
         this.playerRenderer.bindTexture(new ResourceLocation(GuiIngameCosmetics2.Blazepath));
         float[] var9 = CosmeticController.getTopHatColor(var1);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         this.blazeModel.render(var1, var2, var3, var5, var7, var7, var8);
         GlStateManager.popMatrix();
      }

   }

   public CosmeticTest(RenderPlayer var1) {
      super(var1);
      this.blazeModel = new CosmeticTest.BlazeModel(var1);
   }

   private static class BlazeModel extends CosmeticModelBase {
      private ModelRenderer[] blazeSticks = new ModelRenderer[12];

      public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
         float var8 = var3 * 3.1415927F * -0.1F;

         int var9;
         for(var9 = 0; var9 < 4; ++var9) {
            this.blazeSticks[var9].rotationPointY = -2.0F + MathHelper.cos(((float)(var9 * 2) + var3) * 0.25F);
            this.blazeSticks[var9].rotationPointX = MathHelper.cos(var8) * 9.0F;
            this.blazeSticks[var9].rotationPointZ = MathHelper.sin(var8) * 9.0F;
            ++var8;
         }

         var8 = 0.7853982F + var3 * 3.1415927F * 0.03F;

         for(var9 = 4; var9 < 8; ++var9) {
            this.blazeSticks[var9].rotationPointY = 2.0F + MathHelper.cos(((float)(var9 * 2) + var3) * 0.25F);
            this.blazeSticks[var9].rotationPointX = MathHelper.cos(var8) * 7.0F;
            this.blazeSticks[var9].rotationPointZ = MathHelper.sin(var8) * 7.0F;
            ++var8;
         }

         var8 = 0.47123894F + var3 * 3.1415927F * -0.05F;

         for(var9 = 8; var9 < 12; ++var9) {
            this.blazeSticks[var9].rotationPointY = 11.0F + MathHelper.cos(((float)var9 * 1.5F + var3) * 0.5F);
            this.blazeSticks[var9].rotationPointX = MathHelper.cos(var8) * 5.0F;
            this.blazeSticks[var9].rotationPointZ = MathHelper.sin(var8) * 5.0F;
            ++var8;
         }

      }

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
         ModelRenderer[] var11;
         int var10 = (var11 = this.blazeSticks).length;

         for(int var9 = 0; var9 < var10; ++var9) {
            ModelRenderer var8 = var11[var9];
            var8.render(var7);
         }

      }

      public BlazeModel(RenderPlayer var1) {
         super(var1);

         for(int var2 = 0; var2 < this.blazeSticks.length; ++var2) {
            (this.blazeSticks[var2] = new ModelRenderer(this.playerModel, 0, 16)).addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
         }

      }
   }
}
