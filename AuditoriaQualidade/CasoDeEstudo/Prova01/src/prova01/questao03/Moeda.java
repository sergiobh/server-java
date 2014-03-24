/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova01.questao03;

import java.io.IOException;

/**
 *
 * @author edgardcardoso
 */
public class Moeda {
    
    private String tipoMoeda;
    private long valor;
    private int centavos;


    public Moeda(double valor , String tipoMoeda) {
        setValor(valor);
        this.tipoMoeda = tipoMoeda;
        
    }

    private void setValor(double valor) {
        this.valor = new Double(valor).longValue();
        this.centavos = (int) ((valor * 100.0) % 100);
    }

    public Moeda toEuros(ICotacao cotacao) throws Exception {
        if ("EUR".equals(tipoMoeda)) {
            return this;
        }
        else {
            double input = valor + centavos/100.0;
            double rate;
            try {
                rate = cotacao.getCotacao(tipoMoeda, "EUR");
                double output = input * rate;
                return new Moeda(output, "EUR");
            } catch (IOException ex) {
                return null;
            }
        }
    }
    
     public Moeda toDollar(ICotacao cotacao) throws Exception {
        if ("USD".equals(tipoMoeda)) {
             return this;
         }
        else {
            double input = valor + centavos/100.0;
            double rate;
            try {
                rate = cotacao.getCotacao(tipoMoeda, "USD");
                double output = input * rate;
                return new Moeda(output, "USD");
            } catch (IOException ex) {
                return null;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Moeda) {
            Moeda other = (Moeda) o;
            return this.tipoMoeda.equals(other.tipoMoeda)
                    && this.valor == other.valor
                    && this.centavos == other.centavos;
        }
        return false;
    }

    @Override
    public String toString() {
        return valor + "." + Math.abs(centavos) + " " + tipoMoeda;
    }
    
}
