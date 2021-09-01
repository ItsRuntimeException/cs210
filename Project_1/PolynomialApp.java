/**
 * CS210 Project 1 class PolynomialApp
 * @author Bob Wilson
 * @version July 6, 2009
 * 
 */

import java.util.Arrays;

public class PolynomialApp
{
  public static void main(String [] args)
  {
    Polynomial[] polynomials = new Polynomial[5];
    
    polynomials[0] = new Polynomial(2, 2, 2, 2);  
    polynomials[1] = new Polynomial(2, 2, 2);  
    polynomials[2] = new Polynomial(2, 2, 1);  
    polynomials[3] = new Polynomial(2, 1, 2); 
    polynomials[4] = new Polynomial(1, 2, 2);
    
    System.out.println("Before sorting:");
    for (Polynomial p : polynomials)
      System.out.println(p.toString());    

    Arrays.sort(polynomials);      // Polynomial [] is widened to Comparable<Polynomial> []
    
    System.out.println("\nAfter sorting:");
    for (Polynomial p : polynomials)
      System.out.println(p.toString());     
  }
}