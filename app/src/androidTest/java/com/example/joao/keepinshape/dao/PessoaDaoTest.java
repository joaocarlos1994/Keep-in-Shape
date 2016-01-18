package com.example.joao.keepinshape.dao;

import android.test.AndroidTestCase;

import com.example.joao.keepinshape.commons.ConfigDBTestCase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.keepinshape.api.entity.Dieta;
import br.com.keepinshape.api.entity.Pessoa;
import br.com.keepinshape.core.helper.PessoaFactory;
import br.com.keepinshape.core.helper.facade.PessoaFacadeFactory;

/**
 * Created by root on 18/01/16.
 */
public class PessoaDaoTest extends ConfigDBTestCase {

    private Pessoa pessoa1, pessoa2, pessoa3;
    private List<Pessoa> listaPessoas;

    @Before
    public void config(){

        pessoa1 = PessoaFactory.pessoaFactory("João", null, 75, 1.75, 22, null, 70, 100, new Date());
        pessoa2 = PessoaFactory.pessoaFactory("Vanderson", null, 70, 1.80, 20, null, 80, 110, new Date());
        pessoa1 = PessoaFactory.pessoaFactory("Pedro", null, 80, 1.65, 18, null, 70, 90, new Date());

        listaPessoas = new ArrayList<Pessoa>();
        listaPessoas.add(pessoa1);
        listaPessoas.add(pessoa2);
        listaPessoas.add(pessoa3);

    }

    @Test
    public void savePessoaTest(){

        config();

        boolean savedPessoa = PessoaFacadeFactory.getInstancePessoaFacade().save(pessoa1, getContext());
        Pessoa treinoToSave = PessoaFacadeFactory.getInstancePessoaFacade().findById(1, getContext());

        assertEquals(true, savedPessoa);
        assertPessoa(pessoa1, treinoToSave);


    }

    @Test
    public void findAllTest() {

        config();

        for (Pessoa treino : listaPessoas){
            PessoaFacadeFactory.getInstancePessoaFacade().save(treino, getContext());
        }

        List<Pessoa> pessoas = PessoaFacadeFactory.getInstancePessoaFacade().findAll(getContext());

        assertPessoas(listaPessoas, pessoas);

    }

    @Test
    public void removePessoaTest() {

    }

    @Test
    public void updatePessoaTest() {}


    private static void assertPessoa(Pessoa expected, Pessoa actual) {
        Assert.assertEquals(expected.getNome(), actual.getNome());
        Assert.assertEquals(expected.getPeso(), actual.getPeso());
        Assert.assertEquals(expected.getAltura(), actual.getAltura());
        Assert.assertEquals(expected.getIdade(), actual.getIdade());
        Assert.assertEquals(expected.getCintura(), actual.getCintura());
        Assert.assertEquals(expected.getQuadril(), actual.getQuadril());

    }

    private static void assertPessoas(List<Pessoa> expected, List<Pessoa> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertPessoa(expected.get(i), actual.get(i));
        }
    }

}
