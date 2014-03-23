/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import excecao.BancoException;
import excecao.ContaException;
import excecao.EmprestimoException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sérgio
 */
public class BancoTest {

    private Banco banco;

    public BancoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        banco = new Banco("Sergio", 123);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetConta() {
        //System.out.println("testGetConta");

        try {
            Conta conta1 = new Conta(2234, "conta1", "", 30);
            Conta conta2 = new Conta(1122, "conta2", "", 250);
            Conta conta3 = new Conta(1233, "conta3", "", 50);
            Conta conta4 = new Conta(1455, "conta4", "", 100);
            Conta conta5 = new Conta(1566, "conta5", "", 60);

            banco.adicionaConta(conta1);
            banco.adicionaConta(conta2);
            banco.adicionaConta(conta3);
            banco.adicionaConta(conta4);
            banco.adicionaConta(conta5);

            //System.out.println("getConta");
            assertEquals(conta4, banco.getConta(1455));
            assertEquals(conta2, banco.getConta(1122));
            assertEquals(null, banco.getConta(2024));
            assertEquals(conta3, banco.getConta(1233));
            assertEquals(null, banco.getConta(8876));
        } catch (BancoException bancoException) {
            fail("Exceção: " + bancoException.getMessage());
        } catch (ContaException contaException) {
            fail("Exceção: " + contaException.getMessage());
        } catch (Exception e) {
            fail("Exceção: " + e.getMessage());
        }
    }

    @Test
    public void testAdicionaConta() throws Exception {
        //System.out.println("testAdicionaConta");

        try {
            Conta conta1 = new Conta(2234, "conta1", "", 30);
            Conta conta2 = new Conta(4321, "conta2", "", 250);
            Conta conta3 = new Conta(2244, "conta3", "", 50);
            Conta conta4 = new Conta(7656, "conta4", "", 100);
            Conta conta5 = new Conta(3325, "conta5", "", 60);
            Conta conta6 = new Conta(8897, "conta6", "", 70);

            banco.adicionaConta(conta1);
            banco.adicionaConta(conta2);
            banco.adicionaConta(conta3);
            banco.adicionaConta(conta4);
            banco.adicionaConta(conta5);

            //System.out.println("adicionaConta");
            assertEquals(5, banco.getQuantidadeDeContas());

            try {
                banco.adicionaConta(conta6);
            } catch (BancoException bancoException) {
                // Caso tenta adicionar mais de 5 contas deverá entrar nessa exceção!
                assertEquals(5, banco.getQuantidadeDeContas());
            } catch (Exception e) {
                System.out.println("Exceção: " + e.getMessage());
            }
        } catch (BancoException bancoException) {
            fail("Exceção: " + bancoException.getMessage());
        } catch (ContaException contaException) {
            fail("Exceção: " + contaException.getMessage());
        } catch (Exception e) {
            fail("Exceção: " + e.getMessage());
        }
    }

    @Test
    public void testContaComMaiorSaldo() {
        //System.out.println("testContaComMaiorSaldo");

        try {
            Conta conta1 = new Conta(100);
            Conta conta2 = new Conta(500);
            Conta conta3 = new Conta(350);

            banco.adicionaConta(conta1);
            banco.adicionaConta(conta2);
            banco.adicionaConta(conta3);

            //System.out.println("ContaComMaiorSaldo");
            assertEquals(conta2, banco.contaComMaiorSaldo());

        } catch (BancoException bancoException) {
            fail("Exceção: " + bancoException.getMessage());
        } catch (ContaException contaException) {
            fail("Exceção: " + contaException.getMessage());
        } catch (Exception e) {
            fail("Exceção: " + e.getMessage());
        }
    }

    @Test
    public void testContasComSaldoNegativo() {
        //System.out.println("testContasComSaldoNegativo");

        try {
            Conta conta1 = new Conta(30);
            Conta conta2 = new Conta(250);
            Conta conta3 = new Conta(50);
            Conta conta4 = new Conta(100);
            Conta conta5 = new Conta(60);

            conta1.saque(40);
            conta2.saque(300);
            conta3.saque(100);
            conta4.saque(10);
            conta5.saque(30);

            banco.adicionaConta(conta1);
            banco.adicionaConta(conta2);
            banco.adicionaConta(conta3);
            banco.adicionaConta(conta4);
            banco.adicionaConta(conta5);

            //System.out.println("ContaComMaiorSaldo");
            Conta[] contas = new Conta[]{
                conta1,
                conta2,
                conta3
            };

            assertArrayEquals(contas, banco.contasComSaldoNegativo());

        } catch (BancoException bancoException) {
            fail("Exceção: " + bancoException.getMessage());
        } catch (ContaException contaException) {
            fail("Exceção: " + contaException.getMessage());
        } catch (Exception e) {
            fail("Exceção: " + e.getMessage());
        }
    }

    @Test
    public void testRetornaValoresDaDividaDoEmprestimoPelaConta() {
        System.out.println("testRetornaValoresDaDividaDoEmprestimoPelaConta");

        try {
            Conta conta1 = new Conta(1234, "conta1", "", 1);

            Emprestimo emprestimo1 = new Emprestimo(1000, 3.5);
            Emprestimo emprestimo2 = new Emprestimo(3000, 5.75);
            Emprestimo emprestimo3 = new Emprestimo(7500, 2.75);

            conta1.criaEmprestimo(emprestimo1);
            conta1.criaEmprestimo(emprestimo2);
            conta1.criaEmprestimo(emprestimo3);

            banco.adicionaConta(conta1);

            double[] emprestimos = new double[]{
                1035.00
                ,3172.50
                ,7706.25
            };
            //,7687.50

            assertArrayEquals(emprestimos, banco.retornaValoresDaDividaDoEmprestimoPelaConta(conta1.getNumero()), 2);

            Emprestimo emprestimo4 = new Emprestimo(500, 3);
           
            try {
                conta1.criaEmprestimo(emprestimo4);
            } catch (EmprestimoException emprestimoException){
                assertEquals("Exceção: Número máximo de emprestimos concedidos", "Exceção: " + emprestimoException.getMessage());
            } catch (Exception e) {
                fail("Exceção: " + e.getMessage());
            }

        } catch (EmprestimoException emprestimoException) {
            fail("Exceção: " + emprestimoException.getMessage());
        } catch (BancoException bancoException) {
            fail("Exceção: " + bancoException.getMessage());
        } catch (ContaException contaException) {
            fail("Exceção: " + contaException.getMessage());
        } catch (Exception e) {
            fail("Exceção: " + e.getMessage());
        }
    }
}
