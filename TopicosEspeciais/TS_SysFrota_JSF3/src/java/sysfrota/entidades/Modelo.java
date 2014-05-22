/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sysfrota.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sérgio
 */
@Entity
public class Modelo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    private String nome;
    
    @ManyToOne
    private Fabricante fabricante = new Fabricante();
    
    private Short ano;
    
    public Modelo() {            
    }
    
    public Modelo(String nome, Fabricante fabricante, short ano) {
        this.setNome(nome);
        this.setFabricante(fabricante);
        this.setAno(ano);
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    public String getModelo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
