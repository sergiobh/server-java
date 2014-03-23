/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplojpa;

import exemplojpa.entidade.Carro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sérgio
 */
public class ExemploJPA {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidade-exemploJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Carro uno = new Carro();
        uno.setPlaca("ABC-0001");
        uno.setModelo("Uno");
        uno.setCor("Prata");
        em.persist(uno);
        Carro gol = new Carro();
        gol.setPlaca("ABC-0002");
        gol.setModelo("Gol");
        gol.setCor("Preto");
        em.persist(gol);
        em.getTransaction().commit();
        List<Carro> carros = em.createQuery("from Carro").getResultList();
        for (Carro c : carros) {
            System.out.println(c.getPlaca());
        }
        System.out.println("Pressione uma tecla para continuar...");
        System.in.read();
        em.close();
        emf.close();
    }
}
