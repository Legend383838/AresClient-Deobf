package Ares.cosmetics.impl;

import Ares.cosmetics.CosmeticBase;
import Ares.cosmetics.CosmeticController;
import Ares.cosmetics.CosmeticModelBase;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticHalo1 extends CosmeticBase {
   private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("piccadilly/cosmetics/halo.png");
   private final CosmeticHalo1.ModelHalo modelHalo;

   public CosmeticHalo1(RenderPlayer var1) {
      super(var1);
      this.modelHalo = new CosmeticHalo1.ModelHalo(this, var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (CosmeticController.shouldRenderTopHat(var1)) {
         GlStateManager.pushMatrix();
         this.playerRenderer.bindTexture(new ResourceLocation("piccadilly/cosmetics/halo.png"));
         float[] var9 = CosmeticController.getHaloColor(var1);
         GL11.glColor3f(var9[0], var9[1], var9[2]);
         this.modelHalo.render(var1, var2, var3, var5, var6, var7, var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   static ResourceLocation access$0() {
      return RESOURCE_LOCATION;
   }

   private class ModelHalo extends CosmeticModelBase {
      final CosmeticHalo1 this$0;
      private ModelRenderer halo;
      private boolean hat;

      private Color getColor() {
         return Color.GREEN;
      }

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         GlStateManager.pushMatrix();
         float var8 = (float)Math.cos((double)var4 / 10.0D) / 20.0F;
         GlStateManager.rotate(var5 + var4 / 2.0F, 0.0F, 1.0F, 0.0F);
         GlStateManager.translate(0.0F, var8 - (this.isHat() ? 0.2F : 0.0F), 0.0F);
         Minecraft.getMinecraft().getTextureManager().bindTexture(CosmeticHalo1.access$0());
         GlStateManager.disableLighting();

         for(int var9 = 0; var9 < 4; ++var9) {
            GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
         }

         GlStateManager.enableLighting();
         GlStateManager.popMatrix();
      }

      public ModelHalo(CosmeticHalo1 var1, RenderPlayer var2) {
         super(var2);
         this.this$0 = var1;
         this.hat = true;
         Minecraft.getMinecraft().getTextureManager().bindTexture(CosmeticHalo1.access$0());
         this.halo.addBox(-3.0F, -12.5F, -4.0F, 6, 1, 1, 0.15F);
         this.halo.isHidden = true;
      }

      public boolean isHat() {
         return this.hat;
      }
   }
}
