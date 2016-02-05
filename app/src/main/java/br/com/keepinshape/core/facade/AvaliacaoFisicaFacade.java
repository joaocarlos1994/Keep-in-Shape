package br.com.keepinshape.core.facade;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.GenericRawResults;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.api.entity.AvaliacaoFisica;
import br.com.keepinshape.api.service.AvaliacaoFisicaDAO;
import br.com.keepinshape.core.helper.AvaliacaoFisicaFactory;
import br.com.keepinshape.core.helper.facade.AvaliacaoFisicaFacadeFactory;
import br.com.keepinshape.core.impl.AvaliacaoFisicaDaoImpl;

/**
 * Created by root on 05/02/16.
 */
public class AvaliacaoFisicaFacade implements AvaliacaoFisicaDAO{

    private AvaliacaoFisicaDaoImpl avaliacaoFisicaDaoImpl = null;

    @Override
    public boolean save(AvaliacaoFisica avaliacaoFisica, Context context) {

        try {

            avaliacaoFisicaDaoImpl = AvaliacaoFisicaFactory.getInstanceAvaliacaoFisicaDaoImpl(context);
            avaliacaoFisicaDaoImpl.create(avaliacaoFisica);
            return true;

        } catch (SQLException e) {
            Log.d("Erro: , Tipo: ", "Falha ao adicionar Avaliacao");
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public AvaliacaoFisica findById(int id, Context context) {

        AvaliacaoFisica avaliacaoFisica = null;

        try {

            avaliacaoFisicaDaoImpl = AvaliacaoFisicaFactory.getInstanceAvaliacaoFisicaDaoImpl(context);
            avaliacaoFisica = avaliacaoFisicaDaoImpl.queryForId(id);

            return avaliacaoFisica;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public AvaliacaoFisica update(AvaliacaoFisica avaliacaoFisica, Context context) {

        AvaliacaoFisica avaliacaoFisica1 = null;

        try {

            avaliacaoFisicaDaoImpl = AvaliacaoFisicaFactory.getInstanceAvaliacaoFisicaDaoImpl(context);
            avaliacaoFisicaDaoImpl.update(avaliacaoFisica);
            avaliacaoFisica1 = avaliacaoFisica;
            return  avaliacaoFisica1;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean remove(AvaliacaoFisica avaliacaoFisica, Context context) {


        try {
            avaliacaoFisicaDaoImpl = AvaliacaoFisicaFactory.getInstanceAvaliacaoFisicaDaoImpl(context);
            avaliacaoFisicaDaoImpl.delete(avaliacaoFisica);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<AvaliacaoFisica> findAll(Context context) {

        List<AvaliacaoFisica> avaliacaoFisicas = null;

        try {
            avaliacaoFisicaDaoImpl = AvaliacaoFisicaFactory.getInstanceAvaliacaoFisicaDaoImpl(context);
            avaliacaoFisicas = new ArrayList<>(avaliacaoFisicaDaoImpl.queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avaliacaoFisicas;
    }

    @Override
    public List<AvaliacaoFisica> customizedQueryAvaliacaoFisica(String query, Context context) {

        List<AvaliacaoFisica> avaliacaoFisicas = new ArrayList<AvaliacaoFisica>();

        try {

            AvaliacaoFisicaDaoImpl dao = AvaliacaoFisicaFactory.getInstanceAvaliacaoFisicaDaoImpl(context);

            GenericRawResults<AvaliacaoFisica> rawResults = dao.queryRaw(query, dao.getRawRowMapper());

            for(AvaliacaoFisica avaliacaoFisica : rawResults){

                avaliacaoFisicas.add(avaliacaoFisica);

            }

            rawResults.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avaliacaoFisicas;


    }
}
