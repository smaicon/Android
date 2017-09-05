package com.codemaicon.boletimapp.activitys;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.codemaicon.boletimapp.R;
import com.codemaicon.boletimapp.modelo.Avaliacao;
import com.codemaicon.boletimapp.util.Constantes;

public class ResultadoActivity extends AppCompatActivity {

    TextView tvProfessor1, tvProfessor2, tvNota1, tvNota2;
    TextView tvDisciplina1, tvDisciplina2;
    Avaliacao av1, av2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        tvProfessor1 = (TextView) findViewById(R.id.tvNomeProfessor1);
        tvProfessor2 = (TextView) findViewById(R.id.tvNomeProfessor2);
        tvDisciplina1 = (TextView) findViewById(R.id.tvDadosDisciplina1);
        tvDisciplina2 = (TextView) findViewById(R.id.tvDadosDisciplina2);
        tvNota1 = (TextView) findViewById(R.id.tvNota1);
        tvNota2 = (TextView) findViewById(R.id.tvNota2);

        //Resgatar avaliações e inserir os dados no layout
        Bundle param = getIntent().getExtras();
        av1 = (Avaliacao) param.getSerializable("av1");
        av2 = (Avaliacao) param.getSerializable("av2");


        // dados no layout
        tvProfessor1.setText("Prof.: " + av1.getProfessor());
        tvDisciplina1.setText("Disc.: " + av1.getDisciplina().toString());
        tvNota1.setText(String.valueOf(av1.getNota()));

        tvProfessor2.setText("Prof.: " + av2.getProfessor());
        tvDisciplina2.setText("Disc.: " + av2.getDisciplina().toString());
        tvNota2.setText(String.valueOf(av2.getNota()));
    }

    public void voltar(View v) {
        if (v.getId() == R.id.btnVoltarEditar) {
            setResult(Constantes.RESULT_VOLTAR_EDITAR);
            finish();
        } else if (v.getId() == R.id.btnVoltarLimpar) {
            setResult(Constantes.RESULT_VOLTAR_LIMPAR);
            finish();
        }
    }

}
