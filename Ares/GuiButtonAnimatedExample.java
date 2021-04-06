package Ares;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class GuiButtonAnimatedExample extends GuiButton {
   int animatedHeight = 0;

   public void drawButton(Minecraft var1, int var2, int var3) {
      if (this.visible) {
         FontRenderer var4 = var1.fontRendererObj;
         GlStateManager.color(0.0F, 0.0F, 1.0F, 1.0F);
         this.hovered = var2 >= this.xPosition && var3 >= this.yPosition && var2 < this.xPosition + this.width && var3 < this.yPosition + this.height;
         if (this.hovered) {
            ++this.animatedHeight;
            if (this.animatedHeight > this.height) {
               this.animatedHeight = this.height;
            }
         } else {
            --this.animatedHeight;
            if (this.animatedHeight < 0) {
               this.animatedHeight = 0;
            }
         }

         drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, -1);
         drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.animatedHeight, -672001);
         this.mouseDragged(var1, var2, var3);
         int var5 = 14737632;
         if (!this.enabled) {
            var5 = 10526880;
         } else if (this.hovered) {
            var5 = 16777120;
         }

         this.drawCenteredString(var4, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, var5);
      }

   }

   public GuiButtonAnimatedExample(int var1, int var2, int var3, int var4, int var5, String var6) {
      super(var1, var2, var3, var4, var5, var6);
   }

   public GuiButtonAnimatedExample(int var1, int var2, int var3, String var4) {
      super(var1, var2, var3, var4);
   }
}
