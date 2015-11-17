package br.com.keepinshape.core.helper.facade;

import android.content.Context;

import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.core.facade.ExercicioFacade;

/**
 * Created by root on 17/11/15.
 */
public class ExercicioFacadeFactory {

    private static ExercicioFacade exercicioFacade = null;

    public static  ExercicioFacade getExercicioFacadeFactory (){

        if(exercicioFacade == null){
            exercicioFacade = new ExercicioFacade();
            return  exercicioFacade;
        }
    return exercicioFacade;

    }


}
