package mainapp;

import domain.*;
import entity.*;
import exceptions.ExceptionLavacao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainApp {

    public static void main(String[] args) {
        Cor azul = new Cor(0, "Azul");
        Marca volkswagen = new Marca(0, "Volkswagen");
        Modelo gol = new Modelo(0, "Gol", volkswagen);

        Veiculo veiculo1 = new Veiculo(0, "ABC123");
        Veiculo veiculo2 = new Veiculo(0, "VDF123");

        gol.adicionarVeiculo(veiculo1);
        gol.adicionarVeiculo(veiculo2);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date data1 = sdf.parse("2024-05-01");
            Date data2 = sdf.parse("2024-05-02");

            OrdemDeServico ordem1 = new OrdemDeServico(1, data1, 0); // Adicionando o desconto como terceiro argumento
            OrdemDeServico ordem2 = new OrdemDeServico(2, data2, 0); // Adicionando o desconto como terceiro argumento

            System.out.println(ordem1);
            System.out.println(ordem2);
        } catch (ParseException e) {
            System.err.println("Erro ao converter data: " + e.getMessage());
        }

        Date dataNascimento = new Date(101, 0, 6); // Usar o ano de 1901 para 2001

        Cliente pessoaFisica = new PessoaFisica(0, "4243", "Robert", "@melhor", dataNascimento);
        pessoaFisica.addVeiculo(veiculo1);
        pessoaFisica.addVeiculo(veiculo2);

        pessoaFisica.adicionarPontos(20);
        System.out.println("Saldo: " + pessoaFisica.consultarSaldo());

        pessoaFisica.subtrairPontos(10);
        System.out.println("Saldo: " + pessoaFisica.consultarSaldo());

        pessoaFisica.subtrairPontos(100);
        System.out.println("Saldo: " + pessoaFisica.consultarSaldo());

        System.out.println(pessoaFisica.getDados("Cliente com veículo associado."));

        System.out.println("\n\n");
        System.out.println(pessoaFisica.getDados());

        System.out.println("\n\n\n\n");

        // Criando os objetos necessários
        Modelo modelo1 = new Modelo(1, "Modelo A", new Marca(1, "Marca A"), ECategoria.MEDIO);
        Veiculo veiculo = new Veiculo(1, "ABC-1234");
        Servico servico = new Servico(1, "Troca de óleo", 0.10, ECategoria.MEDIO);
        OrdemDeServico ordemDeServico = new OrdemDeServico(1, new Date(), veiculo);

        // Criando um ItemOs
        ItemOs itemOs = new ItemOs("Observações", servico, ordemDeServico);

        // Exibindo o valor do serviço definido automaticamente
        System.out.println("Valor do serviço (automático): " + itemOs.getValorServico());

        // Modificando o valor do serviço
        itemOs.setValorServico(140.0);

        // Exibindo o valor do serviço após modificação
        System.out.println("Valor do serviço (modificado): " + itemOs.getValorServico());

        // Bloco try-catch para a exceção personalizada
        try {
            int x = 10;
            int y = 2;
            int r = x + y;

            if (r == 10) {
                throw new ExceptionLavacao("X não é igual a 10");
            }

            // Continuar com o código normalmente
            System.out.println("O valor de r é: " + r);

        } catch (ExceptionLavacao e) {
            // Manipule a exceção personalizada aqui
            System.out.println("Exceção capturada: " + e.getMessage());
        }
    }
}
