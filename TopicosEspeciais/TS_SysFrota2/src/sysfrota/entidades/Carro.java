package sysfrota.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Sérgio Macedo
 */
@Entity
@Table(name = "veiculo")
public class Carro implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 8, nullable = false)
    private String placa;

    @ManyToOne
    private Modelo modelo = new Modelo();

    @Column(length = 30)
    private String cor;

    @Column(name = "ano_de_fabricacao")
    private Short ano;

    @Column(length = 20, nullable = false)
    private String chassi;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataDeAquisicao;

    private Integer quilometragem;

    @ManyToMany
    private List<Caracteristica> caracteristicas;

    public Carro(){
        
    }
    
    public Carro(String placa, Modelo modelo, String cor, String chassi, short ano, Calendar dataDeAquisicao, Integer quilometragem) {
        this.setPlaca(placa);
        this.setModelo(modelo);
        this.setCor(cor);
        this.setChassi(chassi);
        this.setAno(ano);
        this.setDataDeAquisicao(dataDeAquisicao);
        this.setQuilometragem(quilometragem);        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Calendar getDataDeAquisicao() {
        return dataDeAquisicao;
    }

    public void setDataDeAquisicao(Calendar dataDeAquisicao) {
        this.dataDeAquisicao = dataDeAquisicao;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristica) {
        this.caracteristicas = caracteristica;
    }
}
