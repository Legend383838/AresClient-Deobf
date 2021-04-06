package Ares.account;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class AccountManager {
   private ArrayList<Account> accounts = new ArrayList();
   private File altsFile;
   private String lastAlteningAlt;
   private Account lastAlt;
   private String alteningKey;
   private final Gson gson = (new GsonBuilder()).setPrettyPrinting().create();

   public void setAlteningKey(String var1) {
      this.alteningKey = var1;
   }

   public String getLastAlteningAlt() {
      return this.lastAlteningAlt;
   }

   private void lambda$1(JsonElement var1) {
      JsonObject var2 = (JsonObject)var1;
      Account var3 = new Account();
      var3.fromJson(var2);
      this.getAccounts().add(var3);
   }

   public void remove(String var1) {
      Iterator var3 = this.getAccounts().iterator();

      while(var3.hasNext()) {
         Account var2 = (Account)var3.next();
         if (var2.getName().equalsIgnoreCase(var1)) {
            this.getAccounts().remove(var2);
         }
      }

   }

   public AccountManager(File var1) {
      this.altsFile = new File(var1.toString() + File.separator + "alts.json");
      this.load();
   }

   public void save() {
      if (this.altsFile != null) {
         try {
            if (!this.altsFile.exists()) {
               this.altsFile.createNewFile();
            }

            PrintWriter var1 = new PrintWriter(this.altsFile);
            var1.write(this.gson.toJson(this.toJson()));
            var1.close();
         } catch (IOException var2) {
         }

      }
   }

   public void load() {
      if (!this.altsFile.exists()) {
         this.save();
      } else {
         try {
            JsonObject var1 = (new JsonParser()).parse(new FileReader(this.altsFile)).getAsJsonObject();
            this.fromJson(var1);
         } catch (IOException var2) {
         }

      }
   }

   public void fromJson(JsonObject var1) {
      if (var1.has("altening")) {
         this.alteningKey = var1.get("altening").getAsString();
      }

      if (var1.has("alteningAlt")) {
         this.lastAlteningAlt = var1.get("alteningAlt").getAsString();
      }

      if (var1.has("lastalt")) {
         Account var2 = new Account();
         var2.fromJson(var1.get("lastalt").getAsJsonObject());
         this.lastAlt = var2;
      }

      JsonArray var3 = var1.get("accounts").getAsJsonArray();
      var3.forEach(this::lambda$1);
   }

   public JsonObject toJson() {
      JsonObject var1 = new JsonObject();
      JsonArray var2 = new JsonArray();
      this.getAccounts().forEach(AccountManager::lambda$0);
      if (this.alteningKey != null) {
         var1.addProperty("altening", this.alteningKey);
      }

      if (this.lastAlteningAlt != null) {
         var1.addProperty("alteningAlt", this.lastAlteningAlt);
      }

      if (this.lastAlt != null) {
         var1.add("lastalt", this.lastAlt.toJson());
      }

      var1.add("accounts", var2);
      return var1;
   }

   public void setLastAlteningAlt(String var1) {
      this.lastAlteningAlt = var1;
   }

   public ArrayList<Account> getNotBannedAccounts() {
      ArrayList var1 = new ArrayList(this.accounts);

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         if (((Account)var1.get(var2)).isBanned()) {
            var1.remove(var2);
         }
      }

      return this.accounts;
   }

   private static void lambda$0(JsonArray var0, Account var1) {
      var0.add(var1.toJson());
   }

   public String getAlteningKey() {
      return this.alteningKey;
   }

   public Account getAccountByEmail(String var1) {
      Iterator var3 = this.getAccounts().iterator();

      while(var3.hasNext()) {
         Account var2 = (Account)var3.next();
         if (var2.getEmail().equalsIgnoreCase(var1)) {
            return var2;
         }
      }

      return null;
   }

   public ArrayList<Account> getAccounts() {
      return this.accounts;
   }

   public void setLastAlt(Account var1) {
      this.lastAlt = var1;
   }

   public Account getLastAlt() {
      return this.lastAlt;
   }
}
