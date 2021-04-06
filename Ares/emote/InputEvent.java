package Ares.emote;

import Ares.Client;
import Ares.event.EventTarget;
import Ares.event.impl.ClientTickEvent;

public class InputEvent {
   public static float firstPersonPartialTicks;
   public static int dabbingHeld;
   public static float firstPersonPartialTicks2;
   public static int prevtposingHeld;
   public static int tposingHeld;
   public static final int MAX_DABBING_HELD = 8;
   public static final int MAX_TPOSING_HELD = 8;
   public static int prevDabbingHeld;

   @EventTarget
   public void on(ClientTickEvent var1) {
      prevDabbingHeld = dabbingHeld;
      if (Client.getInstance().dab && dabbingHeld < 8) {
         ++dabbingHeld;
      } else if (!Client.getInstance().dab && dabbingHeld > 0) {
         --dabbingHeld;
      }

      prevtposingHeld = tposingHeld;
      if (Client.getInstance().tpose && tposingHeld < 8) {
         ++tposingHeld;
      } else if (!Client.getInstance().tpose && tposingHeld > 0) {
         --tposingHeld;
      }

   }
}
