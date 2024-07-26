/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class OrdemServico {
    private long numero;
    private double total;
    private Date agenda;
    private double desconto;
    private ItemOs itemOs;
    
    private List<Servico> servico = new ArrayList<>();
    
    public OrdemServico(long numero, double total, Date agenda, double desconto, ItemOs itemOs) {
        this.numero = numero;
        this.total = total;
        this.agenda = agenda;
        this.desconto = desconto;
        this.itemOs = itemOs;
    }
    
    
    //metodos da classe
    public double calcularServico(){
        return total;
    }
    
    public void servico(ItemOs itemOs){
        
    }
    
    public void remove(ItemOs itemOs){
        
    }

    //metodos get and setter
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getAgenda() {
        return agenda;
    }

    public void setAgenda(Date agenda) {
        this.agenda = agenda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public ItemOs getItemOs() {
        return itemOs;
    }

    public void setItemOs(ItemOs itemOs) {
        this.itemOs = itemOs;
    }
    
    public void add(Servico servico){
        servico.add(servico);
        servico.setServico(this);
    }
    
    public void remove(Servico servico){
        servico.remove(servico);
        servico.serServico(null);
    }
    
}
