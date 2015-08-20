package br.com.keepinshape.api.entity;

/**
 * Created by Joao on 17/08/2015.
 */
public class Exercicio {

    private static final String COLUMN_TABLE = "EXERCICIO";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NOME = "NOME";
    private static final String COLUMN_TEMPO = "TEMPO";
    private static final String COLUMN_PESO = "PESO";
    private static final String COLUMN_QUANTIDADE = "QUANTIDADE";
    private static final String COLUMN_PONTUACAO = "PONTUACAO";

    private long _id;
    private String nome;
    private int tempo;
    private float peso;
    private int quantidade;
    private double pontuacao;

    public Exercicio(){}

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
}
