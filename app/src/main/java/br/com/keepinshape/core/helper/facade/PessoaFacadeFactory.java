package br.com.keepinshape.core.helper.facade;

import br.com.keepinshape.core.facade.PessoaFacade;

/**
 * Created by root on 06/01/16.
 */
public class PessoaFacadeFactory {

    public static PessoaFacade pessoaFacade = null;

    public static PessoaFacade getInstancePessoaFacade(){

        if(pessoaFacade == null){
            pessoaFacade = new PessoaFacade();
        }

        return pessoaFacade;

    }

}
