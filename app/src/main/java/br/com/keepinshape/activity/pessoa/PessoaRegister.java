package br.com.keepinshape.activity.pessoa;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.Date;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.Pessoa;
import br.com.keepinshape.core.facade.PessoaFacade;
import br.com.keepinshape.core.helper.PessoaFactory;
import br.com.keepinshape.core.helper.facade.PessoaFacadeFactory;
import br.com.keepinshape.core.service.ConvertToTypes;
import br.com.keepinshape.core.service.Validator;

public class PessoaRegister extends ActionBarActivity {

    private EditText nome, peso, altura, idade, cintura, quadril;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa_register);
    }

    public void handlerSalvarPessoa(View view){

        layout = (RelativeLayout) findViewById(R.id.relative_layout_register_pessoa);

        int vetor [] = {R.id.txtPessoaNome, R.id.txtPessoaPeso, R.id.txtPessoaAltura, R.id.txtPessoaIdade,
                R.id.txtPessoaCintura, R.id.txtPessoaQuadril};

        if (Validator.validador(layout, vetor) == true){

            nome = (EditText) findViewById(vetor[0]);
            peso = (EditText) findViewById(vetor[1]);
            altura = (EditText) findViewById(vetor[2]);
            idade = (EditText) findViewById(vetor[3]);
            cintura = (EditText) findViewById(vetor[4]);
            quadril = (EditText) findViewById(vetor[5]);


            Pessoa pessoa = PessoaFactory.pessoaFactory(nome.getText().toString(), null, Double.parseDouble(peso.getText().toString()),
                    Double.parseDouble(altura.getText().toString()), Integer.parseInt(idade.getText().toString()), null, Double.parseDouble(cintura.getText().toString()),
                    Double.parseDouble(quadril.getText().toString()),new Date());



            PessoaFacadeFactory.getInstancePessoaFacade().save(pessoa, this);

            startActivity(new Intent(this, PessoaRegister.class));


        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pessoa_register, menu);
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
