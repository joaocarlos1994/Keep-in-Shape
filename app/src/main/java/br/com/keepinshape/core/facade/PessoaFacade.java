package br.com.keepinshape.core.facade;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import br.com.keepinshape.api.entity.Pessoa;
import br.com.keepinshape.api.service.PessoaDAO;
import br.com.keepinshape.core.helper.PessoaFactory;
import br.com.keepinshape.core.impl.PessoaDaoImpl;

/**
 * Created by root on 06/01/16.
 */
public class PessoaFacade implements PessoaDAO {

    private PessoaDaoImpl pessoaDaoImpl;

    @Override
    public boolean save(Pessoa pessoa, Context context) {

        try {
            pessoaDaoImpl = PessoaFactory.getInstancePessoaDaoImpl(context);
            pessoaDaoImpl.create(pessoa);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;


    }

    @Override
    public Pessoa findById(int id, Context context) {

        Pessoa pessoa = null;

        try {
            pessoaDaoImpl = PessoaFactory.getInstancePessoaDaoImpl(context);
            pessoa = pessoaDaoImpl.queryForId(id);

            return pessoa;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        return null;
    }

    @Override
    public boolean remove(Pessoa pessoa) {
        return false;
    }

    @Override
    public List<Pessoa> findAll(Context context) {

        List<Pessoa> pessoasList = null;

        try {

            pessoaDaoImpl = PessoaFactory.getInstancePessoaDaoImpl(context);
            pessoasList = pessoaDaoImpl.queryForAll();
            return  pessoasList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}
