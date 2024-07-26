/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author rbb
 */
public enum ECategoria {

    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    GRANDE("Grande"),
    MOTO("Moto"),
    PADRAO("Padrão");

    private String nome;

    ECategoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
