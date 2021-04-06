package Ares;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.util.ResourceLocation;

public class GuiAresMenu extends GuiScreen {
   private int field_146444_f;
   private int field_146445_a;
   protected ArrayList<ImageButton> ImageButtons = new ArrayList();
   ArrayList arraylist = Lists.newArrayList();

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      Iterator var5 = this.ImageButtons.iterator();

      while(var5.hasNext()) {
         ImageButton var4 = (ImageButton)var5.next();
         var4.draw(var1, var2, Color.WHITE);
      }

      super.drawScreen(var1, var2, var3);
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      Iterator var5 = this.ImageButtons.iterator();

      while(var5.hasNext()) {
         ImageButton var4 = (ImageButton)var5.next();
         var4.onClick(var1, var2);
      }

   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      switch(var1.id) {
      case 0:
         this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
         break;
      case 1:
         boolean var2 = this.mc.isIntegratedServerRunning();
         boolean var3 = this.mc.func_181540_al();
         var1.enabled = false;
         this.mc.theWorld.sendQuittingDisconnectingPacket();
         this.mc.loadWorld((WorldClient)null);
         if (var2) {
            this.mc.displayGuiScreen(new GuiMainMenu());
         } else if (var3) {
            RealmsBridge var4 = new RealmsBridge();
            var4.switchToRealms(new GuiMainMenu());
         } else {
            this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu()));
         }
      case 2:
      case 3:
      }

   }

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   public void initGui() {
      byte var1 = 100;
      int var2 = width / 13;
      int var3 = var2 / 2;
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/pos.png"), width / 2 + 300 - var3, height / 2 - var1, var2, var2, "Waypoints", 8));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/mods.png"), width / 2 + 200 - var3, height / 2 - var1, var2, var2, "Mod Toggles", 9));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/modules.png"), width / 2 + 100 - var3, height / 2 - var1, var2, var2, "Modules", 10));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/radio.png"), width / 2 - var3, height / 2 - var1, var2, var2, "Radio", 11));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/capes.png"), width / 2 - 100 - var3, height / 2 - var1, var2, var2, "Capes", 12));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/cosmetics.png"), width / 2 - 200 - var3, height / 2 - var1, var2, var2, "Cosmetics", 13));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/skins.png"), width / 2 - 300 - var3, height / 2 - var1, var2, var2, "Skins", 14));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/wardarobe.png"), width / 2 - 300 - var3, height / 2 - var1 + 100, var2, var2, "Presets", 15));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/color.png"), width / 2 - 200 - var3, height / 2 - var1 + 100, var2, var2, "Color", 19));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/tag.png"), width / 2 - 100 - var3, height / 2 - var1 + 100, var2, var2, "Clan Tag", 20));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/time.png"), width / 2 - var3, height / 2 - var1 + 100, var2, var2, "Time Changer", 25));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/friends.png"), width / 2 + 100 - var3, height / 2 - var1 + 100, var2, var2, "Friends", 26));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/ingame/server.png"), width / 2 + 200 - var3, height / 2 - var1 + 100, var2, var2, "Server List", 37));
      this.field_146445_a = 0;
      this.buttonList.clear();
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
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
}
