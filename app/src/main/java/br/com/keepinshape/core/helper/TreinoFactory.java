package br.com.keepinshape.core.helper;

import android.content.Context;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.core.impl.TreinoDaoImpl;

/**
 * Created by Joao on 18/08/2015.
 */
public class TreinoFactory {

    private static TreinoDaoImpl treinoDaoImpl = null;

    public static TreinoDaoImpl getInstanceTreinoDaoImpl(Context context) throws SQLException {
        if(treinoDaoImpl == null){
            treinoDaoImpl = new TreinoDaoImpl(DatabaseHelperFactory.getIntanceConnection(context).getConnectionSource());
        }
        return treinoDaoImpl;
    }

    public Treino treinoFactory(String nome, String tipo, String diaSemana,
                                Collection<Exercicio> listaExercicios, double pontosTotal, double pontosMaximo){

        Treino treino = new Treino();
        treino.setNome(nome);
        treino.setTipo(tipo);
        treino.setDiaSemana(diaSemana);
        treino.setListaExercicios(listaExercicios);
        treino.setPontosTotal(pontosTotal);
        treino.setPontosMaximo(pontosMaximo);

        return treino;

    }

}
