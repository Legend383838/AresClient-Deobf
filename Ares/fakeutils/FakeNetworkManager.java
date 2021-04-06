package Ares.fakeutils;

import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;

public class FakeNetworkManager extends NetworkManager {
   public FakeNetworkManager(EnumPacketDirection var1) {
      super(var1);
   }
}
