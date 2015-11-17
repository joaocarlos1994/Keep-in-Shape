package br.com.keepinshape.api.service;

import android.content.Context;

import java.util.List;

import br.com.keepinshape.api.entity.Treino;

/**
 * Created by Joao on 17/08/2015.
 */
public interface TreinoDAO {

    public boolean save(Treino treino, Context context);
    public Treino findById (int id, Context context);
    //public Treino update (Treino treino);
    //public boolean remove (Treino treino);
    public List<Treino> findAll(Context context);

}
