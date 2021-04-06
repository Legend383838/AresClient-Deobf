package Ares.event.gui.hud;

public interface IRenderer extends IRenderConfig {
   int getWidth();

   int getHeight();

   void render(ScreenPosition var1);

   default void renderDummy(ScreenPosition var1) {
      this.render(var1);
   }

   default boolean isEnabled() {
      return true;
   }
}
