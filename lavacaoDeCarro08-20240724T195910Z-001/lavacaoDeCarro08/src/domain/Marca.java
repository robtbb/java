package domain;

public class Marca {
    private static int ultimoId = 0;
    private int id;
    private String nome;

    public Marca() {
        this.id = ++ultimoId;
    }

    public Marca(String nome) {
        this.id = ++ultimoId;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Marca{" + "id=" + id + ", nome=" + nome + '}';
    }
}

/* === DOCUMENTAÇÃO ===

foi implementado um esquema de agregar o id de forma altomatica
sem precisar ficar instanciando
*/