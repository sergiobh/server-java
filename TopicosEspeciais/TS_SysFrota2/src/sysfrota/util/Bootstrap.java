/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysfrota.util;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sysfrota.entidades.Caracteristica;
import sysfrota.entidades.Carro;
import sysfrota.entidades.Fabricante;
import sysfrota.entidades.Modelo;
import sysfrota.entidades.ResumoCarro;
import sysfrota.persistence.JPAUtil;
import sysfrota.persistence.dao.CaracteristicaDAO;
import sysfrota.persistence.dao.CarroDAO;
import sysfrota.persistence.dao.FabricanteDAO;
import sysfrota.persistence.dao.ModeloDAO;

/**
 *
 * @author Sérgio
 */
public class Bootstrap {

    private static FabricanteDAO fabricanteDAO = new FabricanteDAO();
    private static ModeloDAO modeloDAO = new ModeloDAO();
    private static CaracteristicaDAO caracteristicaDAO = new CaracteristicaDAO();
    private static CarroDAO carroDAO = new CarroDAO();

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        /*
         * FABRICANTES
         */
        //Fabricante Fiat
        Fabricante fiat = new Fabricante("Fiat");
        fiat = fabricanteDAO.salvar(fiat);

        //Fabricante Volksvagen
        Fabricante vw = new Fabricante("Volksvagen");
        vw = fabricanteDAO.salvar(vw);

        /*
         * MODELOS
         */
        //Cria o Modelo Fiat Uno
        Modelo fiatUno = new Modelo("Uno", fiat, (short) 2011);
        fiatUno = modeloDAO.salvar(fiatUno);

        //Cria o Modelo Volksvagen Gol
        Modelo vwGol = new Modelo("Gol", vw, (short) 1998);
        vwGol = modeloDAO.salvar(vwGol);

        /*
         * CARACTERISTICAS
         */
        // Quatro Portas
        Caracteristica quatroPortas = new Caracteristica("Quatro portas");
        quatroPortas = caracteristicaDAO.salvar(quatroPortas);

        // Ar Condicionado
        Caracteristica ar = new Caracteristica("Ar condicionado");
        ar = caracteristicaDAO.salvar(ar);

        // Direção Hidráulica
        Caracteristica direcao = new Caracteristica("Direção Hidráulica");
        direcao = caracteristicaDAO.salvar(direcao);

        /*
         * CARROS
         */
        // Cria um Uno
        Carro uno = new Carro("ABC-0001", fiatUno, "Prata", "A1B2C3456789DEF", (short) 2010, Calendar.getInstance(), 200000);

        uno.setCaracteristicas(new LinkedList<Caracteristica>());
        uno.getCaracteristicas().add(quatroPortas);
        uno.getCaracteristicas().add(ar);

        uno = carroDAO.salvar(uno);

        // Cria um Gol
        Carro gol = new Carro("DEF-0002", vwGol, "Azul", "A65D4AS65D4AS", (short) 1994, Calendar.getInstance(), 300000);

        gol.setCaracteristicas(new LinkedList<Caracteristica>());
        gol.getCaracteristicas().add(quatroPortas);
        gol.getCaracteristicas().add(direcao);

        gol = carroDAO.salvar(gol);

        Carro g5 = new Carro("GHI-0003", vwGol, "Prata", "ADHJASFSS4F5465", (short) 2011, Calendar.getInstance(), 40000);

        g5.setCaracteristicas(new LinkedList<Caracteristica>());
        g5.getCaracteristicas().add(quatroPortas);
        g5.getCaracteristicas().add(ar);
        g5.getCaracteristicas().add(direcao);

        g5 = carroDAO.salvar(g5);

        
        /*
         * TRANSACTIONS
         */
        /*
        em.getTransaction().begin();

        try {
            // aqui vão as operações de persitência que fazem parte da transação
            fabricanteDAO.salvar(fiat);
            fabricanteDAO.salvar(vw);
            
            modeloDAO.salvar(fiatUno);
            modeloDAO.salvar(vwGol);

            caracteristicaDAO.salvar(quatroPortas);
            caracteristicaDAO.salvar(ar);
            caracteristicaDAO.salvar(direcao);


            carroDAO.salvar(uno);
            carroDAO.salvar(gol);
            carroDAO.salvar(g5);
            
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
        }
        /*
        
        /*
         * EXIBIÇÃO DAS LISTAS
         */
        // Lista os Fabricantes por Ordem de Nome
        List<Fabricante> listaFabricantes = fabricanteDAO.listarTodos();

        for (Fabricante fabricante : listaFabricantes) {
            System.out.println("Id=" + fabricante.getId() + "; Nome=" + fabricante.getNome());
        }

        // Lista os Modelos por Ordem de Ano e Nome
        List<Modelo> listaModelos = modeloDAO.listarTodos();

        for (Modelo modelo : listaModelos) {
            System.out.println("Id=" + modelo.getId() + "; Ano=" + modelo.getAno() + "; Nome=" + modelo.getNome());
        }

        // Listar todos os modelos de um determinado Fabricante num dado Ano
        List<Modelo> listaFabricanteAno = modeloDAO.listarDoFabricanteNoAno(vw, (short) 1998);

        for (Modelo modelo : listaFabricanteAno) {
            System.out.println("Id=" + modelo.getId() + "; Ano=" + modelo.getAno() + "; Nome=" + modelo.getNome());
        }

        // Lista as Caracteristicas por Ordem de Nome
        List<Caracteristica> listaCaracteristicas = caracteristicaDAO.listarTodos();

        for (Caracteristica caracteristica : listaCaracteristicas) {
            System.out.println("Id=" + caracteristica.getId() + "; Nome=" + caracteristica.getNome());
        }

        /*
         /* FIM DO SISTEMA
         */
        System.out.println("Pressione uma tecla para continuar...");
        System.in.read();

        JPAUtil.close();
    }

}
