package Ares.mods;

import Ares.FileManager;
import Ares.event.gui.hud.IRenderer;
import Ares.event.gui.hud.ScreenPosition;
import java.io.File;

public abstract class ModDraggable extends Mod implements IRenderer {
   protected ScreenPosition pos = this.loadPositionFromFile();

   private File getFolder() {
      File var1 = new File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
      var1.mkdirs();
      return var1;
   }

   private int getLineOffset(int var1) {
      return (this.font.FONT_HEIGHT + 3) * var1;
   }

   private void savePositionToFile() {
      FileManager.writeJsonToFile(new File(this.getFolder(), "pos.json"), this.pos);
   }

   private ScreenPosition loadPositionFromFile() {
      ScreenPosition var1 = (ScreenPosition)FileManager.readFromJson(new File(this.getFolder(), "pos.json"), ScreenPosition.class);
      if (var1 == null) {
         var1 = ScreenPosition.fromRalativePosition(0.5D, 0.5D);
         this.pos = var1;
         this.savePositionToFile();
      }

      return var1;
   }

   public ScreenPosition load() {
      return this.pos;
   }

   public void save(ScreenPosition var1) {
      this.pos = var1;
      this.savePositionToFile();
   }

   public final int getLineOffset(ScreenPosition var1, int var2) {
      return var1.getAbsoluteY() + this.getLineOffset(var2);
   }
}
