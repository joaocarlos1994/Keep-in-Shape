package br.com.keepinshape.core.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import br.com.keepinshape.api.entity.Agenda;
import br.com.keepinshape.api.service.AgendaDAO;

/**
 * Created by Joao on 18/08/2015.
 */
public class AgendaDaoImpl extends BaseDaoImpl<Agenda, Integer> implements AgendaDAO {

    public AgendaDaoImpl(ConnectionSource cs) throws SQLException {
        super(Agenda.class);
        setConnectionSource(cs);
        initialize();
    }

    /*
    @Override
    public Agenda save(Agenda agenda) {
        return null;
    }

    @Override
    public Agenda findById(int id) {
        return null;
    }

    @Override
    public Agenda update(Agenda agenda) {
        return null;
    }

    @Override
    public boolean remove(Agenda agenda) {
        return false;
    }

    @Override
    public List<Agenda> findAll() {
        return null;
    }
    */
}
