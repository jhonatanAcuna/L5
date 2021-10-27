package com.example.l5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    GraphView grafica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grafica = findViewById(R.id.grafica);
        //titulo
        grafica.setTitle("Mascotas");

        //DATOS DE LAS BARRAS
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(1,10),
                new DataPoint(2,0),
                new DataPoint(3 ,20),
                new DataPoint(4,50)
        });

        //AÑADIENDO DATOS
        grafica.addSeries(series);

        //Color a las barras
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int)data.getX()*255/4, (int)data.getY()*255/6,100);
            }
        });

        ///espacios
        series.setSpacing(20);

        //Dibujando
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.BLUE);
        //Limitandos
        grafica.getGridLabelRenderer().setNumHorizontalLabels(4);

        //Ingresando valores en XY
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(grafica);
        // Valores de Y
        staticLabelsFormatter.setHorizontalLabels(new String[]{"Arequipa","Moquegua","Tacna","Cusco"});
        // Valores de X
        staticLabelsFormatter.setVerticalLabels(new String[]{"0","10","20","30","40","50","60","70"});
        grafica.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
    }
}