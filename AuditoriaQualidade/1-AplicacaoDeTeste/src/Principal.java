/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sérgio
 */
public class Principal {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        
        Principal principal = new Principal();
        principal.exibeValor(calculadora.soma(1, 2));
    }

    public void exibeValor(int retorno) {
        System.out.println("O retorno é: " + retorno);
    }
}
