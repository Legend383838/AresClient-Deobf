package Ares.Gui;

import Ares.GuiClanTag;
import Ares.GuiIngameCosmetics;
import Ares.GuiIngameMods;
import Ares.GuiIngameSettings;
import Ares.GuiIngameSkins;
import Ares.GuiModColor;
import Ares.GuiMusikPlayer;
import Ares.GuiTimechanger;
import Ares.GuiWardarobe;
import Ares.notis.Notification;
import Ares.notis.NotificationManager;
import Ares.notis.NotificationType;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class GuiAresMenuOld extends GuiScreen {
   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      super.drawScreen(var1, var2, var3);
   }

   public void updateScreen() {
      super.updateScreen();
   }

   public void initGui() {
      this.buttonList.add(new GuiButton(1, width / 2 - 140, 25, 80, 20, I18n.format("Skinchanger§f", new Object[0])));
      this.buttonList.add(new GuiButton(2, width / 2 - 140, 50, 80, 20, I18n.format("Cosmetics§f", new Object[0])));
      this.buttonList.add(new GuiButton(3, width / 2 - 140, 75, 80, 20, I18n.format("Capes§f", new Object[0])));
      this.buttonList.add(new GuiButton(4, width / 2 - 140, 100, 80, 20, I18n.format("Radio§f", new Object[0])));
      this.buttonList.add(new GuiButton(5, width / 2 - 140, 125, 80, 20, I18n.format("More Mods§f", new Object[0])));
      this.buttonList.add(new GuiButton(6, width / 2 - 40, 25, 80, 20, I18n.format("Toggle Mods§f", new Object[0])));
      this.buttonList.add(new GuiButton(7, width / 2 - 40, 50, 80, 20, I18n.format("Waypoints§f", new Object[0])));
      this.buttonList.add(new GuiButton(8, width / 2 - 40, 75, 80, 20, I18n.format("Wardarobe§f", new Object[0])));
      this.buttonList.add(new GuiButton(9, width / 2 - 40, 100, 80, 20, I18n.format("Colors§f", new Object[0])));
      this.buttonList.add(new GuiButton(10, width / 2 - 40, 125, 80, 20, I18n.format("Tags§f", new Object[0])));
      this.buttonList.add(new GuiButton(11, width / 2 + 60, 25, 80, 20, I18n.format("TimeChanger§f", new Object[0])));
      this.buttonList.add(new GuiButton(12, width / 2 + 60, 50, 80, 20, I18n.format("Friends§f", new Object[0])));
      this.buttonList.add(new GuiButton(13, width / 2 + 60, 75, 80, 20, I18n.format("Server-List§f", new Object[0])));
      this.buttonList.add(new GuiButton(14, width / 2 + 60, 100, 80, 20, I18n.format("Coming Soon§f", new Object[0])));
      this.buttonList.add(new GuiButton(0, width / 2 + 60, 125, 80, 20, I18n.format("Coming Soon§f", new Object[0])));
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 1) {
         this.mc.displayGuiScreen(new GuiIngameSkins());
      }

      if (var1.id == 2) {
         this.mc.displayGuiScreen(new GuiIngameCosmetics());
      }

      if (var1.id == 3) {
         this.mc.displayGuiScreen(new GuiCapeSelection());
      }

      if (var1.id == 4) {
         this.mc.displayGuiScreen(new GuiMusikPlayer());
      }

      if (var1.id == 5) {
         this.mc.displayGuiScreen(new GuiIngameSettings());
      }

      if (var1.id == 6) {
         this.mc.displayGuiScreen(new GuiIngameMods());
      }

      if (var1.id == 7) {
         NotificationManager.show(new Notification(NotificationType.INFO, "Cooming soon", "Waypoints", 3));
      }

      if (var1.id == 8) {
         this.mc.displayGuiScreen(new GuiWardarobe());
      }

      if (var1.id == 9) {
         this.mc.displayGuiScreen(new GuiModColor());
      }

      if (var1.id == 10) {
         this.mc.displayGuiScreen(new GuiClanTag(this));
      }

      if (var1.id == 11) {
         this.mc.displayGuiScreen(new GuiTimechanger());
      }

      if (var1.id == 12) {
         this.mc.displayGuiScreen(new GuiFriendMain());
      }

      if (var1.id == 13) {
         this.mc.displayGuiScreen(new GuiMultiplayer(new GuiAresMenuOld()));
      }

      int var10000 = var1.id;
   }
}
