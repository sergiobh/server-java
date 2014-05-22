
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SobreMB {

    public String nome = "Sérgio Macedo";
    public String email = "sergiobh@gmail.com";

    public void teste() {
        System.out.println("Você clicou em teste!");
    }

    public String voltar() {
        return "index.html";
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
