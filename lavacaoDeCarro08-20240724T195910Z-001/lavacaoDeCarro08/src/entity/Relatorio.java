
package entity;

public class Relatorio {
    /**
     * O método imprimir implementa um exemplo de associação por dependência.
     * Neste tipo de associação, não há a declaração de atributos.
     * A relação de dependência está na passagem de parâmetro do cliente.
     * @param cliente
     * @return 
     */
    public static String imprimir(Cliente cliente) {
        StringBuilder sb = new StringBuilder();
        sb.append("Imprimindo os dados do cliente").append("\n");
        // Corrigindo a chamada de método e adicionando a quebra de linha
        sb.append(cliente.getDados()).append("\n");
        return sb.toString();
    }
}

    
    
/** Conceito de Static static é sublinhado**
 * 
 * O conceito de `static` em Java está relacionado a membros 
 * (métodos ou variáveis) que pertencem à classe em si, em vez 
 * de pertencerem a instâncias específicas da classe. Aqui 
 * estão os principais pontos a serem considerados:

1. **Variáveis Estáticas (Static Variables)**: Quando uma 
* variável é declarada como `static`, apenas uma cópia dessa 
* variável é criada e compartilhada por todas as instâncias 
* (objetos) da classe. Isso significa que, se o valor de uma 
* variável estática for alterado em uma instância, a mudança 
* será refletida em todas as outras instâncias da classe. 
* Variáveis estáticas são frequentemente usadas para 
* representar informações que são comuns a todas as instâncias 
* da classe, como contadores ou constantes.

2. **Métodos Estáticos (Static Methods)**: Da mesma forma, 
* métodos estáticos pertencem à classe em si e não a instâncias 
* individuais da classe. Eles podem ser chamados diretamente
* usando o nome da classe, sem a necessidade de criar uma 
* instância da classe. Métodos estáticos são úteis para 
* definir utilitários que não dependem do estado de instância 
* da classe e, portanto, podem ser usados ​​em vários contextos 
* sem a necessidade de criar objetos.

3. **Contexto Estático**: Em um método estático, você não 
* pode acessar diretamente membros não estáticos (membros de
* instância) da classe. Isso ocorre porque os métodos 
* estáticos são executados no contexto da classe, sem uma 
* instância específica associada a eles. No entanto, eles 
* podem acessar outros membros estáticos da classe diretamente.

4. **Inicializadores Estáticos (Static Initializers)**: Os 
* blocos de inicialização estática são usados para inicializar 
* variáveis estáticas e são executados apenas uma vez, quando
* a classe é carregada pela primeira vez na memória.

Em resumo, `static` em Java é usado para membros que 
* pertencem à classe em vez de pertencerem a instâncias 
* individuais da classe, permitindo o compartilhamento de 
* dados ou funcionalidades comuns entre todas as instâncias
* da classe.
 */

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    
//    //construct
//    public Relatorio(String imprimirCliente) {
//        this.imprimirCliente = imprimirCliente;
//    }
//
//    //metodos
//    public String getImprimirCliente() {
//        return imprimirCliente;
//    }
//
//    @Override
//    public String toString() {
//        return "Relatorio{" + "imprimirCliente=" + imprimirCliente + '}';
//    }
//    
    
    
    



/*
   ===== DOCUMENTAÇÃO =====



Uma associação com linha pontilhada e uma seta em um 
diagrama de classes indica uma relação unidirecional 
entre duas classes. Essa relação significa que uma 
classe está associada à outra, mas a associação é 
unidirecional, o que significa que ela ocorre em 
apenas uma direção.

O conceito por trás dessa associação é que uma classe
tem conhecimento ou depende da outra classe, mas não 
o contrário. Essa relação é útil quando uma classe 
precisa usar ou interagir com os objetos de outra 
classe, mas não é necessária uma dependência 
recíproca.

Um exemplo disso seria uma classe `Pedido` que está 
associada à classe `Cliente` com uma linha pontilhada 
e uma seta. Isso significa que um pedido está 
associado a um cliente, mas um cliente não está 
necessariamente associado diretamente a um pedido. 
Isso pode ser interpretado como um pedido sendo feito
por um cliente, mas um cliente não precisa conhecer
ou fazer referência a todos os pedidos que ele fez.

Em código, isso pode ser representado assim:

```java
public class Pedido {
    private Cliente cliente; // Associação 
unidirecional com a classe Cliente
    // Outros atributos e métodos...
}

public class Cliente {
    // Atributos e métodos do cliente...
}
```Uma associação com linha pontilhada e uma seta em um diagrama de classes indica uma relação unidirecional entre duas classes. Essa relação significa que uma classe está associada à outra, mas a associação é unidirecional, o que significa que ela ocorre em apenas uma direção.

O conceito por trás dessa associação é que uma classe tem conhecimento ou depende da outra classe, mas não o contrário. Essa relação é útil quando uma classe precisa usar ou interagir com os objetos de outra classe, mas não é necessária uma dependência recíproca.

Um exemplo disso seria uma classe `Pedido` que está associada à classe `Cliente` com uma linha pontilhada e uma seta. Isso significa que um pedido está associado a um cliente, mas um cliente não está necessariamente associado diretamente a um pedido. Isso pode ser interpretado como um pedido sendo feito por um cliente, mas um cliente não precisa conhecer ou fazer referência a todos os pedidos que ele fez.

Em código, isso pode ser representado assim:

```java
public class Pedido {
    private Cliente cliente; // Associação unidirecional com a classe Cliente
    // Outros atributos e métodos...
}

public class Cliente {
    // Atributos e métodos do cliente...
}
```

Neste exemplo, a classe `Pedido` tem uma referência para a classe `Cliente`, mas a classe `Cliente` não tem uma referência direta para a classe `Pedido`. Isso significa que a classe `Pedido` pode acessar informações do cliente associado a ele, mas a classe `Cliente` não tem uma referência direta para todos os pedidos que ele fez.

Neste exemplo, a classe `Pedido` tem uma referência para a classe `Cliente`, mas a classe `Cliente` não tem uma referência direta para a classe `Pedido`. Isso significa que a classe `Pedido` pode acessar informações do cliente associado a ele, mas a classe `Cliente` não tem uma referência direta para todos os pedidos que ele fez.
*/
