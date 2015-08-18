package br.com.keepinshape.api.entity;

import java.util.List;

/**
 * Created by Joao on 17/08/2015.
 */
public class Pessoa {

    private String nome;
    private List<Treino> listaExercicio;
    private double peso;
    private double altura;
    private int idade;
    private List<Agenda> listaAgenda;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Agenda> getListaAgenda() {
        return listaAgenda;
    }

    public void setListaAgenda(List<Agenda> listaAgenda) {
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

    public List<Treino> getListaExercicio() {
        return listaExercicio;
    }

    public void setListaExercicio(List<Treino> listaExercicio) {
        this.listaExercicio = listaExercicio;
    }
}
