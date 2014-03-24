/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova01.questao03;

import javax.swing.Icon;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author edgardcardoso
 */
public class MoedaTest {
    
    public MoedaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toEuros method, of class Moeda.
     */
    @Test
    public void testToEuros() throws Exception {
        
        ICotacao mocks = EasyMock.createMock(ICotacao.class);
        EasyMock.expect(mocks.getCotacao("BRL", "EUR")).andReturn(0.33);
        EasyMock.replay(mocks);
        
        Moeda experado = new Moeda(0.33, "EUR");
        Moeda moeda = new Moeda(1.00, "BRL");
        
        assertEquals(experado, moeda.toEuros(mocks));
        
    }

    /**
     * Test of toDollar method, of class Moeda.
     */
    @Test
    public void testToDollar() throws Exception {
        ICotacao mocks = EasyMock.createMock(ICotacao.class);
        EasyMock.expect(mocks.getCotacao("BRL", "USD")).andReturn(0.49);
        EasyMock.replay(mocks);
        
        Moeda experado = new Moeda(0.49, "USD");
        Moeda real = new Moeda(1.00, "BRL");
        
        assertEquals(experado, real.toDollar(mocks));
    }

    
}
