package Ares.cosmetics.impl;

import Ares.OBJ.OBJLoader;
import Ares.OBJ.Obj;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class FoxHat {
   OBJLoader loader = new OBJLoader();

   public void render(Entity var1, ModelRenderer var2) {
      byte var3 = 3;
      if (var3 == 2) {
         GlStateManager.pushMatrix();
         if (var1.isSneaking()) {
            GlStateManager.translate(0.0D, 0.05D, 0.0D);
         }

         if (var2.rotateAngleZ != 0.0F) {
            GlStateManager.rotate(var2.rotateAngleZ * 57.295776F, 0.0F, 0.0F, 1.0F);
         }

         if (var2.rotateAngleY != 0.0F) {
            GlStateManager.rotate(var2.rotateAngleY * 57.295776F, 0.0F, 1.0F, 0.0F);
         }

         if (var2.rotateAngleX != 0.0F) {
            GlStateManager.rotate(var2.rotateAngleX * 57.295776F, 1.0F, 0.0F, 0.0F);
         }

         GlStateManager.translate(-0.0D, -0.3499999940395355D, 0.01D);
         GlStateManager.rotate(-180.0F, 40.0F, 0.0F, 0.0F);
         GlStateManager.scale(0.15F, 0.15F, 0.15F);
         Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Ares/fox.png"));
         this.loader.render((Obj)this.loader.loaded.get("fox"));
         GlStateManager.popMatrix();
      }

   }
}
