package br.com.keepinshape.core.helper;

import br.com.keepinshape.api.entity.Exercicio;

/**
 * Created by Joao on 18/08/2015.
 */
public class ExercicioFactory {

    public Exercicio exercicioFactory(long id, String nome, int tempo, float peso, int quantidade, double pontuacao){

        Exercicio exercicio = new Exercicio();
        exercicio.set_id(id);
        exercicio.setNome(nome);
        exercicio.setTempo(tempo);
        exercicio.setPeso(peso);
        exercicio.setQuantidade(quantidade);
        exercicio.setPontuacao(pontuacao);

        return exercicio;

    }

}
