package Ares.cosmetics.impl;

import Ares.GuiIngameCosmetics2;
import Ares.cosmetics.CosmeticBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class CosmeticAura extends CosmeticBase {
   public CosmeticAura(RenderPlayer var1) {
      super(var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (GuiIngameCosmetics2.Blaze.contains("on") && var1.getName().equals(Minecraft.getMinecraft().getSession().getUsername())) {
         GlStateManager.pushMatrix();
         new ItemStack(Items.carrot);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GlStateManager.popMatrix();
      }

   }
}
