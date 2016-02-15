package br.com.keepinshape.activity.treino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.core.helper.TreinoFactory;
import br.com.keepinshape.core.helper.facade.TreinoFacadeFactory;
import br.com.keepinshape.core.impl.TreinoDaoImpl;

public class TreinoSpecification extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_specification);

        Bundle idTreino = getIntent().getExtras();
        int id = (int) idTreino.get("idTreino");

        List<Treino> treinos = null;


        treinos = new ArrayList<Treino>();
        treinos.add(TreinoFacadeFactory.getInstanceTreinoFacade().findById(id, this));


        ListView listView = (ListView) findViewById(R.id.listView_treino_specification);
        listView.setAdapter(new TreinoAdapterSpecification(this, treinos));


    }

    public void handlerEditTreino(View view){

        Bundle idTreino = getIntent().getExtras();
        int id = (int) idTreino.get("idTreino");

        Intent intent = new Intent(this, TreinoRegister.class);
        intent.putExtra("idTreino", id);

        startActivity(intent);
    }

    public void handlerDeleteTreino(View view){

        Bundle idTreino = getIntent().getExtras();
        int id = (int) idTreino.get("idTreino");

        Treino treino = TreinoFacadeFactory.getInstanceTreinoFacade().findById(id, this);
        TreinoFacadeFactory.getInstanceTreinoFacade().remove(treino, this);

        startActivity(new Intent(this, TreinoList.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_treino_specification, menu);
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
