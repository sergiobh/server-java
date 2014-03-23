/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31218428
 */
public class CalculadoraTeste {
    
    private Calculadora calculadora;
    
    public CalculadoraTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        calculadora = new Calculadora();
    }
    
    @After
    public void tearDown() {
        
        calculadora = null;
    }
 
    @Test
    public void testSoma(){
        assertEquals("Deveria retornar 4", 4, calculadora.soma(2,2));
        assertEquals("Deveria retornar 0", 0, calculadora.soma(-2,2));
        assertEquals("Deveria retornar -1", -1, calculadora.soma(-3,2));
        assertEquals("Deveria retornar -1", -1, calculadora.soma(0,-1));
    }
    
    @Test
    public void testPercentual(){
        assertEquals("Deveria retornar 3.6", 3.6, calculadora.percentual(60,6), 0.01d);
        assertEquals("Deveria retornar 10", 10, calculadora.percentual(100,10), 0.01d);
        assertEquals("Deveria retornar 70", 70, calculadora.percentual(100,70), 0.01d);
        assertEquals("Deveria retornar 19.47", 19.47, calculadora.percentual(33,59), 0.01d);
    }
    
    @Test
    public void testFatorial(){
        assertEquals("Deveria retorna 120", 120, calculadora.fatorial(5));
        assertEquals("Deveria retorna 24", 24, calculadora.fatorial(4));
        assertEquals("Deveria retorna 6", 6, calculadora.fatorial(3));
        assertEquals("Deveria retorna 40320", 40320, calculadora.fatorial(8));
    }
    
    @Test
    public void testExponencial(){
        assertEquals("Deveria retornar 8", 8, calculadora.exponencial(2,3));
        assertEquals("Deveria retornar 1024", 1024, calculadora.exponencial(2,10));
        assertEquals("Deveria retornar 27", 27, calculadora.exponencial(3,3));
        assertEquals("Deveria retornar 1", 1, calculadora.exponencial(2,0));
    }
    
    @Test
    public void testLogaritimo(){
        assertEquals("Deveria retornar 3", 3, calculadora.logaritmo(27,3));
        assertEquals("Deveria retornar 10", 10, calculadora.logaritmo(1024,2));
        assertEquals("Deveria retornar 5", 5, calculadora.logaritmo(32,2));
        assertEquals("Deveria retornar 3", 3, calculadora.logaritmo(19683,27));
        
    }
}
