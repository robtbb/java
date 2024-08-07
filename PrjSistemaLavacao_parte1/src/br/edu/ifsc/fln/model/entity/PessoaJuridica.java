
package br.edu.ifsc.fln.model.entity;

import java.util.Date;

public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String inscricaoEstadual;

    // Construtor
    public PessoaJuridica(){}
    
    public PessoaJuridica(String cnpj, String inscricaoEstadual){
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }
    public PessoaJuridica(int id, String nome, String email, String cnpj, String incricaoEstadual) {
        super(id, nome, email); // Chama o construtor da classe pai para inicializar os atributos comuns
        this.cnpj = cnpj;
        this.inscricaoEstadual = incricaoEstadual;
    }

    // Métodos de acesso
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIncricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setIncricaoEstadual(String incricaoEstadual) {
        this.inscricaoEstadual = incricaoEstadual;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "cnpj=" + cnpj + ", inscricaoEstadual=" + inscricaoEstadual + '}';
    }
    
    
    @Override
    public String getDados(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.getDados());
        sb.append("Cnpj..............: ").append(cnpj).append("\n");
        sb.append("Inscricao Estadual: ").append(inscricaoEstadual);
        return sb.toString();
    }
    
    @Override
    public String getDados(String obs){
        StringBuilder sb = new StringBuilder();
        sb.append(super.getDados());
        sb.append(getDados()).append("\n").append(obs);
        return sb.toString();
    }

}