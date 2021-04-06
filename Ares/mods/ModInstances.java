package Ares.mods;

import Ares.event.gui.ModEntry;
import Ares.event.gui.hud.HUDManager;
import Ares.mods.impl.DistanceBetween;
import Ares.mods.impl.ModArmorStatus;
import Ares.mods.impl.ModClicks;
import Ares.mods.impl.ModCoords;
import Ares.mods.impl.ModCurrentItem;
import Ares.mods.impl.ModCustom;
import Ares.mods.impl.ModDamageIndicator;
import Ares.mods.impl.ModDeaths;
import Ares.mods.impl.ModFps;
import Ares.mods.impl.ModHelloWorld;
import Ares.mods.impl.ModItemCounter;
import Ares.mods.impl.ModKeystrokes;
import Ares.mods.impl.ModPerspective;
import Ares.mods.impl.ModPing;
import Ares.mods.impl.ModPlayer;
import Ares.mods.impl.ModPlayername;
import Ares.mods.impl.ModPotionStatus;
import Ares.mods.impl.ModRadio;
import Ares.mods.impl.ModReachDisplay;
import Ares.mods.impl.ModTest;
import Ares.mods.impl.ModTime;
import Ares.mods.impl.togglesprintsneak.ModToggleSprintSneak;

public class ModInstances {
   private static ModRadio modRadio;
   private static ModTime modTime;
   public static int ModPlayernamee = 0;
   private static ModClicks modClicks;
   private static DistanceBetween distanceBetween;
   private static ModCurrentItem modCurrentItem;
   private static ModKeystrokes modKeystrokes;
   private static ModCustom modCustom;
   private static ModReachDisplay modReachDisplay;
   private static ModItemCounter modItemCounter;
   private static ModPlayer modPlayer;
   private static ModPlayername modPlayername;
   private static ModToggleSprintSneak modToggleSprintSneak;
   private static ModTest modTest;
   private static ModPing modPing;
   private static ModHelloWorld modHelloWorld;
   private static ModDeaths modDeaths;
   private static ModArmorStatus modArmorStatus;
   private static ModEntry modEntry;
   private static ModPotionStatus modPotionStatus;
   private static ModFps modFps;
   private static ModPerspective modPerspective;
   private static ModCoords modCoords;
   private static ModDamageIndicator modDamageIndicator;

   public static ModHelloWorld getModHelloWorld() {
      return modHelloWorld;
   }

   public static void register(HUDManager var0) {
      modArmorStatus = new ModArmorStatus();
      var0.register(modArmorStatus);
      modPerspective = new ModPerspective();
      var0.register(modPerspective);
      modCustom = new ModCustom();
      var0.register(modCustom);
      modClicks = new ModClicks();
      var0.register(modClicks);
      modDamageIndicator = new ModDamageIndicator();
      var0.register(modDamageIndicator);
      modReachDisplay = new ModReachDisplay();
      var0.register(modReachDisplay);
      modPotionStatus = new ModPotionStatus();
      var0.register(modPotionStatus);
      modPlayername = new ModPlayername();
      var0.register(modPlayername);
      modItemCounter = new ModItemCounter();
      var0.register(modItemCounter);
      modTime = new ModTime();
      var0.register(modTime);
      modPlayer = new ModPlayer();
      var0.register(modPlayer);
      modCoords = new ModCoords();
      var0.register(modCoords);
      modFps = new ModFps();
      var0.register(modFps);
      modToggleSprintSneak = new ModToggleSprintSneak();
      var0.register(modToggleSprintSneak);
      modKeystrokes = new ModKeystrokes();
      var0.register(modKeystrokes);
   }

   public static ModToggleSprintSneak getModToggleSprintSneak() {
      return modToggleSprintSneak;
   }

   public static ModPerspective getModPerspective() {
      return modPerspective;
   }
}
