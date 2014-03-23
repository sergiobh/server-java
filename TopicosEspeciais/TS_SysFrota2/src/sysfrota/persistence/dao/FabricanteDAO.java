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
import sysfrota.entidades.ResumoCarro;
import sysfrota.persistence.JPAUtil;

/**
 *
 * @author Sérgio
 */
public class FabricanteDAO {

    private EntityManager em = JPAUtil.getEntityManager();

    public Fabricante salvar(Fabricante fabricante) {
        Fabricante retorno = em.merge(fabricante);
        return retorno;
    }

    public Fabricante carregarPeloId(Long id) {
        return em.find(Fabricante.class, id);
    }

    public void remover(Fabricante fabricante) {
        em.remove(fabricante);
    }

    public List<Fabricante> listarTodos() {
        Query query = em.createQuery("SELECT f FROM Fabricante f ORDER BY nome");
        return query.getResultList();
    }
    
}
