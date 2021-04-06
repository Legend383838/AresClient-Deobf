package Ares.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import net.minecraft.client.Minecraft;

public class GuiArestest extends JPanel {
   private JButton jcomp4 = new JButton("Test1");
   private JButton jcomp5 = new JButton("Test2");

   public GuiArestest() {
      this.setPreferredSize(new Dimension(315, 85));
      this.setLayout((LayoutManager)null);
      this.setBackground(Color.BLACK);
      this.add(this.jcomp4);
      this.add(this.jcomp5);
      this.jcomp4.setBackground(new Color(11614442));
      this.jcomp4.setForeground(Color.white);
      this.jcomp5.setBackground(new Color(11614442));
      this.jcomp5.setForeground(Color.white);
      this.jcomp4.setBounds(0, 0, 315, 25);
      this.jcomp5.setBounds(0, 30, 315, 25);
      this.jcomp4.addActionListener(new ActionListener(this) {
         final GuiArestest this$0;

         public void actionPerformed(ActionEvent var1) {
         }

         {
            this.this$0 = var1;
         }
      });
      this.jcomp5.addActionListener(new ActionListener(this) {
         final GuiArestest this$0;

         public void actionPerformed(ActionEvent var1) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("off");
         }

         {
            this.this$0 = var1;
         }
      });
   }
}
