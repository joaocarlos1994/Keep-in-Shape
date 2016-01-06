package br.com.keepinshape.core.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.api.service.ExercicioDAO;

/**
 * Created by Joao on 18/08/2015.
 */
public class ExercicioDaoImpl extends BaseDaoImpl <Exercicio, Integer> {

    public ExercicioDaoImpl (ConnectionSource cs) throws SQLException {
        super(Exercicio.class);
        setConnectionSource(cs);
        initialize();
    }


}
