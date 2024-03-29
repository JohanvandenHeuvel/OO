/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class PolynomialTest {
    
    public PolynomialTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Polynomial.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Polynomial instance = new Polynomial("1 0 2 1 3 2 4 3");
        String expResult = "1,000000 + 2,000000x + 3,000000x^2 + 4,000000x^3";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of plus method, of class Polynomial.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Polynomial b = new Polynomial("1 0 2 1 3 2 4 3");
        Polynomial instance = new Polynomial("1 0 2 1 3 2 4 3");
        instance.plus(b);
        
        Polynomial expResult = new Polynomial("2 0 4 1 6 2 8 3");
        assertEquals(expResult, instance);
    }

    /**
     * Test of minus method, of class Polynomial.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        Polynomial b = new Polynomial("1 0 2 1 3 2 4 3");
        Polynomial instance = new Polynomial("2 0 4 1 6 2 8 3");
        instance.minus(b);
        
        Polynomial expResult = new Polynomial("1 0 2 1 3 2 4 3");
        assertEquals(expResult, instance);
        
        Polynomial c = new Polynomial("1 0 2 1 3 2 4 3");
        Polynomial negative = new Polynomial("-1 0");
        Polynomial d = new Polynomial("2 0 4 1 6 2 8 3");
        c.times(negative);
        d.plus(c);

        assertEquals(expResult, d);
    }

    /**
     * Test of times method, of class Polynomial.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Polynomial b = new Polynomial("1 0 2 1 3 2 4 3");
        Polynomial instance = new Polynomial("2 0 4 1 6 2 8 3");
        instance.times(b);
        
        Polynomial expResult = new Polynomial("2 0 8 1 20 2 40 3 50 4 48 5 32 6");
        assertEquals(expResult, instance);
        
        
        Polynomial c = new Polynomial("1 1");
        c.times(c);
        assertEquals(new Polynomial("1 2"), c);
    }

    /**
     * Test of divide method, of class Polynomial.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Polynomial b = new Polynomial("2 0 4 1 6 2 8 3");
        Polynomial instance = new Polynomial("2 0 8 1 20 2 40 3 50 4 48 5 32 6");
        
        Polynomial result = instance.divide(b); //WTF IS RESULT?
        
        Polynomial expResult = new Polynomial("1 0 2 1 3 2 4 3");
        assertEquals(expResult, instance);
    }

    /**
     * Test of equals method, of class Polynomial.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other_poly = new Polynomial("2 0 8 1 20 2 40 3 50 4 48 5 32 6");
        Polynomial instance = new Polynomial("2 0 8 1 20 2 40 3 50 4 48 5 32 6");
        boolean expResult = true;
        boolean result = instance.equals(other_poly);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCommutativityPlus(){
        System.out.println("commutativity plus");
        
        //a+b = b+a

        Polynomial a1 = new Polynomial("2 0 4 1 6 2 8 3");
        Polynomial a2 = new Polynomial("2 0 4 1 6 2 8 3");
        Polynomial b = new Polynomial("2 0 8 1 20 2 40 3");
       
        a1.plus(b);
        a2.plus(b);
        
        assertEquals(a1,a2);
    }
    
    @Test
    public void testCommutativityTimes(){
        System.out.println("commutativity times");
        
        //a*b = b*a

        Polynomial a1 = new Polynomial("2 0 4 1 6 2 8 3");
        Polynomial a2 = new Polynomial("2 0 4 1 6 2 8 3");
        Polynomial b = new Polynomial("2 0 8 1 20 2 40 3");
       
        a1.times(b);
        a2.times(b);
        
        assertEquals(a1,a2);
    }
    
    @Test
    public void testAssociativityPlus(){
        System.out.println("associativity plus");
        
        //(a + b) + c = a + (b + c)

        Polynomial a1 = new Polynomial("2 0 4 1 6 2 8 3");
        Polynomial a2 = new Polynomial("2 0 4 1 6 2 8 3");
        Polynomial b = new Polynomial("2 0 8 1 20 2 40 3");
        Polynomial c = new Polynomial("3 0 9 1 30 2 12 3");
       
        a1.plus(b);
        a1.plus(c);
        
        a2.plus(c);
        a2.plus(b);
        
        assertEquals(a1,a2);
    }
    
    @Test
    public void testAssociativityTimes(){
        System.out.println("associativity times");
        
        //(a + b) + c = a + (b + c)

        Polynomial a1 = new Polynomial("2 0 4 1 6 2 8 3");
        Polynomial a2 = new Polynomial("2 0 4 1 6 2 8 3");
        Polynomial b = new Polynomial("2 0 8 1 20 2 40 3");
        Polynomial c = new Polynomial("3 0 9 1 30 2 12 3");
       
        a1.times(b);
        a1.times(c);
        
        a2.times(c);
        a2.times(b);
        
        assertEquals(a1,a2);
    }
    
    @Test
    public void testDistributivityPlus(){
        System.out.println("distributivity plus");
        
        //a * (b + c) = a * b + a * c

        Polynomial a1 = new Polynomial("2 0 4 1 6 2 8 3");
        Polynomial a2 = new Polynomial("2 0 4 1 6 2 8 3");
        Polynomial a3 = new Polynomial("2 0 4 1 6 2 8 3");

        Polynomial b = new Polynomial("2 0 8 1 20 2 40 3");
        Polynomial c = new Polynomial("3 0 9 1 30 2 12 3");
        
        //copy b
        Polynomial bplusc = new Polynomial("2 0 8 1 20 2 40 3");
        bplusc.plus(c);
        
        a1.times(bplusc);
        
        a2.times(b);
        a3.times(c);
        a2.plus(a3);
        
        assertEquals(a1,a2);
    }
    
}
