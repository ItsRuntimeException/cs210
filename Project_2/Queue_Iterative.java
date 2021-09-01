import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * @author Bob Wilson
 * @version 1.0, 12/20/2009
 * 
 * Applet with fractal pattern repetition using 
 * iterative drawing of triangles within triangles
 */

public class Queue_Iterative extends JApplet
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
  * iterative version of drawing
  * Note: It can work with either stack or queue for saving triangles
  * in five places in the code below: comment/uncomment one or the other ***
  * The only difference is in the order that sub-triangles are drawn.
  */
 
 private void drawTriangle(Graphics screen, Triangle t)
 {
   // add your code here
   Queue<Triangle> qu = new LinkedList<Triangle>();
   qu.add(t);
   Triangle s;
   while(qu.peek() != null) // not empty...
   {
       s = qu.remove();
       if (s.size() >= Triangle.SMALLEST)
       {
           s.draw(screen);
           for (int i=5; i>=0; i--)
               qu.add(s.getNextLevel(i));
           
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
} 
