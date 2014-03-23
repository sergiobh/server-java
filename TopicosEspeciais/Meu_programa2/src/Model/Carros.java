/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sérgio
 */
public class Carros {

    List<Carro> carros;

    public Carros() {
        carros = new ArrayList<Carro>();
    }

    public void cadastraCarros() {
        Carro carro = new Carro();
        carro.setCarro();

        carros.add(carro);
    }

    public void exbideCarros() {
        System.out.println("\n\n=== Listar carros ===");
        
        for (Carro carroItem : carros) {
            System.out.println("Placa=" + carroItem.getPlaca() + ", Cor=" + carroItem.getCor() + ", Ano=" + carroItem.getAno());
        }

        if (carros.size() == 0) {
            System.out.println("(vazio)");
        }

        System.out.println("=== Listagem concluída. ===\n\n");
    }

}
