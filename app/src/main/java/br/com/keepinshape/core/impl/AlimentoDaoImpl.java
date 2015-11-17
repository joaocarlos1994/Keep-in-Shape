package br.com.keepinshape.core.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import br.com.keepinshape.api.entity.Alimento;
import br.com.keepinshape.api.service.AlimentoDAO;

/**
 * Created by Joao on 18/08/2015.
 */
public class AlimentoDaoImpl extends BaseDaoImpl <Alimento, Integer> {

    public AlimentoDaoImpl (ConnectionSource cs) throws SQLException {
        super(Alimento.class);
        setConnectionSource(cs);
        initialize();
    }

    /*

    @Override
    public Alimento save(Alimento alimento) {
        return null;
    }

    @Override
    public Alimento findById(int id) {
        return null;
    }

    @Override
    public Alimento update(Alimento alimento) {
        return null;
    }

    @Override
    public boolean remove(Alimento alimento) {
        return false;
    }

    @Override
    public List<Alimento> findAll() {
        return null;
    }

    */
}
