/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova01.questao02;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;
import prova01.questao01.Conta;
import prova01.questao01.ContaException;
import prova01.questao01.Emprestimo;
import prova01.questao01.EmprestimoException;

/**
 *
 * @author edgardcardoso
 */
public class BancoTest {

    public BancoTest() {
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
    public void testContasComSaldoNegativo() {
        try {
            Conta conta1 = new Conta(100);
            Conta conta2 = new Conta(200);
            Conta conta3 = new Conta(300);

            Banco banco = new Banco();
            banco.adicionaConta(conta1);
            banco.adicionaConta(conta2);
            banco.adicionaConta(conta3);

            conta1.saque(40);
            conta2.saque(300);
            conta3.saque(1000);

            Conta[] experado = {conta2, conta3};

            assertArrayEquals(experado, banco.contasComSaldoNegativo());



        } catch (BancoException ex) {
            fail("Não deveria ter levantado exceção");
        } catch (ContaException ex) {
            fail("Não deveria ter levantado exceção");
        }


    }

    /**
     * Test of getConta method, of class Banco.
     */
    @Test
    public void testGetConta() {
        try {
            Conta conta1 = new Conta(1234, 300);
            Conta conta2 = new Conta(5431, 250);
            Conta conta3 = new Conta(9988, 10);

            Banco banco = new Banco();
            banco.adicionaConta(conta1);
            banco.adicionaConta(conta2);
            banco.adicionaConta(conta3);

            assertEquals(conta3, banco.getConta(9988));
            assertEquals(null, banco.getConta(1122));
            assertEquals(null, banco.getConta(2024));
            assertEquals(conta2, banco.getConta(5431));

        } catch (BancoException ex) {
            fail("Não deveria ter levantado exceção");
        } catch (ContaException ex) {
            fail("Não deveria ter levantado exceção");
        }


    }

    /**
     * Test of retornaValoresDaDividaDoEmprestimoPelaConta method, of class
     * Banco.
     */
    @Test
    public void testRetornaValoresDaDividaDoEmprestimoPelaConta() {
        try {
            Conta conta = new Conta(1234, 100);
            Emprestimo emprestimo1 = new Emprestimo(3000, 5.75);
            Emprestimo emprestimo2 = new Emprestimo(1000, 3.00);
            Emprestimo emprestimo3 = new Emprestimo(7500, 2.75);
            Emprestimo emprestimo4 = new Emprestimo(500, 3.00);

            conta.criaEmprestimo(emprestimo1);
            conta.criaEmprestimo(emprestimo2);
            conta.criaEmprestimo(emprestimo3);

            Banco banco = new Banco();
            banco.adicionaConta(conta);



            double[] experado = {3172.50, 1030.00, 7706.25};
            double[] retornado = banco.retornaValoresDaDividaDoEmprestimoPelaConta(1234);
            assertArrayEquals(experado, retornado, 0.0d);




            conta.criaEmprestimo(emprestimo4);
            fail("Não deveria ter passado aqui");
        } catch (ContaException ex) {
            fail("Não deveria ter levantado exceção");
        } catch (BancoException ex) {
            fail("Não deveria ter levantado exceção");
        } catch (EmprestimoException ex) {
            // beleza, era esperado!
        }
    }
}
