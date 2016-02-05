package br.com.keepinshape.api.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by root on 05/02/16.
 */

@DatabaseTable(tableName = "AvaliacaoFisica")
public class AvaliacaoFisica {

    @DatabaseField(generatedId = true)
    private Integer _id;

    @DatabaseField(foreign = true)
    private Pessoa pessoa;

    @DatabaseField
    private double peso;

    @DatabaseField
    private double altura;

    @DatabaseField
    private int idade;

    @DatabaseField
    private double cintura;

    @DatabaseField
    private double quadril;

    @DatabaseField(dataType = DataType.DATE_LONG)
    private Date dateAvaliacao;

    public AvaliacaoFisica(){}

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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public Date getDateAvaliacao() {
        return dateAvaliacao;
    }

    public void setDateAvaliacao(Date dateAvaliacao) {
        this.dateAvaliacao = dateAvaliacao;
    }

}
