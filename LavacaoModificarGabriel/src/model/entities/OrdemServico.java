package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entities.enuns.EStatus;

public class OrdemServico {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Long numero;
	private Double total;
	private Date agenda;
	private Double desconto;

	private Veiculo veiculo;

	private EStatus status;

	private List<ItemOS> itens = new ArrayList<ItemOS>();

	public OrdemServico() {
		super();
	}

	public OrdemServico(Long numero, Double total, Date agenda, Double desconto, Veiculo veiculo, EStatus status) {
		super();
		this.numero = numero;
		this.total = total;
		this.agenda = agenda;
		this.desconto = desconto;
		this.veiculo = veiculo;
		this.status = status;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Double getTotal() {
		return calculaServico();
	}

	public Date getAgenda() {
		return agenda;
	}

	public void setAgenda(Date agenda) {
		this.agenda = agenda;
	}

	public Double getDesconto() {
		for (ItemOS item : itens) {
			desconto += item.getDescontoNoServico();
		}
		return desconto;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	public List<ItemOS> getItens() {
		return itens;
	}

	public void addItens(ItemOS item) {
		itens.add(item);
	}

	public void removeItens(ItemOS item) {
		itens.remove(item);
	}

	public Double calculaServico() {
		for (ItemOS item : itens) {
			total += item.getValorServico();
		}
		return total;
	}
	
	public String totalServicoComDescontos() {
		return String.format("%.2f",total - desconto);
	}

	public String apresentarItens() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\t####\t ITENS \t#### \n\n");
		for (ItemOS item : itens) {
			sb.append(item.getServico().toString()).append("\n");
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\t####\t     ORDEM DE SERVIÇO    \t#### \n\n");
		sb.append("Compom : <[ ").append(numero).append(" ]>  ").append("Data: ").append(sdf.format(agenda)).append("\n\n");
		sb.append("Veiculo: ").append(veiculo).append("\n");
		sb.append(apresentarItens()).append("\n");
		sb.append("Desconto: ").append(String.format("%.2f",getDesconto())).append("\n");
		sb.append("Total: ").append(totalServicoComDescontos()).append("\n");
		sb.append("\t\t\tStatus : <[ ").append(status).append(" ]> \t").append("\n");

		return sb.toString();
	}

}
