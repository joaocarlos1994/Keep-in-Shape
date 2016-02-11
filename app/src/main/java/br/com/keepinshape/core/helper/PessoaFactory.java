package br.com.keepinshape.core.helper;

import android.content.Context;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import br.com.keepinshape.api.entity.Agenda;
import br.com.keepinshape.api.entity.AvaliacaoFisica;
import br.com.keepinshape.api.entity.Pessoa;
import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.core.impl.PessoaDaoImpl;

/**
 * Created by Joao on 18/08/2015.
 */
public class PessoaFactory {

    private static PessoaDaoImpl pessoaDaoImpl = null;

    public static PessoaDaoImpl getInstancePessoaDaoImpl (Context context) throws SQLException {
        if(pessoaDaoImpl == null){
            pessoaDaoImpl = new PessoaDaoImpl(DatabaseHelperFactory.getIntanceConnection(context).getConnectionSource());
        }

        return pessoaDaoImpl;
    }

    public static Pessoa pessoaFactory(String nome, Collection<Treino> listaTreino, double peso,
                                double altura, int idade, Collection<Agenda> listaAgenda, double cintura, double quadril,
                                Date dateRegister, AvaliacaoFisica avaliacaoFisica){

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setListaTreino(listaTreino);
        pessoa.setPeso(peso);
        pessoa.setAltura(altura);
        pessoa.setIdade(idade);
        pessoa.setListaAgenda(listaAgenda);
        pessoa.setCintura(cintura);
        pessoa.setQuadril(quadril);
        pessoa.setDateRegister(dateRegister);
        pessoa.setAvaliacaoFisica(avaliacaoFisica);

        return pessoa;

    }

}
