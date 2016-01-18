package com.example.joao.keepinshape.dao;

import android.test.AndroidTestCase;

import com.example.joao.keepinshape.commons.ConfigDBTestCase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import br.com.keepinshape.api.entity.Agenda;
import br.com.keepinshape.api.entity.Alimento;

/**
 * Created by root on 18/01/16.
 */
public class AlimentoDaoTest extends ConfigDBTestCase {

    @Before
    public void config(){

    }

    @Test
    public void saveAlimentoTest(){

        config();

    }

    @Test
    public void findAllTest() {

        config();

    }

    @Test
    public void removeAlimentoTest() {

    }

    @Test
    public void updateAlimentoTest() {}


    private static void assertAlimento(Alimento expected, Alimento actual) {
        Assert.assertEquals(expected.getNome(), actual.getNome());

    }

    private static void assertExercicios(List<Alimento> expected, List<Alimento> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertAlimento(expected.get(i), actual.get(i));
        }
    }


}
