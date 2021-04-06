package Ares;

import net.minecraft.util.ResourceLocation;

public class CapeAnimate {
   public int ticks;
   public int item1Animation;

   public void tick() {
      ++this.item1Animation;
      if (this.item1Animation >= this.ticks) {
         this.item1Animation = 0;
      }
   }

   public CapeAnimate(int var1) {
      this.ticks = var1;
   }

   public ResourceLocation getResource() {
      return new ResourceLocation("frames/" + this.item1Animation + ".png");
   }
}
