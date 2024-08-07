package br.edu.ifsc.fln.model.report;

import br.edu.ifsc.fln.model.entity.Cliente;

public class Relatorio {
    public String imprimirCliente;

    //construct
    public Relatorio(String imprimirCliente) {
        this.imprimirCliente = imprimirCliente;
    }

    /**
     * O método imprimir implementa o exemplo de uma associação por dependência.
     * @param cliente do tipo cliente
     * @return String
     */
    
    public static String ImprimirCliente(Cliente cliente) {
        StringBuilder sb = new StringBuilder();
        sb.append("imprimir dados do relatorio").append("\n");
        sb.append(cliente.getDados()).append("\n");
        return sb.toString();
    }   
}
