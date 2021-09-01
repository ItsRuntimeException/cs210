/**
 * CS210 Lab 3 class TestSolver
 * @author Run Dong Lin
 * @version September 27, 2016
 */

public class TestSolver extends junit.framework.TestCase
{
    private QuadraticSolver cut;
    
    public TestSolver()
    {
        // nothing.
    }
    
    public void test2RealRoots()
    {
        cut = new QuadraticSolver(1,0,-3);
        assertEquals("Solving: 1x\u00b2 + 0x -3 = 0", cut.getEquation());
        assertEquals("Root 1 is 1.7320508075688772\nRoot 2 is -1.7320508075688772", cut.getSolution());
    }
    
    public void test2ImaginaryRoots()
    {
        cut = new QuadraticSolver(1,1,1);
        assertEquals("Solving: 1x\u00b2 + 1x + 1 = 0", cut.getEquation());
        assertEquals("Root 1 is -0.5 + i * 0.8660254037844386\nRoot 2 is -0.5 - i * 0.8660254037844386", cut.getSolution());
    }
    
    public void testOnly1Root()
    {
        cut = new QuadraticSolver(1,2,1);
        assertEquals("Solving: 1x\u00b2 + 2x + 1 = 0", cut.getEquation());
        assertEquals("The only root is -1.0", cut.getSolution());
    }
    
    public void testLinear()
    {
        cut = new QuadraticSolver(0,2,4);
        assertEquals("Solving: 0x\u00b2 + 2x + 4 = 0", cut.getEquation());
        assertEquals("The only root is -2.0", cut.getSolution());
    }
    
    public void testNoSolution()
    {
        cut = new QuadraticSolver(0,0,6);
        assertEquals("Solving: 0x\u00b2 + 0x + 6 = 0", cut.getEquation());
        assertEquals("No value for x is a solution", cut.getSolution());
    }
    
    public void testAnySolution()
    {
        cut = new QuadraticSolver(0,0,0);
        assertEquals("Solving: 0x\u00b2 + 0x + 0 = 0", cut.getEquation());
        assertEquals("Any value for x is a solution", cut.getSolution());
    }
}