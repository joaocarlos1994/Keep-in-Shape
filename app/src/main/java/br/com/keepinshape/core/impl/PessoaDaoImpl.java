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

    public PessoaDaoImpl (ConnectionSource cs) throws SQLException {

        super(Pessoa.class);
        setConnectionSource(cs);
        initialize();

    }

}
