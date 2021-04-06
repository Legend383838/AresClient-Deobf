package Ares;

import Ares.event.EventManager;
import Ares.event.EventTarget;
import Ares.event.gui.hud.HUDManager;
import Ares.event.impl.ClientTickEvent;
import Ares.mods.ModInstances;
import net.minecraft.client.Minecraft;

public class Client {
   public boolean tpose = false;
   public boolean alreadyExecuted;
   private HUDManager hudManager;
   public boolean dab = false;
   private DiscordRP discordRP = new DiscordRP();
   private static final Client INSTANCE = new Client();
   public boolean alreadyExecuted2;

   public void shutdown() {
      this.discordRP.shutdown();
   }

   public void init() {
      FileManager.init();
      EventManager.register(this);
      EventManager.register(new TestClass());
      this.discordRP.start();
   }

   public DiscordRP getDiscordRP() {
      return this.discordRP;
   }

   public void cleanGL() {
   }

   public static final Client getInstance() {
      return INSTANCE;
   }

   @EventTarget
   public void onTick(ClientTickEvent var1) {
      if (Minecraft.getMinecraft().gameSettings.dab.isKeyDown()) {
         this.dab = true;
         if (!this.alreadyExecuted && !Minecraft.getMinecraft().isSingleplayer()) {
            this.alreadyExecuted = true;
         }
      }

      if (!Minecraft.getMinecraft().gameSettings.dab.isKeyDown()) {
         this.dab = false;
         this.alreadyExecuted = false;
      }

   }

   public void start() {
      this.hudManager = HUDManager.getInstance();
      ModInstances.register(this.hudManager);
   }
}
