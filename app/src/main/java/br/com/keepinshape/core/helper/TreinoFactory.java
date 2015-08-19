package br.com.keepinshape.core.helper;

import java.util.Date;
import java.util.List;

import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.api.entity.Treino;

/**
 * Created by Joao on 18/08/2015.
 */
public class TreinoFactory {

    public Treino treinoFactory(long id, String nome, String tipo, Date diaSemana,
                                List<Exercicio>listaExercicios, double pontosTotal, double pontosMaximo){

        Treino treino = new Treino();
        treino.setId(id);
        treino.setNome(nome);
        treino.setTipo(tipo);
        treino.setDiaSemana(diaSemana);
        treino.setListaExercicios(listaExercicios);
        treino.setPontosTotal(pontosTotal);
        treino.setPontosMaximo(pontosMaximo);

        return treino;

    }

}
