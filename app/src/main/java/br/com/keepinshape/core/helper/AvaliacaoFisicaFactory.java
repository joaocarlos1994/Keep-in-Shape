package br.com.keepinshape.core.helper;

import android.content.Context;

import java.sql.SQLException;
import java.util.Date;

import br.com.keepinshape.api.entity.AvaliacaoFisica;
import br.com.keepinshape.api.entity.Pessoa;
import br.com.keepinshape.core.impl.AvaliacaoFisicaDaoImpl;

/**
 * Created by root on 05/02/16.
 */
public class AvaliacaoFisicaFactory {

    private static AvaliacaoFisicaDaoImpl avaliacaoFisicaDaoImpl = null;

    public static AvaliacaoFisicaDaoImpl getInstanceAvaliacaoFisicaDaoImpl(Context context) throws SQLException {
        if(avaliacaoFisicaDaoImpl == null){
            avaliacaoFisicaDaoImpl = new AvaliacaoFisicaDaoImpl(DatabaseHelperFactory.getIntanceConnection(context).getConnectionSource());
        }
        return  avaliacaoFisicaDaoImpl;
    }

    public static AvaliacaoFisica avaliacaoFisicaFactory(Pessoa pessoa, double peso, double altura, int idade,
                                                         double cintura, double quadril, Date dateAvaliacao){

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setPessoa(pessoa);
        avaliacaoFisica.setPeso(peso);
        avaliacaoFisica.setAltura(altura);
        avaliacaoFisica.setIdade(idade);
        avaliacaoFisica.setCintura(cintura);
        avaliacaoFisica.setQuadril(quadril);
        avaliacaoFisica.setDateAvaliacao(dateAvaliacao);

        return avaliacaoFisica;
    }

}
