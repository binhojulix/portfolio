package com.example.julio.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultado;
    private EditText numberOne, numberTwo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        this.resultado = (TextView) findViewById(R.id.resultado);
        this.numberOne = (EditText) findViewById(R.id.number_one);
        this.numberTwo = (EditText) findViewById(R.id.number_two);


        Button somar = (Button) findViewById(R.id.btn_adicionar);
        Button subtrair = (Button) findViewById(R.id.btn_subtrair);
        Button dividir = (Button) findViewById(R.id.btn_dividir);
        Button multiplicar = (Button) findViewById(R.id.btn_multiplicar);


        somar.setOnClickListener(this);
        subtrair.setOnClickListener(this);
        dividir.setOnClickListener(this);
        multiplicar.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        Double resultadoOperacao = 0.0;
        switch (v.getId()) {
            case R.id.btn_adicionar:
                resultadoOperacao = textConverted(numberOne) + textConverted(numberTwo);
                break;
            case R.id.btn_multiplicar:
                resultadoOperacao = textConverted(numberOne) * textConverted(numberTwo);
                break;
            case R.id.btn_dividir:
                resultadoOperacao = textConverted(numberOne) / textConverted(numberTwo);
                break;
            case R.id.btn_subtrair:
                resultadoOperacao = textConverted(numberOne) - textConverted(numberTwo);
                break;
        }

        resultado.setText(resultadoOperacao.toString());

    }

    private Double textConverted(EditText number) {
        String numberString =  number.getText().toString();
        return Double.parseDouble(numberString);
    }
}