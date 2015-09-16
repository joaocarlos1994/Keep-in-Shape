package br.com.keepinshape.core.helper;

import java.util.Collection;
import java.util.List;

import br.com.keepinshape.api.entity.Agenda;
import br.com.keepinshape.api.entity.Pessoa;
import br.com.keepinshape.api.entity.Treino;

/**
 * Created by Joao on 18/08/2015.
 */
public class PessoaFactory {

    public Pessoa pessoaFactory(String nome, Collection<Treino> listaExercicio, double peso,
                                double altura, int idade, Collection<Agenda> listaAgenda){

        Pessoa pessoa = new Pessoa();
        pessoa.setListaExercicio(listaExercicio);
        pessoa.setPeso(peso);
        pessoa.setAltura(altura);
        pessoa.setIdade(idade);
        pessoa.setListaAgenda(listaAgenda);

        return pessoa;

    }

}
