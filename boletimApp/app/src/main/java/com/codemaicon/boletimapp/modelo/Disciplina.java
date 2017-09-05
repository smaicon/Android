package com.codemaicon.boletimapp.modelo;


import java.io.Serializable;


public class Disciplina implements Serializable {
    private String nome;
    private int cargaHoraria;

    public Disciplina() {
    }

    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return nome + " - " + cargaHoraria;
    }
}
