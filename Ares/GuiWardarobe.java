package Ares;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.io.FileWriter;
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

public class GuiWardarobe extends GuiScreen {
   private int field_146445_a;
   private int field_146444_f;
   ArrayList arraylist = Lists.newArrayList();
   protected ArrayList<ImageButton> ImageButtons = new ArrayList();

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

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      Iterator var5 = this.ImageButtons.iterator();

      while(var5.hasNext()) {
         ImageButton var4 = (ImageButton)var5.next();
         var4.onClick(var1, var2);
      }

   }

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         try {
            FileWriter var1 = new FileWriter("AresFolder/Skinpath.txt");
            var1.write(GuiIngameSkins.Skinpath);
            var1.close();
            FileWriter var2 = new FileWriter("AresFolder/Skinonoff.txt");
            var2.write(GuiIngameSkins.Skinonoff);
            var2.close();
            System.out.println("Successfully wrote to the file.");
         } catch (IOException var3) {
            System.out.println("An error occurred.");
            var3.printStackTrace();
         }

         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

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

   public void initGui() {
      byte var1 = 100;
      byte var2 = 75;
      int var3 = var2 / 2;
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/wardarobe/remix313.png"), width / 2 - 100 - var3, height / 2 - var1, var2, var2, "Ares Dev", 16));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/wardarobe/sweater.png"), width / 2 - 200 - var3, height / 2 - var1, var2, var2, "??", 18));
      this.ImageButtons.add(new ImageButton(new ResourceLocation("icons/wardarobe/egirl.png"), width / 2 - 300 - var3, height / 2 - var1, var2, var2, "Egirl", 17));
      this.field_146445_a = 0;
      this.buttonList.clear();
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
   }
}
