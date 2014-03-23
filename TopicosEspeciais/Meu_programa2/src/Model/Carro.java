/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author Sérgio
 */
public class Carro {

    private String placa;
    private String cor;
    private int ano;
    Scanner sc = new Scanner(System.in);

    public void setCarro() {
        this.lePlaca();
        this.leCor();
        this.leAno();
        this.getMensagemCadastro();
    }

    public String getPlaca() {
        return placa;
    }

    private void setPlaca(String placa) {
        this.placa = placa;
    }

    private void leCor() {
        this.exibeSolicitacaoCor();

        while (!sc.hasNext()) {
            this.exibeSolicitacaoCor();
            sc.nextLine();
        }

        this.setCor(sc.next());
    }

    private void exibeSolicitacaoCor() {
        System.out.print("Cor: ");
    }

    private void lePlaca() {
        this.exibeSolicitacaoPlaca();

        while (!sc.hasNext()) {
            this.exibeSolicitacaoPlaca();
            sc.nextLine();
        }

        this.setPlaca(sc.next());
    }

    private void exibeSolicitacaoPlaca() {
        System.out.print("Placa (Ex: AAA-0000): ");
    }

    public String getCor() {
        return cor;
    }

    private void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    private void setAno(int ano) {
        this.ano = ano;
    }

    private void leAno() {
        this.exibeSolicitacaoAno();
        
        while (!sc.hasNextInt()) {
            this.exibeErroNextInt();
            this.exibeSolicitacaoAno();
            sc.nextLine();
        }

        int anoTemp = sc.nextInt();
        
        if (anoTemp < 1900 || anoTemp > 2012) {
            System.out.println("ERRO: ano inválido! Cadastre o carro novamente.");
            this.leAno(); // Metodo recursivo em caso de erro
        }
        else{
            this.setAno(anoTemp);
        }
    }

    private void exibeSolicitacaoAno() {
        System.out.println("Ano: ");
    }

    private void exibeErroNextInt() {
        System.out.println("Número inválido!");
    }

    private void exibeMenuCadastro() {
        System.out.println("\n\n=== Cadastrar carro ===");
    }
    
    private void getMensagemCadastro(){
        System.out.println("=== Cadastro concluído. ===\n\n");
    }
}
