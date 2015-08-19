package br.com.keepinshape.core.helper;

import java.util.Date;
import java.util.List;

import br.com.keepinshape.api.entity.Alimento;
import br.com.keepinshape.api.entity.Dieta;

/**
 * Created by Joao on 18/08/2015.
 */
public class DietaFactory {

    public Dieta dietaFactory(long id,  String nome, Date diaSemana, List<Alimento>listaAlimento){
        Dieta dieta = new Dieta();
        dieta.setId(id);
        dieta.setNome(nome);
        dieta.setDiaSemana(diaSemana);
        dieta.setListaAlimento(listaAlimento);

        return dieta;
    }

}
