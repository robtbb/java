
package domain;

import java.util.ArrayList;
import java.util.List;

public class Modelo {
    private int id;
    private String descricao;
    
    private Marca marca;
    private ECategoria categoria = ECategoria.MEDIO;
    private Motor motor;
    private List<Veiculo> veiculos;
    
    // Método para criar um novo objeto Motor
    public void createMotor() {
        motor = new Motor();
    }

    // Construtor padrão
    public Modelo() {
         createMotor();
         this.veiculos = new ArrayList<>();  
    }
    
    
    // Construtor com todos os atributos
    public Modelo(int id, String descricao) {
        this();
        this.id = id;
        this.descricao = descricao;
    }
    
  
    // Construtor com parâmetros
    public Modelo(int id,String descricao, Marca marca) {
        this(id, descricao);
        this.marca = marca;
    }

    
    
    public Modelo(int id, String descricao, Marca marca, ECategoria categoria){
        this(id, descricao, marca);
        this.categoria = categoria;
    }
    
    public Modelo(int id, String descricao, Marca marca, ECategoria categoria, Motor motor){
        this(id, descricao, marca,categoria);
        this.motor = motor;
    }
    
     
    public Motor getMotor() {
        return motor;
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
    
    // Método toString() para representação em string do objeto
    @Override
    public String toString() {
        return  "marca...........: " + marca.getNome() + "\n" +
                "Mod/descri......: " + descricao + "\n" +
                "categoria.......: " + categoria + "\n" +
                "motor...........: " + motor;
    }
    
    
    
     // Método para adicionar um veículo ao modelo
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        veiculo.setModelo(this);
    }

    // Método para remover um veículo do modelo
    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
        veiculo.setModelo(null);
    }

}