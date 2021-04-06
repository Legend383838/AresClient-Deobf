package Ares.cosmetics.impl;

import Ares.GuiIngameCosmetics3;
import Ares.cosmetics.CosmeticBase;
import Ares.cosmetics.CosmeticController;
import Ares.cosmetics.CosmeticModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticWitchHat extends CosmeticBase {
   private final CosmeticWitchHat.ModelWitchHat modelWitchHat;

   public CosmeticWitchHat(RenderPlayer var1) {
      super(var1);
      this.modelWitchHat = new CosmeticWitchHat.ModelWitchHat(this, var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float[] var9;
      if (CosmeticController.shouldRenderTopHat(var1) && GuiIngameCosmetics3.WitchHat.contains("on") && var1.getName().equals(Minecraft.getMinecraft().getSession().getUsername())) {
         GL11.glPushMatrix();
         this.playerRenderer.bindTexture(new ResourceLocation(GuiIngameCosmetics3.WitchHatPath));
         var9 = CosmeticController.getTopHatColor(var1);
         GL11.glColor3f(var9[0], var9[1], var9[2]);
         this.modelWitchHat.render(var1, var2, var3, var5, var6, var7, var8);
         GL11.glPopMatrix();
      } else if (var1.getName().equals("Mismatch")) {
         GL11.glPushMatrix();
         this.playerRenderer.bindTexture(new ResourceLocation(GuiIngameCosmetics3.WitchHatPath));
         var9 = CosmeticController.getTopHatColor(var1);
         GL11.glColor3f(var9[0], var9[1], var9[2]);
         this.modelWitchHat.render(var1, var2, var3, var5, var6, var7, var8);
         GL11.glPopMatrix();
      }

   }

   private class ModelWitchHat extends CosmeticModelBase {
      final CosmeticWitchHat this$0;
      private ModelRenderer witchHat;

      public ModelWitchHat(CosmeticWitchHat var1, RenderPlayer var2) {
         super(var2);
         this.this$0 = var1;
         ModelBiped var3 = new ModelBiped();
         this.witchHat = (new ModelRenderer(var3)).setTextureSize(40, 34);
         this.witchHat.setRotationPoint(-5.0F, -10.03125F, -5.0F);
         this.witchHat.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 10, 2, 10);
         ModelRenderer var4 = (new ModelRenderer(var3)).setTextureSize(40, 34);
         var4.setRotationPoint(1.75F, -4.0F, 2.0F);
         var4.setTextureOffset(0, 12).addBox(0.0F, 0.0F, 0.0F, 7, 4, 7);
         var4.rotateAngleX = -0.05235988F;
         var4.rotateAngleZ = 0.02617994F;
         this.witchHat.addChild(var4);
         ModelRenderer var5 = (new ModelRenderer(var3)).setTextureSize(40, 34);
         var5.setRotationPoint(1.75F, -4.0F, 2.0F);
         var5.setTextureOffset(0, 23).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
         var5.rotateAngleX = -0.10471976F;
         var5.rotateAngleZ = 0.05235988F;
         var4.addChild(var5);
         ModelRenderer var6 = (new ModelRenderer(var3)).setTextureSize(40, 34);
         var6.setRotationPoint(1.75F, -2.0F, 2.0F);
         var6.setTextureOffset(0, 31).addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.25F);
         var6.rotateAngleX = -0.20943952F;
         var6.rotateAngleZ = 0.10471976F;
         var5.addChild(var6);
         this.witchHat.isHidden = true;
      }

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         GlStateManager.pushMatrix();
         float var8 = 0.995F;
         GlStateManager.scale(var8, var8, var8);
         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.325D, 0.0D);
         }

         GlStateManager.rotate(var5, 0.0F, 1.0F, 0.0F);
         GlStateManager.rotate(var6, 1.0F, 0.0F, 0.0F);
         this.witchHat.isHidden = false;
         this.witchHat.render(var7);
         this.witchHat.isHidden = true;
         GlStateManager.popMatrix();
      }
   }
}
