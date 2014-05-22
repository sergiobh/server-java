
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysfrota.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sysfrota.entidades.Caracteristica;
import sysfrota.persistence.JPAUtil;

/**
 *
 * @author Sérgio
 */
public class CaracteristicaDAO {

    private EntityManager em = JPAUtil.getEntityManager();

    public Caracteristica salvar(Caracteristica caracteristica) {
        Caracteristica retorno = em.merge(caracteristica);
        return retorno;
    }

    public Caracteristica carregarPeloId(Long id) {
        return em.find(Caracteristica.class, id);
    }

    public void remover(Caracteristica caracteristica) {
        em.remove(em.find(Caracteristica.class, caracteristica.getId()));
        em.flush();
    }

    public List<Caracteristica> listarTodos() {
        Query query = em.createQuery("SELECT c FROM Caracteristica c ORDER BY nome");
        return query.getResultList();
    }

}
