package com.example.joao.keepinshape.dao;

import android.test.AndroidTestCase;

import com.example.joao.keepinshape.commons.ConfigDBTestCase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import br.com.keepinshape.api.entity.Alimento;
import br.com.keepinshape.api.entity.Dieta;

/**
 * Created by root on 18/01/16.
 */
public class DietaDaoTest extends ConfigDBTestCase {

    @Before
    public void config(){

    }

    @Test
    public void saveDietaTest(){

        config();

    }

    @Test
    public void findAllTest() {

        config();

    }

    @Test
    public void removeDietaTest() {

    }

    @Test
    public void updateDietaTest() {}


    private static void assertDieta(Dieta expected, Dieta actual) {
        Assert.assertEquals(expected.getNome(), actual.getNome());

    }

    private static void assertDietas(List<Dieta> expected, List<Dieta> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertDieta(expected.get(i), actual.get(i));
        }
    }

}
