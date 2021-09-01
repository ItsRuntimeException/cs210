 

import java.util.*;
import java.io.*;
import javax.swing.*;

public class BalanceCheck
{
    public static void main(String [] args)
    {
        Scanner file = null;
        JFileChooser myChooser = new JFileChooser();
        int status = myChooser.showOpenDialog(null);
        try
        {
            file = new Scanner(myChooser.getSelectedFile());
        }
        catch (Exception e)
        {
            System.out.println("Can not open File");
            System.exit(0);
        }
        
        Stack<Character> check = new Stack<Character>();
        char c1 = ' ';   // current character from the line
        char c2 = ' ';   // last {, (, or [ character (from stack)
            
        boolean error = false;
        while (!error && file.hasNext())
        {
            String line = file.nextLine();
            
            for (int i = 0; !error && i < line.length(); i++)
            {
                c1 = line.charAt(i);
                if (c1 == '{' || c1 == '(' || c1 == '[')
                {check.push(c1);}
                
                if (c1 == '}' || c1 == ')' || c1 == ']')
                {
                    System.out.println(check);
                    c2 = check.pop();
                    if (c1=='}' && c2=='{' || c1==')' && c2=='(' || c1==']' && c2=='[')
                    {;}
                    else
                    {
                        error = true;
                        break;
                    }
                }
            }
        }
        
        // print...
        if (!error)
        {
            System.out.println((!check.empty()) ? "Missing closing delimiters." : "Balance OK!");
            System.out.println(check);
        }
        else
            System.out.println("Mismatch character c1 = " + c1 + ", c2 = " + c2 + ".");
    }
}