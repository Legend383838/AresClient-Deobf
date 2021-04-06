package Ares.Imgur;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import net.minecraft.client.Minecraft;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class ScreenshotRunnable implements Runnable {
   private boolean processing;
   private String host;
   private BufferedImage screenshot;

   public boolean isProcessing() {
      return this.processing;
   }

   public void run() {
      this.processing = true;
      if (this.host.equals("imgur")) {
         try {
            ImageHost var1 = (ImageHost)ImageHost.imageHosts.get("imgur");
            var1.upload(this.screenshot, ImageHost.UPLOAD_METHOD.ANON);
            String var2 = var1.getLink();
            ChatComponentText var3 = new ChatComponentText(EnumChatFormatting.GREEN + "Uploaded screenshot at " + EnumChatFormatting.WHITE.toString() + EnumChatFormatting.UNDERLINE + var2);
            var3.getChatStyle().setChatClickEvent(new ClickEvent(Action.OPEN_URL, var2));
            Minecraft.getMinecraft().thePlayer.addChatMessage(var3);
            addToClipboard(var2);
            var1.upload(this.screenshot, ImageHost.UPLOAD_METHOD.ANON);
         } catch (Exception var4) {
         }
      }

      this.processing = false;
   }

   public ScreenshotRunnable(String var1, BufferedImage var2) {
      this.screenshot = var2;
      this.host = var1;
   }

   public BufferedImage get() {
      return this.processing ? null : this.screenshot;
   }

   public static void addToClipboard(String var0) {
      StringSelection var1 = new StringSelection(var0);
      Clipboard var2 = Toolkit.getDefaultToolkit().getSystemClipboard();
      var2.setContents(var1, var1);
   }
}
