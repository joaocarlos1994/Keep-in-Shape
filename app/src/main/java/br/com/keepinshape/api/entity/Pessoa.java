package br.com.keepinshape.api.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

/**
 * Created by Joao on 17/08/2015.
 */

@DatabaseTable(tableName = "Pessoa")
public class Pessoa {

    private static final String COLUMN_TABLE = "PESSOA";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NOME = "NOME";
    private static final String COLUMN_TREINOS = "TREINOS";
    private static final String COLUMN_PESO = "PESO";
    private static final String COLUMN_ALTURA = "ALTURA";
    private static final String COLUMN_IDADE = "IDADE";
    private static final String COLUMN_AGENDAS = "AGENDAS";

    @DatabaseField(generatedId = true)
    private Integer _id;

    @DatabaseField
    private String nome;

    @ForeignCollectionField
    private Collection<Treino> listaTreino;

    @DatabaseField
    private double peso;

    @DatabaseField
    private double altura;

    @DatabaseField
    private int idade;

    @ForeignCollectionField
    private Collection<Agenda> listaAgenda;

    public Pessoa(){}

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

    public Collection<Agenda> getListaAgenda() {
        return listaAgenda;
    }

    public void setListaAgenda(Collection<Agenda> listaAgenda) {
        this.listaAgenda = listaAgenda;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Collection<Treino> getListaTreino() {
        return listaTreino;
    }

    public void setListaTreino(Collection<Treino> listaTreino) {
        this.listaTreino = listaTreino;
    }
}
