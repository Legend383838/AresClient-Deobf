package Ares.event.gui.hud;

import com.google.gson.annotations.Expose;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class ScreenPosition {
   @Expose(
      serialize = false
   )
   private static final Minecraft mc = Minecraft.getMinecraft();
   private double x;
   private double y;

   public ScreenPosition(double var1, double var3) {
      this.SetRelative(var1, var3);
   }

   public ScreenPosition(int var1, int var2) {
      this.setAbsolute(var1, var2);
   }

   public static ScreenPosition fromRalativePosition(double var0, double var2) {
      return new ScreenPosition(var0, var2);
   }

   public static ScreenPosition fromAbsolute(int var0, int var1) {
      return new ScreenPosition(var0, var1);
   }

   public int getAbsoluteX() {
      ScaledResolution var1 = new ScaledResolution(mc);
      return (int)(this.x * (double)var1.getScaledWidth());
   }

   public int getAbsoluteY() {
      ScaledResolution var1 = new ScaledResolution(mc);
      return (int)(this.y * (double)var1.getScaledHeight());
   }

   public double getRelitiveX() {
      return this.x;
   }

   public double getRelitiveY() {
      return this.y;
   }

   public void setAbsolute(int var1, int var2) {
      ScaledResolution var3 = new ScaledResolution(mc);
      this.x = (double)var1 / (double)var3.getScaledWidth();
      this.y = (double)var2 / (double)var3.getScaledHeight();
   }

   public void SetRelative(double var1, double var3) {
      this.x = var1;
      this.y = var3;
   }
}
