
package domain;

/**
 *
 * @author rbb
 */
public class Motor {
    private int potencia;
    private ETipoCombustivel combustivel;   
   
    public Motor(){
        
    }

    public Motor(int potencia, ETipoCombustivel combustivel) {
        this.potencia = potencia;
        this.combustivel = combustivel;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public ETipoCombustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(ETipoCombustivel combustivel) {
        this.combustivel = combustivel;
    }
    
}

