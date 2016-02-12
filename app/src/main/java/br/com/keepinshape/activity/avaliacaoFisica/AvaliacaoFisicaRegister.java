package br.com.keepinshape.activity.avaliacaoFisica;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import junit.framework.Test;

import java.util.Date;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.AvaliacaoFisica;
import br.com.keepinshape.api.entity.Pessoa;
import br.com.keepinshape.core.helper.AvaliacaoFisicaFactory;
import br.com.keepinshape.core.helper.facade.AvaliacaoFisicaFacadeFactory;
import br.com.keepinshape.core.helper.facade.PessoaFacadeFactory;
import br.com.keepinshape.core.service.Validator;

public class AvaliacaoFisicaRegister extends Activity {

    private EditText editPeso, editAltura, editIdade, editCintura, editQuadril, editDataAvaliacao;
    private int [] vetorIdInputEditText = {R.id.txtPesoAvaliacaoFisica, R.id.txtAlturaAvaliacaoFisica,
    R.id.txtIdadeAvaliacaoFisica, R.id.txtCinturaAvaliacaoFisica, R.id.txtQuadrilAvaliacaoFisica, R.id.txtDataAvaliacaoFisica};
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_fisica_register);
    }

    public void handlerSalvarAvaliacaoFisica(View view){

        layout = (RelativeLayout) findViewById(R.id.layoutAvaliacaoFIsicaRegister);

        if(Validator.validador(layout, vetorIdInputEditText) == true){

            editPeso = (EditText) findViewById(vetorIdInputEditText[0]);
            editAltura = (EditText) findViewById(vetorIdInputEditText[1]);
            editIdade = (EditText) findViewById(vetorIdInputEditText[2]);
            editCintura = (EditText) findViewById(vetorIdInputEditText[3]);
            editQuadril = (EditText) findViewById(vetorIdInputEditText[4]);
            editDataAvaliacao = (EditText) findViewById(vetorIdInputEditText[5]);

            Pessoa pessoa = PessoaFacadeFactory.getInstancePessoaFacade().findById(1, this);

            AvaliacaoFisica avaliacaoFisica = AvaliacaoFisicaFactory.avaliacaoFisicaFactory(pessoa, Double.parseDouble(editPeso.getText().toString()),
                    Double.parseDouble(editAltura.getText().toString()), Integer.parseInt(editIdade.getText().toString()),
                    Double.parseDouble(editCintura.getText().toString()), Double.parseDouble(editQuadril.getText().toString()),
                    new Date());

            if(AvaliacaoFisicaFacadeFactory.getInstanceAvaliacaoFisicaFacade().save(avaliacaoFisica, this) == true){

                startActivity(new Intent(this, AvaliacaoFisicaList.class));

            } else {
                Toast.makeText(this, "Erro ao salvar", Toast.LENGTH_LONG).show();
            }

        } else {

            Toast.makeText(this, "Possuem campos a serem preenchidos", Toast.LENGTH_LONG).show();

        }

    }

}
