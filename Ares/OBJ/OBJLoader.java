package Ares.OBJ;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class OBJLoader {
   public Map<String, Obj> loaded = new HashMap();

   public OBJLoader() {
      try {
         ResourceLocation var1 = new ResourceLocation("Ares/crown.obj");
         this.loadModel(new Scanner(Minecraft.getMinecraft().getResourceManager().getResource(var1).getInputStream()), "fox");
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   public void loadModel(Scanner var1, String var2) {
      Obj var3 = new Obj();

      while(var1.hasNextLine()) {
         String var4 = var1.nextLine();
         if (var4 != null && !var4.equals("") && !var4.startsWith("#")) {
            String[] var5 = var4.split(" ");
            String var6;
            switch((var6 = var5[0]).hashCode()) {
            case 102:
               if (var6.equals("f")) {
                  var3.getFaces().add(new Obj.Face(new int[]{Integer.parseInt(var5[1].split("/")[0]), Integer.parseInt(var5[2].split("/")[0]), Integer.parseInt(var5[3].split("/")[0])}, new int[]{Integer.parseInt(var5[1].split("/")[1]), Integer.parseInt(var5[2].split("/")[1]), Integer.parseInt(var5[3].split("/")[1])}, new int[]{Integer.parseInt(var5[1].split("/")[2]), Integer.parseInt(var5[2].split("/")[2]), Integer.parseInt(var5[3].split("/")[2])}));
               }
               break;
            case 118:
               if (var6.equals("v")) {
                  var3.getVertices().add(new Vector3f(Float.parseFloat(var5[1]), Float.parseFloat(var5[2]), Float.parseFloat(var5[3])));
               }
               break;
            case 3768:
               if (var6.equals("vn")) {
                  var3.getNormals().add(new Vector3f(Float.parseFloat(var5[1]), Float.parseFloat(var5[2]), Float.parseFloat(var5[3])));
               }
               break;
            case 3774:
               if (var6.equals("vt")) {
                  var3.getTextureCoordinates().add(new Vector2f(Float.parseFloat(var5[1]), Float.parseFloat(var5[2])));
               }
            }
         }
      }

      var1.close();
      this.loaded.put(var2, var3);
   }

   public void render(Obj var1) {
      GL11.glMaterialf(1028, 5633, 120.0F);
      GL11.glBegin(4);
      Iterator var3 = var1.getFaces().iterator();

      while(var3.hasNext()) {
         Obj.Face var2 = (Obj.Face)var3.next();
         Vector3f[] var4 = new Vector3f[]{(Vector3f)var1.getNormals().get(var2.getNormals()[0] - 1), (Vector3f)var1.getNormals().get(var2.getNormals()[1] - 1), (Vector3f)var1.getNormals().get(var2.getNormals()[2] - 1)};
         Vector2f[] var5 = new Vector2f[]{(Vector2f)var1.getTextureCoordinates().get(var2.getTextureCoords()[0] - 1), (Vector2f)var1.getTextureCoordinates().get(var2.getTextureCoords()[1] - 1), (Vector2f)var1.getTextureCoordinates().get(var2.getTextureCoords()[2] - 1)};
         Vector3f[] var6 = new Vector3f[]{(Vector3f)var1.getVertices().get(var2.getVertices()[0] - 1), (Vector3f)var1.getVertices().get(var2.getVertices()[1] - 1), (Vector3f)var1.getVertices().get(var2.getVertices()[2] - 1)};
         GL11.glNormal3f(var4[0].getX(), var4[0].getY(), var4[0].getZ());
         GL11.glTexCoord2f(var5[0].getX(), var5[0].getY());
         GL11.glVertex3f(var6[0].getX(), var6[0].getY(), var6[0].getZ());
         GL11.glNormal3f(var4[1].getX(), var4[1].getY(), var4[1].getZ());
         GL11.glTexCoord2f(var5[1].getX(), var5[1].getY());
         GL11.glVertex3f(var6[1].getX(), var6[1].getY(), var6[1].getZ());
         GL11.glNormal3f(var4[2].getX(), var4[2].getY(), var4[2].getZ());
         GL11.glTexCoord2f(var5[2].getX(), var5[2].getY());
         GL11.glVertex3f(var6[2].getX(), var6[2].getY(), var6[2].getZ());
      }

      GL11.glEnd();
   }
}
