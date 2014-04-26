/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysfrota.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sysfrota.entidades.Fabricante;
import sysfrota.entidades.Modelo;
import sysfrota.persistence.JPAUtil;

/**
 *
 * @author Sérgio
 */
public class ModeloDAO {

    private EntityManager em = JPAUtil.getEntityManager();

    public Modelo salvar(Modelo modelo) {
        Modelo retorno = em.merge(modelo);
        return retorno;
    }

    public Modelo carregarPeloId(Long id) {
        return em.find(Modelo.class, id);
    }

    public void remover(Modelo modelo) {
        em.remove(modelo);
    }

    public List<Modelo> listarTodos() {
        Query query = em.createQuery("SELECT m FROM Modelo m ORDER BY ano, nome");
        return query.getResultList();
    }

    public List<Modelo> listarDoFabricante(Fabricante fabricante) {
        Query query = em.createQuery("FROM Modelo m WHERE m.fabricante = :f ORDER BY m.nome");
        query.setParameter("f", fabricante);
        return query.getResultList();
    }
    
    public List<Modelo> listarDoFabricanteNoAno(Fabricante fabricante, Short ano){
        Query query = em.createQuery("FROM Modelo m WHERE m.fabricante = :f AND m.ano = :ano ORDER BY m.nome");
        query.setParameter("f", fabricante);
        query.setParameter("ano", ano);
        return query.getResultList();
    }
}
