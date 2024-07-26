package domain;

public class Cor {
    private static long ultimoId = 0;
    private long id;
    private String nome;
    
    public Cor(){
        this.id = ++ultimoId;
    }
    
    public Cor(String nome) {
        this.id = ++ultimoId;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cor{" + "id=" + id + ", nome=" + nome + '}';
    }   
}

/* === DOCUMENTAÇÃO ===

foi implementado um esquema de agregar o id de forma altomatica
sem precisar ficar instanciando

*/