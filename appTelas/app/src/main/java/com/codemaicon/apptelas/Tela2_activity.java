package com.codemaicon.apptelas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Tela2_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }

    public void clicar(View view) {
        Intent it = new Intent(this, Tela3_activity.class);
        startActivity(it);
    }
}
