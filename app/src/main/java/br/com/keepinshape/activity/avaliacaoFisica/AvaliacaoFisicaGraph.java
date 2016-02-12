package br.com.keepinshape.activity.avaliacaoFisica;

import android.os.Bundle;
import android.app.Activity;
import android.widget.RelativeLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import br.com.keepinshape.R;

public class AvaliacaoFisicaGraph extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_fisica);


        GraphView graph = new GraphView(this);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(1, 10),
                new DataPoint(2, 8),
                new DataPoint(3, 7),
                new DataPoint(4, 6),
                new DataPoint(5, 5),
        });
        graph.addSeries(series);

        graph.getGridLabelRenderer().setVerticalAxisTitle("Peso");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Data Avaliacao");


        RelativeLayout rl = (RelativeLayout) findViewById(R.id.RelaLayoutAvalicaoFisica);
        rl.addView(graph);


    }

}
