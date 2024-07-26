/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author rbb
 */
public enum ETipoCombustivel {
    GASOLINA("Gasolina"),
    ETANOL("Etanol"),
    FLEX("Flex"),
    DIESEL("Diesel"),
    GNV("GNV"),
    OUTRO("Outro");

    private String nome;

    ETipoCombustivel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
