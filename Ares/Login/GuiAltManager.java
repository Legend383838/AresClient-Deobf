package Ares.Login;

import java.io.IOException;
import java.util.Iterator;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiAltManager extends GuiScreen {
   private GuiButton rename;
   public Alt selectedAlt = null;
   private GuiButton login;
   private GuiButton remove;
   private int offset;
   private AltManager AltManager;
   private String status;
   private AltLoginThread loginThread;

   private boolean isMouseOverAlt(int var1, int var2, int var3) {
      return var1 >= 52 && var2 >= var3 - 4 && var1 <= width - 52 && var2 <= var3 + 20 && var1 >= 0 && var2 >= 33 && var1 <= width && var2 <= height - 50;
   }

   public static void drawOutlinedRect(int var0, int var1, int var2, int var3, int var4, int var5) {
      Gui var6 = new Gui();
      Gui.drawRect(var0 + 1, var1, var2 - 1, var3, var4);
      var6.drawHorizontalLine(var0, var2 - 1, var1, var5);
      var6.drawHorizontalLine(var0, var2 - 1, var3, var5);
      var6.drawVerticalLine(var0, var1, var3, var5);
      var6.drawVerticalLine(var2 - 1, var1, var3, var5);
   }

   public void initGui() {
      this.buttonList.add(new GuiButton(0, width / 2 + 4 + 50, height - 24, 100, 20, "Cancel"));
      this.login = new GuiButton(1, width / 2 - 154, height - 48, 100, 20, "Login");
      this.buttonList.add(this.login);
      this.remove = new GuiButton(2, width / 2 - 154, height - 24, 100, 20, "Remove");
      this.buttonList.add(this.remove);
      this.buttonList.add(new GuiButton(3, width / 2 + 4 + 50, height - 48, 100, 20, "Add"));
      this.buttonList.add(new GuiButton(4, width / 2 - 50, height - 48, 100, 20, "Direct Login"));
      this.rename = new GuiButton(6, width / 2 - 50, height - 24, 100, 20, "Edit");
      this.buttonList.add(this.rename);
      this.login.enabled = false;
      this.remove.enabled = false;
      this.rename.enabled = false;
   }

   public void actionPerformed(GuiButton var1) throws IOException {
      switch(var1.id) {
      case 0:
         if (this.loginThread == null) {
            this.mc.displayGuiScreen((GuiScreen)null);
         } else if (!this.loginThread.getStatus().equals(EnumChatFormatting.YELLOW + "Attempting to log in") && !this.loginThread.getStatus().equals(EnumChatFormatting.RED + "Do not hit back!" + EnumChatFormatting.YELLOW + " Logging in...")) {
            this.mc.displayGuiScreen((GuiScreen)null);
         } else {
            this.loginThread.setStatus(EnumChatFormatting.RED + "Failed to login! Please try again!" + EnumChatFormatting.YELLOW + " Logging in...");
         }
         break;
      case 1:
         String var4 = this.selectedAlt.getUsername();
         String var3 = this.selectedAlt.getPassword();
         this.loginThread = new AltLoginThread(var4, var3);
         this.loginThread.start();
         break;
      case 2:
         if (this.loginThread != null) {
            this.loginThread = null;
         }

         AltManager var2 = this.AltManager;
         Ares.Login.AltManager.registry.remove(this.selectedAlt);
         this.status = "§aRemoved.";
         this.selectedAlt = null;
         break;
      case 3:
         this.mc.displayGuiScreen(new GuiAddAlt(this));
         break;
      case 4:
         this.mc.displayGuiScreen(new GuiAltLogin(this));
      case 5:
      default:
         break;
      case 6:
         this.mc.displayGuiScreen(new GuiRenameAlt(this));
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      if (Mouse.hasWheel()) {
         int var4 = Mouse.getDWheel();
         if (var4 < 0) {
            this.offset += 26;
            if (this.offset < 0) {
               this.offset = 0;
            }
         } else if (var4 > 0) {
            this.offset -= 26;
            if (this.offset < 0) {
               this.offset = 0;
            }
         }
      }

      this.drawDefaultBackground();
      this.drawString(this.fontRendererObj, this.mc.session.getUsername(), 10, 10, -7829368);
      FontRenderer var12 = this.fontRendererObj;
      StringBuilder var5 = new StringBuilder("Account Manager - ");
      this.drawCenteredString(var12, var5.append(Ares.Login.AltManager.registry.size()).append(" alts").toString(), width / 2, 10, -1);
      this.drawCenteredString(this.fontRendererObj, this.loginThread == null ? this.status : this.loginThread.getStatus(), width / 2, 20, -1);
      GL11.glPushMatrix();
      this.prepareScissorBox(0.0F, 33.0F, (float)width, (float)(height - 50));
      GL11.glEnable(3089);
      int var6 = 38;
      AltManager var7 = this.AltManager;
      Iterator var9 = Ares.Login.AltManager.registry.iterator();

      while(true) {
         Alt var8;
         do {
            if (!var9.hasNext()) {
               GL11.glDisable(3089);
               GL11.glPopMatrix();
               super.drawScreen(var1, var2, var3);
               if (this.selectedAlt == null) {
                  this.login.enabled = false;
                  this.remove.enabled = false;
                  this.rename.enabled = false;
               } else {
                  this.login.enabled = true;
                  this.remove.enabled = true;
                  this.rename.enabled = true;
               }

               if (Keyboard.isKeyDown(200)) {
                  this.offset -= 26;
                  if (this.offset < 0) {
                     this.offset = 0;
                  }
               } else if (Keyboard.isKeyDown(208)) {
                  this.offset += 26;
                  if (this.offset < 0) {
                     this.offset = 0;
                  }
               }

               return;
            }

            var8 = (Alt)var9.next();
         } while(!this.isAltInArea(var6));

         String var10 = var8.getMask().equals("") ? var8.getUsername() : var8.getMask();
         String var11 = var8.getPassword().equals("") ? "§cCracked" : var8.getPassword().replaceAll(".", "*");
         if (var8 == this.selectedAlt) {
            if (!this.isMouseOverAlt(var1, var2, var6 - this.offset) || !Mouse.isButtonDown(0)) {
               this.isMouseOverAlt(var1, var2, var6 - this.offset);
            }
         } else if (!this.isMouseOverAlt(var1, var2, var6 - this.offset) || !Mouse.isButtonDown(0)) {
            this.isMouseOverAlt(var1, var2, var6 - this.offset);
         }

         this.drawCenteredString(this.fontRendererObj, var10, width / 2, var6 - this.offset, -1);
         this.drawCenteredString(this.fontRendererObj, var11, width / 2, var6 - this.offset + 10, 5592405);
         var6 += 26;
      }
   }

   private boolean isAltInArea(int var1) {
      return var1 - this.offset <= height - 50;
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      if (this.offset < 0) {
         this.offset = 0;
      }

      int var4 = 38 - this.offset;
      AltManager var5 = this.AltManager;

      for(Iterator var7 = Ares.Login.AltManager.registry.iterator(); var7.hasNext(); var4 += 26) {
         Alt var6 = (Alt)var7.next();
         if (this.isMouseOverAlt(var1, var2, var4)) {
            if (var6 == this.selectedAlt) {
               this.actionPerformed((GuiButton)this.buttonList.get(1));
               return;
            }

            this.selectedAlt = var6;
         }
      }

      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var8) {
         var8.printStackTrace();
      }

   }

   public void prepareScissorBox(float var1, float var2, float var3, float var4) {
      ScaledResolution var5 = new ScaledResolution(this.mc);
      int var6 = var5.getScaleFactor();
      GL11.glScissor((int)(var1 * (float)var6), (int)(((float)var5.getScaledHeight() - var4) * (float)var6), (int)((var3 - var1) * (float)var6), (int)((var4 - var2) * (float)var6));
   }

   public GuiAltManager() {
      this.status = EnumChatFormatting.GRAY + "No alts selected";
   }
}
