package Ares;

import Ares.notis.Notification;
import Ares.notis.NotificationManager;
import Ares.notis.NotificationType;
import Ares.radio.Radio;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.C14PacketTabComplete;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GuiMusikPlayer extends GuiScreen {
   private boolean waitingOnAutocomplete;
   private String defaultInputFieldText = "";
   private boolean playerNamesFound;
   private int autocompleteIndex;
   private static final Logger logger = LogManager.getLogger();
   private String historyBuffer = "";
   public static String URL = "http://stream.laut.fm/my-webradio";
   public static int Dance = 1;
   protected GuiTextField inputField;
   private int sentHistoryCursor = -1;
   public static String NowPlaying = "NCS Sounds";
   public static Radio radio = new Radio();
   private List<String> foundPlayerNames = Lists.newArrayList();
   public static int Danceonoff = 0;

   public void drawScreen(int var1, int var2, float var3) {
      RadioLogo.drawRotatingScaledLogo((float)(width / 2), (float)(height / 2), 150);
      super.drawScreen(var1, var2, var3);
   }

   public void updateScreen() {
      this.inputField.updateCursorCounter();
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 0) {
         radio.setStream((new URL(URL)).openStream());
         radio.start();
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§eRadio§f] on"));
         NotificationManager.show(new Notification(NotificationType.INFO, "Radio on", "Now Playing: " + NowPlaying, 1));
      }

      if (var1.id == 1) {
         radio.stop();
         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§f[§eRadio§f] off"));
         NotificationManager.show(new Notification(NotificationType.INFO, "Radio of", "Now Playing: Nothing", 1));
      }

      if (var1.id == 2) {
         radio.stop();
         URL = "http://stream.laut.fm/my-webradio";
         RadioLogo.Radio = 1;
         NowPlaying = "NCS";
         NotificationManager.show(new Notification(NotificationType.INFO, "Radio", "Now Playing: " + NowPlaying, 1));
         radio.setStream((new URL(URL)).openStream());
         radio.start();
      }

      if (var1.id == 3) {
         radio.stop();
         URL = "https://streamer.radio.co/s2c3cc784b/listen";
         RadioLogo.Radio = 2;
         NowPlaying = "E-Swing";
         NotificationManager.show(new Notification(NotificationType.INFO, "Radio", "Now Playing: " + NowPlaying, 1));
         radio.setStream((new URL(URL)).openStream());
         radio.start();
      }

      if (var1.id == 4) {
         radio.stop();
         URL = "https://streams.ilovemusic.de/iloveradio1.mp3";
         RadioLogo.Radio = 3;
         NowPlaying = "ILoveRadio";
         NotificationManager.show(new Notification(NotificationType.INFO, "Radio", "Now Playing: " + NowPlaying, 1));
         radio.setStream((new URL(URL)).openStream());
         radio.start();
      }

      if (var1.id == 5) {
         radio.stop();
         URL = "https://streams.ilovemusic.de/iloveradio13.mp3";
         RadioLogo.Radio = 4;
         NowPlaying = "US Rap";
         radio.setStream((new URL(URL)).openStream());
         radio.start();
         NotificationManager.show(new Notification(NotificationType.INFO, "Radio", "Now Playing: " + NowPlaying, 1));
      }

      if (var1.id == 6) {
         radio.stop();
         URL = "http://stream.laut.fm/eurobeat";
         RadioLogo.Radio = 5;
         NowPlaying = "Eurobeat";
         NotificationManager.show(new Notification(NotificationType.INFO, "Radio", "Now Playing: " + NowPlaying, 1));
         radio.setStream((new URL(URL)).openStream());
         radio.start();
      }

      if (var1.id == 7) {
         radio.stop();
         URL = "http://stream.laut.fm/nightcoremusic";
         RadioLogo.Radio = 6;
         NowPlaying = "Nightcore";
         NotificationManager.show(new Notification(NotificationType.INFO, "Radio", "Now Playing: " + NowPlaying, 1));
         radio.setStream((new URL(URL)).openStream());
         radio.start();
      }

      if (var1.id == 8) {
         radio.stop();
         URL = "http://stream.laut.fm/lofi";
         RadioLogo.Radio = 7;
         NowPlaying = "Lofi / Chill";
         NotificationManager.show(new Notification(NotificationType.INFO, "Radio", "Now Playing: " + NowPlaying, 1));
         radio.setStream((new URL(URL)).openStream());
         radio.start();
      }

   }

   public void onGuiClosed() {
      Client.getInstance().getDiscordRP().update(DiscordRP.ip, "ign: " + Minecraft.getMinecraft().getSession().getUsername(), "main");
      Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
      Keyboard.enableRepeatEvents(false);
      this.mc.ingameGUI.getChatGUI().resetScroll();
      Danceonoff = 0;
   }

   public void autocompletePlayerNames() {
      String var2;
      if (this.playerNamesFound) {
         this.inputField.deleteFromCursor(this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false) - this.inputField.getCursorPosition());
         if (this.autocompleteIndex >= this.foundPlayerNames.size()) {
            this.autocompleteIndex = 0;
         }
      } else {
         int var1 = this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false);
         this.foundPlayerNames.clear();
         this.autocompleteIndex = 0;
         var2 = this.inputField.getText().substring(var1).toLowerCase();
         String var3 = this.inputField.getText().substring(0, this.inputField.getCursorPosition());
         this.sendAutocompleteRequest(var3, var2);
         if (this.foundPlayerNames.isEmpty()) {
            return;
         }

         this.playerNamesFound = true;
         this.inputField.deleteFromCursor(var1 - this.inputField.getCursorPosition());
      }

      if (this.foundPlayerNames.size() > 1) {
         StringBuilder var4 = new StringBuilder();

         for(Iterator var5 = this.foundPlayerNames.iterator(); var5.hasNext(); var4.append(var2)) {
            var2 = (String)var5.next();
            if (var4.length() > 0) {
               var4.append(", ");
            }
         }

         this.mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new ChatComponentText(var4.toString()), 1);
      }

      this.inputField.writeText((String)this.foundPlayerNames.get(this.autocompleteIndex++));
   }

   public void handleMouseInput() throws IOException {
      super.handleMouseInput();
      int var1 = Mouse.getEventDWheel();
      if (var1 != 0) {
         if (var1 > 1) {
            var1 = 1;
         }

         if (var1 < -1) {
            var1 = -1;
         }

         if (!isShiftKeyDown()) {
            var1 *= 7;
         }

         this.mc.ingameGUI.getChatGUI().scroll(var1);
      }

   }

   public void getSentHistory(int var1) {
      int var2 = this.sentHistoryCursor + var1;
      int var3 = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
      var2 = MathHelper.clamp_int(var2, 0, var3);
      if (var2 != this.sentHistoryCursor) {
         if (var2 == var3) {
            this.sentHistoryCursor = var3;
            this.inputField.setText(this.historyBuffer);
         } else {
            if (this.sentHistoryCursor == var3) {
               this.historyBuffer = this.inputField.getText();
            }

            this.inputField.setText((String)this.mc.ingameGUI.getChatGUI().getSentMessages().get(var2));
            this.sentHistoryCursor = var2;
         }
      }

   }

   public GuiMusikPlayer() {
   }

   public GuiMusikPlayer(String var1) {
      this.defaultInputFieldText = var1;
   }

   protected void keyTyped(char var1, int var2) throws IOException {
      this.waitingOnAutocomplete = false;
      if (var2 == 15) {
         this.autocompletePlayerNames();
      } else {
         this.playerNamesFound = false;
      }

      if (var2 == 1) {
         this.mc.displayGuiScreen((GuiScreen)null);
      } else if (var2 != 28 && var2 != 156) {
         if (var2 == 200) {
            this.getSentHistory(-1);
         } else if (var2 == 208) {
            this.getSentHistory(1);
         } else if (var2 == 201) {
            this.mc.ingameGUI.getChatGUI().scroll(this.mc.ingameGUI.getChatGUI().getLineCount() - 1);
         } else if (var2 == 209) {
            this.mc.ingameGUI.getChatGUI().scroll(-this.mc.ingameGUI.getChatGUI().getLineCount() + 1);
         } else {
            this.inputField.textboxKeyTyped(var1, var2);
         }
      } else {
         String var3 = this.inputField.getText().trim();
         if (var3.length() > 0) {
            this.sendChatMessage(var3);
         }

         this.mc.displayGuiScreen((GuiScreen)null);
      }

   }

   public void onAutocompleteResponse(String[] var1) {
      if (this.waitingOnAutocomplete) {
         this.playerNamesFound = false;
         this.foundPlayerNames.clear();
         String[] var5 = var1;
         int var4 = var1.length;

         String var2;
         for(int var3 = 0; var3 < var4; ++var3) {
            var2 = var5[var3];
            if (var2.length() > 0) {
               this.foundPlayerNames.add(var2);
            }
         }

         var2 = this.inputField.getText().substring(this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false));
         String var6 = StringUtils.getCommonPrefix(var1);
         if (var6.length() > 0 && !var2.equalsIgnoreCase(var6)) {
            this.inputField.deleteFromCursor(this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false) - this.inputField.getCursorPosition());
            this.inputField.writeText(var6);
         } else if (this.foundPlayerNames.size() > 0) {
            this.playerNamesFound = true;
            this.autocompletePlayerNames();
         }
      }

   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   public void initGui() {
      Client.getInstance().getDiscordRP().update("Listening to the Radio", "ign: " + Minecraft.getMinecraft().getSession().getUsername(), "radio");
      Danceonoff = 1;
      byte var1 = 30;
      this.buttonList.add(new GuiButton(2, 5, var1 + 5, 100, 20, I18n.format("NSC Radio", new Object[0])));
      this.buttonList.add(new GuiButton(3, 5, var1 + 30, 100, 20, I18n.format("Electro Swing", new Object[0])));
      this.buttonList.add(new GuiButton(4, 5, var1 + 55, 100, 20, I18n.format("I Love Radio", new Object[0])));
      this.buttonList.add(new GuiButton(5, 5, var1 + 80, 100, 20, I18n.format("US Rap", new Object[0])));
      this.buttonList.add(new GuiButton(6, 5, var1 + 105, 100, 20, I18n.format("Eurobeat", new Object[0])));
      this.buttonList.add(new GuiButton(7, 5, var1 + 130, 100, 20, I18n.format("Nightcore", new Object[0])));
      this.buttonList.add(new GuiButton(8, 5, var1 + 155, 100, 20, I18n.format("Lofi / Chill", new Object[0])));
      this.buttonList.add(new GuiButton(1, 5, var1 + 205, 100, 20, I18n.format("Stop", new Object[0])));
      Keyboard.enableRepeatEvents(true);
      this.sentHistoryCursor = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
      this.inputField = new GuiTextField(0, this.fontRendererObj, 4, height - 12, width - 4, 12);
      this.inputField.setMaxStringLength(100);
      this.inputField.setEnableBackgroundDrawing(false);
      this.inputField.setFocused(true);
      this.inputField.setText(this.defaultInputFieldText);
      this.inputField.setCanLoseFocus(false);
      boolean var2 = true;
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
   }

   protected void setText(String var1, boolean var2) {
      if (var2) {
         this.inputField.setText(var1);
      } else {
         this.inputField.writeText(var1);
      }

   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      if (var3 == 0) {
         IChatComponent var4 = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
         if (this.handleComponentClick(var4)) {
            return;
         }
      }

      this.inputField.mouseClicked(var1, var2, var3);
      super.mouseClicked(var1, var2, var3);
   }

   private void sendAutocompleteRequest(String var1, String var2) {
      if (var1.length() >= 1) {
         BlockPos var3 = null;
         if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == MovingObjectType.BLOCK) {
            var3 = this.mc.objectMouseOver.getBlockPos();
         }

         this.mc.thePlayer.sendQueue.addToSendQueue(new C14PacketTabComplete(var1, var3));
         this.waitingOnAutocomplete = true;
      }

   }
}
