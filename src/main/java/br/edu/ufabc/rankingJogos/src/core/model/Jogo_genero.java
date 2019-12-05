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
public class Jogo_genero {
    
    private int jogo_id;
    private int genero_id;

    public Jogo_genero() {
        super();
    }

    public Jogo_genero(int jogo_id, int genero_id) {
        this.jogo_id = jogo_id;
        this.genero_id = genero_id;
    }

    public int getJogo_id() {
        return jogo_id;
    }

    public void setJogo_id(int jogo_id) {
        this.jogo_id = jogo_id;
    }

    public int getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(int genero_id) {
        this.genero_id = genero_id;
    }
 
}
