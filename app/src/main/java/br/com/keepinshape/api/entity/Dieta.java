package br.com.keepinshape.api.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Joao on 17/08/2015.
 */
public class Dieta {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
    private String nome;
    private Date diaSemana;
    private List<Alimento> listaAlimento;

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
