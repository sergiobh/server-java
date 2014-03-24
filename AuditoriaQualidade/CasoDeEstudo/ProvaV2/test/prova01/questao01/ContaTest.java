/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova01.questao01;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author edgardcardoso
 */
public class ContaTest {

    public ContaTest() {
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
    public void testSaque() {
        try {
            Conta conta1 = new Conta(100);
            Conta conta2 = new Conta(100);
            Conta conta3 = new Conta(100);

            conta1.saque(30);
            assertEquals(70, conta1.getSaldo(), 0.0d);

            conta2.saque(250);
            assertEquals(-150, conta2.getSaldo(), 0.0d);

            conta3.saque(-50);
            fail("Não deveria ter passado aqui");
        } catch (ContaException ex) {
            // beleza, era esperado
        }

    }

    /**
     * Test of deposito method, of class Conta.
     */
    @Test
    public void testDeposito() {
        try {

            Conta conta1 = new Conta(100);
            Conta conta2 = new Conta(100);
            Conta conta3 = new Conta(100);

            conta1.deposito(30);
            assertEquals(130, conta1.getSaldo(), 0.0d);

            conta2.deposito(250);
            assertEquals(350, conta2.getSaldo(), 0.0d);

            conta3.deposito(-50);
            fail("Não deveria ter passado aqui");

        } catch (ContaException ex) {
            // beleza, era esperado.
        }
    }
}
