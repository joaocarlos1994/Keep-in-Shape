package br.com.keepinshape.api.service;

import java.util.List;

import br.com.keepinshape.api.entity.Dieta;

/**
 * Created by Joao on 17/08/2015.
 */
public interface DietaDAO {

    public Dieta save(Dieta dieta);
    public Dieta findById (int id);
    public Dieta update (Dieta dieta);
    public boolean remove (Dieta dieta);
    public List<Dieta> findAll();

}
