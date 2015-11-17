package br.com.keepinshape.activity.treino;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.activity.exercicio.ExercicioAdapter;
import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.core.facade.TreinoFacade;
import br.com.keepinshape.core.helper.TreinoFactory;
import br.com.keepinshape.core.helper.facade.TreinoFacadeFactory;
import br.com.keepinshape.core.impl.TreinoDaoImpl;
import br.com.keepinshape.core.service.ConvertToTypes;

public class TreinoList extends ActionBarActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_list);

        listaTreinos();

    }


    public void listaTreinos(){

        ListView listView = (ListView) findViewById(R.id.listView_treinos_cadastrados);
        listView.setAdapter(new TreinoAdapter(this, TreinoFacadeFactory.getInstanceTreinoFacade().findAll(this)));

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView id1 = (TextView) view.findViewById(R.id.treino_list_id);
        int idTreino = Integer.parseInt(id1.getText().toString());

        Intent intent = new Intent(this, TreinoSpecification.class);
        intent.putExtra("idTreino", idTreino);
        startActivity(intent);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_treino_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
