package Ares;

import Ares.event.impl.ClientTickEvent;
import net.minecraft.client.Minecraft;

public class TimeChanger {
   private TimeType timeType;
   private final Minecraft mc = Minecraft.getMinecraft();
   private double fastTimeMultiplier = 1.0D;

   public void onTick(ClientTickEvent var1) {
      if (this.mc.theWorld != null && this.timeType == TimeType.FAST) {
         this.mc.theWorld.setWorldTime((long)((double)System.currentTimeMillis() * this.fastTimeMultiplier % 24000.0D));
      }

   }

   public void setTimeType(TimeType var1) {
      this.timeType = var1;
   }

   public TimeChanger() {
      this.timeType = TimeType.VANILLA;
   }

   public TimeType getTimeType() {
      return this.timeType;
   }

   public void setFastTimeMultiplier(double var1) {
      this.fastTimeMultiplier = var1;
   }
}
