
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysfrota.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sysfrota.entidades.Carro;
import sysfrota.entidades.Modelo;
import sysfrota.persistence.JPAUtil;

/**
 *
 * @author Sérgio
 */
public class CarroDAO {

    private EntityManager em = JPAUtil.getEntityManager();

    public Carro salvar(Carro carro) {
        Carro retorno = em.merge(carro);
        return retorno;
    }

    public Carro carregarPeloId(Long id) {
        return em.find(Carro.class, id);
    }

    public void remover(Carro carro) {
        em.remove(carro);
    }

    public List<Carro> listarTodos() {
        Query query = em.createQuery("SELECT c FROM Carro c ORDER BY nome");
        return query.getResultList();
    }

    /*
     * Busca carro por modelo
     */
    public List<Carro> carrosPorModelo(Modelo modelo) {
        Query query = em.createQuery("SELECT c FROM Carro c WHERE c.modelo = :modelo ORDER BY c.ano");
        query.setParameter("modelo", modelo);

        List<Carro> lista = query.getResultList();
        return lista;
    }

    /*
     * Busca carro que a Placa inicia com as letras informadas
     */
    public List<Carro> carroComPlaca(String placaInicial) {
        Query query = em.createQuery("FROM Carro c WHERE c.placa LIKE :placa");
        query.setParameter("placa", "%" + placaInicial + "%");

        List<Carro> lista = query.getResultList();
        return lista;
    }

    /*
     * Busca carro que a Cor seja a informada
     */
    public List<Carro> carroComCor(String cor) {
        Query query = em.createQuery("FROM Carro c WHERE c.cor = :cor");
        query.setParameter("cor", cor);

        List<Carro> lista = query.getResultList();
        return lista;
    }

    public Long somaQuilometragem() {
        Query query = em.createQuery("SELECT SUM(c.quilometragem) FROM Carro c");
        Long soma = (Long) query.getSingleResult();
        return soma;
    }

    public List<Carro> carrosComMaiorQuilometragem() {
        Query query = em.createQuery("FROM Carro c WHERE "
                + "c.quilometragem = (SELECT MAX(c2.quilometragem) FROM Carro c2)");
        List<Carro> lista = query.getResultList();
        return lista;
    }
}
