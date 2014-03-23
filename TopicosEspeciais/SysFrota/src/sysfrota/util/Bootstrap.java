/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysfrota.util;

import java.util.Calendar;
import java.util.LinkedList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sysfrota.entidades.Caracteristica;
import sysfrota.entidades.Carro;
import sysfrota.entidades.Fabricante;
import sysfrota.entidades.Modelo;

/**
 *
 * @author Sérgio
 */
public class Bootstrap {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db_sysfrota");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //cria Características
        Caracteristica quatroPortas = new Caracteristica();
        quatroPortas.setNome("Quatro portas");
        em.persist(quatroPortas);

        Caracteristica ar = new Caracteristica();
        ar.setNome("Ar condicionado");
        em.persist(ar);

        Caracteristica direcao = new Caracteristica();
        direcao.setNome("Direção Hidráulica");
        em.persist(direcao);

        //Fabricante Fiat
        Fabricante fiat = new Fabricante();
        fiat.setNome("Fiat");
        em.persist(fiat);

        //Cria o Modelo Fiat Uno
        Modelo fiatUno = new Modelo();
        fiatUno.setNome("Uno");
        fiatUno.setFabricante(fiat);
        fiatUno.setAno((short) 2011);
        em.persist(fiatUno);

        //Cria um Uno
        Carro uno = new Carro();
        uno.setPlaca("ABC-0001");
        uno.setModelo(fiatUno);
        uno.setCor("Prata");
        uno.setChassi("A1B2C3456789DEF");
        uno.setAno((short) 2010);
        uno.setDataDeAquisicao(Calendar.getInstance());
        uno.setQuilometragem(200000);

        uno.setCaracteristicas(new LinkedList<Caracteristica>());
        uno.getCaracteristicas().add(quatroPortas);
        uno.getCaracteristicas().add(ar);

        em.persist(uno);

        //Fabricante Volksvagen
        Fabricante vw = new Fabricante();
        vw.setNome("Volksvagen");
        em.persist(vw);

        //Cria o Modelo Volksvagen Gol
        Modelo vwGol = new Modelo();
        vwGol.setNome("Gol");
        vwGol.setFabricante(vw);
        vwGol.setAno((short) 1998);
        em.persist(vwGol);

        Carro gol = new Carro();
        gol.setPlaca("DEF-0002");
        gol.setModelo(vwGol);
        gol.setCor("Azul");
        gol.setChassi("A65D4AS65D4AS");
        gol.setAno((short) 1994);
        gol.setDataDeAquisicao(Calendar.getInstance());
        gol.setQuilometragem(300000);

        gol.setCaracteristicas(new LinkedList<Caracteristica>());
        gol.getCaracteristicas().add(quatroPortas);
        gol.getCaracteristicas().add(direcao);

        em.persist(gol);

        //Cria o Modelo Volksvagen Gol
        Modelo fiatPalio = new Modelo();
        fiatPalio.setNome("Palio");
        fiatPalio.setFabricante(fiat);
        fiatPalio.setAno((short) 1995);
        em.persist(fiatPalio);

        Carro palio = new Carro();
        palio.setPlaca("GHI-0003");
        palio.setModelo(fiatPalio);
        palio.setCor("Verde");
        palio.setChassi("ADHJASFSS4F5465");
        palio.setAno((short) 1991);
        palio.setDataDeAquisicao(Calendar.getInstance());
        palio.setQuilometragem(400000);

        palio.setCaracteristicas(new LinkedList<Caracteristica>());
        palio.getCaracteristicas().add(quatroPortas);
        palio.getCaracteristicas().add(ar);
        palio.getCaracteristicas().add(direcao);

        em.persist(palio);

        em.getTransaction().commit();

        System.out.println("Pressione uma tecla para continuar...");
        System.in.read();
        em.close();
        emf.close();
    }

}
