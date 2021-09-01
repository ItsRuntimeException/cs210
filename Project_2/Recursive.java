import javax.swing.*;
import java.awt.*;

/**
 * @author Bob Wilson
 * @version 1.0, 12/20/2009
 * 
 * Applet with fractal pattern repetition using
 * recursive drawing of triangles within triangles
 */

public class Recursive extends JApplet
{

 public void paint(Graphics screen)
 {
   screen.clearRect(0, 0, this.getWidth(), this.getHeight());
   screen.drawString("Bob Wilson", 0 , 10);
   Corner x = new Corner(0, this.getHeight());
   Corner y = new Corner(this.getWidth(), this.getHeight());
   Corner z = new Corner(this.getWidth() / 2, 0);
   
   drawTriangle(screen, new Triangle(x, y, z));  
 }
 
 /**
  * recursive version of drawing
  */

 private void drawTriangle(Graphics screen, Triangle t)
 {
   if (t.size() >= Triangle.SMALLEST)
   {
       t.draw(screen);
       drawTriangle(screen, t.getNextLevel(0));
       drawTriangle(screen, t.getNextLevel(1));
       drawTriangle(screen, t.getNextLevel(2));
       drawTriangle(screen, t.getNextLevel(3));
       drawTriangle(screen, t.getNextLevel(4));
       drawTriangle(screen, t.getNextLevel(5));
       
       try
           {
               Thread.sleep(15);
           }
           catch(InterruptedException e)
           {
               ; // do noting.
           }
   }
 }
} 
