package Ares.event;

import java.lang.reflect.Method;

public class EventData {
   public final Object source;
   public final byte priority;
   public final Method target;

   public EventData(Object var1, Method var2, byte var3) {
      this.source = var1;
      this.target = var2;
      this.priority = var3;
   }
}
