
package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdemDeServico {
    private long numero;
    private double total;
    private Date agenda;
    private double desconto;
    private Veiculo veiculo;
    
    private List<ItemOs> itensOS;
    
    public OrdemDeServico(long numero, Date agenda, Veiculo veiculo) {
        this.itensOS = new ArrayList<>();
        this.numero = numero;
        this.veiculo = veiculo;
        this.agenda = new Date();
        this.total = 0.0;
    }

    public OrdemDeServico(long numero, Date agenda, double desconto) {
        this.numero = numero;
        this.agenda = agenda;
        this.desconto = desconto;
        this.itensOS = new ArrayList<>();
        this.total = 0.0;
    }

    public double calcularServico() {
        double totalServicos = 0.0;
        for (ItemOs item : itensOS) {
            totalServicos += item.getValorServico();
        }
        return totalServicos - desconto;
    }

    public void add(ItemOs itemOS) {
        itensOS.add(itemOS);
        this.total = calcularServico();
    }

    public void remover(ItemOs itemOS) {
        itensOS.remove(itemOS);
        this.total = calcularServico();
    }

    // Getters e Setters
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

    public List<ItemOs> getItensOS() {
        return itensOS;
    }

    public void setItensOS(List<ItemOs> itensOS) {
        this.itensOS = itensOS;
    }

    @Override
    public String toString() {
        return "OrdemDeServico{numero=" + numero + ", total=" + total + ", agenda=" + agenda + ", desconto=" + desconto + ", itensOS=" + itensOS + "}";
    }
}