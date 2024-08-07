
package domain;

public enum ETipoCombustivel {
    GASOLINA(1, "Gasolina"),
    ETANOL(2, "Etanol"),
    FLEX(3, "Flex"),
    DIESEL(4, "Diesel"),
    GNV(5, "GNV"),
    OUTRO(6, "Outro");
    
    private int id;
    private String nome;
    
    ETipoCombustivel(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public int getId(){return id; }
    
    public String getNome(){return nome;}
    
}
