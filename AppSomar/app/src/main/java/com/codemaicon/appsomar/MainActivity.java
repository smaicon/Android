package com.codemaicon.appsomar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.SortedMap;

public class MainActivity extends AppCompatActivity {
    private EditText etNumero1, etNumero2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         etNumero1 = (EditText)findViewById(R.id.n1);
         etNumero2 = (EditText)findViewById(R.id.n2);
        Button btnSomar = (Button) findViewById(R.id.btnSomar);

        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int n1 = Integer.parseInt(etNumero1.getText().toString());
                int n2 = Integer.parseInt(etNumero1.getText().toString());
                int soma = n1 + n2;

                Toast.makeText(MainActivity.this, "Resultado:" +soma, Toast.LENGTH_LONG).show();
            }
        });


    }
        public void onResume(){
            super.onResume();
        }
        public void onDestroy(){
            super.onDestroy();
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
