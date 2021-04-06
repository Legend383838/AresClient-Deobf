package Ares;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class GuiHelper {
   private static Minecraft mc = Minecraft.getMinecraft();

   public void drawBackgroundPicture(int var1, int var2, String var3) {
      ScaledResolution var4 = new ScaledResolution(mc);
      ResourceLocation var5 = new ResourceLocation(var3);
      mc.getTextureManager().bindTexture(var5);
      Gui.drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, var4.getScaledWidth(), var4.getScaledHeight(), (float)var4.getScaledWidth(), (float)var4.getScaledHeight());
      Gui.drawRect(0, 0, var1, var2, 1073741824);
   }

   public static void drawPicture(int var0, int var1, int var2, int var3, String var4) {
      ResourceLocation var5 = new ResourceLocation(var4);
      mc.getTextureManager().bindTexture(var5);
      Gui.drawModalRectWithCustomSizedTexture(var0, var1, 0.0F, 0.0F, var2, var3, (float)var2, (float)var3);
   }
}
