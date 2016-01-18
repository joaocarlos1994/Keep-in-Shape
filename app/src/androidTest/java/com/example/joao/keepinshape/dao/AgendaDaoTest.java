package com.example.joao.keepinshape.dao;

import android.test.AndroidTestCase;

import com.example.joao.keepinshape.commons.ConfigDBTestCase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.api.entity.Agenda;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.core.helper.ExercicioFactory;
import br.com.keepinshape.core.helper.facade.ExercicioFacadeFactory;

/**
 * Created by root on 18/01/16.
 */
public class AgendaDaoTest extends ConfigDBTestCase {

    @Before
    public void config(){

    }

    @Test
    public void saveAgendaTest(){

        config();

    }

    @Test
    public void findAllTest() {

        config();

    }

    @Test
    public void removeAgendaTest() {

    }

    @Test
    public void updateAgendaTest() {}


    private static void assertAgenda(Agenda expected, Agenda actual) {
        Assert.assertEquals(expected.getPessoa(), actual.getPessoa());

    }

    private static void assertExercicios(List<Agenda> expected, List<Agenda> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertAgenda(expected.get(i), actual.get(i));
        }
    }

}
