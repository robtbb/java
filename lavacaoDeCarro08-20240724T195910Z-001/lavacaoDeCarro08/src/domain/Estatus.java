/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author rbb
 */
public enum Estatus {
    ABERTO("aberto"), 
    FECHADO("fechado"),
    CANCELADA("cancelada");

    private String nome;
    
    Estatus(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
}
