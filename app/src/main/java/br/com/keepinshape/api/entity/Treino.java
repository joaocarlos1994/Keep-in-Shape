package br.com.keepinshape.api.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Joao on 17/08/2015.
 */
public class Treino {

    private static final String TABLE = "Treino";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NOME = "NOME";
    private static final String COLUMN_TIPO = "TIPO";
    private static final String COLUMN_SEMANA = "SEMANA";
    private static final String COLUMN_EXERCICIOS = "EXERCICIOS";
    private static final String COLUMN_PONTOS_TOTAL = "PONTOS_TOTAL";
    private static final String COLUMN_PONTOS_MAXIMO = "PONTOS_MAXIMO";

    private long _id;
    private String nome;
    private String tipo;
    private Date diaSemana;
    private List<Exercicio> listaExercicios;
    private double pontosTotal;
    private double pontosMaximo;

    public Treino(){}

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

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
