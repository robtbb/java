   
package domain;
import entity.*;

/**
 *
 * @author rbb
 */

public class Veiculo {
    private static int ultimoId = 0;
    private int id;
    private String placa;
    private String observacao;
    private Modelo modelo; // Agregação de Modelo
    private Cor cor;
    private Cliente cliente;

    public Veiculo() {
        this.id = ultimoId;
    }

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public Veiculo(String placa, Modelo modelo) {
        this.placa = placa;
        this.modelo = modelo; // Agregação de Modelo
    }

    public Veiculo( String placa, Modelo modelo, String observacao) {
        this.id = ultimoId;
        this.placa = placa;
        this.observacao = observacao;
        this.modelo = modelo; // Agregação de Modelo
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

    @Override
    public String toString() {
        return   modelo +
                "\nveiculo.........: " + placa  +"\n"+
                  "observacao......: " + observacao  +"\n"
               ;
    }

   
  
    
}

