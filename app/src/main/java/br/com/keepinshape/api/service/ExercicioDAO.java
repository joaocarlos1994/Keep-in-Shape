package br.com.keepinshape.api.service;

import java.util.List;

import br.com.keepinshape.api.entity.Exercicio;

/**
 * Created by Joao on 17/08/2015.
 */
public interface ExercicioDAO {

    public Exercicio save(Exercicio exercicio);
    public Exercicio findById (int id);
    public Exercicio update (Exercicio exercicio);
    public boolean remove (Exercicio exercicio);
    public List<Exercicio> findAll();

}
