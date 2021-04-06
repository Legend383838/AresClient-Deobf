package Ares.event.gui;

import Ares.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended.IGuiListEntry;
import org.apache.commons.lang3.StringUtils;

public class ModEntry implements IGuiListEntry, Comparable<ModEntry> {
   private final GuiModToggle gui;
   private final Mod mod;
   private final GuiCheckBox checkbox;
   private final String name;

   public void drawEntry(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      this.checkbox.xPosition = var2 + 200;
      this.checkbox.yPosition = var3;
      this.checkbox.drawButton(Minecraft.getMinecraft(), var6, var7);
      this.mod.setEnabled(this.checkbox.isChecked());
      this.gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, this.name, var2, var3 + 4, -1);
   }

   public boolean mousePressed(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.checkbox.mousePressed(Minecraft.getMinecraft(), var2, var3);
   }

   public void mouseReleased(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.checkbox.mouseReleased(var2, var3);
   }

   public ModEntry(GuiModToggle var1, Mod var2) {
      this.mod = var2;
      this.name = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(var2.getClass().getSimpleName().replace("Mod", "").replaceAll("\\d+", "")), " ");
      this.checkbox = new GuiCheckBox(0, 0, 0, var2.isEnabled());
      this.gui = var1;
   }

   public int compareTo(ModEntry var1) {
      return this.name.compareTo(var1.name);
   }

   public int compareTo(Object var1) {
      return this.compareTo((ModEntry)var1);
   }

   public void setSelected(int var1, int var2, int var3) {
   }
}
