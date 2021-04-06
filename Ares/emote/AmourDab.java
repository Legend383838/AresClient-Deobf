package Ares.emote;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;

public class AmourDab extends ModelBiped {
   public AmourDab() {
      super(1.0F);
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
      RenderPlayer var8 = (RenderPlayer)Minecraft.getMinecraft().getRenderManager().getEntityRenderObject(var7);
      ModelPlayer var9 = var8.getMainModel();
   }
}
