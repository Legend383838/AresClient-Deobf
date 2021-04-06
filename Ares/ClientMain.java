package Ares;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public class ClientMain {
   public static double version = 2.0D;
   public static String version010 = "2.0";
   private static String name = "Ares";

   public static void nameChange() {
      Display.setTitle("Ares");
   }

   public static void ingameGUI() {
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(GuiColor.Color + name + " v" + version, 910.0F, 5.0F, Color.WHITE.getRGB());
   }

   public static void init() {
   }
}
