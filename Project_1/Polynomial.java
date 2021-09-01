/**
 * CS210 Project 1 class TestPolynomial
 * @author Run Dong Lin
 * @version Sept 12, 2016
 * 
 */

import java.util.*;

public class Polynomial implements Comparable<Polynomial>
{
    private ArrayList<Integer> coefficients = new ArrayList<Integer>();
    private int size;
    
    public Polynomial() //default constructor.
    {
        coefficients = null;
        size = 0;
    }
    public Polynomial(int... coefficients)
    {
        for (int i : coefficients)
        {
            this.coefficients.add(i);
        }
        size = this.coefficients.size();
    }
    
    public int compareTo(Polynomial that)
    {
        if (that.size > this.size)
        {return -1;}
        else if (that.size < this.size)
        {return 1;}
        else
        {
            for (int i = this.size-1; i >= 0; i--)
            {
                if (that.coefficients.get(i) > this.coefficients.get(i))
                {
                    return -1;
                }
                else if (that.coefficients.get(i) < this.coefficients.get(i))
                {
                    return 1;
                }
            }
            return 0;
        }
    }    
    public boolean equals(Polynomial that)
    {
        if (this.compareTo(that) == 0)
            return true;
        else
            return false;
    }
    
    public double evaluate(double n)
    {
        double e=0;
        for (int i = this.size-1; i >= 0; i--)
        {
            e+= this.coefficients.get(i) * Math.pow(n,i); // Math.pow(base, exponent);
        }
        return e;
    }
    public Polynomial plus(Polynomial that)
    {
        ArrayList<Integer> a = new ArrayList<Integer>();
        Polynomial p = new Polynomial();
        if (this.size <= that.size)
        {
            for (int i = 0; i < that.size; i++)
            {
                if (i < this.size)
                    a.add(this.coefficients.get(i) + that.coefficients.get(i));
                else
                    a.add(that.coefficients.get(i));
            }
        }
        else // this > that
        {
            for (int i = 0; i < this.size; i++)
            {
                if (i < that.size)
                    a.add(this.coefficients.get(i) + that.coefficients.get(i));
                else
                    a.add(this.coefficients.get(i));
            }
        }
        p.coefficients = a;
        p.size = a.size();
        return p;
    }
    public Polynomial minus(Polynomial that)
    {
        ArrayList<Integer> m = new ArrayList<Integer>();
        Polynomial p = new Polynomial();
        if (this.size <= that.size)
        {
            for (int i = 0; i < that.size; i++)
            {
                if (i < this.size)
                    m.add(this.coefficients.get(i) - that.coefficients.get(i));
                else
                    m.add(-that.coefficients.get(i));
            }
        }
        else // this > that
        {
            for (int i = 0; i < this.size; i++)
            {
                if (i < that.size)
                    m.add(this.coefficients.get(i) - that.coefficients.get(i));
                else
                    m.add(this.coefficients.get(i));
            }
        }
        p.coefficients = m;
        p.size = m.size();
        return p;
    }
    public Polynomial multiply(Polynomial that)
    {
        ArrayList<Integer> mm = new ArrayList<Integer>();
        Polynomial p = new Polynomial();
        if (this.size == 2 || that.size == 2)
        {
            if (that.size == 2 && this.size == 2) // bi-nomial * bi-nomial = ONE tri-nomial.
            {
                return new Polynomial(this.coefficients.get(0)*that.coefficients.get(0),
                               this.coefficients.get(1)*that.coefficients.get(0)+this.coefficients.get(0)*that.coefficients.get(1),
                               this.coefficients.get(1)*that.coefficients.get(1));
            }
            else if ((that.size == 2 && this.size == 3) || (that.size == 3 && this.size == 2))
            {
                if (this.compareTo(that) == 1) // that.coefficients.size() < this.coefficients.size()
                {
                    mm.add(this.coefficients.get(this.size-1)*that.coefficients.get(1));
                    for (int i = (int)this.size-1; i >= 0; i--)
                    {
                        if (i == 0)
                        {
                            mm.add(this.coefficients.get(0)*that.coefficients.get(0));
                        }
                        else
                        {
                            mm.add(this.coefficients.get(this.size/2)*that.coefficients.get(0) + this.coefficients.get((this.size/2)-1)*that.coefficients.get(1));
                        }
                    }
                }
            }
        }
        p.coefficients = mm;
        p.size = mm.size();
        return p;
    }
    public Polynomial[] divide(Polynomial that)
    {
        Polynomial d [] = new Polynomial[2];
        Polynomial p = new Polynomial(0); //default.
        
        if (this.size == 2 || that.size == 2)
        {
            if (that.size > this.size)
            {
                d[0] = p;
                d[1] = this; // remainder.
            }
            else
            {
                d[0] = new Polynomial(this.coefficients.get(0)/that.coefficients.get(0), 
                                      this.coefficients.get(this.size-1)/that.coefficients.get(that.size-1));
                d[1] = p;
            }
        }
        return d;
    }
    public Polynomial derivative()
    {
        ArrayList<Integer> dx = new ArrayList<Integer>();
        Polynomial p = new Polynomial();
        
        if (this.size == 1)
        {
            return new Polynomial(0);
        }
        else
        {
            for (int i = this.size-1; i > 0; i--)
            {
                dx.add(i*this.coefficients.get(i));
            }
        }
        p.coefficients = dx;
        p.size = dx.size();
        return p;
    }
    public double root(double guess, double tolerance, int iteration)
    {
        double Xn = guess; // guess(i);
        double Xn_f = guess; // guess(i+1);
        Polynomial polyGuess = this; // f(x);
        Polynomial derivGuess = this.derivative(); // f'(x);
        if (derivGuess.evaluate(Xn) != 0)
        {
            for(int i = 1; i <= iteration; i++)
            {
                Xn_f = Xn - (polyGuess.evaluate(Xn) / derivGuess.evaluate(Xn)); // Newton.
                if (Math.abs(Xn_f - Xn) < tolerance)
                {
                    break;
                }
                Xn = Xn_f; // increment of guess(i) --> guess(i+1);
            }
        }
        return Xn_f;
    }
    
    public String toString()
    {
        String s = "";
        int i = this.size-1;
        do
        {
            if (this.coefficients.get(i) < 0)
            {
                if (i != this.size-1)   
                    s += " ";
                s += this.coefficients.get(i) + "x^" + i;
            }
            else if (this.coefficients.get(i) > 0)
            {
                if (i != this.size-1)   
                    s += " +";
                s += this.coefficients.get(i) + "x^" + i;
            }
            else if (this.coefficients.get(i) == 0)
            {
                ;
            }
            i--;
        }while(i+1 > 0);
        return s;
    }
}