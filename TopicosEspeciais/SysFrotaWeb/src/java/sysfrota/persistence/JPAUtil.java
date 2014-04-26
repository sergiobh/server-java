/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysfrota.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sérgio
 */
public class JPAUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("db_sysfrota");
    private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();

    public static EntityManager getEntityManager() {
        EntityManager em = JPAUtil.manager.get();
        if (em == null || !em.isOpen()) {
            em = JPAUtil.emf.createEntityManager();
            JPAUtil.manager.set(em);
        }
        return em;
    }

    public static void close() {
        emf.close();
    }
}
