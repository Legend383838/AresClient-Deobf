package Ares.mods.impl;

import Ares.GuiColor;
import Ares.GuiIngameMods;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class ModPotionStatus extends ModDraggable {
   protected FontRenderer fontRendererObj;
   protected float zLevelFloat;

   public void render(ScreenPosition var1) {
      if (GuiIngameMods.Potion.contains("on")) {
         byte var2 = 21;
         byte var3 = 14;
         boolean var4 = true;
         int var5 = 16;
         Collection var6 = this.mc.thePlayer.getActivePotionEffects();
         if (!var6.isEmpty()) {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableLighting();
            int var7 = 33;
            if (var6.size() > 5) {
               var7 = 132 / (var6.size() - 1);
            }

            for(Iterator var9 = this.mc.thePlayer.getActivePotionEffects().iterator(); var9.hasNext(); var5 += var7) {
               PotionEffect var8 = (PotionEffect)var9.next();
               Potion var10 = Potion.potionTypes[var8.getPotionID()];
               GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
               if (var10.hasStatusIcon()) {
                  Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
                  int var11 = var10.getStatusIconIndex();
                  this.drawTexturedModalRect(var1.getAbsoluteX() + var2 - 20, var1.getAbsoluteY() + var5 - var3, 0 + var11 % 8 * 18, 198 + var11 / 8 * 18, 18, 18);
               }

               String var13 = I18n.format(var10.getName(), new Object[0]);
               if (var8.getAmplifier() == 1) {
                  var13 = var13 + " " + I18n.format("enchantment.level.2", new Object[0]);
               } else if (var8.getAmplifier() == 2) {
                  var13 = var13 + " " + I18n.format("enchantment.level.3", new Object[0]);
               } else if (var8.getAmplifier() == 3) {
                  var13 = var13 + " " + I18n.format("enchantment.level.4", new Object[0]);
               }

               this.font.drawString(GuiColor.Color + var13, (float)(var1.getAbsoluteX() + var2), (float)(var1.getAbsoluteY() + var5 - var3), 16777215, true);
               String var12 = Potion.getDurationString(var8);
               this.font.drawString(GuiColor.Color + var12, (float)(var1.getAbsoluteX() + var2), (float)(var1.getAbsoluteY() + var5 + 10 - var3), 8355711, true);
            }
         }
      }

   }

   public void drawTexturedModalRect(int var1, int var2, int var3, int var4, int var5, int var6) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      Tessellator var9 = Tessellator.getInstance();
      WorldRenderer var10 = var9.getWorldRenderer();
      var10.begin(7, DefaultVertexFormats.POSITION_TEX);
      var10.pos((double)var1, (double)(var2 + var6), (double)this.zLevelFloat).tex((double)((float)var3 * var7), (double)((float)(var4 + var6) * var8)).endVertex();
      var10.pos((double)(var1 + var5), (double)(var2 + var6), (double)this.zLevelFloat).tex((double)((float)(var3 + var5) * var7), (double)((float)(var4 + var6) * var8)).endVertex();
      var10.pos((double)(var1 + var5), (double)var2, (double)this.zLevelFloat).tex((double)((float)(var3 + var5) * var7), (double)((float)var4 * var8)).endVertex();
      var10.pos((double)var1, (double)var2, (double)this.zLevelFloat).tex((double)((float)var3 * var7), (double)((float)var4 * var8)).endVertex();
      var9.draw();
   }

   public int getHeight() {
      return 154;
   }

   public int getWidth() {
      return 101;
   }
}
