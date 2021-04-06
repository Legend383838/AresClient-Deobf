package Ares.radio;

import java.io.InputStream;
import java.util.Objects;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Radio {
   private Player player;
   private Thread thread;

   public boolean isRunning() {
      return this.thread != null;
   }

   public void start() {
      Objects.requireNonNull(this.player);
      this.thread = new Thread(this::lambda$0);
      this.thread.start();
   }

   public void stop() {
      if (this.isRunning()) {
         this.thread.interrupt();
         this.thread = null;
         if (this.player != null) {
            this.player.close();
         }
      }

   }

   public void setStream(InputStream var1) {
      try {
         this.player = new Player(var1);
      } catch (JavaLayerException var3) {
         var3.printStackTrace();
      }

   }

   private void lambda$0() {
      try {
         this.player.play();
      } catch (JavaLayerException var2) {
         var2.printStackTrace();
      }

   }
}
