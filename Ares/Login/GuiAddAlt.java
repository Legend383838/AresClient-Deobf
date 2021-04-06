package Ares.Login;

import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import java.io.IOException;
import java.net.Proxy;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

public class GuiAddAlt extends GuiScreen {
   private final GuiAltManager manager;
   private GuiTextField username;
   private String status;
   private PasswordField password;

   protected void actionPerformed(GuiButton var1) {
      switch(var1.id) {
      case 0:
         GuiAddAlt.AddAltThread var2 = new GuiAddAlt.AddAltThread(this, this.username.getText(), this.password.getText());
         var2.start();
         break;
      case 1:
         this.mc.displayGuiScreen(this.manager);
      }

   }

   static void access$0(GuiAddAlt var0, String var1) {
      var0.status = var1;
   }

   public GuiAddAlt(GuiAltManager var1) {
      this.status = EnumChatFormatting.GRAY + "Idle...";
      this.manager = var1;
   }

   protected void keyTyped(char var1, int var2) {
      this.username.textboxKeyTyped(var1, var2);
      this.password.textboxKeyTyped(var1, var2);
      if (var1 == '\t' && (this.username.isFocused() || this.password.isFocused())) {
         this.username.setFocused(!this.username.isFocused());
         this.password.setFocused(!this.password.isFocused());
      }

      if (var1 == '\r') {
         this.actionPerformed((GuiButton)this.buttonList.get(0));
      }

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

   public void initGui() {
      Keyboard.enableRepeatEvents(true);
      this.buttonList.clear();
      this.buttonList.add(new GuiButton(0, width / 2 - 100, height / 4 + 92 + 12, "Login"));
      this.buttonList.add(new GuiButton(1, width / 2 - 100, height / 4 + 116 + 12, "Back"));
      this.username = new GuiTextField(this.eventButton, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.password = new PasswordField(this.mc.fontRendererObj, width / 2 - 100, 100, 200, 20);
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.username.drawTextBox();
      this.password.drawTextBox();
      this.drawCenteredString(this.fontRendererObj, "Add Alt", width / 2, 20, -1);
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Username / E-Mail", width / 2 - 96, 66, -7829368);
      }

      if (this.password.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Password", width / 2 - 96, 106, -7829368);
      }

      this.drawCenteredString(this.fontRendererObj, this.status, width / 2, 30, -1);
      super.drawScreen(var1, var2, var3);
   }

   private class AddAltThread extends Thread {
      private final String username;
      private AltManager AltManager;
      final GuiAddAlt this$0;
      private final String password;

      public void run() {
         if (this.password.equals("")) {
            AltManager var1 = this.AltManager;
            AltManager.registry.add(new Alt(this.username, ""));
            GuiAddAlt.access$0(this.this$0, EnumChatFormatting.GREEN + "Alt added. (" + this.username + " - offline name)");
         } else {
            GuiAddAlt.access$0(this.this$0, EnumChatFormatting.YELLOW + "Trying alt...");

            try {
               this.checkAndAddAlt(this.username, this.password);
            } catch (IOException var2) {
               var2.printStackTrace();
            }

         }
      }

      private final void checkAndAddAlt(String var1, String var2) throws IOException {
         YggdrasilAuthenticationService var3 = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
         YggdrasilUserAuthentication var4 = (YggdrasilUserAuthentication)var3.createUserAuthentication(Agent.MINECRAFT);
         var4.setUsername(var1);
         var4.setPassword(var2);

         try {
            var4.logIn();
            AltManager var5 = this.AltManager;
            AltManager.registry.add(new Alt(var1, var2, var4.getSelectedProfile().getName()));
            GuiAddAlt.access$0(this.this$0, "Alt added. (" + var1 + ")");
         } catch (AuthenticationException var6) {
            GuiAddAlt.access$0(this.this$0, EnumChatFormatting.RED + "Alt failed!");
            var6.printStackTrace();
         }

      }

      public AddAltThread(GuiAddAlt var1, String var2, String var3) {
         this.this$0 = var1;
         this.username = var2;
         this.password = var3;
         GuiAddAlt.access$0(var1, EnumChatFormatting.GRAY + "Idle...");
      }
   }
}
