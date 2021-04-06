package Ares.event.gui;

import Ares.event.gui.hud.HUDManager;
import Ares.event.gui.hud.IRenderer;
import Ares.mods.Mod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiListExtended.IGuiListEntry;

public class ScrollListModToggle extends GuiListExtended {
   private final List<ModEntry> entrys = new ArrayList();

   protected int getSize() {
      return this.entrys.size();
   }

   public ScrollListModToggle(Minecraft var1, GuiModToggle var2) {
      super(var1, GuiModToggle.width, GuiModToggle.height, 63, GuiModToggle.height - 32, 20);
      Iterator var4 = HUDManager.getInstance().getRegisteredRenderers().iterator();

      while(var4.hasNext()) {
         IRenderer var3 = (IRenderer)var4.next();
         if (var3 instanceof Mod) {
            Mod var5 = (Mod)var3;
            this.entrys.add(new ModEntry(var2, var5));
         }
      }

      Collections.sort(this.entrys);
   }

   public IGuiListEntry getListEntry(int var1) {
      return (IGuiListEntry)this.entrys.get(var1);
   }
}
