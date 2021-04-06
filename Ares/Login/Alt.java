package Ares.Login;

public final class Alt {
   private final String username;
   private String password;
   private String mask;

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String var1) {
      this.password = var1;
   }

   public void setMask(String var1) {
      this.mask = var1;
   }

   public String getUsername() {
      return this.username;
   }

   public Alt(String var1, String var2, String var3) {
      this.mask = "";
      this.username = var1;
      this.password = var2;
      this.mask = var3;
   }

   public String getMask() {
      return this.mask;
   }

   public Alt(String var1, String var2) {
      this(var1, var2, "");
   }
}
