package br.com.keepinshape.activity.avaliacaoFisica;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.AvaliacaoFisica;
import br.com.keepinshape.core.helper.facade.AvaliacaoFisicaFacadeFactory;

public class AvaliacaoFisicaSpecification extends Activity {

    private List<AvaliacaoFisica> avaliacaoFisicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_fisica_specification);

        Bundle idAvaliacaoFisica = getIntent().getExtras();
        int id = (int) idAvaliacaoFisica.get("idAvaliacaoFisica");

        avaliacaoFisicas = new ArrayList<>();
        avaliacaoFisicas.add(AvaliacaoFisicaFacadeFactory.getInstanceAvaliacaoFisicaFacade().findById(id, this));

        ListView listView = (ListView) findViewById(R.id.listViewAvaliacaoFisicaSpecification);
        listView.setAdapter(new AvaliacaoFisicaAdapterSpecification(this, avaliacaoFisicas));



    }

    public void handlerDeleteAvaliacaoFisica(View view){

        Bundle idAvaliacaoFisica = getIntent().getExtras();
        int id = (int) idAvaliacaoFisica.get("idAvaliacaoFisica");

        AvaliacaoFisica avaliacaoFisica = AvaliacaoFisicaFacadeFactory.getInstanceAvaliacaoFisicaFacade().findById(id, this);

        if(AvaliacaoFisicaFacadeFactory.getInstanceAvaliacaoFisicaFacade().remove(avaliacaoFisica, this) == true){
            startActivity(new Intent(this, AvaliacaoFisicaList.class));
        } else {
            Toast.makeText(this, "Erro ao deletar Avaliação Física", Toast.LENGTH_LONG).show();
        }


    }

    public void handlerStartActivityAvaliacaoFisicaGraph(View view){

        startActivity(new Intent(this, AvaliacaoFisicaGraph.class));

    }

}
