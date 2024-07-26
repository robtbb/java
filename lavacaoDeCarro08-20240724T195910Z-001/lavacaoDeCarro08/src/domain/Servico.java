/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Servico {
    private int id;
    private String descricao;
    private double valor;
    private int pontos;

    private List<OredemServico> servico = new ArrayList<>();
    
    public Servico(){
        
    }
    
    public Servico(int id, String descricao, double valor, int pontos, OrdemServico ordemDeServico) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.pontos = pontos;
        this.ordemDeServico = ordemDeServico;
    }

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public OrdemServico getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(OrdemServico ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }

    
    //metodos da lista
    public List<OredemServico> getServico() {
        return servico;
    }

    public void setServico(List<OredemServico> servico) {
        this.servico = servico;
    }
    
    
    
}
