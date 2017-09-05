package com.codemaicon.boletimapp.activitys;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.codemaicon.boletimapp.R;
import com.codemaicon.boletimapp.modelo.Avaliacao;
import com.codemaicon.boletimapp.modelo.Disciplina;

import java.util.ArrayList;
import java.util.Iterator;

public class AvaliacaoActivity extends AppCompatActivity {

    Avaliacao avaliacao;
    String titulo;

    EditText editNomeProfessor, editNota;
    TextView tvTitulo;
    Spinner spDisciplinas;

    ArrayList<Disciplina> listDiscplina;
    ArrayAdapter<Disciplina> adapterDisciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        //Resgatar parâmetros enviados da acativity chamadora
        Bundle param = getIntent().getExtras();
        avaliacao = (Avaliacao) param.getSerializable("av");

        titulo = param.getString("titulo");
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvTitulo.setText(titulo);


        //Resgatar campos do formulário
        editNomeProfessor = (EditText) findViewById(R.id.editNomeProfessor);
        editNota = (EditText) findViewById(R.id.editNota);

        //Montagem do spinner com disciplinas
        spDisciplinas = (Spinner) findViewById(R.id.spinnerDisciplinas);
        montarSpinner();

        /*IPopular form para edição*/
        popularForm();
    }

    public void popularForm(){
        if(avaliacao != null){
            editNomeProfessor.setText(avaliacao.getProfessor());
            editNota.setText(String.valueOf(avaliacao.getNota()));

            Iterator<Disciplina> iterator = listDiscplina.iterator();
            int indiceDisciplinaEscolhida = -1;
            Disciplina d;
            while(iterator.hasNext()){
                d = iterator.next();
                indiceDisciplinaEscolhida++;
                if(d.toString().equals(avaliacao.getDisciplina().toString()))
                    break;
            }
            spDisciplinas.setSelection(indiceDisciplinaEscolhida);
        }
    }

    public void montarSpinner(){
        //Cria ligação entre layout e lista de objetos
        listDiscplina = new ArrayList<Disciplina>();
        adapterDisciplina = new ArrayAdapter<Disciplina>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                listDiscplina);
        spDisciplinas.setAdapter(adapterDisciplina);

        //Inserir disciplinas no adapter, adiona automático no spinner
        adapterDisciplina.add(new Disciplina("Lógica", 40));
        adapterDisciplina.add(new Disciplina("Matemática", 30));
        adapterDisciplina.add(new Disciplina("Web", 45));
    }

    public void enviar(View v){
        Disciplina disc = (Disciplina) spDisciplinas.getSelectedItem();
        String professor = editNomeProfessor.getText().toString();

        //INICIO Validação do nota
        double nota = 0;
        try{
            nota = Double.parseDouble(editNota.getText().toString());
            if(nota<0 || nota >10){
                Toast.makeText(this, "Nota inválida", Toast.LENGTH_SHORT).show();
                editNota.requestFocus();
                return;
            }
        }catch (Exception e){
            Toast.makeText(this, "Nota inválida", Toast.LENGTH_SHORT).show();
            editNota.requestFocus();
            return;
        }
        //FIM Validação do nota

        //Inserir dados no objeto avaliação
        if(avaliacao==null)
            avaliacao = new Avaliacao();

        avaliacao.setDisciplina(disc);
        avaliacao.setNota(nota);
        avaliacao.setProfessor(professor);

        //Enviar dados para a activity chamadora
        Intent it = new Intent();
        it.putExtra("avaliacao", avaliacao);
        setResult(RESULT_OK, it);
        finish();
    }

    public void voltar(View v){
        finish();
    }

}
