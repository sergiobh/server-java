
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SobreMB {

    private String nome = "Rafael Odon";
    private String email = "rafael.alencar@prof.una.br";

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
