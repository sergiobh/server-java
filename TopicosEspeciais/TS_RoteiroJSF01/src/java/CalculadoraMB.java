
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CalculadoraMB {

    private Integer termoA = 0;
    private Integer termoB = 0;
    private Integer valor = 0;

    public void somar() {
        valor = termoA + termoB;
    }

    public void subtrair() {
        valor = termoA - termoB;
    }

    public void multiplicar() {
        valor = termoA * termoB;
    }

    public void dividir() {
        if(termoB != 0){
            valor = termoA / termoB;
        }
        else{
            valor = 0;
        }
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
