package FUN;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainForGraphics2
{
 public static void main(String[] args)
 {
  JFrame frame = new JFrame();
  frame.setSize(1920,1080);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Board panel = new Board();
  frame.add(panel);
  frame.setVisible(true);
 }
}


