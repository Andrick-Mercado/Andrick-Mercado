 

import javax.swing.JComponent;
import java.lang.Object;
import java.awt.*;
import java.awt.geom.*;
// HistogramComponent extends the functionality of a JComponent
// in order to draw a histogram.
public class HistogramComponent extends JComponent {
    // Paints a histogram with three bins
    @Override
    public void paintComponent(Graphics g) {  
        // Cast to Graphics2D
        Graphics2D graphicsObj = (Graphics2D) g;

        // Draw 1st bin as an olive colored rectangle at (10,10)
        // with width = 200 and height = 50
        //Rectangle(int x, int y, int width, int height)
        // Color(int red, int green, int blue)
        /**
        Rectangle binRectangle1 = new Rectangle(-10, -10, 100, 100); 
        Color binColor1 = new Color(0,0,0);
        graphicsObj.setColor(binColor1);
        graphicsObj.fill(binRectangle1);**/

        // Draw 2nd round rectangle
        Shape roundRectangle = new RoundRectangle2D.Double(100.0 ,100.0,200.0,50.0,50.0,50.0);
        Color binColor2 = new Color(0,0,0);
        graphicsObj.setColor(binColor2);
        graphicsObj.fill(roundRectangle);
        
        //draw 3rd ellipse
        Shape ellipse = new Ellipse2D.Double(150,250,500,200);
        Color binColor3 = new Color(0,0,0);
        graphicsObj.setColor(binColor3);
        graphicsObj.fill(ellipse);
    }
}