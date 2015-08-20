package br.com.keepinshape.api.entity;

/**
 * Created by Joao on 17/08/2015.
 */
public class Alimento {

    private static final String COLUMN_TABLE = "ALIMENTO";
    private static final String COLUMN_ID = "_ID";
    private static final String COLUMN_NOME = "NOME";
    private static final String COLUMN_CALORIA = "CALORIA";
    private static final String COLUMN_QUANTIDADE = "QUATIDADE";

    private long _id;
    private String nome;
    private double caloria;
    private double quantidade;

    public Alimento(){}

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

    public double getCaloria() {
        return caloria;
    }

    public void setCaloria(double caloria) {
        this.caloria = caloria;
    }

    public double getQuantidae() {
        return quantidade;
    }

    public void setQuantidae(double quantidae) {
        this.quantidade = quantidae;
    }
}
