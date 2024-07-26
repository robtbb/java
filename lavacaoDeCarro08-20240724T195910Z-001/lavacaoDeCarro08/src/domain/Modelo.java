package domain;

public class Modelo {
    private static int ultimoId = 0;
    private int id;
    private String descricao;
    private Marca marca;
    private ECategoria categoria;
    private Motor motor;
    
    // Método para criar um novo objeto Motor
    public void createMotor() {
        motor = new Motor(75, ETipoCombustivel.GASOLINA);
    }

    // Construtor padrão
    public Modelo() {
        this.id = ++ultimoId;
    }

    

    // Construtor com parâmetros
    public Modelo(String descricao, Marca marca, Motor motor) {
        this();
        this.descricao = descricao;
        this.marca = marca;
        this.motor = motor;
    }

    // Construtor com todos os atributos
    public Modelo(String descricao, Marca marca, ECategoria categoria) {
        this.id = ++ultimoId;
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
     
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public ECategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ECategoria categoria) {
        this.categoria = categoria;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    // Método toString() para representação em string do objeto
    @Override
    public String toString() {
        return  "marca...........: " + marca.getNome() + "\n" +
                "Mod/descri......: " + descricao + "\n" +
                "categoria.......: " + categoria + "\n" +
                "motor...........: " + motor;
    }
}
