package br.com.keepinshape.activity.avaliacaoFisica;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.AvaliacaoFisica;
import br.com.keepinshape.core.helper.facade.AvaliacaoFisicaFacadeFactory;

public class AvaliacaoFisicaList extends Activity implements AdapterView.OnItemClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_fisica_list);

        listAllAvalicaoFisica();
    }

    public void listAllAvalicaoFisica(){

        List<AvaliacaoFisica> avaliacaoFisicas = AvaliacaoFisicaFacadeFactory.getInstanceAvaliacaoFisicaFacade().findAll(this);
        ListView listView = (ListView) findViewById(R.id.listViewAvaliacaoFisica);

        listView.setAdapter(new AvaliacaoFisicaAdapter(this, avaliacaoFisicas));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView id1 = (TextView) view.findViewById(R.id.idAvaliacaoFisica);
        int idAvalicaoFisica = Integer.parseInt(id1.getText().toString());

        Intent intent = new Intent(this, AvaliacaoFisicaSpecification.class);
        intent.putExtra("idAvaliacaoFisica", idAvalicaoFisica);
        startActivity(intent);
    }
}
