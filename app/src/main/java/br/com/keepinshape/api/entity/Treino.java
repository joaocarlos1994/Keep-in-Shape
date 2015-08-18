package br.com.keepinshape.api.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Joao on 17/08/2015.
 */
public class Treino {

    private String nome;
    private String tipo;
    private Date diaSemana;
    private List<Exercicio> listaExercicios;
    private double pontosTotal;
    private double pontosMaximo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Date diaSemana) {
        this.diaSemana = diaSemana;
    }

    public List<Exercicio> getListaExercicios() {
        return listaExercicios;
    }

    public void setListaExercicios(List<Exercicio> listaExercicios) {
        this.listaExercicios = listaExercicios;
    }

    public double getPontosTotal() {
        return pontosTotal;
    }

    public void setPontosTotal(double pontosTotal) {
        this.pontosTotal = pontosTotal;
    }

    public double getPontosMaximo() {
        return pontosMaximo;
    }

    public void setPontosMaximo(double pontosMaximo) {
        this.pontosMaximo = pontosMaximo;
    }
}
