package br.com.keepinshape.core.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import br.com.keepinshape.api.entity.Dieta;
import br.com.keepinshape.api.service.DietaDAO;

/**
 * Created by Joao on 18/08/2015.
 */
public class DietaDaoImpl extends BaseDaoImpl <Dieta, Integer> {

    public DietaDaoImpl (ConnectionSource cs) throws SQLException {
        super(Dieta.class);
        setConnectionSource(cs);
        initialize();
    }

    /*

    @Override
    public Dieta save(Dieta dieta) {
        return null;
    }

    @Override
    public Dieta findById(int id) {
        return null;
    }

    @Override
    public Dieta update(Dieta dieta) {
        return null;
    }

    @Override
    public boolean remove(Dieta dieta) {
        return false;
    }

    @Override
    public List<Dieta> findAll() {
        return null;
    }

    */
}
