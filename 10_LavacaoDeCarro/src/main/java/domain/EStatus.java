
package domain;

public enum EStatus {
    ABERTO(1,"aberto"), FECHADO(2,"fechado"), CANCELADA(3,"cancelada");

    private int id;
    private String descricao;

    private EStatus(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
}