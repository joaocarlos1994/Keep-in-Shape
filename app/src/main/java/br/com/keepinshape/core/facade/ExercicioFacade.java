package br.com.keepinshape.core.facade;

import android.content.Context;
import android.util.Log;

import java.sql.SQLException;
import java.util.List;

import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.api.service.ExercicioDAO;
import br.com.keepinshape.core.helper.ExercicioFactory;
import br.com.keepinshape.core.impl.ExercicioDaoImpl;

/**
 * Created by root on 17/11/15.
 */
public class ExercicioFacade implements ExercicioDAO{

    private ExercicioDaoImpl exercicioDaoImpl;

    @Override
    public boolean save(Exercicio exercicio, Context context){

        try {

            exercicioDaoImpl = ExercicioFactory.getInstanceExercicioDaoImpl(context);
            exercicioDaoImpl.create(exercicio);

            return  true;


        } catch (SQLException e) {

            Log.d("Erro: , Tipo: ", "Falha ao adicionar Exercicio");
            e.printStackTrace();

        }

        return false;

    }


    @Override
    public Exercicio findById(int id, Context context) {
        return null;
    }

    @Override
    public Exercicio update(Exercicio exercicio) {
        return null;
    }

    @Override
    public boolean remove(Exercicio exercicio) {
        return false;
    }

    @Override
    public List<Exercicio> findAll(Context context) {

        List<Exercicio> exercicios = null;

        try {
            ExercicioDaoImpl exercicioDaoIml = ExercicioFactory.getInstanceExercicioDaoImpl(context);
            exercicios = exercicioDaoIml.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  exercicios;

    }
}
