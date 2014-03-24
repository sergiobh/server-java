package prova01.questao01;

import prova01.questao02.Erro;

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
            throw new ContaException(Erro.INICIAR_CONTA_COM_SALDO_NEGATIVO);
        }
    }

    public Conta(int numero, double saldo) throws ContaException {
        this.numero = numero;
        if (saldo > 0) {
            this.saldo = saldo;
        } else {
            throw new ContaException(Erro.INICIAR_CONTA_COM_SALDO_NEGATIVO);
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
            throw new ContaException(Erro.SAQUE_DE_VALOR_NETATIVO);
        } else {
            this.saldo = this.saldo - valor;
        }
    }

    public void deposito(double valor) throws ContaException {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
        } else {
            throw new ContaException(Erro.DEPOSITO_DE_VALOR_NEGATIVO);
        }
    }

    public void criaEmprestimo(Emprestimo emprestimo) throws EmprestimoException {
        if (numeroDeEmprestimos == 3) {
            throw new EmprestimoException(Erro.NUMERO_MAXIMO_DE_EMPRESTIMOS_CONCEDIDOS);
        }
        if (emprestimos == null) {
            emprestimos = new Emprestimo[3];
        }
        emprestimos[numeroDeEmprestimos] = emprestimo;
        numeroDeEmprestimos++;
    }

    public double[] retornaValoresDasDividasDoEmprestimo() throws EmprestimoException {
        if (numeroDeEmprestimos == 0) {
            throw new EmprestimoException(Erro.NAO_EXISTE_EMPRESTIMO_CONTRATADO);
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
