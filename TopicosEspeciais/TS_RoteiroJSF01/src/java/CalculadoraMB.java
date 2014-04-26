
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class CalculadoraMB {

    private Integer termoA = 0;
    private Integer termoB = 0;
    private Integer valor = 0;
    private String operador = "";

    public void somar() {
        valor = termoA + termoB;
        this.setOperador("+");
    }

    public void subtrair() {
        valor = termoA - termoB;
        this.setOperador("-");
    }

    public void multiplicar() {
        valor = termoA * termoB;
        this.setOperador("*");
    }

    public void dividir() {
        if (termoB != 0) {
            valor = termoA / termoB;
        } else {
            valor = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não permite divisão por zero!"));
        }

        this.setOperador("/");
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Integer getValor() {
        return valor;
    }

    public Integer getTermoA() {
        return termoA;
    }

    public Integer getTermoB() {
        return termoB;
    }

    public void setTermoA(Integer termoA) {
        this.termoA = termoA;
    }

    public void setTermoB(Integer termoB) {
        this.termoB = termoB;
    }
}
