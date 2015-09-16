package br.com.keepinshape.api.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Joao on 17/08/2015.
 */

@DatabaseTable(tableName="Exercicio")
public class Exercicio {

    private static final String COLUMN_TABLE = "EXERCICIO";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NOME = "NOME";
    private static final String COLUMN_TEMPO = "TEMPO";
    private static final String COLUMN_PESO = "PESO";
    private static final String COLUMN_QUANTIDADE = "QUANTIDADE";
    private static final String COLUMN_PONTUACAO = "PONTUACAO";

    @DatabaseField(generatedId = true)
    private Integer _id;

    @DatabaseField
    private String nome;

    @DatabaseField
    private int tempo;

    @DatabaseField
    private float peso;

    @DatabaseField
    private int quantidade;

    @DatabaseField
    private double pontuacao;

    @DatabaseField(foreign = true)
    private Treino treino;

    public Exercicio(){}

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

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }
}
