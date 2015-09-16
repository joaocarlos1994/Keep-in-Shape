package br.com.keepinshape.api.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Joao on 17/08/2015.
 */
@DatabaseTable(tableName = "Dieta")
public class Dieta {

    private static final String COLUMN_TABLE = "DIETA";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NOME = "NOME";
    private static final String COLUMN_DIA_SEMANA = "DIA_SEMANA";
    private static final String COLUMN_ALIMENTOS = "ALIMENTOS";

    @DatabaseField(generatedId = true)
    private Integer _id;

    @DatabaseField
    private String nome;
    @DatabaseField
    private Date diaSemana;
    @ForeignCollectionField
    private Collection<Alimento> listaAlimento;

    public Dieta() {}

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

    public Date getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Date diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Collection<Alimento> getListaAlimento() {
        return listaAlimento;
    }

    public void setListaAlimento(Collection<Alimento> listaAlimento) {
        this.listaAlimento = listaAlimento;
    }
}
