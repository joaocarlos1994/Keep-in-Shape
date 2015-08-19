package br.com.keepinshape.core.helper;

import br.com.keepinshape.api.entity.Alimento;

/**
 * Created by Joao on 18/08/2015.
 */
public class AlimentoFactory {

    public Alimento alimentoFactory(long id, String nome, double valorCalorico, double quantidade){

        Alimento alimento = new Alimento();
        alimento.setId(id);
        alimento.setNome(nome);
        alimento.setValorCalorico(valorCalorico);
        alimento.setQuantidae(quantidade);

        return alimento;
    }

}
