/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulo;

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
public class TrianguloTest {

    Triangulo triangulo;

    public TrianguloTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        triangulo = new Triangulo();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of eTriangulo method, of class Triangulo.
     */
    @Test
    public void testETriangulo() {
        assertTrue(triangulo.eTriangulo(2, 2, 2));
        assertTrue(triangulo.eTriangulo(2, 3, 2));
        assertTrue(triangulo.eTriangulo(4, 3, 5));
        assertFalse(triangulo.eTriangulo(4, 3, -5));
    }

    /**
     * Test of possuiValoresNulosNeg method, of class Triangulo.
     */
    @Test
    public void testPossuiValoresNulosNeg() {
        assertFalse(triangulo.possuiValoresNulosNeg(2, 2, 2));
        assertFalse(triangulo.possuiValoresNulosNeg(2, 3, 2));
        assertFalse(triangulo.possuiValoresNulosNeg(4, 3, 5));
        assertTrue(triangulo.possuiValoresNulosNeg(2, 2, -2));
        assertTrue(triangulo.possuiValoresNulosNeg(2, -3, 2));
        assertTrue(triangulo.possuiValoresNulosNeg(-4, 3, 5));
    }

    /**
     * Test of atribuirLados method, of class Triangulo.
     */
    @Test
    public void testAtribuirLados() {
    }

    /**
     * Test of obterTextoTriangulo method, of class Triangulo.
     */
    @Test
    public void testObterTextoTriangulo() {
        triangulo.atribuirLados(2, 2, 2);
        assertEquals("O triângulo é equilátero.", triangulo.obterTextoTriangulo());

        triangulo.atribuirLados(2, 3, 2);
        assertEquals("O triângulo é isósceles.", triangulo.obterTextoTriangulo());

        triangulo.atribuirLados(4, 3, 5);
        assertEquals("O triângulo é escaleno.", triangulo.obterTextoTriangulo());

        triangulo.atribuirLados(4, 3, -5);
        assertEquals("Os valores não formam um triângulo.", triangulo.obterTextoTriangulo());

        triangulo.atribuirLados(4, 3, 50);
        assertEquals("Os valores não formam um triângulo.", triangulo.obterTextoTriangulo());
    }

    /**
     * Test of obterTriangulo method, of class Triangulo.
     */
    @Test
    public void testObterTriangulo() {
        triangulo.atribuirLados(2, 2, 2);
        assertEquals(Triangulo.EQUILATERO, triangulo.obterTriangulo());

        triangulo.atribuirLados(2, 3, 2);
        assertEquals(Triangulo.ISOSCELES, triangulo.obterTriangulo());

        triangulo.atribuirLados(4, 3, 5);
        assertEquals(Triangulo.ESCALENO, triangulo.obterTriangulo());

        triangulo.atribuirLados(4, 3, -5);
        assertEquals(Triangulo.INEXISTENTE, triangulo.obterTriangulo());

        triangulo.atribuirLados(4, 3, 50);
        assertEquals(Triangulo.INEXISTENTE, triangulo.obterTriangulo());
    }
}
