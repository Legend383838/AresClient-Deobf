package Ares.mods;

import Ares.Client;
import Ares.event.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Mod {
   protected final Client client;
   protected final FontRenderer font;
   protected final Minecraft mc = Minecraft.getMinecraft();
   public boolean isEnabled = true;

   public void setEnabled(boolean var1) {
      this.isEnabled = var1;
      if (var1) {
         EventManager.register(this);
      } else {
         EventManager.unregister(this);
      }

   }

   public Mod() {
      this.font = this.mc.fontRendererObj;
      this.client = Client.getInstance();
      this.setEnabled(this.isEnabled);
   }

   public boolean isEnabled() {
      return this.isEnabled;
   }
}
