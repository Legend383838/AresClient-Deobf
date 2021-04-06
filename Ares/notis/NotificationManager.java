package Ares.notis;

import java.util.concurrent.LinkedBlockingQueue;

public class NotificationManager {
   private static LinkedBlockingQueue<Notification> pendingNotifications = new LinkedBlockingQueue();
   private static Notification currentNotification = null;

   public static void update() {
      if (currentNotification != null && !currentNotification.isShown()) {
         currentNotification = null;
      }

      if (currentNotification == null && !pendingNotifications.isEmpty()) {
         currentNotification = (Notification)pendingNotifications.poll();
         currentNotification.show();
      }

   }

   public static void show(Notification var0) {
      pendingNotifications.add(var0);
   }

   public static void render() {
      update();
      if (currentNotification != null) {
         currentNotification.render();
      }

   }
}
