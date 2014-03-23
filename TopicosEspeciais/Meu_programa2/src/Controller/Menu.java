/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Carros;
import java.util.Scanner;

/**
 *
 * @author Sérgio
 */
public class Menu {

    private int opcao;
    Scanner sc = new Scanner(System.in);
    Carros carros = new Carros();

    public Menu() {
        this.opcao = 1;
    }

    public void carregaMenu() {
        while (this.opcao != 3) {
            this.getMenuPrincipal();

            this.selecionaMetodo();
        }

        this.exibeFimExecussao();
    }

    private void selecionaMetodo() {
        switch (this.opcao) {
            case 1:
                carros.cadastraCarros();
                break;
            case 2:
                carros.exbideCarros();
                break;
        }
    }

    private void getMenuPrincipal() {
        this.exibeMenuPrincipal();
        this.leOpcao();
    }

    private void exibeMenuPrincipal() {
        System.out.println("======================");
        System.out.println("   MENU DE OPÇÕES");
        System.out.println("======================");
        System.out.println("1. Cadastrar carro");
        System.out.println("2. Listar carros");
        System.out.println("3. Sair");
        System.out.println("======================");

        this.exibeSolicitacaoMenuPrincipal();
    }

    private void exibeSolicitacaoMenuPrincipal() {
        System.out.print("Digite a opção (1/2/3): ");
    }

    private void exibeFimExecussao() {
        System.out.println("=== Fim ===");
    }

    public void getOpcao() {

    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void leOpcao() {
        while (!sc.hasNextInt()) {
            this.exibeErroNextInt();
            this.exibeSolicitacaoMenuPrincipal();
            sc.nextLine();
        }

        this.setOpcao(sc.nextInt());
    }

    private void exibeErroNextInt() {
        System.out.println("Número inválido!");
    }
}
