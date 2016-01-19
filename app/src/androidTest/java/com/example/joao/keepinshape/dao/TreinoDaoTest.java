package com.example.joao.keepinshape.dao;

import android.test.AndroidTestCase;

import com.example.joao.keepinshape.commons.ConfigDBTestCase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.api.entity.Pessoa;
import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.core.helper.TreinoFactory;
import br.com.keepinshape.core.helper.facade.ExercicioFacadeFactory;
import br.com.keepinshape.core.helper.facade.TreinoFacadeFactory;

/**
 * Created by root on 18/01/16.
 */
public class TreinoDaoTest extends ConfigDBTestCase {

    private Treino treino1, treino2, treino3;
    private List<Treino> listaTreinos;

    @Before
    public void config(){

        treino1 = TreinoFactory.treinoFactory("Treino A", "Peito A", "Segunda", null, 100, 1000);
        treino2 = TreinoFactory.treinoFactory("Treino B", "Peito B", "Terça", null, 200, 2000);
        treino3 = TreinoFactory.treinoFactory("Treino C", "Peito C", "Quarta", null, 300, 3000);

        listaTreinos = new ArrayList<>();
        listaTreinos.add(treino1);
        listaTreinos.add(treino2);
        listaTreinos.add(treino2);

    }

    @Test
    public void saveTreinoTest(){

        config();
        boolean savedTreino = TreinoFacadeFactory.getInstanceTreinoFacade().save(treino1, getContext());
        Treino treinoToSave = TreinoFacadeFactory.getInstanceTreinoFacade().findById(1, getContext());

        assertEquals(true, savedTreino);
        assertTreino(treino1, treinoToSave);

    }

    @Test
    public void findAllTest() {

        config();

        for (Treino treino : listaTreinos){
            TreinoFacadeFactory.getInstanceTreinoFacade().save(treino, getContext());
        }

        List<Treino> treinos = TreinoFacadeFactory.getInstanceTreinoFacade().findAll(getContext());

        assertTreinos(listaTreinos, treinos);


    }

    @Test
    public void removeTreinoTest() {

        config();
        boolean savedTreino = TreinoFacadeFactory.getInstanceTreinoFacade().save(treino1, getContext());
        Treino treinoToSave = TreinoFacadeFactory.getInstanceTreinoFacade().findById(1, getContext());
        boolean treinoDelete = TreinoFacadeFactory.getInstanceTreinoFacade().remove(treinoToSave, getContext());

        assertEquals(true, savedTreino);
        assertTreino(treino1, treinoToSave);
        assertEquals(true, treinoDelete);

    }

    @Test
    public void updateTreinoTest() {

        config();

        boolean savedTreino = TreinoFacadeFactory.getInstanceTreinoFacade().save(treino1, getContext());

        Treino treinoToSave = TreinoFacadeFactory.getInstanceTreinoFacade().findById(1, getContext());
        treinoToSave.setNome("Treino A Update");

        Treino treinoToUpdate = TreinoFacadeFactory.getInstanceTreinoFacade().update(treinoToSave, getContext());

        assertEquals(true, savedTreino);
        assertTreino(treinoToSave, treinoToUpdate);

    }


    private static void assertTreino(Treino expected, Treino actual) {
        Assert.assertEquals(expected.getNome(), actual.getNome());
        Assert.assertEquals(expected.getTipo(), actual.getTipo());
        Assert.assertEquals(expected.getDiaSemana(), actual.getDiaSemana());
        Assert.assertEquals(expected.getPontosTotal(), actual.getPontosTotal());
        Assert.assertEquals(expected.getPontosMaximo(), actual.getPontosMaximo());

    }

    private static void assertTreinos(List<Treino> expected, List<Treino> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertTreino(expected.get(i), actual.get(i));
        }
    }

}
