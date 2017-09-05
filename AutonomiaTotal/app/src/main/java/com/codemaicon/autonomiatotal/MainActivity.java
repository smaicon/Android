package com.codemaicon.autonomiatotal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editNomeCarro, editKmPercorrido, editQtdCombustivel;
    TextView consumoMediaFrota;
    ArrayList<String> listaCarros = new ArrayList<>();
    LinearLayout layoutDinamico;

    String[] nomesCarros = new String[3];
    double[] medias = new double[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Resgatar os campos do formulário
        editNomeCarro = (EditText) findViewById(R.id.editNome);
        editKmPercorrido = (EditText) findViewById(R.id.editKmPercorrido);
        editQtdCombustivel = (EditText) findViewById(R.id.editQtdCombustivel);

        // Resgatar TextViews
        consumoMediaFrota = (TextView) findViewById(R.id.consumoMediaFrota);

        layoutDinamico = (LinearLayout) findViewById(R.id.layoutFinal);

    }

    public void calcular(View V) {

        consumoMediaFrota.setText(" ");

        DecimalFormat df = new DecimalFormat("#.00");

        // Calcula a media km percorrido do carro
        double kmPercorrido = Double.parseDouble(editKmPercorrido.getText().toString());
        double qtdCombustivel = Double.parseDouble(editQtdCombustivel.getText().toString());
        double mediaCarro = kmPercorrido / qtdCombustivel;
        String nomeCarro = editNomeCarro.getText().toString() + " Km/L: " + df.format(mediaCarro);

        // Adiciona o carro no array
        listaCarros.add(nomeCarro);

        double kmMedio = (Double.parseDouble(editKmPercorrido.getText().toString()) / Double.parseDouble(editQtdCombustivel.getText().toString())) / listaCarros.size();

        consumoMediaFrota.setText("Consumo médio da frota: " + df.format(kmMedio));
        limparDados(V);

        for (int i = 0; i < listaCarros.size(); i++) {
            TextView tx = new TextView(this);
            tx.setText(listaCarros.get(i).toString());
            layoutDinamico.addView(tx);
        }


    }

    public void limparDados(View V) {
        editNomeCarro.setText("");
        editKmPercorrido.setText("");
        editQtdCombustivel.setText("");
    }


}