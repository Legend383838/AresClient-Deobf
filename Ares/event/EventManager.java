package Ares.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class EventManager {
   private static final Map<Class<? extends Event>, ArrayList<EventData>> REGISTRY_MAP = new HashMap();

   private static boolean isMethodBad(Method var0) {
      return var0.getParameterTypes().length != 1 || !var0.isAnnotationPresent(EventTarget.class);
   }

   private static boolean isMethodBad(Method var0, Class<? extends Event> var1) {
      return isMethodBad(var0) || var0.getParameterTypes()[0].equals(var1);
   }

   public static void register(Object var0, Class<? extends Event> var1) {
      Method[] var5;
      int var4 = (var5 = var0.getClass().getMethods()).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Method var2 = var5[var3];
         if (!isMethodBad(var2, var1)) {
            register(var2, var0);
         }
      }

   }

   public static void register(Object var0) {
      Method[] var4;
      int var3 = (var4 = var0.getClass().getMethods()).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         Method var1 = var4[var2];
         if (!isMethodBad(var1)) {
            register(var1, var0);
         }
      }

   }

   public static void cleanMap(boolean var0) {
      Iterator var1 = REGISTRY_MAP.entrySet().iterator();

      while(true) {
         do {
            if (!var1.hasNext()) {
               return;
            }
         } while(var0 && !((ArrayList)((Entry)var1.next()).getValue()).isEmpty());

         var1.remove();
      }
   }

   public static ArrayList<EventData> get(Class<? extends Event> var0) {
      return (ArrayList)REGISTRY_MAP.get(var0);
   }

   public static void unregister(Object var0) {
      Iterator var2 = REGISTRY_MAP.values().iterator();

      while(var2.hasNext()) {
         ArrayList var1 = (ArrayList)var2.next();

         for(int var3 = var1.size() - 1; var3 >= 0; --var3) {
            if (((EventData)var1.get(var3)).source.equals(var0)) {
               var1.remove(var3);
            }
         }
      }

      cleanMap(true);
   }

   private static void sortListValue(Class<? extends Event> var0) {
      ArrayList var1 = new ArrayList();
      byte[] var5;
      int var4 = (var5 = EventPriority.VALUE_ARRAY).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         byte var2 = var5[var3];
         Iterator var7 = ((ArrayList)REGISTRY_MAP.get(var0)).iterator();

         while(var7.hasNext()) {
            EventData var6 = (EventData)var7.next();
            if (var6.priority == var2) {
               var1.add(var6);
            }
         }
      }

      REGISTRY_MAP.put(var0, var1);
   }

   public static void register(Method var0, Object var1) {
      Class var2 = var0.getParameterTypes()[0];
      EventData var3 = new EventData(var1, var0, ((EventTarget)var0.getAnnotation(EventTarget.class)).value());
      if (!var3.target.isAccessible()) {
         var3.target.setAccessible(true);
      }

      if (REGISTRY_MAP.containsKey(var2)) {
         if (!((ArrayList)REGISTRY_MAP.get(var2)).contains(var3)) {
            ((ArrayList)REGISTRY_MAP.get(var2)).add(var3);
            sortListValue(var2);
         }
      } else {
         REGISTRY_MAP.put(var2, new ArrayList<EventData>(var3) {
            {
               this.add(var1);
            }
         });
      }

   }

   public static void unregister(Object var0, Class<? extends Event> var1) {
      if (REGISTRY_MAP.containsKey(var1)) {
         Iterator var3 = ((ArrayList)REGISTRY_MAP.get(var1)).iterator();

         while(var3.hasNext()) {
            EventData var2 = (EventData)var3.next();
            if (var2.source.equals(var0)) {
               ((ArrayList)REGISTRY_MAP.get(var1)).remove(var2);
            }
         }
      }

      cleanMap(true);
   }
}
