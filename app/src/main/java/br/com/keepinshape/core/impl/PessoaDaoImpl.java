package br.com.keepinshape.core.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import br.com.keepinshape.api.entity.Pessoa;
import br.com.keepinshape.api.service.PessoaDAO;

/**
 * Created by Joao on 18/08/2015.
 */
public class PessoaDaoImpl extends BaseDaoImpl<Pessoa, Integer> {

    PessoaDaoImpl (ConnectionSource cs) throws SQLException {

        super(Pessoa.class);
        setConnectionSource(cs);
        initialize();

    }

    /*

    @Override
    public Pessoa save(Pessoa pessoa) {
        return null;
    }

    @Override
    public Pessoa findById(int id) {
        return null;
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        return null;
    }

    @Override
    public boolean remove(Pessoa pessoa) {
        return false;
    }

    @Override
    public List<Pessoa> findAll() {
        return null;
    }

    */
}
