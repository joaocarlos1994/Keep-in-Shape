package br.com.keepinshape.api.service;

import java.util.List;

import br.com.keepinshape.api.entity.Alimento;

/**
 * Created by Joao on 17/08/2015.
 */
public interface AlimentoDAO {

    public Alimento save(Alimento alimento);
    public Alimento findById (int id);
    public Alimento update (Alimento alimento);
    public boolean remove (Alimento alimento);
    public List<Alimento> findAll();


}

