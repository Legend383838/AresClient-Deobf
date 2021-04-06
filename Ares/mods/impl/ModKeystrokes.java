package Ares.mods.impl;

import Ares.GuiIngameMods;
import Ares.GuiIngameSettings;
import Ares.GuiKeystrokes;
import Ares.event.gui.hud.ScreenPosition;
import Ares.mods.ModDraggable;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class ModKeystrokes extends ModDraggable {
   private boolean wasPressed2;
   private List<Long> clicks;
   private List<Long> clicks2;
   private long lastPressed;
   private long lastPressed2;
   private boolean wasPressed;
   private ModKeystrokes.KeystrokesMode mode;

   public ModKeystrokes() {
      this.mode = ModKeystrokes.KeystrokesMode.WASD_SNEAK_MOUSE;
      this.clicks = new ArrayList();
      this.clicks2 = new ArrayList();
   }

   private int getCPS2() {
      long var1 = System.currentTimeMillis();
      this.clicks2.removeIf(ModKeystrokes::lambda$1);
      return this.clicks2.size();
   }

   public void setMode(ModKeystrokes.KeystrokesMode var1) {
      this.mode = var1;
   }

   private int getRainbow(int var1, int var2) {
      float var3 = (float)((System.currentTimeMillis() + (long)var2) % (long)var1);
      var3 /= (float)var1;
      return Color.getHSBColor(var3, 1.0F, 1.0F).getRGB();
   }

   public void render(ScreenPosition var1) {
      if (GuiIngameMods.Keystrokes.contains("on")) {
         if (GuiKeystrokes.Style.contains("1")) {
            this.mode = ModKeystrokes.KeystrokesMode.WASD_SNEAK_MOUSE;
         }

         if (GuiKeystrokes.Style.contains("2")) {
            this.mode = ModKeystrokes.KeystrokesMode.WASD;
         }

         if (GuiKeystrokes.Style.contains("3")) {
            this.mode = ModKeystrokes.KeystrokesMode.WASD_SNEAK;
         }

         if (GuiKeystrokes.Style.contains("4")) {
            this.mode = ModKeystrokes.KeystrokesMode.WASD_JUMP;
         }

         boolean var2 = Mouse.isButtonDown(0);
         boolean var3 = Mouse.isButtonDown(1);
         if (var2 != this.wasPressed) {
            this.lastPressed = System.currentTimeMillis() + 10L;
            this.wasPressed = var2;
            if (var2) {
               this.clicks.add(this.lastPressed);
            }
         }

         if (var3 != this.wasPressed2) {
            this.lastPressed2 = System.currentTimeMillis() + 10L;
            this.wasPressed2 = var3;
            if (var3) {
               this.clicks2.add(this.lastPressed2);
            }
         }

         GL11.glPushMatrix();
         ModKeystrokes.Key[] var7;
         int var6 = (var7 = this.mode.getKeys()).length;

         for(int var5 = 0; var5 < var6; ++var5) {
            ModKeystrokes.Key var4 = var7[var5];
            int var8 = this.font.getStringWidth(var4.getName());
            Gui.drawRect(var1.getAbsoluteX() + var4.getX(), var1.getAbsoluteY() + var4.getY(), var1.getAbsoluteX() + var4.getX() + var4.getWidth(), var1.getAbsoluteY() + var4.getY() + var4.getHeight(), var4.isDown() ? (new Color(255, 255, 255, 102)).getRGB() : (new Color(0, 0, 0, 150)).getRGB());
            if (GuiKeystrokes.Rainbow == 1) {
               this.font.drawString(var4.getName(), var1.getAbsoluteX() + var4.getX() + var4.getWidth() / 2 - var8 / 2, var1.getAbsoluteY() + var4.getY() + var4.getHeight() / 2 - 4, var4.isDown() ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }

            if (GuiKeystrokes.Rainbow == 2) {
               this.font.drawString(var4.getName(), var1.getAbsoluteX() + var4.getX() + var4.getWidth() / 2 - var8 / 2, var1.getAbsoluteY() + var4.getY() + var4.getHeight() / 2 - 4, var4.isDown() ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }

            if (GuiKeystrokes.Rainbow == 1) {
               Render.drawChromaString(var4.getName(), var1.getAbsoluteX() + var4.getX() + var4.getWidth() / 2 - var8 / 2, var1.getAbsoluteY() + var4.getY() + var4.getHeight() / 2 - 4, true);
            }

            if (GuiKeystrokes.Rainbow == 0) {
               this.font.drawString(var4.getName(), var1.getAbsoluteX() + var4.getX() + var4.getWidth() / 2 - var8 / 2, var1.getAbsoluteY() + var4.getY() + var4.getHeight() / 2 - 4, var4.isDown() ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }

            if (GuiKeystrokes.Clicks == 1 && GuiKeystrokes.LMB == 1 && ModKeystrokes.Key.access$6(var4)) {
               GlStateManager.pushMatrix();
               GlStateManager.scale(0.5F, 0.5F, 0.5F);
               GlStateManager.translate((float)(var1.getAbsoluteX() + var4.getX() + var4.getWidth() / 2) - (float)var8 / 2.0F, (float)(var1.getAbsoluteY() + var4.getY() + var4.getHeight() / 2) + 4.0F, 1.0F);
               if (var4.getName().matches(ModKeystrokes.Key.access$4().getName())) {
                  this.font.drawString("CPS: " + this.getCPS(), var1.getAbsoluteX() + var4.getX() + var4.getWidth() / 2 - var8 / 2, var1.getAbsoluteY() + var4.getY() + var4.getHeight() / 2 + 4, -1);
               }

               if (var4.getName().matches(ModKeystrokes.Key.access$5().getName())) {
                  this.font.drawString("CPS: " + this.getCPS2(), var1.getAbsoluteX() + var4.getX() + var4.getWidth() / 2 - var8 / 2, var1.getAbsoluteY() + var4.getY() + var4.getHeight() / 2 + 4, -1);
               }

               GlStateManager.popMatrix();
            }

            this.font.drawString("§f", var1.getAbsoluteX() + var4.getX() + var4.getWidth() / 2 - var8 / 2, var1.getAbsoluteY() + var4.getY() + var4.getHeight() / 2 + 4, -1);
         }

         GL11.glPopMatrix();
      }

   }

   private static boolean lambda$0(long var0, Long var2) {
      return var2 + 1000L < var0;
   }

   public int getWidth() {
      return this.mode.getWidth();
   }

   private int getCPS() {
      long var1 = System.currentTimeMillis();
      this.clicks.removeIf(ModKeystrokes::lambda$0);
      return this.clicks.size();
   }

   private static boolean lambda$1(long var0, Long var2) {
      return var2 + 1000L < var0;
   }

   public int getHeight() {
      return this.mode.getHeight();
   }

   public void renderDummy(ScreenPosition var1) {
      if (GuiIngameMods.Keystrokes.contains("on")) {
         GL11.glPushMatrix();
         ModKeystrokes.Key[] var5;
         int var4 = (var5 = this.mode.getKeys()).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            ModKeystrokes.Key var2 = var5[var3];
            int var6 = this.font.getStringWidth(var2.getName());
            Gui.drawRect(var1.getAbsoluteX() + var2.getX(), var1.getAbsoluteY() + var2.getY(), var1.getAbsoluteX() + var2.getX() + var2.getWidth(), var1.getAbsoluteY() + var2.getY() + var2.getHeight(), var2.isDown() ? (new Color(255, 255, 255, 102)).getRGB() : (new Color(0, 0, 0, 150)).getRGB());
            if (GuiIngameSettings.ModStyle == 1) {
               this.font.drawString(var2.getName(), var1.getAbsoluteX() + var2.getX() + var2.getWidth() / 2 - var6 / 2, var1.getAbsoluteY() + var2.getY() + var2.getHeight() / 2 - 4, var2.isDown() ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }

            if (GuiIngameSettings.ModStyle == 2) {
               this.font.drawString(var2.getName(), var1.getAbsoluteX() + var2.getX() + var2.getWidth() / 2 - var6 / 2, var1.getAbsoluteY() + var2.getY() + var2.getHeight() / 2 - 4, var2.isDown() ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }

            if (GuiIngameSettings.ModStyle == 3) {
               Render.drawChromaString(var2.getName(), var1.getAbsoluteX() + var2.getX() + var2.getWidth() / 2 - var6 / 2, var1.getAbsoluteY() + var2.getY() + var2.getHeight() / 2 - 4, true);
            }

            if (GuiIngameSettings.ModStyle == 0) {
               this.font.drawString(var2.getName(), var1.getAbsoluteX() + var2.getX() + var2.getWidth() / 2 - var6 / 2, var1.getAbsoluteY() + var2.getY() + var2.getHeight() / 2 - 4, var2.isDown() ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
         }

         GL11.glPopMatrix();
      }

   }

   public static enum KeystrokesMode {
      WASD_SNEAK_MOUSE(new ModKeystrokes.Key[]{ModKeystrokes.Key.access$0(), ModKeystrokes.Key.access$1(), ModKeystrokes.Key.access$2(), ModKeystrokes.Key.access$4(), ModKeystrokes.Key.access$5(), ModKeystrokes.Key.access$3(), new ModKeystrokes.Key("Sneak", Minecraft.getMinecraft().gameSettings.keyBindSneak, 1, 61, 58, 18, false)}),
      WASD_MOUSE(new ModKeystrokes.Key[]{ModKeystrokes.Key.access$0(), ModKeystrokes.Key.access$1(), ModKeystrokes.Key.access$2(), ModKeystrokes.Key.access$1(), ModKeystrokes.Key.access$4(), ModKeystrokes.Key.access$5()}),
      WASD_JUMP(new ModKeystrokes.Key[]{ModKeystrokes.Key.access$0(), ModKeystrokes.Key.access$1(), ModKeystrokes.Key.access$2(), ModKeystrokes.Key.access$3(), new ModKeystrokes.Key("Jump", Minecraft.getMinecraft().gameSettings.keyBindJump, 1, 41, 58, 18, false)});

      private static final ModKeystrokes.KeystrokesMode[] ENUM$VALUES = new ModKeystrokes.KeystrokesMode[]{WASD, WASD_MOUSE, WASD_SNEAK, WASD_JUMP, WASD_SNEAK_MOUSE};
      WASD_SNEAK(new ModKeystrokes.Key[]{ModKeystrokes.Key.access$0(), ModKeystrokes.Key.access$1(), ModKeystrokes.Key.access$2(), ModKeystrokes.Key.access$3(), new ModKeystrokes.Key("Sneak", Minecraft.getMinecraft().gameSettings.keyBindSneak, 1, 41, 58, 18, false)});

      private int height = 0;
      private final ModKeystrokes.Key[] keys;
      WASD(new ModKeystrokes.Key[]{ModKeystrokes.Key.access$0(), ModKeystrokes.Key.access$1(), ModKeystrokes.Key.access$2(), ModKeystrokes.Key.access$3()});

      private int width = 0;

      private KeystrokesMode(ModKeystrokes.Key... var3) {
         this.keys = var3;
         ModKeystrokes.Key[] var7;
         int var6 = (var7 = this.keys).length;

         for(int var5 = 0; var5 < var6; ++var5) {
            ModKeystrokes.Key var4 = var7[var5];
            this.width = Math.max(this.width, var4.getX() + var4.getWidth());
            this.height = Math.max(this.height, var4.getY() + var4.getHeight());
         }

      }

      public ModKeystrokes.Key[] getKeys() {
         return this.keys;
      }

      public int getWidth() {
         return this.width;
      }

      public int getHeight() {
         return this.height;
      }
   }

   private static class Key {
      private static final ModKeystrokes.Key D;
      private static final ModKeystrokes.Key RMB;
      private static final ModKeystrokes.Key S;
      private final boolean cps;
      private final KeyBinding keyBind;
      private static final ModKeystrokes.Key W;
      private final int x;
      private final int y;
      private static final ModKeystrokes.Key LMB;
      private final int height;
      private static final ModKeystrokes.Key A;
      private final String name;
      private final int width;

      static ModKeystrokes.Key access$0() {
         return W;
      }

      public int getHeight() {
         return this.height;
      }

      static ModKeystrokes.Key access$5() {
         return RMB;
      }

      public int getY() {
         return this.y;
      }

      static ModKeystrokes.Key access$2() {
         return S;
      }

      static boolean access$6(ModKeystrokes.Key var0) {
         return var0.cps;
      }

      static ModKeystrokes.Key access$4() {
         return LMB;
      }

      public boolean isDown() {
         return this.keyBind.isKeyDown();
      }

      static ModKeystrokes.Key access$3() {
         return D;
      }

      static {
         W = new ModKeystrokes.Key("W", Minecraft.getMinecraft().gameSettings.keyBindForward, 21, 1, 18, 18, false);
         A = new ModKeystrokes.Key("A", Minecraft.getMinecraft().gameSettings.keyBindLeft, 1, 21, 18, 18, false);
         S = new ModKeystrokes.Key("S", Minecraft.getMinecraft().gameSettings.keyBindBack, 21, 21, 18, 18, false);
         D = new ModKeystrokes.Key("D", Minecraft.getMinecraft().gameSettings.keyBindRight, 41, 21, 18, 18, false);
         LMB = new ModKeystrokes.Key("LMB", Minecraft.getMinecraft().gameSettings.keyBindAttack, 1, 41, 28, 18, true);
         RMB = new ModKeystrokes.Key("RMB", Minecraft.getMinecraft().gameSettings.keyBindUseItem, 31, 41, 28, 18, true);
      }

      public int getX() {
         return this.x;
      }

      public String getName() {
         return this.name;
      }

      public Key(String var1, KeyBinding var2, int var3, int var4, int var5, int var6, boolean var7) {
         this.name = var1;
         this.keyBind = var2;
         this.x = var3;
         this.y = var4;
         this.width = var5;
         this.height = var6;
         this.cps = var7;
      }

      static ModKeystrokes.Key access$1() {
         return A;
      }

      public int getWidth() {
         return this.width;
      }
   }
}
