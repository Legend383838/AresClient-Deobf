package Ares;

import Ares.mods.ModLoader;
import Ares.mods.impl.ModArmorStatus;
import Ares.radio.Radio;
import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentText;

public class GuiIngameMods extends GuiScreen {
   public static int Admin = 0;
   int s = 10;
   public static String Armor = "on";
   public static Radio radio = new Radio();
   public static String CPS = "on";
   public static String Fps = "on";
   public static String Potion = "on";
   private int field_146444_f;
   public static String Reach = "on";
   public static String Item = "on";
   public static String Time = "on";
   public static String Playername = "on";
   public static String Player = "on";
   private int field_146445_a;
   public static String Keystrokes = "on";
   public static String Sprint = "on";
   int k = 1;
   public static String Coords = "on";
   public static String Custom = "on";
   public static String DamageIndicator = "on";

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   public static void drawEntityOnScreen(int var0, int var1, int var2, float var3, float var4, EntityLivingBase var5) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)var0, (float)var1, 50.0F);
      GlStateManager.scale((float)(-var2), (float)var2, (float)var2);
      GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
      float var6 = var5.renderYawOffset;
      float var7 = var5.rotationYaw;
      float var8 = var5.rotationPitch;
      float var9 = var5.prevRotationYawHead;
      float var10 = var5.rotationYawHead;
      GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(-((float)Math.atan((double)(var4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      var5.renderYawOffset = (float)Math.atan((double)(var3 / 40.0F)) * 20.0F;
      var5.rotationYaw = (float)Math.atan((double)(var3 / 40.0F)) * 40.0F;
      var5.rotationPitch = -((float)Math.atan((double)(var4 / 40.0F))) * 20.0F;
      var5.rotationYawHead = var5.rotationYaw;
      var5.prevRotationYawHead = var5.rotationYaw;
      GlStateManager.translate(0.0F, 0.0F, 0.0F);
      RenderManager var11 = Minecraft.getMinecraft().getRenderManager();
      var11.setPlayerViewY(180.0F);
      var11.setRenderShadow(false);
      var11.renderEntityWithPosYaw(var5, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      var11.setRenderShadow(true);
      var5.renderYawOffset = var6;
      var5.rotationYaw = var7;
      var5.rotationPitch = var8;
      var5.prevRotationYawHead = var9;
      var5.rotationYawHead = var10;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   public void initGui() {
      byte var1 = 30;
      String var2 = Minecraft.getMinecraft().getSession().getUsername();
      DrawMenuLogo.drawString(1.0D, var2, (float)(width / 9 - this.fontRendererObj.getStringWidth(var2) + 200), (float)(height / 20 - 5), Color.white.getRGB());
      this.buttonList.add(new GuiButton(30, 5, 5 + var1, 80, 20, I18n.format("Coords", new Object[0])));
      this.buttonList.add(new GuiButton(2, 95, 5 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(3, 120, 5 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(40, 5, 30 + var1, 80, 20, I18n.format("DamageIndicator", new Object[0])));
      this.buttonList.add(new GuiButton(4, 95, 30 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(5, 120, 30 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5, 55 + var1, 80, 20, I18n.format("Fps", new Object[0])));
      this.buttonList.add(new GuiButton(6, 95, 55 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(7, 120, 55 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5, 80 + var1, 80, 20, I18n.format("ItemCounter", new Object[0])));
      this.buttonList.add(new GuiButton(8, 95, 80 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(9, 120, 80 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5, 105 + var1, 80, 20, I18n.format("Keystrokes", new Object[0])));
      this.buttonList.add(new GuiButton(10, 95, 105 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(11, 120, 105 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5, 130 + var1, 80, 20, I18n.format("MiniPlayer", new Object[0])));
      this.buttonList.add(new GuiButton(12, 95, 130 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(13, 120, 130 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5, 155 + var1, 80, 20, I18n.format("Playername", new Object[0])));
      this.buttonList.add(new GuiButton(14, 95, 155 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(15, 120, 155 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5, 180 + var1, 80, 20, I18n.format("Potions", new Object[0])));
      this.buttonList.add(new GuiButton(16, 95, 180 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(17, 120, 180 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      short var3 = 145;
      this.buttonList.add(new GuiButton(30, 5 + var3, 5 + var1, 80, 20, I18n.format("Reach", new Object[0])));
      this.buttonList.add(new GuiButton(18, 95 + var3, 5 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(19, 120 + var3, 5 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5 + var3, 30 + var1, 80, 20, I18n.format("Time", new Object[0])));
      this.buttonList.add(new GuiButton(20, 95 + var3, 30 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(21, 120 + var3, 30 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(51, 5 + var3, 55 + var1, 80, 20, I18n.format("CPS (LMB + RMB)", new Object[0])));
      this.buttonList.add(new GuiButton(22, 95 + var3, 55 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(23, 120 + var3, 55 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(52, 5 + var3, 80 + var1, 80, 20, I18n.format("Custom Mod", new Object[0])));
      this.buttonList.add(new GuiButton(24, 95 + var3, 80 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(25, 120 + var3, 80 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(53, 5 + var3, 105 + var1, 80, 20, I18n.format("Armor Mod", new Object[0])));
      this.buttonList.add(new GuiButton(26, 95 + var3, 105 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(27, 120 + var3, 105 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(53, 5 + var3, 130 + var1, 80, 20, I18n.format("Armor Text", new Object[0])));
      this.buttonList.add(new GuiButton(28, 95 + var3, 130 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(29, 120 + var3, 130 + var1, 20, 20, I18n.format("§coff", new Object[0])));
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

      ModLoader.Save();
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 2) {
         Coords = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Coords on"));
      }

      if (var1.id == 3) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Coords off"));
         Coords = "off";
      }

      if (var1.id == 4) {
         DamageIndicator = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: DamageIndicator on"));
      }

      if (var1.id == 5) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: DamageIndicator off"));
         DamageIndicator = "off";
      }

      if (var1.id == 6) {
         Fps = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Fps on"));
      }

      if (var1.id == 7) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Fps off"));
         Fps = "off";
      }

      if (var1.id == 8) {
         Item = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Item on"));
      }

      if (var1.id == 9) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Item off"));
         Item = "off";
      }

      if (var1.id == 10) {
         Keystrokes = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Keystrokes on"));
      }

      if (var1.id == 11) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Keystrokes off"));
         Keystrokes = "off";
      }

      if (var1.id == 12) {
         Player = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Player on"));
      }

      if (var1.id == 13) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Player off"));
         Player = "off";
      }

      if (var1.id == 14) {
         Playername = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Playername on"));
      }

      if (var1.id == 15) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Playername off"));
         Playername = "off";
      }

      if (var1.id == 16) {
         Potion = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Potion on"));
      }

      if (var1.id == 17) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Potion off"));
         Potion = "off";
      }

      if (var1.id == 18) {
         Reach = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Reach on"));
      }

      if (var1.id == 19) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Reach off"));
         Reach = "off";
      }

      if (var1.id == 20) {
         Time = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Time on"));
      }

      if (var1.id == 21) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Time off"));
         Time = "off";
      }

      if (var1.id == 22) {
         CPS = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: CPS on"));
      }

      if (var1.id == 23) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: CPS off"));
         CPS = "off";
      }

      if (var1.id == 24) {
         Custom = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Custom on"));
      }

      if (var1.id == 25) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Custom off"));
         Custom = "off";
      }

      if (var1.id == 52) {
         this.mc.displayGuiScreen(new GuiCustomMod((GuiScreen)null));
      }

      if (var1.id == 26) {
         Armor = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Armor Mod on"));
      }

      if (var1.id == 27) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Armor Mod off"));
         Armor = "off";
      }

      if (var1.id == 28) {
         ModArmorStatus.Text = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Armor Mod on"));
      }

      if (var1.id == 29) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Armor Mod off"));
         ModArmorStatus.Text = "off";
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      super.drawScreen(var1, var2, var3);
   }

   public void setBlockOverlay(int var1, String var2, int var3) {
   }
}
