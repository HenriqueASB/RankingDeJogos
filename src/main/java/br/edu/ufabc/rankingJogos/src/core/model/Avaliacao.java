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
public class Avaliacao {
    private int user_id;
    private int jogo_id;
    private float nota;

    public Avaliacao() {
        super();
    }

    public Avaliacao(int id, int user_id, int jogo_id, float nota) {
        this.user_id = user_id;
        this.jogo_id = jogo_id;
        this.nota = nota;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getJogo_id() {
        return jogo_id;
    }

    public void setJogo_id(int jogo_id) {
        this.jogo_id = jogo_id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
}
