package Ares.mods.impl;

import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ModCurrentItem extends ModDraggable {
   public int getHeight() {
      return 15;
   }

   public ScreenPosition load() {
      return this.pos;
   }

   public void save(ScreenPosition var1) {
      this.pos = var1;
   }

   public void render(ScreenPosition var1) {
      ItemStack var2 = this.mc.thePlayer.getHeldItem();
      this.renderItemStack(var1, 2, var2);
   }

   public int getWidth() {
      return 60;
   }

   private void renderItemStack(ScreenPosition var1, int var2, ItemStack var3) {
      if (var3 != null) {
         GL11.glPushMatrix();
         byte var4 = 0;
         if (this.mc.thePlayer != null && var3 != null) {
            if (var3.getItem().isDamageable()) {
               double var5 = (double)(var3.getMaxDamage() - var3.getItemDamage()) / (double)var3.getMaxDamage() * 100.0D;
               this.font.drawString(String.format("%.2f%%", var5), var1.getAbsoluteX() + 20, var1.getAbsoluteY() + var4 + 5, -1);
            }

            if (var3.isStackable() && this.mc.thePlayer.getHeldItem().stackSize != 1) {
               this.font.drawString(Integer.toString(this.mc.thePlayer.getHeldItem().stackSize), var1.getAbsoluteX() + 20, var1.getAbsoluteY() + var4 + 5, -1);
            }

            RenderHelper.enableGUIStandardItemLighting();
            GL11.glPopMatrix();
         }

      }
   }

   public void renderDummy(ScreenPosition var1) {
      this.renderItemStack(var1, 2, new ItemStack(Items.diamond_sword));
   }
}
