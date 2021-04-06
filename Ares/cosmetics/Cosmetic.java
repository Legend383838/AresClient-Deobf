package Ares.cosmetics;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

public class Cosmetic {
   protected ModelRenderer bindTextureAndColor1(Color var1, ResourceLocation var2, ModelRenderer var3, ModelRenderer var4) {
      boolean var5 = false;
      if (!var5) {
         Minecraft.getMinecraft().getTextureManager().bindTexture(var2);
      }

      return var3;
   }

   protected ModelRenderer bindTextureAndColor(Color var1, ResourceLocation var2, ModelRenderer var3, ModelRenderer var4) {
      boolean var5 = false;
      if (!var5) {
         Minecraft.getMinecraft().getTextureManager().bindTexture(var2);
      }

      return var3;
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
   }
}
