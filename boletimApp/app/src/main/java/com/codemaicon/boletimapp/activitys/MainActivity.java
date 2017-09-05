package com.codemaicon.boletimapp.activitys;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.codemaicon.boletimapp.util.Constantes;
import com.codemaicon.boletimapp.R;
import com.codemaicon.boletimapp.modelo.Avaliacao;

public class MainActivity extends AppCompatActivity {

    Avaliacao avaliacao1=null, avaliacao2=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamarAvaliacao(View v){
        Intent it = null;
        int codRequisicao = 0;
        if(v.getId() == R.id.btnAvaliacao1){
            it = new Intent(this, AvaliacaoActivity.class);
            it.putExtra("av", avaliacao1);
            it.putExtra("titulo", "Avaliação 1");
            codRequisicao = Constantes.REQUEST_AV1;
        }else if(v.getId() == R.id.btnAvaliacao2){
            it = new Intent(this, AvaliacaoActivity.class);
            it.putExtra("av", avaliacao2);
            it.putExtra("titulo", "Avaliação 2");
            codRequisicao = Constantes.REQUEST_AV2;
        }
        startActivityForResult(it, codRequisicao);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle param;

        switch (requestCode){
            case Constantes.REQUEST_AV1:
                if(resultCode == RESULT_OK){
                    param = data.getExtras();
                    avaliacao1 = (Avaliacao) param.getSerializable("Avaliacao");
                    Toast.makeText(this, ""+avaliacao1.toString(), Toast.LENGTH_SHORT).show();
                }
                break;

            case Constantes.REQUEST_AV2:
                if (resultCode == RESULT_OK) {
                    param = data.getExtras();
                    avaliacao2 = (Avaliacao) param.getSerializable("Avaliacao");
                    Toast.makeText(this, ""+avaliacao2.toString(), Toast.LENGTH_SHORT).show();
                }
                break;

            case Constantes.REQUEST_RESULTADO:
                if(resultCode == Constantes.RESULT_VOLTAR_LIMPAR){
                    avaliacao1 = null;
                    avaliacao2 = null;
                }
                break;

            default:
                Toast.makeText(this, "Cancelou!", Toast.LENGTH_SHORT).show();
        }
    }

    public void resultado(View v){
        Intent it = new Intent(this, ResultadoActivity.class);
        it.putExtra("av1", avaliacao1);
        it.putExtra("av2", avaliacao2);

        if(avaliacao1 == null || avaliacao2 == null){
            Toast.makeText(this, "Finalize o cadastro de avaliacoes", Toast.LENGTH_SHORT).show();
        }else {
            startActivityForResult(it, Constantes.REQUEST_RESULTADO);
        }
    }
}
