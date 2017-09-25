package com.android.curso.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        TextView textView1 = (TextView) findViewById(R.id.textView);
        String cita = null;
        String nombre = getIntent().getStringExtra("nombre");
        String fecha = getIntent().getStringExtra("fecha");
        String hora = getIntent().getStringExtra("hora");
        textView1.setText("Nombre: " + nombre + "\n" + "Fecha: " + fecha + "\n" + "Hora: " + hora);
    }
}
