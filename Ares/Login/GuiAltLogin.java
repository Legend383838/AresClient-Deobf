package Ares.Login;

import Ares.SessionChanger;
import Ares.fakeutils.FakePlayer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public final class GuiAltLogin extends GuiScreen {
   public static String Password = "";
   private GuiTextField username;
   private World world;
   int s = 2;
   int rotate = 0;
   private FakePlayer player;
   private AltLoginThread thread;
   private final GuiScreen previousScreen;
   public static String Email = "";
   private PasswordField password;

   public GuiAltLogin(GuiScreen var1) {
      this.previousScreen = var1;
   }

   protected void mouseClicked(int var1, int var2, int var3) {
      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      this.username.mouseClicked(var1, var2, var3);
      this.password.mouseClicked(var1, var2, var3);
   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);

      try {
         FileWriter var1 = new FileWriter("AresFolder/Mail.txt");
         var1.write(Email);
         var1.close();
         FileWriter var2 = new FileWriter("AresFolder/Pass.txt");
         var2.write(Password);
         var2.close();
         System.out.println("Successfully wrote to the file.");
      } catch (IOException var3) {
         System.out.println("An error occurred.");
         var3.printStackTrace();
      }

   }

   public void initGui() {
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "Login"));
      this.buttonList.add(new GuiButton(3, width / 2 - 100, var1 + 72 + 12 + 24 + 24, "Random Login"));
      this.buttonList.add(new GuiButton(4, width / 2 - 100, var1 + 72 + 12 + 24 + 48, "Last Login"));
      this.buttonList.add(new GuiButton(1, width / 2 - 100, var1 + 72 + 12 + 24, "Back"));
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.password = new PasswordField(this.mc.fontRendererObj, width / 2 - 100, 100, 200, 20);
      this.username.setFocused(true);
      Keyboard.enableRepeatEvents(true);
   }

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

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.username.drawTextBox();
      this.password.drawTextBox();
      this.drawCenteredString(this.mc.fontRendererObj, "Alt Login", width / 2, 20, -1);
      this.drawCenteredString(this.mc.fontRendererObj, this.thread == null ? EnumChatFormatting.GRAY + "Idle..." : this.thread.getStatus(), width / 2, 29, -1);
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Username / E-Mail", width / 2 - 96, 66, -7829368);
      }

      if (this.password.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Password", width / 2 - 96, 106, -7829368);
      }

      super.drawScreen(var1, var2, var3);
   }

   public void updateScreen() {
      this.username.updateCursorCounter();
      this.password.updateCursorCounter();
   }

   protected void keyTyped(char var1, int var2) {
      try {
         super.keyTyped(var1, var2);
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      if (var1 == '\t') {
         if (!this.username.isFocused() && !this.password.isFocused()) {
            this.username.setFocused(true);
         } else {
            this.username.setFocused(this.password.isFocused());
            this.password.setFocused(!this.username.isFocused());
         }
      }

      if (var1 == '\r') {
         this.actionPerformed((GuiButton)this.buttonList.get(0));
      }

      this.username.textboxKeyTyped(var1, var2);
      this.password.textboxKeyTyped(var1, var2);
   }

   protected void actionPerformed(GuiButton var1) {
      switch(var1.id) {
      case 0:
         this.thread = new AltLoginThread(this.username.getText(), this.password.getText());
         this.thread.start();
         Email = this.username.getText();
         Password = this.password.getText();
      case 3:
         Random var2 = new Random();
         SessionChanger.getInstance().setUserOffline("User" + var2.nextInt(9) + var2.nextInt(9) + var2.nextInt(9) + var2.nextInt(9));
      case 4:
         this.thread = new AltLoginThread(Email, Password);
         this.thread.start();
         break;
      case 1:
         this.mc.displayGuiScreen(this.previousScreen);
      case 2:
      }

   }
}
