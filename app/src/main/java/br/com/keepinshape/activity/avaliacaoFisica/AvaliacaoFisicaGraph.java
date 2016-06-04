package br.com.keepinshape.activity.avaliacaoFisica;

import android.os.Bundle;
import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.AvaliacaoFisica;
import br.com.keepinshape.core.helper.facade.AvaliacaoFisicaFacadeFactory;
import br.com.keepinshape.core.service.ConvertToTypes;

public class AvaliacaoFisicaGraph extends Activity {

    private List<DataPoint> dataPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_fisica);

        int layoutPeso = R.id.RelaLayoutAvalicaoFisicaPeso;
        int layoutAltura = R.id.RelaLayoutAvalicaoFisicaAltura;
        int layoutCintura = R.id.RelaLayoutAvalicaoFisicaCintura;
        int layoutQuadril = R.id.RelaLayoutAvalicaoFisicaQuadril;

        List<AvaliacaoFisica> avaliacaoFisicas = AvaliacaoFisicaFacadeFactory.getInstanceAvaliacaoFisicaFacade().findAll(this);

        graphAndroid(avaliacaoFisicas, layoutPeso, "Peso", "Data", 1);
        graphAndroid(avaliacaoFisicas, layoutAltura, "Altura", "Data", 2);
        graphAndroid(avaliacaoFisicas, layoutCintura, "Cintura", "Data", 3);
        graphAndroid(avaliacaoFisicas, layoutQuadril, "Quadril", "Data", 4);

    }

    public void graphAndroid(List<AvaliacaoFisica> avaliacaoFisicas, int idLayout, String verticalTextTile, String horizontalTextTile, int typeGraph){

        GraphView graph = new GraphView(this);

        DataPoint [] dataPoints = returnPointImplementsGraph(avaliacaoFisicas, typeGraph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoints);
        graph.addSeries(series);

        graph.getGridLabelRenderer().setVerticalAxisTitle(verticalTextTile);
        graph.getGridLabelRenderer().setHorizontalAxisTitle(horizontalTextTile);

        RelativeLayout rl = (RelativeLayout) findViewById(idLayout);
        rl.addView(graph);

    }

    public double calcularImc(AvaliacaoFisica avaliacaoFisica){
        double imc = 0;
        imc = avaliacaoFisica.getPeso() / (avaliacaoFisica.getAltura() * avaliacaoFisica.getAltura());
        return imc;
    }

    public String situacaoCalculoImc(double imc){

        String situacao = "";

        if(imc < 17) situacao = "Muito abaixo do peso";
        if(imc >= 17 && imc <= 18.49) situacao = "Abaixo do peso";
        if(imc >= 18.50 && imc <= 24.99) situacao = "Peso normal";
        if(imc >= 25.00 && imc <= 29.99) situacao = "Acima do peso";
        if(imc >= 30.00 && imc <= 34.99) situacao = "Obesidade I";
        if(imc >= 35.00 && imc <= 39.99) situacao = "Obesidade II (severa)";
        if(imc > 40.00) situacao = "Obesidade III (mórbida)";

        return situacao;
    }

    public DataPoint[] returnPointImplementsGraph(List<AvaliacaoFisica> avaliacaoFisicas, int typeGraph){

        DataPoint [] dataPoints = new  DataPoint[avaliacaoFisicas.size()];

        switch (typeGraph){
            case 1:
                for (int i = 0; i < avaliacaoFisicas.size(); i++){
                    dataPoints[i] = new DataPoint(avaliacaoFisicas.get(i).getDateAvaliacao(), avaliacaoFisicas.get(i).getPeso());

                    if (i == avaliacaoFisicas.size() - 1){ //Quando for o último registro da avaliação física

                        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicas.get(i);

                        TextView peso = (TextView) findViewById(R.id.peso_grafico);
                        TextView altura = (TextView) findViewById(R.id.altura_grafico);
                        TextView imc = (TextView) findViewById(R.id.imc_grafico);
                        TextView situacao = (TextView) findViewById(R.id.situacao_grafico);


                        peso.setText(peso.getText() + ConvertToTypes.convertDoubleToString(avaliacaoFisica.getPeso()));
                        altura.setText(altura.getText() + ConvertToTypes.convertDoubleToString(avaliacaoFisica.getAltura()));
                        imc.setText(imc.getText() + ConvertToTypes.convertDoubleToString(calcularImc(avaliacaoFisica)));
                        situacao.setText(situacao.getText() + situacaoCalculoImc(calcularImc(avaliacaoFisica)));

                    }
                }
                break;
            case 2:
                for (int i = 0; i < avaliacaoFisicas.size(); i++){
                    dataPoints[i] = new DataPoint(avaliacaoFisicas.get(i).getDateAvaliacao(), avaliacaoFisicas.get(i).getAltura());
                }
                break;
            case 3:
                for (int i = 0; i < avaliacaoFisicas.size(); i++){
                    dataPoints[i] = new DataPoint(avaliacaoFisicas.get(i).getDateAvaliacao(), avaliacaoFisicas.get(i).getCintura());
                }
                break;
            case 5:
                for (int i = 0; i < avaliacaoFisicas.size(); i++){
                    dataPoints[i] = new DataPoint(avaliacaoFisicas.get(i).getDateAvaliacao(), avaliacaoFisicas.get(i).getQuadril());
                }
                break;
            default:
                for (int i = 0; i < avaliacaoFisicas.size(); i++){
                    dataPoints[i] = new DataPoint(avaliacaoFisicas.get(i).getDateAvaliacao(), avaliacaoFisicas.get(i).getIdade());
                }
                break;
        }


        return  dataPoints;

    }

}
