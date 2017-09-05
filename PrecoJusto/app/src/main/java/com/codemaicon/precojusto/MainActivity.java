package com.codemaicon.precojusto;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText editNomeProduto, editValorProduto, editQtdPar, editJuros;
    TextView tvValorTotal, tvNomeProduto, tvValorInicial, tvValorParcela, tvTotalJuros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // pegando os campos do formulário
        editNomeProduto = (EditText) findViewById(R.id.editNomeProduto);
        editValorProduto = (EditText) findViewById(R.id.editValorProduto);
        editQtdPar = (EditText) findViewById(R.id.editQtdPar);
        editJuros = (EditText) findViewById(R.id.editJuros);

        // pegando os textviews
        tvValorTotal = (TextView) findViewById(R.id.tvValorTotal);
        tvNomeProduto = (TextView) findViewById(R.id.tvNomeProduto);
        tvValorInicial = (TextView) findViewById(R.id.tvValorInicial);
        tvValorParcela = (TextView) findViewById(R.id.tvValorParcela);
        tvTotalJuros = (TextView) findViewById(R.id.tvTotalJuros);

    }

    public void calcular(View V) {

        String nomeProduto = editNomeProduto.getText().toString();
        double valorProduto = Double.parseDouble(editValorProduto.getText().toString());
        int qtdParcelas = Integer.parseInt(editQtdPar.getText().toString());
        double juros = Double.parseDouble(editJuros.getText().toString());

        // calculando o preço final
        double valorParcela = valorProduto / qtdParcelas;
        double precoFinal = (valorParcela + ((valorParcela * juros)/100)) * qtdParcelas;
        double totalJuros = (juros/100) * valorProduto;

        tvValorTotal.setText(String.format("R$ %.2f", precoFinal));

        // out  resultados
        tvNomeProduto.setText(getString(R.string.nomeProduto) + ": " + nomeProduto);
        tvValorInicial.setText(getString(R.string.valorInicial) + ": R$ " + String.format("%.2f", valorProduto));
        tvValorParcela.setText(getString(R.string.valorParcelas) + ": R$ " + String.format("%.2f", valorParcela));
        tvValorTotal.setText(getString(R.string.valorTotal) + ": R$ " + String.format("%.2f", precoFinal));
        tvTotalJuros.setText(getString(R.string.totalJuros) + ": R$ " + String.format("%.2f", totalJuros));
    }

    // Limpa todos e da requestfocus no  nomeProduto
    public void limparDados(View V) {
        editNomeProduto.setText("");
        editValorProduto.setText("");
        editQtdPar.setText("");
        editJuros.setText("");
        tvNomeProduto.setText("");
        tvValorInicial.setText("");
        tvValorParcela.setText("");
        tvValorTotal.setText("");
        tvTotalJuros.setText("");
        editNomeProduto.requestFocus();
    }

}
