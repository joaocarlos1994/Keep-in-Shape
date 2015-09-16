package br.com.keepinshape.core.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.api.service.TreinoDAO;

/**
 * Created by Joao on 18/08/2015.
 */
public class TreinoDaoImpl extends BaseDaoImpl <Treino, Integer> implements TreinoDAO {

    public TreinoDaoImpl(ConnectionSource cs) throws SQLException {

        super(Treino.class);
        setConnectionSource(cs);
        initialize();
    }

    /**

    @Override
    public Treino save(Treino treino) {
        return null;
    }

    @Override
    public Treino findById(int id) {
        return null;
    }

    @Override
    public Treino update(Treino treino) {
        return null;
    }

    @Override
    public boolean remove(Treino treino) {
        return false;
    }

    @Override
    public List<Treino> findAll() {
        return null;
    }

    **/
}
