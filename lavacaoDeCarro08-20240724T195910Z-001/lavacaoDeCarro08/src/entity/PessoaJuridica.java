/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author rbb
 */
public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String incricaoEstadual;

    // Construtor
    public PessoaJuridica(int id, String nome, String email, String cnpj, String incricaoEstadual) {
        super(id, nome, email); // Chama o construtor da classe pai para inicializar os atributos comuns
        this.cnpj = cnpj;
        this.incricaoEstadual = incricaoEstadual;
    }

    // Métodos de acesso
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIncricaoEstadual() {
        return incricaoEstadual;
    }

    public void setIncricaoEstadual(String incricaoEstadual) {
        this.incricaoEstadual = incricaoEstadual;
    }

    // Outros métodos específicos para pessoas jurídicas podem ser adicionados aqui conforme necessário
}

