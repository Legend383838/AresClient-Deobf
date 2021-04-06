package Ares.event.gui;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class GuiCheckBox extends GuiButton {
   public boolean checked;
   private static final String CHECK = "✓";
   private static final Color CHECK_COLOR;
   private static final Color X_COLOR;
   private static final String X = "x";

   public GuiCheckBox(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      super(var1, var2, var3, var4, var5, "");
      this.checked = var6;
   }

   public GuiCheckBox(int var1, int var2, int var3, boolean var4) {
      this(var1, var2, var3, 20, 20, var4);
   }

   public GuiCheckBox(int var1, int var2, int var3) {
      this(var1, var2, var3, false);
   }

   public void drawButton(Minecraft var1, int var2, int var3) {
      if (this.visible) {
         FontRenderer var4 = var1.fontRendererObj;
         var1.getTextureManager().bindTexture(buttonTextures);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         this.hovered = var2 >= this.xPosition && var3 >= this.yPosition && var2 < this.xPosition + this.width && var3 < this.yPosition + this.height;
         int var5 = this.getHoverState(this.hovered);
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         GlStateManager.blendFunc(770, 771);
         this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + var5 * 20, this.width / 2, this.height);
         this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + var5 * 20, this.width / 2, this.height);
         this.mouseDragged(var1, var2, var3);
         this.displayString = "x";
         int var6 = X_COLOR.getRGB();
         if (this.checked) {
            this.displayString = "✓";
            var6 = CHECK_COLOR.getRGB();
         }

         this.drawCenteredString(var4, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, var6);
      }

   }

   public void setChecked(boolean var1) {
      this.checked = var1;
   }

   public boolean mousePressed(Minecraft var1, int var2, int var3) {
      if (super.mousePressed(var1, var2, var3)) {
         this.checked = !this.checked;
         return true;
      } else {
         System.out.println();
         return false;
      }
   }

   static {
      X_COLOR = Color.RED;
      CHECK_COLOR = Color.GREEN;
   }

   public GuiCheckBox(int var1, int var2, int var3, int var4, int var5) {
      this(var1, var2, var3, var4, var5, false);
   }

   public boolean isChecked() {
      return this.checked;
   }
}
