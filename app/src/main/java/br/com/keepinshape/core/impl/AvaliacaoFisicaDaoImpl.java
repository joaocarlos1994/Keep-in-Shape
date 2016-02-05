package br.com.keepinshape.core.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import br.com.keepinshape.api.entity.AvaliacaoFisica;

/**
 * Created by root on 05/02/16.
 */
public class AvaliacaoFisicaDaoImpl extends BaseDaoImpl<AvaliacaoFisica, Integer> {

    public AvaliacaoFisicaDaoImpl (ConnectionSource cs) throws SQLException {

        super(AvaliacaoFisica.class);
        setConnectionSource(cs);
        initialize();

    }


}
