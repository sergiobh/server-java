
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysfrota.persistence.dao;

import java.util.Calendar;
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

    //private EntityManager em = JPAUtil.getEntityManager();

    public Fabricante salvar(Fabricante fabricante) {
        Fabricante retorno = JPAUtil.getEntityManager().merge(fabricante);
        return retorno;
    }

    public Fabricante carregarPeloId(Long id) {
        return JPAUtil.getEntityManager().find(Fabricante.class, id);
    }

    public void remover(Fabricante fabricante) {
        JPAUtil.getEntityManager().remove(JPAUtil.getEntityManager().find(Fabricante.class, fabricante.getId()));
        JPAUtil.getEntityManager().flush();
    }

    public List<Fabricante> listarTodos() {
        Query query = JPAUtil.getEntityManager().createQuery("SELECT f FROM Fabricante f ORDER BY nome");
        return query.getResultList();
    }

    public Long quantidadeModelos(Fabricante fabricante) {
        Query query = JPAUtil.getEntityManager().createQuery("SELECT COUNT(m) FROM Modelo m WHERE m.fabricante = :f");
        query.setParameter("f", fabricante);
        Long quantidade = (Long) query.getSingleResult();
        return quantidade;
    }

    public List<Fabricante> fabricantesVigentes() {
        Query query = JPAUtil.getEntityManager().createQuery("FROM Fabricante f WHERE EXISTS "
                + "(FROM Carro c WHERE c.modelo.fabricante = f AND c.ano = :a)");
        short anoVigente = (short) Calendar.getInstance().get(Calendar.YEAR);
        query.setParameter("a", anoVigente);
        List<Fabricante> lista = query.getResultList();
        return lista;
    }
}
