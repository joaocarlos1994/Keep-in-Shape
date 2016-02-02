package br.com.keepinshape.core.facade;

import android.content.Context;

import com.j256.ormlite.dao.GenericRawResults;

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

            treinoDaoImpl = TreinoFactory.getInstanceTreinoDaoImpl(context);
            treino = treinoDaoImpl.queryForId(id);



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return treino;
    }

    @Override
    public Treino update(Treino treino, Context context) {

        try {

            treinoDaoImpl = TreinoFactory.getInstanceTreinoDaoImpl(context);
            treinoDaoImpl.update(treino);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treino;
    }

    @Override
    public boolean remove(Treino treino, Context context) {

        try {
            treinoDaoImpl = TreinoFactory.getInstanceTreinoDaoImpl(context);
            treinoDaoImpl.delete(treino);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;

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

    @Override
    public List<Treino> customizedQueryTreino(String query, Context context) {

        List<Treino> treinos = new ArrayList<Treino>();

        try {

            TreinoDaoImpl dao = TreinoFactory.getInstanceTreinoDaoImpl(context);

            GenericRawResults<Treino> rawResults = dao.queryRaw(query, dao.getRawRowMapper());

            for(Treino treino : rawResults){

                treinos.add(treino);

            }

            rawResults.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return treinos;

    }
}
