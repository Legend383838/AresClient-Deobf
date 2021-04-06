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

public class CosmeticShield extends CosmeticBase {
   private static final ResourceLocation TEXTURE = new ResourceLocation("Ares/Shieldrot.png");
   private final CosmeticShield.ModelShield modelShield;
   private static final ResourceLocation TEXTURE1 = new ResourceLocation("Ares/ugly.png");

   public CosmeticShield(RenderPlayer var1) {
      super(var1);
      this.modelShield = new CosmeticShield.ModelShield(this, var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (GuiIngameCosmetics2.Shield.contains("on") && var1.getName().toString().equals(Minecraft.getMinecraft().getSession().getUsername()) && CosmeticController.shouldRenderTopHat(var1)) {
         GlStateManager.pushMatrix();
         this.playerRenderer.bindTexture(new ResourceLocation(GuiIngameCosmetics2.Shieldpath));
         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.225D, 0.0D);
         }

         float[] var9 = CosmeticController.getTopHatColor(var1);
         GL11.glColor3f(var9[0], var9[1], var9[2]);
         this.modelShield.render(var1, var2, var3, var5, var6, var7, var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   private class ModelShield extends CosmeticModelBase {
      final CosmeticShield this$0;
      private ModelRenderer Shield;

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.Shield.rotateAngleX = this.playerModel.bipedLeftArm.rotateAngleX;
         this.Shield.rotateAngleY = this.playerModel.bipedLeftArm.rotateAngleY;
         this.Shield.rotationPointX = 0.0F;
         this.Shield.rotationPointY = 0.0F;
         this.Shield.render(var7);
      }

      public ModelShield(CosmeticShield var1, RenderPlayer var2) {
         super(var2);
         this.this$0 = var1;
         this.Shield = new ModelRenderer(this.playerModel, 0, 0);
         this.Shield.addBox(7.5F, 3.0F, -6.0F, 1, 12, 12);
      }
   }
}
