package br.com.keepinshape.core.helper;

import android.content.Context;

import java.sql.SQLException;

import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.core.impl.ExercicioDaoImpl;

/**
 * Created by Joao on 18/08/2015.
 */
public class ExercicioFactory {

    private static ExercicioDaoImpl exercicioDaoImpl = null;

    public static ExercicioDaoImpl getInstanceExercicioDaoImpl(Context ctx) throws SQLException {

        if (exercicioDaoImpl == null){
            exercicioDaoImpl = new ExercicioDaoImpl(DatabaseHelperFactory.getIntanceConnection(ctx).getConnectionSource());
        }

        return exercicioDaoImpl;
    }

    public Exercicio exercicioFactory(String nome, int tempo, float peso, int quantidade, double pontuacao){

        Exercicio exercicio = new Exercicio();
        exercicio.setNome(nome);
        exercicio.setTempo(tempo);
        exercicio.setPeso(peso);
        exercicio.setQuantidade(quantidade);
        exercicio.setPontuacao(pontuacao);

        return exercicio;

    }



}
