/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.util;

import exemplo.entity.Carro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rafael.alencar
 */
public class Bootstrap {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Carro uno = new Carro();
        uno.setPlaca("ABC-0001");

        em.persist(uno);

        Carro gol = new Carro();
        gol.setPlaca("ABC-0002");

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

    public static void main1(String[] args) throws Exception {

        Class.forName("org.apache.derby.jdbc.ClientDriver");

        Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/exemplo", "exemplo",
                "exemplo");
        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM cores");
        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("descricao");
            System.out.println("id=" + id + "; nome=" + nome);
        }

        conexao.close();
    }
}
