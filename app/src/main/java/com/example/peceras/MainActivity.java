package com.example.peceras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button btnSiguiente;
    private String tipoPecera = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioSelect);
        btnSiguiente = findViewById(R.id.btnSig);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    tipoPecera = selectedRadioButton.getText().toString();

                    Intent intent = new Intent(MainActivity.this, ActivityCalculadora.class);
                    intent.putExtra("tipoPecera", tipoPecera);
                    startActivity(intent);
                }
            }
        });
    }
}
