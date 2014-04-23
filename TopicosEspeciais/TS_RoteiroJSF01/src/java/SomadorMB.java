
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SomadorMB {

    private Integer termoA = 0;
    private Integer termoB = 0;
    private Integer soma = 0;

    public void somar() {
        soma = termoA + termoB;
    }

    public Integer getSoma() {
        return soma;
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
