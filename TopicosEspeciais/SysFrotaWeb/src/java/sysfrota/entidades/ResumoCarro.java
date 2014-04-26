package sysfrota.entidades;

public class ResumoCarro {
    
    private String placa;
    private String modelo;
    private String fabricante;

    public ResumoCarro() {
    }

    public ResumoCarro(String placa, String modelo, String fabricante) {
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Placa="+this.placa+"; Fabricante="+this.fabricante+"; Modelo="+this.modelo+";";
    }
    
}
