package br.com.keepinshape.core.helper.facade;

import br.com.keepinshape.core.facade.AvaliacaoFisicaFacade;

/**
 * Created by root on 05/02/16.
 */
public class AvaliacaoFisicaFacadeFactory {

    private static AvaliacaoFisicaFacade avaliacaoFisicaFacade = null;

    public static AvaliacaoFisicaFacade getInstanceAvaliacaoFisicaFacade(){
        if(avaliacaoFisicaFacade == null){
            avaliacaoFisicaFacade = new AvaliacaoFisicaFacade();
        }
        return avaliacaoFisicaFacade;
    }

}
