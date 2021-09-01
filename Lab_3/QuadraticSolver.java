/*
 * @(#)Solver.java 1.0
 *
 *
 * Quadratic equation solver class
 * Bob Wilson
 * 12/29/2015
 *
 */

public class QuadraticSolver 
{ 
  private int a, b, c;            // coefficients of quadratic equation
  
  public QuadraticSolver(int a, int b, int c)
  {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public String getEquation()
  {
    return ("Solving: " + a + "x\u00b2 " + ( (b >= 0) ? "+ " : "") +
            b + "x " + ( (c >= 0) ? "+ " : "") + c + " = 0");
  }

  public String getSolution() // "this" will refer to the object that called this method.
  {
    String result = null;
    double discriminant = (this.b * this.b - 4 * this.a * this.c);
    double x1 = (-this.b + Math.sqrt(discriminant))/(2 * this.a);
    double x2 = (-this.b - Math.sqrt(discriminant))/(2 * this.a);
    
    if (this.a == 0) // no quadratic.
    {
        if (discriminant > 0) // do linear algebra.
        {
            result = "The only root is " + (double)(this.c)/(-this.b);
        }
        else if (this.b == this.a && this.c == this.a) // special case.
        {
            result = "Any value for x is a solution";
        }
        else if (this.b ==this.a && this.c !=this.a) // special case.
        {
            result = "No value for x is a solution";
        }
    }
    else if (this.a > 0) // quadratic.
    {
        if (discriminant > 0) // everything is normal, solve regular.
        {
            result = "Root 1 is " + x1 + "\nRoot 2 is ";
            result += x2;
        }
        else if (discriminant < 0) // everything is normal except discriminant, do imaginary.
        {
            result = "Root 1 is " + ((-this.b)/(double)(2 * this.a)) + " + i * " + Math.sqrt(Math.abs(discriminant))/(double)(2 * this.a) + "\nRoot 2 is ";
            result += ((-this.b)/(double)(2 * this.a)) + " - i * " + Math.sqrt(Math.abs(discriminant))/(double)(2 * this.a);
        }
        else if (discriminant == 0) // + or - operation on zero of discriminant, resulting in a single answer.
        {
            if (this.b !=0 && this.a !=0)
            {
                result = "The only root is " + (-this.b + discriminant)/(2 * this.a);
            }
        }
    }
    
    return result;
  }
}