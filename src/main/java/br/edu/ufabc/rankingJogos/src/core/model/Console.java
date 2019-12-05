/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.rankingJogos.src.core.model;

/**
 *
 * @author Pichau
 */
public class Console {
    
    private int id;
    private String nome ;
    private String fabricante;
    private String ano;

    public Console() {
        super();
    }

    public Console(int id, String nome, String fabricante, String ano) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    
}
