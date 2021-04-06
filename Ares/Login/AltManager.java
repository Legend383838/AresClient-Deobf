package Ares.Login;

import java.util.ArrayList;

public class AltManager {
   public static Alt lastAlt;
   public static ArrayList<Alt> registry = new ArrayList();

   public ArrayList<Alt> getRegistry() {
      return registry;
   }

   public void setLastAlt(Alt var1) {
      lastAlt = var1;
   }
}
