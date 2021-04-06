package Ares;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import org.lwjgl.opengl.GL11;

public class RenderUtils {
   public static void blockESPBox(BlockPos var0) {
      double var1 = (double)var0.getX() - Minecraft.getMinecraft().getRenderManager().renderPosX;
      double var3 = (double)var0.getY() - Minecraft.getMinecraft().getRenderManager().renderPosY;
      double var5 = (double)var0.getZ() - Minecraft.getMinecraft().getRenderManager().renderPosZ;
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(3042);
      GL11.glLineWidth(2.0F);
      GL11.glColor4d(0.0D, 1.0D, 0.0D, 0.15000000596046448D);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4d(0.0D, 0.0D, 1.0D, 0.5D);
      RenderGlobal.func_181561_a(new AxisAlignedBB(var1, var3, var5, var1 + 1.0D, var3 + 1.0D, var5 + 1.0D));
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
   }
}
