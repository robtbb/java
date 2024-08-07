
package domain;

public class ItemOs {
    private double valorServico;
    private String observacoes;
    private Servico servico;
    private OrdemDeServico ordemDeServico;
    

    // Valores padrão para cada categoria
    private static final double VALOR_PEQUENO = 100.0;
    private static final double VALOR_MEDIO = 150.0;
    private static final double VALOR_GRANDE = 200.0;
    private static final double VALOR_MOTO = 80.0;
    private static final double VALOR_PADRAO = 120.0;

    public ItemOs(String observacoes, Servico servico, OrdemDeServico ordemDeServico) {
        this.observacoes = observacoes;
        this.servico = servico;
        this.ordemDeServico = ordemDeServico;
        this.valorServico = definirValorPorCategoria(); // Define o valor inicial com base na categoria do veículo
    }

    // Método para definir o valor do serviço com base na categoria do veículo
    private double definirValorPorCategoria() {
        ECategoria categoria = servico.getCategoria();
        switch (categoria) {
            case PEQUENO:
                return VALOR_PEQUENO;
            case MEDIO:
                return VALOR_MEDIO;
            case GRANDE:
                return VALOR_GRANDE;
            case MOTO:
                return VALOR_MOTO;
            case PADRAO:
                return VALOR_PADRAO;
            default:
                return VALOR_PADRAO;
        }
    }

    // Getters e Setters

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public OrdemDeServico getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }

    
    @Override
    public String toString() {
        return "ItemOs{" +
                "valorServico=" + valorServico +
                ", observacoes='" + observacoes + '\'' +
                ", servico=" + servico +
                ", ordemDeServico=" + ordemDeServico +
                '}';
    }
}