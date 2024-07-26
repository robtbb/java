/*
Considere um desconto na semana do 
aniversáio do voiente tipo PF
*/

package entity;

import java.util.Date;

public class PessoaFisica extends Cliente {
    private String cpf;
    private Date dataNascimento;
    
    public PessoaFisica(int id, String nome, String email, String cpf, Date dataNascimento) {
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
}
