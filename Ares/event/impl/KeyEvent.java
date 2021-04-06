package Ares.event.impl;

import Ares.event.EventCancelable;

public class KeyEvent extends EventCancelable {
   private final int key;

   public int getKey() {
      return this.key;
   }

   public KeyEvent(int var1) {
      this.key = var1;
   }
}
