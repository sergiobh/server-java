/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 31218428
 */
public class Calculadora {

    public int soma(int valorA, int valorB){
        int resultado;
        
        resultado = valorA + valorB;
        
        return resultado;
    }
    
    public float percentual(float valorA, float valorB){
        float resultado;
        
        resultado = valorA * valorB / 100;
        
        return resultado;
    }
    
    public int fatorial(int valorA){
        int retorno = 1;
        
        for (int i = valorA; i > 1; i--) {
            retorno *= i;
        }
        
        return retorno;
    }
    
    public int exponencial(int base, int exponente){
        int retorno = 1;
        
        for (int i = exponente; i >= 1; i--) {
            retorno *= base; 
        }
        
        return retorno;
    }
    
    public int logaritmo(int log, int base){
        int retorno;
        
        retorno = (int) (Math.log(log) / Math.log(base));
        
        return retorno;
    }
}
