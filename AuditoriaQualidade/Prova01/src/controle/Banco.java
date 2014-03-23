package controle;

import excecao.BancoException;
import excecao.EmprestimoException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author edgardcardoso
 */
public class Banco {

    private String nome;
    private int numero;
    private Conta[] contas;
    
    private int quantidadeDeContas = 0;
    private final int MAX_CONTAS = 5;

    public Banco() {
        contas = new Conta[MAX_CONTAS];
    }

    public Banco(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
        contas = new Conta[MAX_CONTAS];
    }

    public int getQuantidadeDeContas() {
        return quantidadeDeContas;
    }

    public Conta contaComMaiorSaldo() {

        double maiorSaldo = 0;
        int index = 0;
        for (int i = 0; i < this.quantidadeDeContas; i++) {
            if (this.contas[i].getSaldo() > maiorSaldo) {
                maiorSaldo = this.contas[i].getSaldo();
                index = i;
            }
        }
        return this.contas[index];
    }

    public void adicionaConta(Conta conta) throws BancoException {
        if (this.quantidadeDeContas < this.MAX_CONTAS) {
            this.contas[this.quantidadeDeContas] = conta;
            this.quantidadeDeContas++;
        } else {
            throw new BancoException("Número máximo de contas atingido");
        }

    }

            
    public Conta[] contasComSaldoNegativo() {
        int quantidadeDeContasComSaldoNegativo = 0;
        for (int i = 0; i < this.quantidadeDeContas; i++) {
            if (this.contas[i].getSaldo() < 0) {
                quantidadeDeContasComSaldoNegativo++;
            }
        }

        Conta[] contasComSaldoNegativo = new Conta[quantidadeDeContasComSaldoNegativo];
        int index = 0;
        for (int i = 0; i < this.quantidadeDeContas; i++) {
            if (this.contas[i].getSaldo() < 0) {
                contasComSaldoNegativo[index] = this.contas[i];
                index++;
            }
        }
        return contasComSaldoNegativo;
    }

    public Conta getConta(int numeroDaConta) {
        for (int i = 0; i < this.quantidadeDeContas; i++) {
            if (contas[i].getNumero() == numeroDaConta) {
                return contas[i];
            }
        }
        return null;
    }
    
    public double [] retornaValoresDaDividaDoEmprestimoPelaConta(int numeroDaConta) throws EmprestimoException{
        return this.getConta(numeroDaConta).retornaValoresDasDividasDoEmprestimo();
    }
}
