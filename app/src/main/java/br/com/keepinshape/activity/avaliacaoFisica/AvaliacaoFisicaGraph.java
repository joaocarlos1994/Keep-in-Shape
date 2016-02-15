package br.com.keepinshape.activity.avaliacaoFisica;

import android.os.Bundle;
import android.app.Activity;
import android.widget.RelativeLayout;

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

    public DataPoint[] returnPointImplementsGraph(List<AvaliacaoFisica> avaliacaoFisicas, int typeGraph){

        DataPoint [] dataPoints = new  DataPoint[avaliacaoFisicas.size()];

        switch (typeGraph){
            case 1:
                for (int i = 0; i < avaliacaoFisicas.size(); i++){
                    dataPoints[i] = new DataPoint(avaliacaoFisicas.get(i).getDateAvaliacao(), avaliacaoFisicas.get(i).getPeso());
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
