package Ares.account;

import com.google.gson.JsonObject;

public class Account {
   private String password;
   private String name;
   private boolean banned;
   private String email;

   public void fromJson(JsonObject var1) {
      this.email = var1.get("email").getAsString();
      this.password = var1.get("password").getAsString();
      this.name = var1.get("name").getAsString();
      this.banned = var1.get("banned").getAsBoolean();
   }

   public boolean isBanned() {
      return this.banned;
   }

   public String getPassword() {
      return this.password;
   }

   public Account(String var1, String var2, String var3) {
      this.email = var1;
      this.password = var2;
      this.name = var3;
   }

   public String getName() {
      return this.name;
   }

   public String getEmail() {
      return this.email;
   }

   public JsonObject toJson() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("email", this.email);
      var1.addProperty("password", this.password);
      var1.addProperty("name", this.name);
      var1.addProperty("banned", this.banned);
      return var1;
   }

   public Account() {
   }

   public void setBanned(boolean var1) {
      this.banned = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }
}
