package Ares.event.gui.hud;

import Ares.event.EventManager;
import Ares.event.EventTarget;
import Ares.event.impl.RenderEvent;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;

public class HUDManager {
   private static HUDManager instance = null;
   private Set<IRenderer> registeredRenderers = Sets.newHashSet();
   private Minecraft mc = Minecraft.getMinecraft();

   private HUDManager() {
   }

   public static HUDManager getInstance() {
      if (instance != null) {
         return instance;
      } else {
         instance = new HUDManager();
         EventManager.register(instance);
         return instance;
      }
   }

   public void register(IRenderer... var1) {
      IRenderer[] var5 = var1;
      int var4 = var1.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         IRenderer var2 = var5[var3];
         this.registeredRenderers.add(var2);
      }

   }

   public void unreister(IRenderer... var1) {
      IRenderer[] var5 = var1;
      int var4 = var1.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         IRenderer var2 = var5[var3];
         this.registeredRenderers.remove(var2);
      }

   }

   public Collection<IRenderer> getRegisteredRenderers() {
      return Sets.newHashSet(this.registeredRenderers);
   }

   public void openConfigScreen() {
      this.mc.displayGuiScreen(new HUDConfigScreen(this));
   }

   @EventTarget
   public void onRender(RenderEvent var1) {
      if (this.mc.currentScreen == null || this.mc.currentScreen instanceof GuiChat) {
         if (this.mc.gameSettings.showDebugInfo) {
            return;
         }

         Iterator var3 = this.registeredRenderers.iterator();

         while(var3.hasNext()) {
            IRenderer var2 = (IRenderer)var3.next();
            this.callRanderer(var2);
         }
      }

   }

   private void callRanderer(IRenderer var1) {
      if (var1.isEnabled()) {
         ScreenPosition var2 = var1.load();
         if (var2 == null) {
            var2 = ScreenPosition.fromRalativePosition(0.5D, 0.5D);
         }

         var1.render(var2);
      }
   }
}
