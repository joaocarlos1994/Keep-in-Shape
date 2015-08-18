package br.com.keepinshape.api.service;

import java.util.List;

import br.com.keepinshape.api.entity.Agenda;

/**
 * Created by Joao on 17/08/2015.
 */
public interface AgendaDAO {

    public Agenda save(Agenda agenda);
    public Agenda findById (int id);
    public Agenda update (Agenda agenda);
    public boolean remove (Agenda agenda);
    public List<Agenda> findAll();

}
