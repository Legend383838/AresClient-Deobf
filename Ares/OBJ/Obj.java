package Ares.OBJ;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Obj {
   private final List<Vector3f> normals;
   private final List<Vector3f> vertices;
   private final List<Obj.Face> faces;
   private final List<Vector2f> textureCoords;

   public List<Obj.Face> getFaces() {
      return this.faces;
   }

   public Obj() {
      this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
   }

   public Obj(List<Vector3f> var1, List<Vector2f> var2, List<Vector3f> var3, List<Obj.Face> var4) {
      this.vertices = var1;
      this.textureCoords = var2;
      this.normals = var3;
      this.faces = var4;
   }

   public List<Vector3f> getVertices() {
      return this.vertices;
   }

   public List<Vector2f> getTextureCoordinates() {
      return this.textureCoords;
   }

   public List<Vector3f> getNormals() {
      return this.normals;
   }

   public static class Face {
      private final int[] textureCoordinateIndices;
      private final int[] normalIndices;
      private final int[] vertexIndices;

      public int[] getTextureCoords() {
         return this.textureCoordinateIndices;
      }

      public int[] getNormals() {
         return this.normalIndices;
      }

      public Face(int[] var1, int[] var2, int[] var3) {
         this.vertexIndices = var1;
         this.normalIndices = var3;
         this.textureCoordinateIndices = var2;
      }

      public int[] getVertices() {
         return this.vertexIndices;
      }
   }
}
