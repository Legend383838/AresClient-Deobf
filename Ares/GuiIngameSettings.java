package Ares;

import Ares.CustomCapes.GuiCustomCapeOLD;
import Ares.radio.Radio;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;
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
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

public class GuiIngameSettings extends GuiScreen {
   public static int Admin = 0;
   int k = 1;
   public static int AutoText = 1;
   private int field_146445_a;
   public static int NameProtect = 0;
   public static int AdminEsp = 0;
   public static int Nightmode = 0;
   public static int Fullbright = 0;
   public static int ShortCuts = 1;
   public static String GuiBlur = "on";
   public static int ModStyle = 2;
   private int field_146444_f;
   public static int ClientWingsColor = 0;
   public static int Capes = 1;
   public static int oldAnimations = 1;
   public static int ChatBox = 0;
   public static int FriendMenu = 1;
   public static int ChestGui = 1;
   public static String ModColor = "§4";
   public static int ChestAdminEsp = 0;
   public static Radio radio = new Radio();
   public static int ButtonStyle = 1;
   public static int ClientWings = 0;
   public static int NameTags = 1;

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 48) {
         if (Nightmode == 0) {
            Nightmode = 1;
         } else {
            Nightmode = 0;
         }
      }

      if (var1.id == 42) {
         this.mc.displayGuiScreen(new GuiIngameeditor());
      }

      if (var1.id == 54) {
         this.mc.displayGuiScreen(new GuiMusikPlayer());
      }

      if (var1.id == 60) {
         oldAnimations = 1;
      }

      if (var1.id == 61) {
         oldAnimations = 0;
      }

      if (var1.id == 40) {
         AutoText = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f]: AutoText on"));
      }

      if (var1.id == 41) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f]: AutoText off"));
         AutoText = 0;
      }

      if (var1.id == 53) {
         this.mc.displayGuiScreen(new GuiAutoText((GuiScreen)null));
      }

      if (var1.id == 52) {
         this.mc.displayGuiScreen(new GuiKeystrokes());
      }

      if (var1.id == 56) {
         this.mc.displayGuiScreen(new GuiSelectionsBox());
      }

      if (var1.id == 51) {
         this.mc.displayGuiScreen(new GuiModColor());
      }

      if (var1.id == 37) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Buttons§f]: Style: 1"));
         ButtonStyle = 1;
      }

      if (var1.id == 38) {
         ButtonStyle = 2;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Buttons§f]: Style: 2"));
      }

      if (var1.id == 39) {
         ButtonStyle = 3;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Buttons§f]: Style: 3"));
      }

      if (var1.id == 35) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Clean"));
         ModStyle = 0;
      }

      if (var1.id == 36) {
         ModStyle = 2;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mods§f]: Normal"));
      }

      if (var1.id == 32) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mod Style§f]: Old"));
         ModStyle = 1;
      }

      if (var1.id == 33) {
         ModStyle = 2;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Mod Style§f]: New"));
      }

      if (var1.id == 34) {
         ModStyle = 3;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4M§co§6d §eS §2S§at§by§3l§1e§f]: Rainbow"));
      }

      if (var1.id == 31) {
         this.mc.displayGuiScreen(new GuiNameChanger((GuiScreen)null));
      }

      if (var1.id == 29) {
         NameProtect = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] NameChanger on"));
      }

      if (var1.id == 30) {
         NameProtect = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] NameChanger off"));
      }

      if (var1.id == 2) {
         this.mc.gameSettings.gammaSetting = 100.0F;
         Fullbright = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Fullbright on"));
      }

      if (var1.id == 3) {
         this.mc.gameSettings.gammaSetting = 0.0F;
         Fullbright = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Fullbright off"));
      }

      if (var1.id == 4) {
         GuiCustomCapeOLD.fps = 1;
         Capes = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Animated Capes on"));
      }

      if (var1.id == 5) {
         GuiCustomCapeOLD.fps = 0;
         Capes = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Animated Capes off"));
      }

      if (var1.id == 6) {
         SetBlockOverlay.name = 1;
         NameTags = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Nametag on"));
      }

      if (var1.id == 7) {
         SetBlockOverlay.name = 0;
         NameTags = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Nametag off"));
      }

      if (var1.id == 8) {
         ClientWings = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Wings on"));
         super.updateScreen();
      }

      if (var1.id == 9) {
         ClientWings = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Wings off"));
         super.updateScreen();
      }

      if (var1.id == 10) {
         ClientWingsColor = 2;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§dWings§f] Changed Color to §dGalaxy"));
      }

      if (var1.id == 11) {
         ClientWingsColor = 3;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§dWings§f] Changed Color to §4Red"));
      }

      if (var1.id == 12) {
         ClientWingsColor = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§dWings§f] Changed Color to §7 Normal"));
      }

      if (var1.id == 13) {
         ClientWingsColor = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§dWings§f] Changed Color to §aGreen"));
      }

      if (var1.id == 14) {
         AdminEsp = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§dAdmin Module§f] Esp Deactivated"));
      }

      if (var1.id == 15) {
         AdminEsp = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§dAdmin Module§f] Esp Activated"));
      }

      if (var1.id == 16) {
         ChestAdminEsp = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§dAdmin Module§f] Chest Esp Activated"));
      }

      if (var1.id == 17) {
         ChestAdminEsp = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§dAdmin Module§f] Chest Esp Deactivated"));
      }

      if (var1.id == 18) {
         ChatBox = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Custom Chatbox on"));
      }

      if (var1.id == 19) {
         ChatBox = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Custom Chatbox off"));
      }

      if (var1.id == 20) {
         radio.setStream((new URL("http://stream.laut.fm/my-webradio")).openStream());
         radio.start();
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§eRadio§f] on"));
         GuiMusikPlayer.NowPlaying = "§f[§eRadio§f] on";
      }

      if (var1.id == 21) {
         radio.stop();
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§eRadio§f] off"));
         GuiMusikPlayer.NowPlaying = "§f[§eRadio§f] off";
      }

      if (var1.id == 22) {
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Chest gui on"));
         ChestGui = 1;
      }

      if (var1.id == 23) {
         ChestGui = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Chest gui off"));
      }

      if (var1.id == 24) {
         Random var2 = new Random();
         SetBlockOverlay.ro = var2.nextFloat();
         SetBlockOverlay.go = var2.nextFloat();
         SetBlockOverlay.bo = var2.nextFloat();
      }

      if (var1.id == 25) {
         FriendMenu = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Friend Menu on"));
      }

      if (var1.id == 26) {
         FriendMenu = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Friend Menu off"));
      }

      if (var1.id == 27) {
         ShortCuts = 1;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Shortcuts on"));
      }

      if (var1.id == 28) {
         ShortCuts = 0;
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] Shortcuts off"));
      }

      if (var1.id == 43) {
         this.mc.getRenderManager().setDebugBoundingBox(true);
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] HitBox on"));
      }

      if (var1.id == 44) {
         this.mc.getRenderManager().setDebugBoundingBox(false);
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] HitBox off"));
      }

      if (var1.id == 60) {
         GuiBlur = "on";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] GuiBlur on"));
      }

      if (var1.id == 61) {
         GuiBlur = "off";
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§4Module§f] GuiBlur off"));
      }

      if (var1.id == 45) {
         this.mc.displayGuiScreen(new GuiHitBox());
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      GuiHelper.drawPicture(width / 2 - 25, height / 2 - 25, 50, 50, "pngicon.png");
      super.drawScreen(var1, var2, var3);
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

   public void onRender() {
      if (ChestAdminEsp == 1) {
         Iterator var2 = this.mc.theWorld.loadedTileEntityList.iterator();

         while(var2.hasNext()) {
            Object var1 = var2.next();
            if (var1 instanceof TileEntityChest) {
               RenderUtils.blockESPBox(((TileEntityChest)var1).getPos());
            }
         }
      }

   }

   public void setBlockOverlay(int var1, String var2, int var3) {
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

   }

   public void initGui() {
      byte var1 = 30;
      String var2 = Minecraft.getMinecraft().getSession().getUsername();
      DrawMenuLogo.drawString(1.0D, var2, (float)(width / 9 - this.fontRendererObj.getStringWidth(var2) + 200), (float)(height / 20 - 5), Color.white.getRGB());
      this.buttonList.add(new GuiButton(30, 5, 5 + var1, 80, 20, I18n.format("Fullbright", new Object[0])));
      this.buttonList.add(new GuiButton(2, 95, 5 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(3, 120, 5 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(40, 5, 30 + var1, 80, 20, I18n.format("Animated Cape", new Object[0])));
      this.buttonList.add(new GuiButton(4, 95, 30 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(5, 120, 30 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5, 55 + var1, 80, 20, I18n.format("Nametag", new Object[0])));
      this.buttonList.add(new GuiButton(6, 95, 55 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(7, 120, 55 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5, 80 + var1, 80, 20, I18n.format("Custom ChatBox", new Object[0])));
      this.buttonList.add(new GuiButton(18, 95, 80 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(19, 120, 80 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(54, 5, 105 + var1, 80, 20, I18n.format("Radio", new Object[0])));
      this.buttonList.add(new GuiButton(20, 95, 105 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(21, 120, 105 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5, 130 + var1, 80, 20, I18n.format("Chest Gui", new Object[0])));
      this.buttonList.add(new GuiButton(22, 95, 130 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(23, 120, 130 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(56, 5, 155 + var1, 80, 20, I18n.format("Selection Box", new Object[0])));
      this.buttonList.add(new GuiButton(24, 95, 155 + var1, 45, 20, I18n.format("Color", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5, 180 + var1, 80, 20, I18n.format("Friend Menu", new Object[0])));
      this.buttonList.add(new GuiButton(25, 95, 180 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(26, 120, 180 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      short var3 = 145;
      this.buttonList.add(new GuiButton(30, 5 + var3, 5 + var1, 80, 20, I18n.format("Shortcuts", new Object[0])));
      this.buttonList.add(new GuiButton(27, 95 + var3, 5 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(28, 120 + var3, 5 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5 + var3, 30 + var1, 80, 20, I18n.format("NameChanger", new Object[0])));
      this.buttonList.add(new GuiButton(29, 95 + var3, 30 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(30, 120 + var3, 30 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(31, 145 + var3, 30 + var1, 20, 20, I18n.format("S", new Object[0])));
      this.buttonList.add(new GuiButton(51, 5 + var3, 55 + var1, 80, 20, I18n.format("Mod Style", new Object[0])));
      this.buttonList.add(new GuiButton(32, 95 + var3, 55 + var1, 20, 20, I18n.format("§cold", new Object[0])));
      this.buttonList.add(new GuiButton(33, 120 + var3, 55 + var1, 20, 20, I18n.format("§anew", new Object[0])));
      this.buttonList.add(new GuiButton(34, 145 + var3, 55 + var1, 40, 20, I18n.format("Rainbow", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5 + var3, 80 + var1, 80, 20, I18n.format("Clean Mode", new Object[0])));
      this.buttonList.add(new GuiButton(36, 95 + var3, 80 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(35, 120 + var3, 80 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(50, 5 + var3, 105 + var1, 80, 20, I18n.format("Button Style", new Object[0])));
      this.buttonList.add(new GuiButton(37, 95 + var3, 105 + var1, 20, 20, I18n.format("§a1", new Object[0])));
      this.buttonList.add(new GuiButton(38, 120 + var3, 105 + var1, 20, 20, I18n.format("§c2", new Object[0])));
      this.buttonList.add(new GuiButton(39, 120 + var3 + 25, 105 + var1, 20, 20, I18n.format("§e3", new Object[0])));
      this.buttonList.add(new GuiButton(52, 5 + var3, 130 + var1, 80, 20, I18n.format("Keystrokes", new Object[0])));
      this.buttonList.add(new GuiButton(53, 5 + var3, 155 + var1, 80, 20, I18n.format("AutoText", new Object[0])));
      this.buttonList.add(new GuiButton(40, 95 + var3, 155 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(41, 120 + var3, 155 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(42, 5 + var3, 180 + var1, 90, 20, I18n.format("Gui Settings", new Object[0])));
      this.buttonList.add(new GuiButton(100, 5 + var3 + var3 + 30, 30 + var1, 80, 20, I18n.format("GuiBlur", new Object[0])));
      this.buttonList.add(new GuiButton(60, 95 + var3 + var3 + 30, 30 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(61, 120 + var3 + var3 + 30, 30 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      this.buttonList.add(new GuiButton(45, 5 + var3 + var3 + 30, 5 + var1, 80, 20, I18n.format("HitBox", new Object[0])));
      this.buttonList.add(new GuiButton(43, 95 + var3 + var3 + 30, 5 + var1, 20, 20, I18n.format("§aon", new Object[0])));
      this.buttonList.add(new GuiButton(44, 120 + var3 + var3 + 30, 5 + var1, 20, 20, I18n.format("§coff", new Object[0])));
      boolean var4 = true;
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
   }

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }
}
