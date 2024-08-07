
package entity;

public class Pontuacao {
    private int pontos;

    public Pontuacao(){
        this.pontos = 0; /// a baixo tem a explicação sobre isso
    }
  
    //construtor
    public Pontuacao(int pontos) {
        this.pontos = pontos;
    }
    
    
    //metodos
    public int adcionar(int pontos){
        if ( pontos > 0 )
        {
            this.pontos+=pontos;
        }else{
            System.out.println("Valor invalido");
        }
        return pontos;
    }
    
    public int subtrair(int pontos){
        if( pontos > 0)
        {
           if(this.pontos >= pontos){
               this.pontos -= pontos;
           }else{
               System.out.println("Pontos insuficientes. *pontos: " + this.pontos );
           }
        }
        return pontos;
    }
    
    public int saldo()
    {
        return this.pontos;
    }
   
    
}

