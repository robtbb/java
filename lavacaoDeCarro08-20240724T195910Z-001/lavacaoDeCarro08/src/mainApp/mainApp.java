package mainApp;

import domain.*; // Importa todas as classes do pacote domain
import entity.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List; 

public class mainApp {

    public static void main(String[] args) throws ParseException { 
       
    Cor c1 = new Cor("Azul");
    Marca marca1 = new Marca( "Volkswagen");
    Modelo modelo1 = new Modelo("gol",marca1,ECategoria.PADRAO);
    Veiculo v1 = new Veiculo("ABC123", modelo1, "Em espera");
    
    Veiculo v2 = new Veiculo("asdf21", modelo1, "retirada");
    
    //Adcionando ao array
    
    Calendar calendar = Calendar.getInstance();

    // Configurando a data de nascimento desejada
    calendar.set(Calendar.YEAR, 2001); // Ano
    calendar.set(Calendar.MONTH, Calendar.JANUARY); // Mês (Janeiro é representado pelo valor 0)
    calendar.set(Calendar.DAY_OF_MONTH, 6); // Dia do mês

    // Obtendo a data de nascimento como um objeto Date
    Date dataNascimento = calendar.getTime();

        
    // Criando um cliente polimorfismo
    Cliente Pfisica1 = new PessoaFisica(0, "juninho", "juninho@hotmail", "89435984", dataNascimento);
    Pfisica1.addVeiculo(v1);
    Pfisica1.addVeiculo(v2);
    
    //mostando infoormações  com obs
    System.out.println(Pfisica1.getDados("Cliente com veículo associado."));
    
    
    //imprimindo informações sem obs
    System.out.println("\n\n");
    System.out.println(Pfisica1.getDados());

    print(Pfisica1);
    }
    
    
    //usando a classe relatorio para imprimir um objeto 
    public static void print(Cliente cliente){
        System.out.println(Relatorio.imprimir(cliente));
    }
    
    public static void print(Cliente cliente, String msg){
        System.out.println(cliente.getDados(msg));
    }
    
    
}
