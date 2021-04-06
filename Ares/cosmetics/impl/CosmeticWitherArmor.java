package Ares.cosmetics.impl;

import Ares.GuiIngameCosmetics3;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class CosmeticWitherArmor implements LayerRenderer<AbstractClientPlayer> {
   private final ModelPlayer playerModel;
   private static final ResourceLocation WITHER_ARMOR = new ResourceLocation("textures/entity/wither/wither_armor.png");
   private final RenderPlayer renderPlayer;

   public boolean shouldCombineTextures() {
      return false;
   }

   public void doRenderLayer(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.doRenderLayer((AbstractClientPlayer)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public CosmeticWitherArmor(RenderPlayer var1) {
      this.renderPlayer = var1;
      this.playerModel = var1.getMainModel();
   }

   public void doRenderLayer(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1.getName().toString().equals(Minecraft.getMinecraft().getSession().getUsername()) && GuiIngameCosmetics3.Wither.contains("on")) {
         GlStateManager.depthMask(!var1.isInvisible());
         this.renderPlayer.bindTexture(WITHER_ARMOR);
         GlStateManager.matrixMode(5890);
         GlStateManager.loadIdentity();
         float var9 = (float)var1.ticksExisted + var4;
         float var10 = MathHelper.cos(var9 * 0.004F) * 3.0F;
         float var11 = var9 * 0.004F;
         GlStateManager.translate(var10, var11, 0.0F);
         GlStateManager.matrixMode(5888);
         GlStateManager.enableBlend();
         float var12 = 0.5F;
         GlStateManager.color(0.5F, 0.0F, 0.5F, 1.0F);
         GlStateManager.disableLighting();
         GlStateManager.blendFunc(1, 1);
         this.playerModel.setLivingAnimations(var1, var2, var3, var4);
         this.playerModel.setModelAttributes(this.renderPlayer.getMainModel());
         this.playerModel.render(var1, var2, var3, var5, var6, var7, var8);
         GlStateManager.matrixMode(5890);
         GlStateManager.loadIdentity();
         GlStateManager.matrixMode(5888);
         GlStateManager.enableLighting();
         GlStateManager.disableBlend();
      }

   }
}
