package Ares.mods.impl;

import Ares.GuiIngameMods;
import Ares.GuiIngameSettings;
import Ares.RenderUtils;
import Ares.UrlTextureUtil;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import java.awt.Color;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ModDamageIndicator extends ModDraggable {
   private ScreenPosition pos;
   private ResourceLocation img = null;
   private boolean hasTriedToDownload = false;
   private String Name = "remix313";

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public void renderDummy(ScreenPosition var1) {
      if (GuiIngameMods.DamageIndicator.contains("on")) {
         Gui.drawRect(var1.getAbsoluteX() - 65, var1.getAbsoluteY() - 10, var1.getAbsoluteX() + 110, var1.getAbsoluteY() + 60, (new Color(0, 0, 0, 150)).getRGB());
         this.font.drawString("HP: 20", var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, -1);
         this.font.drawString("Name: remix313", var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 11, -1);
         UrlTextureUtil.downloadAndSetTexture("https://mc-heads.net/avatar/remix313", new UrlTextureUtil.ResourceLocationCallback(this) {
            final ModDamageIndicator this$0;

            public void onTextureLoaded(ResourceLocation var1) {
               ModDamageIndicator.access$0(this.this$0, var1);
            }

            {
               this.this$0 = var1;
            }
         });
         if (this.img != null) {
            byte var2 = 50;
            GL11.glPushMatrix();
            this.mc.getTextureManager().bindTexture(this.img);
            Gui.drawModalRectWithCustomSizedTexture(var1.getAbsoluteX() - 60, var1.getAbsoluteY(), 1.0F, 1.0F, var2, var2, (float)var2, (float)var2);
            GL11.glPopMatrix();
            Gui.drawRect(var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 31, var1.getAbsoluteX() + 100, var1.getAbsoluteY() + 20, (new Color(180, 255, 180, 102)).getRGB());
         }
      }

   }

   static void access$0(ModDamageIndicator var0, ResourceLocation var1) {
      var0.img = var1;
   }

   public void render(ScreenPosition var1) {
      if (GuiIngameMods.DamageIndicator.contains("on") && this.mc.pointedEntity != null && this.mc.pointedEntity instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)this.mc.pointedEntity;
         Gui.drawRect(var1.getAbsoluteX() - 65, var1.getAbsoluteY() - 10, var1.getAbsoluteX() + 110, var1.getAbsoluteY() + 60, (new Color(0, 0, 0, 150)).getRGB());
         if (var2.getHealth() >= 10.0F) {
            Gui.drawRect(var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 31, var1.getAbsoluteX() + (int)var2.getHealth() * 5, var1.getAbsoluteY() + 20, (new Color(180, 255, 180, 102)).getRGB());
         }

         if (var2.getHealth() >= 5.0F && var2.getHealth() <= 10.0F) {
            Gui.drawRect(var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 31, var1.getAbsoluteX() + (int)var2.getHealth() * 5, var1.getAbsoluteY() + 20, (new Color(255, 255, 0, 102)).getRGB());
         }

         if (var2.getHealth() <= 5.0F && var2.getHealth() >= 0.0F) {
            Gui.drawRect(var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 31, var1.getAbsoluteX() + (int)var2.getHealth() * 5, var1.getAbsoluteY() + 20, (new Color(255, 180, 180, 102)).getRGB());
         }

         if (GuiIngameSettings.ChestAdminEsp == 1) {
            Iterator var4 = this.mc.theWorld.loadedTileEntityList.iterator();

            while(var4.hasNext()) {
               Object var3 = var4.next();
               if (var3 instanceof TileEntityChest) {
                  RenderUtils.blockESPBox(((TileEntityChest)var3).getPos());
               }
            }
         }

         this.font.drawString("HP: " + (int)var2.getHealth(), var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 1, -1);
         this.font.drawString("Name: " + var2.getName(), var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 11, -1);
         if (var2.getHealth() <= Minecraft.getMinecraft().thePlayer.getHealth() && var2.getHealth() != Minecraft.getMinecraft().thePlayer.getHealth()) {
            this.font.drawString("§aYou are Winning§f", var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 35, -1);
         }

         if (var2.getHealth() >= Minecraft.getMinecraft().thePlayer.getHealth() && var2.getHealth() != Minecraft.getMinecraft().thePlayer.getHealth()) {
            this.font.drawString("§cYou are Not Winning§f", var1.getAbsoluteX() + 1, var1.getAbsoluteY() + 35, -1);
         }

         this.Name = var2.getName();
         UrlTextureUtil.downloadAndSetTexture("https://mc-heads.net/avatar/" + var2.getName(), new UrlTextureUtil.ResourceLocationCallback(this) {
            final ModDamageIndicator this$0;

            public void onTextureLoaded(ResourceLocation var1) {
               ModDamageIndicator.access$0(this.this$0, var1);
            }

            {
               this.this$0 = var1;
            }
         });
         if (this.img != null) {
            byte var5 = 50;
            GL11.glPushMatrix();
            this.mc.getTextureManager().bindTexture(this.img);
            Gui.drawModalRectWithCustomSizedTexture(var1.getAbsoluteX() - 60, var1.getAbsoluteY(), 1.0F, 1.0F, var5, var5, (float)var5, (float)var5);
            GL11.glPopMatrix();
         }
      }

   }

   public int getWidth() {
      return this.font.getStringWidth("HP: 20");
   }
}
