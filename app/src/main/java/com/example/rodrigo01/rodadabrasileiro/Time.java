package com.example.rodrigo01.rodadabrasileiro;

/**
 * Created by rodrigo01 on 24/10/2017.
 */

public class Time implements Comparable<Time> {
    private String nome, abrev, escudo;
    private int id, posicao;

    public Time (int id, String nome, String abrev, int posicao, String escudo){
        this.abrev = abrev;
        this.escudo = escudo;
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Time arg0) {
        if (this.posicao < arg0.getPosicao()) return -1;
        else if (this.posicao > arg0.getPosicao()) return 1;
        else return 0;
    }
}
