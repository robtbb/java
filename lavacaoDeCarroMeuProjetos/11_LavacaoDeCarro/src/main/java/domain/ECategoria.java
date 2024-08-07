
package domain;

public enum ECategoria {
    PEQUENO(1, "Pequeno"),
    MEDIO(2, "Medio"),
    GRANDE(3, "Grande"),
    MOTO(4, "Moto"),
    PADRAO(5, "Padrao"),
    NULL(0, "Nulo");
    
    private int id;
    private String nome;
    
    ECategoria(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public int Id(){ return id; }
    public String getNome(){ return nome;}
}
