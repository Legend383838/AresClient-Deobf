package Ares;

import net.minecraft.util.ResourceLocation;

public class AnimatedResourceLocation {
   private int currentTick = 0;
   private final int frames;
   private final String folder;
   private ResourceLocation[] textures;
   private int currentFrame = 0;
   private final int fpt;

   public ResourceLocation getTexture() {
      return this.textures[this.currentFrame];
   }

   public AnimatedResourceLocation(String var1, int var2, int var3) {
      this.folder = var1;
      this.frames = var2;
      this.fpt = var3;
      this.textures = new ResourceLocation[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         this.textures[var4] = new ResourceLocation(var1 + "/" + var4 + ".png");
      }

   }

   public void update() {
      if (this.currentTick > this.fpt) {
         this.currentTick = 0;
         ++this.currentFrame;
         if (this.currentFrame > this.textures.length - 1) {
            this.currentFrame = 0;
         }
      }

      ++this.currentTick;
   }
}
