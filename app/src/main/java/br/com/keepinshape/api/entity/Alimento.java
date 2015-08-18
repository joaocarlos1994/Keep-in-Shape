package br.com.keepinshape.api.entity;

/**
 * Created by Joao on 17/08/2015.
 */
public class Alimento {

    private String nome;
    private double valorCalorico;
    private double quantidae;

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
        return quantidae;
    }

    public void setQuantidae(double quantidae) {
        this.quantidae = quantidae;
    }
}
