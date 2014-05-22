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

/**
 *
 * @author Sérgio
 */
@Entity
public class Fabricante implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    public Fabricante() {
    }

    public Fabricante(String nome) {
        this.setNome(nome);
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

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) o;
        return this.getId().equals(other.getId());
    }
}
