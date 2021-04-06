package Ares.CustomCapes;

import Ares.GuiGiveCape;
import Ares.SessionChanger;
import Ares.fakeutils.FakePlayer;
import Ares.fakeutils.FakeWorld;
import com.mojang.authlib.GameProfile;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import org.lwjgl.input.Keyboard;

public class GuiCustomCapeOLD extends GuiScreen {
   public static int capea = 0;
   public static float ao = 1.0F;
   public static float go = 0.0F;
   public static int bandana1 = 1;
   private World world;
   int rotate = 0;
   private FakePlayer player;
   public static int bandana = 0;
   public static int fps = 1;
   public static float ro = 0.5F;
   public static float THICCNESS = 20.0F;
   public static int cape = 1;
   int s = 2;
   public static float bo = 1.0F;

   public static void drawEntityOnScreen(int var0, int var1, float var2, float var3, float var4, EntityLivingBase var5) {
      GlStateManager.disableBlend();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableAlpha();
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.translate((float)var0, (float)var1, 50.0F);
      GlStateManager.scale(-var2, var2, var2);
      GlStateManager.rotate(var4, 0.0F, 0.0F, 1.0F);
      GlStateManager.rotate(var3, 0.0F, 1.0F, 0.0F);
      float var6 = var5.renderYawOffset;
      float var7 = var5.rotationYaw;
      float var8 = var5.rotationPitch;
      float var9 = var5.prevRotationYawHead;
      float var10 = var5.rotationYawHead;
      RenderHelper.enableStandardItemLighting();
      var5.renderYawOffset = (float)Math.atan((double)(var3 / 40.0F));
      var5.rotationYaw = (float)Math.atan((double)(var3 / 40.0F));
      var5.rotationPitch = -((float)Math.atan(0.0D)) * 20.0F;
      var5.rotationYawHead = var5.rotationYaw;
      var5.prevRotationYawHead = var5.rotationYaw;
      GlStateManager.translate(0.0F, 0.0F, 0.0F);

      try {
         RenderManager var11 = Minecraft.getMinecraft().getRenderManager();
         var11.setPlayerViewY(180.0F);
         var11.setRenderShadow(false);
         var11.doRenderEntity(var5, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, true);
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
         GlStateManager.translate(0.0F, 0.0F, 20.0F);
      } finally {
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
         GlStateManager.translate(0.0F, 0.0F, 20.0F);
      }
   }

   public void setBlockOverlay(float var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8, int var9, int var10) {
      ro = var1;
      go = var2;
      bo = var3;
      ao = var4;
      THICCNESS = var5;
      cape = var6;
      bandana = var7;
      bandana = var8;
      capea = var9;
      fps = var10;
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      if (cape == 11 || cape == 12 || cape == 13) {
         cape = 9;
      }

      if (cape == 0 || cape == -1 || cape == -2) {
         cape = 1;
      }

      if (cape == 31 || cape == 32 || cape == 33) {
         cape = 30;
      }

      super.drawScreen(var1, var2, var3);
      this.drawBackground(0);
      this.mc.thePlayer = this.player;
      this.world.updateEntity(this.player);
      if (this.mc.getRenderManager().worldObj == null || this.mc.getRenderManager().playerRenderer == null) {
         this.mc.getRenderManager().cacheActiveRenderInfo(this.world, this.mc.fontRendererObj, this.player, this.player, this.mc.gameSettings, 0.0F);
      }

      if (this.mc.getRenderManager().worldObj == null || this.mc.getRenderManager().playerRenderer == null) {
         this.mc.getRenderManager().cacheActiveRenderInfo(this.world, this.mc.fontRendererObj, this.player, this.player, this.mc.gameSettings, 0.0F);
      }

      if (this.world != null && this.player != null) {
         this.mc.thePlayer = this.player;
         ScaledResolution var4 = new ScaledResolution(this.mc);
         GuiScreen var10000 = this.mc.currentScreen;
         int var5 = GuiScreen.width / 2 / 2;
         float var6 = (float)(var4.getScaledHeight_double() / 5.0D) / 1.8F;
         drawEntityOnScreen(var4.getScaledWidth() - var5 - 240, (int)((float)(var4.getScaledHeight() / 2 - 150) + this.player.height * var6), var6, (float)this.rotate, 180.0F, this.player);
         this.rotate += this.s;
         if (this.rotate <= -360 || this.rotate >= 360) {
            this.rotate = 0;
         }
      }

      if (cape == 1 || cape == 2 || cape == 3 || cape == 4 || cape == 5 || cape == 6 || cape == 7 || cape == 8 || cape == 9 || cape == 10) {
         this.drawCenteredString(this.mc.fontRendererObj, "Anime Collection", 475, 310, -1);
      }

      if (cape == 21 || cape == 22 || cape == 23 || cape == 24 || cape == 25 || cape == 26 || cape == 27 || cape == 28 || cape == 29 || cape == 30) {
         this.drawCenteredString(this.mc.fontRendererObj, "Fade Collection", 475, 310, -1);
      }

      if (cape == 41 || cape == 42 || cape == 43 || cape == 44 || cape == 45 || cape == 46 || cape == 47 || cape == 48 || cape == 49 || cape == 50) {
         this.drawCenteredString(this.mc.fontRendererObj, "Aesthetic Sad Collection", 475, 310, -1);
      }

      if (cape == 61 || cape == 62 || cape == 63 || cape == 64 || cape == 65 || cape == 66 || cape == 67 || cape == 68 || cape == 69 || cape == 70) {
         this.drawCenteredString(this.mc.fontRendererObj, "Aesthetic Sky Collection", 475, 310, -1);
      }

      this.drawCenteredString(this.mc.fontRendererObj, "Select Cape", width / 2, 10, -1);
      super.drawScreen(var1, var2, var3);
      this.mc.thePlayer = null;
   }

   protected void mouseClicked(int var1, int var2, int var3) {
      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

   }

   public void updateScreen() {
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 1) {
         this.mc.displayGuiScreen(new GuiMainMenu());
      }

      if (var1.id == 0) {
         this.mc.displayGuiScreen(new GuiGiveCape(this));
      }

      if (var1.id == 3) {
         Random var2 = new Random();
         SessionChanger.getInstance().setUserOffline("User" + var2.nextInt(9) + var2.nextInt(9) + var2.nextInt(9) + var2.nextInt(9));
      }

      if (var1.id == 2) {
         this.s = 0;
      }

      if (var1.id == 5) {
         this.s = 2;
      }

      if (var1.id == 6) {
         ro = 0.0F;
         go = 0.0F;
         bo = 1.0F;
      }

      if (var1.id == 10) {
         cape = 1;
      }

      if (var1.id == 11) {
         cape = 2;
      }

      if (var1.id == 12) {
         cape = 3;
      }

      if (var1.id == 13) {
         cape = 4;
      }

      if (var1.id == 14) {
         cape = 5;
      }

      if (var1.id == 15) {
         cape = 6;
      }

      if (var1.id == 30) {
         --cape;
      }

      if (var1.id == 40) {
         ++cape;
      }

      if (var1.id == 80) {
         bandana = 1;
      }

      if (var1.id == 90) {
         bandana = 0;
      }

      if (var1.id == 100) {
         --bandana1;
      }

      if (var1.id == 110) {
         ++bandana1;
      }

      if (var1.id == 111) {
         if (cape != 1 && cape != 2 && cape != 3 && cape != 4 && cape != 5 && cape != 6 && cape != 7 && cape != 8 && cape != 9 && cape != 10) {
            if (cape != 21 && cape != 22 && cape != 23 && cape != 24 && cape != 25 && cape != 26 && cape != 27 && cape != 28 && cape != 29 && cape != 30) {
               if (cape == 41 || cape == 42 || cape == 43 || cape == 44 || cape == 45 || cape == 46 || cape == 47 || cape == 48 || cape == 49 || cape == 50) {
                  cape = 61;
               }
            } else {
               cape = 41;
            }
         } else {
            cape = 21;
         }
      }

      if (var1.id == 112) {
         if (cape == 21 || cape == 22 || cape == 23 || cape == 24 || cape == 25 || cape == 26 || cape == 27 || cape == 28 || cape == 29 || cape == 30) {
            cape = 1;
         }

         if (cape == 41 || cape == 42 || cape == 43 || cape == 44 || cape == 45 || cape == 46 || cape == 47 || cape == 48 || cape == 49 || cape == 50) {
            cape = 30;
         }

         if (cape == 61 || cape == 62 || cape == 63 || cape == 64 || cape == 65 || cape == 66 || cape == 67 || cape == 68 || cape == 69 || cape == 70) {
            cape = 50;
         }
      }

   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
   }

   public void initGui() {
      byte var1 = 100;
      byte var2 = 100;
      byte var3 = 50;
      this.buttonList.add(new GuiButton(30, width / 2 - 325, 160 + var1, "<<<"));
      this.buttonList.add(new GuiButton(40, width / 2 + 125, 160 + var1, ">>>"));
      this.buttonList.add(new GuiButton(1, width / 2 - 100, 160 + var1, "Back"));
      this.buttonList.add(new GuiButton(0, width / 2 - 100, 160 + var1 + 200, "Give Cape to friend!"));
      this.buttonList.add(new GuiButton(2, 5, 5, 49, 20, I18n.format("Stop", new Object[0])));
      this.buttonList.add(new GuiButton(5, 5, 30, 49, 20, I18n.format("Weiter", new Object[0])));
      this.buttonList.add(new GuiButton(112, width / 2 - 325, 160 + var1 + var3, "<<<"));
      this.buttonList.add(new GuiButton(111, width / 2 + 125, 160 + var1 + var3, ">>>"));
      this.buttonList.add(new GuiButton(80, width / 2 - 100, 160 + var1 + 30 + var2, "Enable Bandana"));
      this.buttonList.add(new GuiButton(90, width / 2 - 100, 160 + var1 + 60 + var2, "Disable Bandana"));
      this.buttonList.add(new GuiButton(100, width / 2 - 325, 160 + var1 + 45 + var2, "<<<"));
      this.buttonList.add(new GuiButton(110, width / 2 + 125, 160 + var1 + 45 + var2, ">>>"));
      Keyboard.enableRepeatEvents(true);
      this.world = new FakeWorld(new WorldInfo(new NBTTagCompound()));
      this.player = new FakePlayer(this.mc, this.world, new GameProfile(UUID.randomUUID(), Minecraft.getMinecraft().getSession().getUsername()));
      this.mc.getRenderManager().cacheActiveRenderInfo(this.world, this.mc.fontRendererObj, this.player, this.player, this.mc.gameSettings, 0.0F);
   }
}
