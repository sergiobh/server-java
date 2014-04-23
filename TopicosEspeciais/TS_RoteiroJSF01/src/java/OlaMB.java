
import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMB {

    private String nome;

    public void digaOla() {
//faça nada
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
