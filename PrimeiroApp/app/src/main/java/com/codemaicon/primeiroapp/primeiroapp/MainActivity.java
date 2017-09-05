package com.codemaicon.primeiroapp.primeiroapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mensagem rapida
        makeText(this, R.string.app_name, LENGTH_SHORT).show();
    }
}
