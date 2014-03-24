/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova01.questao04;

import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author edgardcardoso
 */
public class ClienteTest {

    public ClienteTest() {
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

    @Test
    public void testSetCep() {


        ICorreios mock = EasyMock.createMock(ICorreios.class);
        EasyMock.expect(mock.getEndereco("30354-090"))
                .andReturn("Rua Guajajaras 1987, Barro Preto, BH");
        EasyMock.replay(mock);
        
       
        Cliente cliente = new Cliente("edgard");
        cliente.setCorreios(mock);
        cliente.setCep("30354-090");
        
        assertEquals("Rua Guajajaras 1987, Barro Preto, BH", cliente.getEndereco());





    }
}
