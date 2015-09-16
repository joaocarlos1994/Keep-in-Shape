package br.com.keepinshape.api.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Joao on 17/08/2015.
 */

@DatabaseTable(tableName = "Alimento")
public class Alimento {

    private static final String COLUMN_TABLE = "ALIMENTO";
    private static final String COLUMN_ID = "_ID";
    private static final String COLUMN_NOME = "NOME";
    private static final String COLUMN_CALORIA = "CALORIA";
    private static final String COLUMN_QUANTIDADE = "QUATIDADE";

    @DatabaseField(generatedId = true)
    private Integer _id;
    @DatabaseField
    private String nome;
    @DatabaseField
    private double caloria;
    @DatabaseField
    private double quantidade;

    public Alimento(){}

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
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
