
package br.edu.ifsc.fln.model.domain;

public class Motor {
    private int potencia;
    private ETipoCombustivel combustivel;   
   
    public Motor(){ }

    public Motor(int potencia, ETipoCombustivel combustivel) {
        this.potencia = potencia;
        this.combustivel = combustivel;
    }

    public int getPotencia() {
        return potencia;
    }

    public ETipoCombustivel getCombustivel() {
        return combustivel;
    }
    
}