package Ares;

import Ares.event.EventTarget;
import Ares.event.impl.ClientTickEvent;

public class TestClass {
   @EventTarget
   public void onTick(ClientTickEvent var1) {
      System.out.println("TestTestTest");
   }
}
