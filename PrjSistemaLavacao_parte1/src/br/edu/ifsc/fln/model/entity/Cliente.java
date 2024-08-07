
package br.edu.ifsc.fln.model.entity;


import br.edu.ifsc.fln.model.domain.Veiculo;
import java.util.ArrayList;
import java.util.Date;

public abstract class Cliente implements ICliente {
    // Atributos
    protected int id;
    protected String nome;
    protected String email;
    protected Date dataCadastro;
    
    protected Pontuacao pontos;
    
    protected ArrayList<Veiculo> veiculos = new ArrayList<>();//associação muitos para 1
    
    public Cliente(){}
    
    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataCadastro = new Date();
        this.pontos = new Pontuacao(); /// mais uma forma de fazer a associação por composição
    }

    // Métodos para manipulação de veículos
    public void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        veiculo.setCliente(this);
        
    }


    public void removeVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
        veiculo.setCliente(null);
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    // Métodos da interface ICliente
    @Override
    public String getDados() {
        StringBuilder detalhesCliente = new StringBuilder();
        detalhesCliente.append("ID...: ").append(id).append("\n");
        detalhesCliente.append("Nome.: ").append(nome).append("\n");
        detalhesCliente.append("email: ").append(email).append("\n");
        detalhesCliente.append("data.: ").append(dataCadastro).append("\n");
        

        if (veiculos.isEmpty()) {
            detalhesCliente.append("Nenhum veículo associado.\n");
        } else {
            detalhesCliente.append("Veículos associados:\n");
            for (Veiculo veiculo : veiculos) {
                detalhesCliente.append("- Placa: ").append(veiculo.getPlaca()).append(", Observação: ").append(veiculo.getObservacao()).append("\n");
            }
        }

        return detalhesCliente.toString();
    }

    
   
    public void adicionarPontos(int pontos) {
        this.pontos.adcionar(pontos);
    }

    public void subtrairPontos(int pontos) {
        this.pontos.subtrair(pontos);
    }

    public int consultarSaldo() {
        return this.pontos.saldo();
    }
    
}