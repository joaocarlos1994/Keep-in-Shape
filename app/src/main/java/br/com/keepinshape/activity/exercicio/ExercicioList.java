package br.com.keepinshape.activity.exercicio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.ColumnArg;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.keepinshape.R;
import br.com.keepinshape.activity.avaliacaoFisica.AvaliacaoFisicaSpecification;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.core.facade.ExercicioFacade;
import br.com.keepinshape.core.helper.DatabaseHelperFactory;
import br.com.keepinshape.core.helper.ExercicioFactory;
import br.com.keepinshape.core.helper.facade.ExercicioFacadeFactory;
import br.com.keepinshape.core.impl.ExercicioDaoImpl;

public class ExercicioList extends Activity implements AdapterView.OnItemClickListener  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio_list);

        listaExercicios();

    }


    public void listaExercicios(){

        ListView listView = (ListView) findViewById(R.id.listViewExercicio);


        String query = "select * from exercicio e where e." + Exercicio.COLUMN_TREINO + " is null;";

        listView.setAdapter(new ExercicioAdapter(this, ExercicioFacadeFactory.getExercicioFacadeFactory().customizedQueryExercicio(query, this)));
        listView.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exercicio_list, menu);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView id1 = (TextView) view.findViewById(R.id.idExercicio);
        int idExercicio = Integer.parseInt(id1.getText().toString());

        Intent intent = new Intent(this, ExercicioSpecification.class);
        intent.putExtra("idExercicio", idExercicio);
        startActivity(intent);

    }
}
