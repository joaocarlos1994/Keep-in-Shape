package br.com.keepinshape.api.service;

import android.content.Context;

import java.util.List;

import br.com.keepinshape.api.entity.AvaliacaoFisica;

/**
 * Created by root on 05/02/16.
 */
public interface AvaliacaoFisicaDAO {

    boolean save(AvaliacaoFisica avaliacaoFisica, Context context);
    AvaliacaoFisica findById (int id, Context context);
    AvaliacaoFisica update (AvaliacaoFisica avaliacaoFisica, Context context);
    boolean remove (AvaliacaoFisica avaliacaoFisica, Context context);
    List<AvaliacaoFisica> findAll(Context context);
    List<AvaliacaoFisica> customizedQueryAvaliacaoFisica(String query, Context context);


}
