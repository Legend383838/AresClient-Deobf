package Ares.cosmetics.impl;

import Ares.cosmetics.CosmeticController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticWing extends ModelBase implements LayerRenderer<AbstractClientPlayer> {
   private ModelRenderer wing;
   private static final ResourceLocation FADE = new ResourceLocation("Ares/wingsfade.png");
   private static final ResourceLocation PINK = new ResourceLocation("Ares/wingspink.png");
   private boolean playerUsesFullHeight;
   private static final ResourceLocation FADERED = new ResourceLocation("Ares/wingsfadered.png");
   private ModelRenderer wingTip;
   private static final ResourceLocation FADEGREEN = new ResourceLocation("Ares/wingsfadegreen.png");
   private Minecraft mc;
   private ResourceLocation location;
   private static final ResourceLocation GNS = new ResourceLocation("Ares/wingsred.png");
   private static final ResourceLocation G = new ResourceLocation("Ares/galaxywings.png");
   private static final ResourceLocation TEXTURE = new ResourceLocation("Ares/wings.png");
   private final RenderPlayer playerRenderer;

   public CosmeticWing(RenderPlayer var1) {
      this.playerRenderer = var1;
      this.mc = Minecraft.getMinecraft();
      this.location = new ResourceLocation("Ares/wings.png");
      this.setTextureOffset("wing.bone", 0, 0);
      this.setTextureOffset("wing.skin", -10, 8);
      this.setTextureOffset("wingtip.bone", 0, 5);
      this.setTextureOffset("wingtip.skin", -10, 18);
      this.wing = new ModelRenderer(this, "wing");
      this.wing.setTextureSize(30, 30);
      this.wing.setRotationPoint(-2.0F, 0.0F, 0.0F);
      this.wing.addBox("bone", -10.0F, -1.0F, -1.0F, 10, 2, 2);
      this.wing.addBox("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
      this.wingTip = new ModelRenderer(this, "wingtip");
      this.wingTip.setTextureSize(30, 30);
      this.wingTip.setRotationPoint(-10.0F, 0.0F, 0.0F);
      this.wingTip.addBox("bone", -10.0F, -0.5F, -0.5F, 10, 1, 1);
      this.wingTip.addBox("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
      this.wing.addChild(this.wingTip);
   }

   private float interpolate(float var1, float var2, float var3) {
      float var4 = (var1 + (var2 - var1) * var3) % 360.0F;
      if (var4 < 0.0F) {
         var4 += 360.0F;
      }

      return var4;
   }

   public boolean shouldCombineTextures() {
      return false;
   }

   public void doRenderLayer(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.doRenderLayer((AbstractClientPlayer)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void doRenderLayer(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (CosmeticController.shouldRenderTopHat(var1) && (var1.getName().equals("") || var1.getName().equals("AresClient") || var1.getName().equals("Reissackk") || var1.getName().equals("x_LegitLauch") || var1.getName().equals("BannedFromHeavenn") || var1.getName().equals("23ZollAufmBenz") || var1.getName().equals("Capslxck"))) {
         double var9 = (double)this.interpolate(var1.prevRenderYawOffset, var1.renderYawOffset, var4);
         GL11.glPushMatrix();
         GL11.glScaled(-1.0D, -1.0D, 1.0D);
         GL11.glTranslated(0.0D, -1.45D, 0.0D);
         GL11.glTranslated(0.0D, 1.3D, 0.2D);
         if (var1.isSneaking()) {
            GlStateManager.translate(0.0F, -0.142F, -0.0178F);
         }

         GL11.glRotated(180.0D, 1.0D, 0.0D, 0.0D);
         GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
         if (var1.getName().equals("remix313") || var1.getName().equals(" ")) {
            this.playerRenderer.bindTexture(G);
         }

         if (var1.getName().equals("x_LegitLauch") || var1.getName().equals("Reissack")) {
            this.playerRenderer.bindTexture(TEXTURE);
         }

         if (var1.getName().equals("BannedFromHeavenn") || var1.getName().equals("AresClient") || var1.getName().equals("23ZollAufmBenz") || var1.getName().equals("xVeniy") || var1.getName().equals("Capslxck")) {
            this.playerRenderer.bindTexture(GNS);
         }

         if (var1.getName().equals("GreenWings") || var1.getName().equals(" ")) {
            this.playerRenderer.bindTexture(FADEGREEN);
         }

         for(int var11 = 0; var11 < 2; ++var11) {
            GL11.glEnable(2884);
            float var12 = (float)(System.currentTimeMillis() % 1000L) / 1000.0F * 3.1415927F * 2.0F;
            this.wing.rotateAngleX = (float)Math.toRadians(-80.0D) - (float)Math.cos((double)var12) * 0.2F;
            this.wing.rotateAngleY = (float)Math.toRadians(20.0D) + (float)Math.sin((double)var12) * 0.4F;
            this.wing.rotateAngleZ = (float)Math.toRadians(20.0D);
            this.wingTip.rotateAngleZ = -((float)(Math.sin((double)(var12 + 2.0F)) + 0.5D)) * 0.75F;
            this.wing.render(0.0625F);
            GL11.glScalef(-1.0F, 1.0F, 1.0F);
            if (var11 == 0) {
               GL11.glCullFace(1028);
            }
         }

         GL11.glCullFace(1029);
         GL11.glDisable(2884);
         GL11.glColor3f(255.0F, 255.0F, 255.0F);
         GL11.glPopMatrix();
      }

   }
}
