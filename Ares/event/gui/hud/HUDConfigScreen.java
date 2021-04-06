package Ares.event.gui.hud;

import Ares.GuiHelper;
import Ares.event.gui.GuiModToggle;
import java.awt.Color;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class HUDConfigScreen extends GuiScreen {
   private final HashMap<IRenderer, ScreenPosition> renderers = new HashMap();
   private Optional<IRenderer> selectedRenderer = Optional.empty();
   private int prevX;
   private int prevY;

   public HUDConfigScreen(HUDManager var1) {
      Collection var2 = var1.getRegisteredRenderers();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         IRenderer var3 = (IRenderer)var4.next();
         if (var3.isEnabled()) {
            ScreenPosition var5 = var3.load();
            if (var5 == null) {
               var5 = ScreenPosition.fromRalativePosition(0.5D, 0.5D);
            }

            this.adjustBounds(var3, var5);
            this.renderers.put(var3, var5);
         }
      }

   }

   public void initGui() {
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
   }

   public void drawScreen(int var1, int var2, float var3) {
      super.drawDefaultBackground();
      float var4 = this.zLevel;
      this.zLevel = 50.0F;
      Iterator var6 = this.renderers.keySet().iterator();

      while(var6.hasNext()) {
         IRenderer var5 = (IRenderer)var6.next();
         ScreenPosition var7 = (ScreenPosition)this.renderers.get(var5);
         var5.renderDummy(var7);
         this.drawHollowRect(var7.getAbsoluteX(), var7.getAbsoluteY(), var5.getWidth(), var5.getHeight(), this.getRainbow(6000, -15));
      }

      this.drawHollowRect(0, 0, width - 1, height - 1, this.getRainbow(6000, -15));
      this.zLevel = var4;
      GlStateManager.color(1.0F, 1.0F, 1.0F);
      GuiHelper.drawPicture(width / 2 - 150, 50, 300, 100, "header.png");
      super.drawScreen(var1, var2, var3);
   }

   private int getRainbow(int var1, int var2) {
      float var3 = (float)((System.currentTimeMillis() + (long)var2) % (long)var1);
      var3 /= (float)var1;
      return Color.getHSBColor(var3, 1.0F, 1.0F).getRGB();
   }

   private void drawHollowRect(int var1, int var2, int var3, int var4, int var5) {
      this.drawHorizontalLine(var1, var1 + var3, var2, var5);
      this.drawHorizontalLine(var1, var1 + var3, var2 + var4, var5);
      this.drawVerticalLine(var1, var2 + var4, var2, var5);
      this.drawVerticalLine(var1 + var3, var2 + var4, var2, var5);
   }

   protected void keyTyped(char var1, int var2) throws IOException {
      if (var2 == 1) {
         this.renderers.entrySet().forEach(HUDConfigScreen::lambda$0);
         this.mc.displayGuiScreen((GuiScreen)null);
      }

   }

   protected void mouseClickMove(int var1, int var2, int var3, long var4) {
      if (this.selectedRenderer.isPresent()) {
         this.moveSelectedRenderBy(var1 - this.prevX, var2 - this.prevY);
      }

      this.prevX = var1;
      this.prevY = var2;
   }

   private void moveSelectedRenderBy(int var1, int var2) {
      IRenderer var3 = (IRenderer)this.selectedRenderer.get();
      ScreenPosition var4 = (ScreenPosition)this.renderers.get(var3);
      var4.setAbsolute(var4.getAbsoluteX() + var1, var4.getAbsoluteY() + var2);
      this.adjustBounds(var3, var4);
   }

   public void onGuiClosed() {
      Iterator var2 = this.renderers.keySet().iterator();

      while(var2.hasNext()) {
         IRenderer var1 = (IRenderer)var2.next();
         var1.save((ScreenPosition)this.renderers.get(var1));
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

   }

   public boolean doesGuiPauseGame() {
      return true;
   }

   private void adjustBounds(IRenderer var1, ScreenPosition var2) {
      ScaledResolution var3 = new ScaledResolution(Minecraft.getMinecraft());
      int var4 = var3.getScaledWidth();
      int var5 = var3.getScaledHeight();
      int var6 = Math.max(0, Math.min(var2.getAbsoluteX(), Math.max(var4 - var1.getWidth(), 0)));
      int var7 = Math.max(0, Math.min(var2.getAbsoluteY(), Math.max(var5 - var1.getHeight(), 0)));
      var2.setAbsolute(var6, var7);
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      this.prevX = var1;
      this.prevY = var2;
      this.loadMouseOver(var1, var2);
   }

   private void loadMouseOver(int var1, int var2) {
      this.selectedRenderer = this.renderers.keySet().stream().filter(new HUDConfigScreen.MouseOverFinder(this, var1, var2)).findFirst();
   }

   protected void actionPerformed(GuiButton var1) {
      switch(var1.id) {
      case 1:
         this.mc.displayGuiScreen(new GuiModToggle());
      case 0:
      default:
      }
   }

   static HashMap access$0(HUDConfigScreen var0) {
      return var0.renderers;
   }

   private static void lambda$0(Entry var0) {
      ((IRenderer)var0.getKey()).save((ScreenPosition)var0.getValue());
   }

   private class MouseOverFinder implements Predicate<IRenderer> {
      private int mouseX;
      private int mouseY;
      final HUDConfigScreen this$0;

      public MouseOverFinder(HUDConfigScreen var1, int var2, int var3) {
         this.this$0 = var1;
         this.mouseX = var2;
         this.mouseY = var3;
      }

      public boolean test(IRenderer var1) {
         ScreenPosition var2 = (ScreenPosition)HUDConfigScreen.access$0(this.this$0).get(var1);
         int var3 = var2.getAbsoluteX();
         int var4 = var2.getAbsoluteY();
         return this.mouseX >= var3 && this.mouseX <= var3 + var1.getWidth() && this.mouseY >= var4 && this.mouseY <= var4 + var1.getHeight();
      }

      public boolean test(Object var1) {
         return this.test((IRenderer)var1);
      }
   }
}
