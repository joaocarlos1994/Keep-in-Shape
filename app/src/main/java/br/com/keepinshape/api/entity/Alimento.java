package br.com.keepinshape.api.entity;

/**
 * Created by Joao on 17/08/2015.
 */
public class Alimento {

    private long id;
    private String nome;
    private double valorCalorico;
    private double quantidade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorCalorico() {
        return valorCalorico;
    }

    public void setValorCalorico(double valorCalorico) {
        this.valorCalorico = valorCalorico;
    }

    public double getQuantidae() {
        return quantidade;
    }

    public void setQuantidae(double quantidae) {
        this.quantidade = quantidae;
    }
}
