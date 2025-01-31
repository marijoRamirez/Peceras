package com.example.peceras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityCalculadora extends AppCompatActivity {

    EditText txtCal1, txtCal2, txtCal3;
    Button btnCalcular;
    Button btnRegresar;
    TextView txtResultado, txtTipoPecera;
    String tipoPecera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        // Inicializa todos los elementos del layout
        txtCal1 = findViewById(R.id.txtCal1);
        txtCal2 = findViewById(R.id.txtCal2);
        txtCal3 = findViewById(R.id.txtCal3);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnRegresar = findViewById(R.id.btnRegresar);
        txtResultado = findViewById(R.id.txtResultado);
        txtTipoPecera = findViewById(R.id.txtTipoPecera);

        tipoPecera = getIntent().getStringExtra("tipoPecera");
        txtTipoPecera.setText("Tipo de Pecera: " + tipoPecera);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularVolumen();
            }
        });

        btnRegresar.setOnClickListener(view -> {
            Intent abrirVistaAnterior = new Intent(ActivityCalculadora.this, MainActivity.class);
            startActivity(abrirVistaAnterior);
        });

        configurarCampos();
    }

    private void configurarCampos() {
        switch (tipoPecera) {
            case "Rectangular":
            case "Cuadrado":
                txtCal1.setHint("Largo");
                txtCal2.setHint("Ancho");
                txtCal3.setHint("Alto");
                txtCal3.setVisibility(View.VISIBLE);
                txtCal2.setVisibility(View.VISIBLE);
                break;
            case "Cilindrico":
                txtCal1.setHint("Altura");
                txtCal2.setHint("Radio");
                txtCal3.setVisibility(View.GONE);
                txtCal2.setVisibility(View.VISIBLE);
                break;
            case "Esferico":
                txtCal1.setHint("Radio");
                txtCal2.setVisibility(View.GONE);
                txtCal3.setVisibility(View.GONE);
                break;
            case "Triangular":
                txtCal1.setHint("Alto");
                txtCal2.setHint("Ancho");
                txtCal3.setHint("Largo");
                txtCal3.setVisibility(View.VISIBLE);
                txtCal2.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void calcularVolumen() {
        double valor1 = txtCal1.getText().toString().isEmpty() ? 0 : Double.parseDouble(txtCal1.getText().toString());
        double valor2 = txtCal2.getText().toString().isEmpty() ? 0 : Double.parseDouble(txtCal2.getText().toString());
        double valor3 = txtCal3.getText().toString().isEmpty() ? 0 : Double.parseDouble(txtCal3.getText().toString());
        double resultado = 0;

        switch (tipoPecera) {
            case "Rectangular":
            case "Cuadrado":
                resultado = valor1 * valor2 * valor3;
                break;
            case "Cilindrico":
                resultado = Math.PI * Math.pow(valor2, 2) * valor1;
                break;
            case "Esferico":
                resultado = (4.0 / 3.0) * Math.PI * Math.pow(valor1, 3);
                break;
            case "Triangular":
                resultado = (valor1 * valor2 * valor3) / 2;
                break;
        }

        txtResultado.setText(String.valueOf(resultado));
    }
}