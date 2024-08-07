
package br.edu.ifsc.fln.model.domain;

import br.edu.ifsc.fln.model.entity.Cliente;

public class Veiculo {
    private int id;
    private String placa;
    private String observacao;
    
    private Modelo modelo; // Agregação de Modelo
    private Cor cor;
    private Cliente cliente;

    public Veiculo() {}

    public Veiculo(int id, String placa) {
        this.id=id;
        this.placa = placa;
    }
    
    public Veiculo(int id, String placa, Modelo modelo){
        this(id, placa);
        this.modelo = modelo;
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
        return "veiculo" +
               "id =" + id +
               ", placa=" + placa + 
               ", observacao=" + observacao + 
               ", modelo=" + modelo + 
               ", cor=" + cor + 
               ", cliente=" + cliente ;
    }
    
}