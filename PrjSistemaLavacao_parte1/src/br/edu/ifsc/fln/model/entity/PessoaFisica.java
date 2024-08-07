
/*
Considere um desconto na semana do 
aniversáio do voiente tipo PF
*/

package br.edu.ifsc.fln.model.entity;


import java.util.Date;

public class PessoaFisica extends Cliente {
    private String cpf;
    private Date dataNascimento;
    
    public PessoaFisica(int id, String cpf, String nome, String email, Date dataNascimento) {
        super(id, nome, email);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    

    @Override
    public String toString() {
        return "PessoaFisica{" + "cpf=" + cpf + ", dataNascimento=" + dataNascimento + '}';
    }
    
    @Override
    public String getDados(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.getDados());
        sb.append("CPF............: ").append(cpf).append("\n");
        sb.append("Data nascimento: ").append(dataNascimento).append("\n");
        return sb.toString();
    }    
    
    @Override
    public String getDados(String obs) {
        StringBuilder sb = new StringBuilder();
        sb.append(getDados()).append("\n").append(obs);
        return sb.toString();
    }
}
