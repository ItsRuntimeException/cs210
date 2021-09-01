import javax.swing.*;
import java.awt.*;

/**
 * @author Bob Wilson
 * @version 1.0, 12/20/2009
 * 
 * Triangle class for fractal pattern generation
 */

public class Triangle
{
  // indices for sub-triangles
  public static final int CORNER_ONE = 0;
  public static final int CORNER_TWO = 1;
  public static final int CORNER_THREE = 2;
  public static final int EDGE_ONE = 3;
  public static final int EDGE_TWO = 4;
  public static final int EDGE_THREE = 5;
  
  // smallest perimeter for triangle to be drawn
  public static final int SMALLEST = 10;
  
  private Corner x;
  private Corner y;
  private Corner z;
    
  public Triangle(Corner x, Corner y, Corner z)
  {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public void draw(Graphics screen)
  {
   screen.drawLine(x.w, x.d, y.w, y.d);
   screen.drawLine(y.w, y.d, z.w, z.d);
   screen.drawLine(z.w, z.d, x.w, x.d);
  }
  
  public int size()
  {
    return (this.x.len(y)) + (this.y.len(z)) + (this.z.len(x));
  }
  
  public Triangle getNextLevel(int index)
  {
    Triangle t = null;
    Corner a,b,c;
    a = b = c = null;
    
    switch(index)
    {
        case CORNER_ONE:
        a = x.mid(x.mid(z));
        b = x.mid(x.mid(y));
        c = x.mid(z).mid(x.mid(y));
        break;
        
        case CORNER_TWO:
        a = y.mid(z).mid(y.mid(x));
        b = y.mid(y.mid(x));
        c = y.mid(y.mid(z));
        break;
        
        case CORNER_THREE:
        a = z.mid(z.mid(x));
        c = z.mid(z.mid(y));
        b = z.mid(x).mid(z.mid(y));
        break;
        
        case EDGE_ONE:
        a = x.mid(z);
        b = a.mid(x.mid(y));
        c = a.mid(z.mid(y));
        break;
        
        case EDGE_TWO:
        b = x.mid(y);
        a = b.mid(x.mid(z));
        c = b.mid(z.mid(y));
        break;
        
        case EDGE_THREE:
        c = z.mid(y);
        a = c.mid(z.mid(x));
        b = c.mid(x.mid(y));
        break;
    }
    t = new Triangle(a,b,c);
    return t;
  }
}