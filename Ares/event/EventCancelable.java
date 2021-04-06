package Ares.event;

public class EventCancelable extends Event {
   private boolean cancelled = false;

   public void setCancelled(boolean var1) {
      this.cancelled = var1;
   }

   public boolean isCancelled() {
      return this.cancelled;
   }
}
