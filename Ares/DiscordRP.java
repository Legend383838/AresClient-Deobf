package Ares;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.DiscordRichPresence.Builder;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class DiscordRP {
   private boolean running = true;
   private long created = 0L;
   public static String ip = "";

   public void update(String var1, String var2, String var3) {
      Builder var4 = new Builder(var2);
      var4.setBigImage(var3, "");
      var4.setDetails(var1);
      var4.setStartTimestamps(this.created);
      DiscordRPC.discordUpdatePresence(var4.build());
   }

   static boolean access$0(DiscordRP var0) {
      return var0.running;
   }

   public void shutdown() {
      this.running = false;
      DiscordRPC.discordShutdown();
   }

   public void updatepicture(String var1) {
   }

   public void start() {
      this.created = System.currentTimeMillis();
      DiscordEventHandlers var1 = (new net.arikia.dev.drpc.DiscordEventHandlers.Builder()).setReadyEventHandler(new ReadyCallback(this) {
         final DiscordRP this$0;

         public void apply(DiscordUser var1) {
            System.out.println("Websome" + var1.username + "#" + var1.discriminator + ".");
            this.this$0.update("Booting up...", "", "main2");
         }

         {
            this.this$0 = var1;
         }
      }).build();
      DiscordRPC.discordInitialize("751919026401312778", var1, true);
      (new Thread(this, "Discord RPC Callback") {
         final DiscordRP this$0;

         {
            this.this$0 = var1;
         }

         public void run() {
            while(DiscordRP.access$0(this.this$0)) {
               DiscordRPC.discordRunCallbacks();
            }

         }
      }).start();
   }
}
