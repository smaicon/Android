package com.codemaicon.apptelas;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

public class Tela1_activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        Toast.makeText(this, "Passou pelo onCreate!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Passou pelo onDestroy!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Passou pelo onRestart!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Pressionou voltar");
        alerta.setMessage("Deseja fechar a tela?");
        alerta.setNeutralButton("Não", null);
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Tela1_activity.this, "Fechou", Toast.LENGTH_SHORT).show();
                // Fechar a tela
                finish();
            }
        });
        alerta.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
        alerta.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Passou pelo onStart!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Passou pelo onResume!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Passou pelo onPause!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Passou pelo onStop!", Toast.LENGTH_SHORT).show();
    }

    public void clicar(View view) {
        Intent it = new Intent(this, Tela2_activity.class);
        startActivity(it);
    }
}
