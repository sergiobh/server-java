/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sysfrota.entidades;

/**
 *
 * @author Sérgio
 */
public class CarroModelo {
    private Integer id;
    
    private String placa;
    
    private String nome;

    public CarroModelo(String Placa, String Nome) {
        this.placa = Placa;
        this.nome = Nome;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String Placa) {
        this.placa = Placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }
    
    
}
