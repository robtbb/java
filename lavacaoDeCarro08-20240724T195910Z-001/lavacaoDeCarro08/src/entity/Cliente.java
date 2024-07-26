
package entity;

import domain.*;
import java.util.ArrayList;
import java.util.Date;

public abstract class Cliente implements ICliente {
    // Atributos
    protected int id;
    protected String nome;
    protected String email;
    protected Date dataCadastro;
    protected ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataCadastro = new Date();
    }

    // Métodos para manipulação de veículos
    public void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removeVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    // Métodos da interface ICliente
    @Override
    public String getDados() {
        StringBuilder detalhesCliente = new StringBuilder();
        detalhesCliente.append("ID: ").append(id).append("\n");
        detalhesCliente.append("Nome: ").append(nome).append("\n");

        if (veiculos.isEmpty()) {
            detalhesCliente.append("Nenhum veículo associado.\n");
        } else {
            detalhesCliente.append("Veículos associados:\n");
            for (Veiculo veiculo : veiculos) {
                detalhesCliente.append("- Placa: ").append(veiculo.getPlaca()).append(", Observação: ").append(veiculo.getObservacao()).append("\n");
            }
        }

        return detalhesCliente.toString();
    }

    @Override
    public String getDados(String observacao) {
        return getDados() + "\nObservação: " + observacao;
    }
}



/*
Claro! O método **append()** em Java é utilizado para 
concatenar (ou adicionar) uma representação  de  um 
determinado valor   à   sequência   de   caracteres 
existente em um objeto do   tipo   `StringBuilder`.

Por exemplo, ao chamar `append("ID: ").append(id)`,
estamos adicionando a string "ID: "   seguida  pelo
valor da variável `id` à sequência   de  caracteres 
dentro do objeto `StringBuilder`.

Aqui está um exemplo simplificado:

```java
StringBuilder detalhes = new StringBuilder();
int id = 123;
String nome = "João";

// Adicionando informações ao StringBuilder
detalhes.append("ID: ").append(id).append("\n");
detalhes.append("Nome: ").append(nome);

// Convertendo o StringBuilder para uma String
String resultado = detalhes.toString();

// Output
System.out.println(resultado);
```

O resultado será:

```
ID: 123
Nome: João
```

Portanto, `append()` é utilizado para construir uma 
string  gradualmente,  adicionando  informações  ou 
valores conforme necessário. Isso  é  especialmente 
útil ao construir strings complexas ou  quando   se 
deseja evitar a criação excessiva de objetos String 
intermediários.
*/

