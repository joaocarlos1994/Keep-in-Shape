package com.example.joao.keepinshape.dao;

import android.test.AndroidTestCase;

import com.example.joao.keepinshape.commons.ConfigDBTestCase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.core.helper.ExercicioFactory;
import br.com.keepinshape.core.helper.facade.ExercicioFacadeFactory;

/**
 * Created by root on 18/01/16.
 */
public class ExercicioDaoTest extends ConfigDBTestCase {

    private Exercicio exercicio1, exercicio2, exercicio3;
    private List<Exercicio> listaExercicios;



    @Before
    public void config(){

        exercicio1 = ExercicioFactory.exercicioFactory("Supino A", 100, 10, 1, 1000);
        exercicio2 = ExercicioFactory.exercicioFactory("Supino B", 200, 20, 2, 2000);
        exercicio3 = ExercicioFactory.exercicioFactory("Supino C", 300, 30, 3, 3000);

        listaExercicios = new ArrayList<Exercicio>();
        listaExercicios.add(exercicio1);
        listaExercicios.add(exercicio2);
        listaExercicios.add(exercicio3);


    }

    @Test
    public void saveExercicioTest(){

        config();

        boolean exercicioToSave = ExercicioFacadeFactory.getExercicioFacadeFactory().save(exercicio1, getContext());
        Exercicio savedExercicio = ExercicioFacadeFactory.getExercicioFacadeFactory().findById(1, getContext());

        assertEquals(true, exercicioToSave);
        assertExercicio(exercicio1, savedExercicio);


    }

    @Test
    public void findAllTest() {

        config();


        for (Exercicio exercicio : listaExercicios){
            ExercicioFacadeFactory.getExercicioFacadeFactory().save(exercicio, getContext());
        }

        List<Exercicio> exercicios = ExercicioFacadeFactory.getExercicioFacadeFactory().findAll(getContext());

        assertExercicios(listaExercicios, exercicios);

    }

    @Test
    public void removeExercicioTest() {

        config();
        boolean savedExercicio = ExercicioFacadeFactory.getExercicioFacadeFactory().save(exercicio1, getContext());
        Exercicio exercicioToSave = ExercicioFacadeFactory.getExercicioFacadeFactory().findById(1, getContext());
        boolean treinoDelete = ExercicioFacadeFactory.getExercicioFacadeFactory().remove(exercicioToSave, getContext());

        assertEquals(true, savedExercicio);
        assertExercicio(exercicio1, exercicioToSave);
        assertEquals(true, treinoDelete);

    }

    @Test
    public void updateExercicioTest() {

        config();

        boolean savedExercicio = ExercicioFacadeFactory.getExercicioFacadeFactory().save(exercicio1, getContext());

        Exercicio exercicioToSave = ExercicioFacadeFactory.getExercicioFacadeFactory().findById(1, getContext());
        exercicioToSave.setNome("Supino A Update");

        ExercicioFacadeFactory.getExercicioFacadeFactory().update(exercicioToSave, getContext());

        Exercicio exercicioToUpdate = ExercicioFacadeFactory.getExercicioFacadeFactory().findById(1, getContext());

        assertEquals(true, savedExercicio);
        assertExercicio(exercicioToSave, exercicioToUpdate);

    }


    private static void assertExercicio(Exercicio expected, Exercicio actual) {
        Assert.assertEquals(expected.getNome(), actual.getNome());
        Assert.assertEquals(expected.getTempo(), actual.getTempo());
        Assert.assertEquals(expected.getPeso(), actual.getPeso());
        Assert.assertEquals(expected.getQuantidade(), actual.getQuantidade());
        Assert.assertEquals(expected.getPontuacao(), actual.getPontuacao());

    }

    private static void assertExercicios(List<Exercicio> expected, List<Exercicio> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertExercicio(expected.get(i), actual.get(i));
        }
    }


}
