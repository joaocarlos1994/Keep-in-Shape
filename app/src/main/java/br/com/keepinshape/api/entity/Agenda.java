package br.com.keepinshape.api.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Joao on 17/08/2015.
 */
@DatabaseTable(tableName = "Agenda")
public class Agenda {

    @DatabaseField(generatedId = true)
    private Integer _id;

    @DatabaseField(foreign = true)
    private Pessoa pessoa;

    public Agenda() {
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
