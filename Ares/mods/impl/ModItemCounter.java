package Ares.mods.impl;

import Ares.GuiColor;
import Ares.GuiIngameMods;
import Ares.GuiIngameSettings;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItemCounter extends ModDraggable {
   public String getItemStack() {
      ItemStack var1 = this.mc.thePlayer.getHeldItem();
      if (var1 == null) {
         return "";
      } else {
         int var2 = Item.getIdFromItem(this.mc.thePlayer.getCurrentEquippedItem().getItem());
         int var3 = this.mc.thePlayer.getCurrentEquippedItem().getItemDamage();
         if (this.mc.thePlayer.getCurrentEquippedItem().getItem() == Items.bow) {
            var2 = Item.getIdFromItem(Items.arrow);
            var3 = 0;
         }

         int var4 = 0;
         Minecraft var5 = Minecraft.getMinecraft();
         ItemStack[] var6 = this.mc.thePlayer.inventory.mainInventory;

         for(int var7 = 0; var7 < var6.length; ++var7) {
            if (var6[var7] != null) {
               Item var8 = var6[var7].getItem();
               if (Item.getIdFromItem(var8) == var2 && var6[var7].getItemDamage() == var3) {
                  var4 += var6[var7].stackSize;
               }
            }
         }

         return Integer.toString(var4);
      }
   }

   public int getItemStackAsInt() {
      ItemStack var1 = this.mc.thePlayer.getHeldItem();
      if (var1 == null) {
         return 0;
      } else {
         int var2 = Item.getIdFromItem(this.mc.thePlayer.getCurrentEquippedItem().getItem());
         int var3 = this.mc.thePlayer.getCurrentEquippedItem().getItemDamage();
         if (this.mc.thePlayer.getCurrentEquippedItem().getItem() == Items.bow) {
            var2 = Item.getIdFromItem(Items.arrow);
            var3 = 0;
         }

         int var4 = 0;
         Minecraft var5 = Minecraft.getMinecraft();
         ItemStack[] var6 = this.mc.thePlayer.inventory.mainInventory;

         for(int var7 = 0; var7 < var6.length; ++var7) {
            if (var6[var7] != null) {
               Item var8 = var6[var7].getItem();
               if (Item.getIdFromItem(var8) == var2 && var6[var7].getItemDamage() == var3) {
                  var4 += var6[var7].stackSize;
               }
            }
         }

         return var4;
      }
   }

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public int getWidth() {
      return this.font.getStringWidth("Item Counter: 512");
   }

   public void renderDummy(ScreenPosition var1) {
      if (GuiIngameMods.Item.contains("on")) {
         this.font.drawStringWithShadow("Item Counter: 69", (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), -1);
      }

   }

   public void render(ScreenPosition var1) {
      if (GuiIngameMods.Item.contains("on")) {
         if (GuiIngameSettings.ModStyle == 1) {
            if (this.getItemStackAsInt() <= 99) {
               this.font.drawStringWithShadow(GuiColor.Color + "Item Counter: " + this.getItemStack(), (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), -1);
            } else {
               this.font.drawStringWithShadow(GuiColor.Color + "Item Counter: " + this.getItemStack(), (float)(var1.getAbsoluteX() - 3), (float)var1.getAbsoluteY(), -1);
            }
         }

         if (GuiIngameSettings.ModStyle == 2) {
            if (this.getItemStackAsInt() <= 99) {
               this.font.drawStringWithShadow("§f[" + GuiIngameSettings.ModColor + "Item Counter§f]:" + this.getItemStack(), (float)var1.getAbsoluteX(), (float)var1.getAbsoluteY(), -1);
            } else {
               this.font.drawStringWithShadow("§f[" + GuiIngameSettings.ModColor + "Item Counter§f]:" + this.getItemStack(), (float)(var1.getAbsoluteX() - 3), (float)var1.getAbsoluteY(), -1);
            }
         }
      }

   }
}
