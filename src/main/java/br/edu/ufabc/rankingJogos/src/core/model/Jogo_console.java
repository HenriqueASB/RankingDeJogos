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
public class Jogo_console {
    
    private int jogo_id;
    private int console_id;

    public Jogo_console() {
        super();
    }

    public Jogo_console(int jogo_id, int console_id) {
        this.jogo_id = jogo_id;
        this.console_id = console_id;
    }
    
    public int getJogo_id() {
        return jogo_id;
    }

    public void setJogo_id(int jogo_id) {
        this.jogo_id = jogo_id;
    }

    public int getConsole_id() {
        return console_id;
    }

    public void setConsole_id(int console_id) {
        this.console_id = console_id;
    }
}
