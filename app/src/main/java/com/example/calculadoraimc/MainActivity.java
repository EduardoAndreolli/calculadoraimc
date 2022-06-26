package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editAlt, editPeso;
    TextView resultadoIMC;
    RadioButton SexoMasc, SexoFem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPeso = findViewById(R.id.edit_text_peso);
        editAlt = findViewById(R.id.edit_text_altura);
        resultadoIMC = findViewById(R.id.textViewResultado);
        SexoMasc = findViewById(R.id.rdnMasc);
        SexoFem = findViewById(R.id.rdnFem);
    }

    public void Calcula(View view) {
        double pesoKG = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAlt.getText().toString());

        double imc = pesoKG / (Math.pow(altura, 2));
        resultadoIMC.setText(Double.valueOf(imc).toString());

        if (SexoMasc.isChecked() == true && SexoFem.isChecked() == false)  {
            if(imc < 20){
                resultadoIMC.setText("Seu imc é:"+ imc +", Abaixo do normal");
            } else if(imc >= 20 && imc <= 24.9) {
                resultadoIMC.setText("Seu imc é:"+ imc + ", Normal");
            } else if(imc >= 25 && imc <= 29.9){
                resultadoIMC.setText("Seu imc é:"+ imc +", Obesidade leve");
            } else if(imc >= 30 && imc <= 39.9) {
                resultadoIMC.setText("Seu imc é:"+ imc +", Obesidade moderada");
            } else if(imc >= 40) {
                resultadoIMC.setText("Seu imc é:"+ imc + ", Obesidade mórbida");
            }
        } else if (SexoMasc.isChecked() == false && SexoFem.isChecked() == true){
            if(imc < 19){
                resultadoIMC.setText("Seu imc é:"+ imc +", Abaixo do normal");
            } else if(imc >= 19 && imc <= 23.9) {
                resultadoIMC.setText("Seu imc é:"+ imc + ", Normal");
            } else if(imc >= 24 && imc <= 28.9){
                resultadoIMC.setText("Seu imc é:"+ imc +", Obesidade leve");
            } else if(imc >= 29 && imc <= 38.9) {
                resultadoIMC.setText("Seu imc é:"+ imc +", Obesidade moderada");
            } else if(imc >= 39) {
                resultadoIMC.setText("Seu imc é:"+ imc + ", Obesidade mórbida");
            }
        }

    }
}
