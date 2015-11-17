package br.com.keepinshape.core.helper.facade;

import br.com.keepinshape.core.facade.TreinoFacade;

/**
 * Created by root on 17/11/15.
 */
public class TreinoFacadeFactory {

    private static TreinoFacade treinoFacade = null;

    public static TreinoFacade getInstanceTreinoFacade(){

        if(treinoFacade == null){
            treinoFacade = new TreinoFacade();
        }

        return treinoFacade;

    }


}
