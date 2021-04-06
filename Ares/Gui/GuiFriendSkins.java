package Ares.Gui;

import Ares.ImageButton;
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
import net.minecraft.entity.Entity;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.util.ResourceLocation;

public class GuiFriendSkins extends GuiScreen {
   protected ArrayList<ImageButton> ImageButtons = new ArrayList();
   public static String FriendFolder = "dream";
   public static String onoff = "off";
   ArrayList arraylist = Lists.newArrayList();

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

   public void initGui() {
      byte var1 = 100;
      byte var2 = 75;
      int var3 = var2 / 2;
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/friend/Skins/dream.png"), width / 2 + 100 - var3, height / 2 - var1, var2, var2, "Dream Skins", 34));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/friend/Skins/toad.png"), width / 2 - var3, height / 2 - var1, var2, var2, "Toad Skins", 35));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/friend/Skins/amongus.png"), width / 2 - 100 - var3, height / 2 - var1, var2, var2, "Among Us Skins", 36));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/time/power.png"), width / 2 - var3, height / 2 - var1 + 100, var2, var2, "On/Off", 33));
      this.buttonList.clear();
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      Iterator var5 = this.ImageButtons.iterator();

      while(var5.hasNext()) {
         ImageButton var4 = (ImageButton)var5.next();
         var4.draw(var1, var2, Color.WHITE);
      }

      super.drawScreen(var1, var2, var3);
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
   }
}
