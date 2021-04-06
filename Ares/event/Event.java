package Ares.event;

import java.util.ArrayList;
import java.util.Iterator;

public class Event {
   public Event call() {
      ArrayList var1 = EventManager.get(this.getClass());
      if (var1 != null) {
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            EventData var2 = (EventData)var3.next();

            try {
               var2.target.invoke(var2.source, this);
            } catch (Exception var5) {
               var5.printStackTrace();
            }
         }
      }

      return this;
   }
}
