
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExemploJDBC {

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/exemploJPA", "dba", "dba");
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
