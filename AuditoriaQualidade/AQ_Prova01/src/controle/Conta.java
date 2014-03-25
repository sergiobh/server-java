package controle;

import excecao.ContaException;
import excecao.EmprestimoException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author edgardcardoso
 */
public class Conta {

    private int numero;
    private String correntista;
    private String cpf;
    private double saldo;
    private Emprestimo[] emprestimos;
    private int numeroDeEmprestimos;

    public Conta() {
    }

    public int getNumero() {
        return numero;
    }

    public Conta(double saldo) throws ContaException {
        if (saldo > 0) {
            this.saldo = saldo;
        } else {
            throw new ContaException(Erro.CONTA_COM_VALOR_NEGATIVO);
        }
    }

    public Conta(int numero, String correntista, String cpf, double saldo) throws ContaException {
        this.numero = numero;
        this.correntista = correntista;
        this.cpf = cpf;
        if (saldo > 0) {
            this.saldo = saldo;
        } else {
            throw new ContaException(Erro.INICIAR_CONTA_COM_SALDO_NEGATIVO);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void saque(double valor) throws ContaException {
        if (valor <= 0) {
            throw new ContaException("Não é possNãoível fazer saque de valor negativo");
        } else {
            this.saldo = this.saldo - valor;
        }
    }

    public void deposito(double valor) throws ContaException {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
        } else {
            throw new ContaException("Não é possível fazer depósito de valor negativo");
        }
    }

    public void criaEmprestimo(Emprestimo emprestimo) throws EmprestimoException {
        if (numeroDeEmprestimos == 3) {
            throw new EmprestimoException("Número máximo de emprestimos concedidos");
        }
        if (emprestimos == null) {
            emprestimos = new Emprestimo[3];
        }
        emprestimos[numeroDeEmprestimos] = emprestimo;
        numeroDeEmprestimos++;
    }

    public double[] retornaValoresDasDividasDoEmprestimo() throws EmprestimoException {
        if (numeroDeEmprestimos == 0) {
            throw new EmprestimoException("Não existe nenhum emprestimo contratado.");
        }
        double[] valores = new double[numeroDeEmprestimos];
        for (int i = 0; i < numeroDeEmprestimos; i++) {
            valores[i] = ((emprestimos[i].getValor()
                    * emprestimos[i].getJuros()) / 100.00)
                    + emprestimos[i].getValor();
        }
        return valores;
    }
}
