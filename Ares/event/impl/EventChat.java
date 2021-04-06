package Ares.event.impl;

import Ares.event.Event;
import net.minecraft.util.IChatComponent;

public class EventChat extends Event {
   private IChatComponent message;

   public IChatComponent getMessage() {
      return this.message;
   }

   public EventChat(IChatComponent var1) {
      this.message = var1;
   }
}
