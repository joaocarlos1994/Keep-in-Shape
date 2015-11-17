package br.com.keepinshape.api.service;

import android.content.Context;

import java.util.List;

import br.com.keepinshape.api.entity.Exercicio;

/**
 * Created by Joao on 17/08/2015.
 */
public interface ExercicioDAO {

    public boolean save(Exercicio exercicio, Context context);
    public Exercicio findById (int id, Context context);
    public Exercicio update (Exercicio exercicio);
    public boolean remove (Exercicio exercicio);
    public List<Exercicio> findAll(Context context);

}
