package br.com.keepinshape.core.facade;

import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.api.service.TreinoDAO;
import br.com.keepinshape.core.helper.DatabaseHelperFactory;
import br.com.keepinshape.core.helper.TreinoFactory;
import br.com.keepinshape.core.impl.TreinoDaoImpl;

/**
 * Created by root on 17/11/15.
 */
public class TreinoFacade implements TreinoDAO {

    private TreinoDaoImpl treinoDaoImpl;

    @Override
    public boolean save(Treino treino, Context context) {

        try {

            treinoDaoImpl = TreinoFactory.getInstanceTreinoDaoImpl(context);
            treinoDaoImpl.create(treino);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public Treino findById(int id, Context context) {

        Treino treino = null;

        try {

            TreinoDaoImpl treinoDaoImpl = TreinoFactory.getInstanceTreinoDaoImpl(context);
            treino = treinoDaoImpl.queryForId(id);



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return treino;
    }

    @Override
    public List<Treino> findAll(Context context) {

        List<Treino> treinos = null;

        try {
            TreinoDaoImpl treinoDaoImpl = TreinoFactory.getInstanceTreinoDaoImpl(context);
            treinos = treinoDaoImpl.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return treinos;

    }
}
