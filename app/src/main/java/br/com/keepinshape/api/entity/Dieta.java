package br.com.keepinshape.api.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Joao on 17/08/2015.
 */
public class Dieta {

    private static final String COLUMN_TABLE = "DIETA";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NOME = "NOME";
    private static final String COLUMN_DIA_SEMANA = "DIA_SEMANA";
    private static final String COLUMN_ALIMENTOS = "ALIMENTOS";

    private long _id;
    private String nome;
    private Date diaSemana;
    private List<Alimento> listaAlimento;

    public Dieta() {}

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

    public Date getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Date diaSemana) {
        this.diaSemana = diaSemana;
    }

    public List<Alimento> getListaAlimento() {
        return listaAlimento;
    }

    public void setListaAlimento(List<Alimento> listaAlimento) {
        this.listaAlimento = listaAlimento;
    }
}
