package Ares;

import net.minecraft.client.gui.Gui;

public class Element {
   public float getFloat() {
      return 0.0F;
   }

   public int getInt() {
      return 0;
   }

   public boolean getBool() {
      return false;
   }

   public void draw() {
   }

   public boolean mouseOverlap(int var1, int var2) {
      return false;
   }

   public String getString() {
      return null;
   }

   private void drawVerticalLine(int var1, int var2, int var3, int var4) {
      if (var3 < var2) {
         int var5 = var2;
         var2 = var3;
         var3 = var5;
      }

      Gui.drawRect(var1, var2 + 1, var1 + 1, var3, var4);
   }

   public void hover() {
   }

   private void drawHorizontalLine(int var1, int var2, int var3, int var4) {
      if (var2 < var1) {
         int var5 = var1;
         var1 = var2;
         var2 = var5;
      }

      Gui.drawRect(var1, var3, var2 + 1, var3 + 1, var4);
   }

   public void interact(int var1, int var2) {
   }

   void drawHollowRect(int var1, int var2, int var3, int var4, int var5) {
      this.drawHorizontalLine(var1, var1 + var3, var2, var5);
      this.drawHorizontalLine(var1, var1 + var3, var2 + var4, var5);
      this.drawVerticalLine(var1, var2 + var4, var2, var5);
      this.drawVerticalLine(var1 + var3, var2 + var4, var2, var5);
      Client.getInstance().cleanGL();
   }

   public void unHover() {
   }
}
