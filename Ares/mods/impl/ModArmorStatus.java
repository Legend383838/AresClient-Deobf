package Ares.mods.impl;

import Ares.GuiIngameMods;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import java.awt.Color;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ModArmorStatus extends ModDraggable {
   public static String Text = "on";
   private ScreenPosition pos = ScreenPosition.fromRalativePosition(0.5D, 0.5D);

   public void renderDummy(ScreenPosition var1) {
      this.renderItemStack(var1, 3, new ItemStack(Items.diamond_helmet));
      this.renderItemStack(var1, 2, new ItemStack(Items.diamond_chestplate));
      this.renderItemStack(var1, 1, new ItemStack(Items.diamond_leggings));
      this.renderItemStack(var1, 0, new ItemStack(Items.diamond_boots));
   }

   public int getWidth() {
      return 64;
   }

   public void render(ScreenPosition var1) {
      if (GuiIngameMods.Armor.contains("on")) {
         for(int var2 = 0; var2 < this.mc.thePlayer.inventory.armorInventory.length; ++var2) {
            ItemStack var3 = this.mc.thePlayer.inventory.armorInventory[var2];
            this.renderItemStack(var1, var2, var3);
         }
      }

   }

   public int getHeight() {
      return 64;
   }

   static int DamageToColor(double var0) {
      if (var0 > 1.0D) {
         var0 = 1.0D;
      } else if (var0 < 0.0D) {
         var0 = 0.0D;
      }

      int var2 = (int)(255.0D * (1.0D - var0));
      int var3 = (int)(255.0D * var0);
      boolean var4 = false;
      return (new Color(255, 255, 255)).getRGB();
   }

   private void renderItemStack(ScreenPosition var1, int var2, ItemStack var3) {
      if (var3 != null) {
         GL11.glPushMatrix();
         int var4 = -16 * var2 + 48;
         if (var3.getItem().isDamageable()) {
            double var5 = (double)(var3.getMaxDamage() - var3.getItemDamage()) / (double)var3.getMaxDamage() * 100.0D;
            if (Text.contains("on")) {
               this.font.drawStringWithShadow(String.format("%.2f%%", var5), (float)(var1.getAbsoluteX() + 20), (float)(var1.getAbsoluteY() + var4 + 5), DamageToColor(var5 / 100.0D));
            }
         }

         RenderHelper.enableGUIStandardItemLighting();
         this.mc.getRenderItem().renderItemAndEffectIntoGUI(var3, var1.getAbsoluteX(), var1.getAbsoluteY() + var4);
         GL11.glPopMatrix();
      }
   }
}
