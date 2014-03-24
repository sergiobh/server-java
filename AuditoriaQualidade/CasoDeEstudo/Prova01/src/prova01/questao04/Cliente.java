/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova01.questao04;

/**
 *
 * @author edgardcardoso
 */
public class Cliente {
    
    private String nome;
    private String cep;
    private String endereco;
    
    private ICorreios correios;

    public Cliente(String nome) {
        this.nome = nome;
    }
    
    public void setCorreios(ICorreios correio){
        this.correios  = correio;
    }
    
    public void setCep(String cep){
        this.cep= cep;
        this.endereco = correios.getEndereco(this.cep);
    }

    public String getEndereco() {
        return endereco;
    }
    
    
    
}
